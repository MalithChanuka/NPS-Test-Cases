package ManageDepartmnet.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.common.Env;

public class DeleteDepartment {
    
    public static Env objEnv = new Env();

    public static void addNewUserRoleFun() throws InterruptedException {

        boolean deleteUser = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("a:nth-child(5) .name")).click();
        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("tr:nth-child(8) .close")).click();
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();
        {
            WebElement element = objEnv.driver.findElement(By.cssSelector(".swal2-confirm"));
            Actions builder = new Actions(objEnv.driver);
            builder.moveToElement(element).perform();
        }
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();

        Thread.sleep(500);
        deleteUser = objEnv.driver.findElement(By.cssSelector("#root > div.department > div.department-container > div > div > div > div.text-center.d-flex.bordertable-wrapper.justify-content-center > table > tbody > tr:nth-child(7) > td:nth-child(1)")).isDisplayed();
        
        if (deleteUser) {
            System.out.println("\n\nDeleted Department..!");
        } else {
            System.out.println("\n\nDid Not Deleted Department..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        addNewUserRoleFun();
        objEnv.driver.quit();
    }
}
