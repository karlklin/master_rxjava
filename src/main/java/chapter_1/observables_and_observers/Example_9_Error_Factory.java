package chapter_1.observables_and_observers;

import io.reactivex.Observable;

public class Example_9_Error_Factory {

    public static void main(String[] args) {
        // 1 and 2 are equivalents. 3 emits value and then throws exception. In all cases onCompleted is not executed.

        // 1 Error Factory
        Observable.error(new RuntimeException("My exception 1"))
                .subscribe(System.out::println, throwable -> System.out.println("exception: " + throwable), () -> System.out.println("Completed 1 empty!"));

        // 2 Using ObservableOnSubscribe
        Observable.create(emitter -> emitter.onError(new RuntimeException("My exception 2")))
                .subscribe(System.out::println, throwable -> System.out.println("exception: " + throwable), () -> System.out.println("Completed 2 empty!"));

        // 3 Using ObservableOnSubscribe
        Observable.create(emitter -> {
            emitter.onNext("first value before exception");
            emitter.onError(new RuntimeException("My Exception 3"));
        }).subscribe(System.out::println, throwable -> System.out.println("exception: " + throwable), () -> System.out.println("Completed 3 empty!"));

    }
}
