package chapter_5.concurrency_and_parallelization;

import io.reactivex.Observable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example_44_blockingSubscribe {

    public static void main(String[] args) throws InterruptedException {
        // blockingSubscribe blocks all Observers

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(createNewWorkingThread("thread_1"));

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .take(5)
                .blockingSubscribe(aLong -> System.out.println("observer 1: " + aLong),
                        Throwable::printStackTrace, () -> System.out.println("observer 1 is DONE"));

        // Main Thread is blocked until the Blocking Subscribers are DONE
        executor.submit(createNewWorkingThread("thread_2"));

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .take(5)
                .blockingSubscribe(aLong -> System.out.println("observer 2: " + aLong),
                        Throwable::printStackTrace, () -> System.out.println("observer 2 is DONE"));
    }

    private static Runnable createNewWorkingThread(String name) {
        return () -> {
            do {
                System.out.println("Another working thread: name=" + name + ", thread=" + Thread.currentThread().getName());
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        };
    }

}
