package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class LaptopandNotebooksTest extends Utility {
    String baseurl = " http://tutorialsninja.com/demo/index.php? ";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully()throws InterruptedException{
        //1.1Mouse hover on Laptops & Notebooks Tab.and click
        WebElement Laptop=driver.findElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(Laptop).click().build().perform();
        //Select sort by price
        selectValueDropDown(By.xpath("//select[@id='input-sort']"),"input-sort");
        //Verify the Product price will arrange in high to low
        String expectedResult="Price (High > Low)";
        String actualResult=getTextFromElement(By.xpath("//select[@id='input-sort']"));
        Assert.assertEquals("Error message display",expectedResult,actualResult);
        Thread.sleep(1000);
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException{
        //1.1Mouse hover on Laptops & Notebooks Tab.and click
        WebElement Laptop=driver.findElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(Laptop).click().build().perform();
        //Select sort by price
        selectValueDropDown(By.xpath("//select[@id='input-sort']"),"input-sort");
        //Verify the Product price will arrange in high to low
        String expectedResult="Price (High > Low)";
        String actualResult=getTextFromElement(By.xpath("//select[@id='input-sort']"));
        Assert.assertEquals("Error message display",expectedResult,actualResult);
        selectVisibleText(By.xpath("//h1[contains(text(),'MacBook Pro')]"),"MacBook Pro");
        //Verify the text Macbook
        String expectedText="MacBook Pro";
        String actualText=getTextFromElement(By.xpath("//h1[contains(text(),'MacBook Pro')]"));
        Assert.assertEquals("Message is not display",expectedText,actualText);
        selectVisibleText(By.xpath("//input[@id='input-quantity']"),"2");
        //click on Update
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]"));
        //Verify the message
        String expectedTxt="“Success: You have modified your shopping cart";
        String actualTxt=getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        Assert.assertEquals("Message is not display",expectedTxt,actualTxt);
        //Verify the total
        String expectedTotal=" £737.45";
        String actualTotal=getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Assert.assertEquals("Total price is not matched",expectedTotal,actualTotal);
        //Click on checkout button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        Thread.sleep(1000);
    }



















    @After
    public void tearDown() {
        closeBrowser();
    }
}