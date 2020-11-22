package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * @author u.frolova
 *
 * Класс программы.
 * Описывает шаги ассертов в тест-кейсах.
 *
 **/

public class AssertionSteps extends AbstractBaseStep {
    public AssertionSteps(WebDriver driver) {
        super(driver);
    }
    SoftAssert sa = new SoftAssert();

    @Step("Проверить, что первая страница в поиске ссылается на яндекс маркет")
    public void assertCorrectFirstLink() {
        Assert.assertTrue(googlePage.isLinkYandexMarket().equals(LINK_YANDEX_MARKET),
                "Первая ссылка не яндекс-маркет");
    }

    @Step("Проверить, что открылась страницы Яндекс-Маркета")
    public void assertCorrectTitleYandexMarketPage(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getTitle().contains("Яндекс.Маркет"), "Не открылась страница Яндекс-Маркета");
    }

    @Step("Проверить, что открыта страница с отфильтрованными элементами")
    public void assertCorrectTitleFilteredList(){
        Assert.assertTrue(driver.getTitle().contains("Пылесосы"),
                "Переход на страницу с отфильтрованными элементами произошел неуспешнл");
    }

    @Step("Проверить, что отображается кнопка с отфильтрованными предложениями")
    public void assertShowFilteredVariantsBth(){
        Assert.assertTrue(yandexMarketPage.checkShowFilteredVariantsBtnIsDisplayed(),
                "Кнопка с отфильтрованными предложениями не отображается");
    }

    @Step("Сравнить значение отфильтрованной максимальной сумме с введенной максимальной суммой")
    public void equalsFilteredMaxPrice(){
        Assert.assertTrue(yandexMarketPage.equalsFilteredMaxPrice(MAX_PRICE),
                "Переданное значение суммы отличается от введенной раннее");
    }

    @Step("Сравнить отфильтрованных производителя Vitek и выбранного ранее")
    public void equalsChosenManufactorVitek(){
        Assert.assertTrue(yandexMarketPage.equalsChosenManufactors(MANUFACTOR_VITEK),
                "Переданный производитель отличается от введенного раннее");
    }

    @Step("Сравнить отфильтрованных производителя Polaris и выбранного ранее")
    public void equalsChosenManufactorPolaris(){
        Assert.assertTrue(yandexMarketPage.equalsChosenManufactors(MANUFACTOR_POLARIS),
                "Переданный производитель отличается от введенного раннее");
    }
}
