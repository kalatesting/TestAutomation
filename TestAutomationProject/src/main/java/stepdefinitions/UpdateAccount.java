package stepdefinitions;

import PageClasses.AccountUpdate;
import PageClasses.SignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;

import java.io.IOException;

public class UpdateAccount {
    @Given("The Sign In to the Webpage")
    public void the_sign_in_to_the_webpage() throws IOException, InterruptedException {
        SignInPage login=new SignInPage();
        login.LogintoPage();
    }
    @When("I Edit the FirstName of MyAccount")
    public void i_edit_the_first_name_of_my_account() throws IOException, InterruptedException {
        AccountUpdate modify=new AccountUpdate();
       modify.ModifyAccountInformation();
    }
    @Then("The Account should be updated successfully")
    public void the_account_should_be_updated_successfully() {
        AccountUpdate modify=new AccountUpdate();
        boolean isSuccess=modify.ModifiedSuccess();
        Assertions.assertThat(isSuccess);
    }
}
