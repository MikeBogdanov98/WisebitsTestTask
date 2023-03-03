package res;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage{
    protected final SelenideElement txNumberOfActiveStep = $x(".//div[contains(@class, 'item active')]/span");

}
