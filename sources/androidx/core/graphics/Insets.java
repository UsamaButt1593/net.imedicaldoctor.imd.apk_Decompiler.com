package androidx.core.graphics;

import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.dd.plist.ASCIIPropertyListParser;

public final class Insets {
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final Insets f5823e = new Insets(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f5824a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5825b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5826c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5827d;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static android.graphics.Insets a(int i2, int i3, int i4, int i5) {
            return android.graphics.Insets.of(i2, i3, i4, i5);
        }
    }

    private Insets(int i2, int i3, int i4, int i5) {
        this.f5824a = i2;
        this.f5825b = i3;
        this.f5826c = i4;
        this.f5827d = i5;
    }

    @NonNull
    public static Insets a(@NonNull Insets insets, @NonNull Insets insets2) {
        return d(insets.f5824a + insets2.f5824a, insets.f5825b + insets2.f5825b, insets.f5826c + insets2.f5826c, insets.f5827d + insets2.f5827d);
    }

    @NonNull
    public static Insets b(@NonNull Insets insets, @NonNull Insets insets2) {
        return d(Math.max(insets.f5824a, insets2.f5824a), Math.max(insets.f5825b, insets2.f5825b), Math.max(insets.f5826c, insets2.f5826c), Math.max(insets.f5827d, insets2.f5827d));
    }

    @NonNull
    public static Insets c(@NonNull Insets insets, @NonNull Insets insets2) {
        return d(Math.min(insets.f5824a, insets2.f5824a), Math.min(insets.f5825b, insets2.f5825b), Math.min(insets.f5826c, insets2.f5826c), Math.min(insets.f5827d, insets2.f5827d));
    }

    @NonNull
    public static Insets d(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f5823e : new Insets(i2, i3, i4, i5);
    }

    @NonNull
    public static Insets e(@NonNull Rect rect) {
        return d(rect.left, rect.top, rect.right, rect.bottom);
    }

    @NonNull
    public static Insets f(@NonNull Insets insets, @NonNull Insets insets2) {
        return d(insets.f5824a - insets2.f5824a, insets.f5825b - insets2.f5825b, insets.f5826c - insets2.f5826c, insets.f5827d - insets2.f5827d);
    }

    @RequiresApi(api = 29)
    @NonNull
    public static Insets g(@NonNull android.graphics.Insets insets) {
        return d(insets.left, insets.top, insets.right, insets.bottom);
    }

    @RequiresApi(api = 29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NonNull
    @Deprecated
    public static Insets i(@NonNull android.graphics.Insets insets) {
        return g(insets);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.f5827d == insets.f5827d && this.f5824a == insets.f5824a && this.f5826c == insets.f5826c && this.f5825b == insets.f5825b;
    }

    @RequiresApi(29)
    @NonNull
    public android.graphics.Insets h() {
        return Api29Impl.a(this.f5824a, this.f5825b, this.f5826c, this.f5827d);
    }

    public int hashCode() {
        return (((((this.f5824a * 31) + this.f5825b) * 31) + this.f5826c) * 31) + this.f5827d;
    }

    @NonNull
    public String toString() {
        return "Insets{left=" + this.f5824a + ", top=" + this.f5825b + ", right=" + this.f5826c + ", bottom=" + this.f5827d + ASCIIPropertyListParser.f18653k;
    }
}
