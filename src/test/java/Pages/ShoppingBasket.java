package Pages;

import org.apache.bcel.generic.PUSH;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static framework.base.DriverContext.driver;

public class ShoppingBasket {
    private By HEADERMENU_SHOPPING_BASKET = By.id("nav-cart");
    private By SHOPPING_BASKET_SUBTOTAL_QUANTITY1 = By.id("sc-subtotal-label-activecart");
    private By PROCEED_TO_CHECKOUT_BTN = By.xpath("//input[@value='Proceed to checkout']");
    private By CHECKOUT_PAGE_ADDED_ITEM = By.xpath("//img[@src='https://images-eu.ssl-images-amazon.com/images/I/619dShjweDL._AC_AA150_.jpg']");

    private By CHECKOUT_PAGE_CLICKABLE_HEADING = By.xpath("//span[@class='a-color-link clickable-heading']");
    private By CHECKOUT_PAGE_RETURN_TO_BASKET_BTN = By.xpath("//a[@href='https://www.amazon.co.uk/gp/cart/view.html/ref=chk_cart_link_return_to_cart']");
    private By SHOPPING_BASKET_ITEMS_DELETE_LINK = By.xpath("//input[@value='Delete']");
    private By SHOPPING_BASKET_STATUS_TEXT = By.xpath("//h1[text()]");
    private By SHOPPING_BASKET_SUBTOTAL_QUANTITY2 = By.id("sc-subtotal-label-activecart");




    public String getSHOPPING_BASKET_SUBTOTAL_QUANTITY1(){
        WebElement item_quantity_box = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(SHOPPING_BASKET_SUBTOTAL_QUANTITY1));
        String quantity = item_quantity_box.getText();
        Assert.assertEquals(quantity, "Subtotal (1 item):");
        return quantity;
    }
    public void setPROCEED_TO_CHECKOUT_BTN(){
        new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(PROCEED_TO_CHECKOUT_BTN)).click();
    }
    public void getCheckOutPageTitle(){
        String checkoutPageTitle = driver.getTitle();
        Assert.assertTrue(checkoutPageTitle.contains("Checkout"));
    }
    public void setCHECKOUT_PAGE_ADDED_ITEM(){
        WebElement itemImage = driver.findElement(CHECKOUT_PAGE_ADDED_ITEM);
        boolean isTrue = itemImage.isDisplayed();
        Assert.assertTrue(isTrue);
    }

    public void setHEADERMENU_SHOPPING_BASKET(){
        String basketQnty = driver.findElement(HEADERMENU_SHOPPING_BASKET).getAttribute("aria-label");
        Assert.assertEquals(basketQnty, "0 items in shopping basket");
    }
    public void setCHECKOUT_PAGE_CLICKABLE_HEADING(){
        driver.findElement(CHECKOUT_PAGE_CLICKABLE_HEADING).click();
    }
    public void setCHECKOUT_PAGE_RETURN_TO_BASKET_BTN(){
        driver.findElement(CHECKOUT_PAGE_RETURN_TO_BASKET_BTN).click();
    }
    public void setSHOPPING_BASKET_ITEMS_DELETE_LINK(){
        driver.findElement(SHOPPING_BASKET_ITEMS_DELETE_LINK).click();
    }
    public String getSHOPPING_BASKET_STATUS_TEXT(){
        String basketStatus = driver.findElement(SHOPPING_BASKET_STATUS_TEXT).getText();
        Assert.assertEquals(basketStatus, "Your Amazon Basket is empty.");
        return basketStatus;
    }
    public String getSHOPPING_BASKET_SUBTOTAL_QUANTITY2(){
        WebElement item_quantity_box = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(SHOPPING_BASKET_SUBTOTAL_QUANTITY1));
        String quantity = item_quantity_box.getText();
        Assert.assertEquals(quantity, "Subtotal (0 items):");
        return quantity;
    }

}
