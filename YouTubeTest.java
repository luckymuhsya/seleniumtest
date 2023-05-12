import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YouTubeTest {
    public static void main(String[] args) throws InterruptedException {
        // Inisialisasi driver dan buka website YouTube
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        
     // Maximalkan window
        driver.manage().window().maximize();

        // Test case 1: Cari video dengan kata kunci "Video Tanpa Iklan"
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("Video Tanpa Iklan");
        searchBox.sendKeys(Keys.RETURN);

        Thread.sleep(3000); // Tunggu hingga halaman hasil pencarian selesai loading

        // Test case 2: Buka video pertama dari hasil pencarian
        WebElement firstVideo = driver.findElement(By.xpath("//a[@id='video-title'][1]"));
        firstVideo.click();

        Thread.sleep(3000); // Tunggu hingga video selesai loading

        // Test case 3: Pause video
        WebElement videoPlayer = driver.findElement(By.xpath("//div[@id='movie_player']"));
        videoPlayer.click();
        videoPlayer.sendKeys(Keys.SPACE);

        Thread.sleep(1000); // Tunggu hingga video berhenti

       // Kembali ke halaman sebelumnya
        driver.navigate().back();

        Thread.sleep(3000); // Tunggu hingga halaman sebelumnya selesai loading

     
     // Test case 4: Navigasi ke halaman Trending YouTube
        WebElement trendingBtn = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[3]/div/ytd-guide-entry-renderer[1]/a/tp-yt-paper-item"));
        trendingBtn.click();

        Thread.sleep(5000); // Tunggu hingga halaman Trending selesai loading

     // Test case 5: Navigasi ke Shorts YouTube
        WebElement shortsBtn = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-entry-renderer[2]/a/tp-yt-paper-item"));
        shortsBtn.click();

        Thread.sleep(3000); // Tunggu hingga halaman Shorts selesai loading
        
        // Tutup browser
        driver.quit();
    }
}
