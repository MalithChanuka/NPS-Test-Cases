package ManageRoles.admin;

import org.openqa.selenium.By;

import app.common.Env;

public class CanselNewRole {
    
    public static Env objEnv = new Env();

    public static void cancelAddRoleFun() throws InterruptedException {

        boolean cancelRoleAded = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/ul/a[2]/li")).click();

        objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div/div[1]/button")).click();

        objEnv.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/input")).click();

        objEnv.driver.findElement(By.cssSelector("body > div.fade.add-modal.modal.show > div > div > div.modal-footer > button.danger-btn")).click();

        Thread.sleep(500);
        cancelRoleAded = objEnv.driver.findElement(By.cssSelector("#root > div.roles > div.role-container > div > div > div > div.filter-view.col-12 > button")).isDisplayed();

        if (cancelRoleAded) {
            System.out.println("\n\nRole Aded Cancel..!");
        } else {
            System.out.println("\n\nRole Cancel Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        cancelAddRoleFun();
        objEnv.driver.quit();
    }
}

