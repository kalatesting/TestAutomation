package stepdefinitions;

import PageClasses.OrderHistory;
import PageClasses.SignInPage;
import PageClasses.TshirtsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Order {

    @Given("I Login to the Website")
    public void the_Login_to_the_website() throws IOException, InterruptedException {
        SignInPage signIn=new SignInPage();
        signIn.LogintoPage();
    }
    @When("I order the TShirt")
    public void i_order_the_TShirt() throws IOException, InterruptedException {
        TshirtsPage order=new TshirtsPage();
        order.tshirtsOrder();
    }
    @Then("I check the order history")
    public void i_check_the_order_history() throws InterruptedException, IOException {
        OrderHistory orders = new OrderHistory();
        boolean checkOrderedItem=orders.CheckOrderHistory();
        Assertions.assertThat(checkOrderedItem);
    }

}
