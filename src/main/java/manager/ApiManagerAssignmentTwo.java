package manager;

import constaints.UrlAndEndPoints;

import static io.restassured.RestAssured.given;

/**
 * Класс ApiManagerAssignmentTwo предоставляет методы для работы с информационным API
 * и решения задачи 2.
 *
 * <p>Задача 2: Выяснить, какие курсы валют мы не забираем с сайта ЦБ
 * и какие курсы валют, которые забираем, не совпадают с курсом в Юнистриме.</p>
 *
 * В ходе решения было выяснено, что с сайта ЦБ забираются только USD и EUR
 *
 */
public class ApiManagerAssignmentTwo extends UrlAndEndPoints {

    /**
     * Сравниваем курсы валют EUR и выводит результаты сравнения.
     */
    public void compareCurrencyRatesEUR() {
        // Получение данных о курсах с ЦБ
        float cbRate = given()
                .when()
                .get(OFFICIAL_RATES_EUR)
                .then()
                .extract()
                .path("rate");

        // Получение данных о курсах с Юнистрима
        float unistreamSellRate = given()
                .when()
                .get(UNISTREAM_RATES_EUR)
                .then()
                .extract()
                .path("sellRate");

        float unistreamBuyRate = given()
                .when()
                .get(UNISTREAM_RATES_EUR)
                .then()
                .extract()
                .path("buyRate");

        // Сравнение курсов и вывод результатов
        if (cbRate == unistreamSellRate && cbRate == unistreamBuyRate) {
            System.out.println("Курсы валют совпадают.\n");
        } else {
            System.out.println("Курсы EUR не совпадают.");
            System.out.println("Курс EUR ЦБ: " + cbRate);
            System.out.println("Курс покупки EUR Юнистрим: " + unistreamBuyRate);
            System.out.println("Курс продажи EUR Юнистрим: " + unistreamSellRate + "\n");
        }
    }

    /**
     * Сравнивает курсы валют USD и выводит результаты сравнения.
     */

    public void compareCurrencyRatesUSD() {
        // Получение данных о курсах с ЦБ
        float cbRate = given()
                .when()
                .get(OFFICIAL_RATES_USD)
                .then()
                .extract()
                .path("rate");

        // Получение данных о курсах с Юнистрима
        float unistreamSellRate = given()
                .when()
                .get(UNISTREAM_RATES_USD)
                .then()
                .extract()
                .path("sellRate");

        float unistreamBuyRate = given()
                .when()
                .get(UNISTREAM_RATES_USD)
                .then()
                .extract()
                .path("buyRate");

        // Сравнение курсов и вывод результатов
        if (cbRate == unistreamSellRate && cbRate == unistreamBuyRate) {
            System.out.println("Курсы валют совпадают.");
        } else {
            System.out.println("Курсы USD не совпадают.");
            System.out.println("Курс USD ЦБ: " + cbRate);
            System.out.println("Курс покупки USD Юнистрим: " + unistreamBuyRate);
            System.out.println("Курс продажи USD Юнистрим: " + unistreamSellRate + "\n");
        }
    }
}

