package chapter_2.operators.operators_4_collection;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;

public class Example_29_collect {

    public static void main(String[] args) {
        System.out.println("=== collect to HashSet ===");
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4", "qs1=1")
                .collect(HashSet::new, HashSet::add)
                .subscribe(System.out::println);

        System.out.println("=== collect to HashMap ===");
        Function<String, String> getKey = s -> s.substring(0, s.indexOf("="));
        Function<String, String> getValue = s -> s.substring(s.indexOf("=") + 1, s.length());
        BiConsumer<HashMap<String, String>, String> addMapElement = (map, s) -> map.put(getKey.apply(s), getValue.apply(s));
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4")
                .collect(HashMap::new, addMapElement)
                .subscribe(System.out::println);
    }
}
