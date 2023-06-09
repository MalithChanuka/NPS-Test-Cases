package dashboard.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.common.Env;

public class ClearLowRatedQuestions {
    
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

        objEnv.driver.findElement(By.cssSelector("#root > div.home > div.home-container > div > div:nth-child(2) > div:nth-child(3) > div > button.danger-btn")).click();

        Thread.sleep(500);
        filterLowRatedQus = objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div[3]/ol/li[1]")).isDisplayed();

        if (filterLowRatedQus) {
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

