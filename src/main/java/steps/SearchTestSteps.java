package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
public class SearchTestSteps {
    WebDriver driver;

    @Given("^I set search request \"([^\"]*)\"$")
    public void iSetSearchRequest(String searchRequest){
        driver.get("http://ebay.com");
        driver.findElement(By.xpath(".//*[@id='gh-ac']")).sendKeys(searchRequest);
    }
    @When("^I perfom search$")
    public void iPerfomSearch(){
        driver.findElement(By.xpath(".//*[@id='gh-btn']")).click();
    }

    @Then("^the term query \"([^\"]*)\" should be the first in the Search Result grid$")
    public void theTermQueryShouldBeTheFirstInTheSearchResultGrid(String expectPhrase){
        String firstSnippet = driver.findElement(By.xpath(".//*[@id='ListViewInner']/li[1]")).getText();
        assertThat(firstSnippet,containsString(expectPhrase));
    }
}
