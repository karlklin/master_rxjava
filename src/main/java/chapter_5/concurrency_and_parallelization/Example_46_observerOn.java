package chapter_5.concurrency_and_parallelization;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Example_46_observerOn {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable = Observable.just("item_1", "item_2", "item_3", "item_4", "item_5")
                .subscribeOn(Schedulers.computation());

        // When we would like to change type of Scheduler

        Observable<String> observable2 = observable.observeOn(Schedulers.io());

        observable2.subscribe(s -> System.out.println("Observer_1 : " + s + " : " + Thread.currentThread().getId()));
        observable2.subscribe(s -> System.out.println("Observer_2 : " + s + " : " + Thread.currentThread().getId()));

        Thread.sleep(3000);
    }

}
