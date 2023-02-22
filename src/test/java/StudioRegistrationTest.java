import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import res.*;
import wrappers.CommonWrapper;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
public class StudioRegistrationTest extends BaseTest{
    @Test
    public void checkFullProcessOfRegistration() throws IOException {
        //Запоминаем почту
        final String email = CommonWrapper.getRandomStringOfLettersAndDigits(10) + "@gmail.com";
        //Заходим на сайт
        MainPage mainPage = new MainPage(Constants.siteLink);

        //На главной заполняем поля и переходим на следующую страницу
        RegistrationStepDetailsPage registrationStepDetailsPage = mainPage.successfulRegistration(
                CommonWrapper.getRandomStringOfLettersAndDigits(10),
                email,
                CommonWrapper.getRandomStringOfLettersAndDigits(6));

        //Заполняем все поля первого этапа регистрации
        RegistrationStepAgreementPage registrationStepAgreementPage
                = registrationStepDetailsPage.fillInDetailsOfBusinessAccount();

        //Проверяем, что перешли на второй этап, проходим второй этап регистрации
        registrationStepAgreementPage.waitStepAgreement();
        assertEquals("1", registrationStepAgreementPage.getNumberOfActiveStep());
        RegistrationStepVerificationPage registrationStepVerificationPage
                = registrationStepAgreementPage.confirmAgreementStep();

        //Проверяем, что перешли на третий этап, проходим третий этап регистрации, переходим на модальное окно
        File insertFile = CommonWrapper.createFile("example.pdf", 1000000);
        registrationStepVerificationPage.waitStepVerification();
        assertEquals("3", registrationStepVerificationPage.getNumberOfActiveStep());
        ConfirmationWindowRegistrationPage confirmationWindowRegistrationPage
                = registrationStepVerificationPage.uploadMandatoryFilesAndConfirm(insertFile);

        //Заполняем модльное окно и переходим на страницу успешной регистрации
        SuccessRegistrationPage successRegistrationPage
                = confirmationWindowRegistrationPage.fillInAndConfirmRegistrationWindow();

        //Проверяем, что успешно зарегистрировались
        assertTrue(successRegistrationPage.isSuccessRegistrationTitleDisplayed());
        assertEquals(successRegistrationPage.getEmailOfSuccessRegistration(), email.toLowerCase());
    }

    //Для проверки успешности внедрения параллельного запуска
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
