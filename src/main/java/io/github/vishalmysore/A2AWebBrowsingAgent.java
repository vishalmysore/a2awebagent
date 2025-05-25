package io.github.vishalmysore;

import com.t4a.processor.AIProcessingException;
import io.github.vishalmysore.a2a.client.LocalA2ATaskClient;
import io.github.vishalmysore.a2a.domain.FileContent;
import io.github.vishalmysore.a2a.domain.FilePart;
import io.github.vishalmysore.a2a.domain.Task;
import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Log
public class A2AWebBrowsingAgent {
    public static void main(String[] args) throws IOException, AIProcessingException {
        // Set the path of the ChromeDriver executable

//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//      //  context.scan("io.github.vishalmysore");
//        context.refresh();
//        // Get the client from Spring context
//        SeleniumA2AController rpcController = context.getBean(SeleniumA2AController.class);
//        LocalA2ATaskClient client = new LocalA2ATaskClient(rpcController);
//        FilePart filePart = new FilePart();
//        FileContent fileContent = new FileContent();
//        Path webActionPath = Paths.get("src/main/resources/web.action");
//        byte[] fileBytes = Files.readAllBytes(webActionPath);
//        String base64Content = java.util.Base64.getEncoder().encodeToString(fileBytes);
//
//// Set the file content
//        fileContent.setName("web.action");
//        fileContent.setMimeType("text/plain");
//        fileContent.setBytes(base64Content);
//        filePart.setFile(fileContent);
//         Task t =  client.sendFileTask(filePart);
//
//
//
//
//        log.info(client.getTask(t.getId(),2).toString());
//        // Clean up
//        context.close();
    }
}
