package mawad.web_pages;

import keywords.WebUI;
import mawad.objectRepo.EshopPackagesOR;

public class EshopPackages extends BasePage {


    public boolean clickOnRegisterYourEshopBtn() throws InterruptedException {

        WebUI.moveToElement(EshopPackagesOR.registerYourEshopBtn);
        WebUI.clickElement(EshopPackagesOR.registerYourEshopBtn);
        WebUI.clickElement(EshopPackagesOR.welcomConfirmationOKBtn);
        return true;

    }


}
