package chapter_1.observables_and_observers;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Example_5_Hot_Observable_using_Connected_Observables {

    public static void main(String[] args) {
        // To change COLD Observable to HOT one we need to use ConnectableObservable: publish & connect
        Observable<String> justObservable = Observable.just("first value lambda", "second value lambda", "third value lambda");

        // ConnectableObservable waits until `connect` method is called before it emits items
        ConnectableObservable<String> hotObservable = justObservable.publish();

        hotObservable.subscribe(s -> System.out.println("observer 1:" + s));
        hotObservable.subscribe(s -> System.out.println("observer 2:" + s));

        hotObservable.connect();
    }

}
