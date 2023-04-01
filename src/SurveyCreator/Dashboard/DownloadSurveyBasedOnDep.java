package SurveyCreator.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.common.EnvSurveyCreator;

public class DownloadSurveyBasedOnDep {
    
    public static EnvSurveyCreator objEnvS = new EnvSurveyCreator();

    public static void BarChart() throws InterruptedException {

        boolean downloadChart = false;

        Thread.sleep(1000);
        objEnvS.driver.findElement(By.cssSelector(".gap-3 > .w-100")).click();
        {
            WebElement dropdown = objEnvS.driver.findElement(By.cssSelector(".gap-3 > .w-100"));
            dropdown.findElement(By.xpath("//option[. = 'Channeling']")).click();
        }

        Thread.sleep(1000);
        objEnvS.driver.findElement(By.cssSelector(".gap-3 > .success-btn")).click();

        Thread.sleep(1000);
        objEnvS.driver.findElement(By.cssSelector(".apexcharts-toolbar:nth-child(4) > .apexcharts-menu-icon")).click();
        objEnvS.driver.findElement(By.cssSelector(".apexcharts-menu-open > .exportSVG")).click();
        
        Thread.sleep(500);
        downloadChart = objEnvS.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div[1]/div[2]")).isDisplayed();

        if (downloadChart) {
            System.out.println("\n\nDownloaded Bar Chart..!");
        } else {
            System.out.println("\n\nDid Not Download bar chart..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnvS.setUpDriver();
        objEnvS.signIn();
        BarChart();
        objEnvS.driver.quit();
    }
}
