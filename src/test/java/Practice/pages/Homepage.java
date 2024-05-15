package Practice.pages;

import Practice.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Utils {

    WebDriver driver;


    public Homepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement searchField;



    public void enterWords(String input) {
        searchField.clear();
        searchField.sendKeys(input);
        Utils.pauseExecution(3);
    }
}
