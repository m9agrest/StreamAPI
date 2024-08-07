package ru.mina987;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearnStreamAPI {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
        //task7();
        //task8();
        //task9();
        //task10();
    }
    static void task1(){
        //Напишите программу, которая создает список чисел от 1 до 100. Используйте Stream API, чтобы отфильтровать только четные числа и вывести их на экран.
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= 100; i++){
            nums.add(i);
        }
        nums.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }
    static void task2(){
        //Создайте список строк, представляющих имена людей. Используя Stream API, преобразуйте все имена в верхний регистр и выведите результат на экран.
        List<String> names = Arrays.asList("Иван", "Людмила", "Виктор", "Светлана", "Екатерина", "Роза", "Михаил", "Александр", "Максим", "Олег");
        names.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
    }
    static void task3(){
        //Напишите программу, которая создает список объектов Person с полями name (строка) и age (целое число). 
        //Используйте Stream API для сортировки списка по возрасту и выведите отсортированный список на экран.
        List<Person> pers = Arrays.asList(
                new Person("Иван", 34),
                new Person("Людмила", 24),
                new Person("Виктор", 54),
                new Person("Светлана", 35),
                new Person("Екатерина", 67),
                new Person("Роза", 23),
                new Person("Михаил", 45)
        );
        
        pers.stream().sorted(Comparator.comparingInt(Person::getAge)).forEach(System.out::println);
        
    }
    static class Person {
        private String name;
        private int age;
        public int getAge(){
            return age;
        }
        public void setAge(int value){
            age = value;
        }
        public String getName(){
            return name;
        }
        public void setName(String value){
            name = value;
        }
        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString(){
            return "name: " + name + ", age: " + age + ";";
        }
    }
    static void task4(){
        //Cоздайте список объектов Person, содержащих имена и возраста. Используйте Stream API для группировки людей по возрасту и выведите количество людей в каждой возрастной группе.
        List<Person> pers = Arrays.asList(
                new Person("Иван", 45),
                new Person("Людмила", 24),
                new Person("Виктор", 54),
                new Person("Светлана", 24),
                new Person("Екатерина", 67),
                new Person("Роза", 54),
                new Person("Михаил", 45)
        );
        pers.stream().collect(Collectors.groupingBy(Person::getAge)).forEach((i, l)->{
            System.out.println(i);
            l.stream().forEach(e -> {
                System.out.println(e.getName());
            });
        });
    }
    static void task5(){
        //Напишите программу, которая создает список чисел и использует Stream API для вычисления суммы всех чисел в списке.
        List<Integer> nums = Arrays.asList(12,3,56,23,87,12,343);
        System.out.println(nums.stream().mapToInt(Integer::intValue).sum());
    }
    static void task6(){
        //Создайте список чисел и используйте Stream API для нахождения максимального значения в этом списке. Выведите максимальное значение на экран.
        List<Integer> nums = Arrays.asList(12,3,56,23,87,12,343);
        System.out.println(nums.stream().mapToInt(Integer::intValue).max());
    }
    static void task7(){
        //Напишите программу, которая создает список строк с дубликатами. Используя Stream API, уберите дубликаты и выведите уникальные строки на экран.
        List<Integer> nums = Arrays.asList(12,343,12,56,23,56,12,343);
        nums.stream().collect(Collectors.toSet()).forEach(System.out::println);
    }
    static void task8(){
        //Создайте текстовый файл, содержащий список имен. Используйте Stream API для чтения файла и вывода имен, которые начинаются с буквы "A".
        List<String> names = Arrays.asList("Иван", "Людмила", "Виктор", "Светлана", "Екатерина", "Роза", "Михаил", "Александр", "Максим", "Олег");
        names.stream().filter(s -> (s.length() > 0 && s.charAt(0) == 'А')).forEach(System.out::println);
    }
    static void task9(){
        //Создайте список строк и используйте Stream API для объединения всех строк в одну, разделяя их запятыми. Выведите результат на экран.
        List<String> names = Arrays.asList("Иван", "Людмила", "Виктор", "Светлана", "Екатерина", "Роза", "Михаил", "Александр", "Максим", "Олег");
        System.out.println(names.stream().collect(Collectors.joining(",")));
    }
    static void task10(){
        //Напишите программу, которая создает список строк, представляющих названия книг. Используя Stream API, найдите и выведите все названия книг, которые содержат слово "Java".
        List<String> names = Arrays.asList("c++", "Java чайников", "изучаем JavaScript");
        String regex = "^.*(Java).*$";
        names.stream().filter(s -> s.matches(regex)).forEach(System.out::println);
    }
}
