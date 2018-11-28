package chapter_2.operators.operators_2_transformative;

import io.reactivex.Observable;

public class Example_25_repeat {

    public static void main(String[] args) {
        System.out.println("=== sort and then repeat twice === ");
        Observable.just(1, 2, 3, 5, 1, 2, 4, 22, 2, 55)
                .sorted()
                .repeat(2)
                .subscribe(System.out::println);

        System.out.println("=== repeat twice and then sort === ");
        Observable.just(1, 2, 3, 5, 1, 2, 4, 22, 2, 55)
                .repeat(2)
                .sorted()
                .subscribe(System.out::println);
    }
}
