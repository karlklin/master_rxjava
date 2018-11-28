package chapter_2.operators.operators_3_reducing;

import io.reactivex.Observable;

public class Example_26_reduce {

    public static void main(String[] args) {
        System.out.println("=== reduce ===");
        Observable.just("qs1=1", "qs2=2", "qs3=3", "qs4=4")
                .reduce((s, s2) -> s + "&" + s2)
                .subscribe(System.out::println);
    }
}
