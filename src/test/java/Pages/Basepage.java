package Pages;

import framework.base.Base;
import framework.config.Settings;

import static framework.base.DriverContext.driver;

public class Basepage extends Base {
    public void launchBaseUrl(){

        driver.get(Settings.AmazonLiveUrl);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }
}
