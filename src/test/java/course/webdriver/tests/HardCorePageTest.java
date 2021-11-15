package course.webdriver.tests;

import course.webdriver.page.CommonConditions;
import course.webdriver.page.Email;
import course.webdriver.page.HardCorePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class HardCorePageTest extends CommonConditions {

    @Test(description = "Open browser")
    public void openNewBrowser() {

        HardCorePage hardCorePage = new HardCorePage(driver);
        hardCorePage.openCalculatorPage()
                .inputSearchText("Google Cloud Platform Pricing Calculator")
                .searchElement()
                .newFrame()
                .clickOnComputeEngine()
                .inputNumberOfInstances("4")
                .choseSoftware("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)")
                .choseMachineClass("Regular")
                .choseSeriesOfInstanceType("N1")
                .choseInstanceType("(vCPUs: 8, RAM: 30GB)")
                .choseGRUsNumber("1")
                .choseGRUsType("NVIDIA Tesla V100")
                .inputLocalSSD("2x375 GB")
                .choseDatacenterLocation("Frankfurt (europe-west3)")
                .choseCommitedUsage("1 Year")
                .addToEstimateButton()
                .clickOnEmailButton();

        String sumFromCalculator = hardCorePage.getEstimatedComponentCostValue();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://yopmail.com/");
        hardCorePage.waitForPageLoad();

        hardCorePage
                .generateRandomEmail()
                .copyEmail();
        String newEmail = hardCorePage.getEmailString();

        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");

        System.out.println("frame 'myframe' is switched ");
        hardCorePage
                .inputEmailToCalculator();

        Email email = new Email(driver);
        email
                .openEmailPage()
                .openEmailBox(newEmail);


        Assert.assertEquals("Total Estimated Cost: " + email.getTotalCost() + " per 1 month",
                sumFromCalculator);

    }

}
