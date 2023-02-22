import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import res.Constants;
import res.MainPage;
import res.RegistrationStepsPage;
import res.SuccessRegistrationPage;
import wrappers.CommonWrapper;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
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
        assertTrue(Objects.equals(registrationStepsPage.getNumberOfActiveStep(), "2"));
        //Assert.assertTrue(registrationStepsPage.getNumberOfActiveStep(), Objects.equals(registrationStepsPage.getNumberOfActiveStep(), "2"));
        registrationStepsPage.clickSubmit();
        registrationStepsPage.uploadPassport();
        assertTrue(Objects.equals(registrationStepsPage.getNumberOfActiveStep(), "3"));
        //Assert.assertTrue(registrationStepsPage.getNumberOfActiveStep(), Objects.equals(registrationStepsPage.getNumberOfActiveStep(), "3"));
        registrationStepsPage.uploadCommercialRegisterExtract();
        registrationStepsPage.uploadCertificateOfIncorporation();
        registrationStepsPage.clickSubmit();
        //add waiting
        registrationStepsPage.fillInValidDataInModalWindow();
        registrationStepsPage.selectAllCheckboxes();
        registrationStepsPage.clickSubmitSecond();
        SuccessRegistrationPage successRegistrationPage = new SuccessRegistrationPage();
        assertTrue(successRegistrationPage.isSuccessRegistrationTitleDisplayed());
        //Assert.assertTrue(successRegistrationPage.isSuccessRegistrationTitleDisplayed());
        assertTrue(Objects.equals(successRegistrationPage.getEmailOfSuccessRegistration(), email.toLowerCase()));
        //Assert.assertTrue(Objects.equals(successRegistrationPage.getEmailOfSuccessRegistration(), email.toLowerCase()));

    }

    @Test
    public void checkParallelTesting(){
        final String email = CommonWrapper.getRandomStringOfLettersAndDigits(10) + "@gmail.com";
        MainPage mainPage = new MainPage(Constants.siteLink);
        mainPage.fillInValidDataForRegistration(
                CommonWrapper.getRandomStringOfLettersAndDigits(10),
                email,
                CommonWrapper.getRandomStringOfLettersAndDigits(6));
        mainPage.clickOnCreateAccount();

    }
}
