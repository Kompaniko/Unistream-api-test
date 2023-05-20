package manager;

import constaints.UrlAndEndPoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;

/**
 * Класс ApiManagerAssignmentOne предоставляет методы для работы с информационным API
 * и решения задачи 1.
 *
 * <p> Задача 1: Узнать с помощью инфо API сумму комиссии при
 * отправке безадресного перевода из банка "10400" в Армению на сумму 1000 RUB.</p>
 */

public class ApiManagerAssignmentOne extends UrlAndEndPoints {

    /**
     * Вычисляет сумму комиссии для безадресного перевода и выполняет проверки.
     *
     * @param senderBankId  идентификатор отправляющего банка
     * @param countryCode   код страны
     * @param amount        сумма перевода
     */
    public void CommissionAmount(int senderBankId, String countryCode, int amount) {

        // Формирование тела запроса
        String requestBody = "{\n" +
                "  \"senderBankId\": " + senderBankId + ",\n" +
                "  \"recipientBankId\": null,\n" +
                "  \"countryCode\": \"" + countryCode + "\",\n" +
                "  \"acceptedCurrency\": \"RUB\",\n" +
                "  \"withdrawCurrency\": \"RUB\",\n" +
                "  \"amount\": " + amount + ",\n" +
                "  \"operationType\": \"Transfer\",\n" +
                "  \"amountType\": null,\n" +
                "  \"feeCurrency\": null,\n" +
                "  \"values\": null\n" +
                "}";

        // Отправление POST-запроса для расчета комиссии
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(POST_CALCULATE_COMMISION);

        // Проверяем успешность выполнения запроса
        assertEquals(200, response.getStatusCode());

        // Извлекаем сумму комиссии из ответа
        double commissionAmount = response.jsonPath().getDouble("fees[0].acceptedTotalFee");
        String name = response.jsonPath().getString("fees[0].name");


        // Вывод фактической суммы комиссии
        System.out.println(name);
        System.out.println("Сумма комиссии: " + commissionAmount);

        // Проверка, что фактическая сумма комиссии больше нуля
        assertEquals(true, commissionAmount > 0);
    }
}