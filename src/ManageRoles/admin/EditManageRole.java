package ManageRoles.admin;

import org.openqa.selenium.By;

import app.common.Env;

public class EditManageRole {
    
    public static Env objEnv = new Env();

    public static void editManageRoleFun() throws InterruptedException {

        boolean roleEdit = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[2]/li")).click();

        Thread.sleep(500);
        objEnv.driver.findElement(By.cssSelector("tr:nth-child(1) .edit")).click();

        // objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/input")).click();

        // objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/input")).sendKeys("survey creator");
        Thread.sleep(500);
        objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();

        Thread.sleep(500);
        objEnv.driver.findElement(By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();

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
