package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* renamed from: d  reason: collision with root package name */
    final RecyclerView f15601d;

    /* renamed from: e  reason: collision with root package name */
    private final ItemDelegate f15602e;

    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* renamed from: d  reason: collision with root package name */
        final RecyclerViewAccessibilityDelegate f15603d;

        /* renamed from: e  reason: collision with root package name */
        private Map<View, AccessibilityDelegateCompat> f15604e = new WeakHashMap();

        public ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f15603d = recyclerViewAccessibilityDelegate;
        }

        public boolean a(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f15604e.get(view);
            return accessibilityDelegateCompat != null ? accessibilityDelegateCompat.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Nullable
        public AccessibilityNodeProviderCompat b(@NonNull View view) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f15604e.get(view);
            return accessibilityDelegateCompat != null ? accessibilityDelegateCompat.b(view) : super.b(view);
        }

        public void f(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f15604e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        public void g(@SuppressLint({"InvalidNullabilityOverride"}) @NonNull View view, @SuppressLint({"InvalidNullabilityOverride"}) @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!this.f15603d.o() && this.f15603d.f15601d.getLayoutManager() != null) {
                this.f15603d.f15601d.getLayoutManager().j1(view, accessibilityNodeInfoCompat);
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.f15604e.get(view);
                if (accessibilityDelegateCompat != null) {
                    accessibilityDelegateCompat.g(view, accessibilityNodeInfoCompat);
                    return;
                }
            }
            super.g(view, accessibilityNodeInfoCompat);
        }

        public void h(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f15604e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        public boolean i(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f15604e.get(viewGroup);
            return accessibilityDelegateCompat != null ? accessibilityDelegateCompat.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        public boolean j(@SuppressLint({"InvalidNullabilityOverride"}) @NonNull View view, int i2, @SuppressLint({"InvalidNullabilityOverride"}) @Nullable Bundle bundle) {
            if (this.f15603d.o() || this.f15603d.f15601d.getLayoutManager() == null) {
                return super.j(view, i2, bundle);
            }
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f15604e.get(view);
            if (accessibilityDelegateCompat != null) {
                if (accessibilityDelegateCompat.j(view, i2, bundle)) {
                    return true;
                }
            } else if (super.j(view, i2, bundle)) {
                return true;
            }
            return this.f15603d.f15601d.getLayoutManager().D1(view, i2, bundle);
        }

        public void l(@NonNull View view, int i2) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f15604e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.l(view, i2);
            } else {
                super.l(view, i2);
            }
        }

        public void m(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f15604e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* access modifiers changed from: package-private */
        public AccessibilityDelegateCompat n(View view) {
            return this.f15604e.remove(view);
        }

        /* access modifiers changed from: package-private */
        public void o(View view) {
            AccessibilityDelegateCompat E = ViewCompat.E(view);
            if (E != null && E != this) {
                this.f15604e.put(view, E);
            }
        }
    }

    public RecyclerViewAccessibilityDelegate(@NonNull RecyclerView recyclerView) {
        this.f15601d = recyclerView;
        AccessibilityDelegateCompat n2 = n();
        this.f15602e = (n2 == null || !(n2 instanceof ItemDelegate)) ? new ItemDelegate(this) : (ItemDelegate) n2;
    }

    public void f(@SuppressLint({"InvalidNullabilityOverride"}) @NonNull View view, @SuppressLint({"InvalidNullabilityOverride"}) @NonNull AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !o()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().f1(accessibilityEvent);
            }
        }
    }

    public void g(@SuppressLint({"InvalidNullabilityOverride"}) @NonNull View view, @SuppressLint({"InvalidNullabilityOverride"}) @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.g(view, accessibilityNodeInfoCompat);
        if (!o() && this.f15601d.getLayoutManager() != null) {
            this.f15601d.getLayoutManager().h1(accessibilityNodeInfoCompat);
        }
    }

    public boolean j(@SuppressLint({"InvalidNullabilityOverride"}) @NonNull View view, int i2, @SuppressLint({"InvalidNullabilityOverride"}) @Nullable Bundle bundle) {
        if (super.j(view, i2, bundle)) {
            return true;
        }
        if (o() || this.f15601d.getLayoutManager() == null) {
            return false;
        }
        return this.f15601d.getLayoutManager().B1(i2, bundle);
    }

    @NonNull
    public AccessibilityDelegateCompat n() {
        return this.f15602e;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f15601d.J0();
    }
}
