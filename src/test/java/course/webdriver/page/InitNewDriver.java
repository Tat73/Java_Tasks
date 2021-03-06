package course.webdriver.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class InitNewDriver {
    protected WebDriver driver;

    public InitNewDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 40);
        wait.until(driver -> {
            System.out.println("Current Window State       : "
                    + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
            return String
                    .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                    .equals("complete");
        });
    }


}
