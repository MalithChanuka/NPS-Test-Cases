package ManageDepartmnet.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.common.Env;

public class CreateDepartment {
    
    public static Env objEnv = new Env();

    public static void cancelAddRoleFun() throws InterruptedException {

        boolean departmentAded = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("a:nth-child(5) .name")).click();
        objEnv.driver.findElement(By.cssSelector(".plus-icon > path:nth-child(3)")).click();
        {
            WebElement element = objEnv.driver.findElement(By.cssSelector(".plus-icon > path:nth-child(3)"));
            Actions builder = new Actions(objEnv.driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = objEnv.driver.findElement(By.tagName("body"));
            Actions builder = new Actions(objEnv.driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        objEnv.driver.findElement(By.name("departmentname")).click();
        objEnv.driver.findElement(By.name("departmentname")).click();
        objEnv.driver.findElement(By.name("departmentname")).sendKeys("Testing 3");
        objEnv.driver.findElement(By.cssSelector(".success-btn")).click();

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();

        Thread.sleep(500);
        departmentAded = objEnv.driver.findElement(By.cssSelector("#root > div.department > div.department-container > div > div")).isDisplayed();

        if (departmentAded) {
            System.out.println("\n\nDepartment Aded..!");
        } else {
            System.out.println("\n\nDepartment Aded Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        cancelAddRoleFun();
        objEnv.driver.quit();
    }
}

