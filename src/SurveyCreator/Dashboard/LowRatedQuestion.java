package SurveyCreator.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.common.EnvSurveyCreator;

public class LowRatedQuestion {
    
    public static EnvSurveyCreator objEnvS = new EnvSurveyCreator();

    public static void downloadBarChart() throws InterruptedException {

        boolean downloadChart = false;

        Thread.sleep(1000);
        objEnvS.driver.findElement(By.cssSelector(".gap-2 > .w-100")).click();
        {
            WebElement dropdown = objEnvS.driver.findElement(By.cssSelector(".gap-2 > .w-100"));
            dropdown.findElement(By.xpath("//option[. = 'Counselling']")).click();
        }
        objEnvS.driver.findElement(By.cssSelector(".gap-2 > .success-btn")).click();
        
        Thread.sleep(500);
        downloadChart = objEnvS.driver.findElement(By.cssSelector("#root > div.home > div.sidebar > div.center > ul > a:nth-child(2) > li")).isDisplayed();

        if (downloadChart) {
            System.out.println("\n\nFiltered Chart..!");
        } else {
            System.out.println("\n\nChart Filter Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnvS.setUpDriver();
        objEnvS.signIn();
        downloadBarChart();
        objEnvS.driver.quit();
    }
}
