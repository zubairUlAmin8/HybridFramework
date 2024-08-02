package mawad.web_pages;

import Utils.fakerUtils;
import keywords.WebUI;
import mawad.objectRepo.VendorRegistrationPageOR;
import models.VendorBusinessInfoModel;
import models.VendorPersonalInfoModel;

import java.util.Hashtable;

public class VendorRegistrationPage extends BasePage {


    public boolean addVendorPersonalInfo(Hashtable<String, String> data) throws InterruptedException {
        WebUI.setText(VendorRegistrationPageOR.firstNameIF, data.get(VendorPersonalInfoModel.getFirstName()));
        WebUI.setText(VendorRegistrationPageOR.lastNameIF, data.get(VendorPersonalInfoModel.getLastName()));
        WebUI.setText(VendorRegistrationPageOR.emailAddressIF, data.get(VendorPersonalInfoModel.getEmail())+"+"+ fakerUtils.generateRandomInt()+"@gmail.com");
        WebUI.setText(VendorRegistrationPageOR.passwordIF, data.get(VendorPersonalInfoModel.getPassword()));
        WebUI.setText(VendorRegistrationPageOR.confirmPasswordIF, data.get(VendorPersonalInfoModel.getConfirmPassword()));
        WebUI.clickElement(VendorRegistrationPageOR.nextPiBtn);
        return true;

    } public boolean addVendorBusinessInfo(Hashtable<String, String> data) throws InterruptedException {
        WebUI.setText(VendorRegistrationPageOR.englishTradeNameIF, data.get(VendorBusinessInfoModel.getEnglishTradeNameIF()));
        WebUI.setText(VendorRegistrationPageOR.arabicTradeNameIF, data.get(VendorBusinessInfoModel.getArabicTradeNameIF()));
//        WebUI.uploadFileWithSendKeys(VendorRegistrationPageOR.tradeLicenseDocIF, data.get(VendorBusinessInfoModel.getTradeLicenseDocIF()));
//        WebUI.setText(VendorRegistrationPageOR.tradeLicenseDocIF, data.get(VendorBusinessInfoModel.getTradeLicenseDocIF()));
        WebUI.setText(VendorRegistrationPageOR.englishEshopNameIF, data.get(VendorBusinessInfoModel.getArabicEshopNameIF()));
        WebUI.setText(VendorRegistrationPageOR.arabicEshopNameIF, data.get(VendorBusinessInfoModel.getArabicEshopNameIF()));
        WebUI.setText(VendorRegistrationPageOR.englishEshopDescriptionTE, data.get(VendorBusinessInfoModel.getEnglishEshopDescriptionTE()));
        WebUI.setText(VendorRegistrationPageOR.arabicEshopDescriptionTE, data.get(VendorBusinessInfoModel.getArabicEshopDescriptionTE()));
        WebUI.setText(VendorRegistrationPageOR.licenceIssueDateIF, data.get(VendorBusinessInfoModel.getLicenceIssueDateIF()));
        WebUI.setText(VendorRegistrationPageOR.licenceExpiryDateIF, data.get(VendorBusinessInfoModel.getLicenceExpiryDateIF()));

//      Location Information
        WebUI.selectOptionByIndex(VendorRegistrationPageOR.stateListIF, 2);
//        WebUI.selectListOptionByIndex(VendorRegistrationPageOR.stateListIF, 2);
        Thread.sleep(500);
        WebUI.selectOptionByIndex(VendorRegistrationPageOR.areaIF, 2);
        WebUI.setText(VendorRegistrationPageOR.streetIF, data.get(VendorBusinessInfoModel.getStreetIF()));
        WebUI.setText(VendorRegistrationPageOR.buildingIF, data.get(VendorBusinessInfoModel.getBuildingIF()));
        WebUI.setText(VendorRegistrationPageOR.unitOfficeNoIF, data.get(VendorBusinessInfoModel.getUnitOfficeNoIF()));
        WebUI.setText(VendorRegistrationPageOR.POBoxIF, data.get(VendorBusinessInfoModel.getPOBoxIF()));
        WebUI.setText(VendorRegistrationPageOR.landlinePhoneNoIF, data.get(VendorBusinessInfoModel.getLandlinePhoneNoIF()));
//        WebUI.setText(VendorRegistrationPageOR.vatCertificateFileIF, data.get(VendorBusinessInfoModel.getVatCertificateFileIF()));
        WebUI.setText(VendorRegistrationPageOR.TRNTaxRegistrationNumberIF, data.get(VendorBusinessInfoModel.getTRNTaxRegistrationNumberIF()));
//        WebUI.setText(VendorRegistrationPageOR.civilDefenseApprovalFileIF, data.get(VendorBusinessInfoModel.getCivilDefenseApprovalFileIF()));


        WebUI.clickElement(VendorRegistrationPageOR.SaveAndContinueBIBtn);
        return true;

    }


}
