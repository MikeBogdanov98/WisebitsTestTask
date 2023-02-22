package res;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$$x;

public class RegistrationStepVerificationPage extends  RegistrationStepPage{
    private final ElementsCollection inputsFiles = $$x(".//input");

    public void uploadMandatoryFiles(File srcFile){
        for (SelenideElement inputFile: inputsFiles) {
            String curName= inputFile.getAttribute("name");
            if (!"passportSecondPage".equals(curName)) {
                inputFile.uploadFile(srcFile);
            }
        }
    }

    public void waitStepVerification(){
        inputsFiles.first().shouldBe(Condition.enabled);
    }

    public ConfirmationWindowRegistrationPage uploadMandatoryFilesAndConfirm(File insertFile){
        uploadMandatoryFiles(insertFile);
        clickSubmit();
        return new ConfirmationWindowRegistrationPage();
    }

}
