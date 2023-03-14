package test.dashboard;

import org.openqa.selenium.By;

import app.common.Env;

public class DownloadBarChart {
    
    public static Env objEnv = new Env();

    public static void downloadBarChart() throws InterruptedException {

        boolean downloadChart = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[1]/li/span"));
        
        objEnv.driver.findElement(By.xpath("//*[@id='apexchartswc8idadu']/div[3]")).click();
        
        objEnv.driver.findElement(By.cssSelector(".apexcharts-menu-open > .exportSVG")).click();
        
        Thread.sleep(500);
        downloadChart = objEnv.driver.findElement(By.cssSelector("#apexchartsy0yjh668 > div.apexcharts-toolbar > div.apexcharts-menu-icon > svg")).isDisplayed();

        if (downloadChart) {
            System.out.println("\n\nRole Aded..!");
        } else {
            System.out.println("\n\nRole Aded Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        downloadBarChart();
        objEnv.driver.quit();
    }
}
