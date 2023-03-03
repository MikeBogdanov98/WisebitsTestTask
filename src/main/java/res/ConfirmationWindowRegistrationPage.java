package res;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class ConfirmationWindowRegistrationPage extends  RegistrationPage{
    private final SelenideElement divModalAffidavit = $("#affidavit-modal");
    private final ElementsCollection cbsAgreements = $$x(".//div[@class='affidavit']//*[name()='svg']");
    private final SelenideElement inFullLegalName = $x(".//input[@name='fullLegalName']");
    private final SelenideElement inJobTitle = $x(".//input[@name='jobTitle']");
    private final SelenideElement inCompanyLegalName = $x(".//input[@name='companyLegalName']");
    protected final SelenideElement btnSubmit = $("#affidavit-modal__ok");

    public void clickSubmit(){
        btnSubmit.click();
    }

    public ConfirmationWindowRegistrationPage(){
        divModalAffidavit.shouldBe(Condition.visible, Duration.ofSeconds(25));
    }

    public SuccessRegistrationPage fillInAndConfirmRegistrationWindow(){
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
        inFullLegalName.setValue(RandomStringUtils.randomAlphabetic(10));
        inJobTitle.setValue(RandomStringUtils.randomAlphabetic(10));
        inCompanyLegalName.setValue(RandomStringUtils.randomAlphabetic(10));
    }
}
