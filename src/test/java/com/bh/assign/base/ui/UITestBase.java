package com.bh.assign.base.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UITestBase {

    public static WebDriver driver;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void pageScroll_Keypress_Executor() throws InterruptedException {
        driver.get("https://www.stqatools.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

// Scroll Down using Actions class
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(300);

// Scroll Up using Actions class
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
        Thread.sleep(500);

//        assertThat(driver.getTitle(), containsString("GitHub"));
        String javascript = "window.scrollBy(0,500)";

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript);

    }

    @Test
    public void page_Handling_iFrame() throws InterruptedException {
        // Click on link to open iFrame
            driver.get("http://omayo.blogspot.com/");
            Thread.sleep(1000);
            driver.manage().window().maximize();
            Thread.sleep(1000);
// Switch to Frame
            driver.switchTo().frame(1);

            // Switch back to defaultContent
            driver.switchTo().defaultContent();
        }
    }
