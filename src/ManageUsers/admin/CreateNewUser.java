package ManageUsers.admin;

import org.openqa.selenium.By;

import app.common.Env;

public class CreateNewUser {
    
    public static Env objEnv = new Env();

    public static void addNewUserRoleFun() throws InterruptedException {

        boolean roleAded = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[1]/ul/a[3]/li/span")).click();

        objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div[1]/button")).click();

        objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/input")).click();

        objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/input")).sendKeys("Role");

        objEnv.driver.findElement(By.cssSelector("body > div.fade.add-modal.modal.show > div > div > div.modal-footer > button.success-btn")).click();

        Thread.sleep(500);
        roleAded = objEnv.driver.findElement(By.cssSelector("#root > div.Toastify > div")).isDisplayed();
        
        if (!roleAded) {
            System.out.println("\n\nRole Aded..!");
        } else {
            System.out.println("\n\nRole Aded Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        addNewUserRoleFun();
        objEnv.driver.quit();
    }
}
