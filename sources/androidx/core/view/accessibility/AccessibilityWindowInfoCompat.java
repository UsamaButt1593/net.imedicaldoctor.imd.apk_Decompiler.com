package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;

public class AccessibilityWindowInfoCompat {

    /* renamed from: b  reason: collision with root package name */
    private static final int f6689b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6690c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6691d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6692e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f6693f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f6694g = 5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f6695h = 6;

    /* renamed from: a  reason: collision with root package name */
    private final Object f6696a;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void a(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        @DoNotInline
        static AccessibilityWindowInfo b(AccessibilityWindowInfo accessibilityWindowInfo, int i2) {
            return accessibilityWindowInfo.getChild(i2);
        }

        @DoNotInline
        static int c(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        @DoNotInline
        static int d(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        @DoNotInline
        static int e(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLayer();
        }

        @DoNotInline
        static AccessibilityWindowInfo f(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        @DoNotInline
        static AccessibilityNodeInfo g(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getRoot();
        }

        @DoNotInline
        static int h(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        @DoNotInline
        static boolean i(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isAccessibilityFocused();
        }

        @DoNotInline
        static boolean j(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        @DoNotInline
        static boolean k(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }

        @DoNotInline
        static AccessibilityWindowInfo l() {
            return AccessibilityWindowInfo.obtain();
        }

        @DoNotInline
        static AccessibilityWindowInfo m(AccessibilityWindowInfo accessibilityWindowInfo) {
            return AccessibilityWindowInfo.obtain(accessibilityWindowInfo);
        }
    }

    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static AccessibilityNodeInfo a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getAnchor();
        }

        @DoNotInline
        static CharSequence b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTitle();
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static boolean a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isInPictureInPictureMode();
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static AccessibilityWindowInfo a() {
            return new AccessibilityWindowInfo();
        }
    }

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static int a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getDisplayId();
        }

        @DoNotInline
        static void b(AccessibilityWindowInfo accessibilityWindowInfo, Region region) {
            accessibilityWindowInfo.getRegionInScreen(region);
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat c(Object obj, int i2) {
            return AccessibilityNodeInfoCompat.s2(((AccessibilityWindowInfo) obj).getRoot(i2));
        }
    }

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static LocaleList a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLocales();
        }

        @DoNotInline
        public static long b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTransitionTimeMillis();
        }
    }

    public AccessibilityWindowInfoCompat() {
        this.f6696a = Build.VERSION.SDK_INT >= 30 ? Api30Impl.a() : null;
    }

    @Nullable
    public static AccessibilityWindowInfoCompat t() {
        return y(Api21Impl.l());
    }

    @Nullable
    public static AccessibilityWindowInfoCompat u(@Nullable AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        if (accessibilityWindowInfoCompat == null) {
            return null;
        }
        return y(Api21Impl.m((AccessibilityWindowInfo) accessibilityWindowInfoCompat.f6696a));
    }

    private static String w(int i2) {
        if (i2 == 1) {
            return "TYPE_APPLICATION";
        }
        if (i2 == 2) {
            return "TYPE_INPUT_METHOD";
        }
        if (i2 != 3) {
            return i2 != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY";
        }
        return "TYPE_SYSTEM";
    }

    static AccessibilityWindowInfoCompat y(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return AccessibilityNodeInfoCompat.s2(Api24Impl.a((AccessibilityWindowInfo) this.f6696a));
        }
        return null;
    }

    public void b(@NonNull Rect rect) {
        Api21Impl.a((AccessibilityWindowInfo) this.f6696a, rect);
    }

    @Nullable
    public AccessibilityWindowInfoCompat c(int i2) {
        return y(Api21Impl.b((AccessibilityWindowInfo) this.f6696a, i2));
    }

    public int d() {
        return Api21Impl.c((AccessibilityWindowInfo) this.f6696a);
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.a((AccessibilityWindowInfo) this.f6696a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        Object obj2 = this.f6696a;
        Object obj3 = ((AccessibilityWindowInfoCompat) obj).f6696a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public int f() {
        return Api21Impl.d((AccessibilityWindowInfo) this.f6696a);
    }

    public int g() {
        return Api21Impl.e((AccessibilityWindowInfo) this.f6696a);
    }

    @NonNull
    public LocaleListCompat h() {
        return Build.VERSION.SDK_INT >= 34 ? LocaleListCompat.o(Api34Impl.a((AccessibilityWindowInfo) this.f6696a)) : LocaleListCompat.g();
    }

    public int hashCode() {
        Object obj = this.f6696a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Nullable
    public AccessibilityWindowInfoCompat i() {
        return y(Api21Impl.f((AccessibilityWindowInfo) this.f6696a));
    }

    public void j(@NonNull Region region) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.b((AccessibilityWindowInfo) this.f6696a, region);
            return;
        }
        Rect rect = new Rect();
        Api21Impl.a((AccessibilityWindowInfo) this.f6696a, rect);
        region.set(rect);
    }

    @Nullable
    public AccessibilityNodeInfoCompat k() {
        return AccessibilityNodeInfoCompat.s2(Api21Impl.g((AccessibilityWindowInfo) this.f6696a));
    }

    @Nullable
    public AccessibilityNodeInfoCompat l(int i2) {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.c(this.f6696a, i2) : k();
    }

    @Nullable
    public CharSequence m() {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.b((AccessibilityWindowInfo) this.f6696a);
        }
        return null;
    }

    public long n() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.b((AccessibilityWindowInfo) this.f6696a);
        }
        return 0;
    }

    public int o() {
        return Api21Impl.h((AccessibilityWindowInfo) this.f6696a);
    }

    public boolean p() {
        return Api21Impl.i((AccessibilityWindowInfo) this.f6696a);
    }

    public boolean q() {
        return Api21Impl.j((AccessibilityWindowInfo) this.f6696a);
    }

    public boolean r() {
        return Api21Impl.k((AccessibilityWindowInfo) this.f6696a);
    }

    public boolean s() {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a((AccessibilityWindowInfo) this.f6696a);
        }
        return false;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Rect rect = new Rect();
        b(rect);
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=");
        sb.append(f());
        sb.append(", type=");
        sb.append(w(o()));
        sb.append(", layer=");
        sb.append(g());
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", focused=");
        sb.append(r());
        sb.append(", active=");
        sb.append(q());
        sb.append(", hasParent=");
        boolean z = false;
        sb.append(i() != null);
        sb.append(", hasChildren=");
        if (d() > 0) {
            z = true;
        }
        sb.append(z);
        sb.append(", transitionTime=");
        sb.append(n());
        sb.append(", locales=");
        sb.append(h());
        sb.append(']');
        return sb.toString();
    }

    @Deprecated
    public void v() {
    }

    @Nullable
    public AccessibilityWindowInfo x() {
        return (AccessibilityWindowInfo) this.f6696a;
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.f6696a = obj;
    }
}
