package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author u.frolova
 *
 * Класс программы.
 * Описывает шаги действий в тест-кейсах.
 *
 **/

public class ActionSteps extends AbstractBaseStep {
    public ActionSteps(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Step("Найти в поиске Яндекс-Маркет")
    public void findYandexMarketPage(){
        googlePage.inputSearchForm(YANDEX_MARKET);
        wait.until(ExpectedConditions.elementToBeClickable(googlePage.firstSearchResult));
        googlePage.clickFistSeachResult();
        wait.until(ExpectedConditions.titleContains("Поиск в Google"));
    }

    @Step ("Перейти на страницу Яндекс-Маркета")
    public void goYandexMarket(){
        googlePage.clickFirstLinkSearchResult();
    }

    @Step("Ввести в форму для поиска запрос")
    public void inputDataSearchForm(){
        yandexMarketPage.inputDataSearchForm(VACUUM_CLEANER);
    }

    @Step("Нажать на кнопку Найти")
    public void clickSearchButton(){
        yandexMarketPage.clickSearchButton();
    }

    @Step("Выбрать подкатегорию Пылесосы в бытовой технике")
    public void chooseSubcategoryVacuumCleaner(){
        wait.until(ExpectedConditions.titleContains("«пылесосы» — Результаты поиска"));
        yandexMarketPage.clickSubcategoryVacuumCleaner();
    }

    @Step("Нажать на кнопку все фильтры")
    public void clickAllFiltersButton(){
        yandexMarketPage.clickAllFiltersButton();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Step("Ввести производителя Polaris в форму поиска")
    public void inputManufactorPolaris(){
        yandexMarketPage.inputManufactorForm(MANUFACTOR_POLARIS);
    }

    @Step("Ввести производителя Vitek в форму поиска")
    public void inputManufactorVitek() throws InterruptedException {
        yandexMarketPage.inputManufactorForm(MANUFACTOR_VITEK);
    }

    @Step("Очистить форму для ввода производетелей")
    public void clearManufactorForm(){
        yandexMarketPage.clearManufactorForm();
    }

    @Step("Выбрать чекбокс с найденным производителем")
    public void checkFoundManufacturerCheckbox(){
        yandexMarketPage.checkFoundManufacturerCheckbox();
    }

    @Step ("Ввести максимальную сумму в поле до")
    public void inputMaxPrice(){
        yandexMarketPage.inputMaxPrice(MAX_PRICE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("Нажать на кнопку Показать предложения")
    public void clickShowFilteredVariantsBtn(){
        yandexMarketPage.clickShowFilteredVariantsBtn();
    }

    @Step("Кликнуть чекбокс в продаже")
    public void checkInStockCheckbox(){
        yandexMarketPage.checkInStockCheckbox();
    }
}
