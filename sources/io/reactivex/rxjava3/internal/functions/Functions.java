package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Function4;
import io.reactivex.rxjava3.functions.Function5;
import io.reactivex.rxjava3.functions.Function6;
import io.reactivex.rxjava3.functions.Function7;
import io.reactivex.rxjava3.functions.Function8;
import io.reactivex.rxjava3.functions.Function9;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

public final class Functions {

    /* renamed from: a  reason: collision with root package name */
    static final Function<Object, Object> f28372a = new Identity();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f28373b = new EmptyRunnable();

    /* renamed from: c  reason: collision with root package name */
    public static final Action f28374c = new EmptyAction();

    /* renamed from: d  reason: collision with root package name */
    static final Consumer<Object> f28375d = new EmptyConsumer();

    /* renamed from: e  reason: collision with root package name */
    public static final Consumer<Throwable> f28376e = new ErrorConsumer();

    /* renamed from: f  reason: collision with root package name */
    public static final Consumer<Throwable> f28377f = new OnErrorMissingConsumer();

    /* renamed from: g  reason: collision with root package name */
    public static final LongConsumer f28378g = new EmptyLongConsumer();

    /* renamed from: h  reason: collision with root package name */
    static final Predicate<Object> f28379h = new TruePredicate();

    /* renamed from: i  reason: collision with root package name */
    static final Predicate<Object> f28380i = new FalsePredicate();

    /* renamed from: j  reason: collision with root package name */
    static final Supplier<Object> f28381j = new NullProvider();

    /* renamed from: k  reason: collision with root package name */
    public static final Consumer<Subscription> f28382k = new MaxRequestSubscription();

    static final class ActionConsumer<T> implements Consumer<T> {
        final Action s;

        ActionConsumer(Action action) {
            this.s = action;
        }

        public void accept(T t) throws Throwable {
            this.s.run();
        }
    }

