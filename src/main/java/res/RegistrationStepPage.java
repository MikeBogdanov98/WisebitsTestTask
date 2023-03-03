package res;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationStepPage extends RegistrationPage{
    protected final SelenideElement btnSubmit = $x(".//button[@type='submit'][1]");

    public void clickSubmit(){
        btnSubmit.click();
    }

    public void isNumberOfActiveStepEquals(String val){
        txNumberOfActiveStep.shouldHave(Condition.exactText(val));
    }
}
