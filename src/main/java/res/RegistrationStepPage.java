package res;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationStepPage {
    protected final SelenideElement btnSubmit = $x(".//button[contains(@class,'go2570090340 button')]");
    protected final SelenideElement txNumberOfActiveStep = $x(".//div[contains(@class, 'item active')]/span");

    public void clickSubmit(){
        btnSubmit.click();
    }

    public String getNumberOfActiveStep(){
        return txNumberOfActiveStep.getText();
    }

}
