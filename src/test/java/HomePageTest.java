import Helper.Listener;
import Page.HomePage;
import Page.TestBase;
import com.codeborne.selenide.ElementsCollection;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


@Listeners({Listener.class})

public class HomePageTest extends TestBase {

    @Epic(value = "Duck-site")
    @Feature(value = "Check page")
    @Story(value = "Страница RubberDark")

    @Test
    public void duckClickRubberDarkTest() {
        By title;
        logger.info("Start test duckClickRubberDarkTest");
        title = HomePage.duckClickRubberDark();
        $(title).shouldHave(text("Rubber Ducks ttt"));
        logger.info("End test duckClickRubberDarkTest");
    }
    @Epic(value = "Duck-site")
    @Feature(value = "Check page")
    @Story(value = "Страница DeliveryInformation")
    @Test
    public void duckClickDeliveryInformationTest() {
        ElementsCollection footer ;
        logger.info("Start test duckClickDeliveryInformationTest");
        footer = HomePage.duckClickDeliveryInformation();
        $$(footer).get(1).shouldHave(text("Delivery Information111"));
    }
    @Epic(value = "Duck-site")
    @Feature(value = "Check page")
    @Story(value = "Страница TermCondition")
    @Test
    public void duckClickTermConditionTest() {

        String footer = "";
        logger.info("Start test duckClickTermConditionTest");
        footer = HomePage.duckClickTermCondition();
        assertTrue(footer.contains("Terms & Conditions"),"Terms & Conditions not found");
        logger.info(String.format("TextFooter: %s ",footer));
    }
}
