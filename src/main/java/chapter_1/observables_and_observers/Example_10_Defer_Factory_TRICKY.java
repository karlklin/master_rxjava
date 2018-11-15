package chapter_1.observables_and_observers;

import io.reactivex.Observable;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Example_10_Defer_Factory_TRICKY {

    static int start = 1;
    static int count = 5;

    public static void main(String[] args) throws Exception {

        Supplier<String> supplier = () -> String.valueOf(count);
        Callable<String> callable = () -> String.valueOf(count);
        Supplier<String> supplier2 = new Supplier<String>() {
            @Override
            public String get() {
                return String.valueOf(count);
            }
        };

        // Here we are creating Range Observable immediately
        Observable<Integer> standardObservable = Observable.range(start, count);

        // Here we are deferring creation of Range Observable
        Observable<Integer> deferredObservable = Observable.defer(() -> Observable.range(start, count));
        Observable<String> standardObservable2 = Observable.create(emitter -> emitter.onNext(String.valueOf(count)));

        count = 10;

        standardObservable.subscribe(integer -> System.out.println("standard observer i: " + integer));
        standardObservable2.subscribe(integer -> System.out.println("standard observer count: " + integer));
        deferredObservable.subscribe(integer -> System.out.println("deferred observer i: " + integer));

        System.out.println("callable=" + callable.call());
        System.out.println("supplier=" + supplier.get());
        System.out.println("supplier2=" + supplier2.get());
    }
}
