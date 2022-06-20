package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static framework.base.DriverContext.driver;


//Registration Page Objects
public class RegistrationPage {
    private By CREATE_ACCOUNT_FORM_TITLE = By.xpath("//h1[@class='a-spacing-small']");
    private By FORM_YOUR_NAME_FIELD = By.id("ap_customer_name");
    private By FORM_MOBILE_OR_EMAIL_FIELD = By.id("ap_email");
    private By FORM_PASSWORD_FIELD = By.id("ap_password");
    private By FORM_REENTER_PASSWORD_FIELD = By.id("ap_password_check");
    private By FORM_VERIFY_EMAIL_BTN = By.id("continue");




    //Page Object methods
        public String getPageTitle(){
            driver.getTitle();
            return driver.getTitle();
        }

        public String getCreate_Account_Form_Title (){
            String Title_Text = new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(CREATE_ACCOUNT_FORM_TITLE)).getText();
            return Title_Text;
        }
        public void setForm_Your_Name_Field(String name){
            driver.findElement(FORM_YOUR_NAME_FIELD).sendKeys(name);
        }
        public void setForm_Mobile_Or_Email_Field(String email){
            driver.findElement(FORM_MOBILE_OR_EMAIL_FIELD).sendKeys(email);
        }
        public void setForm_Password_Field(String password1){
            driver.findElement(FORM_PASSWORD_FIELD).sendKeys(password1);
        }
        public void setForm_ReEnter_Password_Field(String password2){
        driver.findElement(FORM_REENTER_PASSWORD_FIELD).sendKeys(password2);
        }
        public void setFORM_VERIFY_EMAIL_BTN(){
            driver.findElement(FORM_VERIFY_EMAIL_BTN).click();
        }



}
