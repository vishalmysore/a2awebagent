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
        WebDriver driver = new ChromeDriver(CustomChromeOptions.createOptions());
        this.baseScriptProcessor = new SeleniumScriptProcessor(new SeleniumOpenAIProcessor(driver));

    }

    @Override
    public BaseScriptProcessor getScriptProcessor() {
        return baseScriptProcessor;
    }
}
