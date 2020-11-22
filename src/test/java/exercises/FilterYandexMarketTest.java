package exercises;

import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Класс программы- тест.
 * Проверяет фильтрацию Яндекс-Маркета.
 *
 **/

public class FilterYandexMarketTest extends  AbstractBaseTest {

    @Test
    public void equalsPositionYandexMarket() throws InterruptedException {
        driver.get(YANDEX_MARKET_PAGE);
        assertionSteps.assertCorrectTitleYandexMarketPage();
        actionSteps.inputDataSearchForm();
        //пропущен шаг в тест-кейсе  - нажатие кнопки "Найти"
        actionSteps.clickSearchButton();
        //пропущен шаг в тест-кейсе - выбор кликабельной подкатегории Пылесосы в бытовой технике
        actionSteps.chooseSubcategoryVacuumCleaner();
        assertionSteps.assertCorrectTitleFilteredList();
        actionSteps.clickAllFiltersButton();
        //На этом шаге неверный ожидаемый рез-т. Написан в формате шага.
        //для соответствия с настоящим тест-кейсом  - следующий шаг закомментирован
        actionSteps.inputManufactorVitek();
        actionSteps.checkFoundManufacturerCheckbox();
        actionSteps.clearManufactorForm();
        actionSteps.inputManufactorPolaris();
        actionSteps.checkFoundManufacturerCheckbox();
        actionSteps.inputMaxPrice();
        assertionSteps.assertShowFilteredVariantsBth();
        actionSteps.clickShowFilteredVariantsBtn();
        assertionSteps.assertCorrectTitleFilteredList();
        //среди шагов тест-кейса упущен шаг с нажатием чекбокса "В продаже"
        actionSteps.checkInStockCheckbox();
        assertionSteps.equalsFilteredMaxPrice();
        assertionSteps.equalsChosenManufactorVitek();
        assertionSteps.equalsChosenManufactorPolaris();
    }
}
