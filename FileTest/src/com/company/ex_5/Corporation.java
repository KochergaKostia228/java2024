package com.company.ex_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Corporation {
    private List<Employee> employees;
    private static final String FILE_NAME = "employees.dat"; // Имя файла для сохранения данных

    public Corporation() {
        employees = loadEmployeesFromFile();
    }

    public List<Employee> loadEmployeesFromFile() {
        List<Employee> employeesList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employeesList = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке данных или файл не существует.");
        }
        return employeesList;
    }

    public void saveEmployeesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных.");
        }
    }

    public void addEmployee(String firstName, String lastName, int age) {
        employees.add(new Employee(firstName, lastName, age));
    }

    public void editEmployee(String lastName, String newFirstName, String newLastName, int newAge) {
        for (Employee emp : employees) {
            if (emp.getLastName().equals(lastName)) {
                emp.setFirstName(newFirstName);
                emp.setLastName(newLastName);
                emp.setAge(newAge);
                System.out.println("Данные сотрудника обновлены.");
                return;
            }
        }
        System.out.println("Сотрудник с такой фамилией не найден.");
    }

    public void deleteEmployee(String lastName) {
        employees.removeIf(emp -> emp.getLastName().equals(lastName));
    }

    public Employee searchByLastName(String lastName) {
        for (Employee emp : employees) {
            if (emp.getLastName().equals(lastName)) {
                return emp;
            }
        }
        return null;
    }

    public void listEmployeesByAge(int age) {
        for (Employee emp : employees) {
            if (emp.getAge() == age) {
                System.out.println(emp);
            }
        }
    }

    public void listEmployeesByFirstLetter(char letter) {
        for (Employee emp : employees) {
            if (emp.getLastName().startsWith(String.valueOf(letter))) {
                System.out.println(emp);
            }
        }
    }

    public void listAllEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
