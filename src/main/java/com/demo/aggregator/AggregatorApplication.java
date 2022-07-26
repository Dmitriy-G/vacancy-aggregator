package com.demo.aggregator;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;

import java.util.HashMap;

/*@SpringBootApplication
@EnableScheduling*/
public class AggregatorApplication {

	@SneakyThrows
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.selenium.dev/downloads/");
		System.out.println(driver.getTitle());

		WebElement link = driver.findElementByCssSelector("body > div > main > div.row.justify-content-center.p-5.td-box--100 > div.col-sm-6.py-3.pl-0.pr-3 > div > div > p:nth-child(2) > a");
		link.click();
		Thread.sleep(15000);

		System.out.println(driver.getTitle());

		driver.quit();

		/*ApiContextInitializer.init();
		SpringApplication.run(AggregatorApplication.class, args);*/
	}
}
