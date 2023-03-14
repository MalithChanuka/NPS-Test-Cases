package test.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.common.Env;

public class ClearSurveyBasedDepBarChart {
    
    public static Env objEnv = new Env();

    public static void BarChart() throws InterruptedException {

        boolean downloadChart = false;

        Thread.sleep(1000);
        // objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[1]/li/span"));
        
        objEnv.driver.findElement(By.cssSelector("#root > div.home > div.home-container > div > div:nth-child(3) > div.cardchart-wrapper.chart2.shadow-sm.p-2.d-flex.flex-column.bg-white.col > div.chart-filters.d-flex.gap-3 > select")).click();
        {
            WebElement dropdown = objEnv.driver.findElement(By.cssSelector("#root > div.home > div.home-container > div > div:nth-child(3) > div.cardchart-wrapper.chart2.shadow-sm.p-2.d-flex.flex-column.bg-white.col > div.chart-filters.d-flex.gap-3 > select"));
            dropdown.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[3]/div[1]/div[1]/select/option[2]")).click();
        }
        objEnv.driver.findElement(By.cssSelector("#root > div.home > div.home-container > div > div:nth-child(3) > div.cardchart-wrapper.chart2.shadow-sm.p-2.d-flex.flex-column.bg-white.col > div.chart-filters.d-flex.gap-3 > button.success-btn")).click();

        objEnv.driver.findElement(By.cssSelector("#root > div.home > div.home-container > div > div:nth-child(3) > div.cardchart-wrapper.chart2.shadow-sm.p-2.d-flex.flex-column.bg-white.col > div.chart-filters.d-flex.gap-3 > button.danger-btn")).click();
        
        Thread.sleep(500);
        downloadChart = objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[3]/div[1]/div[2]")).isDisplayed();

        if (downloadChart) {
            System.out.println("\n\nClear the Filtered Bar Chart..!");
        } else {
            System.out.println("\n\nNot Clear the Filtered Bar Chart..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        BarChart();
        objEnv.driver.quit();
    }
}
