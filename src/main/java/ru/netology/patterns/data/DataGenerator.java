package ru.netology.patterns.data;

import com.github.javafaker.Faker;
import lombok.Value;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {
    }

    private static final List<String> CITIES = List.of(
            "Абакан",
            "Анадырь",
            "Архангельск",
            "Астрахань",
            "Барнаул",
            "Белгород",
            "Биробиджан",
            "Благовещенск",
            "Брянск",
            "Великий Новгород",
            "Владивосток",
            "Владикавказ",
            "Владимир",
            "Волгоград",
            "Вологда",
            "Воронеж",
            "Гатчина",
            "Горно-Алтайск",
            "Грозный",
            "Екатеринбург",
            "Йошкар-Ола",
            "Иваново",
            "Ижевск",
            "Иркутск",
            "Казань",
            "Калининград",
            "Калуга",
            "Кемерово",
            "Киров",
            "Кострома",
            "Красногорск",
            "Краснодар",
            "Красноярск",
            "Курган",
            "Курск",
            "Кызыл",
            "Липецк",
            "Магадан",
            "Магас",
            "Майкоп",
            "Махачкала",
            "Москва",
            "Мурманск",
            "Нальчик",
            "Нарьян-Мар",
            "Нижний Новгород",
            "Новосибирск",
            "Омск",
            "Оренбург",
            "Орёл",
            "Пенза",
            "Пермь",
            "Петропавловск-Камчатский",
            "Петрозаводск",
            "Псков",
            "Ростов-на-Дону",
            "Рязань",
            "Салехард",
            "Самара",
            "Санкт-Петербург",
            "Саранск",
            "Саратов",
            "Смоленск",
            "Ставрополь",
            "Сыктывкар",
            "Тамбов",
            "Тверь",
            "Томск",
            "Тула",
            "Тюмень",
            "Улан-Удэ",
            "Ульяновск",
            "Уфа",
            "Хабаровск",
            "Ханты-Мансийск",
            "Чебоксары",
            "Челябинск",
            "Черкесск",
            "Чита",
            "Элиста",
            "Южно-Сахалинск",
            "Якутск",
            "Ярославль"
    );

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity() {
        String city = CITIES.get(new Random().nextInt(CITIES.size()));
        return city;
    }

    public static String generateName(Faker faker) {
        String name = faker.name().firstName() + " " + faker.name().lastName();
        return name;
    }

    public static String generatePhone(Faker faker) {
        String phone = faker.numerify("+7 (9##) ###-##-##");
        return phone;
    }

    public static class Registration {
        private static Faker faker;

        private Registration() {

        }

        public static UserInfo generateUser(String Locale) {
            faker = new Faker(new Locale(Locale));
            UserInfo user = new UserInfo(
                    generateCity(),
                    generateName(faker),
                    generatePhone(faker));
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
