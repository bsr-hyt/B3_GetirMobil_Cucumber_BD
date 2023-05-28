package com.getir.pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{

    @FindBy(xpath = "//*[@text='There is no result']")
    public AndroidElement emptyBasketText;

    @FindBy(id="")
    public AndroidElement backBtn;

    @FindBy(id="")
    public AndroidElement addBtn;

    @FindBy(id="")
    public AndroidElement total;
}
