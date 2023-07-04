package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseurl = " http://tutorialsninja.com/demo/index.php? ";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu){
        //1.2 This method should click on the menu whatever name is passed as parameter.
        //Write the following Test
        clickOnElement(By.linkText(menu));
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully()throws InterruptedException {
        //1.1  Mouse hover on “Desktops” Tab and click
        WebElement deskTops = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(deskTops).click().build().perform();
        //Verify the text Desktop
        String expectedText = "‘Desktops’";
        String actualText = getTextFromElement(By.linkText("Desktops"));
        Assert.assertEquals("Message is not displayed", expectedText, actualText);
        Thread.sleep(1000);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()throws InterruptedException{
        //2.1  Mouse hover on “Laptops & Notebooks” Tab and click
        WebElement laptop=driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(laptop).click().build().perform();
        //Verify the text laptops & Notebooks
        String expectedMessage="Laptops & Notebooks";
        String actualMessage=getTextFromElement(By.xpath("//href[@class='dropdown-toggle']"));
        Assert.assertEquals("Message is not display",expectedMessage,actualMessage);
        Thread.sleep(1000);
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully()throws InterruptedException{
        //3.1 Mouse hover on “Components” Tab and click
        WebElement components=driver.findElement(By.xpath("//href[@class='dropdown-toggle']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(components).click().build().perform();
        //Verify the Text component
        String expectedResult="‘Components’";
        String actualResult=getTextFromElement(By.xpath("//href[@class='dropdown-toggle']"));
        Assert.assertEquals("Message is not display",expectedResult,actualResult);
        //Verify the model
        String expectedText="Product21";
        String actualText=getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Assert.assertEquals("Error message display",expectedText,actualText);
        //Verify the total
        String expectedTotal="£74.73";
        String actualTotal=getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Thread.sleep(1000);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


