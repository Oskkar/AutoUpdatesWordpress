package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


import static utility.Actions.waitForVisibilityOfElement;

public class Login extends BasePage {

    public Login() {
    }

    @FindBy(id = "user_login")
    private WebElement loginInput;

    @FindBy(id = "user_pass")
    private WebElement passInput;

    @FindBy(id = "wp-submit")
    private WebElement loginButton;

    @FindBy(id = "login")
    private WebElement pageSite;

    @Step
    public BaseToPosts LoginToSite() {

        waitForVisibilityOfElement(pageSite);
        loginGo();

        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        Boolean isPresent = driver.findElements(By.id("login")).size() > 0;

        if (isPresent)
            loginGo();

        return new BaseToPosts();
    }

    public void loginGo(){

        loginInput.sendKeys("karolinas");
        passInput.sendKeys("");
        //captureScreenshot();
        loginButton.click();
    }
}