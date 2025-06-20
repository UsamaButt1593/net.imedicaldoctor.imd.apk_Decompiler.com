package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DisplayCutoutCompat {

    /* renamed from: a  reason: collision with root package name */
    private final DisplayCutout f6375a;

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static DisplayCutout a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        @DoNotInline
        static List<Rect> b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        @DoNotInline
        static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        @DoNotInline
        static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        @DoNotInline
        static int e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        @DoNotInline
        static int f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static DisplayCutout a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            return new DisplayCutout(insets, rect, rect2, rect3, rect4);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static DisplayCutout a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
            return new DisplayCutout(insets, rect, rect2, rect3, rect4, insets2);
        }

        @DoNotInline
        static Insets b(DisplayCutout displayCutout) {
            return displayCutout.getWaterfallInsets();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DisplayCutoutCompat(@Nullable Rect rect, @Nullable List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? Api28Impl.a(rect, list) : null);
    }

    private static DisplayCutout a(@NonNull androidx.core.graphics.Insets insets, @Nullable Rect rect, @Nullable Rect rect2, @Nullable Rect rect3, @Nullable Rect rect4, @NonNull androidx.core.graphics.Insets insets2) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            return Api30Impl.a(insets.h(), rect, rect2, rect3, rect4, insets2.h());
        } else if (i2 >= 29) {
            return Api29Impl.a(insets.h(), rect, rect2, rect3, rect4);
        } else {
            if (i2 < 28) {
                return null;
            }
            Rect rect5 = new Rect(insets.f5824a, insets.f5825b, insets.f5826c, insets.f5827d);
            ArrayList arrayList = new ArrayList();
            if (rect != null) {
                arrayList.add(rect);
            }
            if (rect2 != null) {
                arrayList.add(rect2);
            }
            if (rect3 != null) {
                arrayList.add(rect3);
            }
            if (rect4 != null) {
                arrayList.add(rect4);
            }
            return Api28Impl.a(rect5, arrayList);
        }
    }

    static DisplayCutoutCompat i(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new DisplayCutoutCompat(displayCutout);
    }

    @NonNull
    public List<Rect> b() {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.b(this.f6375a) : Collections.emptyList();
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.c(this.f6375a);
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.d(this.f6375a);
        }
        return 0;
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.e(this.f6375a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        return ObjectsCompat.a(this.f6375a, ((DisplayCutoutCompat) obj).f6375a);
    }

    public int f() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.f(this.f6375a);
        }
        return 0;
    }

    @NonNull
    public androidx.core.graphics.Insets g() {
        return Build.VERSION.SDK_INT >= 30 ? androidx.core.graphics.Insets.g(Api30Impl.b(this.f6375a)) : androidx.core.graphics.Insets.f5823e;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(28)
    public DisplayCutout h() {
        return this.f6375a;
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f6375a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    @NonNull
    public String toString() {
        return "DisplayCutoutCompat{" + this.f6375a + "}";
    }

    private DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.f6375a = displayCutout;
    }

    public DisplayCutoutCompat(@NonNull androidx.core.graphics.Insets insets, @Nullable Rect rect, @Nullable Rect rect2, @Nullable Rect rect3, @Nullable Rect rect4, @NonNull androidx.core.graphics.Insets insets2) {
        this(a(insets, rect, rect2, rect3, rect4, insets2));
    }
}
