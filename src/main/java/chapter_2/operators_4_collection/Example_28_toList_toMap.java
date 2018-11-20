package chapter_2.operators_4_collection;

import io.reactivex.Observable;

public class Example_28_toList_toMap {

    public static void main(String[] args) {
        System.out.println("=== toList ===");
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4")
                .toList()
                .subscribe(System.out::println);

        System.out.println("=== toList ===");
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4")
                .toSortedList()
                .subscribe(System.out::println);

        System.out.println("=== toMap ===");
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4", "qs1=2")
                .toMap(s -> s.substring(0, s.indexOf("=")))
                .subscribe(System.out::println);

        System.out.println("=== toMultimap ===");
        Observable.just("qs1=1", "qs7=2", "qs3=3", "qs4=4", "qs1=2")
                .toMultimap(s -> s.substring(0, s.indexOf("=")))
                .subscribe(System.out::println);
    }
}
