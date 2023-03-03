package res;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pojo.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement secCreateAccount = $("#create-account");
    private final SelenideElement inUsername = $x(".//input[@name='username']");
    private final SelenideElement inEmail = $x(".//input[@name='email']");
    private final SelenideElement inPassword = $x(".//input[@name='password']");
    private final SelenideElement btnCreateAccount = $x(".//form[@id='create-account']//button");

    public MainPage(){
        Selenide.open(Constants.siteLink);
        secCreateAccount.shouldBe(Condition.visible);
    }

    public RegistrationStepDetailsPage successfulRegistration(User user){
        fillInValidDataForRegistration(user);
        clickOnCreateAccount();
        return new RegistrationStepDetailsPage();
    }

    public void fillInValidDataForRegistration(User user){
        inUsername.setValue(user.getName());
        inEmail.setValue(user.getEmail());
        inPassword.setValue(user.getPassword());
    }

    public void clickOnCreateAccount(){
        btnCreateAccount.click();
    }
}
