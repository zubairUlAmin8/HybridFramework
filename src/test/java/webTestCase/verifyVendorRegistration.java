package webTestCase;

import dataprovider.DataProviderManager;
import helpers.PropertiesHelpers;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Hashtable;

public class verifyVendorRegistration extends BaseTest {

    @Test (priority = 0)
    public  void clickOnBecomeAVendor() throws InterruptedException {
        String url_Address = PropertiesHelpers.getValue("URL_MAWAD");
        basePage.loadPage(driver, url_Address);
        landingPage.clickOnBecomeVendor();
    }
    @Test(priority = 1)
    public  void selectEshopPackage() throws InterruptedException {
        eshopPackages.clickOnRegisterYourEshopBtn();
    }
    @Test(priority = 2,enabled = true, dataProvider = "getSignUpDataHashTable", dataProviderClass = DataProviderManager.class)
    public  void addVendorPersonalInformation(Hashtable<String, String> data) throws InterruptedException {
        vendorRegistrationPage.addVendorPersonalInfo(data);
    }

    @Test(priority = 3, enabled = true)
    public void verifyGmailOTP() throws MessagingException, IOException, InterruptedException {
        String OTPCode = twoFactorAuthPage.getGmailInboxOTP();
        twoFactorAuthPage.authentication(OTPCode);

    }

        @Test(priority = 4,enabled = true, dataProvider = "getVendorBusinessInfoDataHashTable", dataProviderClass = DataProviderManager.class)
    public void addVendorBusinessInformation(Hashtable<String, String> data) throws MessagingException, IOException, InterruptedException {
        vendorRegistrationPage.addVendorBusinessInfo(data);

    }


}
