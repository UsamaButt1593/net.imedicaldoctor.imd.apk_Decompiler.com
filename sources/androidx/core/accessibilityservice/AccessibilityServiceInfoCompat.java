package androidx.core.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class AccessibilityServiceInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5198a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5199b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5200c = 4;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5201d = 8;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5202e = 32;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5203f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5204g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5205h = 4;

    /* renamed from: i  reason: collision with root package name */
    public static final int f5206i = 8;

    /* renamed from: j  reason: collision with root package name */
    public static final int f5207j = 16;

    /* renamed from: k  reason: collision with root package name */
    public static final int f5208k = 32;

    private AccessibilityServiceInfoCompat() {
    }

    @NonNull
    public static String a(int i2) {
        if (i2 == 1) {
            return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
        }
        if (i2 == 2) {
            return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
        }
        if (i2 != 4) {
            return i2 != 8 ? "UNKNOWN" : "CAPABILITY_CAN_FILTER_KEY_EVENTS";
        }
        return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    }

    @NonNull
    public static String b(int i2) {
        StringBuilder sb = new StringBuilder();
        String str = "[";
        while (true) {
            sb.append(str);
            while (i2 > 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i2);
                i2 &= ~numberOfTrailingZeros;
                if (sb.length() > 1) {
                    sb.append(", ");
                }
                if (numberOfTrailingZeros == 1) {
                    str = "FEEDBACK_SPOKEN";
                } else if (numberOfTrailingZeros == 2) {
                    str = "FEEDBACK_HAPTIC";
                } else if (numberOfTrailingZeros == 4) {
                    str = "FEEDBACK_AUDIBLE";
                } else if (numberOfTrailingZeros == 8) {
                    str = "FEEDBACK_VISUAL";
                } else if (numberOfTrailingZeros == 16) {
                    str = "FEEDBACK_GENERIC";
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    @Nullable
    public static String c(int i2) {
        if (i2 == 1) {
            return "DEFAULT";
        }
        if (i2 == 2) {
            return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
        }
        if (i2 == 4) {
            return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
        }
        if (i2 == 8) {
            return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
        }
        if (i2 == 16) {
            return "FLAG_REPORT_VIEW_IDS";
        }
        if (i2 != 32) {
            return null;
        }
        return "FLAG_REQUEST_FILTER_KEY_EVENTS";
    }

    public static int d(@NonNull AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getCapabilities();
    }

    @Nullable
    public static String e(@NonNull AccessibilityServiceInfo accessibilityServiceInfo, @NonNull PackageManager packageManager) {
        return accessibilityServiceInfo.loadDescription(packageManager);
    }
}
