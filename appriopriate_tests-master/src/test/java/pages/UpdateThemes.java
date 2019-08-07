package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static utility.Screenshot.captureScreenshot;

public class UpdateThemes extends BasePage {


    public UpdateThemes(){
        super();
    }


    @FindBy(id = "the-list")
    private WebElement baseTable;


    @FindBy(xpath = "//*[@id=\"menu-dashboard\"]/ul/li[3]/a")
    private WebElement updatesButton;

    @FindBy(xpath = "//*[@id=\"themes-select-all\"]")
    private WebElement themesSelect;

    @FindBy(xpath = "//*[@id=\"upgrade-themes-2\"]")
    private WebElement updateThemesButton;

    Boolean isPresent, isPresent2;


    @Step
    public void goThemes() {

        updatesButton.click();

        isPresent = driver.findElements(By.xpath("//*[@id=\"themes-select-all\"]")).size() > 0;

        if (isPresent) {
            themesSelect.click();
            updateThemesButton.click();

            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        captureScreenshot();



    }






}
