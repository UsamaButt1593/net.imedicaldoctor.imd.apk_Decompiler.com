package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

@ExperimentalBadgeUtils
public class BadgeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f20839a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f20840b = "BadgeUtils";

    private BadgeUtils() {
    }

    /* access modifiers changed from: private */
    public static void b(@NonNull final BadgeDrawable badgeDrawable, @NonNull View view) {
        ViewCompat.H1(view, (Build.VERSION.SDK_INT < 29 || !ViewCompat.J0(view)) ? new AccessibilityDelegateCompat() {
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.o1(BadgeDrawable.this.r());
            }
        } : new AccessibilityDelegateCompat(view.getAccessibilityDelegate()) {
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.o1(badgeDrawable.r());
            }
        });
    }

    public static void c(@NonNull BadgeDrawable badgeDrawable, @NonNull View view) {
        d(badgeDrawable, view, (FrameLayout) null);
    }

    public static void d(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        m(badgeDrawable, view, frameLayout);
        if (badgeDrawable.s() != null) {
            badgeDrawable.s().setForeground(badgeDrawable);
        } else if (!f20839a) {
            view.getOverlay().add(badgeDrawable);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static void e(@NonNull BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i2) {
        f(badgeDrawable, toolbar, i2, (FrameLayout) null);
    }

    public static void f(@NonNull final BadgeDrawable badgeDrawable, @NonNull final Toolbar toolbar, @IdRes final int i2, @Nullable final FrameLayout frameLayout) {
        toolbar.post(new Runnable() {
            public void run() {
                ActionMenuItemView a2 = ToolbarUtils.a(Toolbar.this, i2);
                if (a2 != null) {
                    BadgeUtils.n(badgeDrawable, Toolbar.this.getResources());
                    BadgeUtils.d(badgeDrawable, a2, frameLayout);
                    BadgeUtils.b(badgeDrawable, a2);
                }
            }
        });
    }

    @NonNull
    public static SparseArray<BadgeDrawable> g(Context context, @NonNull ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i2 = 0; i2 < parcelableSparseArray.size(); i2++) {
            int keyAt = parcelableSparseArray.keyAt(i2);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i2);
            sparseArray.put(keyAt, state != null ? BadgeDrawable.h(context, state) : null);
        }
        return sparseArray;
    }

    @NonNull
    public static ParcelableSparseArray h(@NonNull SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            BadgeDrawable valueAt = sparseArray.valueAt(i2);
            parcelableSparseArray.put(keyAt, valueAt != null ? valueAt.G() : null);
        }
        return parcelableSparseArray;
    }

    private static void i(@NonNull View view) {
        ViewCompat.H1(view, (Build.VERSION.SDK_INT < 29 || !ViewCompat.J0(view)) ? null : new AccessibilityDelegateCompat(view.getAccessibilityDelegate()) {
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.o1((CharSequence) null);
            }
        });
    }

    public static void j(@Nullable BadgeDrawable badgeDrawable, @NonNull View view) {
        if (badgeDrawable != null) {
            if (f20839a || badgeDrawable.s() != null) {
                badgeDrawable.s().setForeground((Drawable) null);
            } else {
                view.getOverlay().remove(badgeDrawable);
            }
        }
    }

    public static void k(@Nullable BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i2) {
        if (badgeDrawable != null) {
            ActionMenuItemView a2 = ToolbarUtils.a(toolbar, i2);
            if (a2 != null) {
                l(badgeDrawable);
                j(badgeDrawable, a2);
                i(a2);
                return;
            }
            Log.w(f20840b, "Trying to remove badge from a null menuItemView: " + i2);
        }
    }

    @VisibleForTesting
    static void l(BadgeDrawable badgeDrawable) {
        badgeDrawable.h0(0);
        badgeDrawable.i0(0);
    }

    public static void m(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.P0(view, frameLayout);
    }

    @VisibleForTesting
    static void n(BadgeDrawable badgeDrawable, Resources resources) {
        badgeDrawable.h0(resources.getDimensionPixelOffset(R.dimen.ua));
        badgeDrawable.i0(resources.getDimensionPixelOffset(R.dimen.va));
    }

    public static void o(@NonNull Rect rect, float f2, float f3, float f4, float f5) {
        rect.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
    }
}
