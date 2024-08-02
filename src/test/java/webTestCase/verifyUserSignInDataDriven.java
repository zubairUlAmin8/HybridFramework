package webTestCase;

import dataprovider.DataProviderManager;
import helpers.PropertiesHelpers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class verifyUserSignInDataDriven extends BaseTest {

    @Test
    public  void goToLoginPage() throws InterruptedException {
        String url_Address = PropertiesHelpers.getValue("URL_MAWAD");
        basePage.loadPage(driver, url_Address);
        landingPage.goToVendorLoginPage();
    }

    @Test(priority = 1, enabled = true, dataProvider = "getSignInDataHashTable", dataProviderClass = DataProviderManager.class)
    public void vendorSignInDataDriven(Hashtable<String, String> data) throws InterruptedException {
        signInPage.signIn(data);
    }

}
