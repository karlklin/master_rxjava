package chapter_2.operators_2_transformative;

import io.reactivex.Observable;

public class Example_25_repeat_and_scan {

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

        System.out.println("=== scan === ");
        Observable.just("qs1=1", "qs2=2", "qs3=3", "qs4=4")
                .scan((s, s2) -> s + "&" + s2)
                .subscribe(System.out::println);

        System.out.println("=== scan and last element");
        Observable.just("qs1=1", "qs2=2", "qs3=3", "qs4=4")
                .scan((s, s2) -> s + "&" + s2)
                .lastElement()
                .subscribe(System.out::println);
    }
}
