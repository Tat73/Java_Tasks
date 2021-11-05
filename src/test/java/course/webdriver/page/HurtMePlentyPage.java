package course.webdriver.page;

import course.webDriver.Page.InitNewDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HurtMePlentyPage extends InitNewDriver {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriverWait wait = new WebDriverWait(driver, 40);

    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
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

    @FindBy(xpath = "//div[@class='md-label' and contains(text(),'Add Sustained Use Discounts.')]")
    private WebElement clickOnGPUs;

    @FindBy(xpath = "//div[@class='md-label' and contains(text(),'Add GPUs.')]")
    private WebElement clickOnSUD;

    @FindBy(xpath = "//*[@id='select_value_label_449']")
    private WebElement entryGRUsNumber;

    @FindBy(xpath = "//*[@class='md-input-has-placeholder md-input-has-value flex']")
    private WebElement clickToChoseGPUsType;

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
        WebElement choseSoftwareOptions = driver.findElement(By.xpath("//div[@class='md-text' and contains(text(), 'Paid: Ubuntu Pro')]"));
        choseSoftwareOptions.click();
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSoftwareOptions)).click();

        WebElement choseSoftwareOptions1 = driver.findElement(By.xpath("//div[@class='md-text' and contains(text(), '" +
                software + "')]"));


        choseSoftwareOptions1.click();

        System.out.println(choseSoftwareOptions1.getText());

        return this;
    }

    public HurtMePlentyPage choseMachineClass(String machineClass) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnMachineClass)).click();
        WebElement choseClass = driver
                .findElement(By.xpath("//*[@id='select_container_92']//div[@class='md-text' and contains(text(), '" +
                        machineClass + "')]"));
        choseClass.click();

        System.out.println(choseClass.getText());
        return this;
    }

    public HurtMePlentyPage choseSeriesOfInstanceType(String SeriesOfInstanceType) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSeries)).click();
        WebElement choseSeries = driver.findElement(By.xpath("//div[@class='md-text ng-binding' and contains(text(), '" +
                SeriesOfInstanceType + "')]"));

        choseSeries.click();

        System.out.println(choseSeries.getText());
        return this;
    }

    public HurtMePlentyPage choseInstanceType(String instanceType) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnMachineType)).click();
        WebElement choseType = driver.findElement(By.xpath("//div[@class='md-text ng-binding' and contains(text(), '" +
                instanceType + "')]"));
        choseType.click();

        System.out.println(choseType.getText());
        return this;
    }

    public HurtMePlentyPage choseGRUs(String GPUsNumber, String inputGRUsType) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSUD)).click();

        wait.until(ExpectedConditions.elementToBeClickable(clickOnGPUs)).click();

        wait.until(ExpectedConditions.elementToBeClickable(entryGRUsNumber)).click();
        WebElement clickOnGRUsNumber = driver.findElement(
                By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding' and contains(text(),'" +
                        GPUsNumber + "')]"));
        clickOnGRUsNumber.click();

        wait.until(ExpectedConditions.elementToBeClickable(clickToChoseGPUsType)).click();
        WebElement GPUsType = driver.findElement(
                By.xpath("//*[@class='ng-scope md-ink-ripple']//div[@class='md-text ng-binding' and contains(text(),'" +
                inputGRUsType + "')]"));

        GPUsType.click();

        System.out.println(GPUsType.getText());


        return this;
    }

    public HurtMePlentyPage inputLocalSSD(String SSD){
        wait.until(ExpectedConditions.elementToBeClickable(clickOnLocalSSD)).click();
        WebElement inputSSD = driver.findElement(
                By.xpath("//div[@id='select_container_413']//div[@class='md-text ng-binding' and contains(text(),'" + SSD + "')]"));

        inputSSD.click();

        System.out.println(inputSSD.getText());
        return this;

    }

    public HurtMePlentyPage choseDatacenterLocation(String location){
        wait.until(ExpectedConditions.elementToBeClickable(clickOnDatacenterLocation)).click();
        WebElement choseLocation = driver.findElement(
                By.xpath("//*[@id='select_container_108']//*[@class='md-text ng-binding' and contains(text(),'" +
                        location + "')]"));

        choseLocation.click();

        System.out.println(choseLocation.getText());

        return this;
    }

    public HurtMePlentyPage choseCommitedUsage(String usage){
        wait.until(ExpectedConditions.elementToBeClickable(clickOnCommitedUsage)).click();
        WebElement choseUsage = driver.findElement(
                By.xpath("//*[@id='select_container_115']//div[@class='md-text' and contains(text(),'" + usage + "')]"));

        choseUsage.click();

        System.out.println(choseUsage.getText());

        return this;
    }

    public HurtMePlentyPage addToEstimateButton(){
        wait.until(ExpectedConditions.elementToBeClickable(clickOnButton)).click();

        return new HurtMePlentyPage(driver);
    }

    /*
    Calculator result
     */

    public String getMachineClassValue(){
        wait.until(ExpectedConditions.visibilityOf(machineClassValue));
        return machineClassValue.getText();
    }
    public String getMachineTypeValue(){
        wait.until(ExpectedConditions.visibilityOf(machineTypeValue));
        return machineTypeValue.getText();
    }
    public String getLocalSSDValue(){
        wait.until(ExpectedConditions.visibilityOf(localSSDValue));
        return localSSDValue.getText();
    }
    public String getDatacenterLocationValue(){
        wait.until(ExpectedConditions.visibilityOf(datacenterLocationValue));
        return datacenterLocationValue.getText();
    }
    public String getCommitedUsageValue(){
        wait.until(ExpectedConditions.visibilityOf(commitedUsageValue));
        return commitedUsageValue.getText();
    }

    public String getEstimatedComponentCostValue(){
        wait.until(ExpectedConditions.visibilityOf(totalCostValue));
        return totalCostValue.getText();
    }

}
