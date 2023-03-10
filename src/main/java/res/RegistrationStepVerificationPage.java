package res;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$$x;

public class RegistrationStepVerificationPage extends  RegistrationStepPage{
    private final ElementsCollection inputsFiles = $$x(".//input");

    public  RegistrationStepVerificationPage(){
        isNumberOfActiveStepEquals("3");
    }

    public void uploadMandatoryFiles(File srcFile){
        for (SelenideElement inputFile: inputsFiles) {
            String curName= inputFile.getAttribute("name");
            if (!"passportSecondPage".equals(curName)) {
                inputFile.uploadFile(srcFile);
            }
        }
    }

    public ConfirmationWindowRegistrationPage uploadMandatoryFilesAndConfirm(File insertFile){
        uploadMandatoryFiles(insertFile);
        clickSubmit();
        return new ConfirmationWindowRegistrationPage();
    }

}
