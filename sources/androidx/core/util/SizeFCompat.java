package androidx.core.util;

import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class SizeFCompat {

    /* renamed from: a  reason: collision with root package name */
    private final float f6315a;

    /* renamed from: b  reason: collision with root package name */
    private final float f6316b;

    @RequiresApi(21)
    private static final class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        @NonNull
        static SizeF a(@NonNull SizeFCompat sizeFCompat) {
            Preconditions.l(sizeFCompat);
            return new SizeF(sizeFCompat.b(), sizeFCompat.a());
        }

        @DoNotInline
        @NonNull
        static SizeFCompat b(@NonNull SizeF sizeF) {
            Preconditions.l(sizeF);
            return new SizeFCompat(sizeF.getWidth(), sizeF.getHeight());
        }
    }

    public SizeFCompat(float f2, float f3) {
        this.f6315a = Preconditions.d(f2, "width");
        this.f6316b = Preconditions.d(f3, "height");
    }

    @RequiresApi(21)
    @NonNull
    public static SizeFCompat d(@NonNull SizeF sizeF) {
        return Api21Impl.b(sizeF);
    }

    public float a() {
        return this.f6316b;
    }

    public float b() {
        return this.f6315a;
    }

    @RequiresApi(21)
    @NonNull
    public SizeF c() {
        return Api21Impl.a(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeFCompat)) {
            return false;
        }
        SizeFCompat sizeFCompat = (SizeFCompat) obj;
        return sizeFCompat.f6315a == this.f6315a && sizeFCompat.f6316b == this.f6316b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f6315a) ^ Float.floatToIntBits(this.f6316b);
    }

    @NonNull
    public String toString() {
        return this.f6315a + "x" + this.f6316b;
    }
}
