package Page;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;


public class HomePage {
    WebDriver driver;

    private static By buttonRubberDarkLocator = By.xpath("//nav[@id='site-menu']/ul/li[@class='category-1']");
    private static By buttonDeliveryInformationLocator = By.cssSelector("#site-menu > ul > li");
    private static By footerModeLocator = By.cssSelector("#breadcrumbs > ul > li");
    private static By buttonTermConditionLocator = By.xpath("//li[@class='page-4']");
    private static By titlePageRubberDarkLocator = By.xpath("//div[@id='box-category']/h1[@class='title']");


    public static By duckClickRubberDark(){

        $(buttonRubberDarkLocator).click();
        return titlePageRubberDarkLocator;
    }

    public static ElementsCollection duckClickDeliveryInformation() {
        String footer = "";

        for( WebElement element : $$(buttonDeliveryInformationLocator)){
            if (element.getText().equals("Delivery Information")) {
                element.click();
                break;
            }
        }
        return $$(footerModeLocator);
    }

    public  static String duckClickTermCondition() {    //WPath locators
        String footer = "";
        $(buttonTermConditionLocator).click();
        for (WebElement element :  $$(footerModeLocator)){
            footer = footer + " " + (element.getText());
        }
        return footer;
    }
}
