package chapter_5.concurrency_and_parallelization;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example_47_ExecutorService {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Scheduler scheduler = Schedulers.from(executor);

        Observable<String> observable = Observable.just("item_1", "item_2", "item_3", "item_4", "item_5")
                .subscribeOn(scheduler);

        observable.subscribe(createConsumer("Observer_1 : "));
        observable.subscribe(createConsumer("Observer_2 : "));
        observable.subscribe(createConsumer("Observer_3 : "));

        Thread.sleep(3000);
    }

    private static Consumer<String> createConsumer(String name) {
        return s -> System.out.println(name + s + " : " + Thread.currentThread().getId());
    }

}
