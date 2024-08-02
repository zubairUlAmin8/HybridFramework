package mawad.objectRepo;

import org.openqa.selenium.By;

public interface VendorRegistrationPageOR {
      //Personal Information
      By firstNameIF=By.cssSelector("#first_name");
      By lastNameIF=By.cssSelector("#last_name");
      By emailAddressIF=By.cssSelector("#email");
      By passwordIF=By.cssSelector("#password");
      By confirmPasswordIF=By.cssSelector("#password_confirmation");
      By nextPiBtn=By.xpath("//button[text()=\"Next\" and @data-action=\"register\"]");

      //Code Verification
      By verificationCodeIF=By.xpath("//input[@name=\"verification_code\"]");
      By verifyCodeBtn=By.xpath("//button[@id=\"verifyCodeBtn\"]");

      //Business Information
      By englishTradeNameIF=By.xpath("//input[@name=\"trade_name_english\"]");
      By arabicTradeNameIF=By.xpath("//input[@name=\"trade_name_arabic\"]");
      By tradeLicenseDocIF=By.xpath("//input[@name=\"trade_license_doc\"]");
      By englishEshopNameIF=By.xpath("//input[@name=\"eshop_name_english\"]");
      By arabicEshopNameIF=By.xpath("//input[@name=\"eshop_name_arabic\"]");
      By englishEshopDescriptionTE=By.xpath("//textarea[@name=\"eshop_desc_en\"]");
      By arabicEshopDescriptionTE=By.xpath("//textarea[@name=\"eshop_desc_ar\"]");
      By licenceIssueDateIF=By.id("license_issue_date");
      By licenceExpiryDateIF=By.xpath("//input[@name=\"license_expiry_date\"]");
      By stateListIF=By.id("emirateempire");
      By areaIF=By.id("areaempire");
      By streetIF=By.xpath("//input[@name=\"street\"]");
      By buildingIF=By.xpath("//input[@name=\"building\"]");
      By unitOfficeNoIF=By.xpath("//input[@name=\"unit\"]");
      By POBoxIF=By.xpath("//input[@name=\"po_box\"]");
      By landlinePhoneNoIF=By.xpath("//input[@name=\"landline\"]");
      By vatCertificateFileIF=By.xpath("//input[@name=\"vat_certificate\"]");
      By TRNTaxRegistrationNumberIF=By.xpath("//input[@name=\"trn\"]");
      By civilDefenseApprovalFileIF=By.xpath("//input[@name=\"civil_defense_approval\"]");
      By SaveAndContinueBIBtn=By.xpath("//*[@id=\"businessInfoForm\"]/div[2]/button[2]");

}
