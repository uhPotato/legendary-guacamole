package AcceptanceTests;

import PageObjects.MoviesPage;
import PageObjects.ProfilePage;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by idorovskikh on 1/18/17.
 */
public class UserProfile extends BaseTest {
    @BeforeMethod
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

    @AfterMethod
    public void afterEachTest() {
        System.out.println("Resetting App");
        driver.resetApp();
    }

    @Test
    public void changeName() {

        MoviesPage moviesPage = new MoviesPage();
        ProfilePage profilePage = moviesPage.clickOnProfileButton();
        profilePage.clickOnEditName();



     //   MobileElement profileButton = (MobileElement) driver.findElementById("btnHamburger");
     //   profileButton.click();

      //  MobileElement nameEdit = (MobileElement) driver.findElementById("ivName");
      //  nameEdit.click();

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

    @Test
    public void changeNameWithOneChar() {
        MobileElement profileButton = (MobileElement) driver.findElementById("btnHamburger");
        profileButton.click();

        MobileElement nameEdit = (MobileElement) driver.findElementById("ivName");
        nameEdit.click();

        MobileElement nameTextField = (MobileElement) driver.findElementById("edit_text");
        String previousName = nameTextField.getText();
        MobileElement okButtonAfterNameChanging = (MobileElement) driver.findElementById("android:id/button1");
        nameTextField.clear();
        String newName = "A";
        nameTextField.sendKeys(newName);
        driver.hideKeyboard();
        okButtonAfterNameChanging.click();

        MobileElement checkTextField = (MobileElement) driver.findElementById("tvNameValue");
        Assert.assertEquals(checkTextField.getText(), previousName);
    }
<<<<<<< HEAD

    @Test
    public void changeNameWithOneChar() {
        MobileElement profileButton = (MobileElement) driver.findElementById("btnHamburger");
        profileButton.click();

        MobileElement beforecheckTextField = (MobileElement) driver.findElementById("tvNameValue");
        String beforeName=beforecheckTextField.getText();

        MobileElement nameEdit = (MobileElement) driver.findElementById("ivName");
        nameEdit.click();

        MobileElement nameTextField = (MobileElement) driver.findElementById("edit_text");
        MobileElement okButtonAfterNameChanging = (MobileElement) driver.findElementById("android:id/button1");
        nameTextField.clear();
        String newName = "Q";
        nameTextField.sendKeys(newName);
        driver.hideKeyboard();
        okButtonAfterNameChanging.click();

        MobileElement aftercheckTextField = (MobileElement) driver.findElementById("tvNameValue");
        String afterName = aftercheckTextField.getText();

        Assert.assertEquals(beforeName, afterName);
    }
=======
>>>>>>> 2977da83b42144d663dc7a4f59f1106d291fdb5e
}
