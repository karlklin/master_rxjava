package chapter_5.concurrency_and_parallelization;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example_47_ExecutorService {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Scheduler scheduler = Schedulers.from(executor);

        Observable<String> observable = Observable.just("item_1", "item_2", "item_3", "item_4", "item_5")
                .subscribeOn(scheduler);

        observable.subscribe(s -> System.out.println("Observer_1 : " + s + " : " + Thread.currentThread().getId()));
        observable.subscribe(s -> System.out.println("Observer_2 : " + s + " : " + Thread.currentThread().getId()));

        Thread.sleep(3000);
    }

}
