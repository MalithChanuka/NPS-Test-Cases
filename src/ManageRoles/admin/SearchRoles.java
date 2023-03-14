package ManageRoles.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.common.Env;

public class SearchRoles {
    
    public static Env objEnv = new Env();

    public static void addNewUserRoleFun() throws InterruptedException {

        boolean roleAded = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[2]/li/span")).click();

        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div/div[1]/input")).click();
        {
            WebElement element = objEnv.driver.findElement(By.cssSelector(".active > .name"));
            Actions builder = new Actions(objEnv.driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = objEnv.driver.findElement(By.tagName("body"));
            Actions builder = new Actions(objEnv.driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        
        objEnv.driver.findElement(By.cssSelector("input")).click();
        objEnv.driver.findElement(By.cssSelector("input")).sendKeys("survey");

        Thread.sleep(500);
        roleAded = objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[2]")).isDisplayed();
        
        if (roleAded) {
            System.out.println("\n\nSearched Roles..!");
        } else {
            System.out.println("\n\nRole Searched Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        addNewUserRoleFun();
        objEnv.driver.quit();
    }
}
