package course.webdriver.tests;

import course.webdriver.page.BringItOnPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BringItOnPageTest {

    private WebDriver driver;
    private BringItOnPage bringItOnPage;
    private static final String TEXT_FOR_SYNTAX = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    @BeforeClass(description = "Open browser")

    public void openNewBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        bringItOnPage = new BringItOnPage(driver);
        bringItOnPage.openPage()
                .inputCode(TEXT_FOR_SYNTAX)
                .clickOnSyntaxHighlighting()
                .choseSyntaxHighlighting("Bash")
                .clickOnPasteExpiration()
                .chosePasteExpiration("10 Minutes")
                .inputName("how to gain dominance among developers")
                .createNewPaste();

    }

    @Test(description = "Page title", priority = 1)

    public void testPageTitle(){
        System.out.println(bringItOnPage.getTitlePage());
        Assert.assertEquals(bringItOnPage.getTitlePage(), "how to gain dominance among developers");
    }

    @Test(description = "Page title", priority = 2)

    public void testPageSyntax(){
        System.out.println(bringItOnPage.getPageSyntax());
        Assert.assertEquals(bringItOnPage.getPageSyntax(), "Bash");
    }

    @Test(description = "Page text", priority = 3)
    public void testPageText(){
        System.out.println(bringItOnPage.getPageText());
        Assert.assertEquals(bringItOnPage.getPageText(), TEXT_FOR_SYNTAX);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
