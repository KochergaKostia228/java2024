package com.company.ex_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Corporation corporation = new Corporation();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Редактировать сотрудника");
            System.out.println("3. Удалить сотрудника");
            System.out.println("4. Найти сотрудника по фамилии");
            System.out.println("5. Вывести сотрудников по возрасту");
            System.out.println("6. Вывести сотрудников по первой букве фамилии");
            System.out.println("7. Вывести всех сотрудников");
            System.out.println("8. Сохранить данные");
            System.out.println("9. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Для поглощения лишнего символа новой строки

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Введите фамилию: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Введите возраст: ");
                    int age = scanner.nextInt();
                    corporation.addEmployee(firstName, lastName, age);
                    break;
                case 2:
                    System.out.print("Введите фамилию сотрудника для редактирования: ");
                    String editLastName = scanner.nextLine();
                    System.out.print("Введите новое имя: ");
                    String newFirstName = scanner.nextLine();
                    System.out.print("Введите новую фамилию: ");
                    String newLastName = scanner.nextLine();
                    System.out.print("Введите новый возраст: ");
                    int newAge = scanner.nextInt();
                    corporation.editEmployee(editLastName, newFirstName, newLastName, newAge);
                    break;
                case 3:
                    System.out.print("Введите фамилию сотрудника для удаления: ");
                    String deleteLastName = scanner.nextLine();
                    corporation.deleteEmployee(deleteLastName);
                    break;
                case 4:
                    System.out.print("Введите фамилию для поиска: ");
                    String searchLastName = scanner.nextLine();
                    Employee emp = corporation.searchByLastName(searchLastName);
                    if (emp != null) {
                        System.out.println("Найден сотрудник: " + emp);
                    } else {
                        System.out.println("Сотрудник не найден.");
                    }
                    break;
                case 5:
                    System.out.print("Введите возраст для поиска: ");
                    int searchAge = scanner.nextInt();
                    corporation.listEmployeesByAge(searchAge);
                    break;
                case 6:
                    System.out.print("Введите букву для поиска по фамилии: ");
                    char letter = scanner.nextLine().charAt(0);
                    corporation.listEmployeesByFirstLetter(letter);
                    break;
                case 7:
                    corporation.listAllEmployees();
                    break;
                case 8:
                    corporation.saveEmployeesToFile();
                    System.out.println("Данные сохранены.");
                    break;
                case 9:
                    corporation.saveEmployeesToFile();
                    System.out.println("Данные сохранены. Выход из программы.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}
