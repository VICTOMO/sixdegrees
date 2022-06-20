package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static framework.base.DriverContext.driver;

public class SigninPage {

    //Sign In page objects
    private By CLICK_HEADERMENU_SIGNINACCOUNTS_BTN = By.id("nav-link-accountList-nav-line-1");
    private By SIGN_IN_FORM_TITLE = By.xpath("//h1[@class='a-spacing-small']");
    private By EMAIL_FIELD = By.id("ap_email");
    private By CONTINUE_BTN = By.id("continue");
    private By PASSWORD_FIELD = By.id("ap_password");
    private By SIGN_IN_SUBMIT_BTN = By.id("signInSubmit");
    private By USER_ACCOUNT_MENU_BTN = By.id("nav-link-accountList-nav-line-1");
    private By USER_PAGE_Sign_Out_Link = By.xpath("//span[text()='Sign Out']");


    //Sign In Page Methods
    public void setHOVER_HEADERMENU_SIGNINACCOUNTS_BTN(){
        driver.findElement(CLICK_HEADERMENU_SIGNINACCOUNTS_BTN).click();
    }
    public String getPAGE_TITLE(){
        String a_Page_Title = driver.getTitle();
        String e_Page_Title = "Amazon Sign In";

        Assert.assertEquals(a_Page_Title,e_Page_Title);
        return driver.getTitle();
    }
    public String getSIGN_IN_FORM_TITLE(){
        String a_Form_Title = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(SIGN_IN_FORM_TITLE)).getText();
        String e_Form_Title = "Sign In";
        Assert.assertEquals(e_Form_Title,a_Form_Title);
        return a_Form_Title;
    }
    public void setEMAIL_FIELD(String email){
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    public void setCONTINUE_BTN(){
        driver.findElement(CONTINUE_BTN).click();
    }
    public void setPASSWORD_FIELD(String password){
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void setSIGN_IN_SUBMIT_BTN(){
        new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(SIGN_IN_SUBMIT_BTN)).click();
    }
    public void setUSER_ACCOUNT_MENU_BTN(){
        WebElement User_Account_Btn = driver.findElement(USER_ACCOUNT_MENU_BTN);
        Actions act = new Actions(driver);
        act.moveToElement(User_Account_Btn).perform();
    }
    public String getUSER_PAGE_Sign_Out_Link(){
        String a_Text = driver.findElement(USER_PAGE_Sign_Out_Link).getText();
        String e_Text = "Sign Out";
        Assert.assertEquals(a_Text, e_Text);
        return a_Text;
    }

}
