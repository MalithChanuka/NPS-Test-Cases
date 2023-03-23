package ManageDepartmentNPS.admin;

import org.openqa.selenium.By;
import app.common.Env;

public class EditDepartmentNPS {
    
    public static Env objEnv = new Env();

    public static void editManageRoleFun() throws InterruptedException {

        boolean roleEdit = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("a:nth-child(6) .name")).click();

        Thread.sleep(500);
        objEnv.driver.findElement(By.cssSelector("tr:nth-child(4) .edit")).click();

        Thread.sleep(500);
        objEnv.driver.findElement(By.name("nps")).click();

        Thread.sleep(500);
        objEnv.driver.findElement(By.name("nps")).sendKeys("2");

        Thread.sleep(500);
        objEnv.driver.findElement(By.cssSelector(".success-btn")).click();

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
