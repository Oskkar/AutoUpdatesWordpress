package pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utility.Actions.waitForVisibilityOfElement;

public class UpdatePlugins extends BasePage {


    public UpdatePlugins(){
        super();
        waitForVisibilityOfElement(baseTable);
    }

    @FindBy(id = "menu-dashboard")
    private WebElement kokpitButton;

    @FindBy(id = "the-list")
    private WebElement baseTable;

    @FindBy(id = "cb-select-all-1")
    private WebElement selectAllList;


    @FindBy(xpath = "//*[@id=\"cb-select-all-1\"]")
    WebElement selectAll;

    @FindBy(id = "doaction")
    WebElement pluginsUpdate;

    @FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[3]/ul/li[4]/a")
    WebElement pluginsUpdateCount;

    JavascriptExecutor js = (JavascriptExecutor) driver;




    String textHelp = "";
    String textContain = "Dostępna jest nowa wersja";
    String textContain2 = "Aktualizowanie";

    Select dropdown;


    List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));



    @Test
    public BaseToThemes PluginsRun(){

        selectAll.click();

        dropdown = new Select(driver.findElement(By.id("bulk-action-selector-top")));

        dropdown.selectByValue("update-selected");

        pluginsUpdate.click();

        textHelp = baseTable.getText();


        while (textHelp.contains(textContain) == true){
            textHelp = baseTable.getText();
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        while (textHelp.contains(textContain2) == true){
            textHelp = baseTable.getText();

            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        js.executeScript("window.scrollBy(0,-500)");
        kokpitButton.click();
        return new BaseToThemes();

        // dodac obsluge bledu aktualizacji wtyczki !!!!  (metoda do ponownego zaaktualizowania + screen)
    }
}
