package chapter_1.observables_and_observers;

import io.reactivex.Observable;

import static java.lang.System.out;

public class Example_4_Cold_Observables {

    public static void main(String[] args) {
        // Just Observable is COLD Observable
        Observable<String> justObservable = Observable.just("first value lambda", "second value lambda", "third value lambda");

        justObservable.subscribe(s -> System.out.println("observer 1:" + s));
        justObservable.subscribe(s -> System.out.println("observer 2:" + s));

        // Observable created by from array or iterable factory is COLD Observable as well
        Observable<String> listObservable = Observable.fromArray("first value lambda", "second value lambda", "third value lambda");
        listObservable.subscribe(s -> System.out.println("observer 3:" + s));
        listObservable.subscribe(s -> System.out.println("observer 4:" + s));
    }

}
