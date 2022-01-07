package test;

import java.util.Optional;


public class optionalTEST {


    public static void whenCreatesEmptyOptional_thenCorrect(){
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());
    }

    public static void givenNonNull_whenCreateNonNullNullable_thenCorrect(){
        String name = "testAbv";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.isPresent());
    }

    public static void givenNull_whenCreatesNullable_thenCorrect(){
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);

    }

    public void givenOptional_whenIsPresentWorks_thenCorrect(){

    }


    public static void main(String[] args) {
        whenCreatesEmptyOptional_thenCorrect();
        givenNonNull_whenCreateNonNullNullable_thenCorrect();

        String name = "test";
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt.isPresent());

        givenNull_whenCreatesNullable_thenCorrect();



    }
}
