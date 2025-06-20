package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.ProductData;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.itextpdf.text.html.HtmlTags;
import java.util.concurrent.ExecutionException;

public class MessagingAnalytics {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24793a = "Firebase";

    /* renamed from: b  reason: collision with root package name */
    private static final String f24794b = "notification";

    /* renamed from: c  reason: collision with root package name */
    private static final String f24795c = "com.google.firebase.messaging";

    /* renamed from: d  reason: collision with root package name */
    private static final String f24796d = "export_to_big_query";

    /* renamed from: e  reason: collision with root package name */
    private static final String f24797e = "delivery_metrics_exported_to_big_query_enabled";

    /* renamed from: f  reason: collision with root package name */
    private static final int f24798f = 111881503;

    @VisibleForTesting
    static void A(String str, Bundle bundle) {
        try {
            FirebaseApp.p();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String d2 = d(bundle);
            if (d2 != null) {
                bundle2.putString("_nmid", d2);
            }
            String e2 = e(bundle);
            if (e2 != null) {
                bundle2.putString(Constants.ScionAnalytics.f24723g, e2);
            }
            String i2 = i(bundle);
            if (!TextUtils.isEmpty(i2)) {
                bundle2.putString("label", i2);
            }
            String g2 = g(bundle);
            if (!TextUtils.isEmpty(g2)) {
                bundle2.putString(Constants.ScionAnalytics.f24726j, g2);
            }
            String r = r(bundle);
            if (r != null) {
                bundle2.putString(Constants.ScionAnalytics.f24721e, r);
            }
            String l2 = l(bundle);
            if (l2 != null) {
                try {
                    bundle2.putInt(Constants.ScionAnalytics.f24724h, Integer.parseInt(l2));
                } catch (NumberFormatException e3) {
                    Log.w(Constants.f24670a, "Error while parsing timestamp in GCM event", e3);
                }
            }
            String t = t(bundle);
            if (t != null) {
                try {
                    bundle2.putInt(Constants.ScionAnalytics.f24725i, Integer.parseInt(t));
                } catch (NumberFormatException e4) {
                    Log.w(Constants.f24670a, "Error while parsing use_device_time in GCM event", e4);
                }
            }
            String n2 = n(bundle);
            if (Constants.ScionAnalytics.f24729m.equals(str) || Constants.ScionAnalytics.p.equals(str)) {
                bundle2.putString(Constants.ScionAnalytics.f24727k, n2);
            }
            if (Log.isLoggable(Constants.f24670a, 3)) {
                Log.d(Constants.f24670a, "Logging to scion event=" + str + " scionPayload=" + bundle2);
            }
            AnalyticsConnector analyticsConnector = (AnalyticsConnector) FirebaseApp.p().l(AnalyticsConnector.class);
            if (analyticsConnector != null) {
                analyticsConnector.c(Constants.ScionAnalytics.f24717a, str, bundle2);
            } else {
                Log.w(Constants.f24670a, "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e(Constants.f24670a, "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    static void B(boolean z) {
        FirebaseApp.p().n().getSharedPreferences("com.google.firebase.messaging", 0).edit().putBoolean(f24796d, z).apply();
    }

    private static void C(Bundle bundle) {
        if (bundle != null) {
            if (IcyHeaders.a3.equals(bundle.getString(Constants.AnalyticsKeys.f24680g))) {
                AnalyticsConnector analyticsConnector = (AnalyticsConnector) FirebaseApp.p().l(AnalyticsConnector.class);
                if (Log.isLoggable(Constants.f24670a, 3)) {
                    Log.d(Constants.f24670a, "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (analyticsConnector != null) {
                    String string = bundle.getString(Constants.AnalyticsKeys.f24676c);
                    analyticsConnector.g(Constants.ScionAnalytics.f24717a, Constants.ScionAnalytics.q, string);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("source", f24793a);
                    bundle2.putString("medium", f24794b);
                    bundle2.putString(Constants.ScionAnalytics.f24722f, string);
                    analyticsConnector.c(Constants.ScionAnalytics.f24717a, Constants.ScionAnalytics.f24728l, bundle2);
                    return;
                }
                Log.w(Constants.f24670a, "Unable to set user property for conversion tracking:  analytics library is missing");
            } else if (Log.isLoggable(Constants.f24670a, 3)) {
                Log.d(Constants.f24670a, "Received event with track-conversion=false. Do not set user property");
            }
        }
    }

    public static boolean D(Intent intent) {
        if (intent == null || u(intent)) {
            return false;
        }
        return a();
    }

    public static boolean E(Intent intent) {
        if (intent == null || u(intent)) {
            return false;
        }
        return F(intent.getExtras());
    }

    public static boolean F(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return IcyHeaders.a3.equals(bundle.getString(Constants.AnalyticsKeys.f24675b));
    }

    static boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            FirebaseApp.p();
            Context n2 = FirebaseApp.p().n();
            SharedPreferences sharedPreferences = n2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains(f24796d)) {
                return sharedPreferences.getBoolean(f24796d, false);
            }
            try {
                PackageManager packageManager = n2.getPackageManager();
                if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(n2.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(f24797e))) {
                    return applicationInfo.metaData.getBoolean(f24797e, false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i(Constants.f24670a, "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    static MessagingClientEvent b(MessagingClientEvent.Event event, Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        MessagingClientEvent.Builder j2 = MessagingClientEvent.q().p(s(extras)).g(event).h(f(extras)).k(o()).n(MessagingClientEvent.SDKPlatform.ANDROID).j(m(extras));
        String h2 = h(extras);
        if (h2 != null) {
            j2.i(h2);
        }
        String r = r(extras);
        if (r != null) {
            j2.o(r);
        }
        String c2 = c(extras);
        if (c2 != null) {
            j2.e(c2);
        }
        String i2 = i(extras);
        if (i2 != null) {
            j2.b(i2);
        }
        String e2 = e(extras);
        if (e2 != null) {
            j2.f(e2);
        }
        long q = q(extras);
        if (q > 0) {
            j2.m(q);
        }
        return j2.a();
    }

    @Nullable
    static String c(Bundle bundle) {
        return bundle.getString(Constants.MessagePayloadKeys.f24703e);
    }

    @Nullable
    static String d(Bundle bundle) {
        return bundle.getString(Constants.AnalyticsKeys.f24676c);
    }

    @Nullable
    static String e(Bundle bundle) {
        return bundle.getString(Constants.AnalyticsKeys.f24677d);
    }

    @NonNull
    static String f(Bundle bundle) {
        String string = bundle.getString(Constants.MessagePayloadKeys.f24705g);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return (String) Tasks.a(FirebaseInstallations.v(FirebaseApp.p()).getId());
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Nullable
    static String g(Bundle bundle) {
        return bundle.getString(Constants.AnalyticsKeys.f24683j);
    }

    @Nullable
    static String h(Bundle bundle) {
        String string = bundle.getString(Constants.MessagePayloadKeys.f24706h);
        return string == null ? bundle.getString(Constants.MessagePayloadKeys.f24704f) : string;
    }

    @Nullable
    static String i(Bundle bundle) {
        return bundle.getString(Constants.AnalyticsKeys.f24682i);
    }

    @NonNull
    private static int j(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return HtmlTags.y0.equals(str) ? 2 : 0;
    }

    static int k(Bundle bundle) {
        int p = p(bundle);
        if (p == 2) {
            return 5;
        }
        return p == 1 ? 10 : 0;
    }

    @Nullable
    static String l(Bundle bundle) {
        return bundle.getString(Constants.AnalyticsKeys.f24678e);
    }

    @NonNull
    static MessagingClientEvent.MessageType m(Bundle bundle) {
        return (bundle == null || !NotificationParams.v(bundle)) ? MessagingClientEvent.MessageType.DATA_MESSAGE : MessagingClientEvent.MessageType.DISPLAY_NOTIFICATION;
    }

    @NonNull
    static String n(Bundle bundle) {
        return (bundle == null || !NotificationParams.v(bundle)) ? "data" : "display";
    }

    @NonNull
    static String o() {
        return FirebaseApp.p().n().getPackageName();
    }

    @NonNull
    static int p(Bundle bundle) {
        String string = bundle.getString(Constants.MessagePayloadKeys.f24710l);
        if (string == null) {
            if (IcyHeaders.a3.equals(bundle.getString(Constants.MessagePayloadKeys.f24712n))) {
                return 2;
            }
            string = bundle.getString(Constants.MessagePayloadKeys.f24711m);
        }
        return j(string);
    }

    @Nullable
    static long q(Bundle bundle) {
        if (bundle.containsKey(Constants.MessagePayloadKeys.q)) {
            try {
                return Long.parseLong(bundle.getString(Constants.MessagePayloadKeys.q));
            } catch (NumberFormatException e2) {
                Log.w(Constants.f24670a, "error parsing project number", e2);
            }
        }
        FirebaseApp p = FirebaseApp.p();
        String m2 = p.s().m();
        if (m2 != null) {
            try {
                return Long.parseLong(m2);
            } catch (NumberFormatException e3) {
                Log.w(Constants.f24670a, "error parsing sender ID", e3);
            }
        }
        String j2 = p.s().j();
        if (!j2.startsWith("1:")) {
            try {
                return Long.parseLong(j2);
            } catch (NumberFormatException e4) {
                Log.w(Constants.f24670a, "error parsing app ID", e4);
                return 0;
            }
        } else {
            String[] split = j2.split(":");
            if (split.length < 2) {
                return 0;
            }
            String str = split[1];
            if (str.isEmpty()) {
                return 0;
            }
            return Long.parseLong(str);
        }
    }

    @Nullable
    static String r(Bundle bundle) {
        String string = bundle.getString("from");
        if (string == null || !string.startsWith("/topics/")) {
            return null;
        }
        return string;
    }

    @NonNull
    static int s(Bundle bundle) {
        Object obj = bundle.get(Constants.MessagePayloadKeys.f24707i);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w(Constants.f24670a, "Invalid TTL: " + obj);
            return 0;
        }
    }

    @Nullable
    static String t(Bundle bundle) {
        if (bundle.containsKey(Constants.AnalyticsKeys.f24679f)) {
            return bundle.getString(Constants.AnalyticsKeys.f24679f);
        }
        return null;
    }

    private static boolean u(Intent intent) {
        return FirebaseMessagingService.c3.equals(intent.getAction());
    }

    public static void v(Intent intent) {
        A(Constants.ScionAnalytics.o, intent.getExtras());
    }

    public static void w(Intent intent) {
        A(Constants.ScionAnalytics.p, intent.getExtras());
    }

    public static void x(Bundle bundle) {
        C(bundle);
        A(Constants.ScionAnalytics.f24730n, bundle);
    }

    public static void y(Intent intent) {
        if (E(intent)) {
            A(Constants.ScionAnalytics.f24729m, intent.getExtras());
        }
        if (D(intent)) {
            z(MessagingClientEvent.Event.MESSAGE_DELIVERED, intent, FirebaseMessaging.E());
        }
    }

    private static void z(MessagingClientEvent.Event event, Intent intent, @Nullable TransportFactory transportFactory) {
        if (transportFactory == null) {
            Log.e(Constants.f24670a, "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
            return;
        }
        MessagingClientEvent b2 = b(event, intent);
        if (b2 != null) {
            try {
                transportFactory.b(Constants.FirelogAnalytics.f24684a, MessagingClientEventExtension.class, Encoding.b("proto"), new B()).a(Event.l(MessagingClientEventExtension.d().b(b2).a(), ProductData.b(Integer.valueOf(intent.getIntExtra(Constants.MessagePayloadKeys.o, f24798f)))));
            } catch (RuntimeException e2) {
                Log.w(Constants.f24670a, "Failed to send big query analytics payload.", e2);
            }
        }
    }
}
