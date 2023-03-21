package ManageUsers.admin;

import org.openqa.selenium.By;

import app.common.Env;

public class DeleteUser {
    
    public static Env objEnv = new Env();

    public static void addNewUserRoleFun() throws InterruptedException {

        boolean deleteUser = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector(".w-100")).click();
        objEnv.driver.findElement(By.cssSelector("a:nth-child(4) .name")).click();

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("#root > div.users > div.user-container > div > div > div > div.text-center.d-flex.bordertable-wrapper.justify-content-center > table > tbody > tr:nth-child(5) > td:nth-child(5) > svg.icon.close")).click();
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();
        objEnv.driver.findElement(By.cssSelector(".swal2-confirm")).click();

        Thread.sleep(500);
        deleteUser = objEnv.driver.findElement(By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).isDisplayed();
        
        if (deleteUser) {
            System.out.println("\n\nDeleted User..!");
        } else {
            System.out.println("\n\nDid Not Deleted User..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        addNewUserRoleFun();
        objEnv.driver.quit();
    }
}
