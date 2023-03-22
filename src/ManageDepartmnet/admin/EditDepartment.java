package ManageDepartmnet.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.common.Env;

public class EditDepartment {
    
    public static Env objEnv = new Env();

    public static void editManageRoleFun() throws InterruptedException {

        boolean roleEdit = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("a:nth-child(5) .name")).click();
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
        objEnv.driver.findElement(By.cssSelector("tr:nth-child(8) .edit")).click();

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/input")).click();
        objEnv.driver.findElement(By.cssSelector(".add-modal")).click();
        objEnv.driver.findElement(By.name("name")).sendKeys("Testing edit");

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("body > div.fade.add-modal.modal.show > div > div > div.modal-footer > button.success-btn")).click();

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();

        Thread.sleep(500);
        roleEdit = objEnv.driver.findElement(By.xpath("/html/body")).isDisplayed();

        if (roleEdit) {
            System.out.println("\n\nUser Details Edited..!");
        } else {
            System.out.println("\n\nUser Details Edit Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        editManageRoleFun();
        objEnv.driver.quit();
    }
}
