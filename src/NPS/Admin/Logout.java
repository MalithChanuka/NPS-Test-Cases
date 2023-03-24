package NPS.Admin;

import org.openqa.selenium.By;
import app.common.Env;

public class Logout {
    
    public static Env objEnv = new Env();

    public static void addNewUserRoleFun() throws InterruptedException {

        boolean adminLogout = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/div[2]/ul/li[2]/span")).click();

        Thread.sleep(500);
        adminLogout = objEnv.driver.findElement(By.xpath("/html")).isDisplayed();
        
        if (adminLogout) {
            System.out.println("\n\nSuccessfully Logout..!");
        } else {
            System.out.println("\n\nDid Not Logout..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        addNewUserRoleFun();
        objEnv.driver.quit();
    }
}
