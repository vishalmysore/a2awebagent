package io.github.vishalmysore;

import io.github.vishalmysore.a2a.domain.JsonRpcRequest;

import io.github.vishalmysore.a2a.server.A2ATaskController;
import io.github.vishalmysore.common.server.JsonRpcController;
import io.github.vishalmysore.common.server.SpringAwareJSONRpcController;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
@Log
public class SeleniumA2AController extends SpringAwareJSONRpcController {


    @Autowired
    SeleniumTaskController seleniumTaskController;

    @Autowired
    public SeleniumA2AController(ApplicationContext applicationContext) {
        super(applicationContext);
    }

    @GetMapping
    public ModelAndView forwardToIndex() {

        return new ModelAndView("forward:/index.html");
    }

    @PostMapping
    public Object handleRpc(@RequestBody JsonRpcRequest request) {
        log.info(request.toString());
        Object obj =  super.handleRpc(request);

        return obj;

    }

    @Override
    public A2ATaskController getTaskController() {
        return seleniumTaskController;
    }
}
