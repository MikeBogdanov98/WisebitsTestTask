package res;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pojo.BusinessAccount;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationStepDetailsPage extends RegistrationStepPage{
    private final SelenideElement rbBusinessAccountType
            = $x(".//div[@id='field-element-accountType']/div[contains(@class, 'business')]");
    private final SelenideElement rbSelectedBusinessAccountType
            = $x(".//div[@id='field-element-accountType']/div[contains(@class, 'business selected')]");
    private final ElementsCollection inputs = $$x(".//input");
    private final SelenideElement inProducerName = inputs.find(Condition.name("producerName"));
    private final SelenideElement inContactFirstname = inputs.find(Condition.name("contactFirstname"));
    private final SelenideElement inContactLastname = inputs.find(Condition.name("contactLastname"));
    private final SelenideElement inDirectorFirstname = inputs.find(Condition.name("directorFirstname"));
    private final SelenideElement inDirectorLastname = inputs.find(Condition.name("directorLastname"));
    private final SelenideElement inCompanyName = inputs.find(Condition.name("companyName"));
    private final SelenideElement inRegistrationNumber = inputs.find(Condition.name("registrationNumber"));
    private final SelenideElement inVatNumber = inputs.find(Condition.name("vatNumber"));
    private final SelenideElement inAddressCountryCode = inputs.find(Condition.name("addressCountryCode"));
    private final ElementsCollection liAddressCountryCode = $$x(".//input[@name='addressCountryCode']/../following-sibling::div//li");
    private final SelenideElement inAddressCity = inputs.find(Condition.name("addressCity"));
    private final SelenideElement inAddressRegion = inputs.find(Condition.name("addressRegion"));
    private final SelenideElement inAddressPostCode = inputs.find(Condition.name("addressPostCode"));
    private final SelenideElement inAddressStreet = inputs.find(Condition.name("addressStreet"));
    private final SelenideElement inCustodianOfRecordsAddress = $("#field-element-custodianOfRecordsAddress");

    public RegistrationStepDetailsPage(){
        isNumberOfActiveStepEquals("1");
    }

    public RegistrationStepAgreementPage fillInDetailsOfBusinessAccount(BusinessAccount businessAccount){
        chooseBusinessAccountType();
        fillInValidMandatoryDataForRegistration(businessAccount);
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

    public void fillInValidMandatoryDataForRegistration(BusinessAccount businessAccount){
        inProducerName.setValue(businessAccount.getProducerName());
        inContactFirstname.setValue(businessAccount.getContactFirstname());
        inContactLastname.setValue(businessAccount.getContactLastname());
        inDirectorFirstname.setValue(businessAccount.getDirectorFirstname());
        inDirectorLastname.setValue(businessAccount.getDirectorLastname());
        inCompanyName.setValue(businessAccount.getCompanyName());
        inRegistrationNumber.setValue(businessAccount.getRegistrationNumber());
        inAddressCountryCode.setValue(businessAccount.getAddressCountryCode());
        liAddressCountryCode.first().click();
        inAddressCity.setValue(businessAccount.getAddressCity());
        inAddressRegion.setValue(businessAccount.getAddressRegion());
        inAddressPostCode.setValue(businessAccount.getAddressPostCode());
        inAddressStreet.setValue(businessAccount.getAddressStreet());
        inCustodianOfRecordsAddress.setValue(businessAccount.getCustodianOfRecordsAddress());
    }

}
