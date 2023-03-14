package test;

import org.openqa.selenium.By;

import app.common.Env;

public class EditManageRole {
    
    public static Env objEnv = new Env();

    public static void editManageRoleFun() throws InterruptedException {

        boolean roleEdit = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[2]/li")).click();

        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[3]/svg[1]")).click();

        objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/input")).click();

        objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/input")).sendKeys("survey creator");

        objEnv.driver.findElement(By.cssSelector("body > div.fade.add-modal.modal.show > div > div > div.modal-footer > button.success-btn")).click();

        Thread.sleep(500);
        roleEdit = objEnv.driver.findElement(By.cssSelector("#swal2-title")).isDisplayed();

        if (!roleEdit) {
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
