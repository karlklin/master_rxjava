package chapter_1.observables_and_observers;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Example_1_Create_Factory {

    public static void main(String[] args) {
        Observable<String> myObservable = Observable.create(emitter -> {
            try {
                emitter.onNext("first value");
                emitter.onNext("second value");
                emitter.onNext("third value");
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });

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
                System.out.println("completed!");
            }
        };

        myObservable.subscribe(myObserver);
    }

}
