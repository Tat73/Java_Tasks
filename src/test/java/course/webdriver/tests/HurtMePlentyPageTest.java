package course.webdriver.tests;


import course.webdriver.page.HurtMePlentyPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HurtMePlentyPageTest {
    private WebDriver driver;
    private HurtMePlentyPage hurtMePlentyPage;

    @BeforeClass(description = "Open browser")

    public void openNewBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        hurtMePlentyPage = new HurtMePlentyPage(driver);
        hurtMePlentyPage.openPage()
                .inputSearchText("Google Cloud Platform Pricing Calculator")
                .searchElement()
                .newFrame()
                .clickOnComputeEngine()
                .inputNumberOfInstances("4")
                .choseSoftware("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)")
                .choseMachineClass("Regular")
                .choseSetOfInstanceType("N1")
                .choseInstanceType("(vCPUs: 8, RAM: 30GB)")
                .choseGPUButton()
                .choseGRUsType("NVIDIA Tesla V100")
                .choseGRUsNumber("1")
                .inputLocalSSD("2x375 GB")
                .choseDatacenterLocation("Frankfurt")
                .choseCommitedUsage("1 Year")
                .addToEstimateButton();


    }

    @Test(description = "VMClass", priority = 1)
    public void testMachineClass() {
        System.out.println(hurtMePlentyPage.getMachineClassValue());
        Assert.assertEquals(hurtMePlentyPage.getMachineClassValue(), "VM class: regular");
    }

    @Test(description = "Instance type", priority = 2)
    public void testMachineType() {
        System.out.println(hurtMePlentyPage.getMachineTypeValue());
        Assert.assertEquals(hurtMePlentyPage.getMachineTypeValue(), "Instance type: n1-standard-8\n" +
                "Committed Use Discount applied");
    }

    @Test(description = "Region", priority = 3)
    public void testDatacenterLocation() {
        System.out.println(hurtMePlentyPage.getDatacenterLocationValue());
        Assert.assertEquals(hurtMePlentyPage.getDatacenterLocationValue(), "Region: Frankfurt");
    }

    @Test(description = "Local SSD", priority = 4)
    public void testLocalSSDValue() {
        System.out.println(hurtMePlentyPage.getLocalSSDValue());
        Assert.assertEquals(hurtMePlentyPage.getLocalSSDValue(), "Local SSD: 2x375 GiB\n" +
                "Committed Use Discount applied");

    }

    @Test(description = "Commitment term", priority = 5)
    public void testCommitedUsage() {
        System.out.println(hurtMePlentyPage.getCommitedUsageValue());
        Assert.assertEquals(hurtMePlentyPage.getCommitedUsageValue(), "Commitment term: 1 Year");
    }

    @Test(description = "Estimated Component Cost", priority = 6)
    public void testTotalCost() {
        System.out.println(hurtMePlentyPage.getEstimatedComponentCostValue());
        Assert.assertEquals(hurtMePlentyPage.getEstimatedComponentCostValue(), "Total Estimated Cost: USD 1,084.69 per 1 month");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }


}
