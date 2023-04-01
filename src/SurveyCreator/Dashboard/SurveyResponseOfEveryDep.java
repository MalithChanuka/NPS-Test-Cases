package SurveyCreator.Dashboard;

import org.openqa.selenium.By;

import app.common.EnvSurveyCreator;

public class SurveyResponseOfEveryDep {
    
    public static EnvSurveyCreator objEnvS = new EnvSurveyCreator();

    public static void BarChart() throws InterruptedException {

        boolean downloadChart = false;

        // Thread.sleep(1000);
        // objEnvS.js.executeScript("window.scrollTo(0,0)");

        Thread.sleep(1000);
        objEnvS.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[4]/div[1]")).click();

        Thread.sleep(1000);
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
