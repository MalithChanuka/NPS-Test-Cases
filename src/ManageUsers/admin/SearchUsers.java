package ManageUsers.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.common.Env;

public class SearchUsers {
    
    public static Env objEnv = new Env();

    public static void addNewUserRoleFun() throws InterruptedException {

        boolean userSearch = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[2]/li/span")).click();

        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div/div[1]/input")).click();

        objEnv.driver.findElement(By.cssSelector("a:nth-child(4) .name")).click();
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
        objEnv.driver.findElement(By.cssSelector("input")).sendKeys("mali");

        Thread.sleep(500);
        userSearch = objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[2]")).isDisplayed();
        
        if (userSearch) {
            System.out.println("\n\nSearched User..!");
        } else {
            System.out.println("\n\nUser Searched Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        addNewUserRoleFun();
        objEnv.driver.quit();
    }
}
