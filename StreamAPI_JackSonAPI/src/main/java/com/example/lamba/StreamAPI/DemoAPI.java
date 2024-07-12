package com.example.lamba.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoAPI {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> result = list.stream().filter(integer -> integer % 2 == 0)
                .map(integer -> Math.sqrt(integer)).peek(aDouble -> System.out.println(aDouble)).collect(Collectors.toList());
        //ở bên lambda (ghép vào tùy trg hợp)
    }
}
