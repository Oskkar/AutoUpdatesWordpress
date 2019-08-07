package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static utility.Actions.waitForVisibilityOfElement;

public class BaseToPosts extends BasePage {

    public BaseToPosts() {
        super ();
        waitForVisibilityOfElement(pageContent);
    }
    @FindBy(id = "wpcontent")
    private WebElement pageContent;

    @FindBy(id = "menu-posts")
    private WebElement postButton;

    @Step
    public UpdatePosts GoToPosts() {

        postButton.click();
        return new UpdatePosts();
    }



}
