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
    String positionName;

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
    @When("^установлен фильтр цены \"(.+)\" and (.+)$")
    public void priceFilter(String menuName, String price){
        filtersPageSteps.priceFilter(menuName, price);
    }

    @When("^выбран производитель$")
    public void Manufacturer(DataTable dataTable){
        dataTable.asList(String.class).forEach(k -> filtersPageSteps.Manufacturer(k));
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

    @When("^взят \"(.+)\"-й элемент в списке")
    public void takePositionName(int count){
       positionName = tVsPageSteps.takePositionName(count);
    }

    @When("^данный элемент введен в поисковую строку")
    public void fillField(){
        tVsPageSteps.fillField(positionName);
    }

    @Then("^наименование товара соответствует запомненному значению")
    public void checkPosition(){
        tVsPageSteps.checkPosition(positionName);
    }
}
