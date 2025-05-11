package io.github.vishalmysore;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import com.t4a.detect.ActionCallback;
import com.t4a.processor.GeminiV2ActionProcessor;
import com.t4a.processor.OpenAiActionProcessor;
import com.t4a.processor.scripts.ScriptProcessor;
import com.t4a.processor.scripts.ScriptResult;
import com.t4a.processor.scripts.SeleniumScriptProcessor;
import io.github.vishalmysore.a2a.server.SSEEmitterCallback;
import lombok.extern.java.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Log
@Agent(groupName = "web browsing", groupDescription = "actions related to web browsing and searching and validation of web pages ")
public class WebBrowsingAction {
    private ActionCallback callback;

    @Action(description = "perform actions on the web with selenium")
    public String browseWebAndPerformAction(String webBrowsingSteps) throws IOException {


        // Process the file
        SeleniumScriptProcessor script = new SeleniumScriptProcessor();
        ScriptResult result = script.process(webBrowsingSteps,callback);


        return result.toString();
    }

}
