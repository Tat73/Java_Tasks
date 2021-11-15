package course.framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(driver -> {
            System.out.println("Current Window State       : "
                    + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
            return String
                    .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                    .equals("complete");
        });
    }
}
