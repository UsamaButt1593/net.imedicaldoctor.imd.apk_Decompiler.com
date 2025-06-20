package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.common.util.k;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.httpclient.cookie.CookiePolicy;

public final class CommonNotificationBuilder {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24658a = "com.google.firebase.messaging.default_notification_color";

    /* renamed from: b  reason: collision with root package name */
    public static final String f24659b = "com.google.firebase.messaging.default_notification_icon";

    /* renamed from: c  reason: collision with root package name */
    public static final String f24660c = "com.google.firebase.messaging.default_notification_channel_id";

    /* renamed from: d  reason: collision with root package name */
    public static final String f24661d = "fcm_fallback_notification_channel";

    /* renamed from: e  reason: collision with root package name */
    public static final String f24662e = "fcm_fallback_notification_channel_label";

    /* renamed from: f  reason: collision with root package name */
    private static final String f24663f = "Misc";

    /* renamed from: g  reason: collision with root package name */
    private static final String f24664g = "com.google.android.c2dm.intent.RECEIVE";

    /* renamed from: h  reason: collision with root package name */
    private static final int f24665h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicInteger f24666i = new AtomicInteger((int) SystemClock.elapsedRealtime());

    public static class DisplayNotificationInfo {

        /* renamed from: a  reason: collision with root package name */
        public final NotificationCompat.Builder f24667a;

        /* renamed from: b  reason: collision with root package name */
        public final String f24668b;

        /* renamed from: c  reason: collision with root package name */
        public final int f24669c;

        DisplayNotificationInfo(NotificationCompat.Builder builder, String str, int i2) {
            this.f24667a = builder;
            this.f24668b = str;
            this.f24669c = i2;
        }
    }

    private CommonNotificationBuilder() {
    }

    @Nullable
    private static PendingIntent a(Context context, NotificationParams notificationParams, String str, PackageManager packageManager) {
        Intent f2 = f(str, notificationParams, packageManager);
        if (f2 == null) {
            return null;
        }
        f2.addFlags(67108864);
        f2.putExtras(notificationParams.A());
        if (q(notificationParams)) {
            f2.putExtra(Constants.MessageNotificationKeys.E, notificationParams.z());
        }
        return PendingIntent.getActivity(context, g(), f2, l(1073741824));
    }

    @Nullable
    private static PendingIntent b(Context context, Context context2, NotificationParams notificationParams) {
        if (!q(notificationParams)) {
            return null;
        }
        return c(context, context2, new Intent(CloudMessagingReceiver.IntentActionKeys.f19803b).putExtras(notificationParams.z()));
    }

