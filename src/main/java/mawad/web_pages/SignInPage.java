package mawad.web_pages;

import Utils.LogUtils;
import Utils.waits;
import helpers.ExcelHelpers;
import keywords.WebUI;
import mawad.objectRepo.LoginPageOR;
import models.SignInModel;
import models.VendorPersonalInfoModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import mawad.web_elements.SignInPageElements;
import org.openqa.selenium.WebElement;

import java.util.Hashtable;

public class SignInPage extends BasePage {
        SignInPageElements singInPageElements;
        WebDriver driver;
//    SingInPageElements singInPageElements = new SingInPageElements(driver);

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        singInPageElements = new SignInPageElements(driver);
    }

    ExcelHelpers excelHelpers = new ExcelHelpers();
    String expectedTitle;
    public static String testName;



    public boolean  signIn(Hashtable<String, String> data) {

        WebUI.waitForElementVisible(LoginPageOR.emailIF);
        WebUI.clearText(LoginPageOR.emailIF);
        WebUI.clearText(LoginPageOR.passwordIF);
        String email = data.get(SignInModel.getUserName());
        String password = data.get(VendorPersonalInfoModel.getPassword());
        String expectedResult= data.get(VendorPersonalInfoModel.getExpectedTitle());
        WebUI.setText(LoginPageOR.emailIF,email );
        WebUI.setText(LoginPageOR.passwordIF,password );
        WebUI.clickElement(LoginPageOR.loginBtn);

        if(expectedResult.equalsIgnoreCase("fail")){
            if(email.equalsIgnoreCase("" )|| password.equalsIgnoreCase("")){
                WebUI.waitForElementVisible(LoginPageOR.credentialRequiredAlert);
            }else {
                WebUI.waitForElementVisible(LoginPageOR.validationError);
            }
            return true;
        }else if(expectedResult.equalsIgnoreCase("pass")){
            WebUI.waitForElementVisible(By.xpath("//h1[text()=\"Dashboard\"]"));
            WebElement ele= driver.findElement(By.xpath("//h1[text()=\"Dashboard\"]"));
            WebUI.isElementDisplayed(ele);
            return true;
        }
        else {
            return false;
        }
    }




    public boolean verifyExpectedResult() {
        if (expectedTitle.equals("pass")) {
            return true;
        } else {
            return false;

        }
    }

    public void goToForgetPasswordPage() {
        waits.waitForElements(driver, singInPageElements.forgetPasswordLinkTxt, 5);
        singInPageElements.forgetPasswordLinkTxt.click();
    }

    public static String getTestName() {
        return testName;
    }

    public boolean verifyLoginPage() {
    waits.waitForElements(driver, singInPageElements.logInText, 10);
        String checkSTR = singInPageElements.logInText.getText();
        LogUtils.info("check"+checkSTR);
        if (checkSTR.equalsIgnoreCase("Sign In")) {
            return true;
        } else {
            return false;
        }
    }

}
