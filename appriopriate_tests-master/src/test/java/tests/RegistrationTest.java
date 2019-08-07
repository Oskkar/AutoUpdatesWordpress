package tests;

import config.TestConfig;
import org.junit.Test;
import pages.Login;

public class RegistrationTest extends TestConfig {


    @Test
    public void test() {
        new Login()
                .LoginToSite()
                .GoToPosts()
                .PostUpdate()
                .PluginsRun()
                .GoToThemes()
                .goThemes();

    }


}
