package com.getir.utilities;

import com.getir.step_definitions.Initialize;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class ScrollHelper {

    private AndroidDriver driver = Initialize.driver;

    public void scrollVerticalHelper(String text){ //aşağı yukarı kaydırır.
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollTextIntoView(\""+text+"\")"));

    }
    public void scrollHorizontalHelper(String text){ //yana doğru kaydırır.
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".setAsHorizontalList().scrollTextIntoView(\""+text+"\")"));
    }
}