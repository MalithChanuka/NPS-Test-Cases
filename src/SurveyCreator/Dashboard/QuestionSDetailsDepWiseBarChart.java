package SurveyCreator.Dashboard;

import org.openqa.selenium.By;

import app.common.EnvSurveyCreator;

public class QuestionSDetailsDepWiseBarChart {
    
    public static EnvSurveyCreator objEnvS = new EnvSurveyCreator();

    public static void downloadBarChart() throws InterruptedException {

        boolean downloadChart = false;

        Thread.sleep(1000);
        objEnvS.driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[1]/ul/a[1]/li/span"));
        Thread.sleep(500);
        objEnvS.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[1]/div/div/div/div[4]/div[1]")).click();
        objEnvS.driver.findElement(By.cssSelector(".apexcharts-menu-open > .exportSVG")).click();
        
        Thread.sleep(500);
        downloadChart = objEnvS.driver.findElement(By.cssSelector("#root > div.home > div.sidebar > div.center > ul > a:nth-child(2) > li")).isDisplayed();

        if (downloadChart) {
            System.out.println("\n\nChart Downloaded..!");
        } else {
            System.out.println("\n\nChart Download Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnvS.setUpDriver();
        objEnvS.signIn();
        downloadBarChart();
        objEnvS.driver.quit();
    }
}
