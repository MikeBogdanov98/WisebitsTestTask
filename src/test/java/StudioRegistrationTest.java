import org.junit.Assert;
import org.junit.jupiter.api.Test;
import res.Constants;
import res.MainPage;
import res.RegistrationStepsPage;
import res.SuccessRegistrationPage;
import wrappers.CommonWrapper;

import java.util.Objects;

public class StudioRegistrationTest extends BaseTest{
    @Test
    public void checkFullProcessOfRegistration(){
        final String email = CommonWrapper.getRandomStringOfLettersAndDigits(10) + "@gmail.com";
        MainPage mainPage = new MainPage(Constants.siteLink);
        mainPage.fillInValidDataForRegistration(
                CommonWrapper.getRandomStringOfLettersAndDigits(10),
                email,
                CommonWrapper.getRandomStringOfLettersAndDigits(6));
        mainPage.clickOnCreateAccount();
        RegistrationStepsPage registrationStepsPage = new RegistrationStepsPage();
        registrationStepsPage.chooseBusinessAccountType();
        registrationStepsPage.fillInValidMandatoryDataForRegistration();
        registrationStepsPage.clickSubmit();
        registrationStepsPage.acceptAgreement();
        Assert.assertTrue(registrationStepsPage.getNumberOfActiveStep(), Objects.equals(registrationStepsPage.getNumberOfActiveStep(), "2"));
        registrationStepsPage.clickSubmit();
        registrationStepsPage.uploadPassport();
        Assert.assertTrue(registrationStepsPage.getNumberOfActiveStep(), Objects.equals(registrationStepsPage.getNumberOfActiveStep(), "3"));
        registrationStepsPage.uploadCommercialRegisterExtract();
        registrationStepsPage.uploadCertificateOfIncorporation();
        registrationStepsPage.clickSubmit();
        registrationStepsPage.fillInValidDataInModalWindow();
        registrationStepsPage.selectAllCheckboxes();
        registrationStepsPage.clickSubmitSecond();
        SuccessRegistrationPage successRegistrationPage = new SuccessRegistrationPage();
        Assert.assertTrue(successRegistrationPage.isSuccessRegistrationTitleDisplayed());
        Assert.assertTrue(successRegistrationPage.getEmailOfSuccessRegistration()+ "hohoho" + email, Objects.equals(successRegistrationPage.getEmailOfSuccessRegistration(), email.toLowerCase()));

    }
}
