package androidx.media3.common;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public final class FlagSet {

    /* renamed from: a  reason: collision with root package name */
    private final SparseBooleanArray f9122a;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final SparseBooleanArray f9123a = new SparseBooleanArray();

        /* renamed from: b  reason: collision with root package name */
        private boolean f9124b;

        @CanIgnoreReturnValue
        public Builder a(int i2) {
            Assertions.i(!this.f9124b);
            this.f9123a.append(i2, true);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder b(FlagSet flagSet) {
            for (int i2 = 0; i2 < flagSet.d(); i2++) {
                a(flagSet.c(i2));
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(int... iArr) {
            for (int a2 : iArr) {
                a(a2);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(int i2, boolean z) {
            return z ? a(i2) : this;
        }

        public FlagSet e() {
            Assertions.i(!this.f9124b);
            this.f9124b = true;
            return new FlagSet(this.f9123a);
        }

        @CanIgnoreReturnValue
        public Builder f(int i2) {
            Assertions.i(!this.f9124b);
            this.f9123a.delete(i2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g(int... iArr) {
            for (int f2 : iArr) {
                f(f2);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder h(int i2, boolean z) {
            return z ? f(i2) : this;
        }
    }

    private FlagSet(SparseBooleanArray sparseBooleanArray) {
        this.f9122a = sparseBooleanArray;
    }

    public boolean a(int i2) {
        return this.f9122a.get(i2);
    }

    public boolean b(int... iArr) {
        for (int a2 : iArr) {
            if (a(a2)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i2) {
        Assertions.c(i2, 0, d());
        return this.f9122a.keyAt(i2);
    }

    public int d() {
        return this.f9122a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlagSet)) {
            return false;
        }
        FlagSet flagSet = (FlagSet) obj;
        if (Util.f9646a >= 24) {
            return this.f9122a.equals(flagSet.f9122a);
        }
        if (d() != flagSet.d()) {
            return false;
        }
        for (int i2 = 0; i2 < d(); i2++) {
            if (c(i2) != flagSet.c(i2)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (Util.f9646a >= 24) {
            return this.f9122a.hashCode();
        }
        int d2 = d();
        for (int i2 = 0; i2 < d(); i2++) {
            d2 = (d2 * 31) + c(i2);
        }
        return d2;
    }
}
