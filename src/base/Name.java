package base;

import java.util.Random;

public class Name {
    private static String[] names = {"Сергей", "Иван", "Пётр", "Станислав", "Владимир", "Константин",
            "Олег", "Валерий", "Григорий", "Максим", "Михаил", "Екатерина", "Светлана", "Анна",
            "Ирина", "Марина"};

    public static String getRandomName(){
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }
}
