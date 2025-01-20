package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class scraper {

    String url;
    String grade;
    WebDriver driver = new ChromeDriver();
    static Double totalPrice = 0.0;

    public scraper(String Url, String Grade){
        this.url = Url;
        this.grade = Grade;
    }

    public scraper(String Url){
        this.url = Url;
    }

    public scraper(){}

    public Double getTotalPrice(){
        return totalPrice;
    }

    public void updateTotal(String strPrice){
        double price = Double.parseDouble(strPrice.replace("$", ""));
        totalPrice += Double.parseDouble(String.format("%.2f", price));
    }

    public String[] getInfo() {
        String[] response = new String[3];

        if (url.contains("tcgplayer")) { // if current link is tcg player link
            try {
                driver.get(url);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));  // Changed Duration.ofSeconds to direct seconds value
                WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-details__name"))); // get name
                WebElement currentPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".price-points__upper__price")));

                response[0] = productName.getText();
                response[1] = currentPrice.getText();
                response[2] = "none";

                updateTotal(currentPrice.getText());

            } catch (Exception e) {
                System.out.println("Error fetching data in TCGPlayer scraper " + e.getMessage());
                return null;
            } finally {
                driver.quit();
            }
        }
        if (url.contains("pricecharting")) {
            try {
                driver.get(url);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement productNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1#product_name")));
                WebElement productPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#graded_price > span.price.js-price")));

                response[0] = productNameElement.getText();
                response[1] = productPriceElement.getText();
                response[2] = grade;

                updateTotal(productPriceElement.getText());
                driver.quit();
            } catch (Exception e) {
                System.out.println("Error fetching data in PriceCharting scraper: " + e.getMessage());
            }
        }

        return response;
    }
}

