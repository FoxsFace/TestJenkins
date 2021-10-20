import org.testng.annotations.Test;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class TestClass {
    @Test
    public void test(){
        getBrowser().maximize();
        getBrowser().quit();
    }
}
