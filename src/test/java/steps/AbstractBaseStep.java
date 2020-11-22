package steps;

import org.openqa.selenium.WebDriver;
import pages.GooglePage;
import pages.YandexMarketPage;

/**
 * @author u.frolova
 *
 * Абстрактный класс программы.
 * Содержит контруктор связи PAGES. Необходим для работы с Allure-Reports. (вызов mvn allure:serve)
 * Также содержит константы , используемые в шагах теста.
 *
 **/

public abstract class AbstractBaseStep {

    protected WebDriver driver;

    GooglePage googlePage;
    YandexMarketPage yandexMarketPage;

    protected static final String LINK_YANDEX_MARKET = "https://market.yandex.ru/";
    protected static final String YANDEX_MARKET = "яндекс маркет";
    protected static final String VACUUM_CLEANER = "пылесосы";
    protected static final String MANUFACTOR_POLARIS = "Polaris";
    protected static final String MANUFACTOR_VITEK = "VITEK";
    protected static final String MAX_PRICE = "6000";

    protected AbstractBaseStep(WebDriver driver) {
        this.driver = driver;
        googlePage = new GooglePage (driver);
        yandexMarketPage = new YandexMarketPage(driver);
    }
}
