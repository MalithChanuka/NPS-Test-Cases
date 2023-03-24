package admin.login;

import org.openqa.selenium.By;
import app.common.Env;

public class InvalidLogin {

    public static Env objEnv = new Env();

    public static void loginFun() throws InterruptedException {

        boolean loged = false;

        //  // Find the email input field and enter the email address
        //  WebElement emailInput = objEnv.driver.findElement(By.name("username"));
        //  emailInput.sendKeys("nps@admin.com");
 
        //  // Find the password input field and enter the password
        //  WebElement passwordInput = objEnv.driver.findElement(By.name("password"));
        //  passwordInput.sendKeys("1234");
 
        //  // Find the login button and click it
        //  WebElement loginButton = objEnv.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[3]/button"));
        //  loginButton.click();
 
         // Wait for the dashboard page to load
        //  WebElement dashboardPage = objEnv.driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/h3"));
        
        Thread.sleep(1500);
        loged = objEnv.driver.findElement(By.cssSelector("#root > div.Toastify > div")).isDisplayed();

         // Verify that the dashboard page is displayed
         if (loged) {
             System.out.println("\n\nLogin Fail");
         } else {
             System.out.println("\n\nLogin Success");
         }
    }

    public static void main(String[] args) throws InterruptedException {
        objEnv.setUpDriver();
        objEnv.signIn();
        loginFun();
        objEnv.driver.quit();
    }
}
    
