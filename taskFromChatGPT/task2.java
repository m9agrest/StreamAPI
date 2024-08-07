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
        task4();
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
    }
    
    
}
