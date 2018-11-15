package chapter_1.observables_and_observers;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;

public class Example_12_Maybe_Observable {

    public static void main(String[] args) {
        // Comparing to SingleObservable it has also onComplete as it might not contain any items

        MaybeObserver<String> maybeObserver = new MaybeObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(String s) {
                System.out.println("returns first item");
            }

            @Override
            public void onComplete() {
                System.out.println("called if there is single or none items");
            }

            @Override
            public void onError(Throwable e) {

            }
        };

        System.out.println(maybeObserver.toString());
    }
}
