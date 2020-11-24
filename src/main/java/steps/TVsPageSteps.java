package steps;

import PageObjects.TVsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TVsPageSteps {

    String positionName;

    @Step("нажата кнопка Показывать по {0}")
    public void setCountOfElement(int count){
        new TVsPage().setCountOfElement(count);
    }

    @Step("позиций на странице {0}")
    public void isCorrectCountOfTV(int count){
        new TVsPage().isCorrectCountOfTV(count);
    }

    @Step("взят {0}-й элемент в списке")
    public String takePositionName(int count){
        return positionName = new TVsPage().takePositionName(count);
    }

    @Step("данный элемент введен в поисковую строку")
    public void fillField(String positionName){
        new TVsPage().fillField(positionName);
    }

    @Step("наименование товара соответствует запомненному значению")
    public void checkPosition(String positionName){
        new TVsPage().checkPosition(positionName);
    }
}
