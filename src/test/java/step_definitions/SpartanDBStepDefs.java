package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

public class SpartanDBStepDefs {

    String actualName;

    @When("the user retrives the name of spartan with ID {int}")
    public void the_user_retrives_the_name_of_spartan_with_ID(Integer id) {

            String query = "select name from spartans where spartan_id="+id;
            actualName = (String) DBUtils.getCellValue(query);
        System.out.println("query = " + query);
        System.out.println("actualName = " + actualName);
    }

    @Then("the name of the spartan should be {string}")
    public void the_name_of_the_spartan_should_be(String expectedName) {
        Assert.assertEquals(expectedName,actualName);
    }
}
