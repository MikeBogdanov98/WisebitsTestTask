package res;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import wrappers.CommonWrapper;

import java.io.File;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationStepsPage {
    private final SelenideElement rbBusinessAccountType
            = $x(".//div[@id='field-element-accountType']/div[contains(@class, 'business')]");
    private final SelenideElement inProducerName = $x(".//input[@name='producerName']");
    private final SelenideElement inContactFirstname = $x(".//input[@name='contactFirstname']");
    private final SelenideElement inContactLastname = $x(".//input[@name='contactLastname']");
    private final SelenideElement inDirectorFirstname = $x(".//input[@name='directorFirstname']");
    private final SelenideElement inDirectorLastname = $x(".//input[@name='directorLastname']");
    private final SelenideElement inCompanyName = $x(".//input[@name='companyName']");
    private final SelenideElement inRegistrationNumber = $x(".//input[@name='registrationNumber']");
    private final SelenideElement inAddressCountryCode = $x(".//input[@name='addressCountryCode']");
    private final ElementsCollection liAddressCountryCode = $$x(".//input[@name='addressCountryCode']/../following-sibling::div//li");
    private final SelenideElement inAddressCity = $x(".//input[@name='addressCity']");
    private final SelenideElement inAddressRegion = $x(".//input[@name='addressRegion']");
    private final SelenideElement inAddressPostCode = $x(".//input[@name='addressPostCode']");
    private final SelenideElement inAddressStreet = $x(".//input[@name='addressStreet']");
    private final SelenideElement inCustodianOfRecordsAddress = $x(".//textarea[@name='custodianOfRecordsAddress']");
    private final SelenideElement btnSubmit = $x(".//button[@type='submit']");

    private final SelenideElement txNumberOfActiveStep = $x(".//div[contains(@class, 'item active')]/span");
    private final SelenideElement cbAgreement = $x(".//*[@id='field-element-contractSigned']//*[name()='svg']");

    private final SelenideElement inPassport = $x("*//input[@name='passport']");
    private final SelenideElement inCommercialRegisterExtract = $x("*//input[@name='commercialRegisterExtract']");
    private final SelenideElement inCertificateOfIncorporation = $x("*//input[@name='certificateOfIncorporation']");

    //window
    private final ElementsCollection cbsAgreements = $$x(".//div[@class='affidavit']//*[name()='svg']");
    private final SelenideElement inFullLegalName = $x(".//input[@name='fullLegalName']");
    private final SelenideElement inJobTitle = $x(".//input[@name='jobTitle']");
    private final SelenideElement inCompanyLegalName = $x(".//input[@name='companyLegalName']");
    private final SelenideElement btnSubmit2 = $x(".//button[@type='submit'][2]");

    public void chooseBusinessAccountType(){
        rbBusinessAccountType.click();
    }

    public void fillInValidMandatoryDataForRegistration(){
        inProducerName.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inContactFirstname.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inContactLastname.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inDirectorFirstname.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inDirectorLastname.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inCompanyName.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inRegistrationNumber.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inAddressCountryCode.setValue(CommonWrapper.getRandomStringOfLetters(1));
        liAddressCountryCode.first().click();
        inAddressCity.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inAddressRegion.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inAddressPostCode.setValue(CommonWrapper.getRandomStringOfLetters(10));
        inAddressStreet.setValue(CommonWrapper.getRandomStringOfLettersAndDigits(30));
        inCustodianOfRecordsAddress.setValue(CommonWrapper.getRandomStringOfLettersAndDigits(30));
    }

    public void clickSubmit(){
        btnSubmit.click();
    }

    public void acceptAgreement(){
        cbAgreement.click();
    }

    public String getNumberOfActiveStep(){
        return txNumberOfActiveStep.getText();
    }

    public void uploadPassport(){
        inPassport.uploadFile(new File("src/test/resources/02.pdf"));
    }

    public void uploadCommercialRegisterExtract(){
        inCommercialRegisterExtract.uploadFile(new File("src/test/resources/02.pdf"));
    }

    public void uploadCertificateOfIncorporation(){
        inCertificateOfIncorporation.uploadFile(new File("src/test/resources/02.pdf"));
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


    public void clickSubmitSecond(){
        btnSubmit2.click();
    }



}
