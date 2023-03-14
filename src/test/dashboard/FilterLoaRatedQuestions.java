package test.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.common.Env;

public class FilterLoaRatedQuestions {
    
    public static Env objEnv = new Env();

    public static void filterQuestions() throws InterruptedException {

        boolean filterLowRatedQus = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[1]/li/span")).click();

        objEnv.driver.findElement(By.cssSelector(".cardchart-wrapper:nth-child(3) .w-100")).click();
        {
            WebElement dropdown = objEnv.driver.findElement(By.cssSelector(".cardchart-wrapper:nth-child(3) .w-100"));
            dropdown.findElement(By.xpath("//option[. = 'Cashier']")).click();
        }
        objEnv.driver.findElement(By.cssSelector(".cardchart-wrapper:nth-child(3) .success-btn")).click();

        Thread.sleep(500);
        filterLowRatedQus = objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[2]/div[3]/ol/li[1]/text()")).isDisplayed();

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

