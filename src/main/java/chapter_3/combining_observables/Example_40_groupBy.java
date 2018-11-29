package chapter_3.combining_observables;

import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.observables.GroupedObservable;

import java.util.Map;

public class Example_40_groupBy {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("red", "green", "black", "blue", "purple",  "brown", "grey");

        Observable<GroupedObservable<Character, String>> groupedObservable = observable.groupBy(s -> s.charAt(0));

        System.out.println("=== Just print out ObservableGroupBy ids ===");
        groupedObservable.subscribe(System.out::println);

        System.out.println("=== Using directly flatMap but then we need to convert Single to Observable ===");
        groupedObservable.flatMap(grouped -> grouped.toList().toObservable())
                .subscribe(System.out::println);

        System.out.println("=== Using flatMapSingle ===");
        groupedObservable.flatMapSingle(grouped -> grouped.toList())
                .subscribe(System.out::println);

        groupedObservable
                .flatMapMaybe(grouped -> grouped
                        .reduce((groupItem, groupItem2) -> groupItem + ", " + groupItem2)
                        .map(reducedGroup -> grouped.getKey() + ":" + reducedGroup))
                .subscribe(System.out::println);
    }

}
