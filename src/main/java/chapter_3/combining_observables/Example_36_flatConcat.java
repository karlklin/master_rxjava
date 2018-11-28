package chapter_3.combining_observables;

import io.reactivex.Observable;

public class Example_36_flatConcat {

    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("Alpha", "Beta", "Omega", "Lambda");

        System.out.println("We could map and then concatMap");
        source1.map(s -> s.split(""))
                .concatMap(strings -> Observable.fromArray(strings))
                .subscribe(System.out::println);

        System.out.println("Or just concatMap directly");
        source1.concatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);
    }

}
