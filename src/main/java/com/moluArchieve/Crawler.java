package com.moluArchieve;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Component
public class Crawler {

    public static final String URL_ENTIRE = "https://www.pixiv.net/tags/%E3%83%96%E3%83%AB%E3%83%BC%E3%82%A2%E3%83%BC%E3%82%AB%E3%82%A4%E3%83%96";
    public static final String URL_ILLUSTRATION = "https://www.pixiv.net/tags/%E3%83%96%E3%83%AB%E3%83%BC%E3%82%A2%E3%83%BC%E3%82%AB%E3%82%A4%E3%83%96/illustrations";

    // 로그인 용
    public static final String TO_LOGIN_PAGE_URL = "#root > div.charcoal-token > div > div.sc-12xjnzy-0.dIGjtZ > div.sc-oh3a2p-0.lfaZnj > div > div.sc-oh3a2p-4.gHKmNu > a.sc-oh3a2p-3.dfWiNJ";
    public static final String LOGIN_INPUT_ID = "#app-mount-point > div > div > div.sc-fvq2qx-4.mKPmB > div.sc-2oz7me-0.fJsfdC > div.sc-fg9pwe-2.gZSHsw > div > div > div > form > fieldset.sc-bn9ph6-0.gOrvZT.sc-2o1uwj-2.dNokDr > label > input";
    public static final String LOGIN_INPUT_PW = "#app-mount-point > div > div > div.sc-fvq2qx-4.mKPmB > div.sc-2oz7me-0.fJsfdC > div.sc-fg9pwe-2.gZSHsw > div > div > div > form > fieldset.sc-bn9ph6-0.gOrvZT.sc-2o1uwj-3.iA-DYnj > label > input";
    public static final String LOGIN_BUTTON = "#app-mount-point > div > div > div.sc-fvq2qx-4.mKPmB > div.sc-2oz7me-0.fJsfdC > div.sc-fg9pwe-2.gZSHsw > div > div > div > form > button";
    private String id = "{pixiv id}";
    private String pw = "{pixiv pw}";

    // 짤 크롤링
    public static final String IMAGE_BOX_ENTIRE = "#root > div.charcoal-token > div > div:nth-child(4) > div > div > div.sc-15n9ncy-0.jORshO > div > section:nth-child(2) > div.sc-l7cibp-0.juyBTC > ul > li";
    public static final String IMAGE_BOX_ILLUSTRATION = "#root > div.charcoal-token > div > div:nth-child(4) > div > div > div.sc-15n9ncy-0.jORshO > section > div.sc-l7cibp-0.juyBTC > div:nth-child(1) > ul > li";

    public void login() throws InterruptedException {
        ChromeDriver driver = initDriver();
        driver.get(URL_ENTIRE);

        driver.findElement(By.cssSelector(TO_LOGIN_PAGE_URL)).click();
        driver.findElement(By.cssSelector(LOGIN_INPUT_ID)).sendKeys(id);
        driver.findElement(By.cssSelector(LOGIN_INPUT_PW)).sendKeys(pw);
        driver.findElement(By.cssSelector(LOGIN_BUTTON)).click();

        driver.quit();
    }

    public void getSingleImage() throws InterruptedException {
        ChromeDriver driver = initDriver();
        driver.get(URL_ENTIRE);

        WebElement imageBox = driver.findElement(By.cssSelector("#root > div.charcoal-token > div > div:nth-child(4) > div > div > div.sc-15n9ncy-0.jORshO > div > section:nth-child(2) > div.sc-l7cibp-0.juyBTC > ul > li:nth-child(24) > div > div.sc-iasfms-4.kbmWzS > div > a > div.sc-rp5asc-9.cYUezH > img"));
        String imageUrl = imageBox.getAttribute("src");
        System.out.println(imageUrl);

        driver.quit();
    }

    public void getImages() throws InterruptedException {
        ChromeDriver driver = initDriver();
        driver.get(URL_ILLUSTRATION);

        List<String> images = new ArrayList<>();
        List<WebElement> imageBox = driver.findElements(By.cssSelector(IMAGE_BOX_ILLUSTRATION));
        for (WebElement img : imageBox) {
            String imageUrl = img.findElement(By.cssSelector("img.sc-rp5asc-10.erYaF")).getAttribute("src");
            images.add(imageUrl);
            System.out.println(imageUrl);
        }

        driver.quit();
    }

    private static ChromeDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
        driver.manage().window().maximize();
        return driver;
    }
}
