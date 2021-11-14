package course.webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BringItOnPage extends InitNewDriver {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private static final String EXPIRATION_XPATH = "//*[@id='select2-postform-expiration-results']/li[contains(text(),'%s')]";


    private WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(xpath = "//*[@id='postform-text']")
    private WebElement inputCode;

    @FindBy(xpath = "//*[@id='select2-postform-format-container']")
    private WebElement findSyntaxHighlighting;

    @FindBy(xpath = "//*[@class='select2-search__field']")
    private WebElement inputSyntax;

    @FindBy(xpath = "//*[@class='select2-selection select2-selection--single']/*[@id='select2-postform-expiration-container']")
    private WebElement findPasteExpiration;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement inputName;

    @FindBy(xpath = "//*[@class='btn -big' and contains(text(),'Create New Paste')]")
    private WebElement createNewPaste;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@class='textarea']")
    private WebElement pageText;

    @FindBy(xpath = "//*[@class='btn -small h_800' and contains(text(),'Bash')]")
    private WebElement checkSyntax;


    public BringItOnPage(WebDriver driver) {
        super(driver);
    }

    public BringItOnPage openPage() {
        driver.get(HOMEPAGE_URL);
        waitForPageLoad();

        return this;
    }

    public BringItOnPage inputCode(String text) {
        wait.until(ExpectedConditions.visibilityOf(inputCode));
        inputCode.sendKeys(text);

        return this;
    }

    public BringItOnPage clickOnSyntaxHighlighting() {
        wait.ignoring(ElementClickInterceptedException.class).until(ExpectedConditions.elementToBeClickable(findSyntaxHighlighting));
        ((JavascriptExecutor) driver).executeScript("scroll(296, 476)");
        findSyntaxHighlighting.click();

        return this;
    }

    public BringItOnPage choseSyntaxHighlighting(String syntax) {
        wait.until(ExpectedConditions.visibilityOf(inputSyntax));
        inputSyntax.sendKeys(syntax, Keys.ENTER);

        return this;
    }

    public BringItOnPage clickOnPasteExpiration() {
        wait.ignoring(ElementClickInterceptedException.class).until(ExpectedConditions.elementToBeClickable(findPasteExpiration));
        ((JavascriptExecutor) driver).executeScript("scroll(296, 476)");
        findPasteExpiration.click();

        return this;
    }

    public BringItOnPage chosePasteExpiration(String expiration) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(EXPIRATION_XPATH, expiration)))));

        WebElement choseExpiration = driver.findElement(By.xpath(String.format(EXPIRATION_XPATH, expiration)));
        choseExpiration.click();

        return this;
    }

    public BringItOnPage inputName(String name) {
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys(name);

        return this;
    }

    public BringItOnPage createNewPaste() {
        wait.ignoring(ElementClickInterceptedException.class).until(ExpectedConditions.elementToBeClickable(createNewPaste));
        createNewPaste.submit();

        return new BringItOnPage(driver);
    }

    public String getTitlePage() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));

        return pageTitle.getText();
    }

    public String getPageText() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));

        return pageText.getText();
    }

    public String getPageSyntax() {
        wait.until(ExpectedConditions.visibilityOf(checkSyntax));

        return checkSyntax.getText();
    }
}
