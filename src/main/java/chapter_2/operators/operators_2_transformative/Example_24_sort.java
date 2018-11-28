package chapter_2.operators.operators_2_transformative;

import io.reactivex.Observable;

import java.util.Comparator;

public class Example_24_sort {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== sort ascending === ");
        Observable.just(1, 2, 3, 5, 1, 2, 4, 22, 2, 55)
                .sorted()
                .subscribe(System.out::println);

        System.out.println("=== sort descending === ");
        Observable.just(1, 2, 3, 5, 1, 2, 4, 22, 2, 55)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);
    }
}
