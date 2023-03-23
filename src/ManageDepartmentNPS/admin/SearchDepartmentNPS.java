package ManageDepartmentNPS.admin;

import org.openqa.selenium.By;
import app.common.Env;

public class SearchDepartmentNPS {
    
    public static Env objEnv = new Env();

    public static void addNewUserRoleFun() throws InterruptedException {

        boolean depSearch = false;

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("a:nth-child(6) .name")).click();

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("input")).click();

        Thread.sleep(1000);
        objEnv.driver.findElement(By.cssSelector("input")).sendKeys("lab");

        Thread.sleep(500);
        depSearch = objEnv.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[2]")).isDisplayed();
        
        if (depSearch) {
            System.out.println("\n\nSearched Department..!");
        } else {
            System.out.println("\n\nDepartment Searched Fail..!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        addNewUserRoleFun();
        objEnv.driver.quit();
    }
}
