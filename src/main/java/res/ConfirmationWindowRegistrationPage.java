package res;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import wrappers.CommonWrapper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ConfirmationWindowRegistrationPage extends  RegistrationStepPage{
    private final ElementsCollection cbsAgreements = $$x(".//div[@class='affidavit']//*[name()='svg']");
    private final SelenideElement inFullLegalName = $x(".//input[@name='fullLegalName']");
    private final SelenideElement inJobTitle = $x(".//input[@name='jobTitle']");
    private final SelenideElement inCompanyLegalName = $x(".//input[@name='companyLegalName']");

    public SuccessRegistrationPage fillInAndConfirmRegistrationWindow(){
        waitRegistrationWindow();
        selectAllCheckboxes();
        fillInValidDataInModalWindow();
        clickSubmit();
        return new SuccessRegistrationPage();
    }

    public void selectAllCheckboxes(){
        for (SelenideElement checkbox: cbsAgreements) {
            checkbox.click();
        }
    }

    public void fillInValidDataInModalWindow() {
        inFullLegalName.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inJobTitle.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inCompanyLegalName.setValue(CommonWrapper.getRandomStringOfLetters(10));
    }

    public void waitRegistrationWindow(){
        inFullLegalName.shouldBe(Condition.visible, Duration.ofSeconds(25));
    }
}
