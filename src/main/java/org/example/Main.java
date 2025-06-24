package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Đặt đường dẫn tới ChromeDriver
        // import io.github.bonigarcia.wdm.WebDriverManager;
        WebDriverManager.chromedriver().setup();

        // Thiết lập Chrome ở chế độ ẩn danh
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // URL của ứng dụng trên itch.io
        String url = "https://nguyenlamtung-k18-hl.itch.io/vechaiapp";

        // Số lần lặp (số lượt xem/tải)
        int numberOfRuns = 5;

        for (int i = 0; i < numberOfRuns; i++) {
            WebDriver driver = null;
            try {
                // Khởi tạo trình duyệt
                driver = new ChromeDriver(options);
                System.out.println("Bắt đầu lượt truy cập " + (i + 1));

                // Truy cập trang
                driver.get(url);

                // Chờ ngẫu nhiên 5-10 giây để mô phỏng hành vi người dùng
                Thread.sleep(new Random().nextInt(5000) + 5000);

                // Tìm và nhấn nút tải (nếu có)
                try {
                    WebElement downloadButton = driver.findElement(By.cssSelector("a.download_btn"));
                    downloadButton.click();
                    System.out.println("Đã nhấn nút tải");
                    Thread.sleep(2000); // Chờ tải hoàn tất
                } catch (Exception e) {
                    System.out.println("Không tìm thấy nút tải hoặc lỗi: " + e.getMessage());
                }

                System.out.println("Hoàn thành lượt truy cập " + (i + 1));
            } catch (Exception e) {
                System.out.println("Lỗi trong lượt truy cập " + (i + 1) + ": " + e.getMessage());
            } finally {
                // Đóng trình duyệt
                if (driver != null) {
                    driver.quit();
                }
            }

            // Chờ ngẫu nhiên 10-20 giây trước khi chạy lượt tiếp theo
            try {
                Thread.sleep(new Random().nextInt(3000) + 3000);
            } catch (InterruptedException e) {
                System.out.println("Lỗi khi chờ: " + e.getMessage());
            }
        }
    }
}