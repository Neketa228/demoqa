import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

public class GoogleSearch {

    @BeforeSuite
    public void beforeSuite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://demoqa.com/automation-practice-form");
        String zoomJS;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        zoomJS = "document.body.style.zoom='0.8'";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
        firstName.sendKeys("Marina");
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
        lastName.sendKeys("Ivanova");
        WebElement mail = driver.findElement(By.xpath("//input[@placeholder=\"name@example.com\"]"));
        mail.sendKeys("marina1990@gmail.com");

        WebElement rb = driver.findElement(By.xpath("//input[@value=\"Female\"]"));
        actions.moveToElement(rb).click().build().perform();

        WebElement number = driver.findElement(By.id("userNumber"));
        number.sendKeys("89112896574");

        WebElement date = driver.findElement(By.id("dateOfBirthInput"));
        date.click();
        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        month.click();

        WebElement selectMonth = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
        Select selectmonth = new Select(selectMonth);
        selectmonth.selectByVisibleText("April");

        WebElement selectYear = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
        Select selectyear = new Select(selectYear);
        selectyear.selectByVisibleText("1997");

        List<WebElement> selectDay = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(" div.react-datepicker__day.react-datepicker__day--010")));
        selectDay.get(0).click();

        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        subjects.sendKeys("Physics");
        subjects.sendKeys(Keys.ENTER);
        subjects.sendKeys("Math");
        subjects.sendKeys(Keys.ENTER);

        WebElement hobbies = driver.findElement(By.xpath("//input[@id=\"hobbies-checkbox-2\"]"));
        actions.moveToElement(hobbies).click().build().perform();

        WebElement picture = driver.findElement(By.id("uploadPicture"));
        picture.sendKeys("C:\\Users\\nekit\\IdeaProjects\\TestProj\\foto_kotika.jpg");

        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("Street 1");

        WebElement dropdownState = driver.findElement(By.id("state"));
        dropdownState.click();
        WebElement optionState = driver.findElement(By.xpath("//div[@id='state']//div[text()='NCR']"));
        optionState.click();

        WebElement dropdownCity = driver.findElement(By.id("city"));
        dropdownCity.click();
        WebElement optionCity = driver.findElement(By.xpath("//div[@id='city']//div[text()='Delhi']"));
        optionCity.click();

        js.executeScript(zoomJS);
        WebElement buttonSub = driver.findElement((By.id("submit")));
        buttonSub.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.urlContains("/automation-practice-form"));

    }
}
