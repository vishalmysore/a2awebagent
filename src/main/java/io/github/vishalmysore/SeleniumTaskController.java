package io.github.vishalmysore;

import com.t4a.processor.scripts.BaseScriptProcessor;
import com.t4a.processor.scripts.SeleniumScriptProcessor;
import com.t4a.processor.selenium.SeleniumOpenAIProcessor;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.vishalmysore.a2a.server.DyanamicTaskContoller;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

@Service
public class SeleniumTaskController extends DyanamicTaskContoller {
    BaseScriptProcessor baseScriptProcessor;
    public SeleniumTaskController() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // or just "--headless" if < Chrome 109
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--window-size=1920,1080");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        this.baseScriptProcessor = new SeleniumScriptProcessor(new SeleniumOpenAIProcessor(driver));

    }

    @Override
    public BaseScriptProcessor getScriptProcessor() {
        return baseScriptProcessor;
    }
}
