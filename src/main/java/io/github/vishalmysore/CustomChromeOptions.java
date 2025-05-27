package io.github.vishalmysore;

import org.openqa.selenium.chrome.ChromeOptions;

public class CustomChromeOptions {
    public static ChromeOptions createOptions() {
        ChromeOptions options = new ChromeOptions();
        boolean useCommandLineOptions = Boolean.getBoolean("driverOptions");

        if (useCommandLineOptions) {
            String commandLineArgs = System.getProperty("chrome.options", "");
            if (!commandLineArgs.isEmpty()) {
                String[] args = commandLineArgs.split(",");
                options.addArguments(args);
                System.out.println(commandLineArgs);
            }
        } else {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-software-rasterizer");
            options.addArguments("--disable-extensions");
            options.addArguments("--remote-debugging-pipe");
            options.addArguments("--window-size=1920,1080");
        }

        return options;
    }
}