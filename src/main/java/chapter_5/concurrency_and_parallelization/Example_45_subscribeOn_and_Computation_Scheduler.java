package chapter_5.concurrency_and_parallelization;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Example_45_subscribeOn_and_Computation_Scheduler {

    public static void main(String[] args) throws InterruptedException {
        // Schedulers are used to create new threads on which Observers will work on
        // - Scheduler.computation - for complex computation that is using CPU and when we don't know how long
        // - Scheduler.IO - for dealing data-base, reading files and web requests (the threads are not destroyed)
        // - Scheduler.newThread - thread is destroyed on complete
        // - Scheduler.Single - for sequential computation but detached from main thread

        // usingSchedulers();
        usingStandardApproach();
    }

    private static void usingSchedulers() throws InterruptedException {
        Observable<String> observable = Observable.just("item_1", "item_2", "item_3", "item_4", "item_5")
               .subscribeOn(Schedulers.computation());

        observable.subscribe(s -> {
            Thread.sleep(7000);
            System.out.println("Observer_1 : computing...");
            System.out.println("Observer_1 : " + s + " : " + Thread.currentThread().getId());

        });

        observable.subscribe(s -> {
            Thread.sleep(1000);
            System.out.println("Observer_2 : computing...");
            System.out.println("Observer_2 : " + s + " : " + Thread.currentThread().getId());
        });

        Thread.sleep(10000);
    }

    @SuppressWarnings("unused")
    private static void usingStandardApproach() throws InterruptedException {
        Observable<String> observable = Observable.just("item_1", "item_2", "item_3", "item_4", "item_5")
                .publish()
                .autoConnect(2);

        observable.subscribe(s -> {
            Thread.sleep(7000);
            System.out.println("Observer_1 : computing...");
            System.out.println("Observer_1 : " + s + " : " + Thread.currentThread().getId());

        });

        observable.subscribe(s -> {
            Thread.sleep(1000);
            System.out.println("Observer_2 : computing...");
            System.out.println("Observer_2 : " + s + " : " + Thread.currentThread().getId());
        });

        Thread.sleep(10000);
    }

}
