package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

public class NotificationParams {

    /* renamed from: b  reason: collision with root package name */
    private static final int f24811b = -16777216;

    /* renamed from: c  reason: collision with root package name */
    private static final int f24812c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f24813d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static final int f24814e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final String f24815f = "NotificationParams";
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f24816a;

    public NotificationParams(@NonNull Bundle bundle) {
        if (bundle != null) {
            this.f24816a = new Bundle(bundle);
            return;
        }
        throw new NullPointerException("data");
    }

    private static String B(String str) {
        return str.startsWith(Constants.MessageNotificationKeys.f24686b) ? str.substring(6) : str;
    }

    private static int d(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != -16777216) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean t(String str) {
        return str.startsWith(Constants.AnalyticsKeys.f24674a) || str.equals("from");
    }

    public static boolean v(Bundle bundle) {
        return IcyHeaders.a3.equals(bundle.getString(Constants.MessageNotificationKeys.f24688d)) || IcyHeaders.a3.equals(bundle.getString(x(Constants.MessageNotificationKeys.f24688d)));
    }

    private static boolean w(String str) {
        return str.startsWith(Constants.MessagePayloadKeys.p) || str.startsWith(Constants.MessageNotificationKeys.f24686b) || str.startsWith(Constants.MessageNotificationKeys.f24687c);
    }

    private static String x(String str) {
        return !str.startsWith(Constants.MessageNotificationKeys.f24686b) ? str : str.replace(Constants.MessageNotificationKeys.f24686b, Constants.MessageNotificationKeys.f24687c);
    }

    private String y(String str) {
        if (!this.f24816a.containsKey(str) && str.startsWith(Constants.MessageNotificationKeys.f24686b)) {
            String x = x(str);
            if (this.f24816a.containsKey(x)) {
                return x;
            }
        }
        return str;
    }

    public Bundle A() {
        Bundle bundle = new Bundle(this.f24816a);
        for (String next : this.f24816a.keySet()) {
            if (w(next)) {
                bundle.remove(next);
            }
        }
        return bundle;
    }

    public boolean a(String str) {
        String p = p(str);
        return IcyHeaders.a3.equals(p) || Boolean.parseBoolean(p);
    }

    public Integer b(String str) {
        String p = p(str);
        if (TextUtils.isEmpty(p)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(p));
        } catch (NumberFormatException unused) {
            Log.w(f24815f, "Couldn't parse value of " + B(str) + "(" + p + ") into an int");
            return null;
        }
    }

    @Nullable
    public JSONArray c(String str) {
        String p = p(str);
        if (TextUtils.isEmpty(p)) {
            return null;
        }
        try {
            return new JSONArray(p);
        } catch (JSONException unused) {
            Log.w(f24815f, "Malformed JSON for key " + B(str) + ": " + p + ", falling back to default");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public int[] e() {
        String str;
        JSONArray c2 = c(Constants.MessageNotificationKeys.w);
        if (c2 == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (c2.length() == 3) {
                iArr[0] = d(c2.optString(0));
                iArr[1] = c2.optInt(1);
                iArr[2] = c2.optInt(2);
                return iArr;
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (JSONException unused) {
            str = "LightSettings is invalid: " + c2 + ". Skipping setting LightSettings";
            Log.w(f24815f, str);
            return null;
        } catch (IllegalArgumentException e2) {
            str = "LightSettings is invalid: " + c2 + ". " + e2.getMessage() + ". Skipping setting LightSettings";
            Log.w(f24815f, str);
            return null;
        }
    }

    @Nullable
    public Uri f() {
        String p = p(Constants.MessageNotificationKeys.C);
        if (TextUtils.isEmpty(p)) {
            p = p(Constants.MessageNotificationKeys.B);
        }
        if (!TextUtils.isEmpty(p)) {
            return Uri.parse(p);
        }
        return null;
    }

    @Nullable
    public Object[] g(String str) {
        JSONArray c2 = c(str + Constants.MessageNotificationKeys.G);
        if (c2 == null) {
            return null;
        }
        int length = c2.length();
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = c2.optString(i2);
        }
        return strArr;
    }

    @Nullable
    public String h(String str) {
        return p(str + Constants.MessageNotificationKeys.F);
    }

    @Nullable
    public String i(Resources resources, String str, String str2) {
        String h2 = h(str2);
        if (TextUtils.isEmpty(h2)) {
            return null;
        }
        int identifier = resources.getIdentifier(h2, TypedValues.Custom.f3952e, str);
        if (identifier == 0) {
            Log.w(f24815f, B(str2 + Constants.MessageNotificationKeys.F) + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] g2 = g(str2);
        if (g2 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, g2);
        } catch (MissingFormatArgumentException e2) {
            Log.w(f24815f, "Missing format argument for " + B(str2) + ": " + Arrays.toString(g2) + " Default value will be used.", e2);
            return null;
        }
    }

    public Long j(String str) {
        String p = p(str);
        if (TextUtils.isEmpty(p)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(p));
        } catch (NumberFormatException unused) {
            Log.w(f24815f, "Couldn't parse value of " + B(str) + "(" + p + ") into a long");
            return null;
        }
    }

    public String k() {
        return p(Constants.MessageNotificationKeys.D);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Integer l() {
        Integer b2 = b(Constants.MessageNotificationKeys.t);
        if (b2 == null) {
            return null;
        }
        if (b2.intValue() >= 0) {
            return b2;
        }
        Log.w(Constants.f24670a, "notificationCount is invalid: " + b2 + ". Skipping setting notificationCount.");
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Integer m() {
        Integer b2 = b(Constants.MessageNotificationKeys.p);
        if (b2 == null) {
            return null;
        }
        if (b2.intValue() >= -2 && b2.intValue() <= 2) {
            return b2;
        }
        Log.w(Constants.f24670a, "notificationPriority is invalid " + b2 + ". Skipping setting notificationPriority.");
        return null;
    }

    public String n(Resources resources, String str, String str2) {
        String p = p(str2);
        return !TextUtils.isEmpty(p) ? p : i(resources, str, str2);
    }

    @Nullable
    public String o() {
        String p = p(Constants.MessageNotificationKeys.y);
        return TextUtils.isEmpty(p) ? p(Constants.MessageNotificationKeys.z) : p;
    }

    public String p(String str) {
        return this.f24816a.getString(y(str));
    }

    @Nullable
    public long[] q() {
        JSONArray c2 = c(Constants.MessageNotificationKeys.v);
        if (c2 == null) {
            return null;
        }
        try {
            if (c2.length() > 1) {
                int length = c2.length();
                long[] jArr = new long[length];
                for (int i2 = 0; i2 < length; i2++) {
                    jArr[i2] = c2.optLong(i2);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            Log.w(f24815f, "User defined vibrateTimings is invalid: " + c2 + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Integer r() {
        Integer b2 = b(Constants.MessageNotificationKeys.u);
        if (b2 == null) {
            return null;
        }
        if (b2.intValue() >= -1 && b2.intValue() <= 1) {
            return b2;
        }
        Log.w(f24815f, "visibility is invalid: " + b2 + ". Skipping setting visibility.");
        return null;
    }

    public boolean s() {
        return !TextUtils.isEmpty(p(Constants.MessageNotificationKeys.f24694j));
    }

    public boolean u() {
        return a(Constants.MessageNotificationKeys.f24688d);
    }

    public Bundle z() {
        Bundle bundle = new Bundle(this.f24816a);
        for (String next : this.f24816a.keySet()) {
            if (!t(next)) {
                bundle.remove(next);
            }
        }
        return bundle;
    }
}
