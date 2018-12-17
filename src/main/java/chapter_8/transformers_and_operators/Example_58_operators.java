package chapter_8.transformers_and_operators;

import io.reactivex.Observable;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.stream.Stream;

public class Example_58_operators {

    public static void main(String[] args) {
        String default0 = Stream.of("1")
                .filter(s -> Boolean.FALSE)
                .findAny()
                .orElse("default0");

        System.out.println(default0);

        Observable.just("item")
                .filter(s -> Boolean.FALSE)
                .first("default1")
                .subscribe(System.out::println);

        Observable.empty()
                .first("default2")
                .subscribe(System.out::println);

        System.out.println("*** EXAMPLE1 ***");

        Observable.just("item_1", "item_2", "item_3")
                .lift(firstOperator("DEFAULT!"))
                .subscribe(s -> System.out.println(s), Throwable::printStackTrace, () -> System.out.println("onComplete"));

        System.out.println("*** EXAMPLE2 ***");

        Observable.just("item_1", "item_2", "item_3")
                .filter(s -> Boolean.FALSE)
                .lift(firstOperator("DEFAULT!"))
                .subscribe(s -> System.out.println(s), Throwable::printStackTrace, () -> System.out.println("onComplete"));

        System.out.println("*** EXAMPLE3 ***");

        Observable.just("a", "ab", "abc", "abcd")
                .lift(toLengthOperator())
                .subscribe(System.out::println);
    }

    private static ObservableOperator<String, String> firstOperator(String defaultValue) {
        return observer -> new Observer<String>() {
            boolean empty = true;

            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("=== onSubscribe ===");
                observer.onSubscribe(d);
            }

            @Override
            public void onNext(String value) {
                System.out.println("=== onNext ===");

                empty = false;
                observer.onNext(value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("=== onError ===");

                observer.onError(e);
            }

            @Override
            public void onComplete() {
                System.out.println("=== onComplete ===");

                if (empty) {
                    observer.onNext(defaultValue);
                } else {
                    observer.onComplete();
                }
            }
        };
    }

    private static ObservableOperator<Integer, String> toLengthOperator() {
        return observer -> new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                observer.onSubscribe(d);
            }

            @Override
            public void onNext(String s) {
                observer.onNext(s.length());
            }

            @Override
            public void onError(Throwable e) {
                observer.onError(e);
            }

            @Override
            public void onComplete() {
                observer.onComplete();;
            }
        };
    }

}
