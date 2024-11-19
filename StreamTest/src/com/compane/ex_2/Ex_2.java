package com.compane.ex_2;

import java.util.List;
import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> product = List.of(
                new Product("Молоко", "Молочные продукты"),
                new Product("Хліб", "Віпечка"),
                new Product("Масло", "Молочні продукти"),
                new Product("Яблоко", "Фрукти"),
                new Product("Молоко", "Молочні продукти"),
                new Product("Сир", "Молочні продукти"),
                new Product("Торт", "Випічка"),
                new Product("Молоко", "Молочні продукти")
        );

        //1
        System.out.println("Всі продукти:");
        product.stream()
                .map(Product::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //2
        System.out.println("Всі продукти меньше ніж 5 символів:");
        product.stream()
                .map(Product::getName)
                .filter(x -> x.length() < 5)
                .forEach(System.out::println);

        System.out.println(" ");

        //3
        System.out.println("\nВведіть назву продукта для пошука:");
        String productNameToCount = scanner.nextLine();

        long nameToCount = product.stream()
                .map(Product::getName)
                .filter(x -> x.equalsIgnoreCase(productNameToCount))
                .count();

        System.out.println("Кількість продуктів з такою назвою: " + nameToCount);

        //4
        System.out.println("\nВведіть назву продукта для пошука:");
        Character productCharToCount = scanner.nextLine().charAt(0);

        long charToCount = product.stream()
                .map(Product::getName)
                .filter(x -> x.toLowerCase().startsWith(String.valueOf(productCharToCount).toLowerCase()))
                .count();

        System.out.println("Кількість продуктів з введеною вами буквою на початку: " + charToCount);

        System.out.println(" ");

        //5
        System.out.println("Всі молочні продукти:");
        product.stream()
                .filter(x -> x.getCategory().equals("Молочні продукти"))
                .map(Product::getName)
                .forEach(System.out::println);
    }

    static class Product {
        private String name;
        private String category;

        public Product(String name, String category) {
            this.name = name;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }
    }
}
