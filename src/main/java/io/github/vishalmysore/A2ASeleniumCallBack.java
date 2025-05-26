package io.github.vishalmysore;

import com.t4a.processor.scripts.SeleniumCallback;
import lombok.extern.java.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

@Log
public class A2ASeleniumCallBack implements SeleniumCallback {
    CustomScriptResult customResult;

    public A2ASeleniumCallBack(CustomScriptResult customResult) {
        this.customResult = customResult;
    }

    @Override
    public boolean beforeWebAction(String lineToBeProessed,WebDriver driver) {
        log.info("Processing line: " + lineToBeProessed);
        try {
            String html = driver.getPageSource();
            customResult.addBeforeHtml(html);
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            customResult.addScreenshot(screenshot);
        } catch (WebDriverException e) {
            log.info(e.getMessage());
        }
        return true;
    }

    @Override
    public void afterWebAction(String lineProcessed,WebDriver driver) {
        log.info("Processed line: " + lineProcessed);
        try {
            String html = driver.getPageSource();
            customResult.addAfterHtml(html);
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            customResult.addScreenshot(screenshot);
        } catch (WebDriverException e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public void handleError(String line, String errorMessage, WebDriver driver) {
        // Log the error message you can take any action here like reprocessing the line
        log.severe("Error processing line: " + line + " Error: " + errorMessage);
    }
}