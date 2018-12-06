package chapter_5.concurrency_and_parallelization;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_44_blockingSubscribe {

    public static void main(String[] args) {
        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .take(5)
                .blockingSubscribe(aLong -> System.out.println("observer 1: " + aLong),
                        Throwable::printStackTrace, () -> System.out.println("observer 1 is DONE"));

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .take(5)
                .blockingSubscribe(aLong -> System.out.println("observer 2: " + aLong),
                        Throwable::printStackTrace, () -> System.out.println("observer 2 is DONE"));
    }

}
