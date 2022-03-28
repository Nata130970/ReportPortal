package Helper;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import java.io.*;
import java.io.FileNotFoundException;

public  class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Allure.addAttachment("png_" + result.getName(),"image",getScreenshotAsInputStream(),"png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Allure.addAttachment("html_" + result.getName(), "text", getPageSource(), "html");

        File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);

    }

    private static InputStream getScreenshotAsInputStream() throws FileNotFoundException {
        File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
        return new FileInputStream(screenshot);
    }

    private static String getPageSource() {
        return WebDriverRunner.getWebDriver().getPageSource();
    }

/*
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            makeScreenshot(result.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
  //       File screen = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
    }
    @Attachment(value = "{name}", type = "image/png", fileExtension = ".png")
    public static InputStream makeScreenshot(String name) throws FileNotFoundException {
         File screen = ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
         return new FileInputStream(screen);
    }
}
*/

}






