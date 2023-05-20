package constaints;

/**
 * Класс UrlAndEndPoints содержит URL и конечные точки для API-запросов.
 */
public class UrlAndEndPoints {

    /** Базовый URL для API-запросов. */
    public static final String BASE_URL  = "https://slt-test.info.api.unistream.com";

    /** Конечная точка для расчета комиссии. */
    public static final String POST_CALCULATE_COMMISION = "/api/v1/transfer/calculate";

    /** Конечная точка для получения официального курса валюты EUR. */
    public static final String OFFICIAL_RATES_EUR = "/api/v1/poses/officialrate?currency=EUR";

    /** Конечная точка для получения официального курса валюты USD. */
    public static final String OFFICIAL_RATES_USD = "/api/v1/poses/officialrate?currency=USD";

    /** Конечная точка для получения курса валюты EUR в Юнистриме. */
    public static final String UNISTREAM_RATES_EUR = "/api/v1/poses/rate?bankId=11153&currency=EUR&toCurrency=RUB";

    /** Конечная точка для получения курса валюты USD в Юнистриме. */
    public static final String UNISTREAM_RATES_USD = "/api/v1/poses/rate?bankId=11153&currency=USD&toCurrency=RUB";

}
