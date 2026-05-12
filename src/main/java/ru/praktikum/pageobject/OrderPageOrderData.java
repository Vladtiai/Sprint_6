package ru.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPageOrderData {
    private WebDriver driver;

    private By dateDelivery =           By.xpath("//div[@class=\"Order_Form__17u6u\"]//input[@placeholder=\"* Когда привезти самокат\"]");
    private By rentalPeriod =           By.xpath("//div[contains(@class, 'Dropdown-control')]");
    private By scooterColourBlack =     By.xpath("//input[@id='black']");
    private By scooterColourGray =      By.xpath("//input[@id='grey']");
    private By comment =                By.xpath("//input[@placeholder=\"Комментарий для курьера\"]");
    private By finalOrderButton =       By.xpath("//div[@class=\"Order_Buttons__1xGrp\"]/button[text()=\"Заказать\"]");
    private By yesButton =              By.xpath("//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    private By successOrderMessage =    By.xpath("//div[contains(text(), 'Заказ оформлен')]");

    public OrderPageOrderData(WebDriver driver) {
        this.driver = driver;
    }

    public void inputDateDelivery(String userDateDelivery) {
        driver.findElement(dateDelivery).sendKeys(userDateDelivery);
        driver.findElement(dateDelivery).sendKeys(Keys.ENTER);
    }

    public void selectRentalPeriod(String period) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-option'][text()='" + period + "']")).click();
    }

    public void selectScooterColour(String colour) {
        if (colour.equals("черный")) {
            driver.findElement(scooterColourBlack).click();
        } else if (colour.equals("серый")) {
            driver.findElement(scooterColourGray).click();
        }
    }

    public void inputComment(String userComment) {
        driver.findElement(comment).sendKeys(userComment);
    }

    public void clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public boolean isOrderSuccessDisplayed() {
        return driver.findElement(successOrderMessage).isDisplayed();
    }

    public void inputOrderData(String date, String period, String colour, String commentText) {
        inputDateDelivery(date);
        selectRentalPeriod(period);
        selectScooterColour(colour);
        inputComment(commentText);
        clickFinalOrderButton();
        clickYesButton();
    }
}