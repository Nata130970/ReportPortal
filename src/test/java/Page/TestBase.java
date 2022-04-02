package Page;
import com.codeborne.selenide.Configuration;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.Selenide.*;
import Helper.Browsers;

public class TestBase {

    protected static Logger logger = Logger.getLogger(TestBase.class);

    @BeforeMethod
    public void setup(){
        Browsers browserName = Browsers.valueOf(System.getProperty("browser",Browsers.CHROME.toString()));

        switch (browserName) {
            case CHROME :  Configuration.browser = "CHROME";
                break;
            case FIREFOX:  Configuration.browser =  "FIREFOX";
                break;
            default: Configuration.browser = "CHROME";;
        }

        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 20000;
 //     Configuration.remote="http://192.168.0.179:4444/wd/hub";
 //     Configuration.browser = "CHROME";
        Configuration.baseUrl = "https://litecart.stqa.ru/en/";
        open(Configuration.baseUrl);
     }

    @AfterMethod
   public void close(){
       //closeWindow();

   }

}



