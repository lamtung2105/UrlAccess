package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor; // Import for scrolling

import java.util.Random;
import java.util.Arrays; // For user agents

public class Main {
    /**
     * Main method to run the Selenium script.
     * This script simulates multiple visits to a specific URL with different user agents,
     * waits for a random time, scrolls the page, and attempts to click a download button.
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        String url = "https://nguyenlamtung-k18-hl.itch.io/vechaiapp";
        int numberOfRuns = 5; // For testing, would be much higher in reality

        // A list of diverse user agents (expand this list significantly)
        String[] userAgents = {
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.3 Safari/605.1.15",
                "Mozilla/5.0 (Linux; Android 10; SM-G973F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Mobile Safari/537.36",
                "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:91.0) Gecko/20100101 Firefox/91.0"
        };

        Random random = new Random();

        for (int i = 0; i < numberOfRuns; i++) {
            WebDriver driver = null;
            try {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");

                // Set a random user agent
                String selectedUserAgent = userAgents[random.nextInt(userAgents.length)];
                options.addArguments("user-agent=" + selectedUserAgent);

                // In User-Agent đã chọn
                System.out.println("Starting visit " + (i + 1) + " with User-Agent: " + selectedUserAgent);

                driver = new ChromeDriver(options);
                driver.get(url);

                // Simulate human reading/Browse time (15-45 seconds)
                Thread.sleep(random.nextInt(30000) + 15000);

                // Simulate scrolling
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
                Thread.sleep(random.nextInt(3000) + 1000);
                js.executeScript("window.scrollTo(0, 0)");
                Thread.sleep(random.nextInt(3000) + 1000);

                // Attempt to click download button
                try {
                    WebElement downloadButton = driver.findElement(By.cssSelector("a.download_btn"));
                    downloadButton.click();
                    System.out.println("Clicked download button.");
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Download button not found or error: " + e.getMessage());
                }

                System.out.println("Completed visit " + (i + 1));
            } catch (Exception e) {
                System.out.println("Error during visit " + (i + 1) + ": " + e.getMessage());
            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }

            // Wait longer between runs (30-60 seconds)
            try {
                Thread.sleep(random.nextInt(30000) + 30000);
            } catch (InterruptedException e) {
                System.out.println("Error during wait: " + e.getMessage());
            }
        }
    }
}
