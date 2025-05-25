package io.github.vishalmysore;

import com.t4a.processor.scripts.SeleniumCallback;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class A2ASeleniumCallBack implements SeleniumCallback {
    CustomScriptResult customResult;

    public A2ASeleniumCallBack(CustomScriptResult customResult) {
        this.customResult = customResult;
    }

    @Override
    public void beforeWebAction(WebDriver driver) {
        String html = driver.getPageSource();
        customResult.addBeforeHtml(html);
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        customResult.addScreenshot(screenshot);
    }

    @Override
    public void afterWebAction(WebDriver driver) {
        String html = driver.getPageSource();
        customResult.addAfterHtml(html);
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        customResult.addScreenshot(screenshot);
    }
}