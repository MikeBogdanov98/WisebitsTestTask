import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import res.Constants;

abstract public class BaseTest {
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1080x720";
        Configuration.timeout = 20000;
        //Configuration.headless = true;
    }

    @BeforeEach
    public void initBrowser(){
        setUpBrowser();
    }

    @AfterEach
    public void closeBrowser(){
        //Selenide.closeWebDriver();
    }
}
