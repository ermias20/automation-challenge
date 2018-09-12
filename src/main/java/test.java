import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public  class test {
    public static void comment() throws Exception  {
        String Link = "https://preview.c9users.io/borisyuz/staging_env/automation/post1.html";
        String Username = "candidate@armyspy.com";
        String Password ="1q2w#E$R";

        WebDriver driver = new Chromedriver().openbrowser();
        driver.manage().window().maximize();
        driver.get(Link);
        Wait.waitforcss("body > h1" , driver);

        Thread.sleep(6000);

        int size = driver.findElements(By.className("prerender-view")).size();
        System.out.println(size);
        driver.switchTo().frame(0);
        Wait.waitforspan("//*[@id=\"root\"]/div/div[2]/div[1]", driver);
        Wait.waitforspan("//*[@id=\"root\"]/div/div[1]", driver);

        driver.findElement(By.className("sppre_login-button")).click();
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        //int size1 = driver.findElements(By.className("modal-body")).size();
        //System.out.println(size1);
        //driver.switchTo().frame(0);
        driver.switchTo().frame("spot-im-frame-modal-iframe");

        WebElement select = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]"));
        List<WebElement> options = select.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]"));
             for (WebElement option : options) {
                 System.out.println(option);

                 if("Email".equals(option.getText()))
                option.click();
             }

        Wait.waitforspan("//*[@id=\"root\"]/div/div[2]", driver);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]")).click();
        Wait.waitforspan("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/span[2]", driver);
        int size1 = driver.findElements(By.className("spot-im-frame-modal-iframe")).size();
        System.out.println(size1);
        Wait.waitforspan("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]", driver);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/input")).sendKeys(Username);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/input")).sendKeys(Password);
        //Wait.waitforclickable("div.registration-fields", driver);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/a")).click();
        Thread.sleep(7000);
        //Wait.waitforspan(""//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/button"", driver);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(0);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");

        String CurrentUsername = driver.findElement(By.className("sppre_wrapper")).getText();

        String comment = "comment1";
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")).sendKeys(comment);
        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/button")).click();
        Wait.waitforclickab("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/button", driver);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/button")).click();

        /**  WebElement select1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/ul"));
         List<WebElement> options1 = select1.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/ul/li[*]"));
         for (WebElement options2 : options1) {

         System.out.println( options1.size());
         System.out.println(options2.getText());
         }
         **/
        Wait.waitforspan("//*[@id=\"root\"]/div/div[2]/ul/li[2]/div/div/div[1]/div[2]",driver);
        String messageid = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/ul/li[2]/div/div/div[1]/div[1]")).getAttribute("data-message-id");
        BEDApiResponse run = new BEDApiResponse();
        run.GetResponse(messageid);
    }
   }