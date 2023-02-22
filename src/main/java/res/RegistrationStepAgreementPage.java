package res;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationStepAgreementPage extends RegistrationStepPage{
    private final SelenideElement cbAgreement = $x(".//*[@id='field-element-contractSigned']//*[name()='svg']");

    public RegistrationStepVerificationPage confirmAgreementStep(){
        acceptAgreement();
        clickSubmit();
        return new RegistrationStepVerificationPage();
    }

    public void acceptAgreement(){
        cbAgreement.click();
    }

    public void waitStepAgreement(){
        cbAgreement.shouldBe(Condition.visible);
    }

}
