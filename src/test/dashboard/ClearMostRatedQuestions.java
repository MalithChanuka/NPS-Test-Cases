package test.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.common.Env;

public class ClearMostRatedQuestions {
    
    public static Env objEnv = new Env();

    public static void filterQuestions() throws InterruptedException {

        boolean filterMostRatedQus = false;

        Thread.sleep(1000);
        // objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[1]/li/span")).click();

        objEnv.driver.findElement(By.cssSelector(".cardchart-wrapper:nth-child(2) > .gap-2 > .w-100")).click();
        {
            WebElement dropdown = objEnv.driver.findElement(By.cssSelector(".cardchart-wrapper:nth-child(2) > .gap-2 > .w-100"));
            dropdown.findElement(By.xpath("//option[. = 'Admission Room']")).click();
        }
        objEnv.driver.findElement(By.cssSelector(".cardchart-wrapper:nth-child(2) .success-btn")).click();

        objEnv.driver.findElement(By.cssSelector("#root > div.home > div.home-container > div > div:nth-child(2) > div:nth-child(2) > div > button.danger-btn")).click();

        Thread.sleep(500);
        filterMostRatedQus = objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div[2]/ol/li[1]")).isDisplayed();

        if (filterMostRatedQus) {
            System.out.println("\n\nClear the Filtered Questions..!");
        } else {
            System.out.println("\n\nNot Clear the Filtered Questions..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        filterQuestions();
        objEnv.driver.quit();
    }
}

