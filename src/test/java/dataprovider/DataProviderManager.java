/*
 * Copyright (c) 2022. Anh Tester
 * Automation Framework Selenium
 */

package dataprovider;


import constants.FrameworkConstants;
import helpers.ExcelHelpers;
import helpers.Helpers;
import org.testng.annotations.DataProvider;

public final class DataProviderManager {

    private DataProviderManager() {
    }


    @DataProvider(name = "getSignInDataHashTable", parallel = false)
    public static Object[][] getSignInData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn", 1, 7);
        System.out.println("getSignInData: " + data);
        return data;
    }
    @DataProvider(name = "getSignUpDataHashTable", parallel = false)
    public static Object[][] getSignUpdata() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "PersonalInfo", 1, 1);
        System.out.println("getSignInData: " + data);
        return data;
    }@DataProvider(name = "getVendorBusinessInfoDataHashTable", parallel = false)
    public static Object[][] getVendorBusinessInfo() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "VendorBusinessInfo", 1, 1);
        System.out.println("getSignInData: " + data);
        return data;
    }
}
