package pageObjects;

import framework.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class StudyPage {

    WebDriver driver;
    Helper elementHelper;


    //[class='dropdown-content lang-dropdown']

    // Language Button
    By dropLanguageList = By.xpath("//button[@class='dropbtn']");

    // Azerbaijani Select Button
    By azSelect = By.xpath("//*[contains(text(), 'Azerbaijani')]");
    //[data-id='AZ']

    // Currency Button
    By dropCurrencyList = By.xpath("//button[@class='dropbtn currency-dropdown']");

    By usdSelect = By.xpath("//*[contains(text(), 'USD')]");

    By aznSelect = By.xpath("//*[contains(text(), 'AZN')]");

    By priceTitle = By.xpath("//*[@id=\"tt-pageContent\"]/div[3]/div/div/div/div/div/div[1]/div/div[2]/div[2]");


    //login page constructor
    public StudyPage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new Helper(driver);
    }

    public void changeCurrencyUSD() {
        this.elementHelper.findElement(dropCurrencyList).click();
        this.elementHelper.findElement(usdSelect).click();
    }


    public void changeLanguage() {
        this.elementHelper.findElement(dropLanguageList).click();
        this.elementHelper.findElement(azSelect).click();
    }

    public void changeCurrencyAZN() {
        this.elementHelper.findElement(dropCurrencyList).click();
        this.elementHelper.findElement(aznSelect).click();
    }

    public void checkIfCurrencyIsUSD() {
        String str = this.elementHelper.findElement(priceTitle).getText();
        String[] splitStr = str.split("\\s+");
        Assert.assertEquals("USD", splitStr[1]);
    }

    public void checkIfCurrencyIsAZN() {
        String str = this.elementHelper.findElement(priceTitle).getText();
        String[] splitStr = str.split("\\s+");
        Assert.assertEquals("AZN", splitStr[1]);
    }

}
