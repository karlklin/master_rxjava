package chapter_3.combining_observables;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.stream.Stream;

public class Example_34_flatMap {

    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("Alpha", "Beta", "Omega", "Lambda");

        System.out.println("If we just map we get Observable of String array");
        source1.map(s -> s.split(""))
                .subscribe(System.out::println);

        System.out.println("We could map and then flatMap");
        source1.map(s -> s.split(""))
                .map(strings -> Observable.fromArray(strings))
                .subscribe(System.out::println);

        System.out.println("Or just flatMap directly");
        source1.flatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);
    }

}
