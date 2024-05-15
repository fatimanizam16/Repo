package Practice.test;

import Practice.pages.Homepage;
import Practice.utils.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.sql.DriverManager.*;

public class TestTo extends SetUp {

    public static Properties properties= new Properties();
    public static WebDriver driver;
    public static Homepage homepage;


    public TestTo(){

        String filePath="/Users/fatimanizam/Desktop/Practice/src/resources/TestData/config.properties";
        try {
            FileInputStream fileInputStream= new FileInputStream(filePath);
            properties.load(fileInputStream);
        fileInputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @BeforeClass(alwaysRun = true)
    public void tearUp(){
       driver= launchBrowser(properties.getProperty("browser"));
        driver.get(properties.getProperty("url"));
        homepage=new Homepage(driver);
    }



    @Test(priority = 1)
    public static void verify_application_launched_Successfully() {
        homepage.enterWords(properties.getProperty("searchInput"));
    }
    @AfterClass(alwaysRun = true)
        public void tearDown(){
//        if (SetUp.driver != null){
//            SetUp.driver.quit();
//        }
        driver.quit();
    }






}

