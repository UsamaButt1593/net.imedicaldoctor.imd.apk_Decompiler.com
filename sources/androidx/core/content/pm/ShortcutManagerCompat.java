package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ShortcutManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5721a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5722b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5723c = 4;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5724d = 8;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    static final String f5725e = "com.android.launcher.action.INSTALL_SHORTCUT";
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    static final String f5726f = "com.android.launcher.permission.INSTALL_SHORTCUT";

    /* renamed from: g  reason: collision with root package name */
    private static final int f5727g = 96;

    /* renamed from: h  reason: collision with root package name */
    private static final int f5728h = 48;

    /* renamed from: i  reason: collision with root package name */
    public static final String f5729i = "android.intent.extra.shortcut.ID";

    /* renamed from: j  reason: collision with root package name */
    private static volatile ShortcutInfoCompatSaver<?> f5730j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile List<ShortcutInfoChangeListener> f5731k = null;

    /* renamed from: l  reason: collision with root package name */
    private static final String f5732l = "androidx.core.content.pm.SHORTCUT_LISTENER";

    /* renamed from: m  reason: collision with root package name */
    private static final String f5733m = "androidx.core.content.pm.shortcut_listener_impl";

    @RequiresApi(25)
    private static class Api25Impl {
        private Api25Impl() {
        }

        static String a(@NonNull List<ShortcutInfo> list) {
            int i2 = -1;
            String str = null;
            for (ShortcutInfo next : list) {
                if (next.getRank() > i2) {
                    String id = next.getId();
                    str = id;
                    i2 = next.getRank();
                }
            }
            return str;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }

    private ShortcutManagerCompat() {
    }

    @VisibleForTesting
    static void A(List<ShortcutInfoChangeListener> list) {
        f5731k = list;
    }

    @VisibleForTesting
    static void B(ShortcutInfoCompatSaver<Void> shortcutInfoCompatSaver) {
        f5730j = shortcutInfoCompatSaver;
    }

    public static boolean C(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> w = w(list, 1);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 29) {
            c(context, w);
        }
        if (i2 >= 25) {
            ArrayList arrayList = new ArrayList();
            for (ShortcutInfoCompat H : w) {
                arrayList.add(H.H());
            }
            if (!f0.a(context.getSystemService(O.a())).updateShortcuts(arrayList)) {
                return false;
            }
        }
        o(context).a(w);
        for (ShortcutInfoChangeListener d2 : n(context)) {
            d2.d(list);
        }
        return true;
    }

    public static boolean a(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> w = w(list, 1);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 29) {
            c(context, w);
        }
        if (i2 >= 25) {
            ArrayList arrayList = new ArrayList();
            for (ShortcutInfoCompat H : w) {
                arrayList.add(H.H());
            }
            if (!f0.a(context.getSystemService(O.a())).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        o(context).a(w);
        for (ShortcutInfoChangeListener b2 : n(context)) {
            b2.b(list);
        }
        return true;
    }

    @VisibleForTesting
    static boolean b(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Bitmap decodeStream;
        IconCompat iconCompat = shortcutInfoCompat.f5710i;
        if (iconCompat == null) {
            return false;
        }
        int i2 = iconCompat.f5902a;
        if (i2 != 6 && i2 != 4) {
            return true;
        }
        InputStream E = iconCompat.E(context);
        if (E == null || (decodeStream = BitmapFactory.decodeStream(E)) == null) {
            return false;
        }
        shortcutInfoCompat.f5710i = i2 == 6 ? IconCompat.p(decodeStream) : IconCompat.s(decodeStream);
        return true;
    }

    @VisibleForTesting
    static void c(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        for (ShortcutInfoCompat shortcutInfoCompat : new ArrayList(list)) {
            if (!b(context, shortcutInfoCompat)) {
                list.remove(shortcutInfoCompat);
            }
        }
    }

    @NonNull
    public static Intent d(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Intent a2 = Build.VERSION.SDK_INT >= 26 ? f0.a(context.getSystemService(O.a())).createShortcutResultIntent(shortcutInfoCompat.H()) : null;
        if (a2 == null) {
            a2 = new Intent();
        }
        return shortcutInfoCompat.a(a2);
    }

    public static void e(@NonNull Context context, @NonNull List<String> list, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 25) {
            f0.a(context.getSystemService(O.a())).disableShortcuts(list, charSequence);
        }
        o(context).d(list);
        for (ShortcutInfoChangeListener c2 : n(context)) {
            c2.c(list);
        }
    }

    public static void f(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> w = w(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(list.size());
            for (ShortcutInfoCompat shortcutInfoCompat : w) {
                arrayList.add(shortcutInfoCompat.f5703b);
            }
            f0.a(context.getSystemService(O.a())).enableShortcuts(arrayList);
        }
        o(context).a(w);
        for (ShortcutInfoChangeListener b2 : n(context)) {
            b2.b(list);
        }
    }

    @NonNull
    public static List<ShortcutInfoCompat> g(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            List<Object> a2 = f0.a(context.getSystemService(O.a())).getDynamicShortcuts();
            ArrayList arrayList = new ArrayList(a2.size());
            for (Object a3 : a2) {
                arrayList.add(new ShortcutInfoCompat.Builder(context, C0028f.a(a3)).c());
            }
            return arrayList;
        }
        try {
            return o(context).b();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    private static int h(@NonNull Context context, boolean z) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int max = Math.max(1, activityManager == null || activityManager.isLowRamDevice() ? 48 : 96);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (((float) max) * ((z ? displayMetrics.xdpi : displayMetrics.ydpi) / 160.0f));
    }

    public static int i(@NonNull Context context) {
        Preconditions.l(context);
        return Build.VERSION.SDK_INT >= 25 ? f0.a(context.getSystemService(O.a())).getIconMaxHeight() : h(context, false);
    }

    public static int j(@NonNull Context context) {
        Preconditions.l(context);
        return Build.VERSION.SDK_INT >= 25 ? f0.a(context.getSystemService(O.a())).getIconMaxWidth() : h(context, true);
    }

    public static int k(@NonNull Context context) {
        Preconditions.l(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return f0.a(context.getSystemService(O.a())).getMaxShortcutCountPerActivity();
        }
        return 5;
    }

    @VisibleForTesting
    static List<ShortcutInfoChangeListener> l() {
        return f5731k;
    }

    private static String m(@NonNull List<ShortcutInfoCompat> list) {
        int i2 = -1;
        String str = null;
        for (ShortcutInfoCompat next : list) {
            if (next.v() > i2) {
                String k2 = next.k();
                str = k2;
                i2 = next.v();
            }
        }
        return str;
    }

    private static List<ShortcutInfoChangeListener> n(Context context) {
        Bundle bundle;
        String string;
        if (f5731k == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(f5732l);
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 128)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (!(activityInfo == null || (bundle = activityInfo.metaData) == null || (string = bundle.getString(f5733m)) == null)) {
                    try {
                        arrayList.add((ShortcutInfoChangeListener) Class.forName(string, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
                    } catch (Exception unused) {
                    }
                }
            }
            if (f5731k == null) {
                f5731k = arrayList;
            }
        }
        return f5731k;
    }

    private static ShortcutInfoCompatSaver<?> o(Context context) {
        if (f5730j == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    f5730j = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
                } catch (Exception unused) {
                }
            }
            if (f5730j == null) {
                f5730j = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return f5730j;
    }

    @NonNull
    public static List<ShortcutInfoCompat> p(@NonNull Context context, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            return ShortcutInfoCompat.c(context, f0.a(context.getSystemService(O.a())).getShortcuts(i2));
        }
        if (i3 >= 25) {
            ShortcutManager a2 = f0.a(context.getSystemService(O.a()));
            ArrayList arrayList = new ArrayList();
            if ((i2 & 1) != 0) {
                arrayList.addAll(a2.getManifestShortcuts());
            }
            if ((i2 & 2) != 0) {
                arrayList.addAll(a2.getDynamicShortcuts());
            }
            if ((i2 & 4) != 0) {
                arrayList.addAll(a2.getPinnedShortcuts());
            }
            return ShortcutInfoCompat.c(context, arrayList);
        }
        if ((i2 & 2) != 0) {
            try {
                return o(context).b();
            } catch (Exception unused) {
            }
        }
        return Collections.emptyList();
    }

    public static boolean q(@NonNull Context context) {
        Preconditions.l(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return f0.a(context.getSystemService(O.a())).isRateLimitingActive();
        }
        return p(context, 3).size() == k(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean r(@androidx.annotation.NonNull android.content.Context r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x0017
            java.lang.Class r0 = androidx.core.content.pm.O.a()
            java.lang.Object r4 = r4.getSystemService(r0)
            android.content.pm.ShortcutManager r4 = androidx.core.content.pm.f0.a(r4)
            boolean r4 = r4.isRequestPinShortcutSupported()
            return r4
        L_0x0017:
            java.lang.String r0 = "com.android.launcher.permission.INSTALL_SHORTCUT"
            int r1 = androidx.core.content.ContextCompat.a(r4, r0)
            r2 = 0
            if (r1 == 0) goto L_0x0021
            return r2
        L_0x0021:
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r3 = "com.android.launcher.action.INSTALL_SHORTCUT"
            r1.<init>(r3)
            java.util.List r4 = r4.queryBroadcastReceivers(r1, r2)
            java.util.Iterator r4 = r4.iterator()
        L_0x0034:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r4.next()
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1
            android.content.pm.ActivityInfo r1 = r1.activityInfo
            java.lang.String r1 = r1.permission
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0050
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0034
        L_0x0050:
            r4 = 1
            return r4
        L_0x0052:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.pm.ShortcutManagerCompat.r(android.content.Context):boolean");
    }

    public static boolean s(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Preconditions.l(context);
        Preconditions.l(shortcutInfoCompat);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 32 || !shortcutInfoCompat.E(1)) {
            int k2 = k(context);
            if (k2 == 0) {
                return false;
            }
            if (i2 <= 29) {
                b(context, shortcutInfoCompat);
            }
            if (i2 >= 30) {
                f0.a(context.getSystemService(O.a())).pushDynamicShortcut(shortcutInfoCompat.H());
            } else if (i2 >= 25) {
                ShortcutManager a2 = f0.a(context.getSystemService(O.a()));
                if (a2.isRateLimitingActive()) {
                    return false;
                }
                List a3 = a2.getDynamicShortcuts();
                if (a3.size() >= k2) {
                    a2.removeDynamicShortcuts(Arrays.asList(new String[]{Api25Impl.a(a3)}));
                }
                boolean unused = a2.addDynamicShortcuts(Arrays.asList(new ShortcutInfo[]{shortcutInfoCompat.H()}));
            }
            ShortcutInfoCompatSaver<?> o = o(context);
            try {
                List<ShortcutInfoCompat> b2 = o.b();
                if (b2.size() >= k2) {
                    o.d(Arrays.asList(new String[]{m(b2)}));
                }
                o.a(Arrays.asList(new ShortcutInfoCompat[]{shortcutInfoCompat}));
                for (ShortcutInfoChangeListener b3 : n(context)) {
                    b3.b(Collections.singletonList(shortcutInfoCompat));
                }
                x(context, shortcutInfoCompat.k());
                return true;
            } catch (Exception unused2) {
                for (ShortcutInfoChangeListener b4 : n(context)) {
                    b4.b(Collections.singletonList(shortcutInfoCompat));
                }
                x(context, shortcutInfoCompat.k());
                return false;
            } catch (Throwable th) {
                for (ShortcutInfoChangeListener b5 : n(context)) {
                    b5.b(Collections.singletonList(shortcutInfoCompat));
                }
                x(context, shortcutInfoCompat.k());
                throw th;
            }
        } else {
            for (ShortcutInfoChangeListener b6 : n(context)) {
                b6.b(Collections.singletonList(shortcutInfoCompat));
            }
            return true;
        }
    }

    public static void t(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            f0.a(context.getSystemService(O.a())).removeAllDynamicShortcuts();
        }
        o(context).c();
        for (ShortcutInfoChangeListener a2 : n(context)) {
            a2.a();
        }
    }

    public static void u(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            f0.a(context.getSystemService(O.a())).removeDynamicShortcuts(list);
        }
        o(context).d(list);
        for (ShortcutInfoChangeListener c2 : n(context)) {
            c2.c(list);
        }
    }

    public static void v(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT < 30) {
            u(context, list);
            return;
        }
        f0.a(context.getSystemService(O.a())).removeLongLivedShortcuts(list);
        o(context).d(list);
        for (ShortcutInfoChangeListener c2 : n(context)) {
            c2.c(list);
        }
    }

    @NonNull
    private static List<ShortcutInfoCompat> w(@NonNull List<ShortcutInfoCompat> list, int i2) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 32) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        for (ShortcutInfoCompat next : list) {
            if (next.E(i2)) {
                arrayList.remove(next);
            }
        }
        return arrayList;
    }

    public static void x(@NonNull Context context, @NonNull String str) {
        Preconditions.l(context);
        Preconditions.l(str);
        if (Build.VERSION.SDK_INT >= 25) {
            f0.a(context.getSystemService(O.a())).reportShortcutUsed(str);
        }
        for (ShortcutInfoChangeListener e2 : n(context)) {
            e2.e(Collections.singletonList(str));
        }
    }

    public static boolean y(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat, @Nullable final IntentSender intentSender) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 32 && shortcutInfoCompat.E(1)) {
            return false;
        }
        if (i2 >= 26) {
            return f0.a(context.getSystemService(O.a())).requestPinShortcut(shortcutInfoCompat.H(), intentSender);
        }
        if (!r(context)) {
            return false;
        }
        Intent a2 = shortcutInfoCompat.a(new Intent(f5725e));
        if (intentSender == null) {
            context.sendBroadcast(a2);
            return true;
        }
        context.sendOrderedBroadcast(a2, (String) null, new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                try {
                    intentSender.sendIntent(context, 0, (Intent) null, (IntentSender.OnFinished) null, (Handler) null);
                } catch (IntentSender.SendIntentException unused) {
                }
            }
        }, (Handler) null, -1, (String) null, (Bundle) null);
        return true;
    }

    public static boolean z(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        Preconditions.l(context);
        Preconditions.l(list);
        List<ShortcutInfoCompat> w = w(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(w.size());
            for (ShortcutInfoCompat H : w) {
                arrayList.add(H.H());
            }
            if (!f0.a(context.getSystemService(O.a())).setDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        o(context).c();
        o(context).a(w);
        for (ShortcutInfoChangeListener next : n(context)) {
            next.a();
            next.b(list);
        }
        return true;
    }
}
