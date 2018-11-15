package chapter_1.observables_and_observers;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class Example_13_Completable_Observable {

    public static void main(String[] args) {
        // Completable is only interested when an observable, action or runnable is completed

        Completable.fromObservable(Observable.just("first", "second"))
                .subscribe(() -> System.out.println("Completed Completable 1"));

        Completable.fromRunnable(() -> System.out.println("Runnable finished"))
                .subscribe(() -> System.out.println("Completed Completable 2"));

        Completable.fromAction(() -> System.out.println("Action finished"))
                .subscribe(() -> System.out.println("Completed Completable 3"));
    }
}
