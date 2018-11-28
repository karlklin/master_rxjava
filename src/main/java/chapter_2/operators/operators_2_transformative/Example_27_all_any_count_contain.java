package chapter_2.operators.operators_2_transformative;

import io.reactivex.Observable;

public class Example_27_all_any_count_contain {

    public static void main(String[] args) {
        System.out.println("=== all ===");
        Observable.just("qs1=1", "qs2=2", "qs3=3", "qs4=4")
                .all(s -> s.startsWith("qs"))
                .subscribe(System.out::println);

        System.out.println("=== any ===");
        Observable.just("qs1=1", "qs2=2", "qs3=3", "qs4=4")
                .any(s -> s.contains("qs3"))
                .subscribe(System.out::println);

        System.out.println("=== count ===");
        Observable.just("qs1=1", "qs2=2", "qs3=3", "qs4=4")
                .count()
                .subscribe(System.out::println);

        System.out.println("=== contains ===");
        Observable.just("qs1=1", "qs2=2", "qs3=3", "qs4=4")
                .contains("qs3=3")
                .subscribe(System.out::println);
    }
}
