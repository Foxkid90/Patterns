package ru.netology.patterns.tests;


import com.codeborne.selenide.SelenideElement;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.patterns.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ChangingDeliveryDateTest {

    @Test
    void shouldReplaneDeliveryDate() {
        open("http://localhost:9999");
        SelenideElement form = $("form");

        DataGenerator.UserInfo user = DataGenerator.Registration.generateUser("ru");
        form.$("[data-test-id=city] .input__control").setValue(user.getCity());
        String shiftDate = DataGenerator.generateDate(5);
        form.$("[data-test-id=date] .input__control")
                .press(Keys.CONTROL, "a").press(Keys.BACK_SPACE).setValue(shiftDate);
        form.$("[data-test-id=name] .input__control")
                .setValue(DataGenerator.Registration.generateUser("ru").getName());
        form.$("[data-test-id=phone] .input__control")
                .setValue(DataGenerator.Registration.generateUser("ru").getPhone());
        form.$("[data-test-id=agreement] .checkbox__box").click();
        form.$("button .button__content").click();
        $("[data-test-id=success-notification]")
                .shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=success-notification] .notification__content")
                .shouldHave(text("Встреча успешно запланирована на " + shiftDate));

        String replanDate = DataGenerator.generateDate(10);
        form.$("[data-test-id=date] .input__control")
                .press(Keys.CONTROL, "a").press(Keys.BACK_SPACE).setValue(replanDate);
        form.$("button .button__content").click();
        $("[data-test-id=replan-notification]")
                .shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=replan-notification] .button__content").click();
        $("[data-test-id=success-notification]")
                .shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=success-notification] .notification__content")
                .shouldHave(text("Встреча успешно запланирована на " + replanDate));


    }


}