    static final class Array2Func<T1, T2, R> implements Function<Object[], R> {
        final BiFunction<? super T1, ? super T2, ? extends R> s;

        Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.s = biFunction;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 2) {
                return this.s.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {
        final Function3<T1, T2, T3, R> s;

        Array3Func(Function3<T1, T2, T3, R> function3) {
            this.s = function3;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 3) {
                return this.s.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {
        final Function4<T1, T2, T3, T4, R> s;

        Array4Func(Function4<T1, T2, T3, T4, R> function4) {
            this.s = function4;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 4) {
                return this.s.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {
        private final Function5<T1, T2, T3, T4, T5, R> s;

        Array5Func(Function5<T1, T2, T3, T4, T5, R> function5) {
            this.s = function5;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 5) {
                return this.s.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {
        final Function6<T1, T2, T3, T4, T5, T6, R> s;

        Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.s = function6;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 6) {
                return this.s.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {
        final Function7<T1, T2, T3, T4, T5, T6, T7, R> s;

        Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.s = function7;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 7) {
                return this.s.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {
        final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> s;

        Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.s = function8;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 8) {
                return this.s.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {
        final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> s;

        Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.s = function9;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 9) {
                return this.s.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    static final class ArrayListCapacityCallable<T> implements Supplier<List<T>> {
        final int s;

        ArrayListCapacityCallable(int i2) {
            this.s = i2;
        }

        /* renamed from: a */
        public List<T> get() {
            return new ArrayList(this.s);
        }
    }

    static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {
        final BooleanSupplier s;

        BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
            this.s = booleanSupplier;
        }

        public boolean test(T t) throws Throwable {
            return !this.s.a();
        }
    }

    public static class BoundedConsumer implements Consumer<Subscription> {
        final int s;

        BoundedConsumer(int i2) {
            this.s = i2;
        }

        /* renamed from: a */
        public void accept(Subscription subscription) {
            subscription.request((long) this.s);
        }
    }

    static final class CastToClass<T, U> implements Function<T, U> {
        final Class<U> s;

        CastToClass(Class<U> cls) {
            this.s = cls;
        }

        public U apply(T t) {
            return this.s.cast(t);
        }
    }

    static final class ClassFilter<T, U> implements Predicate<T> {
        final Class<U> s;

        ClassFilter(Class<U> cls) {
            this.s = cls;
        }

        public boolean test(T t) {
            return this.s.isInstance(t);
        }
    }

    static final class EmptyAction implements Action {
        EmptyAction() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class EmptyConsumer implements Consumer<Object> {
        EmptyConsumer() {
        }

        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class EmptyLongConsumer implements LongConsumer {
        EmptyLongConsumer() {
        }

        public void a(long j2) {
        }
    }

    static final class EmptyRunnable implements Runnable {
        EmptyRunnable() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class EqualsPredicate<T> implements Predicate<T> {
        final T s;

        EqualsPredicate(T t) {
            this.s = t;
        }

        public boolean test(T t) {
            return Objects.equals(t, this.s);
        }
    }

    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.Y(th);
        }
    }

    static final class FalsePredicate implements Predicate<Object> {
        FalsePredicate() {
        }

        public boolean test(Object obj) {
            return false;
        }
    }

    static final class FutureAction implements Action {
        final Future<?> s;

        FutureAction(Future<?> future) {
            this.s = future;
        }

        public void run() throws Exception {
            this.s.get();
        }
    }

    enum HashSetSupplier implements Supplier<Set<Object>> {
        INSTANCE;

        /* renamed from: a */
        public Set<Object> get() {
            return new HashSet();
        }
    }

    static final class Identity implements Function<Object, Object> {
        Identity() {
        }

        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class JustValue<T, U> implements Callable<U>, Supplier<U>, Function<T, U> {
        final U s;

        JustValue(U u) {
            this.s = u;
        }

        public U apply(T t) {
            return this.s;
        }

        public U call() {
            return this.s;
        }

        public U get() {
            return this.s;
        }
    }

    static final class ListSorter<T> implements Function<List<T>, List<T>> {
        final Comparator<? super T> s;

        ListSorter(Comparator<? super T> comparator) {
            this.s = comparator;
        }

        /* renamed from: a */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.s);
            return list;
        }
    }

    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        /* renamed from: a */
        public void accept(Subscription subscription) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class NotificationOnComplete<T> implements Action {
        final Consumer<? super Notification<T>> s;

        NotificationOnComplete(Consumer<? super Notification<T>> consumer) {
            this.s = consumer;
        }

        public void run() throws Throwable {
            this.s.accept(Notification.a());
        }
    }

    static final class NotificationOnError<T> implements Consumer<Throwable> {
        final Consumer<? super Notification<T>> s;

        NotificationOnError(Consumer<? super Notification<T>> consumer) {
            this.s = consumer;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Throwable {
            this.s.accept(Notification.b(th));
        }
    }

    static final class NotificationOnNext<T> implements Consumer<T> {
        final Consumer<? super Notification<T>> s;

        NotificationOnNext(Consumer<? super Notification<T>> consumer) {
            this.s = consumer;
        }

        public void accept(T t) throws Throwable {
            this.s.accept(Notification.c(t));
        }
    }

    static final class NullProvider implements Supplier<Object> {
        NullProvider() {
        }

        public Object get() {
            return null;
        }
    }

    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.Y(new OnErrorNotImplementedException(th));
        }
    }

    static final class TimestampFunction<T> implements Function<T, Timed<T>> {
        final Scheduler X;
        final TimeUnit s;

        TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
            this.s = timeUnit;
            this.X = scheduler;
        }

        /* renamed from: a */
        public Timed<T> apply(T t) {
            return new Timed<>(t, this.X.e(this.s), this.s);
        }
    }

    static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final Function<? super T, ? extends K> f28383a;

        ToMapKeySelector(Function<? super T, ? extends K> function) {
            this.f28383a = function;
        }

        /* renamed from: a */
        public void accept(Map<K, T> map, T t) throws Throwable {
            map.put(this.f28383a.apply(t), t);
        }
    }

    static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final Function<? super T, ? extends V> f28384a;

        /* renamed from: b  reason: collision with root package name */
        private final Function<? super T, ? extends K> f28385b;

        ToMapKeyValueSelector(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
            this.f28384a = function;
            this.f28385b = function2;
        }

        /* renamed from: a */
        public void accept(Map<K, V> map, T t) throws Throwable {
            map.put(this.f28385b.apply(t), this.f28384a.apply(t));
        }
    }

    static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final Function<? super K, ? extends Collection<? super V>> f28386a;

        /* renamed from: b  reason: collision with root package name */
        private final Function<? super T, ? extends V> f28387b;

        /* renamed from: c  reason: collision with root package name */
        private final Function<? super T, ? extends K> f28388c;

        ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
            this.f28386a = function;
            this.f28387b = function2;
            this.f28388c = function3;
        }

        /* renamed from: a */
        public void accept(Map<K, Collection<V>> map, T t) throws Throwable {
            Object apply = this.f28388c.apply(t);
            Collection collection = map.get(apply);
            if (collection == null) {
                collection = (Collection) this.f28386a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.f28387b.apply(t));
        }
    }

    static final class TruePredicate implements Predicate<Object> {
        TruePredicate() {
        }

        public boolean test(Object obj) {
            return true;
        }
    }

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> A(@NonNull Function5<T1, T2, T3, T4, T5, R> function5) {
        return new Array5Func(function5);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> B(@NonNull Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        return new Array6Func(function6);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> C(@NonNull Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        return new Array7Func(function7);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> D(@NonNull Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        return new Array8Func(function8);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> E(@NonNull Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        return new Array9Func(function9);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> F(Function<? super T, ? extends K> function) {
        return new ToMapKeySelector(function);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> G(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new ToMapKeyValueSelector(function2, function);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> H(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new ToMultimapKeyValueSelector(function3, function2, function);
    }

    public static <T> Consumer<T> a(Action action) {
        return new ActionConsumer(action);
    }

    @NonNull
    public static <T> Predicate<T> b() {
        return f28380i;
    }

    @NonNull
    public static <T> Predicate<T> c() {
        return f28379h;
    }

    public static <T> Consumer<T> d(int i2) {
        return new BoundedConsumer(i2);
    }

    @NonNull
    public static <T, U> Function<T, U> e(@NonNull Class<U> cls) {
        return new CastToClass(cls);
    }

    public static <T> Supplier<List<T>> f(int i2) {
        return new ArrayListCapacityCallable(i2);
    }

    public static <T> Supplier<Set<T>> g() {
        return HashSetSupplier.INSTANCE;
    }

    public static <T> Consumer<T> h() {
        return f28375d;
    }

    public static <T> Predicate<T> i(T t) {
        return new EqualsPredicate(t);
    }

    @NonNull
    public static Action j(@NonNull Future<?> future) {
        return new FutureAction(future);
    }

    @NonNull
    public static <T> Function<T, T> k() {
        return f28372a;
    }

    public static <T, U> Predicate<T> l(Class<U> cls) {
        return new ClassFilter(cls);
    }

    @NonNull
    public static <T> Callable<T> m(@NonNull T t) {
        return new JustValue(t);
    }

    @NonNull
    public static <T, U> Function<T, U> n(@NonNull U u) {
        return new JustValue(u);
    }

    @NonNull
    public static <T> Supplier<T> o(@NonNull T t) {
        return new JustValue(t);
    }

    public static <T> Function<List<T>, List<T>> p(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    public static <T> Comparator<T> q() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Action r(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnComplete(consumer);
    }

    public static <T> Consumer<Throwable> s(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnError(consumer);
    }

    public static <T> Consumer<T> t(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnNext(consumer);
    }

    @NonNull
    public static <T> Supplier<T> u() {
        return f28381j;
    }

    public static <T> Predicate<T> v(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    public static <T> Function<T, Timed<T>> w(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    @NonNull
    public static <T1, T2, R> Function<Object[], R> x(@NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        return new Array2Func(biFunction);
    }

    @NonNull
    public static <T1, T2, T3, R> Function<Object[], R> y(@NonNull Function3<T1, T2, T3, R> function3) {
        return new Array3Func(function3);
    }

    @NonNull
    public static <T1, T2, T3, T4, R> Function<Object[], R> z(@NonNull Function4<T1, T2, T3, T4, R> function4) {
        return new Array4Func(function4);
    }
}
