package chapter_4.multicasting;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

import javax.xml.bind.ValidationEvent;
import java.util.concurrent.TimeUnit;

public class Example_41_autoconnect {

    public static void main(String[] args) throws InterruptedException {
        // Multi-casting or hot observable emits value to all subscribes at the same time
        // after connect() is invoked.

        // In case of connect() when new Observer is subscribing and will receive emitters since now:
        // http://reactivex.io/documentation/operators/publish.html

        // When autoConnect is used will start emissions when the defined numbers of observers subscribe.
        // When other observers start subscribing will receive emissions since now.

        // So there is small difference between Auto-Connect and Connect. Use auto-connect when we know what is the desired
        // number of observers that we will start emission so we don't have to call it manually.

        // E.g. when on the lecture there is at least 15 students needs to start a lecture => autoConnect

        // On meeting when we are waiting for given stakeholders and then we will start emissions => connect based
        // on condition.

        connectExample();
        // autoConnectExample();
    }

    @SuppressWarnings("unused")
    static void autoConnectExample() throws InterruptedException {

        System.out.println("=== auto-connect example ===");
        Observable<Long> hotObservableWithAutoConnect = Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .publish()
                .autoConnect(2);

        System.out.println("=== observer 1 subscribing === ");
        hotObservableWithAutoConnect.subscribe(s -> System.out.println("auto observer 1:" + s));

        System.out.println("=== waiting for observer 2 to subscribe ===");
        Thread.sleep(3000);

        System.out.println("=== observer 2 subscribing ===");
        hotObservableWithAutoConnect.subscribe(s -> System.out.println("auto observer 2:" + s));

        Thread.sleep(3000);

        System.out.println("=== observer 3 subscribing ===");
        hotObservableWithAutoConnect.subscribe(s -> System.out.println("auto observer 3:" + s));

        Thread.sleep(3000);
    }

    static void connectExample() throws InterruptedException {
        System.out.println("=== connect example === ");
        ConnectableObservable<Long> hotObservable = Observable.interval(1000, TimeUnit.MILLISECONDS)
                .publish();

        hotObservable.subscribe(s -> System.out.println("observer 1:" + s));
        hotObservable.subscribe(s -> System.out.println("observer 2:" + s));

        System.out.println("=== awaiting connect() ===");
        Thread.sleep(3000);

        hotObservable.connect();
        Thread.sleep(3000);

        System.out.println("=== observer 3 starts subscribing ===");
        hotObservable.subscribe(s -> System.out.println("observer 3:" + s));

        Thread.sleep(3000);
    }
}
