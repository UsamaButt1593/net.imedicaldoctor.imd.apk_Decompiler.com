package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {

    /* renamed from: b  reason: collision with root package name */
    public static final int f6684b = -1;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Object f6685a;

    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final AccessibilityNodeProviderCompat f6686a;

        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f6686a = accessibilityNodeProviderCompat;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            AccessibilityNodeInfoCompat b2 = this.f6686a.b(i2);
            if (b2 == null) {
                return null;
            }
            return b2.q2();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            List<AccessibilityNodeInfoCompat> c2 = this.f6686a.c(str, i2);
            if (c2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c2.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(c2.get(i3).q2());
            }
            return arrayList;
        }

        public AccessibilityNodeInfo findFocus(int i2) {
            AccessibilityNodeInfoCompat d2 = this.f6686a.d(i2);
            if (d2 == null) {
                return null;
            }
            return d2.q2();
        }

        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.f6686a.f(i2, i3, bundle);
        }
    }

    @RequiresApi(26)
    static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i2, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f6686a.a(i2, AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.f6685a = Build.VERSION.SDK_INT >= 26 ? new AccessibilityNodeProviderApi26(this) : new AccessibilityNodeProviderApi19(this);
    }

    public void a(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @NonNull String str, @Nullable Bundle bundle) {
    }

    @Nullable
    public AccessibilityNodeInfoCompat b(int i2) {
        return null;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> c(@NonNull String str, int i2) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat d(int i2) {
        return null;
    }

    @Nullable
    public Object e() {
        return this.f6685a;
    }

    public boolean f(int i2, int i3, @Nullable Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(@Nullable Object obj) {
        this.f6685a = obj;
    }
}
