package chapter_3.combining_observables;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class Example_40_groupBy {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("red", "green", "black", "blue", "purple",  "brown", "grey");

        Observable<GroupedObservable<Character, String>> groupedObservable = observable.groupBy(s -> s.charAt(0));

        System.out.println("=== Not very useful: only prints out ObservableGroupBy ids ===");
        groupedObservable.subscribe(System.out::println);

        System.out.println("=== Printing out keys ===");
        groupedObservable.map(group -> group.getKey())
                .subscribe(System.out::println);

        System.out.println("=== Printing out values: Using directly flatMap but then we need to convert Single to Observable ===");
        groupedObservable.flatMap(group -> group.toList().toObservable())
                .subscribe(System.out::println);

        System.out.println("=== Printing out values: Using flatMapSingle ===");
        groupedObservable.flatMapSingle(grouped -> grouped.toList())
                .subscribe(System.out::println);

        groupedObservable
                .flatMapMaybe(group -> formatGroup(group))
                .subscribe(System.out::println);
    }

    private static Maybe<String> formatGroup(GroupedObservable<Character, String> group) {
        return group
                .reduce((groupItem, groupItem2) -> groupItem + ", " + groupItem2)
                .map(reducedGroup -> group.getKey() + ":" + reducedGroup);
    }

}
