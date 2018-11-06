package chapter_1.observables_and_observers;

import io.reactivex.Observable;

import static java.lang.System.out;

public class Example_3_Lambda_Expression {

    public static void main(String[] args) {
        Observable<String> myObservable = Observable.just("first value lambda", "second value lambda", "third value lambda");
        myObservable.subscribe(out::println, Throwable::printStackTrace, () -> out.println("completed lambda!"));
    }

}
