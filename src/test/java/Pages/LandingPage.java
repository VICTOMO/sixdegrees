package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static framework.base.DriverContext.driver;

public class LandingPage {

    //Amazon Landing Page objects
    private By CLICK_lANDINGPAGE_ACCEPTCOOKIES_BTN = By.id("sp-cc-accept");
    private By HOVER_HEADERMENU_SIGNINACCOUNTS_BTN = By.id("nav-link-accountList-nav-line-1");
    private By HEADERMENU_SHOPPING_BASKET = By.id("nav-cart");
    private By CLICK_NEW_CUSTOMER_START_HERE_LINK = By.xpath("//a[text()='Start here.']");
    private By HEADER_MENU_SEARCH_BOX = By.id("twotabsearchtextbox");
    private By SEARCH_SUBMIT_ICON = By.id("nav-search-submit-button");
    private By SEARCH_RESULT_PAGE_ITEM1 = By.xpath("//img[contains(@alt, 'Duerer Inflatable Swimming')]");
    private By SEARCH_RESULT_PAGE_ITEM2 = By.xpath("//img[contains(@alt, 'THE NORTH FACE - Horizon Mesh Cap - Lightweight, Unisex Hiking Hat')]");
    private By ADD_TO_CART_BTN = By.id("add-to-cart-button");





    //Amazon Landing Page object methods
    public String getLandingPageTitle(){
        driver.getTitle();
        return driver.getTitle();
    }
    public void getClick_HomePage_AcceptCookies_Btn(){
        WebElement Accept_Cookie_Btn = new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(CLICK_lANDINGPAGE_ACCEPTCOOKIES_BTN));
        Accept_Cookie_Btn.click();
    }
    public void setHOVER_HEADERMENU_SIGNINACCOUNTS_BTN(){
        WebElement AuthenticationBtn = driver.findElement(HOVER_HEADERMENU_SIGNINACCOUNTS_BTN);
        Actions act = new Actions(driver);
        act.moveToElement(AuthenticationBtn).perform();
    }
    public void setHEADERMENU_SHOPPING_BASKET_ICON(){
        driver.findElement(HEADERMENU_SHOPPING_BASKET).click();
    }
    public void setCLICK_NEW_CUSTOMER_START_HERE_LINK(){
        driver.findElement(CLICK_NEW_CUSTOMER_START_HERE_LINK).click();
    }
    public void setHEADER_MENU_SEARCH_BOX(String item){
        new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(HEADER_MENU_SEARCH_BOX)).sendKeys(item);
    }
    public void setSEARCH_SUBMIT_ICON(){
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(SEARCH_SUBMIT_ICON)).click();
    }
    public void setSEARCH_RESULT_PAGE_ITEM1(){
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(SEARCH_RESULT_PAGE_ITEM1)).click();
    }
    public void setSEARCH_RESULT_PAGE_ITEM2(){
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(SEARCH_RESULT_PAGE_ITEM2)).click();
    }
    public String getSearchResultPageTitle(){
        String a_itemPageTitle = driver.getTitle();
        Assert.assertTrue(a_itemPageTitle.contains("Duerer"));
        return a_itemPageTitle;
    }
    public void setADD_TO_CART_BTN(){
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(ADD_TO_CART_BTN)).click();
    }
    public String getSearchItemPageTitle(){
        String a_itemPageTitle = driver.getTitle();
        Assert.assertTrue(a_itemPageTitle.contains("THE NORTH FACE"));
        return a_itemPageTitle;
    }



}
