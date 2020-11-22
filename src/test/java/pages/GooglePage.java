package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author u.frolova
 *
 * Класс программы.
 * Описывает элементы поисковой страницы GOOGLE.
 *
 **/

public class GooglePage extends BasePage {
    public GooglePage(WebDriver driver) {
        super(driver);
    }

    //форма поиска
    @FindBy (xpath = "//input[@title='Поиск']")
    private WebElement searchForm;
    //первая строка поискового результата
    @FindBy (xpath = "//ul[@role='listbox']/li[1]")
    public WebElement firstSearchResult;
    //ссылка на маркет на странице поискового результата
    @FindBy (xpath = "//div[@id='search']//a[1]")
    private WebElement linkYandexMarket;

    //ввести запрос в форму поисковой строки
    public void inputSearchForm(String searchRequest) {
        searchForm.sendKeys(searchRequest);
    }

    //Кликнуть по первому результату поиска
    public void clickFistSeachResult(){
        firstSearchResult.click();
    }

    //Получить прямую ссылку на страницу из аттрибутов
    public String isLinkYandexMarket (){
        String linkYandexMarketAttribute = linkYandexMarket.getAttribute("href");
        return linkYandexMarketAttribute;
    }

    //Кликнуть на первый результат поиска по странице
    public void clickFirstLinkSearchResult(){
        linkYandexMarket.click();
    }

}
