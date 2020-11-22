package exercises;

import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Класс программы- тест.
 * Проверяет переход на Яндекс-Маркет с поисковой страницы GOOGLE.
 *
 **/

public class FollowYandexMarketPageTest extends AbstractBaseTest {

    @Test
    public void goToYandexMarketPage() {
        driver.get(GOOGLE_START_PAGE);
        actionSteps.findYandexMarketPage();
        assertionSteps.assertCorrectFirstLink();
        actionSteps.goYandexMarket();
        assertionSteps.assertCorrectTitleYandexMarketPage();
    }

}
