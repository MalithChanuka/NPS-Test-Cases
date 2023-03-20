package ManageUsers.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.common.Env;

public class CreateNewUser {
    
    public static Env objEnv = new Env();

    public static void addNewUserRoleFun() throws InterruptedException {

        boolean createUser = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[1]/ul/a[3]/li/span")).click();
        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div[1]/button")).click();
        Thread.sleep(1000);
        // objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/input")).click();
        objEnv.driver.findElement(By.name("name")).click();
        objEnv.driver.findElement(By.name("name")).sendKeys("Malith Chanuka");
        Thread.sleep(1000);
        // objEnv.driver.findElement(By.name("role")).click();
        {
            WebElement dropdown = objEnv.driver.findElement(By.name("role"));
            dropdown.findElement(By.xpath("//option[. = 'survey creator']")).click();
        }

        objEnv.driver.findElement(By.cssSelector(".mb-3:nth-child(3) .btn")).click();

        objEnv.driver.findElement(By.cssSelector(".pass .btn")).click();

        objEnv.driver.findElement(By.cssSelector("body > div.fade.add-modal.modal.show > div > div > div.modal-footer > button.success-btn")).click();

        Thread.sleep(500);
        createUser = objEnv.driver.findElement(By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).isDisplayed();
        
        if (createUser) {
            System.out.println("\n\nCreated User..!");
        } else {
            System.out.println("\n\nNot Created User..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        addNewUserRoleFun();
        objEnv.driver.quit();
    }
}
