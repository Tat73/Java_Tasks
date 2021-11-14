package course.webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ICanWinPage extends InitNewDriver {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private static final String EXPIRATION_XPATH = "//*[@id='select2-postform-expiration-results']/li[contains(text(),'%s')]";

    private WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement inputCode;

    @FindBy(xpath = "//*[@class='select2-selection select2-selection--single']/*[@id='select2-postform-expiration-container']")
    private WebElement findPasteExpiration;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement inputName;

    @FindBy(xpath = "//*[@class='btn -big' and contains(text(),'Create New Paste')]")
    private WebElement createNewPaste;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement pageTitle;


    public ICanWinPage(WebDriver driver) {
        super(driver);
    }

    public ICanWinPage openPage() {
        driver.get(HOMEPAGE_URL);
        waitForPageLoad();

        return this;
    }

    public ICanWinPage inputCode(String text) {
        wait.until(ExpectedConditions.visibilityOf(inputCode));
        inputCode.sendKeys(text);

        return this;
    }

    public ICanWinPage clickOnPasteExpiration() {
        wait.ignoring(ElementClickInterceptedException.class).until(ExpectedConditions.elementToBeClickable(findPasteExpiration));
        ((JavascriptExecutor) driver).executeScript("scroll(296, 476)");
        findPasteExpiration.click();

        return this;
    }

    public ICanWinPage chosePasteExpiration(String expiration) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(EXPIRATION_XPATH, expiration)))));

        WebElement choseExpiration = driver.findElement(By.xpath(String.format(EXPIRATION_XPATH, expiration)));
        choseExpiration.click();

        return this;
    }

    public ICanWinPage inputName(String name) {
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys(name);

        return this;
    }

    public ICanWinPage createNewPaste() {
        wait.ignoring(ElementClickInterceptedException.class).until(ExpectedConditions.elementToBeClickable(createNewPaste));
        createNewPaste.submit();

        return new ICanWinPage(driver);
    }

    public String getTitlePage() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));

        return pageTitle.getText();
    }


}
