package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static utility.Actions.waitForVisibilityOfElement;

public class UpdatePosts extends BasePage {

    public UpdatePosts(){
        super();
        waitForVisibilityOfElement(baseTable);
    }

    @FindBy(id = "the-list")
    private WebElement baseTable;

    @FindBy(xpath = "//*[@id=\"menu-dashboard\"]/a/div[3]")
    private WebElement KokpitButton;

    @FindBy(id = "menu-plugins")
    private WebElement pluginsButtons;

    private WebElement stepOne;
    private WebElement stepTwo;
    private WebElement StepThree;


    List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
    List <Integer> errorRows = new ArrayList<Integer>();

    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions builder = new Actions(driver);
    WebDriverWait wait;

    String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
            + "var elementTop = arguments[0].getBoundingClientRect().top;"
            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

    String helpingString;

    @Step
    public UpdatePlugins PostUpdate() {


        getAlertMessageContent();

        for (int i = 0; i < errorRows.size(); i++) {


            stepOne = baseTable.findElement(By.xpath("//*[@id=\"" + tableRows.get(errorRows.get(i)).getAttribute("id") + "\"]/td[1]/strong/a"));

            js.executeScript(scrollElementIntoMiddle , stepOne);
            builder.moveToElement(stepOne).perform();

            stepTwo = baseTable.findElement(By.xpath("//*[@id=\"" + tableRows.get(errorRows.get(i)).getAttribute("id") + "\"]/td[1]/div[3]/span[2]/button"));
            builder.moveToElement(stepTwo).click().perform();

            helpingString = tableRows.get(errorRows.get(i)).getAttribute("id");
            String str = helpingString.substring(5);

            StepThree = baseTable.findElement(By.xpath("//*[@id=\"edit-" + str + "\"]/td/div/button[2]"));
            StepThree.click();

            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"" + tableRows.get(errorRows.get(i)).getAttribute("id") + "\"]/td[1]/div[3]/span[2]/button")));


        }

        js.executeScript("window.scrollBy(0,-500)");
        pluginsButtons.click();
        return new UpdatePlugins();
    }




    private void getAlertMessageContent() {
        int help = 0;

        for(WebElement tableRow : tableRows){
            String helper = tableRow.getText();
            if (helper.contains("Przegapiono datę"))
                errorRows.add(help);

            help++;
        }

    }


}
