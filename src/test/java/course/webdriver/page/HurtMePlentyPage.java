package course.webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HurtMePlentyPage extends InitNewDriver {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriverWait wait = new WebDriverWait(driver, 40);

    private static final String LOCATION_XPATH = "//*[@id='select_container_108']//*[@class='md-text ng-binding' and contains(text(),'%s')]";
    private static final String SSD_XPATH = "//div[@id='select_container_413']//div[@class='md-text ng-binding' and contains(text(),'%s')]";
    private static final String COMMITED_USAGE_XPATH = "//*[@id='select_container_115']//div[@class='md-text' and contains(text(),'%s')]";
    private static final String GRU_NUMBER_XPATH = "//*[@id='select_container_453']//div[@class='md-text ng-binding' and contains(text(),'%s')]";
    private static final String GRU_TYPE_XPATH = "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding' and contains(text(),'%s')]";
    private static final String INSTANCE_TYPE_XPATH = "//div[@class='md-text ng-binding' and contains(text(),'%s')]";
    private static final String MACHINE_CLASS_XPATH = "//*[@id='select_container_92']//div[@class='md-text' and contains(text(),'%s')]";
    private static final String SOFTWARE_XPATH = "//div[@class='md-text' and contains(text(),'%s')]";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    @FindBy(xpath = "//a[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement clickOnFirstResult;

    @FindBy(xpath = "//div[@class='name ng-binding' and text()='Compute Engine']")
    private WebElement clickOnComputeEngine;

    @FindBy(xpath = "//*[@id='input_74']")
    private WebElement inputNumberOfInstances;

    @FindBy(xpath = "//div[@class='md-text']")
    private WebElement clickOnSoftwareOptions;

    @FindBy(xpath = "//*[@class='md-input-has-placeholder flex md-input-has-value']")
    private WebElement clickOnMachineClass;

    @FindBy(xpath = "//*[@id='select_99']")
    private WebElement clickOnSeries;

    @FindBy(xpath = "//*[@id='select_101']")
    private WebElement clickOnMachineType;

    @FindBy(xpath = "//div[@class='md-label' and contains(text(),'Add GPUs.')]")
    private WebElement clickOnGPUs;

    @FindBy(xpath = "//div[@class='md-label' and contains(text(),'Add Sustained Use Discounts.')]")
    private WebElement clickOnSUD;

    @FindBy(xpath = "//*[@aria-label='GPU type']")
    private WebElement clickToChoseGPUsType;

    @FindBy(xpath = "//*[@id='select_value_label_449']")
    private WebElement entryGRUsNumber;

    @FindBy(xpath = "//*[@id='select_value_label_411']")
    private WebElement clickOnLocalSSD;

    @FindBy(xpath = "//*[@id='select_value_label_72']")
    private WebElement clickOnDatacenterLocation;

    @FindBy(xpath = "//*[@id='select_114']")
    private WebElement clickOnCommitedUsage;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);' and contains(text(),'Add to Estimate')]")
    private WebElement clickOnButton;

    /*
    calculator
     */

    @FindBy(xpath = "//*[@class='md-list-item-text ng-binding' and contains(text(),'VM class')]")
    private WebElement machineClassValue;

    @FindBy(xpath = "//*[@class='md-1-line md-no-proxy']//*[@class='md-list-item-text ng-binding cpc-cart-multiline flex' and contains(text(),'Instance type: n1-standard-8')]")
    private WebElement machineTypeValue;

    @FindBy(xpath = "//*[@class='md-list-item-text ng-binding cpc-cart-multiline flex' and contains(text(),'Local SSD')]")
    private WebElement localSSDValue;

    @FindBy(xpath = "//*[@class='md-list-item-text ng-binding' and contains(text(),'Region')]")
    private WebElement datacenterLocationValue;

    @FindBy(xpath = "//*[@class='md-list-item-text ng-binding' and contains(text(),'Commitment term')]")
    private WebElement commitedUsageValue;

    @FindBy(xpath = "//b[@class='ng-binding' and contains(text(),'Total Estimated Cost')]")
    private WebElement totalCostValue;


    public HurtMePlentyPage(WebDriver driver) {
        super(driver);
    }

    public HurtMePlentyPage openPage() {
        driver.get(HOMEPAGE_URL);
        waitForPageLoad();
        return this;
    }

    public HurtMePlentyPage inputSearchText(String text) {
        wait.until(ExpectedConditions.visibilityOf(search));
        search.sendKeys(text, Keys.ENTER);

        return this;
    }

    public HurtMePlentyPage searchElement() {
        waitForPageLoad();
        wait.until(ExpectedConditions.visibilityOf(clickOnFirstResult));
        clickOnFirstResult.click();

        return this;
    }

    public HurtMePlentyPage newFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");

        System.out.println("frame is switched");

        return this;
    }

    public HurtMePlentyPage clickOnComputeEngine() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnComputeEngine)).click();

        return this;
    }

    public HurtMePlentyPage inputNumberOfInstances(String number) {
        wait.until(ExpectedConditions.visibilityOf(inputNumberOfInstances)).click();
        inputNumberOfInstances.sendKeys(number);

        return this;
    }

    public HurtMePlentyPage choseSoftware(String software) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSoftwareOptions)).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='md-text' and contains(text(), 'Paid: Ubuntu Pro')]"))));
        WebElement choseSoftwareOptions = driver.findElement(By.xpath("//div[@class='md-text' and contains(text(), 'Paid: Ubuntu Pro')]"));
        choseSoftwareOptions.click();

        wait.until(ExpectedConditions.elementToBeClickable(clickOnSoftwareOptions)).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(SOFTWARE_XPATH, software)))));
        WebElement choseSoftwareOptions1 = driver.findElement(By.xpath(String.format(SOFTWARE_XPATH, software)));
        ((JavascriptExecutor) driver).executeScript("scroll(267, 472)");
        choseSoftwareOptions1.click();

        System.out.println(choseSoftwareOptions1.getText());

        return this;
    }

    public HurtMePlentyPage choseMachineClass(String machineClass) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnMachineClass)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(MACHINE_CLASS_XPATH, machineClass)))));
        WebElement choseClass = driver.findElement(By.xpath(String.format(MACHINE_CLASS_XPATH, machineClass)));
        choseClass.click();

        System.out.println(choseClass.getText());
        return this;
    }

    public HurtMePlentyPage choseSetOfInstanceType(String seriesOfInstanceType) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSeries)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(INSTANCE_TYPE_XPATH, seriesOfInstanceType)))));
        WebElement choseSet = driver.findElement(By.xpath(String.format(INSTANCE_TYPE_XPATH, seriesOfInstanceType)));

        choseSet.click();

        System.out.println(choseSet.getText());
        return this;
    }

    public HurtMePlentyPage choseInstanceType(String instanceType) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnMachineType)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(INSTANCE_TYPE_XPATH, instanceType)))));
        WebElement choseType = driver.findElement(By.xpath(String.format(INSTANCE_TYPE_XPATH, instanceType)));
        choseType.click();

        System.out.println(choseType.getText());
        return this;
    }

    public HurtMePlentyPage choseGPUButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSUD)).click();
        wait.until(ExpectedConditions.elementToBeClickable(clickOnGPUs)).click();

        return this;
    }

    public HurtMePlentyPage choseGRUsType(String inputGRUsType) {

        wait.until(ExpectedConditions.elementToBeClickable(clickToChoseGPUsType)).click();
        wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(GRU_TYPE_XPATH, inputGRUsType)))));
        WebElement GPUsType = driver.findElement(
                By.xpath(String.format(GRU_TYPE_XPATH, inputGRUsType)));
        GPUsType.click();

        System.out.println(GPUsType.getText());

        return this;
    }

    public HurtMePlentyPage choseGRUsNumber(String GPUsNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(entryGRUsNumber)).click();

        wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(GRU_NUMBER_XPATH, GPUsNumber)))));
        WebElement clickOnGRUsNumber = driver.findElement(By.xpath(String.format(GRU_NUMBER_XPATH, GPUsNumber)));
        clickOnGRUsNumber.click();

        System.out.println(clickOnGRUsNumber.getText());

        return this;
    }

    public HurtMePlentyPage inputLocalSSD(String SSD) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnLocalSSD)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(SSD_XPATH, SSD)))));
        WebElement inputSSD = driver.findElement(By.xpath(String.format(SSD_XPATH, SSD)));
        inputSSD.click();

        System.out.println(inputSSD.getText());
        return this;

    }

    public HurtMePlentyPage choseDatacenterLocation(String location) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnDatacenterLocation)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(LOCATION_XPATH, location)))));
        WebElement choseLocation = driver.findElement(By.xpath(String.format(LOCATION_XPATH, location)));

        choseLocation.click();

        System.out.println(choseLocation.getText());

        return this;
    }

    public HurtMePlentyPage choseCommitedUsage(String usage) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnCommitedUsage)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(COMMITED_USAGE_XPATH, usage)))));
        WebElement choseUsage = driver.findElement(By.xpath(String.format(COMMITED_USAGE_XPATH, usage)));

        choseUsage.click();

        System.out.println(choseUsage.getText());

        return this;
    }

    public HurtMePlentyPage addToEstimateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnButton)).click();

        return new HurtMePlentyPage(driver);
    }

    /*
    Calculator result
     */

    public String getMachineClassValue() {
        wait.until(ExpectedConditions.visibilityOf(machineClassValue));
        return machineClassValue.getText();
    }

    public String getMachineTypeValue() {
        wait.until(ExpectedConditions.visibilityOf(machineTypeValue));
        return machineTypeValue.getText();
    }

    public String getLocalSSDValue() {
        wait.until(ExpectedConditions.visibilityOf(localSSDValue));
        return localSSDValue.getText();
    }

    public String getDatacenterLocationValue() {
        wait.until(ExpectedConditions.visibilityOf(datacenterLocationValue));
        return datacenterLocationValue.getText();
    }

    public String getCommitedUsageValue() {
        wait.until(ExpectedConditions.visibilityOf(commitedUsageValue));
        return commitedUsageValue.getText();
    }

    public String getEstimatedComponentCostValue() {
        wait.until(ExpectedConditions.visibilityOf(totalCostValue));
        return totalCostValue.getText();
    }

}
