package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_objects.HomePage;
import page_objects.SearchResultPage;
import page_objects.ShopPage;

public class SearchTestSteps {
        WebDriver driver;
        HomePage homePage = new HomePage(driver);
        @Given("^user navigates to shop page$")
        public void navigate_to_shop_page() {
            homePage.open().startShopPage();
        }
        @And("^enters iphone12 as name of product to search$")
        public void enter_request_in_shop_page() {
            new ShopPage(driver).selectAlmatyAsCity().fillSearchInput("iphone12");
        }
        @And("^click on search button$")
        public void click_on_search_button(){
            new ShopPage(driver).searchEnteredQuery();
        }
        @Then("^all products related to our request will be displayed$")
        public void check_whether_related_result_is_displayed(){
            Assert.assertTrue(SearchResultPage.getSearchResultTitle().contains("iphone12"));
        }
}
