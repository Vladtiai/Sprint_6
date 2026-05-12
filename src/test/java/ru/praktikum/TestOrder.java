package ru.praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.pageobject.MainPage;
import ru.praktikum.pageobject.OrderPageOrderData;
import ru.praktikum.pageobject.OrderPagePersonalData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOrder {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.education-services.ru/");
        mainPage = new MainPage(driver);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "header | Иван | Иванов | Москва, ул. Ленина 1 | Авиамоторная | 89990001122 | 12.05.2026 | двое суток | черный | позвоните заранее",
            "main | Мария | Иванова | Москва, ул. Сталина 1 | Бульвар Рокоссовского | 88005553535 | 14.05.2026 | трое суток | серый | просто до метро"
    }, delimiter = '|')


    public void testCreateOrder(String buttonType,
                                String firstName, String lastName,
                                String address, String metroStation,
                                String phoneNumber, String deliveryDate,
                                String rentalPeriod, String color, String comment) {

        OrderPagePersonalData personalData = new OrderPagePersonalData(driver);
        OrderPageOrderData orderData = new OrderPageOrderData(driver);

        if (buttonType.equals("header")) {
            mainPage.clickButtonHeader();
        } else {
            mainPage.clickButtonMainPage();
        }

        personalData.inputPersonalData(firstName, lastName, address, metroStation, phoneNumber);
        orderData.inputOrderData(deliveryDate, rentalPeriod, color, comment);
        assertTrue(orderData.isOrderSuccessDisplayed());
    }

    @AfterEach
    public void tearDown() {
            driver.quit();
    }
}