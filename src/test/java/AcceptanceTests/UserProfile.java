package AcceptanceTests;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by idorovskikh on 1/18/17.
 */
public class UserProfile extends BaseTest {

    @BeforeClass
    private void successfulGoogleLoginWithValidCredential() {
        System.out.println("login");
        driver.findElement(By.id("btnGoogleLogin")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(By.id("android:id/button1")).click();

        Boolean result = elementIsNotPresent(By.id("com.android.packageinstaller:id/permission_allow_button"));
        if (!result) {
            //driver.switchTo().alert().accept(); DOES NOT WORK!!!!
            driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        }

        Assert.assertTrue(driver.findElementById("btnHamburger").isDisplayed());
    }

    @AfterClass
    public void afterEachTest() {
        System.out.println("Resetting App");
        driver.resetApp();
    }

    @Test
    public void changeName() {
        MobileElement profileButton = (MobileElement) driver.findElementById("btnHamburger");
        profileButton.click();

        MobileElement nameEdit = (MobileElement) driver.findElementById("ivName");
        nameEdit.click();

        MobileElement nameTextField = (MobileElement) driver.findElementById("edit_text");
        MobileElement okButtonAfterNameChanging = (MobileElement) driver.findElementById("android:id/button1");
        nameTextField.clear();
        String newName = "Boris";
        nameTextField.sendKeys(newName);
        driver.hideKeyboard();
        okButtonAfterNameChanging.click();

        MobileElement checkTextField = (MobileElement) driver.findElementById("tvNameValue");
        Assert.assertEquals(checkTextField.getText(), newName);
    }
}
