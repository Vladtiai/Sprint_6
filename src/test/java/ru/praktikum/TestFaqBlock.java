package ru.praktikum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.pageobject.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFaqBlock {

    private MainPage mainPage;
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.education-services.ru/");
        mainPage = new MainPage(driver);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 | Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "2 | Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "3 | Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "4 | Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "5 | Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "6 | Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "7 | Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "8 | Да, обязательно. Всем самокатов! И Москве, и Московской области."
    }, delimiter = '|')

    void testQuestionButton (int index, String expectedText) {
        mainPage.clickQuestionButton(index);
        String actualText = mainPage.getAnswerText(index);
        assertEquals(expectedText, actualText,"Текст для кнопки " + index + " не совпадает");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
