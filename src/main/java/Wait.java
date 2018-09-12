import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Wait {
    public static void waitforcss (String css, WebDriver driver) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));

    }
    public static void waitforspan (String xpath, WebDriver driver) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }
    public static void waitforclickable (String classname, WebDriver driver) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.elementToBeClickable(By.className(classname)));

    }
    public static void waitforclassname (String classname, WebDriver driver) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.elementToBeClickable(By.className(classname)));

    }

    public static void waitforclickab (String xpath, WebDriver driver) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

    }
}
