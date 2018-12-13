package chapter_8.transformers_and_operators;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public class Example_57_transformers {

    public static void main(String[] args) {
        Observable.just("alpha", "beta", "gamma")
                .compose(toLengthGreaterThen3())
                .subscribe(System.out::println);

        Observable.just("alpha2", "beta2", "gamma2")
                .compose(toLengthGreaterThen3())
                .subscribe(System.out::println);
    }

    private static ObservableTransformer<String, Integer> toLengthGreaterThen3() {
        return upstream -> upstream.map(String::length)
                .filter(length -> length > 3);
    }

}
