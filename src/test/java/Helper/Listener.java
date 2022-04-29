package Helper;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.*;
import java.io.FileNotFoundException;

public  class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Allure.addAttachment("Screeshot",getScreenshotAsInputStream());
      }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Allure.addAttachment("Source","text",getPageSource(),"html");
        File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);

    }

    private static InputStream getScreenshotAsInputStream() throws FileNotFoundException {
        File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
        return new FileInputStream(screenshot);
    }

    private static String getPageSource() {
        return WebDriverRunner.getWebDriver().getPageSource();
    }

}






