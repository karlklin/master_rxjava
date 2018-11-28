package chapter_2.operators.operators_2_transformative;

import io.reactivex.Observable;

public class Example_25_scan {

    public static void main(String[] args) {
        System.out.println("=== scan (meaning assemble) === ");
        Observable.just("qs1=1", "qs2=2", "qs3=3", "qs4=4")
                .scan((s1, s2) -> s1 + "&" + s2)
                .subscribe(System.out::println);

        System.out.println("=== scan and last element (meaning assemble)");
        Observable.just("qs1=1", "qs2=2", "qs3=3", "qs4=4")
                .scan((s, s2) -> s + "&" + s2)
                .lastElement()
                .subscribe(System.out::println);
    }
}
