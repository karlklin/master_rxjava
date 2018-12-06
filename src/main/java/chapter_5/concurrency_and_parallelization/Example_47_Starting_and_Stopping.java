package chapter_5.concurrency_and_parallelization;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example_47_Starting_and_Stopping {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Scheduler scheduler = Schedulers.from(executor);

        Observable<Long> observable = Observable.interval(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(scheduler);

        observable.subscribe(s -> System.out.println("Observer_1 : " + s + " : " + Thread.currentThread().getId()));
        observable.subscribe(s -> System.out.println("Observer_2 : " + s + " : " + Thread.currentThread().getId()));

        Thread.sleep(3000);

        System.out.println("=== Shutting down ===");
        scheduler.shutdown();

        Thread.sleep(3000);
    }

}
