package ManageUsers.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.common.Env;

public class EditManageUser {
    
    public static Env objEnv = new Env();

    public static void editManageRoleFun() throws InterruptedException {

        boolean roleEdit = false;

        Thread.sleep(1000);
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
        objEnv.driver.findElement(By.cssSelector("tr:nth-child(4) .edit")).click();
        objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div[1]/input")).click();
        objEnv.driver.findElement(By.name("name")).sendKeys("Malith");
        objEnv.driver.findElement(By.name("role")).click();
        {
            WebElement dropdown = objEnv.driver.findElement(By.name("role"));
            dropdown.findElement(By.xpath("//option[. = 'assistant']")).click();
        }
        objEnv.driver.findElement(By.cssSelector(".success-btn")).click();
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();

        Thread.sleep(500);
        roleEdit = objEnv.driver.findElement(By.cssSelector("#root > div.roles > div.role-container > div > div > div > div.text-center.d-flex.bordertable-wrapper.justify-content-center > table > tbody > tr:nth-child(1) > td:nth-child(2)")).isDisplayed();

        if (roleEdit) {
            System.out.println("\n\nRole Edited..!");
        } else {
            System.out.println("\n\nRole Edit Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        editManageRoleFun();
        objEnv.driver.quit();
    }
}
