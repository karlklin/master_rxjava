package chapter_1.observables_and_observers;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class Example_11_Single_Observable {

    public static void main(String[] args) {
        SingleObserver<String> singleObserver = new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(String s) {
                System.out.println("Single Observer:" + s);
            }

            @Override
            public void onError(Throwable e) {

            }
        };

        // first returns Single Observable
        Observable.just("first item", "second item")
                .first("default").subscribe(singleObserver);

        Observable.just("first item", "second item")
                .first("default").subscribe(s -> System.out.println("Second observer:" + s));
    }
}
