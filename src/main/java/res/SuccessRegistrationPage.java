package res;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuccessRegistrationPage {
    private final SelenideElement txPageTitle = $x(".//div[@id='wizard-page-title']");
    private final SelenideElement txMessage = $x(".//strong");

    public boolean isSuccessRegistrationTitleDisplayed(){
        txPageTitle.shouldBe(Condition.visible);
        return txPageTitle.isDisplayed();
    }

    public String getEmailOfSuccessRegistration(){
        return txMessage.getText();
    }
}
