package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import steps.ActionSteps;
import steps.AssertionSteps;

/**
 * @author u.frolova
 *
 * Абстрактный класс программы.
 * Инициализирует ВебДрайвер для запуска тестов, и закрывает его после выполнения.
 *
 **/

public abstract class AbstractBaseTest {
    protected WebDriver driver;
    protected ActionSteps actionSteps;
    protected AssertionSteps assertionSteps;

    protected static final String GOOGLE_START_PAGE = "https://www.google.com";
    protected static final String YANDEX_MARKET_PAGE = "https://market.yandex.ru/";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
