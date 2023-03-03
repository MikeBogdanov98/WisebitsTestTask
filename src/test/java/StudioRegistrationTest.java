import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pojo.BusinessAccount;
import pojo.User;
import res.*;
import wrappers.CommonWrapper;

import java.io.File;
import java.io.IOException;

@Execution(ExecutionMode.CONCURRENT)
public class StudioRegistrationTest extends BaseTest{
    @Test
    public void checkFullProcessOfRegistration() throws IOException {
        //Подготавливаем данные
        final String email = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
        final User user = new User(RandomStringUtils.randomAlphanumeric(10),
                email,
                RandomStringUtils.randomAlphanumeric(6));
        final File insertFile = CommonWrapper.createFile("example.pdf", 1000000);
        final BusinessAccount businessAccount = new BusinessAccount();

        //Заходим на сайт
        MainPage mainPage = new MainPage();

        //На главной заполняем поля и переходим на следующую страницу
        RegistrationStepDetailsPage registrationStepDetailsPage = mainPage.successfulRegistration(user);

        //Заполняем все поля первого этапа регистрации
        RegistrationStepAgreementPage registrationStepAgreementPage
                = registrationStepDetailsPage.fillInDetailsOfBusinessAccount(businessAccount);

        //Проверяем, что перешли на второй этап, проходим второй этап регистрации
        registrationStepAgreementPage.waitStepAgreement();
        RegistrationStepVerificationPage registrationStepVerificationPage
                = registrationStepAgreementPage.confirmAgreementStep();

        //Проверяем, что перешли на третий этап, проходим третий этап регистрации, переходим на модальное окно
        ConfirmationWindowRegistrationPage confirmationWindowRegistrationPage
                = registrationStepVerificationPage.uploadMandatoryFilesAndConfirm(insertFile);

        //Заполняем модльное окно и переходим на страницу успешной регистрации
        SuccessRegistrationPage successRegistrationPage
                = confirmationWindowRegistrationPage.fillInAndConfirmRegistrationWindow();

        //Проверяем, что успешно зарегистрировались
        successRegistrationPage.isSuccessRegistrationTitleDisplayed();
        successRegistrationPage.isEmailOfSuccessRegistrationEquals(email.toLowerCase());
    }

    //Для проверки успешности внедрения параллельного запуска
    @Test
    public void checkParallelTesting(){
        final String email = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
        final User user = new User(RandomStringUtils.randomAlphanumeric(10),
                email,
                RandomStringUtils.randomAlphanumeric(6));
        MainPage mainPage = new MainPage();
        mainPage.fillInValidDataForRegistration(user);
        mainPage.clickOnCreateAccount();
    }
}
