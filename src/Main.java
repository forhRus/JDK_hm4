import base.Employee;
import base.EmployeeDirectory;
import base.Name;
import base.Phone;
import exceptions.EmployeeAlAddedException;
import exceptions.EmployeeIsNotException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static Phone phone = new Phone();
    static Random random = new Random();

    public static void main(String[] args) {
        EmployeeDirectory directory1, directory2, directory3;
        try {
            //пустой конструктор
            directory1 = new EmployeeDirectory();

            // создаём сотрудника
            int id = 1;
            String name = Name.getRandomName();
            String number = phone.getPhone();
            int seniority = random.nextInt(5);
            Employee employee = new Employee(id, name, number, seniority);

            directory1.add(employee);
            // ОШИБКА! Сотрудник с id:1 уже добавлен в справочник.
            // directory1.add(new Employee(1, name, number, seniority));

            // генерируем список сотрудников с уникальными id
            List<Employee>list = createList(20);
            // создаём справочник из списка сотрудников
            directory2 = new EmployeeDirectory(list);

            // создаём справочник из другого справочника
            directory3 = new EmployeeDirectory(directory2);

            System.out.println("Тестовый справочник");
            showDirectory(directory2); // тестовый справочник

            System.out.println("Поиск сотрудников по id");
            System.out.println(directory1.getEmployee(1));
            System.out.println();

            // ОШИБКА! Сотрудник с id:2 в справочнике отсутствует.
            // System.out.println(directory1.getEmployee(2));

            System.out.println("Список телефонов сотрудников по имени");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Попытка №"+i);
                directory2.showEmployeesPhone(Name.getRandomName());
            }
            System.out.println();

            System.out.println("Поиск сотрудников по стажу");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Попытка №"+i);
                int sen = random.nextInt(5);
                directory3.showEmployeeBySeniority(sen);
            }

        } catch (EmployeeAlAddedException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeIsNotException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Employee> createList(int n) throws EmployeeAlAddedException {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = Name.getRandomName();
            String number = phone.getPhone();
            int seniority = random.nextInt(5);
            list.add(new Employee(i + 1, name, number, seniority));
        }
        return list;
    }

    private static void showDirectory(EmployeeDirectory directory){
        for (Employee e:directory) {
            System.out.println(e);
        }
        System.out.println();
    }

}