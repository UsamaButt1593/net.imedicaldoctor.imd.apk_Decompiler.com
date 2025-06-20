package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat {

    /* renamed from: b  reason: collision with root package name */
    private static final String f6561b = "WindowInsetsCompat";
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final WindowInsetsCompat f6562c = (Build.VERSION.SDK_INT >= 30 ? Impl30.q : Impl.f6578b);

    /* renamed from: a  reason: collision with root package name */
    private final Impl f6563a;

    @RequiresApi(21)
    @SuppressLint({"SoonBlockedPrivateApi"})
    static class Api21ReflectionHolder {

        /* renamed from: a  reason: collision with root package name */
        private static Field f6564a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f6565b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f6566c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f6567d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f6564a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f6565b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f6566c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.w(WindowInsetsCompat.f6561b, "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
            }
        }

        private Api21ReflectionHolder() {
        }

        @Nullable
        public static WindowInsetsCompat a(@NonNull View view) {
            if (f6567d && view.isAttachedToWindow()) {
                try {
                    Object obj = f6564a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f6565b.get(obj);
                        Rect rect2 = (Rect) f6566c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            WindowInsetsCompat a2 = new Builder().f(Insets.e(rect)).h(Insets.e(rect2)).a();
                            a2.H(a2);
                            a2.d(view.getRootView());
                            return a2;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    Log.w(WindowInsetsCompat.f6561b, "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
                }
            }
            return null;
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final BuilderImpl f6568a;

        public Builder() {
            int i2 = Build.VERSION.SDK_INT;
            this.f6568a = i2 >= 30 ? new BuilderImpl30() : i2 >= 29 ? new BuilderImpl29() : new BuilderImpl20();
        }

        @NonNull
        public WindowInsetsCompat a() {
            return this.f6568a.b();
        }

        @NonNull
        public Builder b(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.f6568a.c(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder c(int i2, @NonNull Insets insets) {
            this.f6568a.d(i2, insets);
            return this;
        }

        @NonNull
        public Builder d(int i2, @NonNull Insets insets) {
            this.f6568a.e(i2, insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder e(@NonNull Insets insets) {
            this.f6568a.f(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder f(@NonNull Insets insets) {
            this.f6568a.g(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder g(@NonNull Insets insets) {
            this.f6568a.h(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder h(@NonNull Insets insets) {
            this.f6568a.i(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder i(@NonNull Insets insets) {
            this.f6568a.j(insets);
            return this;
        }

        @NonNull
        public Builder j(int i2, boolean z) {
            this.f6568a.k(i2, z);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i2 = Build.VERSION.SDK_INT;
            this.f6568a = i2 >= 30 ? new BuilderImpl30(windowInsetsCompat) : i2 >= 29 ? new BuilderImpl29(windowInsetsCompat) : new BuilderImpl20(windowInsetsCompat);
        }
    }

    private static class BuilderImpl {

        /* renamed from: a  reason: collision with root package name */
        private final WindowInsetsCompat f6569a;

        /* renamed from: b  reason: collision with root package name */
        Insets[] f6570b;

        BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        /* access modifiers changed from: protected */
        public final void a() {
            Insets[] insetsArr = this.f6570b;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.e(1)];
                Insets insets2 = this.f6570b[Type.e(2)];
                if (insets2 == null) {
                    insets2 = this.f6569a.f(2);
                }
                if (insets == null) {
                    insets = this.f6569a.f(1);
                }
                i(Insets.b(insets, insets2));
                Insets insets3 = this.f6570b[Type.e(16)];
                if (insets3 != null) {
                    h(insets3);
                }
                Insets insets4 = this.f6570b[Type.e(32)];
                if (insets4 != null) {
                    f(insets4);
                }
                Insets insets5 = this.f6570b[Type.e(64)];
                if (insets5 != null) {
                    j(insets5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat b() {
            a();
            return this.f6569a;
        }

        /* access modifiers changed from: package-private */
        public void c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, @NonNull Insets insets) {
            if (this.f6570b == null) {
                this.f6570b = new Insets[9];
            }
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    this.f6570b[Type.e(i3)] = insets;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, @NonNull Insets insets) {
            if (i2 == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void h(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void i(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void j(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void k(int i2, boolean z) {
        }

        BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f6569a = windowInsetsCompat;
        }
    }

    @RequiresApi(api = 20)
    private static class BuilderImpl20 extends BuilderImpl {

        /* renamed from: e  reason: collision with root package name */
        private static Field f6571e = null;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f6572f = false;

        /* renamed from: g  reason: collision with root package name */
        private static Constructor<WindowInsets> f6573g = null;

        /* renamed from: h  reason: collision with root package name */
        private static boolean f6574h = false;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f6575c;

        /* renamed from: d  reason: collision with root package name */
        private Insets f6576d;

        BuilderImpl20() {
            this.f6575c = l();
        }

        @Nullable
        private static WindowInsets l() {
            Class<WindowInsets> cls = WindowInsets.class;
            if (!f6572f) {
                try {
                    f6571e = cls.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i(WindowInsetsCompat.f6561b, "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f6572f = true;
            }
            Field field = f6571e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i(WindowInsetsCompat.f6561b, "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f6574h) {
                try {
                    f6573g = cls.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e4) {
                    Log.i(WindowInsetsCompat.f6561b, "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f6574h = true;
            }
            Constructor<WindowInsets> constructor = f6573g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e5) {
                    Log.i(WindowInsetsCompat.f6561b, "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat K = WindowInsetsCompat.K(this.f6575c);
            K.F(this.f6570b);
            K.I(this.f6576d);
            return K;
        }

        /* access modifiers changed from: package-private */
        public void g(@Nullable Insets insets) {
            this.f6576d = insets;
        }

        /* access modifiers changed from: package-private */
        public void i(@NonNull Insets insets) {
            WindowInsets windowInsets = this.f6575c;
            if (windowInsets != null) {
                this.f6575c = windowInsets.replaceSystemWindowInsets(insets.f5824a, insets.f5825b, insets.f5826c, insets.f5827d);
            }
        }

        BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f6575c = windowInsetsCompat.J();
        }
    }

    @RequiresApi(api = 29)
    private static class BuilderImpl29 extends BuilderImpl {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets.Builder f6577c;

        BuilderImpl29() {
            this.f6577c = C0127u0.a();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat K = WindowInsetsCompat.K(this.f6577c.build());
            K.F(this.f6570b);
            return K;
        }

        /* access modifiers changed from: package-private */
        public void c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            WindowInsets.Builder unused = this.f6577c.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.h() : null);
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f6577c.setMandatorySystemGestureInsets(insets.h());
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f6577c.setStableInsets(insets.h());
        }

        /* access modifiers changed from: package-private */
        public void h(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f6577c.setSystemGestureInsets(insets.h());
        }

        /* access modifiers changed from: package-private */
        public void i(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f6577c.setSystemWindowInsets(insets.h());
        }

        /* access modifiers changed from: package-private */
        public void j(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f6577c.setTappableElementInsets(insets.h());
        }

        BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets J = windowInsetsCompat.J();
            this.f6577c = J != null ? C0125t0.a(J) : C0127u0.a();
        }
    }

    @RequiresApi(30)
    private static class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, @NonNull Insets insets) {
            WindowInsets.Builder unused = this.f6577c.setInsets(TypeImpl30.a(i2), insets.h());
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, @NonNull Insets insets) {
            WindowInsets.Builder unused = this.f6577c.setInsetsIgnoringVisibility(TypeImpl30.a(i2), insets.h());
        }

        /* access modifiers changed from: package-private */
        public void k(int i2, boolean z) {
            WindowInsets.Builder unused = this.f6577c.setVisible(TypeImpl30.a(i2), z);
        }

        BuilderImpl30(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    private static class Impl {
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        static final WindowInsetsCompat f6578b = new Builder().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final WindowInsetsCompat f6579a;

        Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f6579a = windowInsetsCompat;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat a() {
            return this.f6579a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat b() {
            return this.f6579a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat c() {
            return this.f6579a;
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull View view) {
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            return p() == impl.p() && o() == impl.o() && ObjectsCompat.a(l(), impl.l()) && ObjectsCompat.a(j(), impl.j()) && ObjectsCompat.a(f(), impl.f());
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public DisplayCutoutCompat f() {
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets g(int i2) {
            return Insets.f5823e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets h(int i2) {
            if ((i2 & 8) == 0) {
                return Insets.f5823e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return ObjectsCompat.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets i() {
            return l();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets j() {
            return Insets.f5823e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets k() {
            return l();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets l() {
            return Insets.f5823e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets m() {
            return l();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat n(int i2, int i3, int i4, int i5) {
            return f6578b;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean p() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean q(int i2) {
            return true;
        }

        public void r(Insets[] insetsArr) {
        }

        /* access modifiers changed from: package-private */
        public void s(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void t(@Nullable WindowInsetsCompat windowInsetsCompat) {
        }

        public void u(Insets insets) {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {

        /* renamed from: h  reason: collision with root package name */
        private static boolean f6580h = false;

        /* renamed from: i  reason: collision with root package name */
        private static Method f6581i;

        /* renamed from: j  reason: collision with root package name */
        private static Class<?> f6582j;

        /* renamed from: k  reason: collision with root package name */
        private static Field f6583k;

        /* renamed from: l  reason: collision with root package name */
        private static Field f6584l;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f6585c;

        /* renamed from: d  reason: collision with root package name */
        private Insets[] f6586d;

        /* renamed from: e  reason: collision with root package name */
        private Insets f6587e;

        /* renamed from: f  reason: collision with root package name */
        private WindowInsetsCompat f6588f;

        /* renamed from: g  reason: collision with root package name */
        Insets f6589g;

        Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f6587e = null;
            this.f6585c = windowInsets;
        }

        @SuppressLint({"PrivateApi"})
        private static void A() {
            try {
                f6581i = View.class.getDeclaredMethod("getViewRootImpl", (Class[]) null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f6582j = cls;
                f6583k = cls.getDeclaredField("mVisibleInsets");
                f6584l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f6583k.setAccessible(true);
                f6584l.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e(WindowInsetsCompat.f6561b, "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            f6580h = true;
        }

        @SuppressLint({"WrongConstant"})
        @NonNull
        private Insets v(int i2, boolean z) {
            Insets insets = Insets.f5823e;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    insets = Insets.b(insets, w(i3, z));
                }
            }
            return insets;
        }

        private Insets x() {
            WindowInsetsCompat windowInsetsCompat = this.f6588f;
            return windowInsetsCompat != null ? windowInsetsCompat.m() : Insets.f5823e;
        }

        @Nullable
        private Insets y(@NonNull View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f6580h) {
                    A();
                }
                Method method = f6581i;
                if (!(method == null || f6582j == null || f6583k == null)) {
                    try {
                        Object invoke = method.invoke(view, (Object[]) null);
                        if (invoke == null) {
                            Log.w(WindowInsetsCompat.f6561b, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f6583k.get(f6584l.get(invoke));
                        if (rect != null) {
                            return Insets.e(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e2) {
                        Log.e(WindowInsetsCompat.f6561b, "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull View view) {
            Insets y = y(view);
            if (y == null) {
                y = Insets.f5823e;
            }
            s(y);
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.H(this.f6588f);
            windowInsetsCompat.G(this.f6589g);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f6589g, ((Impl20) obj).f6589g);
        }

        @NonNull
        public Insets g(int i2) {
            return v(i2, false);
        }

        @NonNull
        public Insets h(int i2) {
            return v(i2, true);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public final Insets l() {
            if (this.f6587e == null) {
                this.f6587e = Insets.d(this.f6585c.getSystemWindowInsetLeft(), this.f6585c.getSystemWindowInsetTop(), this.f6585c.getSystemWindowInsetRight(), this.f6585c.getSystemWindowInsetBottom());
            }
            return this.f6587e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat n(int i2, int i3, int i4, int i5) {
            Builder builder = new Builder(WindowInsetsCompat.K(this.f6585c));
            builder.h(WindowInsetsCompat.z(l(), i2, i3, i4, i5));
            builder.f(WindowInsetsCompat.z(j(), i2, i3, i4, i5));
            return builder.a();
        }

        /* access modifiers changed from: package-private */
        public boolean p() {
            return this.f6585c.isRound();
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean q(int i2) {
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0 && !z(i3)) {
                    return false;
                }
            }
            return true;
        }

        public void r(Insets[] insetsArr) {
            this.f6586d = insetsArr;
        }

        /* access modifiers changed from: package-private */
        public void s(@NonNull Insets insets) {
            this.f6589g = insets;
        }

        /* access modifiers changed from: package-private */
        public void t(@Nullable WindowInsetsCompat windowInsetsCompat) {
            this.f6588f = windowInsetsCompat;
        }

        /* access modifiers changed from: protected */
        @NonNull
        public Insets w(int i2, boolean z) {
            int i3;
            if (i2 == 1) {
                return z ? Insets.d(0, Math.max(x().f5825b, l().f5825b), 0, 0) : Insets.d(0, l().f5825b, 0, 0);
            }
            Insets insets = null;
            if (i2 != 2) {
                if (i2 == 8) {
                    Insets[] insetsArr = this.f6586d;
                    if (insetsArr != null) {
                        insets = insetsArr[Type.e(8)];
                    }
                    if (insets != null) {
                        return insets;
                    }
                    Insets l2 = l();
                    Insets x = x();
                    int i4 = l2.f5827d;
                    if (i4 > x.f5827d) {
                        return Insets.d(0, 0, 0, i4);
                    }
                    Insets insets2 = this.f6589g;
                    return (insets2 == null || insets2.equals(Insets.f5823e) || (i3 = this.f6589g.f5827d) <= x.f5827d) ? Insets.f5823e : Insets.d(0, 0, 0, i3);
                } else if (i2 == 16) {
                    return k();
                } else {
                    if (i2 == 32) {
                        return i();
                    }
                    if (i2 == 64) {
                        return m();
                    }
                    if (i2 != 128) {
                        return Insets.f5823e;
                    }
                    WindowInsetsCompat windowInsetsCompat = this.f6588f;
                    DisplayCutoutCompat e2 = windowInsetsCompat != null ? windowInsetsCompat.e() : f();
                    return e2 != null ? Insets.d(e2.d(), e2.f(), e2.e(), e2.c()) : Insets.f5823e;
                }
            } else if (z) {
                Insets x2 = x();
                Insets j2 = j();
                return Insets.d(Math.max(x2.f5824a, j2.f5824a), 0, Math.max(x2.f5826c, j2.f5826c), Math.max(x2.f5827d, j2.f5827d));
            } else {
                Insets l3 = l();
                WindowInsetsCompat windowInsetsCompat2 = this.f6588f;
                if (windowInsetsCompat2 != null) {
                    insets = windowInsetsCompat2.m();
                }
                int i5 = l3.f5827d;
                if (insets != null) {
                    i5 = Math.min(i5, insets.f5827d);
                }
                return Insets.d(l3.f5824a, 0, l3.f5826c, i5);
            }
        }

        /* access modifiers changed from: protected */
        public boolean z(int i2) {
            if (!(i2 == 1 || i2 == 2)) {
                if (i2 == 4) {
                    return false;
                }
                if (!(i2 == 8 || i2 == 128)) {
                    return true;
                }
            }
            return !w(i2, false).equals(Insets.f5823e);
        }

        Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.f6585c));
        }
    }

    @RequiresApi(21)
    private static class Impl21 extends Impl20 {

        /* renamed from: m  reason: collision with root package name */
        private Insets f6590m = null;

        Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat b() {
            return WindowInsetsCompat.K(this.f6585c.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat c() {
            return WindowInsetsCompat.K(this.f6585c.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public final Insets j() {
            if (this.f6590m == null) {
                this.f6590m = Insets.d(this.f6585c.getStableInsetLeft(), this.f6585c.getStableInsetTop(), this.f6585c.getStableInsetRight(), this.f6585c.getStableInsetBottom());
            }
            return this.f6590m;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return this.f6585c.isConsumed();
        }

        public void u(@Nullable Insets insets) {
            this.f6590m = insets;
        }

        Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl21 impl21) {
            super(windowInsetsCompat, (Impl20) impl21);
            this.f6590m = impl21.f6590m;
        }
    }

    @RequiresApi(28)
    private static class Impl28 extends Impl21 {
        Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.K(this.f6585c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            return Objects.equals(this.f6585c, impl28.f6585c) && Objects.equals(this.f6589g, impl28.f6589g);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public DisplayCutoutCompat f() {
            return DisplayCutoutCompat.i(this.f6585c.getDisplayCutout());
        }

        public int hashCode() {
            return this.f6585c.hashCode();
        }

        Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl28 impl28) {
            super(windowInsetsCompat, (Impl21) impl28);
        }
    }

    @RequiresApi(29)
    private static class Impl29 extends Impl28 {

        /* renamed from: n  reason: collision with root package name */
        private Insets f6591n = null;
        private Insets o = null;
        private Insets p = null;

        Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets i() {
            if (this.o == null) {
                this.o = Insets.g(this.f6585c.getMandatorySystemGestureInsets());
            }
            return this.o;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets k() {
            if (this.f6591n == null) {
                this.f6591n = Insets.g(this.f6585c.getSystemGestureInsets());
            }
            return this.f6591n;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets m() {
            if (this.p == null) {
                this.p = Insets.g(this.f6585c.getTappableElementInsets());
            }
            return this.p;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat n(int i2, int i3, int i4, int i5) {
            return WindowInsetsCompat.K(this.f6585c.inset(i2, i3, i4, i5));
        }

        public void u(@Nullable Insets insets) {
        }

        Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, (Impl28) impl29);
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl29 {
        @NonNull
        static final WindowInsetsCompat q = WindowInsetsCompat.K(WindowInsets.CONSUMED);

        Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public final void d(@NonNull View view) {
        }

        @NonNull
        public Insets g(int i2) {
            return Insets.g(this.f6585c.getInsets(TypeImpl30.a(i2)));
        }

        @NonNull
        public Insets h(int i2) {
            return Insets.g(this.f6585c.getInsetsIgnoringVisibility(TypeImpl30.a(i2)));
        }

        public boolean q(int i2) {
            return this.f6585c.isVisible(TypeImpl30.a(i2));
        }

        Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl30 impl30) {
            super(windowInsetsCompat, (Impl29) impl30);
        }
    }

    public static final class Type {

        /* renamed from: a  reason: collision with root package name */
        static final int f6592a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final int f6593b = 1;

        /* renamed from: c  reason: collision with root package name */
        static final int f6594c = 2;

        /* renamed from: d  reason: collision with root package name */
        static final int f6595d = 4;

        /* renamed from: e  reason: collision with root package name */
        static final int f6596e = 8;

        /* renamed from: f  reason: collision with root package name */
        static final int f6597f = 16;

        /* renamed from: g  reason: collision with root package name */
        static final int f6598g = 32;

        /* renamed from: h  reason: collision with root package name */
        static final int f6599h = 64;

        /* renamed from: i  reason: collision with root package name */
        static final int f6600i = 128;

        /* renamed from: j  reason: collision with root package name */
        static final int f6601j = 256;

        /* renamed from: k  reason: collision with root package name */
        static final int f6602k = 9;

        /* renamed from: l  reason: collision with root package name */
        static final int f6603l = 256;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        private Type() {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        static int a() {
            return -1;
        }

        public static int b() {
            return 4;
        }

        public static int c() {
            return 128;
        }

        public static int d() {
            return 8;
        }

        static int e(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
        }

        public static int f() {
            return 32;
        }

        public static int g() {
            return 2;
        }

        public static int h() {
            return 1;
        }

        public static int i() {
            return 7;
        }

        public static int j() {
            return 16;
        }

        public static int k() {
            return 64;
        }
    }

    @RequiresApi(30)
    private static final class TypeImpl30 {
        private TypeImpl30() {
        }

        static int a(int i2) {
            int a2;
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i2 & i4) != 0) {
                    if (i4 == 1) {
                        a2 = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        a2 = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        a2 = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        a2 = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        a2 = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        a2 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        a2 = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        a2 = WindowInsets.Type.displayCutout();
                    }
                    i3 |= a2;
                }
            }
            return i3;
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        this.f6563a = i2 >= 30 ? new Impl30(this, windowInsets) : i2 >= 29 ? new Impl29(this, windowInsets) : i2 >= 28 ? new Impl28(this, windowInsets) : new Impl21(this, windowInsets);
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat K(@NonNull WindowInsets windowInsets) {
        return L(windowInsets, (View) null);
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat L(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.l(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.H(ViewCompat.r0(view));
            windowInsetsCompat.d(view.getRootView());
        }
        return windowInsetsCompat;
    }

    static Insets z(@NonNull Insets insets, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, insets.f5824a - i2);
        int max2 = Math.max(0, insets.f5825b - i3);
        int max3 = Math.max(0, insets.f5826c - i4);
        int max4 = Math.max(0, insets.f5827d - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? insets : Insets.d(max, max2, max3, max4);
    }

    public boolean A() {
        return this.f6563a.o();
    }

    public boolean B() {
        return this.f6563a.p();
    }

    public boolean C(int i2) {
        return this.f6563a.q(i2);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat D(int i2, int i3, int i4, int i5) {
        return new Builder(this).h(Insets.d(i2, i3, i4, i5)).a();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat E(@NonNull Rect rect) {
        return new Builder(this).h(Insets.e(rect)).a();
    }

    /* access modifiers changed from: package-private */
    public void F(Insets[] insetsArr) {
        this.f6563a.r(insetsArr);
    }

    /* access modifiers changed from: package-private */
    public void G(@NonNull Insets insets) {
        this.f6563a.s(insets);
    }

    /* access modifiers changed from: package-private */
    public void H(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.f6563a.t(windowInsetsCompat);
    }

    /* access modifiers changed from: package-private */
    public void I(@Nullable Insets insets) {
        this.f6563a.u(insets);
    }

    @RequiresApi(20)
    @Nullable
    public WindowInsets J() {
        Impl impl = this.f6563a;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).f6585c;
        }
        return null;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat a() {
        return this.f6563a.a();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat b() {
        return this.f6563a.b();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat c() {
        return this.f6563a.c();
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull View view) {
        this.f6563a.d(view);
    }

    @Nullable
    public DisplayCutoutCompat e() {
        return this.f6563a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.a(this.f6563a, ((WindowInsetsCompat) obj).f6563a);
    }

    @NonNull
    public Insets f(int i2) {
        return this.f6563a.g(i2);
    }

    @NonNull
    public Insets g(int i2) {
        return this.f6563a.h(i2);
    }

    @NonNull
    @Deprecated
    public Insets h() {
        return this.f6563a.i();
    }

    public int hashCode() {
        Impl impl = this.f6563a;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f6563a.j().f5827d;
    }

    @Deprecated
    public int j() {
        return this.f6563a.j().f5824a;
    }

    @Deprecated
    public int k() {
        return this.f6563a.j().f5826c;
    }

    @Deprecated
    public int l() {
        return this.f6563a.j().f5825b;
    }

    @NonNull
    @Deprecated
    public Insets m() {
        return this.f6563a.j();
    }

    @NonNull
    @Deprecated
    public Insets n() {
        return this.f6563a.k();
    }

    @Deprecated
    public int o() {
        return this.f6563a.l().f5827d;
    }

    @Deprecated
    public int p() {
        return this.f6563a.l().f5824a;
    }

    @Deprecated
    public int q() {
        return this.f6563a.l().f5826c;
    }

    @Deprecated
    public int r() {
        return this.f6563a.l().f5825b;
    }

    @NonNull
    @Deprecated
    public Insets s() {
        return this.f6563a.l();
    }

    @NonNull
    @Deprecated
    public Insets t() {
        return this.f6563a.m();
    }

    public boolean u() {
        Insets f2 = f(Type.a());
        Insets insets = Insets.f5823e;
        return !f2.equals(insets) || !g(Type.a() ^ Type.d()).equals(insets) || e() != null;
    }

    @Deprecated
    public boolean v() {
        return !this.f6563a.j().equals(Insets.f5823e);
    }

    @Deprecated
    public boolean w() {
        return !this.f6563a.l().equals(Insets.f5823e);
    }

    @NonNull
    public WindowInsetsCompat x(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, @IntRange(from = 0) int i5) {
        return this.f6563a.n(i2, i3, i4, i5);
    }

    @NonNull
    public WindowInsetsCompat y(@NonNull Insets insets) {
        return x(insets.f5824a, insets.f5825b, insets.f5826c, insets.f5827d);
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.f6563a;
            int i2 = Build.VERSION.SDK_INT;
            this.f6563a = (i2 < 30 || !(impl instanceof Impl30)) ? (i2 < 29 || !(impl instanceof Impl29)) ? (i2 < 28 || !(impl instanceof Impl28)) ? impl instanceof Impl21 ? new Impl21(this, (Impl21) impl) : impl instanceof Impl20 ? new Impl20(this, (Impl20) impl) : new Impl(this) : new Impl28(this, (Impl28) impl) : new Impl29(this, (Impl29) impl) : new Impl30(this, (Impl30) impl);
            impl.e(this);
            return;
        }
        this.f6563a = new Impl(this);
    }
}
