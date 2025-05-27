package io.github.vishalmysore;

import com.t4a.processor.AIProcessingException;
import com.t4a.processor.AIProcessor;
import com.t4a.processor.scripts.SeleniumCallback;
import lombok.extern.java.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

@Log
public class A2ASeleniumCallBack implements SeleniumCallback {
    CustomScriptResult customResult;
    AIProcessor processor;

    public A2ASeleniumCallBack(CustomScriptResult customResult, AIProcessor processor) {
        this.customResult = customResult;
        this.processor = processor;
    }

    @Override
    public boolean beforeWebAction(String lineToBeProessed,WebDriver driver) {
        if(lineToBeProessed.contains("browser"))
            return false;
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
    public String handleError(String line, String errorMessage, WebDriver driver, int numberOfRetries) {
        // Log the error message you can take any action here like reprocessing the line
        log.severe("Error processing line: " + line + " Error: " + errorMessage);
        String newline = null;
        if(numberOfRetries > 3) {
            log.severe("Max retries reached for line: " + line);
            return null; // or handle as needed
        }
        try {
            newline = processor.query(" this line " + line + " failed with error " + errorMessage + " please provide new line to process");
        } catch (AIProcessingException e) {
            throw new RuntimeException(e);
        }
        return newline;
    }
}