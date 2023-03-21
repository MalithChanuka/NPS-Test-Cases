package ManageUsers.admin;

import org.openqa.selenium.By;

import app.common.Env;

public class UndoneUser {
    
    public static Env objEnv = new Env();

    public static void addNewUserRoleFun() throws InterruptedException {

        boolean deleteUser = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("a:nth-child(4) .name")).click();

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("tr:nth-child(4) .icon:nth-child(1) > path:nth-child(1)")).click();
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();

        Thread.sleep(500);
        deleteUser = objEnv.driver.findElement(By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).isDisplayed();
        
        if (deleteUser) {
            System.out.println("\n\nUndone User..!");
        } else {
            System.out.println("\n\nDid Not Undone User..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        addNewUserRoleFun();
        objEnv.driver.quit();
    }
}
