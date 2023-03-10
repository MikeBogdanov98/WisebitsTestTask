import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

abstract public class BaseTest {
    private final String browserType = System.getenv("BROWSER_TYPE");

    //Чтобы выбрать браузер отличный от Хрома, нужно в Конфигурации к рану проставить переменную BROWSER_TYPE=firefox/edge
    public void setUpBrowser(){
        switch (browserType == null ? "" : browserType){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                Configuration.browser = "firefox";
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                Configuration.browser = "edge";
                break;
            default:
                WebDriverManager.chromedriver().setup();
                Configuration.browser = "chrome";
        }
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1080x720";
        //Configuration.timeout = 20000;

        //Configuration.headless = true;
    }

    @BeforeEach
    public void initBrowser(){
        setUpBrowser();
    }

    @AfterEach
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
