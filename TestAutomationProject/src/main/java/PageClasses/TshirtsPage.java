package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TshirtsPage {
    By TshirtPage=By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
    By selecTshirt=By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img");
    By addtoCart=By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span");
    By proceedtoCheckout=By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    By orderpageproceedtocheckout=By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
    By AddressPageproceedtocheckout=By.xpath("//*[@id=\"center_column\"]/form/p/button");
    By AgreeTerms=By.xpath("//*[@id=\"cgv\"]");
    By Shippingpagecheckout=By.xpath("//*[@id=\"form\"]/p/button");
    By payment=By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"); //*[@id="HOOK_PAYMENT"]/div[1]/div/p/a
    By confirmOrder=By.xpath("//*[@id=\"cart_navigation\"]/button");
    By backtoOrders=By.xpath("//*[@id=\"center_column\"]/p/a");

    public void CLickTshirtsMenu(WebDriver driver){
        driver.findElement(TshirtPage).click();
    }

    public void AddtoCart(WebDriver driver){
        WebElement Tshirt=driver.findElement(selecTshirt);
        Actions actions=new Actions(driver);
        actions.moveToElement(Tshirt);
        WebElement AddtoCart= driver.findElement(addtoCart);
        actions.moveToElement(AddtoCart);
        actions.click().build().perform();
    }
    public void ProceedtoCheckout(WebDriver driver){
        driver.findElement(proceedtoCheckout).click();
    }

    public void OrderpageProceedtoCheckout(WebDriver driver){

        driver.findElement(orderpageproceedtocheckout).click();
    }
    public void AddresspageProceedoCheckout(WebDriver driver){
        driver.findElement(AddressPageproceedtocheckout).click();
    }
    public void shippingcheckout(WebDriver driver) throws InterruptedException {
        driver.findElement(AgreeTerms).click();
        Thread.sleep(5);
        driver.findElement(Shippingpagecheckout).click();
    }
    public void payment(WebDriver driver)throws InterruptedException{
        driver.findElement(payment).click();
        Thread.sleep(5);
    }
    public void confirmOrder(WebDriver driver){

        driver.findElement(confirmOrder).click();
    }
    public void backtoOrders(WebDriver driver){

        driver.findElement(backtoOrders).click();
    }

    public void tshirtsOrder()throws IOException, InterruptedException
    {
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
        CLickTshirtsMenu(driver);
        Thread.sleep(50);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String parentWindow= driver.getWindowHandle();
        AddtoCart(driver);
        Thread.sleep(30);
        for (String handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }
        Thread.sleep(50);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        ProceedtoCheckout(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        OrderpageProceedtoCheckout(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        AddresspageProceedoCheckout(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        shippingcheckout(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        payment(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        confirmOrder(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        backtoOrders(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        signIn.clickSignout(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.close();
    }
}
