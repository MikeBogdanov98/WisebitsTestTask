package res;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuccessRegistrationPage extends RegistrationPage{
    private final SelenideElement txPageTitle = $x(".//div[@id='wizard-page-title']");
    private final SelenideElement txEmailMessage = $x(".//strong");

    public SuccessRegistrationPage(){
        txNumberOfActiveStep.shouldNot(Condition.exist);
    }

    public void isSuccessRegistrationTitleDisplayed(){
        txPageTitle.shouldBe(Condition.visible);
    }

    public void isEmailOfSuccessRegistrationEquals(String val){
        txEmailMessage.shouldHave(Condition.exactText(val));
    }
}
