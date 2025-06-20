package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class NotificationCompatJellybean {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5503a = "NotificationCompat";

    /* renamed from: b  reason: collision with root package name */
    static final String f5504b = "android.support.dataRemoteInputs";

    /* renamed from: c  reason: collision with root package name */
    static final String f5505c = "android.support.allowGeneratedReplies";

    /* renamed from: d  reason: collision with root package name */
    private static final String f5506d = "icon";

    /* renamed from: e  reason: collision with root package name */
    private static final String f5507e = "title";

    /* renamed from: f  reason: collision with root package name */
    private static final String f5508f = "actionIntent";

    /* renamed from: g  reason: collision with root package name */
    private static final String f5509g = "extras";

    /* renamed from: h  reason: collision with root package name */
    private static final String f5510h = "remoteInputs";

    /* renamed from: i  reason: collision with root package name */
    private static final String f5511i = "dataOnlyRemoteInputs";

    /* renamed from: j  reason: collision with root package name */
    private static final String f5512j = "resultKey";

    /* renamed from: k  reason: collision with root package name */
    private static final String f5513k = "label";

    /* renamed from: l  reason: collision with root package name */
    private static final String f5514l = "choices";

    /* renamed from: m  reason: collision with root package name */
    private static final String f5515m = "allowFreeFormInput";

    /* renamed from: n  reason: collision with root package name */
    private static final String f5516n = "allowedDataTypes";
    private static final String o = "semanticAction";
    private static final String p = "showsUserInterface";
    private static final Object q = new Object();
    private static Field r;
    private static boolean s;
    private static final Object t = new Object();
    private static Field u;
    private static Field v;
    private static Field w;
    private static Field x;
    private static boolean y;

    private NotificationCompatJellybean() {
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    private static boolean b() {
        if (y) {
            return false;
        }
        try {
            if (u == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                v = cls.getDeclaredField(f5506d);
                w = cls.getDeclaredField("title");
                x = cls.getDeclaredField(f5508f);
                Field declaredField = Notification.class.getDeclaredField("actions");
                u = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (ClassNotFoundException | NoSuchFieldException e2) {
            Log.e(f5503a, "Unable to access notification actions", e2);
            y = true;
        }
        return !y;
    }

    private static RemoteInput c(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(f5516n);
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it2 = stringArrayList.iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next());
            }
        }
        return new RemoteInput(bundle.getString(f5512j), bundle.getCharSequence("label"), bundle.getCharSequenceArray(f5514l), bundle.getBoolean(f5515m), 0, bundle.getBundle(f5509g), hashSet);
    }

    private static RemoteInput[] d(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[bundleArr.length];
        for (int i2 = 0; i2 < bundleArr.length; i2++) {
            remoteInputArr[i2] = c(bundleArr[i2]);
        }
        return remoteInputArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r5 = r5.getSparseParcelableArray(androidx.core.app.NotificationCompatExtras.f5501e);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.app.NotificationCompat.Action e(android.app.Notification r5, int r6) {
        /*
            java.lang.Object r0 = t
            monitor-enter(r0)
            r1 = 0
            java.lang.Object[] r2 = h(r5)     // Catch:{ IllegalAccessException -> 0x0023 }
            if (r2 == 0) goto L_0x004c
            r2 = r2[r6]     // Catch:{ IllegalAccessException -> 0x0023 }
            android.os.Bundle r5 = k(r5)     // Catch:{ IllegalAccessException -> 0x0023 }
            if (r5 == 0) goto L_0x0025
            java.lang.String r3 = "android.support.actionExtras"
            android.util.SparseArray r5 = r5.getSparseParcelableArray(r3)     // Catch:{ IllegalAccessException -> 0x0023 }
            if (r5 == 0) goto L_0x0025
            java.lang.Object r5 = r5.get(r6)     // Catch:{ IllegalAccessException -> 0x0023 }
            android.os.Bundle r5 = (android.os.Bundle) r5     // Catch:{ IllegalAccessException -> 0x0023 }
            goto L_0x0026
        L_0x0021:
            r5 = move-exception
            goto L_0x004e
        L_0x0023:
            r5 = move-exception
            goto L_0x0042
        L_0x0025:
            r5 = r1
        L_0x0026:
            java.lang.reflect.Field r6 = v     // Catch:{ IllegalAccessException -> 0x0023 }
            int r6 = r6.getInt(r2)     // Catch:{ IllegalAccessException -> 0x0023 }
            java.lang.reflect.Field r3 = w     // Catch:{ IllegalAccessException -> 0x0023 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ IllegalAccessException -> 0x0023 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ IllegalAccessException -> 0x0023 }
            java.lang.reflect.Field r4 = x     // Catch:{ IllegalAccessException -> 0x0023 }
            java.lang.Object r2 = r4.get(r2)     // Catch:{ IllegalAccessException -> 0x0023 }
            android.app.PendingIntent r2 = (android.app.PendingIntent) r2     // Catch:{ IllegalAccessException -> 0x0023 }
            androidx.core.app.NotificationCompat$Action r5 = l(r6, r3, r2, r5)     // Catch:{ IllegalAccessException -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r5
        L_0x0042:
            java.lang.String r6 = "NotificationCompat"
            java.lang.String r2 = "Unable to access notification actions"
            android.util.Log.e(r6, r2, r5)     // Catch:{ all -> 0x0021 }
            r5 = 1
            y = r5     // Catch:{ all -> 0x0021 }
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r1
        L_0x004e:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompatJellybean.e(android.app.Notification, int):androidx.core.app.NotificationCompat$Action");
    }

    public static int f(Notification notification) {
        int length;
        synchronized (t) {
            try {
                Object[] h2 = h(notification);
                length = h2 != null ? h2.length : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return length;
    }

    static NotificationCompat.Action g(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f5509g);
        return new NotificationCompat.Action(bundle.getInt(f5506d), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable(f5508f), bundle.getBundle(f5509g), d(i(bundle, f5510h)), d(i(bundle, f5511i)), bundle2 != null ? bundle2.getBoolean(f5505c, false) : false, bundle.getInt(o), bundle.getBoolean(p), false, false);
    }

    private static Object[] h(Notification notification) {
        synchronized (t) {
            if (!b()) {
                return null;
            }
            try {
                Object[] objArr = (Object[]) u.get(notification);
                return objArr;
            } catch (IllegalAccessException e2) {
                Log.e(f5503a, "Unable to access notification actions", e2);
                y = true;
                return null;
            }
        }
    }

    private static Bundle[] i(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    static Bundle j(NotificationCompat.Action action) {
        Bundle bundle = new Bundle();
        IconCompat f2 = action.f();
        bundle.putInt(f5506d, f2 != null ? f2.z() : 0);
        bundle.putCharSequence("title", action.j());
        bundle.putParcelable(f5508f, action.a());
        Bundle bundle2 = action.d() != null ? new Bundle(action.d()) : new Bundle();
        bundle2.putBoolean(f5505c, action.b());
        bundle.putBundle(f5509g, bundle2);
        bundle.putParcelableArray(f5510h, n(action.g()));
        bundle.putBoolean(p, action.i());
        bundle.putInt(o, action.h());
        return bundle;
    }

    public static Bundle k(Notification notification) {
        String str;
        String str2;
        synchronized (q) {
            if (s) {
                return null;
            }
            try {
                if (r == null) {
                    Field declaredField = Notification.class.getDeclaredField(f5509g);
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e(f5503a, "Notification.extras field is not of type Bundle");
                        s = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    r = declaredField;
                }
                Bundle bundle = (Bundle) r.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    r.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                e = e2;
                str2 = f5503a;
                str = "Unable to access notification extras";
                Log.e(str2, str, e);
                s = true;
                return null;
            } catch (NoSuchFieldException e3) {
                e = e3;
                str2 = f5503a;
                str = "Unable to access notification extras";
                Log.e(str2, str, e);
                s = true;
                return null;
            }
        }
    }

    public static NotificationCompat.Action l(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        boolean z;
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            remoteInputArr2 = d(i(bundle2, NotificationCompatExtras.f5502f));
            remoteInputArr = d(i(bundle2, f5504b));
            z = bundle2.getBoolean(f5505c);
        } else {
            remoteInputArr2 = null;
            remoteInputArr = null;
            z = false;
        }
        return new NotificationCompat.Action(i2, charSequence, pendingIntent, bundle, remoteInputArr2, remoteInputArr, z, 0, true, false, false);
    }

    private static Bundle m(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString(f5512j, remoteInput.o());
        bundle.putCharSequence("label", remoteInput.n());
        bundle.putCharSequenceArray(f5514l, remoteInput.h());
        bundle.putBoolean(f5515m, remoteInput.f());
        bundle.putBundle(f5509g, remoteInput.m());
        Set<String> g2 = remoteInput.g();
        if (g2 != null && !g2.isEmpty()) {
            ArrayList arrayList = new ArrayList(g2.size());
            for (String add : g2) {
                arrayList.add(add);
            }
            bundle.putStringArrayList(f5516n, arrayList);
        }
        return bundle;
    }

    private static Bundle[] n(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i2 = 0; i2 < remoteInputArr.length; i2++) {
            bundleArr[i2] = m(remoteInputArr[i2]);
        }
        return bundleArr;
    }

    public static Bundle o(Notification.Builder builder, NotificationCompat.Action action) {
        IconCompat f2 = action.f();
        builder.addAction(f2 != null ? f2.z() : 0, action.j(), action.a());
        Bundle bundle = new Bundle(action.d());
        if (action.g() != null) {
            bundle.putParcelableArray(NotificationCompatExtras.f5502f, n(action.g()));
        }
        if (action.c() != null) {
            bundle.putParcelableArray(f5504b, n(action.c()));
        }
        bundle.putBoolean(f5505c, action.b());
        return bundle;
    }
}
