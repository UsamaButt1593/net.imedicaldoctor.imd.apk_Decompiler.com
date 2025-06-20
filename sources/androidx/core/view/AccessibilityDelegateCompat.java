package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    private static final View.AccessibilityDelegate f6331c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    private final View.AccessibilityDelegate f6332a;

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f6333b;

    static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final AccessibilityDelegateCompat f6334a;

        AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.f6334a = accessibilityDelegateCompat;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f6334a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProviderCompat b2 = this.f6334a.b(view);
            if (b2 != null) {
                return (AccessibilityNodeProvider) b2.e();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f6334a.f(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat r2 = AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo);
            r2.W1(ViewCompat.d1(view));
            r2.z1(ViewCompat.Q0(view));
            r2.O1(ViewCompat.J(view));
            r2.c2(ViewCompat.y0(view));
            this.f6334a.g(view, r2);
            r2.f(accessibilityNodeInfo.getText(), view);
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> c2 = AccessibilityDelegateCompat.c(view);
            for (int i2 = 0; i2 < c2.size(); i2++) {
                r2.b(c2.get(i2));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f6334a.h(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f6334a.i(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f6334a.j(view, i2, bundle);
        }

        public void sendAccessibilityEvent(View view, int i2) {
            this.f6334a.l(view, i2);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f6334a.m(view, accessibilityEvent);
        }
    }

    public AccessibilityDelegateCompat() {
        this(f6331c);
    }

    static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> c(View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = (List) view.getTag(R.id.f0);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] z = AccessibilityNodeInfoCompat.z(view.createAccessibilityNodeInfo().getText());
            int i2 = 0;
            while (z != null && i2 < z.length) {
                if (clickableSpan.equals(z[i2])) {
                    return true;
                }
                i2++;
            }
        }
        return false;
    }

    private boolean k(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.g0);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.f6332a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Nullable
    public AccessibilityNodeProviderCompat b(@NonNull View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f6332a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.f6333b;
    }

    public void f(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f6332a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.f6332a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.q2());
    }

    public void h(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f6332a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.f6332a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(@NonNull View view, int i2, @Nullable Bundle bundle) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> c2 = c(view);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= c2.size()) {
                break;
            }
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = c2.get(i3);
            if (accessibilityActionCompat.b() == i2) {
                z = accessibilityActionCompat.d(view, bundle);
                break;
            }
            i3++;
        }
        if (!z) {
            z = this.f6332a.performAccessibilityAction(view, i2, bundle);
        }
        return (z || i2 != R.id.f5145a || bundle == null) ? z : k(bundle.getInt(AccessibilityClickableSpanCompat.f6619d, -1), view);
    }

    public void l(@NonNull View view, int i2) {
        this.f6332a.sendAccessibilityEvent(view, i2);
    }

    public void m(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f6332a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityDelegateCompat(@NonNull View.AccessibilityDelegate accessibilityDelegate) {
        this.f6332a = accessibilityDelegate;
        this.f6333b = new AccessibilityDelegateAdapter(this);
    }
}
