package Steps;

import Pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class FeatureSteps {
    Basepage basepage = new Basepage();
    LandingPage amazonLandingPage = new LandingPage();
    RegistrationPage amazonRegistrationPage = new RegistrationPage();
    SigninPage amazonSigninPage = new SigninPage();
    ShoppingBasket shoppingBasket = new ShoppingBasket();



    @Given("User is on the Homepage of Amazon.co.uk")
    public void userIsOnTheHomepageOfAmazonCoUk() {
        //Launch Amazon Website and get it in a ready state.
        basepage.launchBaseUrl();
        amazonLandingPage.getClick_HomePage_AcceptCookies_Btn();
    }

    @When("User completes the Create Account form")
    public void userCompletesTheCreateAccountForm(DataTable userRegDetails) throws InterruptedException {

        //Hover over the Header Menu CTA and click the displayed "New customer? Start here" link.
        amazonLandingPage.setHOVER_HEADERMENU_SIGNINACCOUNTS_BTN();
        amazonLandingPage.setCLICK_NEW_CUSTOMER_START_HERE_LINK();

        //Assert register page is opened.
        amazonRegistrationPage.getPageTitle();
        amazonRegistrationPage.getCreate_Account_Form_Title();

        //Map the DataTable text strings to the Registration form entry fields.
        List<Map<String, String>> Reg_DataTable_List = userRegDetails.asMaps(String.class, String.class);
        String name = Reg_DataTable_List.get(0).get("name");
        String email = Reg_DataTable_List.get(0).get("email");
        String password1 = Reg_DataTable_List.get(0).get("password1");
        String password2 = Reg_DataTable_List.get(0).get("password2");

        //Complete the registration form with the mapped values
        amazonRegistrationPage.setForm_Your_Name_Field(name);
        amazonRegistrationPage.setForm_Mobile_Or_Email_Field(email);
        amazonRegistrationPage.setForm_Password_Field(password1);
        amazonRegistrationPage.setForm_ReEnter_Password_Field(password2);
        Thread.sleep(5000);

    }


    @And("Clicks the Verify Email button")
    public void clicksTheVerifyEmailButton() {
        //amazonRegistrationPage.setFORM_VERIFY_EMAIL_BTN();
    }

    @When("Enters valid credentials to sign in")
    public void entersValidCredentialsToSignIn(DataTable signin_Details) {

        //Click the Header Menu Sign In CTA
        amazonSigninPage.setHOVER_HEADERMENU_SIGNINACCOUNTS_BTN();

        //Assert Sign In form is displayed
        amazonSigninPage.getPAGE_TITLE();
        amazonSigninPage.getSIGN_IN_FORM_TITLE();

        //Map the DataTable text strings to the SignIn form entry fields.
        List<Map<String, String>> credentials = signin_Details.asMaps(String.class, String.class);
        String email = credentials.get(0).get("email");
        String password = credentials.get(0).get("password");


        //Complete the Sign In form with the mapped values
        amazonSigninPage.setEMAIL_FIELD(email);
        amazonSigninPage.setCONTINUE_BTN();
        amazonSigninPage.setPASSWORD_FIELD(password);
    }

    @And("Clicks the Sign In button")
    public void clicksTheSignInButton() throws InterruptedException {
        amazonSigninPage.setSIGN_IN_SUBMIT_BTN();
        Thread.sleep(4000);
    }

    @Then("User account page is successfully opened")
    public void userAccountPageIsSuccessfullyOpened() throws InterruptedException {
        amazonSigninPage.setUSER_ACCOUNT_MENU_BTN();
        amazonSigninPage.getUSER_PAGE_Sign_Out_Link();
        Thread.sleep(4000);

    }

    @When("User Logs in with valid credentials")
    public void userLogsInWithValidCredentials(DataTable signin_Details) throws InterruptedException {
        amazonSigninPage.setHOVER_HEADERMENU_SIGNINACCOUNTS_BTN();
        List<Map<String, String>> credentials = signin_Details.asMaps(String.class, String.class);
        String email = credentials.get(0).get("email");
        String password = credentials.get(0).get("password");
        Thread.sleep(4000);


        amazonSigninPage.setEMAIL_FIELD(email);
        amazonSigninPage.setCONTINUE_BTN();
        amazonSigninPage.setPASSWORD_FIELD(password);
        amazonSigninPage.setSIGN_IN_SUBMIT_BTN();
    }

    @And("Selects an item to add to the shopping basket")
    public void selectsAnItemToAddToTheShoppingBasket(String item) throws InterruptedException {
        amazonLandingPage.setHEADER_MENU_SEARCH_BOX(item);
        amazonLandingPage.setSEARCH_SUBMIT_ICON();
        amazonLandingPage.setSEARCH_RESULT_PAGE_ITEM1();
        amazonLandingPage.getSearchResultPageTitle();
        amazonLandingPage.setADD_TO_CART_BTN();
        Thread.sleep(4000);
    }
    @And("Navigates to the checkout page")
    public void navigatesToTheCheckoutPage() throws InterruptedException {
        amazonLandingPage.setHEADERMENU_SHOPPING_BASKET_ICON();
        shoppingBasket.getSHOPPING_BASKET_SUBTOTAL_QUANTITY1();
        shoppingBasket.setPROCEED_TO_CHECKOUT_BTN();
        shoppingBasket.getCheckOutPageTitle();
        Thread.sleep(4000);

    }


    @Then("Item is successfully added and displayed")
    public void itemIsSuccessfullyAddedAndDisplayed() throws InterruptedException {
        shoppingBasket.setCHECKOUT_PAGE_ADDED_ITEM();
        Thread.sleep(4000);

    }


    @And("Deletes added item")
    public void deletesAddedItem() throws InterruptedException {
        shoppingBasket.setCHECKOUT_PAGE_CLICKABLE_HEADING();
        shoppingBasket.setCHECKOUT_PAGE_RETURN_TO_BASKET_BTN();
        shoppingBasket.setSHOPPING_BASKET_ITEMS_DELETE_LINK();
        Thread.sleep(4000);

    }


    @Then("Item is successfully removed from the shopping basket")
    public void itemIsSuccessfullyRemovedFromTheShoppingBasket() {
        shoppingBasket.getSHOPPING_BASKET_SUBTOTAL_QUANTITY2();
        //shoppingBasket.getSHOPPING_BASKET_STATUS_TEXT();
    }

    @And("Selects an {string} to add to the shopping basket")
    public void selectsAnToAddToTheShoppingBasket(String item) throws InterruptedException {
        amazonLandingPage.setHEADER_MENU_SEARCH_BOX(item);
        amazonLandingPage.setSEARCH_SUBMIT_ICON();
        amazonLandingPage.setSEARCH_RESULT_PAGE_ITEM1();
        amazonLandingPage.getSearchResultPageTitle();
        amazonLandingPage.setADD_TO_CART_BTN();
        Thread.sleep(4000);
    }


    @Then("User can add {string} item to the shopping basket")
    public void userCanAddItemToTheShoppingBasket(String another_item) {
        amazonLandingPage.setHEADER_MENU_SEARCH_BOX(another_item);
        amazonLandingPage.setSEARCH_SUBMIT_ICON();
        amazonLandingPage.setSEARCH_RESULT_PAGE_ITEM2();
        amazonLandingPage.getSearchItemPageTitle();
        amazonLandingPage.setADD_TO_CART_BTN();
        amazonLandingPage.setHEADERMENU_SHOPPING_BASKET_ICON();
        shoppingBasket.getSHOPPING_BASKET_SUBTOTAL_QUANTITY1();
    }

    @Then("A system email is sent to user account")
    public void aSystemEmailIsSentToUserAccount() {

    }
}
