package chapter_2.operators.operators_4_collection;

import io.reactivex.Observable;

public class Example_32_action_do_operators {

    public static void main(String[] args) throws InterruptedException {
        // not sure why onError is not executed
        System.out.println("=== retry  ===");
        Observable.just(1, 2, 3, 0, 4, 5, 6, 7)
                .doOnNext(integer -> System.out.println("Next is coming:" + integer))
                .doOnComplete(() -> System.out.println("Complete :)"))
                .doOnError(throwable -> System.out.println("Error is coming"))
                .doAfterNext(integer -> System.out.println("Element " + integer + " processed"))
                .map(integer -> 10 / integer)
                .subscribe(System.out::println);

        Thread.sleep(5000);
    }
}
