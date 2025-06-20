package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.SimpleArrayMap;
import androidx.core.R;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ViewCompat {
    @Deprecated
    public static final int A = 16777216;
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 0;
    public static final int F = 1;
    public static final int G = 1;
    public static final int H = 2;
    public static final int I = 4;
    public static final int J = 8;
    public static final int K = 16;
    public static final int L = 32;
    private static Method M = null;
    private static Method N = null;
    private static boolean O = false;
    private static WeakHashMap<View, String> P = null;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> Q = null;
    private static Method R = null;
    private static Field S = null;
    private static boolean T = false;
    private static ThreadLocal<Rect> U = null;
    private static final int[] V = {R.id.f5146b, R.id.f5147c, R.id.f5158n, R.id.y, R.id.B, R.id.C, R.id.D, R.id.E, R.id.F, R.id.G, R.id.f5148d, R.id.f5149e, R.id.f5150f, R.id.f5151g, R.id.f5152h, R.id.f5153i, R.id.f5154j, R.id.f5155k, R.id.f5156l, R.id.f5157m, R.id.o, R.id.p, R.id.q, R.id.r, R.id.s, R.id.t, R.id.u, R.id.v, R.id.w, R.id.x, R.id.z, R.id.A};
    private static final OnReceiveContentViewBehavior W = new H();
    private static final AccessibilityPaneVisibilityManager X = new AccessibilityPaneVisibilityManager();

    /* renamed from: a  reason: collision with root package name */
    private static final String f6489a = "ViewCompat";
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final int f6490b = 0;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final int f6491c = 1;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final int f6492d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6493e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f6494f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f6495g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final int f6496h = 4;

    /* renamed from: i  reason: collision with root package name */
    public static final int f6497i = 8;
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    public static final int f6498j = 0;
    @Deprecated

    /* renamed from: k  reason: collision with root package name */
    public static final int f6499k = 1;
    @Deprecated

    /* renamed from: l  reason: collision with root package name */
    public static final int f6500l = 2;
    @Deprecated

    /* renamed from: m  reason: collision with root package name */
    public static final int f6501m = 4;

    /* renamed from: n  reason: collision with root package name */
    public static final int f6502n = 0;
    public static final int o = 1;
    public static final int p = 2;
    @Deprecated
    public static final int q = 0;
    @Deprecated
    public static final int r = 1;
    @Deprecated
    public static final int s = 2;
    @Deprecated
    public static final int t = 0;
    @Deprecated
    public static final int u = 1;
    @Deprecated
    public static final int v = 2;
    @Deprecated
    public static final int w = 3;
    @Deprecated
    public static final int x = 16777215;
    @Deprecated
    public static final int y = -16777216;
    @Deprecated
    public static final int z = 16;

    static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap<View, Boolean> s = new WeakHashMap<>();

        AccessibilityPaneVisibilityManager() {
        }

        private void b(Map.Entry<View, Boolean> entry) {
            View key = entry.getKey();
            boolean booleanValue = entry.getValue().booleanValue();
            boolean z = key.isShown() && key.getWindowVisibility() == 0;
            if (booleanValue != z) {
                ViewCompat.h1(key, z ? 16 : 32);
                entry.setValue(Boolean.valueOf(z));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            this.s.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
            this.s.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> b2 : this.s.entrySet()) {
                    b(b2);
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class AccessibilityViewProperty<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f6503a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f6504b;

        /* renamed from: c  reason: collision with root package name */
        private final int f6505c;

        /* renamed from: d  reason: collision with root package name */
        private final int f6506d;

        AccessibilityViewProperty(int i2, Class<T> cls, int i3) {
            this(i2, cls, 0, i3);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f6505c;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        /* access modifiers changed from: package-private */
        public abstract T c(View view);

        /* access modifiers changed from: package-private */
        public abstract void d(View view, T t);

        /* access modifiers changed from: package-private */
        public T e(View view) {
            if (b()) {
                return c(view);
            }
            T tag = view.getTag(this.f6503a);
            if (this.f6504b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void f(View view, T t) {
            if (b()) {
                d(view, t);
            } else if (g(e(view), t)) {
                ViewCompat.C(view);
                view.setTag(this.f6503a, t);
                ViewCompat.h1(view, this.f6506d);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean g(T t, T t2) {
            return !t2.equals(t);
        }

        AccessibilityViewProperty(int i2, Class<T> cls, int i3, int i4) {
            this.f6503a = i2;
            this.f6504b = cls;
            this.f6506d = i3;
            this.f6505c = i4;
        }
    }

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        @DoNotInline
        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        @DoNotInline
        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void a(@NonNull WindowInsets windowInsets, @NonNull View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.r0);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        @DoNotInline
        static WindowInsetsCompat b(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            WindowInsets J = windowInsetsCompat.J();
            if (J != null) {
                return WindowInsetsCompat.L(view.computeSystemWindowInsets(J, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        @DoNotInline
        static boolean c(@NonNull View view, float f2, float f3, boolean z) {
            return view.dispatchNestedFling(f2, f3, z);
        }

        @DoNotInline
        static boolean d(@NonNull View view, float f2, float f3) {
            return view.dispatchNestedPreFling(f2, f3);
        }

        @DoNotInline
        static boolean e(View view, int i2, int i3, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }

        @DoNotInline
        static boolean f(View view, int i2, int i3, int i4, int i5, int[] iArr) {
            return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }

        @DoNotInline
        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        @DoNotInline
        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        @DoNotInline
        static float i(View view) {
            return view.getElevation();
        }

        @DoNotInline
        @Nullable
        public static WindowInsetsCompat j(@NonNull View view) {
            return WindowInsetsCompat.Api21ReflectionHolder.a(view);
        }

        @DoNotInline
        static String k(View view) {
            return view.getTransitionName();
        }

        @DoNotInline
        static float l(View view) {
            return view.getTranslationZ();
        }

        @DoNotInline
        static float m(@NonNull View view) {
            return view.getZ();
        }

        @DoNotInline
        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        @DoNotInline
        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        @DoNotInline
        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        @DoNotInline
        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        @DoNotInline
        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        @DoNotInline
        static void s(View view, float f2) {
            view.setElevation(f2);
        }

        @DoNotInline
        static void t(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        @DoNotInline
        static void u(@NonNull final View view, @Nullable final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.j0, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.r0));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {

                    /* renamed from: a  reason: collision with root package name */
                    WindowInsetsCompat f6507a = null;

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        WindowInsetsCompat L = WindowInsetsCompat.L(windowInsets, view);
                        int i2 = Build.VERSION.SDK_INT;
                        if (i2 < 30) {
                            Api21Impl.a(windowInsets, view);
                            if (L.equals(this.f6507a)) {
                                return onApplyWindowInsetsListener.a(view, L).J();
                            }
                        }
                        this.f6507a = L;
                        WindowInsetsCompat a2 = onApplyWindowInsetsListener.a(view, L);
                        if (i2 >= 30) {
                            return a2.J();
                        }
                        ViewCompat.B1(view);
                        return a2.J();
                    }
                });
            }
        }

        @DoNotInline
        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        @DoNotInline
        static void w(View view, float f2) {
            view.setTranslationZ(f2);
        }

        @DoNotInline
        static void x(@NonNull View view, float f2) {
            view.setZ(f2);
        }

        @DoNotInline
        static boolean y(View view, int i2) {
            return view.startNestedScroll(i2);
        }

        @DoNotInline
        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @Nullable
        public static WindowInsetsCompat a(@NonNull View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat K = WindowInsetsCompat.K(rootWindowInsets);
            K.H(K);
            K.d(view.getRootView());
            return K;
        }

        @DoNotInline
        static int b(@NonNull View view) {
            return view.getScrollIndicators();
        }

        @DoNotInline
        static void c(@NonNull View view, int i2) {
            view.setScrollIndicators(i2);
        }

        @DoNotInline
        static void d(@NonNull View view, int i2, int i3) {
            view.setScrollIndicators(i2, i3);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void a(@NonNull View view) {
            view.cancelDragAndDrop();
        }

        @DoNotInline
        static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        @DoNotInline
        static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        @DoNotInline
        static void d(@NonNull View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        @DoNotInline
        static boolean e(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i2) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i2);
        }

        @DoNotInline
        static void f(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void a(@NonNull View view, Collection<View> collection, int i2) {
            view.addKeyboardNavigationClusters(collection, i2);
        }

        @DoNotInline
        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        @DoNotInline
        static int c(View view) {
            return view.getImportantForAutofill();
        }

        @DoNotInline
        static int d(@NonNull View view) {
            return view.getNextClusterForwardId();
        }

        @DoNotInline
        static boolean e(@NonNull View view) {
            return view.hasExplicitFocusable();
        }

        @DoNotInline
        static boolean f(@NonNull View view) {
            return view.isFocusedByDefault();
        }

        @DoNotInline
        static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        @DoNotInline
        static boolean h(@NonNull View view) {
            return view.isKeyboardNavigationCluster();
        }

        @DoNotInline
        static View i(@NonNull View view, View view2, int i2) {
            return view.keyboardNavigationClusterSearch(view2, i2);
        }

        @DoNotInline
        static boolean j(@NonNull View view) {
            return view.restoreDefaultFocus();
        }

        @DoNotInline
        static void k(@NonNull View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        @DoNotInline
        static void l(@NonNull View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        @DoNotInline
        static void m(View view, int i2) {
            view.setImportantForAutofill(i2);
        }

        @DoNotInline
        static void n(@NonNull View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        @DoNotInline
        static void o(View view, int i2) {
            view.setNextClusterForwardId(i2);
        }

        @DoNotInline
        static void p(@NonNull View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void a(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            int i2 = R.id.q0;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(i2);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(i2, simpleArrayMap);
            }
            Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
            I i3 = new I(onUnhandledKeyEventListenerCompat);
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, i3);
            view.addOnUnhandledKeyEventListener(i3);
        }

        @DoNotInline
        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @DoNotInline
        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        @DoNotInline
        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        @DoNotInline
        static void e(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.q0);
            if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        @DoNotInline
        static <T> T f(View view, int i2) {
            return view.requireViewById(i2);
        }

        @DoNotInline
        static void g(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        @DoNotInline
        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        @DoNotInline
        public static void i(View view, AutofillIdCompat autofillIdCompat) {
            view.setAutofillId(autofillIdCompat == null ? null : autofillIdCompat.a());
        }

        @DoNotInline
        static void j(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        @DoNotInline
        static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        @DoNotInline
        static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        @DoNotInline
        static void d(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }

        @DoNotInline
        static void e(View view, ContentCaptureSessionCompat contentCaptureSessionCompat) {
            view.setContentCaptureSession(contentCaptureSessionCompat == null ? null : contentCaptureSessionCompat.f());
        }

        @DoNotInline
        static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static int a(View view) {
            return view.getImportantForContentCapture();
        }

        @DoNotInline
        static CharSequence b(View view) {
            return view.getStateDescription();
        }

        @Nullable
        public static WindowInsetsControllerCompat c(@NonNull View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return WindowInsetsControllerCompat.l(windowInsetsController);
            }
            return null;
        }

        @DoNotInline
        static boolean d(View view) {
            return view.isImportantForContentCapture();
        }

        @DoNotInline
        static void e(View view, int i2) {
            view.setImportantForContentCapture(i2);
        }

        @DoNotInline
        static void f(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    @RequiresApi(31)
    private static final class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        @Nullable
        public static String[] a(@NonNull View view) {
            return view.getReceiveContentMimeTypes();
        }

        @DoNotInline
        @Nullable
        public static ContentInfoCompat b(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
            ContentInfo l2 = contentInfoCompat.l();
            ContentInfo performReceiveContent = view.performReceiveContent(l2);
            if (performReceiveContent == null) {
                return null;
            }
            return performReceiveContent == l2 ? contentInfoCompat : ContentInfoCompat.m(performReceiveContent);
        }

        @DoNotInline
        public static void c(@NonNull View view, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
            if (onReceiveContentListener == null) {
                view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
            } else {
                view.setOnReceiveContentListener(strArr, new OnReceiveContentListenerAdapter(onReceiveContentListener));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    @RequiresApi(31)
    private static final class OnReceiveContentListenerAdapter implements OnReceiveContentListener {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final OnReceiveContentListener f6510a;

        OnReceiveContentListenerAdapter(@NonNull OnReceiveContentListener onReceiveContentListener) {
            this.f6510a = onReceiveContentListener;
        }

        @Nullable
        public ContentInfo onReceiveContent(@NonNull View view, @NonNull ContentInfo contentInfo) {
            ContentInfoCompat m2 = ContentInfoCompat.m(contentInfo);
            ContentInfoCompat a2 = this.f6510a.a(view, m2);
            if (a2 == null) {
                return null;
            }
            return a2 == m2 ? contentInfo : a2.l();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    static class UnhandledKeyEventManager {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f6511d = new ArrayList<>();
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f6512a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f6513b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<KeyEvent> f6514c = null;

        UnhandledKeyEventManager() {
        }

        static UnhandledKeyEventManager a(View view) {
            int i2 = R.id.p0;
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(i2);
            if (unhandledKeyEventManager != null) {
                return unhandledKeyEventManager;
            }
            UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
            view.setTag(i2, unhandledKeyEventManager2);
            return unhandledKeyEventManager2;
        }

        @Nullable
        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f6512a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c2 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c2 != null) {
                            return c2;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f6513b == null) {
                this.f6513b = new SparseArray<>();
            }
            return this.f6513b;
        }

        private boolean e(@NonNull View view, @NonNull KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.q0);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f6512a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f6511d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    try {
                        if (this.f6512a == null) {
                            this.f6512a = new WeakHashMap<>();
                        }
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ArrayList<WeakReference<View>> arrayList2 = f6511d;
                            View view = (View) arrayList2.get(size).get();
                            if (view == null) {
                                arrayList2.remove(size);
                            } else {
                                this.f6512a.put(view, Boolean.TRUE);
                                for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    this.f6512a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }

        static void h(View view) {
            ArrayList<WeakReference<View>> arrayList = f6511d;
            synchronized (arrayList) {
                try {
                    Iterator<WeakReference<View>> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().get() == view) {
                            return;
                        }
                    }
                    f6511d.add(new WeakReference(view));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        static void i(View view) {
            synchronized (f6511d) {
                int i2 = 0;
                while (true) {
                    try {
                        ArrayList<WeakReference<View>> arrayList = f6511d;
                        if (i2 >= arrayList.size()) {
                            return;
                        }
                        if (arrayList.get(i2).get() == view) {
                            arrayList.remove(i2);
                            return;
                        }
                        i2++;
                    } finally {
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c2 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c2));
                }
            }
            return c2 != null;
        }

        /* access modifiers changed from: package-private */
        public boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int indexOfKey;
            WeakReference<KeyEvent> weakReference2 = this.f6514c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f6514c = new WeakReference<>(keyEvent);
            SparseArray<WeakReference<View>> d2 = d();
            if (keyEvent.getAction() != 1 || (indexOfKey = d2.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = d2.valueAt(indexOfKey);
                d2.removeAt(indexOfKey);
            }
            if (weakReference == null) {
                weakReference = d2.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    @Deprecated
    protected ViewCompat() {
    }

    @UiThread
    static boolean A(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.a(view).f(keyEvent);
    }

    @Nullable
    public static String A0(@NonNull View view) {
        return Api21Impl.k(view);
    }

    public static void A1(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, @Nullable CharSequence charSequence, @Nullable AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            x1(view, accessibilityActionCompat.b());
        } else {
            d(view, accessibilityActionCompat.a(charSequence, accessibilityViewCommand));
        }
    }

    @UiThread
    public static void A2(@NonNull View view, @Nullable CharSequence charSequence) {
        O2().f(view, charSequence);
    }

    public static void B(@NonNull View view) {
        C(view);
    }

    @Deprecated
    public static float B0(View view) {
        return view.getTranslationX();
    }

    public static void B1(@NonNull View view) {
        Api20Impl.c(view);
    }

    public static void B2(@NonNull View view, @NonNull List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.f(view, list);
        }
    }

    static void C(@NonNull View view) {
        AccessibilityDelegateCompat E2 = E(view);
        if (E2 == null) {
            E2 = new AccessibilityDelegateCompat();
        }
        H1(view, E2);
    }

    @Deprecated
    public static float C0(View view) {
        return view.getTranslationY();
    }

    @NonNull
    public static <T extends View> T C1(@NonNull View view, @IdRes int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) Api28Impl.f(view, i2);
        }
        T findViewById = view.findViewById(i2);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    public static void C2(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.p(view, charSequence);
        }
    }

    @Deprecated
    public static int D() {
        return View.generateViewId();
    }

    public static float D0(@NonNull View view) {
        return Api21Impl.l(view);
    }

    @Deprecated
    public static int D1(int i2, int i3, int i4) {
        return View.resolveSizeAndState(i2, i3, i4);
    }

    public static void D2(@NonNull View view, @Nullable String str) {
        Api21Impl.v(view, str);
    }

    @Nullable
    public static AccessibilityDelegateCompat E(@NonNull View view) {
        View.AccessibilityDelegate F2 = F(view);
        if (F2 == null) {
            return null;
        }
        return F2 instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter ? ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) F2).f6334a : new AccessibilityDelegateCompat(F2);
    }

    @Deprecated
    @Nullable
    public static WindowInsetsControllerCompat E0(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.c(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return WindowCompat.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static boolean E1(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.j(view) : view.requestFocus();
    }

    @Deprecated
    public static void E2(View view, float f2) {
        view.setTranslationX(f2);
    }

    @Nullable
    private static View.AccessibilityDelegate F(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 29 ? Api29Impl.a(view) : G(view);
    }

    @Deprecated
    public static int F0(@NonNull View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static void F1(@NonNull View view, @SuppressLint({"ContextFirst"}) @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.d(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    @Deprecated
    public static void F2(View view, float f2) {
        view.setTranslationY(f2);
    }

    @Nullable
    private static View.AccessibilityDelegate G(@NonNull View view) {
        if (T) {
            return null;
        }
        if (S == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                S = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                T = true;
                return null;
            }
        }
        try {
            Object obj = S.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            T = true;
            return null;
        }
    }

    @Deprecated
    public static float G0(View view) {
        return view.getX();
    }

    private static AccessibilityViewProperty<Boolean> G1() {
        return new AccessibilityViewProperty<Boolean>(R.id.m0, Boolean.class, 28) {
            /* access modifiers changed from: package-private */
            @RequiresApi(28)
            /* renamed from: h */
            public Boolean c(@NonNull View view) {
                return Boolean.valueOf(Api28Impl.d(view));
            }

            /* access modifiers changed from: package-private */
            @RequiresApi(28)
            /* renamed from: i */
            public void d(@NonNull View view, Boolean bool) {
                Api28Impl.j(view, bool.booleanValue());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public boolean g(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    public static void G2(@NonNull View view, float f2) {
        Api21Impl.w(view, f2);
    }

    @Deprecated
    public static int H(@NonNull View view) {
        return view.getAccessibilityLiveRegion();
    }

    @Deprecated
    public static float H0(View view) {
        return view.getY();
    }

    public static void H1(@NonNull View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat) {
        if (accessibilityDelegateCompat == null && (F(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        a2(view);
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.d());
    }

    public static void H2(@NonNull View view, @Nullable WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.h(view, callback);
    }

    @Nullable
    public static AccessibilityNodeProviderCompat I(@NonNull View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    public static float I0(@NonNull View view) {
        return Api21Impl.m(view);
    }

    @UiThread
    public static void I1(@NonNull View view, boolean z2) {
        b().f(view, Boolean.valueOf(z2));
    }

    @Deprecated
    public static void I2(View view, float f2) {
        view.setX(f2);
    }

    @UiThread
    @Nullable
    public static CharSequence J(@NonNull View view) {
        return o1().e(view);
    }

    public static boolean J0(@NonNull View view) {
        return F(view) != null;
    }

    @Deprecated
    public static void J1(@NonNull View view, int i2) {
        view.setAccessibilityLiveRegion(i2);
    }

    @Deprecated
    public static void J2(View view, float f2) {
        view.setY(f2);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> K(View view) {
        int i2 = R.id.f0;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i2, arrayList2);
        return arrayList2;
    }

    public static boolean K0(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.e(view) : view.hasFocusable();
    }

    @UiThread
    public static void K1(@NonNull View view, @Nullable CharSequence charSequence) {
        o1().f(view, charSequence);
        if (charSequence != null) {
            X.a(view);
        } else {
            X.d(view);
        }
    }

    public static void K2(@NonNull View view, float f2) {
        Api21Impl.x(view, f2);
    }

    @Deprecated
    public static float L(View view) {
        return view.getAlpha();
    }

    public static boolean L0(@NonNull View view) {
        return Api21Impl.n(view);
    }

    @Deprecated
    public static void L1(View view, boolean z2) {
        view.setActivated(z2);
    }

    public static boolean L2(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i2) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.e(view, clipData, dragShadowBuilder, obj, i2) : view.startDrag(clipData, dragShadowBuilder, obj, i2);
    }

    @Nullable
    public static AutofillIdCompat M(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return AutofillIdCompat.b(Api26Impl.b(view));
        }
        return null;
    }

    public static boolean M0(@NonNull View view, int i2) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).d(i2);
            return false;
        } else if (i2 == 0) {
            return L0(view);
        } else {
            return false;
        }
    }

    @Deprecated
    public static void M1(View view, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        view.setAlpha(f2);
    }

    public static boolean M2(@NonNull View view, int i2) {
        return Api21Impl.y(view, i2);
    }

    private static int N(View view, @NonNull CharSequence charSequence) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> K2 = K(view);
        for (int i2 = 0; i2 < K2.size(); i2++) {
            if (TextUtils.equals(charSequence, K2.get(i2).c())) {
                return K2.get(i2).b();
            }
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            int[] iArr = V;
            if (i3 >= iArr.length || i4 != -1) {
                return i4;
            }
            int i5 = iArr[i3];
            boolean z2 = true;
            for (int i6 = 0; i6 < K2.size(); i6++) {
                z2 &= K2.get(i6).b() != i5;
            }
            if (z2) {
                i4 = i5;
            }
            i3++;
        }
        return i4;
    }

    @Deprecated
    public static boolean N0(@NonNull View view) {
        return view.hasOnClickListeners();
    }

    public static void N1(@NonNull View view, @Nullable String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.k(view, strArr);
        }
    }

    public static boolean N2(@NonNull View view, int i2, int i3) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).f(i2, i3);
        }
        if (i3 == 0) {
            return M2(view, i2);
        }
        return false;
    }

    @Nullable
    public static ColorStateList O(@NonNull View view) {
        return Api21Impl.g(view);
    }

    @Deprecated
    public static boolean O0(@NonNull View view) {
        return view.hasOverlappingRendering();
    }

    public static void O1(@NonNull View view, @Nullable AutofillIdCompat autofillIdCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.i(view, autofillIdCompat);
        }
    }

    private static AccessibilityViewProperty<CharSequence> O2() {
        return new AccessibilityViewProperty<CharSequence>(R.id.n0, CharSequence.class, 64, 30) {
            /* access modifiers changed from: package-private */
            @RequiresApi(30)
            /* renamed from: h */
            public CharSequence c(View view) {
                return Api30Impl.b(view);
            }

            /* access modifiers changed from: package-private */
            @RequiresApi(30)
            /* renamed from: i */
            public void d(View view, CharSequence charSequence) {
                Api30Impl.f(view, charSequence);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public boolean g(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    @Nullable
    public static PorterDuff.Mode P(@NonNull View view) {
        return Api21Impl.h(view);
    }

    @Deprecated
    public static boolean P0(@NonNull View view) {
        return view.hasTransientState();
    }

    @Deprecated
    public static void P1(@NonNull View view, @Nullable Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void P2(@NonNull View view) {
        Api21Impl.z(view);
    }

    @Deprecated
    @Nullable
    public static Rect Q(@NonNull View view) {
        return view.getClipBounds();
    }

    @UiThread
    public static boolean Q0(@NonNull View view) {
        Boolean e2 = b().e(view);
        return e2 != null && e2.booleanValue();
    }

    public static void Q1(@NonNull View view, @Nullable ColorStateList colorStateList) {
        int i2 = Build.VERSION.SDK_INT;
        Api21Impl.q(view, colorStateList);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (Api21Impl.g(view) == null && Api21Impl.h(view) == null) ? false : true;
            if (background != null && z2) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static void Q2(@NonNull View view, int i2) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).h(i2);
        } else if (i2 == 0) {
            P2(view);
        }
    }

    @Nullable
    public static ContentCaptureSessionCompat R(@NonNull View view) {
        ContentCaptureSession b2;
        if (Build.VERSION.SDK_INT < 29 || (b2 = Api29Impl.b(view)) == null) {
            return null;
        }
        return ContentCaptureSessionCompat.g(b2, view);
    }

    @Deprecated
    public static boolean R0(@NonNull View view) {
        return view.isAttachedToWindow();
    }

    public static void R1(@NonNull View view, @Nullable PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        Api21Impl.r(view, mode);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (Api21Impl.g(view) == null && Api21Impl.h(view) == null) ? false : true;
            if (background != null && z2) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    private static void R2(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    @Deprecated
    @Nullable
    public static Display S(@NonNull View view) {
        return view.getDisplay();
    }

    public static boolean S0(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.f(view);
        }
        return false;
    }

    @SuppressLint({"BanUncheckedReflection"})
    @Deprecated
    public static void S1(ViewGroup viewGroup, boolean z2) {
        if (R == null) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                R = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException e2) {
                Log.e(f6489a, "Unable to find childrenDrawingOrderEnabled", e2);
            }
            R.setAccessible(true);
        }
        try {
            R.invoke(viewGroup, new Object[]{Boolean.valueOf(z2)});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
            Log.e(f6489a, "Unable to invoke childrenDrawingOrderEnabled", e3);
        }
    }

    public static void S2(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.f(view, dragShadowBuilder);
        }
    }

    public static float T(@NonNull View view) {
        return Api21Impl.i(view);
    }

    public static boolean T0(@NonNull View view) {
        return Api21Impl.o(view);
    }

    @Deprecated
    public static void T1(@NonNull View view, @Nullable Rect rect) {
        view.setClipBounds(rect);
    }

    private static Rect U() {
        if (U == null) {
            U = new ThreadLocal<>();
        }
        Rect rect = U.get();
        if (rect == null) {
            rect = new Rect();
            U.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static boolean U0(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.g(view);
        }
        return true;
    }

    public static void U1(@NonNull View view, @Nullable ContentCaptureSessionCompat contentCaptureSessionCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.e(view, contentCaptureSessionCompat);
        }
    }

    private static OnReceiveContentViewBehavior V(@NonNull View view) {
        return view instanceof OnReceiveContentViewBehavior ? (OnReceiveContentViewBehavior) view : W;
    }

    public static boolean V0(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.d(view);
        }
        return false;
    }

    public static void V1(@NonNull View view, float f2) {
        Api21Impl.s(view, f2);
    }

    @Deprecated
    public static boolean W(@NonNull View view) {
        return view.getFitsSystemWindows();
    }

    @Deprecated
    public static boolean W0(@NonNull View view) {
        return view.isInLayout();
    }

    @Deprecated
    public static void W1(View view, boolean z2) {
        view.setFitsSystemWindows(z2);
    }

    @Deprecated
    public static int X(@NonNull View view) {
        return view.getImportantForAccessibility();
    }

    public static boolean X0(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.h(view);
        }
        return false;
    }

    public static void X1(@NonNull View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.l(view, z2);
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int Y(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.c(view);
        }
        return 0;
    }

    @Deprecated
    public static boolean Y0(@NonNull View view) {
        return view.isLaidOut();
    }

    @Deprecated
    public static void Y1(@NonNull View view, boolean z2) {
        view.setHasTransientState(z2);
    }

    public static int Z(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.a(view);
        }
        return 0;
    }

    @Deprecated
    public static boolean Z0(@NonNull View view) {
        return view.isLayoutDirectionResolved();
    }

    @UiThread
    @Deprecated
    public static void Z1(@NonNull View view, int i2) {
        view.setImportantForAccessibility(i2);
    }

    @Deprecated
    public static int a0(@NonNull View view) {
        return view.getLabelFor();
    }

    public static boolean a1(@NonNull View view) {
        return Api21Impl.p(view);
    }

    private static void a2(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    private static AccessibilityViewProperty<Boolean> b() {
        return new AccessibilityViewProperty<Boolean>(R.id.h0, Boolean.class, 28) {
            /* access modifiers changed from: package-private */
            @RequiresApi(28)
            /* renamed from: h */
            public Boolean c(View view) {
                return Boolean.valueOf(Api28Impl.c(view));
            }

            /* access modifiers changed from: package-private */
            @RequiresApi(28)
            /* renamed from: i */
            public void d(View view, Boolean bool) {
                Api28Impl.g(view, bool.booleanValue());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public boolean g(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    @Deprecated
    public static int b0(View view) {
        return view.getLayerType();
    }

    @Deprecated
    public static boolean b1(View view) {
        return view.isOpaque();
    }

    public static void b2(@NonNull View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.m(view, i2);
        }
    }

    public static int c(@NonNull View view, @NonNull CharSequence charSequence, @NonNull AccessibilityViewCommand accessibilityViewCommand) {
        int N2 = N(view, charSequence);
        if (N2 != -1) {
            d(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(N2, charSequence, accessibilityViewCommand));
        }
        return N2;
    }

    @Deprecated
    public static int c0(@NonNull View view) {
        return view.getLayoutDirection();
    }

    @Deprecated
    public static boolean c1(@NonNull View view) {
        return view.isPaddingRelative();
    }

    public static void c2(@NonNull View view, int i2) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.e(view, i2);
        }
    }

    private static void d(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        C(view);
        y1(accessibilityActionCompat.b(), view);
        K(view).add(accessibilityActionCompat);
        h1(view, 0);
    }

    @Deprecated
    @Nullable
    public static Matrix d0(View view) {
        return view.getMatrix();
    }

    @UiThread
    public static boolean d1(@NonNull View view) {
        Boolean e2 = G1().e(view);
        return e2 != null && e2.booleanValue();
    }

    public static void d2(@NonNull View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.n(view, z2);
        }
    }

    public static void e(@NonNull View view, @NonNull Collection<View> collection, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.a(view, collection, i2);
        }
    }

    @Deprecated
    public static int e0(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static void e1(View view) {
        view.jumpDrawablesToCurrentState();
    }

    @Deprecated
    public static void e2(@NonNull View view, @IdRes int i2) {
        view.setLabelFor(i2);
    }

    public static void f(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.a(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        int i2 = R.id.q0;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(i2, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            UnhandledKeyEventManager.h(view);
        }
    }

    @Deprecated
    public static int f0(View view) {
        return view.getMeasuredState();
    }

    @Nullable
    public static View f1(@NonNull View view, @Nullable View view2, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.i(view, view2, i2);
        }
        return null;
    }

    @Deprecated
    public static void f2(@NonNull View view, @Nullable Paint paint) {
        view.setLayerPaint(paint);
    }

    @NonNull
    @Deprecated
    public static ViewPropertyAnimatorCompat g(@NonNull View view) {
        if (Q == null) {
            Q = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = Q.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        Q.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    @Deprecated
    public static int g0(View view) {
        return view.getMeasuredWidthAndState();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ContentInfoCompat g1(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }

    @Deprecated
    public static void g2(View view, int i2, Paint paint) {
        view.setLayerType(i2, paint);
    }

    private static void h() {
        Class<View> cls = View.class;
        try {
            M = cls.getDeclaredMethod("dispatchStartTemporaryDetach", (Class[]) null);
            N = cls.getDeclaredMethod("dispatchFinishTemporaryDetach", (Class[]) null);
        } catch (NoSuchMethodException e2) {
            Log.e(f6489a, "Couldn't find method", e2);
        }
        O = true;
    }

    @Deprecated
    public static int h0(@NonNull View view) {
        return view.getMinimumHeight();
    }

    static void h1(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z2 = J(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            int i3 = 32;
            if (view.getAccessibilityLiveRegion() != 0 || z2) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z2) {
                    i3 = 2048;
                }
                obtain.setEventType(i3);
                obtain.setContentChangeTypes(i2);
                if (z2) {
                    obtain.getText().add(J(view));
                    a2(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i2 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i2);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(J(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e(f6489a, view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    @Deprecated
    public static void h2(@NonNull View view, int i2) {
        view.setLayoutDirection(i2);
    }

    @Deprecated
    public static boolean i(View view, int i2) {
        return view.canScrollHorizontally(i2);
    }

    @Deprecated
    public static int i0(@NonNull View view) {
        return view.getMinimumWidth();
    }

    public static void i1(@NonNull View view, int i2) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        Rect U2 = U();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            U2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !U2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z2 = false;
        }
        m(view, i2);
        if (z2 && U2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(U2);
        }
    }

    public static void i2(@NonNull View view, boolean z2) {
        Api21Impl.t(view, z2);
    }

    @Deprecated
    public static boolean j(View view, int i2) {
        return view.canScrollVertically(i2);
    }

    public static int j0(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.d(view);
        }
        return -1;
    }

    public static void j1(@NonNull View view, int i2) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        Rect U2 = U();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            U2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !U2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z2 = false;
        }
        n(view, i2);
        if (z2 && U2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(U2);
        }
    }

    public static void j2(@NonNull View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.o(view, i2);
        }
    }

    public static void k(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.a(view);
        }
    }

    @Nullable
    public static String[] k0(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.a(view) : (String[]) view.getTag(R.id.l0);
    }

    @NonNull
    public static WindowInsetsCompat k1(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets J2 = windowInsetsCompat.J();
        if (J2 != null) {
            WindowInsets b2 = Api20Impl.b(view, J2);
            if (!b2.equals(J2)) {
                return WindowInsetsCompat.L(b2, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void k2(@NonNull View view, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Api21Impl.u(view, onApplyWindowInsetsListener);
    }

    @Deprecated
    public static int l(int i2, int i3) {
        return View.combineMeasuredStates(i2, i3);
    }

    @Deprecated
    public static int l0(View view) {
        return view.getOverScrollMode();
    }

    @Deprecated
    public static void l1(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void l2(@NonNull View view, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.c(view, strArr, onReceiveContentListener);
            return;
        }
        if (strArr == null || strArr.length == 0) {
            strArr = null;
        }
        boolean z2 = false;
        if (onReceiveContentListener != null) {
            Preconditions.b(strArr != null, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (strArr[i2].startsWith("*")) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            Preconditions.b(!z2, "A MIME type set here must not start with *: " + Arrays.toString(strArr));
        }
        view.setTag(R.id.l0, strArr);
        view.setTag(R.id.k0, onReceiveContentListener);
    }

    private static void m(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            R2(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                R2((View) parent);
            }
        }
    }

    @Px
    @Deprecated
    public static int m0(@NonNull View view) {
        return view.getPaddingEnd();
    }

    @Deprecated
    public static void m1(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.q2());
    }

    @Deprecated
    public static void m2(View view, int i2) {
        view.setOverScrollMode(i2);
    }

    private static void n(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            R2(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                R2((View) parent);
            }
        }
    }

    @Px
    @Deprecated
    public static int n0(@NonNull View view) {
        return view.getPaddingStart();
    }

    @Deprecated
    public static void n1(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static void n2(@NonNull View view, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        view.setPaddingRelative(i2, i3, i4, i5);
    }

    @NonNull
    public static WindowInsetsCompat o(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        return Api21Impl.b(view, windowInsetsCompat, rect);
    }

    @Deprecated
    @Nullable
    public static ViewParent o0(@NonNull View view) {
        return view.getParentForAccessibility();
    }

    private static AccessibilityViewProperty<CharSequence> o1() {
        return new AccessibilityViewProperty<CharSequence>(R.id.i0, CharSequence.class, 8, 28) {
            /* access modifiers changed from: package-private */
            @RequiresApi(28)
            /* renamed from: h */
            public CharSequence c(View view) {
                return Api28Impl.b(view);
            }

            /* access modifiers changed from: package-private */
            @RequiresApi(28)
            /* renamed from: i */
            public void d(View view, CharSequence charSequence) {
                Api28Impl.h(view, charSequence);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public boolean g(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    @Deprecated
    public static void o2(View view, float f2) {
        view.setPivotX(f2);
    }

    @NonNull
    public static WindowInsetsCompat p(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets J2 = windowInsetsCompat.J();
        if (J2 != null) {
            WindowInsets a2 = Api20Impl.a(view, J2);
            if (!a2.equals(J2)) {
                return WindowInsetsCompat.L(a2, view);
            }
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public static float p0(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static boolean p1(@NonNull View view, int i2, @Nullable Bundle bundle) {
        return view.performAccessibilityAction(i2, bundle);
    }

    @Deprecated
    public static void p2(View view, float f2) {
        view.setPivotY(f2);
    }

    public static void q(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.b(view);
            return;
        }
        if (!O) {
            h();
        }
        Method method = N;
        if (method != null) {
            try {
                method.invoke(view, (Object[]) null);
            } catch (Exception e2) {
                Log.d(f6489a, "Error calling dispatchFinishTemporaryDetach", e2);
            }
        } else {
            view.onFinishTemporaryDetach();
        }
    }

    @Deprecated
    public static float q0(View view) {
        return view.getPivotY();
    }

    public static boolean q1(@NonNull View view, int i2) {
        int a2 = HapticFeedbackConstantsCompat.a(i2);
        if (a2 == -1) {
            return false;
        }
        return view.performHapticFeedback(a2);
    }

    public static void q2(@NonNull View view, @Nullable PointerIconCompat pointerIconCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.d(view, G.a(pointerIconCompat != null ? pointerIconCompat.b() : null));
        }
    }

    public static boolean r(@NonNull View view, float f2, float f3, boolean z2) {
        return Api21Impl.c(view, f2, f3, z2);
    }

    @Nullable
    public static WindowInsetsCompat r0(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.a(view) : Api21Impl.j(view);
    }

    public static boolean r1(@NonNull View view, int i2, int i3) {
        int a2 = HapticFeedbackConstantsCompat.a(i2);
        if (a2 == -1) {
            return false;
        }
        return view.performHapticFeedback(a2, i3);
    }

    @Deprecated
    public static void r2(View view, float f2) {
        view.setRotation(f2);
    }

    public static boolean s(@NonNull View view, float f2, float f3) {
        return Api21Impl.d(view, f2, f3);
    }

    @Deprecated
    public static float s0(View view) {
        return view.getRotation();
    }

    @Nullable
    public static ContentInfoCompat s1(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(f6489a, 3)) {
            Log.d(f6489a, "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.b(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.k0);
        if (onReceiveContentListener == null) {
            return V(view).a(contentInfoCompat);
        }
        ContentInfoCompat a2 = onReceiveContentListener.a(view, contentInfoCompat);
        if (a2 == null) {
            return null;
        }
        return V(view).a(a2);
    }

    @Deprecated
    public static void s2(View view, float f2) {
        view.setRotationX(f2);
    }

    public static boolean t(@NonNull View view, int i2, int i3, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return Api21Impl.e(view, i2, i3, iArr, iArr2);
    }

    @Deprecated
    public static float t0(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static void t1(@NonNull View view) {
        view.postInvalidateOnAnimation();
    }

    @Deprecated
    public static void t2(View view, float f2) {
        view.setRotationY(f2);
    }

    public static boolean u(@NonNull View view, int i2, int i3, @Nullable int[] iArr, @Nullable int[] iArr2, int i4) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).b(i2, i3, iArr, iArr2, i4);
        }
        if (i4 == 0) {
            return t(view, i2, i3, iArr, iArr2);
        }
        return false;
    }

    @Deprecated
    public static float u0(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static void u1(@NonNull View view, int i2, int i3, int i4, int i5) {
        view.postInvalidateOnAnimation(i2, i3, i4, i5);
    }

    @Deprecated
    public static void u2(View view, boolean z2) {
        view.setSaveFromParentEnabled(z2);
    }

    public static void v(@NonNull View view, int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6, @NonNull int[] iArr2) {
        View view2 = view;
        if (view2 instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3) view2).c(i2, i3, i4, i5, iArr, i6, iArr2);
        } else {
            x(view, i2, i3, i4, i5, iArr, i6);
        }
    }

    @Deprecated
    public static float v0(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static void v1(@NonNull View view, @NonNull Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @Deprecated
    public static void v2(View view, float f2) {
        view.setScaleX(f2);
    }

    public static boolean w(@NonNull View view, int i2, int i3, int i4, int i5, @Nullable int[] iArr) {
        return Api21Impl.f(view, i2, i3, i4, i5, iArr);
    }

    @Deprecated
    public static float w0(View view) {
        return view.getScaleY();
    }

    @SuppressLint({"LambdaLast"})
    @Deprecated
    public static void w1(@NonNull View view, @NonNull Runnable runnable, long j2) {
        view.postOnAnimationDelayed(runnable, j2);
    }

    @Deprecated
    public static void w2(View view, float f2) {
        view.setScaleY(f2);
    }

    public static boolean x(@NonNull View view, int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).a(i2, i3, i4, i5, iArr, i6);
        }
        if (i6 == 0) {
            return w(view, i2, i3, i4, i5, iArr);
        }
        return false;
    }

    public static int x0(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(view);
        }
        return 0;
    }

    public static void x1(@NonNull View view, int i2) {
        y1(i2, view);
        h1(view, 0);
    }

    @UiThread
    public static void x2(@NonNull View view, boolean z2) {
        G1().f(view, Boolean.valueOf(z2));
    }

    public static void y(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.c(view);
            return;
        }
        if (!O) {
            h();
        }
        Method method = M;
        if (method != null) {
            try {
                method.invoke(view, (Object[]) null);
            } catch (Exception e2) {
                Log.d(f6489a, "Error calling dispatchStartTemporaryDetach", e2);
            }
        } else {
            view.onStartTemporaryDetach();
        }
    }

    @UiThread
    @Nullable
    public static CharSequence y0(@NonNull View view) {
        return O2().e(view);
    }

    private static void y1(int i2, View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> K2 = K(view);
        for (int i3 = 0; i3 < K2.size(); i3++) {
            if (K2.get(i3).b() == i2) {
                K2.remove(i3);
                return;
            }
        }
    }

    public static void y2(@NonNull View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.c(view, i2);
        }
    }

    @UiThread
    static boolean z(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.a(view).b(view, keyEvent);
    }

    @NonNull
    public static List<Rect> z0(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 29 ? Api29Impl.c(view) : Collections.emptyList();
    }

    public static void z1(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.e(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.q0);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                UnhandledKeyEventManager.i(view);
            }
        }
    }

    public static void z2(@NonNull View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.d(view, i2, i3);
        }
    }
}
