package io.github.vishalmysore;

import com.t4a.processor.scripts.BaseScriptProcessor;
import com.t4a.processor.scripts.SeleniumScriptProcessor;
import io.github.vishalmysore.a2a.server.DyanamicTaskContoller;
import org.springframework.stereotype.Service;

@Service
public class SeleniumTaskController extends DyanamicTaskContoller {
    BaseScriptProcessor baseScriptProcessor;
    public SeleniumTaskController() {
        this.baseScriptProcessor = new SeleniumScriptProcessor();

    }

    @Override
    public BaseScriptProcessor getScriptProcessor() {
        return baseScriptProcessor;
    }
}
