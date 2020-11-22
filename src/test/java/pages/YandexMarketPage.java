package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author u.frolova
 *
 * Класс программы.
 * Описывает элементы Яндекс-Маркета.
 *
 **/

public class YandexMarketPage extends BasePage{


    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    //Форма для поиска
    @FindBy (css = "#header-search")
    private WebElement searchForm;
    //кнопка Найти
    @FindBy (xpath = "//div[text()='Найти']/..")
    private WebElement searchBtn;
    //кнопка подкатегории Пылесосы
    @FindBy (xpath = "//div[text()='Пылесосы']")
    private WebElement subcategoryVacuumCleaner;
    //Кнопка Все фильтры
    @FindBy (xpath = "//div[@data-zone-name='all-filters-button']//a")
    private WebElement allFiltersBtn;
    //Поле для ввода производителей
    @FindBy(xpath = "//div[@data-filter-id='7893318']//input[@class='_34OG20yGDA']")
    private WebElement inputFormManufacturer;
    //Чекбокс с найденным производителем
    @FindBy(xpath = "//div[@data-filter-id='7893318']//label")
    public WebElement foundManufacturerCheckbox;
    //поле цены правая граница (до)
    @FindBy(xpath = "//div[@data-prefix='до']/input")
    private WebElement formMaxPrice;
    //Кнопка показать отфильтрованные предложения
    @FindBy(xpath = "//a[contains(text(),'предложений')]")
    private WebElement showFilteredVariantsBtn;
    //чекбокс в продаже
    @FindBy(xpath = "//input[@name='В продаже']/..")
    private WebElement inStockCheckbox;
    //отфильтрованное значение максимальной суммы
    @FindBy(xpath = "//input[@name='Цена до']")
    private WebElement filteredMaxPrice;
    //все чекбоксы производителя
    @FindBy(xpath = "//fieldset[@data-autotest-id = '7893318']//input")
    private List<WebElement> manufactorCheckboxes;

    //ввести требуемое значение в поисковую форму
    public void inputDataSearchForm(String searchData){
        searchForm.sendKeys(searchData);
    }
    //нажать на кнопку Найти
    public void clickSearchButton(){
        searchBtn.click();
    }
    //нажать на подкатегорию Пылесосы
    public void clickSubcategoryVacuumCleaner(){
        subcategoryVacuumCleaner.click();
    }
    //нажать на кнопку все фильтры
    public void clickAllFiltersButton(){
        allFiltersBtn.click();
    }
    //ввести производителя
    public void inputManufactorForm(String manufactor){
       inputFormManufacturer.sendKeys(manufactor);
    }
    //очистить форму для ввода производителей
    public void clearManufactorForm(){
        inputFormManufacturer.clear();
    }
    //выбрать чекбокс с найденным производителем
    public void checkFoundManufacturerCheckbox(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                foundManufacturerCheckbox);
        foundManufacturerCheckbox.click();
    }
    //ввести максимальное значение суммы
    public void inputMaxPrice(String price){
        formMaxPrice.sendKeys(price);
    }
    //проверить, что кнопка Показать предложения отображается
    public boolean checkShowFilteredVariantsBtnIsDisplayed(){
        return showFilteredVariantsBtn.isDisplayed();
    }
    //нажать на кнопку Показать предложения
    public void clickShowFilteredVariantsBtn(){
        showFilteredVariantsBtn.click();
    }
    //кликнуть чекбокс в продаже
    public void checkInStockCheckbox(){
        inStockCheckbox.click();
    }
    //получить аттрибут значения value в отфильтрованной максимальной сумме и сравнить с максимальной суммой
    public boolean equalsFilteredMaxPrice(String price){
        String realFilteredMaxPrice = filteredMaxPrice.getAttribute("value");
        return realFilteredMaxPrice.equals(price);
    }
    //сравнить отфильтрованных производителей и выбранных ранее
    public boolean equalsChosenManufactors(String manufactor){
        for (WebElement manufactorCheckbox : manufactorCheckboxes) {
            if (manufactorCheckbox.getAttribute("name").contains(manufactor)){
                return true;
            }
        }return false;
    }
}

