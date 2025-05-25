package io.github.vishalmysore;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import com.t4a.detect.ActionCallback;
import com.t4a.predict.PredictionLoader;
import com.t4a.processor.AIProcessingException;
import com.t4a.processor.AIProcessor;
import com.t4a.processor.GeminiV2ActionProcessor;
import com.t4a.processor.OpenAiActionProcessor;
import com.t4a.processor.scripts.ScriptProcessor;
import com.t4a.processor.scripts.ScriptResult;
import com.t4a.processor.scripts.SeleniumScriptProcessor;
import io.github.vishalmysore.a2a.server.SSEEmitterCallback;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@Log
@Agent(groupName = "web browsing", groupDescription = "actions related to web browsing and searching and validation of web pages ")
public class WebBrowsingAction {
    private ActionCallback callback;
    private AIProcessor processor;
    @Action(description = "perform actions on the web with selenium and return text")
    public String browseWebAndReturnText(String webBrowsingSteps) throws IOException {
        CustomScriptResult result = new CustomScriptResult();
        A2ASeleniumCallBack seleniumCallBack = new A2ASeleniumCallBack(result);
        if(processor != null) {
            try {
                StringBuffer seperatedWebBrowsingSteps = new StringBuffer(processor.query("Separate the web browsing steps into individual steps  just give me steps without any additional text or brackets {"+ webBrowsingSteps+"}"));
                SeleniumScriptProcessor script = new SeleniumScriptProcessor();
                script.process(seperatedWebBrowsingSteps,seleniumCallBack);
                                return result.getLastData();
            } catch (AIProcessingException e) {
                throw new RuntimeException(e);
            }


        }
        return "processing issues";// Process the file

    }

    @Action(description = "perform actions on the web with selenium and return image")
    public String browseWebAndReturnImage(String webBrowsingSteps) throws IOException {
        CustomScriptResult result = new CustomScriptResult();
        A2ASeleniumCallBack seleniumCallBack = new A2ASeleniumCallBack(result);
        if(processor != null) {
            try {
                StringBuffer seperatedWebBrowsingSteps = new StringBuffer(processor.query("Separate the web browsing steps into individual steps  just give me steps without any additional text or brackets {"+ webBrowsingSteps+"}"));
                SeleniumScriptProcessor script = new SeleniumScriptProcessor();
                script.process(seperatedWebBrowsingSteps,seleniumCallBack);
                return result.getLastScreenshotAsBase64();
            } catch (AIProcessingException e) {
                throw new RuntimeException(e);
            }


        }
        return "processing issues";// Process the file

    }

}
