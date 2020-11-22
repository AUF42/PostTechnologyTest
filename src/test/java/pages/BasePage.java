package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author u.frolova
 *
 * Абстрактный класс программы.
 * Содержит конструктор инициализации элементов.
 *
 **/

public abstract class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
}