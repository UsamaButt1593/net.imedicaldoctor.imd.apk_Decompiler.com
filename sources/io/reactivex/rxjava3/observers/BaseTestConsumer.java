package io.reactivex.rxjava3.observers;

import com.dd.plist.ASCIIPropertyListParser;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.VolatileSizeArrayList;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> {
    protected final List<T> X = new VolatileSizeArrayList();
    protected Thread X2;
    protected final List<Throwable> Y = new VolatileSizeArrayList();
    protected boolean Y2;
    protected long Z;
    protected CharSequence Z2;
    protected boolean a3;
    protected final CountDownLatch s = new CountDownLatch(1);

    @NonNull
    public static String E(@Nullable Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    public final boolean A(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        boolean z = this.s.getCount() == 0 || this.s.await(j2, timeUnit);
        this.a3 = !z;
        return z;
    }

    @NonNull
    public final U B(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - currentTimeMillis < 5000) {
                if (this.s.getCount() == 0 || this.X.size() >= i2) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                this.a3 = true;
                break;
            }
        }
        return this;
    }

    @NonNull
    public final U C(long j2, @NonNull TimeUnit timeUnit) {
        try {
            if (!this.s.await(j2, timeUnit)) {
                this.a3 = true;
                m();
            }
            return this;
        } catch (InterruptedException e2) {
            m();
            throw ExceptionHelper.i(e2);
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final AssertionError D(@NonNull String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.s.getCount());
        sb.append(", ");
        sb.append("values = ");
        sb.append(this.X.size());
        sb.append(", ");
        sb.append("errors = ");
        sb.append(this.Y.size());
        sb.append(", ");
        sb.append("completions = ");
        sb.append(this.Z);
        if (this.a3) {
            sb.append(", timeout!");
        }
        if (g()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.Z2;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(ASCIIPropertyListParser.f18650h);
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.Y.isEmpty()) {
            assertionError.initCause(this.Y.size() == 1 ? this.Y.get(0) : new CompositeException((Iterable<? extends Throwable>) this.Y));
        }
        return assertionError;
    }

    @NonNull
    public final List<T> F() {
        return this.X;
    }

    @NonNull
    public final U G(@Nullable CharSequence charSequence) {
        this.Z2 = charSequence;
        return this;
    }

    @NonNull
    public final U c() {
        long j2 = this.Z;
        if (j2 == 0) {
            throw D("Not completed");
        } else if (j2 <= 1) {
            return this;
        } else {
            throw D("Multiple completions: " + j2);
        }
    }

    @NonNull
    public final U d() {
        return q().l().k().n();
    }

    @NonNull
    public final U e(@NonNull Predicate<Throwable> predicate) {
        int size = this.Y.size();
        if (size != 0) {
            for (Throwable test : this.Y) {
                try {
                    if (predicate.test(test)) {
                        if (size == 1) {
                            return this;
                        }
                        throw D("Error present but other errors as well");
                    }
                } catch (Throwable th) {
                    throw ExceptionHelper.i(th);
                }
            }
            throw D("Error not present");
        }
        throw D("No errors");
    }

    @NonNull
    public final U f(@NonNull Class<? extends Throwable> cls) {
        return e(Functions.l(cls));
    }

    /* access modifiers changed from: protected */
    public abstract boolean g();

    @NonNull
    public final U i(@NonNull Throwable th) {
        return e(Functions.i(th));
    }

    @SafeVarargs
    @NonNull
    public final U j(@NonNull Class<? extends Throwable> cls, @NonNull T... tArr) {
        return q().x(tArr).f(cls).n();
    }

    @NonNull
    public final U k() {
        if (this.Y.size() == 0) {
            return this;
        }
        throw D("Error(s) present: " + this.Y);
    }

    @NonNull
    public final U l() {
        return v(0);
    }

    /* access modifiers changed from: protected */
    public abstract void m();

    @NonNull
    public final U n() {
        long j2 = this.Z;
        int i2 = (j2 > 1 ? 1 : (j2 == 1 ? 0 : -1));
        if (i2 == 0) {
            throw D("Completed!");
        } else if (i2 <= 0) {
            return this;
        } else {
            throw D("Multiple completions: " + j2);
        }
    }

    @SafeVarargs
    @NonNull
    public final U p(@NonNull T... tArr) {
        return q().x(tArr).k().c();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract U q();

    @NonNull
    public final U r(@NonNull Predicate<T> predicate) {
        t(0, predicate);
        if (this.X.size() <= 1) {
            return this;
        }
        throw D("Value present but other values as well");
    }

    @NonNull
    public final U s(@NonNull T t) {
        if (this.X.size() == 1) {
            T t2 = this.X.get(0);
            if (Objects.equals(t, t2)) {
                return this;
            }
            throw D("expected: " + E(t) + " but was: " + E(t2));
        }
        throw D("expected: " + E(t) + " but was: " + this.X);
    }

    @NonNull
    public final U t(int i2, @NonNull Predicate<T> predicate) {
        if (this.X.size() == 0) {
            throw D("No values");
        } else if (i2 < this.X.size()) {
            try {
                if (predicate.test(this.X.get(i2))) {
                    return this;
                }
                throw D("Value not present");
            } catch (Throwable th) {
                throw ExceptionHelper.i(th);
            }
        } else {
            throw D("Invalid index: " + i2);
        }
    }

    @NonNull
    public final U u(int i2, @NonNull T t) {
        int size = this.X.size();
        if (size == 0) {
            throw D("No values");
        } else if (i2 < size) {
            T t2 = this.X.get(i2);
            if (Objects.equals(t, t2)) {
                return this;
            }
            throw D("expected: " + E(t) + " but was: " + E(t2));
        } else {
            throw D("Invalid index: " + i2);
        }
    }

    @NonNull
    public final U v(int i2) {
        int size = this.X.size();
        if (size == i2) {
            return this;
        }
        throw D("Value counts differ; expected: " + i2 + " but was: " + size);
    }

    @NonNull
    public final U w(@NonNull Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it2 = this.X.iterator();
        Iterator<? extends T> it3 = iterable.iterator();
        int i2 = 0;
        while (true) {
            hasNext = it3.hasNext();
            hasNext2 = it2.hasNext();
            if (hasNext2 && hasNext) {
                Object next = it3.next();
                T next2 = it2.next();
                if (Objects.equals(next, next2)) {
                    i2++;
                } else {
                    throw D("Values at position " + i2 + " differ; expected: " + E(next) + " but was: " + E(next2));
                }
            }
        }
        if (hasNext2) {
            throw D("More values received than expected (" + i2 + ")");
        } else if (!hasNext) {
            return this;
        } else {
            throw D("Fewer values received than expected (" + i2 + ")");
        }
    }

    @SafeVarargs
    @NonNull
    public final U x(@NonNull T... tArr) {
        int size = this.X.size();
        if (size == tArr.length) {
            int i2 = 0;
            while (i2 < size) {
                T t = this.X.get(i2);
                T t2 = tArr[i2];
                if (Objects.equals(t2, t)) {
                    i2++;
                } else {
                    throw D("Values at position " + i2 + " differ; expected: " + E(t2) + " but was: " + E(t));
                }
            }
            return this;
        }
        throw D("Value count differs; expected: " + tArr.length + StringUtils.SPACE + Arrays.toString(tArr) + " but was: " + size + StringUtils.SPACE + this.X);
    }

    @SafeVarargs
    @NonNull
    public final U y(@NonNull T... tArr) {
        return q().x(tArr).k().n();
    }

    @NonNull
    public final U z() throws InterruptedException {
        if (this.s.getCount() == 0) {
            return this;
        }
        this.s.await();
        return this;
    }
}
