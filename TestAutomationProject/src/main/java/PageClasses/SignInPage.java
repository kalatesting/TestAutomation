package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SignInPage {
    public Properties prop;

        public Properties readProperties(String filename) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(filename);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }

   By email = By.name("email");
   By pwd = By.name("passwd");
   By login=By.name("SubmitLogin");
   By signin=By.linkText("Sign in");
   By signout=By.linkText("Sign out");

    public void CLickSignIn(WebDriver driver){
       driver.findElement(signin).click();
    }
    public void clickSignout(WebDriver driver){driver.findElement(signout).click();}

    public void Login(String emailID,String password,WebDriver driver){
        driver.findElement(email).sendKeys(emailID);
        driver.findElement(pwd).sendKeys(password);
        driver.findElement(login).click();
    }
        public void LogintoPage() throws IOException, InterruptedException {
          System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
          WebDriver driver= new ChromeDriver();
          driver.manage().window().maximize();
        Properties prop=readProperties("C:/Users/sathi/IdeaProjects/TestAutomationProject/src/main/resources/test.properties");
        String URL= prop.getProperty("URL");
        String email=prop.getProperty("email");
        String pwd=prop.getProperty("password");
        driver.get(URL);
        Thread.sleep(50);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        CLickSignIn(driver);
        Thread.sleep(50);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        Login(email,pwd,driver);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        clickSignout(driver);
        driver.close();
    }

}
