package androidx.core.content;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ContextCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5632a = "ContextCompat";

    /* renamed from: b  reason: collision with root package name */
    private static final Object f5633b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final String f5634c = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";

    /* renamed from: d  reason: collision with root package name */
    public static final int f5635d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5636e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5637f = 4;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        @DoNotInline
        static Drawable b(Context context, int i2) {
            return context.getDrawable(i2);
        }

        @DoNotInline
        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int a(Context context, int i2) {
            return context.getColor(i2);
        }

        @DoNotInline
        static <T> T b(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        @DoNotInline
        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        @DoNotInline
        static File b(Context context) {
            return context.getDataDir();
        }

        @DoNotInline
        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static Intent a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i2) {
            if ((i2 & 4) != 0 && str == null) {
                return context.registerReceiver(broadcastReceiver, intentFilter, ContextCompat.v(context), handler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i2 & 1);
        }

        @DoNotInline
        static ComponentName b(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        @NonNull
        static Context a(@NonNull Context context, @Nullable String str) {
            return context.createAttributionContext(str);
        }

        @DoNotInline
        static String b(Context context) {
            return context.getAttributionTag();
        }

        @DoNotInline
        static Display c(Context context) {
            try {
                return context.getDisplay();
            } catch (UnsupportedOperationException unused) {
                Log.w(ContextCompat.f5632a, "The context:" + context + " is not associated with any display. Return a fallback display instead.");
                return ((DisplayManager) context.getSystemService(DisplayManager.class)).getDisplay(0);
            }
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static Intent a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i2) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i2);
        }
    }

    private static final class LegacyServiceMapHolder {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<Class<?>, String> f5638a;

        static {
            HashMap<Class<?>, String> hashMap = new HashMap<>();
            f5638a = hashMap;
            if (Build.VERSION.SDK_INT >= 22) {
                hashMap.put(a.a(), "telephony_subscription_service");
                hashMap.put(UsageStatsManager.class, "usagestats");
            }
            hashMap.put(AppWidgetManager.class, "appwidget");
            hashMap.put(BatteryManager.class, "batterymanager");
            hashMap.put(CameraManager.class, "camera");
            hashMap.put(JobScheduler.class, "jobscheduler");
            hashMap.put(LauncherApps.class, "launcherapps");
            hashMap.put(MediaProjectionManager.class, "media_projection");
            hashMap.put(MediaSessionManager.class, "media_session");
            hashMap.put(RestrictionsManager.class, "restrictions");
            hashMap.put(TelecomManager.class, "telecom");
            hashMap.put(TvInputManager.class, "tv_input");
            hashMap.put(AppOpsManager.class, "appops");
            hashMap.put(CaptioningManager.class, "captioning");
            hashMap.put(ConsumerIrManager.class, "consumer_ir");
            hashMap.put(PrintManager.class, "print");
            hashMap.put(BluetoothManager.class, "bluetooth");
            hashMap.put(DisplayManager.class, "display");
            hashMap.put(UserManager.class, "user");
            hashMap.put(InputManager.class, HTML.Tag.q0);
            hashMap.put(MediaRouter.class, "media_router");
            hashMap.put(NsdManager.class, "servicediscovery");
            hashMap.put(AccessibilityManager.class, "accessibility");
            hashMap.put(AccountManager.class, "account");
            hashMap.put(ActivityManager.class, "activity");
            hashMap.put(AlarmManager.class, NotificationCompat.K0);
            hashMap.put(AudioManager.class, "audio");
            hashMap.put(ClipboardManager.class, "clipboard");
            hashMap.put(ConnectivityManager.class, "connectivity");
            hashMap.put(DevicePolicyManager.class, "device_policy");
            hashMap.put(DownloadManager.class, "download");
            hashMap.put(DropBoxManager.class, "dropbox");
            hashMap.put(InputMethodManager.class, "input_method");
            hashMap.put(KeyguardManager.class, "keyguard");
            hashMap.put(LayoutInflater.class, "layout_inflater");
            hashMap.put(LocationManager.class, "location");
            hashMap.put(NfcManager.class, "nfc");
            hashMap.put(NotificationManager.class, "notification");
            hashMap.put(PowerManager.class, "power");
            hashMap.put(SearchManager.class, "search");
            hashMap.put(SensorManager.class, "sensor");
            hashMap.put(StorageManager.class, "storage");
            hashMap.put(TelephonyManager.class, "phone");
            hashMap.put(TextServicesManager.class, "textservices");
            hashMap.put(UiModeManager.class, "uimode");
            hashMap.put(UsbManager.class, "usb");
            hashMap.put(Vibrator.class, "vibrator");
            hashMap.put(WallpaperManager.class, "wallpaper");
            hashMap.put(WifiP2pManager.class, "wifip2p");
            hashMap.put(WifiManager.class, "wifi");
            hashMap.put(WindowManager.class, "window");
        }

        private LegacyServiceMapHolder() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RegisterReceiverFlags {
    }

    protected ContextCompat() {
    }

    public static void A(@NonNull Context context, @NonNull Intent intent, @Nullable Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void B(@NonNull Context context, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.b(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        ObjectsCompat.e(str, "permission must be non-null");
        if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return NotificationManagerCompat.q(context).a() ? 0 : -1;
    }

    @NonNull
    public static Context b(@NonNull Context context, @Nullable String str) {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.a(context, str) : context;
    }

    @Nullable
    public static Context c(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.a(context);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File d(java.io.File r4) {
        /*
            java.lang.Object r0 = f5633b
            monitor-enter(r0)
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x002d
            boolean r1 = r4.mkdirs()     // Catch:{ all -> 0x0011 }
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r4
        L_0x0011:
            r4 = move-exception
            goto L_0x002f
        L_0x0013:
            java.lang.String r1 = "ContextCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0011 }
            r2.<init>()     // Catch:{ all -> 0x0011 }
            java.lang.String r3 = "Unable to create files subdir "
            r2.append(r3)     // Catch:{ all -> 0x0011 }
            java.lang.String r3 = r4.getPath()     // Catch:{ all -> 0x0011 }
            r2.append(r3)     // Catch:{ all -> 0x0011 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0011 }
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x0011 }
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r4
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.ContextCompat.d(java.io.File):java.io.File");
    }

    @Nullable
    public static String e(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.b(context);
        }
        return null;
    }

    @NonNull
    public static File f(@NonNull Context context) {
        return Api21Impl.a(context);
    }

    @ColorInt
    public static int g(@NonNull Context context, @ColorRes int i2) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.a(context, i2) : context.getResources().getColor(i2);
    }

    @Nullable
    public static ColorStateList h(@NonNull Context context, @ColorRes int i2) {
        return ResourcesCompat.f(context.getResources(), i2, context.getTheme());
    }

    @NonNull
    public static Context i(@NonNull Context context) {
        LocaleListCompat a2 = LocaleManagerCompat.a(context);
        if (Build.VERSION.SDK_INT > 32 || a2.j()) {
            return context;
        }
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        ConfigurationCompat.b(configuration, a2);
        return context.createConfigurationContext(configuration);
    }

    @Nullable
    public static File j(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.b(context);
        }
        String str = context.getApplicationInfo().dataDir;
        if (str != null) {
            return new File(str);
        }
        return null;
    }

    @NonNull
    public static Display k(@NonNull Context context) {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.c(context) : ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    @Nullable
    public static Drawable l(@NonNull Context context, @DrawableRes int i2) {
        return Api21Impl.b(context, i2);
    }

    @NonNull
    public static File[] m(@NonNull Context context) {
        return context.getExternalCacheDirs();
    }

    @NonNull
    public static File[] n(@NonNull Context context, @Nullable String str) {
        return context.getExternalFilesDirs(str);
    }

    @NonNull
    public static Executor o(@NonNull Context context) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.a(context) : ExecutorCompat.a(new Handler(context.getMainLooper()));
    }

    @Nullable
    public static File p(@NonNull Context context) {
        return Api21Impl.c(context);
    }

    @NonNull
    public static File[] q(@NonNull Context context) {
        return context.getObbDirs();
    }

    @NonNull
    public static String r(@NonNull Context context, int i2) {
        return i(context).getString(i2);
    }

    @Nullable
    public static <T> T s(@NonNull Context context, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(context, cls);
        }
        String t = t(context, cls);
        if (t != null) {
            return context.getSystemService(t);
        }
        return null;
    }

    @Nullable
    public static String t(@NonNull Context context, @NonNull Class<?> cls) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.c(context, cls) : LegacyServiceMapHolder.f5638a.get(cls);
    }

    public static boolean u(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.c(context);
        }
        return false;
    }

    static String v(Context context) {
        String str = context.getPackageName() + f5634c;
        if (PermissionChecker.d(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    @Nullable
    public static Intent w(@NonNull Context context, @Nullable BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter, int i2) {
        return x(context, broadcastReceiver, intentFilter, (String) null, (Handler) null, i2);
    }

    @Nullable
    public static Intent x(@NonNull Context context, @Nullable BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter, @Nullable String str, @Nullable Handler handler, int i2) {
        int i3 = i2 & 1;
        if (i3 == 0 || (i2 & 4) == 0) {
            if (i3 != 0) {
                i2 |= 2;
            }
            int i4 = i2;
            int i5 = i4 & 2;
            if (i5 == 0 && (i4 & 4) == 0) {
                throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
            } else if (i5 == 0 || (i4 & 4) == 0) {
                int i6 = Build.VERSION.SDK_INT;
                if (i6 >= 33) {
                    return Api33Impl.a(context, broadcastReceiver, intentFilter, str, handler, i4);
                }
                if (i6 >= 26) {
                    return Api26Impl.a(context, broadcastReceiver, intentFilter, str, handler, i4);
                }
                return ((i4 & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler) : context.registerReceiver(broadcastReceiver, intentFilter, v(context), handler);
            } else {
                throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
            }
        } else {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
    }

    public static boolean y(@NonNull Context context, @NonNull Intent[] intentArr) {
        return z(context, intentArr, (Bundle) null);
    }

    public static boolean z(@NonNull Context context, @NonNull Intent[] intentArr, @Nullable Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }
}
