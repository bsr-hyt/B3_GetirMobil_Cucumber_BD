package com.getir.pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@text='username']")
    public AndroidElement usernameInput;
    @FindBy(xpath = "//*[@text='password']")
    public AndroidElement passwordInput;
    @FindBy(xpath = "//*[@text='Submit']")
    public AndroidElement submitBtn;

    @FindBy(xpath = "//*[@text='Dondurma']")
    public AndroidElement categoryDondurma;

    @FindBy(id = "")
    public AndroidElement basketBtn;

    @FindBy(className = "android.widget.TextView")
    public List<AndroidElement> menuList;

    public void login(String username,String password){
        waitUntil(usernameInput).sendKeys(username);
        passwordInput.sendKeys(password);
        waitUntil(submitBtn).click();
    }

    public AndroidElement waitUntil(AndroidElement element){
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void getCategory(String categoryName){
        driver.findElement(By.xpath("//*[@text='"+categoryName+"']")).click();

    }
}
