package framework.base;

import org.openqa.selenium.support.PageFactory;

public class Base {


    public void initialise(){

        PageFactory.initElements(DriverContext.driver, this);
    }
}
