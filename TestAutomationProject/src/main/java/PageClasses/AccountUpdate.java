package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AccountUpdate {
    public boolean savedSuccessfully;
    By personalInfm=By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a");
    By firstName=By.name("firstname");
    By save=By.xpath("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button");
    By enterpwd=By.xpath("//*[@id=\"old_passwd\"]");
    By Success=By.xpath("//*[@id=\"center_column\"]/div/p");

    public void ClickPersonalInfm(WebDriver driver)    {
        driver.findElement(personalInfm).click();
    }
    public void modifyfirstName(WebDriver driver){
        driver.findElement(firstName).sendKeys("chandrika");
    }
    public void Enterpwd(WebDriver driver) throws IOException {
        SignInPage signIn=new SignInPage();
        Properties prop=signIn.readProperties("C:/Users/sathi/IdeaProjects/TestAutomationProject/src/main/resources/test.properties");
        String pwd=prop.getProperty("password");
        driver.findElement(enterpwd).sendKeys(pwd);
    }
    public void SaveAccount(WebDriver driver){
        driver.findElement(save).click();
    }

    public void ModifyAccountInformation() throws IOException, InterruptedException {
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
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        ClickPersonalInfm(driver);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        modifyfirstName(driver);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Enterpwd(driver);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        SaveAccount(driver);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        savedSuccessfully=driver.findElement(Success).isDisplayed();
        driver.close();
    }
    public boolean ModifiedSuccess(){
        if(savedSuccessfully)
            return true;
        else
            return false;
    }



}
