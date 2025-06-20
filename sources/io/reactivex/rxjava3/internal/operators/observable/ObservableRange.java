package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;

public final class ObservableRange extends Observable<Integer> {
    private final long X;
    private final int s;

    static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long Y2 = 396518478098735504L;
        final Observer<? super Integer> X;
        boolean X2;
        final long Y;
        long Z;

        RangeDisposable(Observer<? super Integer> observer, long j2, long j3) {
            this.X = observer;
            this.Z = j2;
            this.Y = j3;
        }

        @Nullable
        /* renamed from: c */
        public Integer poll() {
            long j2 = this.Z;
            if (j2 != this.Y) {
                this.Z = 1 + j2;
                return Integer.valueOf((int) j2);
            }
            lazySet(1);
            return null;
        }

        public void clear() {
            this.Z = this.Y;
            lazySet(1);
        }

        public boolean g() {
            return get() != 0;
        }

        public boolean isEmpty() {
            return this.Z == this.Y;
        }

        public void m() {
            set(1);
        }

        public int r(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.X2 = true;
            return 1;
        }

        /* access modifiers changed from: package-private */
        public void run() {
            if (!this.X2) {
                Observer<? super Integer> observer = this.X;
                long j2 = this.Y;
                for (long j3 = this.Z; j3 != j2 && get() == 0; j3++) {
                    observer.onNext(Integer.valueOf((int) j3));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }
    }

    public ObservableRange(int i2, int i3) {
        this.s = i2;
        this.X = ((long) i2) + ((long) i3);
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, (long) this.s, this.X);
        observer.b(rangeDisposable);
        rangeDisposable.run();
    }
}
