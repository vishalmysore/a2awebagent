package io.github.vishalmysore;

import java.util.ArrayList;
import java.util.Base64;
import lombok.ToString;

@ToString
public class CustomScriptResult {
    ArrayList<String> data = new ArrayList<String>();
    ArrayList<byte[]> screenshots = new ArrayList<>();

    public void addBeforeHtml(String html) {
        data.add("Before HTML: " + html);
    }

    public void addAfterHtml(String html) {
        data.add("After HTML: " + html);
    }

    public void addScreenshot(byte[] screenshot) {
        screenshots.add(screenshot);
    }

    public String getLastScreenshotAsBase64() {
        if (screenshots.isEmpty()) {
            return "No screenshot available";
        }
        return Base64.getEncoder().encodeToString(screenshots.get(screenshots.size() - 1));
    }

    public String getLastData() {
        if (data.isEmpty()) {
            return "No data available";
        }
        return data.get(data.size() - 1);
    }
}