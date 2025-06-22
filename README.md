# Itch.io View/Download Bot

Dự án này là một tập lệnh tự động hóa sử dụng Selenium WebDriver để truy cập và tương tác với một trang ứng dụng trên Itch.io. Mục tiêu chính là mô phỏng hành vi của người dùng để tăng lượt xem hoặc lượt tải cho một ứng dụng cụ thể.

## Tính năng

* Truy cập URL của ứng dụng Itch.io đã chỉ định.
* Mô phỏng hành vi người dùng bằng cách chờ đợi ngẫu nhiên trên trang.
* Tự động tìm và nhấn nút tải xuống (nếu có).
* Thực hiện nhiều lượt truy cập liên tiếp với khoảng thời gian chờ ngẫu nhiên giữa các lượt để trông tự nhiên hơn.
* Sử dụng chế độ duyệt web ẩn danh của Chrome để tránh lưu trữ dữ liệu duyệt web.

## Yêu cầu

Để chạy dự án này, bạn cần có:

* **Java Development Kit (JDK)**: Phiên bản 8 trở lên.
* **Maven** hoặc **Gradle** (để quản lý các dependency).
* **Trình duyệt Google Chrome** được cài đặt trên hệ thống của bạn.

## Cài đặt

1.  **Clone hoặc tải xuống dự án này:**
    ```bash
    git clone https://github.com/lamtung2105/urlAccess.git
    ```

2.  **Thêm các dependency vào file `pom.xml` (đối với Maven) hoặc `build.gradle` (đối với Gradle):**

    **Đối với Maven (pom.xml):**

    ```xml
        <dependencies>
            <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-java</artifactId>
                <version>4.21.0</version> </dependency>
            <dependency>
                <groupId>io.github.bonigarcia</groupId>
                <artifactId>webdrivermanager</artifactId>
                <version>5.8.0</version> </dependency>
        </dependencies>

    ```

3.  **Xây dựng dự án:**
    * **Maven:** `mvn clean install`
    * **Gradle:** `gradle build`

## Cách sử dụng

1.  **Mở file `Main.java`** trong IDE của bạn (ví dụ: IntelliJ IDEA, Eclipse).

2.  **Chỉnh sửa các tham số sau theo nhu cầu của bạn:**

    * `String url = "https://nguyenlamtung-k18-hl.itch.io/vechaiapp";`
        Thay đổi URL này thành URL của ứng dụng Itch.io mà bạn muốn tăng lượt xem/tải.

    * `int numberOfRuns = 5;`
        Thay đổi giá trị này để đặt số lần script sẽ truy cập và tương tác với trang.

3.  **Chạy file `Main.java`:**
    Bạn có thể chạy trực tiếp từ IDE của mình hoặc từ dòng lệnh sau khi đã xây dựng dự án:
    ```bash
    java -jar target/ItchIoBot-1.0-SNAPSHOT.jar
    ```
    (Nếu bạn đang chạy từ JAR và project của bạn có tên artifact là `ItchIoBot-1.0-SNAPSHOT.jar`. Hãy thay thế bằng tên file JAR thực tế của bạn.)

## Cảnh báo

* Việc sử dụng các script tự động để thao túng lượt xem hoặc tải có thể vi phạm các điều khoản dịch vụ của Itch.io. Hãy sử dụng một cách có trách nhiệm.
* Hành vi "nhấn nút tải" chỉ hoạt động nếu nút tải có `class="download_btn"`. Nếu cấu trúc HTML của trang thay đổi, script có thể cần được cập nhật.
* Thời gian chờ ngẫu nhiên được thiết lập để mô phỏng hành vi của con người, nhưng không đảm bảo tránh được việc bị phát hiện là bot.

## Tác giả

LamTung
