import framework.ConfigReader;
import framework.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.StudyPage;

public class FavouritesTest {

    static WebDriver driver;
    HomePage homePage;

    StudyPage studyPage;

    String savedWishTitle = "";


    // Burada Driver'lar Ayağa Kaldırılır
    @BeforeClass
    public void setup(){
        driver = DriverSetup.initialize_Driver(ConfigReader.initialize_Properties().get("browser").toString());
        //homePage = new HomePage(driver);
        studyPage = new StudyPage(driver);
    }

    @Test(priority = 1, enabled = false)
    public void checkAddToWishListSuccessfully(){
        savedWishTitle = homePage.addItemToWishList();
    }

    @Test(priority = 2, enabled = false)
    public void checkWishList(){
        homePage.checkWishInFavoriteList(savedWishTitle);
    }

    @Test(priority = 3)
    public void changeCurrencyToUSD() throws InterruptedException {
        studyPage.changeCurrencyUSD();
    }

    @Test(priority = 4)
    public void checkPriceCurrencyIfUSD(){
        studyPage.checkIfCurrencyIsUSD();
    }

    @Test(priority = 5)
    public void changePageLanguage(){
        studyPage.changeLanguage();
    }

    @Test(priority = 6)
    public void changeCurrencyToAZN(){
        studyPage.changeCurrencyAZN();
    }

    @Test(priority = 7)
    public void checkPriceCurrencyIfAZN(){
        studyPage.checkIfCurrencyIsAZN();
    }
}
