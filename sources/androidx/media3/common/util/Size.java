package androidx.media3.common.util;

import androidx.annotation.Nullable;

@UnstableApi
public final class Size {

    /* renamed from: c  reason: collision with root package name */
    public static final Size f9620c = new Size(-1, -1);

    /* renamed from: d  reason: collision with root package name */
    public static final Size f9621d = new Size(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final int f9622a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9623b;

    public Size(int i2, int i3) {
        Assertions.a((i2 == -1 || i2 >= 0) && (i3 == -1 || i3 >= 0));
        this.f9622a = i2;
        this.f9623b = i3;
    }

    public int a() {
        return this.f9623b;
    }

    public int b() {
        return this.f9622a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f9622a == size.f9622a && this.f9623b == size.f9623b;
    }

    public int hashCode() {
        int i2 = this.f9623b;
        int i3 = this.f9622a;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public String toString() {
        return this.f9622a + "x" + this.f9623b;
    }
}
