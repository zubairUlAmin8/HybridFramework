package webTestCase;

import Utils.LogUtils;
import constants.FrameworkConstants;
import driver.DriverManager;
import driver.TargetFactory;
import helpers.PropertiesHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;
import mawad.web_pages.*;

public class BaseTest {
    protected BasePage basePage = new BasePage();
     SignInPage signInPage;
     LandingPage landingPage ;
     EshopPackages eshopPackages;
     VendorRegistrationPage vendorRegistrationPage;
    TwoFactorAuthPage twoFactorAuthPage ;



    public static WebDriver driver;
    private ThreadLocal<String> testName = new ThreadLocal<>();



    void initObject() {
        signInPage = new SignInPage(driver);
        landingPage = new LandingPage(driver);
        eshopPackages = new EshopPackages();
        vendorRegistrationPage=new VendorRegistrationPage();
        twoFactorAuthPage = new TwoFactorAuthPage();

    }
    @Parameters("BROWSER")
    @BeforeSuite(groups = {"dataDrivenTestCases"})
    public  void beforeSuite_dataDrivenTestCases(@Optional("chrome") String browser) {
        if (driver == null) {
            driver = ThreadGuard.protect(new TargetFactory().createInstance(FrameworkConstants.BROWSER));
            DriverManager.setDriver(driver);
            driver.manage().window().maximize();
            LogUtils.info("Driver is Just Initialized: dataDrivenTestCases");
        } else {
            LogUtils.info("Driver is already Intialized Initialized: dataDrivenTestCases");
        }

    }
    @Parameters("BROWSER")
    @BeforeSuite(alwaysRun = true)
    public  void beforeSuite(@Optional("chrome") String browser) {
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
        if (driver != null) {
            driver=null;
            driver = ThreadGuard.protect(new TargetFactory().createInstance(FrameworkConstants.BROWSER));
            DriverManager.setDriver(driver);
            driver.manage().window().maximize();
            LogUtils.info("Driver is Just Initialized");
        } else {
            LogUtils.info("Driver was null");
            driver = ThreadGuard.protect(new TargetFactory().createInstance(FrameworkConstants.BROWSER));
            DriverManager.setDriver(driver);
            driver.manage().window().maximize();
            LogUtils.info("Driver is Just Initialized");
        }
    }
    @Parameters("BROWSER")
    @BeforeClass(alwaysRun = true)
    public void createDriver(@Optional("chrome") String browser) {
        LogUtils.error("driver value: "+driver);
        initObject();

//        BasePage.setBrowser(driver);
    }

    @AfterSuite(groups = {"dataDrivenTestCases"})
    public void closeDriver_dataDrivenTestCases() {
        DriverManager.quit();
    }
    @AfterSuite(alwaysRun = true)
    public void closeDriver() {
//        DriverManager.quit();
    }
    public WebDriver createBrowser(@Optional("chrome") String browser) {
        PropertiesHelpers.loadAllFiles();
         driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        return DriverManager.getDriver();
    }
}


