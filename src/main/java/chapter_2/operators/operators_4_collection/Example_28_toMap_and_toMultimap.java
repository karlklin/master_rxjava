package chapter_2.operators.operators_4_collection;

import io.reactivex.Observable;

import java.util.HashMap;
import java.util.HashSet;

public class Example_28_toMap_and_toMultimap {

    public static void main(String[] args) {
        System.out.println("=== toMap ===");
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4", "qs1=100")
                .toMap(s -> s.substring(0, s.indexOf("=")))
                .subscribe(System.out::println);

        System.out.println("=== toMap specifying key and value and how to create the result ===");
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4")
                .toMap(s -> s.substring(0, s.indexOf("=")), s -> s.substring(s.indexOf("=") + 1, s.length()), HashMap::new)
                .subscribe(System.out::println);

        System.out.println("=== toMultimap ===");
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4", "qs1=2")
                .toMultimap(s -> s.substring(0, s.indexOf("=")))
                .subscribe(System.out::println);

        System.out.println("=== toMultimap specifying key and value and how to create the result ===");
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4", "qs1=2")
                .toMultimap(s -> s.substring(0, s.indexOf("=")), s -> s.substring(s.indexOf("=") + 1, s.length()), () -> new HashMap<>())
                .subscribe(System.out::println);
    }
}
