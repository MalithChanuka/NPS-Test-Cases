package NPS.Admin;

import org.openqa.selenium.By;
import app.common.Env;

public class admin {
    
    public static Env objEnv = new Env();

    public static void addNewUserRoleFun() throws InterruptedException {

        boolean admin = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("span > b")).click();
        Thread.sleep(500);
        objEnv.driver.findElement(By.cssSelector(".modal-footer > .success-btn")).click();
        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();

        Thread.sleep(500);
        admin = objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[1]/ul/a[1]/li")).isDisplayed();
        
        if (admin) {
            System.out.println("\n\nChange My Profile..!");
        } else {
            System.out.println("\n\nDid Not Change My Profile..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        addNewUserRoleFun();
        objEnv.driver.quit();
    }
}
