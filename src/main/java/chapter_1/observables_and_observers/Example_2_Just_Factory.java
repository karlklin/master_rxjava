package chapter_1.observables_and_observers;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Example_2_Just_Factory {

    public static void main(String[] args) {
        Observable<String> myObservable = Observable.just("first value", "second value", "third value");

        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("completed 2!");
            }
        };

        myObservable.subscribe(myObserver);
    }

}
