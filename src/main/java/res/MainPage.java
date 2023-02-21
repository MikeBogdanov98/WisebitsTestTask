package res;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement inUsername = $x(".//input[@name='username']");
    private final SelenideElement inEmail = $x(".//input[@name='email']");
    private final SelenideElement inPassword = $x(".//input[@name='password']");
    private final SelenideElement btnCreateAccount = $x(".//form[@id='create-account']//button");

    public MainPage(String url){
        Selenide.open(url);
    }

    public void fillInValidDataForRegistration(String name, String email, String password){
        inUsername.setValue(name);
        inEmail.setValue(email);
        inPassword.setValue(password);
    }

    public void clickOnCreateAccount(){
        btnCreateAccount.click();
    }
}
