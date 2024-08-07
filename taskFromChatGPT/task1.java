package ru.mina987;

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
        /*
        task8().stream().forEach(i -> {
            System.out.println(i.intValue());
        });
        */
        //task9();
    }
    static void task1(){
        //   - Дан список строк, содержащих различные слова. Отфильтруйте список, оставив только слова, длина которых больше 3 символов, и преобразуйте их в верхний регистр.
        List<String> words = Arrays.asList("apple", "pear", "banana", "v", "kiwi", "grape", "aaa");
        Stream<String> stream = words.stream().filter(s -> s.length() > 3).map(String::toUpperCase);
        stream.forEach(System.out::println);
    }
    static void task2(){
        //   - Дан список чисел. Найдите сумму всех чисел в списке.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        Stream<Integer> stream = numbers.stream();
        System.out.println(stream.mapToInt(Integer::intValue).sum());
        
        /*
        stream = numbers.stream();
        Optional<Integer> sum = stream.reduce((a, b) -> a + b);
        System.out.println(sum.get());
        */
    }
    static void task3(){
        //- Дан список чисел. Отсортируйте список в порядке убывания.
        List<Integer> numbers = Arrays.asList(3, 9, 1, 4, 7);
        //Stream<Integer> stream = numbers.stream().map(i -> -i).sorted().map(i -> -i);
        Stream<Integer> stream = numbers.stream().sorted(Comparator.reverseOrder());
        stream.forEach(System.out::println);
        
    }
    static void task4(){
        // - Дан список строк. Разделите строки на группы по их длине.
        List<String> words = Arrays.asList("apple", "pear", "banana", "kiwi", "grape");
        /*Stream<Integer, List<String>> stream = */
        words.stream().collect(Collectors.groupingBy(String::length)).forEach((i, l) -> {
            System.out.println(i);
            l.stream().forEach(System.out::println);
        });
    }
    static void task5(){
        // - Дан список строк. Подсчитайте, сколько раз каждое слово встречается в списке.
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((s, i)->{
            System.out.println(s + " = " + i);
        });
    }
    static void task6(){
        // Дан список строк. Объедините все строки в одну строку, разделяя их запятыми.
        List<String> words = Arrays.asList("apple", "banana", "kiwi");
        System.out.println(words.stream().collect(Collectors.joining(",")));
    }
    static void task7(){
        // Дан список строк, представляющих имена людей (например, "John Doe"). Отфильтруйте имена, состоящие из двух слов, и преобразуйте их в формат "Doe, John".
        List<String> names = Arrays.asList("John  Doe", "Jane Smith", "Anna", "Mike Tyson");
        names.stream().filter(s -> s.matches("[a-zA-Z]+\\s+[a-zA-Z]+")).map(s -> s.replaceAll("\\s+", ", ")).forEach(System.out::println);
    }
    static List<Integer> task8(){
        //Дан список чисел, содержащий дублирующиеся элементы. Найдите все уникальные числа и верните их в виде списка.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 2, 4, 5);
        /*List<Integer> numbersUnique = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(a -> a.getValue() == 1).map(a -> a.getKey()).collect(Collectors.toList());*/
        
        Set<Entry<Integer, Long>> set = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet();
        List<Integer> numbersUnique = set.stream().filter(a -> a.getValue() == 1).map(a -> a.getKey()).collect(Collectors.toList());
        
        /*
        numbersUnique.stream().forEach(i -> {
            System.out.println(i.intValue());
        });
        */
        
        return numbersUnique;
    }
    static void task9(){
        //Дан список чисел. Найдите максимальное, минимальное значение, среднее значение и сумму всех чисел.
        List<Integer> numbers = Arrays.asList(3, 9, 1, 4, 7, 6, 2, 8);
        IntSummaryStatistics stat =  numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(stat);
    }
}
