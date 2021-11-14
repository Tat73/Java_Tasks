package course.webdriver.tests;

import course.webdriver.page.ICanWinPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ICanWinPageTest {
    private WebDriver driver;
    private ICanWinPage iCanWinPage;

    @BeforeClass(description = "Open browser")

    public void openNewBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        iCanWinPage = new ICanWinPage(driver);
        iCanWinPage.openPage()
                .inputCode("Hello from WebDriver")
                .clickOnPasteExpiration()
                .chosePasteExpiration("10 Minutes")
                .inputName("helloweb")
                .createNewPaste();
    }

    @Test(description = "Page title", priority = 1)

    public void testPageTitle() {
        System.out.println(iCanWinPage.getTitlePage());
        Assert.assertEquals(iCanWinPage.getTitlePage(), "helloweb");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }

}


