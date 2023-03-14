package test.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.common.Env;

public class FilterLowRatedQuestions {
    
    public static Env objEnv = new Env();

    public static void filterQuestions() throws InterruptedException {

        boolean filterLowRatedQus = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[1]/li/span")).click();

        objEnv.driver.findElement(By.cssSelector("#root > div.home > div.home-container > div > div:nth-child(2) > div:nth-child(3) > div > select")).click();
        {
            WebElement dropdown = objEnv.driver.findElement(By.cssSelector("#root > div.home > div.home-container > div > div:nth-child(2) > div:nth-child(3) > div > select"));
            dropdown.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div[3]/div/select/option[2]")).click();
        }
        objEnv.driver.findElement(By.cssSelector(".cardchart-wrapper:nth-child(3) .success-btn")).click();

        Thread.sleep(500);
        filterLowRatedQus = objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div[2]/ol/li[1]")).isDisplayed();

        if (filterLowRatedQus) {
            System.out.println("\n\nFiltered Questions..!");
        } else {
            System.out.println("\n\nQuestions Filltered Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        filterQuestions();
        objEnv.driver.quit();
    }
}

