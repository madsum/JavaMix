package com.ma.home;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListExample {

    public static void createStream_whenFindFirstResultIsPresent_thenCorrect() {

        List<String> list = Arrays.asList("A", "B", "C", "D");

        Optional<String> result = list.stream().findFirst();

        System.out.println((result.isPresent()));
        System.out.println(result.get());
    }

    public static boolean listContainsTestWord( String search) {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        if (list != null && search != null) {
            return list.stream().anyMatch(search::equalsIgnoreCase);
        }
        return false;
    }


    public static void main(String[] args) {

       // createStream_whenFindFirstResultIsPresent_thenCorrect();
        System.out.println(listContainsTestWord("x"));

    }
}
