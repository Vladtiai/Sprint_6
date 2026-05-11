package ru.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPagePersonalData {

    private WebDriver driver;

    private By firstName        =By.xpath("//div[@class=\"Order_Form__17u6u\"]//input[@placeholder=\"* Имя\"]");
    private By lastName         =By.xpath("//div[@class=\"Order_Form__17u6u\"]//input[@placeholder=\"* Фамилия\"]");
    private By adress           =By.xpath("//div[@class=\"Order_Form__17u6u\"]//input[contains(@placeholder, \"Адрес\")]");
    private By metroStation     =By.xpath("//div[@class=\"Order_Form__17u6u\"]//input[@placeholder=\"* Станция метро\"]");
    private By phoneNumber      =By.xpath("//div[@class=\"Order_Form__17u6u\"]//input[contains(@placeholder, \"Телефон\")]");
    private By nextButton       =By.xpath("//div[@class=\"Order_NextButton__1_rCA\"]//button[text()=\"Далее\"]");

    public OrderPagePersonalData(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstname(String userFirstName){
        driver.findElement(firstName ).sendKeys(userFirstName);
    }

    public void inputLastname(String userLastName){
        driver.findElement(lastName).sendKeys(userLastName);
    }

    public void inputAdress(String userAdress){
        driver.findElement(adress).sendKeys(userAdress);
    }

    public void selectMetroStation(String userMetroStation){
        driver.findElement(metroStation).sendKeys(userMetroStation);
        driver.findElement(metroStation).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroStation).sendKeys(Keys.ENTER);
    }

    public void inputPhoneNumber(String userPhoneNumber){
        driver.findElement(phoneNumber).sendKeys(userPhoneNumber);
    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }

    public void inputPersonalData(String name,
                                  String lastName,
                                  String adress,
                                  String metro,
                                  String phone) {
        inputFirstname(name);
        inputLastname(lastName);
        inputAdress(adress);
        selectMetroStation(metro);
        inputPhoneNumber(phone);
        clickNextButton();
    }
}
