package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class DesktopsTest extends Utility {
    String baseurl = " http://tutorialsninja.com/demo/index.php? ";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder()throws InterruptedException{
        //1.1 Mouse hover on Desktop Tab and click
        WebElement DeskTop=driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(DeskTop).click().build().perform();
        //1.2 Click on Show All Desktops
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //1.3 select sort By position "Name: Z to A"
    }
    @Test
    public void  verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        //2.1 Mouse hover on Desktops Tab. and click
        WebElement DeskTop=driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(DeskTop).click().build().perform();
        //2.2 Click on Show All Desktops
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        Thread.sleep(1000);
        WebElement sortby=driver.findElement(By.xpath("//label[contains(text(),'Sort By:')]"));
        WebElement names=driver.findElement(By.xpath("//select[@id='input-sort']"));
        Actions actions1=new Actions(driver);
        actions.moveToElement(sortby).moveToElement(names).click().build().perform();
        selectVisibleText(By.xpath("//a[contains(text(),'HP LP3065')]"),"HP LP3065");
        // Verify the Text "HP LP
        String expectedResult="HP LP3065";
        String actualResult=getTextFromElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        Assert.assertEquals("Error message display",expectedResult,actualResult);
        //Select Delivery Date
        selectVisibleText(By.xpath("//input[@id='input-option225']"),"");
    }















    @After
    public void tearDown() {
        closeBrowser();
    }
}
