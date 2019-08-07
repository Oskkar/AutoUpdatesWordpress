package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static utility.Actions.waitForVisibilityOfElement;

public class BaseToThemes extends BasePage {

    public BaseToThemes() {
        super ();
        waitForVisibilityOfElement(pageContent);
    }

    @FindBy(id = "wpcontent")
    private WebElement pageContent;

    @FindBy(xpath = "//*[@id=\"menu-dashboard\"]/ul/li[3]/a")
    WebElement pluginsButton;

    @Step
    public UpdateThemes GoToThemes() {

        pluginsButton.click();
        return new UpdateThemes();
    }

}
