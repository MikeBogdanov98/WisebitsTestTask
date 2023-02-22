package res;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import wrappers.CommonWrapper;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationStepDetailsPage extends RegistrationStepPage{
    private final SelenideElement rbBusinessAccountType
            = $x(".//div[@id='field-element-accountType']/div[contains(@class, 'business')]");
    private final SelenideElement rbSelectedBusinessAccountType
            = $x(".//div[@id='field-element-accountType']/div[contains(@class, 'business selected')]");
    private final ElementsCollection inputs = $$x(".//input");
    private final ElementsCollection liAddressCountryCode = $$x(".//input[@name='addressCountryCode']/../following-sibling::div//li");
    private final SelenideElement inCustodianOfRecordsAddress = $x(".//textarea[@name='custodianOfRecordsAddress']");

    public RegistrationStepAgreementPage fillInDetailsOfBusinessAccount(){
        chooseBusinessAccountType();
        fillInValidMandatoryDataForRegistration();
        clickSubmit();
        return new RegistrationStepAgreementPage();
    }

    public void chooseBusinessAccountType(){
        rbBusinessAccountType.click();
        //На Firefox падало на этом месте, не всегда нажимается (скорее нажимается, но страница не до конца подгружается и слетает выбор)
        if (!rbSelectedBusinessAccountType.exists()){
            rbBusinessAccountType.click();
        }
    }

    public void fillInValidMandatoryDataForRegistration(){
        for (SelenideElement inputElement: inputs) {
            String curName= inputElement.getAttribute("name");
            switch (curName){
                case "vatNumber":
                    break;
                case "addressCountryCode":
                    inputElement.setValue(CommonWrapper.getRandomStringOfLetters(1));
                    liAddressCountryCode.first().click();
                    break;
                case "addressStreet":
                    inputElement.setValue(CommonWrapper.getRandomStringOfLettersAndDigits(30));
                    break;
                default:
                    inputElement.setValue(CommonWrapper.getRandomStringOfLetters(10));
            }
        }
        inCustodianOfRecordsAddress.setValue(CommonWrapper.getRandomStringOfLettersAndDigits(30));
    }

}
