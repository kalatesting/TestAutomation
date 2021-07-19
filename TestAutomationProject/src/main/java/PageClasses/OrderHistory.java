package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class OrderHistory {
    By orderHistory=By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a");
    By orderedItem=By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]");


    public void clickOrderHistory(WebDriver driver){
        driver.findElement(orderHistory).click();
    }

    public Boolean CheckOrderHistory() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        SignInPage signIn=new SignInPage();
        Properties prop=signIn.readProperties("C:/Users/sathi/IdeaProjects/TestAutomationProject/src/main/resources/test.properties");
        String URL= prop.getProperty("URL");
        String email=prop.getProperty("email");
        String pwd=prop.getProperty("password");
        driver.get(URL);
        Thread.sleep(50);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        signIn.CLickSignIn(driver);
        Thread.sleep(50);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        signIn.Login(email,pwd,driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        clickOrderHistory(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        boolean isOrderPresent= driver.findElement(orderedItem).isDisplayed();
        driver.close();
         if(isOrderPresent){
            return true;}
            else {
            return false;}



    }
}
