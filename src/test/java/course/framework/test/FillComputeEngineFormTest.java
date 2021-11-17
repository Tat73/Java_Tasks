package course.framework.test;

import course.framework.model.FormForCalculator;
import course.framework.page.Email;
import course.framework.page.FillComputeEngineForm;
import course.framework.service.FormForCalculatorCreator;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class FillComputeEngineFormTest extends CommonConditions {

    @Test
    public void openNewBrowser() {

        FormForCalculator input = FormForCalculatorCreator.withCredentialsFromProperty();

        FillComputeEngineForm fillComputeEngineForm = new FillComputeEngineForm(driver);
        fillComputeEngineForm.openCalculatorPage()
                .inputSearchText("Google Cloud Platform Pricing Calculator")
                .searchElement()
                .newFrame()
                .clickOnComputeEngine()
                .inputNumberOfInstances(input.getNumberOfInstances())
                .choseSoftware(input.getOperationSystem())
                .choseMachineClass(input.getMachineClass())
                .choseSeriesOfInstanceType(input.getInstanceSeries())
                .choseInstanceType(input.getInstanceType())
                .choseGPUButton()
//                 .choseGRUsType(input.getGPUType())
//                 .choseGRUsNumber(input.getNumberOfGPUs())
                .inputLocalSSD(input.getLocalSSD())
                .choseDatacenterLocation(input.getLocation())
                .choseCommitedUsage(input.getCommitedUsage())
                .addToEstimateButton()
                .clickOnEmailButton();

        String sumFromCalculator = fillComputeEngineForm.getEstimatedComponentCostValue();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://yopmail.com/");
        fillComputeEngineForm.waitForPageLoad();

        fillComputeEngineForm
                .generateRandomEmail()
                .copyEmail();
        String newEmail = fillComputeEngineForm.getEmailString();

        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");

        System.out.println("frame 'myframe' is switched ");
        fillComputeEngineForm
                .inputEmailToCalculator(newEmail);

        Email email = new Email(driver);
        email
                .openEmailPage()
                .openEmailBox(newEmail);

        Assert.assertEquals("Total Estimated Cost: " + email.getTotalCost() + " per 1 month",
                sumFromCalculator);

    }

}
