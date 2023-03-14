package test.dashboard;

import org.openqa.selenium.By;

import app.common.Env;

public class DownloadBarChart {
    
    public static Env objEnv = new Env();

    public static void downloadBarChart() throws InterruptedException {

        boolean downloadChart = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[1]/li/span"));
        Thread.sleep(500);
        objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[3]/div[1]")).click();
        
        objEnv.driver.findElement(By.cssSelector(".apexcharts-menu-open > .exportSVG")).click();
        
        Thread.sleep(500);
        downloadChart = objEnv.driver.findElement(By.cssSelector("#root > div.home > div.sidebar > div.center > ul > a:nth-child(2) > li")).isDisplayed();

        if (downloadChart) {
            System.out.println("\n\nChart Downloaded..!");
        } else {
            System.out.println("\n\nChart Download Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        downloadBarChart();
        objEnv.driver.quit();
    }
}
