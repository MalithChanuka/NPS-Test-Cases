package app.common;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Env {
     public WebDriver driver;
     public JavascriptExecutor js;

     public String baseURL = "https://nps.monoroc.com/";
     public String userName = "nps@admin.com";
     public String password = "123";

     public void setUpDriver() {

        String absolutePath = new File("").getAbsolutePath();

        System.setProperty("Webdriver.chrome.driver", absolutePath+"\\Chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

     }

    public void signIn() throws InterruptedException {

        driver.get(baseURL);
        driver.manage().window().maximize();
        Thread.sleep(2500);

        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[3]/div/div[2]/form/div[1]/input")).click();
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[3]/div/div[2]/form/div[1]/input")).sendKeys(userName);

        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[3]/div/div[2]/form/div[2]/input")).click();
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[3]/div/div[2]/form/div[2]/input")).sendKeys(password);     
    
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[3]/div/div[2]/form/div[3]/button")).click();

    }

}
