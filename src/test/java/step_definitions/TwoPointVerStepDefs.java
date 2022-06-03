package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TwoPointVerStepDefs {
    String actualNameFromUI;
    @When("the user navigates to spartan home page")
    public void the_user_navigates_to_spartan_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("the user clicks on view button for spartan with id {int}")
    public void the_user_clicks_on_view_button_for_spartan_with_id(Integer id) throws InterruptedException {
            String idLocator = "view_spartan_"+id;
            Driver.get().findElement(By.id(idLocator)).click();
            Thread.sleep(2000);
         actualNameFromUI = Driver.get().findElement(By.id("name")).getAttribute("value");
    }

    @Then("the user should see that the name of the spartan is {string}")
    public void the_user_should_see_that_the_name_of_the_spartan_is(String expectedName) {

        System.out.println("actualName = " + actualNameFromUI);
        System.out.println("expectedName = " + expectedName);

    }

    @Then("DB and UI info should match")
    public void dbAndUIInfoShouldMatch() {

        System.out.println("actualNameFromUI = " + actualNameFromUI);
        String nameFromDB = SpartanDBStepDefs.actualName;
        System.out.println("nameFromDB = " + nameFromDB);
        Assert.assertEquals(nameFromDB,actualNameFromUI);
    }
}
