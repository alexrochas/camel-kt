package br.com.alex.camel.kt.cucumber;

import br.com.alex.camel.kt.TestConfig;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class SearchPetStepdefs extends TestConfig implements En {

  public SearchPetStepdefs() {
    Given("^a running API$", () -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });
    When("^hitting /pets$", () -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });
    Then("^return status (\\d+)$", (Integer status) -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });
  }
}
