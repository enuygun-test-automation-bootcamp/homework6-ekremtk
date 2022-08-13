package pageObjects;

import framework.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

    //WebDriver setups
    WebDriver driver;
    Helper elementHelper;
    By searchInput = By.id("search-input");
    By searchIcon = By.cssSelector("button[type=submit]");
    By wishListIcon = By.cssSelector("a[data-tooltip=\"Add to Wishlist\"]");
    By imageBox = By.cssSelector(".tt-image-box");
    By favorites = By.cssSelector("div[data-tooltip=\"Favorites\"]");
    By titleOfWish = By.xpath("//*/h2[@class='tt-title']");
    //By titlefOfSearchResult = By.xpath("//*/h2[@class='tt-title']");


    //By titlefOfSearchResult = By.xpath("//a[contains(text(),'Love and feelings - Flower Bouquet')]");
    By titlefOfSearchResult = By.xpath("//*[contains(text(),'Love and feeling')]");




    //login page constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new Helper(driver);
    }

    public String addItemToWishList() {
        this.elementHelper.findElement(searchInput).click();
        this.elementHelper.typeForInput("rose", this.elementHelper.findElement(searchInput));
        this.elementHelper.findElement(searchIcon).click();
        this.elementHelper.hoverMover(this.elementHelper.findElement(imageBox));
        this.elementHelper.findElements(wishListIcon).get(0).click();

        System.out.println("Result with using FindElements Command: " + this.elementHelper.findElements(titlefOfSearchResult).get(0).getText());
        System.out.println("Result with using FindElement Command: " + this.elementHelper.findElement(titlefOfSearchResult).getText());

        return this.elementHelper.findElements(titlefOfSearchResult).get(0).getText();
    }

    public void checkWishInFavoriteList(String expectedWish){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scroll(0, -250)");
        this.elementHelper.findElement(favorites).click();
        System.out.println("Title of Element in the Search Section (Expected): " + expectedWish);
        System.out.println("Title of Element in the Favorite Section (Obtained): " +  this.elementHelper.findElement(titleOfWish).getText());
        Assert.assertEquals(expectedWish, this.elementHelper.findElement(titleOfWish).getText());
    }

}
