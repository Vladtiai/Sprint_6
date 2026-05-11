package ru.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.pageobject.MainPage;
import ru.praktikum.pageobject.OrderPageOrderData;
import ru.praktikum.pageobject.OrderPagePersonalData;

import static org.junit.Assert.assertTrue;

public class TestOrder {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.education-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testOrderButtonHeader() {

        String firstName =      "Иван";
        String lastName =       "Иванов";
        String address =        "Москва, ул. Ленина 1";
        String metroStation =   "Авиамоторная";
        String phoneNumber =    "89990001122";
        String deliveryDate =   "12.05.2026";
        String rentalPeriod =   "двое суток";
        String color =          "черный";
        String comment =        "позвоните заранее";

        OrderPagePersonalData personalData = new OrderPagePersonalData(driver);
        OrderPageOrderData orderData = new OrderPageOrderData(driver);
        mainPage.clickButtonHeader();
        personalData.inputPersonalData(firstName, lastName, address, metroStation, phoneNumber);
        orderData.inputOrderData(deliveryDate, rentalPeriod, color, comment);
        assertTrue(orderData.isOrderSuccessDisplayed());
    }

    @Test
    public void testOrderButtonMainPage() {

        String firstName =      "Мария";
        String lastName =       "Иванова";
        String address =        "Москва, ул. Сталина 1";
        String metroStation =   "Бульвар Рокоссовского";
        String phoneNumber =    "88005553535";
        String deliveryDate =   "14.05.2026";
        String rentalPeriod =   "трое суток";
        String color =          "серый";
        String comment =        "просто до метро";

        OrderPagePersonalData personalData = new OrderPagePersonalData(driver);
        OrderPageOrderData orderData = new OrderPageOrderData(driver);
        mainPage.clickButtonMainPage();
        personalData.inputPersonalData(firstName, lastName, address, metroStation, phoneNumber);
        orderData.inputOrderData(deliveryDate, rentalPeriod, color, comment);
        assertTrue(orderData.isOrderSuccessDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}