package chapter_1.observables_and_observers;

import io.reactivex.Observable;

public class Example_8_Empty_Never_Future_Factories {

    public static void main(String[] args) {
        // Empty and immediately completed
        Observable.empty()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed empty!"));

        // Never completed
        Observable.never()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed never!"));

        /* Observable.fromFuture(future)
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed never!")); */
    }
}
