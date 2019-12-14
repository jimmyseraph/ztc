package com.testops.liudao.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LotteryTest {

    private AndroidDriver<AndroidElement> driver;

    @Test
    public void testOpenLottery(){
        URL url = null;
        try {

            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "LKX7N17C04003807");
        caps.setCapability(MobileCapabilityType.UDID, "LKX7N17C04003807");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "cn.gov.lottery");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.host.ui.InitActivity");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver<AndroidElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.view.View[@content-desc='超级大乐透']").click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void close(){
        driver.closeApp();
    }
}
