package chapter_2.operators.operators_4_collection;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;

public class Example_28_toList {

    public static void main(String[] args) {
        System.out.println("=== toList ===");

        // Note: toList returns Single!
        Single<List<String>> single = Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4")
                .toList();
        single
                .subscribe(System.out::println);

        System.out.println("=== toList ===");
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4")
                .toSortedList()
                .subscribe(System.out::println);
    }
}
