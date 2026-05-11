package ru.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    private By orderButtonHeader =      By.xpath(".//button[@class = 'Button_Button__ra12g']");
    private By orderButtonMainPage =    By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/button");

    public void clickButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void clickButtonMainPage() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonMainPage)); ;
        driver.findElement(orderButtonMainPage).click();
    }


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickQuestionButton(int index) {
        int actualIndex = index - 1;
        By questionButton = By.id("accordion__heading-" + actualIndex);
        WebElement element = driver.findElement(questionButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }


    public String getAnswerText(int index) {
        int actualIndex = index - 1;
        By answerPanel = By.id("accordion__panel-" + actualIndex);
        return driver.findElement(answerPanel).getText();
    }
}

