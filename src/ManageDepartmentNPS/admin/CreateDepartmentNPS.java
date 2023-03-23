package ManageDepartmentNPS.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.common.Env;

public class CreateDepartmentNPS {
    
    public static Env objEnv = new Env();

    public static void cancelAddRoleFun() throws InterruptedException {

        boolean departmentAded = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("a:nth-child(6) .name")).click();
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
        objEnv.driver.findElement(By.cssSelector(".add-btn")).click();
        {
            WebElement element = objEnv.driver.findElement(By.cssSelector(".add-btn"));
            Actions builder = new Actions(objEnv.driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = objEnv.driver.findElement(By.tagName("body"));
            Actions builder = new Actions(objEnv.driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        objEnv.driver.findElement(By.name("department")).click();
        {
            WebElement dropdown = objEnv.driver.findElement(By.name("department"));
            dropdown.findElement(By.xpath("//option[. = 'Lab']")).click();
        }
        objEnv.driver.findElement(By.name("nps")).sendKeys("1");
        
        objEnv.driver.findElement(By.cssSelector(".success-btn")).click();

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();

        Thread.sleep(500);
        departmentAded = objEnv.driver.findElement(By.cssSelector("#root > div.department_nps > div.departmet_nps-container > div > div > div > div.text-center.d-flex.bordertable-wrapper.justify-content-center")).isDisplayed();

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