    private static PendingIntent c(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent(f24664g).setPackage(context2.getPackageName()).putExtra(CloudMessagingReceiver.IntentKeys.f19805b, intent), l(1073741824));
    }

    public static DisplayNotificationInfo d(Context context, Context context2, NotificationParams notificationParams, String str, Bundle bundle) {
        String packageName = context2.getPackageName();
        Resources resources = context2.getResources();
        PackageManager packageManager = context2.getPackageManager();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, str);
        String n2 = notificationParams.n(resources, packageName, Constants.MessageNotificationKeys.f24691g);
        if (!TextUtils.isEmpty(n2)) {
            builder.O(n2);
        }
        String n3 = notificationParams.n(resources, packageName, Constants.MessageNotificationKeys.f24692h);
        if (!TextUtils.isEmpty(n3)) {
            builder.N(n3);
            builder.z0(new NotificationCompat.BigTextStyle().A(n3));
        }
        builder.t0(m(packageManager, resources, packageName, notificationParams.p(Constants.MessageNotificationKeys.f24693i), bundle));
        Uri n4 = n(packageName, notificationParams, resources);
        if (n4 != null) {
            builder.x0(n4);
        }
        builder.M(a(context, notificationParams, packageName, packageManager));
        PendingIntent b2 = b(context, context2, notificationParams);
        if (b2 != null) {
            builder.T(b2);
        }
        Integer h2 = h(context2, notificationParams.p(Constants.MessageNotificationKeys.f24696l), bundle);
        if (h2 != null) {
            builder.I(h2.intValue());
        }
        builder.C(!notificationParams.a(Constants.MessageNotificationKeys.o));
        builder.e0(notificationParams.a(Constants.MessageNotificationKeys.f24698n));
        String p = notificationParams.p(Constants.MessageNotificationKeys.f24697m);
        if (p != null) {
            builder.B0(p);
        }
        Integer m2 = notificationParams.m();
        if (m2 != null) {
            builder.k0(m2.intValue());
        }
        Integer r = notificationParams.r();
        if (r != null) {
            builder.G0(r.intValue());
        }
        Integer l2 = notificationParams.l();
        if (l2 != null) {
            builder.h0(l2.intValue());
        }
        Long j2 = notificationParams.j(Constants.MessageNotificationKeys.x);
        if (j2 != null) {
            builder.r0(true);
            builder.H0(j2.longValue());
        }
        long[] q = notificationParams.q();
        if (q != null) {
            builder.F0(q);
        }
        int[] e2 = notificationParams.e();
        if (e2 != null) {
            builder.d0(e2[0], e2[1], e2[2]);
        }
        builder.S(i(notificationParams));
        return new DisplayNotificationInfo(builder, o(notificationParams), 0);
    }

    static DisplayNotificationInfo e(Context context, NotificationParams notificationParams) {
        Bundle j2 = j(context.getPackageManager(), context.getPackageName());
        return d(context, context, notificationParams, k(context, notificationParams.k(), j2), j2);
    }

    private static Intent f(String str, NotificationParams notificationParams, PackageManager packageManager) {
        String p = notificationParams.p(Constants.MessageNotificationKeys.A);
        if (!TextUtils.isEmpty(p)) {
            Intent intent = new Intent(p);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri f2 = notificationParams.f();
        if (f2 != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(f2);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w(Constants.f24670a, "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return f24666i.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w(Constants.f24670a, "Color is invalid: " + str + ". Notification will use default color.");
            }
        }
        int i2 = bundle.getInt(f24658a, 0);
        if (i2 == 0) {
            return null;
        }
        try {
            return Integer.valueOf(ContextCompat.g(context, i2));
        } catch (Resources.NotFoundException unused2) {
            Log.w(Constants.f24670a, "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    private static int i(NotificationParams notificationParams) {
        boolean a2 = notificationParams.a(Constants.MessageNotificationKeys.q);
        if (notificationParams.a(Constants.MessageNotificationKeys.r)) {
            a2 |= true;
        }
        return notificationParams.a(Constants.MessageNotificationKeys.s) ? a2 | true ? 1 : 0 : a2 ? 1 : 0;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                return bundle;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w(Constants.f24670a, "Couldn't get own application info: " + e2);
        }
        return Bundle.EMPTY;
    }

    @VisibleForTesting
    @TargetApi(26)
    public static String k(Context context, String str, Bundle bundle) {
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                Log.w(Constants.f24670a, "Notification Channel requested (" + str + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string = bundle.getString(f24660c);
            if (TextUtils.isEmpty(string)) {
                str2 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
            } else if (notificationManager.getNotificationChannel(string) != null) {
                return string;
            } else {
                str2 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
            }
            Log.w(Constants.f24670a, str2);
            if (notificationManager.getNotificationChannel(f24661d) == null) {
                int identifier = context.getResources().getIdentifier(f24662e, TypedValues.Custom.f3952e, context.getPackageName());
                if (identifier == 0) {
                    Log.e(Constants.f24670a, "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    str3 = f24663f;
                } else {
                    str3 = context.getString(identifier);
                }
                notificationManager.createNotificationChannel(k.a(f24661d, str3, 3));
            }
            return f24661d;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static int l(int i2) {
        return Build.VERSION.SDK_INT >= 23 ? i2 | 67108864 : i2;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            Log.w(Constants.f24670a, "Icon resource " + str2 + " not found. Notification will use default icon.");
        }
        int i2 = bundle.getInt(f24659b, 0);
        if (i2 == 0 || !p(resources, i2)) {
            try {
                i2 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w(Constants.f24670a, "Couldn't get own application info: " + e2);
            }
        }
        if (i2 == 0 || !p(resources, i2)) {
            return 17301651;
        }
        return i2;
    }

    private static Uri n(String str, NotificationParams notificationParams, Resources resources) {
        String o = notificationParams.o();
        if (TextUtils.isEmpty(o)) {
            return null;
        }
        if (CookiePolicy.DEFAULT.equals(o) || resources.getIdentifier(o, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        return Uri.parse("android.resource://" + str + "/raw/" + o);
    }

    private static String o(NotificationParams notificationParams) {
        String p = notificationParams.p(Constants.MessageNotificationKeys.f24695k);
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        return "FCM-Notification:" + SystemClock.uptimeMillis();
    }

    @TargetApi(26)
    private static boolean p(Resources resources, int i2) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!C0485a.a(resources.getDrawable(i2, (Resources.Theme) null))) {
                return true;
            }
            Log.e(Constants.f24670a, "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i2);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e(Constants.f24670a, "Couldn't find resource " + i2 + ", treating it as an invalid icon");
            return false;
        }
    }

    static boolean q(@NonNull NotificationParams notificationParams) {
        return notificationParams.a(Constants.AnalyticsKeys.f24675b);
    }
}
