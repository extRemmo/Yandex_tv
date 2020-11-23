package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Fi;


public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    MarketPageSteps marketPageSteps = new MarketPageSteps();
    FiltersPageSteps filtersPageSteps = new FiltersPageSteps();
    TVsPageSteps tVsPageSteps = new TVsPageSteps();

    @When("^выбран раздел \"(.+)\"$")
    public void GoToMarket(String menuName){
        mainPageSteps.GoToMarket(menuName);
    }

    @Then("^заголовок страницы \"(.+)\"$")
    public void checkTitleMarketPage(String title){
        marketPageSteps.checkPageTitle(title);
    }

    @When("^выбрано меню \"(.+)\"$")
    public void ElectronicMenu(String menuName){
        marketPageSteps.ElectronicMenu(menuName);
    }

    @Then("^заголовок подменю \"(.+)\"$")
    public void checkTitleElectronicPage(String title){
        marketPageSteps.checkTitleElectronicMenu(title);
    }

    @When("^выбрано подменю \"(.+)\"$")
    public void TVMenu(String menuName){
        marketPageSteps.TVMenu(menuName);
    }

    @When("^кликнуто по кнопке \"(.+)\"$")
    public void AllFilters(String menuName){
        marketPageSteps.AllFilters(menuName);
    }

    @Then("^название страницы \"(.+)\"$")
    public void checkTitleFiltersPage(String title){
        filtersPageSteps.checkTitleFiltersPage(title);
    }
    @When("^установлен фильтр цены \"(.+)\" and \"(.+)\"$")
    public void priceFilter(String menuName, String price){
        filtersPageSteps.priceFilter(menuName, price);
    }
    @When("^выбран производитель \"(.+)\"$")
    public void Manufacturer(String menuName){
        filtersPageSteps.Manufacturer(menuName);
    }

    @Then("^нажата кнопка \"(.+)\"$")
    public void ShowResult(String menuName){
        filtersPageSteps.ShowResult(menuName);
    }

    @When("^нажата кнопка Показывать по \"(.+)\"$")
    public void setCountOfElement(int count){
        tVsPageSteps.setCountOfElement(count);
    }

    @Then("^позиций на странице \"(.+)\"$")
    public void isCorrectCountOfTV(int rows){
        tVsPageSteps.isCorrectCountOfTV(rows);
    }
}
