import io.qameta.allure.*;
import io.restassured.RestAssured;
import manager.ApiManagerAssignmentOne;
import manager.ApiManagerAssignmentTwo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constaints.UrlAndEndPoints.BASE_URL;

/**
 * Класс с тестами для API Unistream.
 *
 * Отчет о тестировании Allure запускать локально через "allure serve /Users/username/Unistream-api-test/target/allure-results"
 */

@Epic("Unistream API Tests")
@Owner("Nikita Kompanits")

public class TestUnistream {

    final ApiManagerAssignmentOne apiManagerAssignmentOne = new ApiManagerAssignmentOne();

    final ApiManagerAssignmentTwo apiManagerAssignmentTwo = new ApiManagerAssignmentTwo();
    @BeforeAll
    public static void setup() {
        // Установка базового URL для всех запросов в классе
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @DisplayName("Тест проверки комиссии")
    @Description("Проверяет расчет комиссии при отправке безадресного перевода")
    public void testComissionAmount() {
       apiManagerAssignmentOne.CommissionAmount(10400,"ARM", 1000);
    }

    @Test
    @DisplayName("Тест сравнения курса евро")
    @Description("Проверка совпадения курса евро ЦБ и Юнистрима")
    public void testCompareCurrencyRatesEUR() {
        apiManagerAssignmentTwo.compareCurrencyRatesEUR();
    }

    @Test
    @DisplayName("Тест сравнения курса доллара")
    @Description("Проверка совпадения курса доллара ЦБ и Юнистрима")
    public void testCompareCurrencyRatesUSD() {
        apiManagerAssignmentTwo.compareCurrencyRatesUSD();
    }

}
