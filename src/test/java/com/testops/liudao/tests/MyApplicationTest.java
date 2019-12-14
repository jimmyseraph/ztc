package com.testops.liudao.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MyApplicationTest {
    @Test
    public void simpleTest(){
        URL url = null;
        try {

            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.example.myapplication");
        caps.setCapability("appActivity", ".MainActivity");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);

        driver.findElementById("com.example.myapplication:id/nameInput").sendKeys("testops");
        driver.findElementById("com.example.myapplication:id/spinner").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"StarCraft\").className(\"android.widget.CheckedTextView\")").click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.closeApp();
    }
}
