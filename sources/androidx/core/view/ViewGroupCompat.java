package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class ViewGroupCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6521a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6522b = 1;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        @DoNotInline
        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        @DoNotInline
        static void c(ViewGroup viewGroup, boolean z) {
            viewGroup.setTransitionGroup(z);
        }
    }

    private ViewGroupCompat() {
    }

    public static int a(@NonNull ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }

    public static int b(@NonNull ViewGroup viewGroup) {
        return Api21Impl.a(viewGroup);
    }

    public static boolean c(@NonNull ViewGroup viewGroup) {
        return Api21Impl.b(viewGroup);
    }

    @Deprecated
    public static boolean d(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void e(@NonNull ViewGroup viewGroup, int i2) {
        viewGroup.setLayoutMode(i2);
    }

    @Deprecated
    public static void f(ViewGroup viewGroup, boolean z) {
        viewGroup.setMotionEventSplittingEnabled(z);
    }

    public static void g(@NonNull ViewGroup viewGroup, boolean z) {
        Api21Impl.c(viewGroup, z);
    }
}
