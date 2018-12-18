package testing_and_debugging;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

public class Example_63_debugging {

    @Test
    public void debugging_using_action_operators() {
        TestObserver<String> observer = new TestObserver();
        Single<String> source = Single.just("8329382-Karol-984394dksjd-Ola-dlskfdslfd932-Tadzik-dslfkds423432fds-Malina");

        source.doOnSuccess(s -> System.out.println("all:" + s))
                .flatMapObservable(s -> Observable.fromArray(s.split("-")))
                .doOnNext(s -> System.out.println("flatMap:" + s))
                .filter(s -> s.matches("[A-Za-z]+"))
                .doOnNext(s -> System.out.println("filter:" + s))
                .subscribe(observer);

        observer.assertValues("Karol", "Ola", "Tadzik", "Malina");
    }

}
