package com.getir.step_definitions;

import com.getir.pages.BasketPage;
import com.getir.pages.LoginPage;
import com.getir.utilities.ScrollHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Getir_stepdef {

    LoginPage loginPage = new LoginPage();

    BasketPage basketPage = new BasketPage();

    @Given("The user open the getir app and enters {string} and {string}")
    public void the_user_open_the_getir_app_and_enters_and(String username, String password) {
        loginPage.login(username, password);
        loginPage.waitUntil(loginPage.categoryDondurma);
    }

    @Then("The user login successfully")
    public void the_user_login_successfully() {
        String actualText = loginPage.categoryDondurma.getText();
        String expectedText = "Dondurma";
        Assert.assertEquals(expectedText,actualText);
    }

    @Then("The user clicks basket button")
    public void the_user_clicks_basket_button() {
        loginPage.basketBtn.click();
    }

    @Then("The user verify that basket is empty and able to see {string}")
    public void the_user_verify_that_basket_is_empty_and_able_to_see(String expected) {
        Assert.assertEquals(expected,basketPage.emptyBasketText.getText());
        basketPage.backBtn.click();
    }

    @Then("The user able to see all menu list in console and verify that size is {int}")
    public void the_user_able_to_see_all_menu_list_in_console_and_verify_that_size_is(int expectedSize) {
        int actualSize = loginPage.menuList.size();
        Assert.assertEquals(expectedSize,actualSize);
    }

    @Then("The user clicks second category which is {string}")
    public void the_user_clicks_second_category_which_is(String categoryName) {
        loginPage.getCategory(categoryName);
    }

    @Then("The user adds two different items")
    public void the_user_adds_two_different_items() {
        basketPage.addBtn.click();
        basketPage.addBtn.click(); //2 tane aynı ürünü sepete atmış olduk
    }

    @Then("The user scroll down to {string}")
    public void the_user_scroll_down_to(String itemText) {
        new ScrollHelper().scrollVerticalHelper(itemText);
    }

    @Then("The user verify that {string}")
    public void the_user_verify_that(String expectedAmount) {
        String actualAmount = basketPage.total.getText();
        Assert.assertEquals(expectedAmount,actualAmount);
    }

}
