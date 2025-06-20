package androidx.media3.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
public final class NetworkTypeObserver {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static NetworkTypeObserver f9594e;

    /* renamed from: a  reason: collision with root package name */
    private final Handler f9595a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<WeakReference<Listener>> f9596b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Object f9597c = new Object();
    @GuardedBy("networkTypeLock")

    /* renamed from: d  reason: collision with root package name */
    private int f9598d = 0;

    @RequiresApi(31)
    private static final class Api31 {

        private static final class DisplayInfoCallback extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* renamed from: a  reason: collision with root package name */
            private final NetworkTypeObserver f9599a;

            public DisplayInfoCallback(NetworkTypeObserver networkTypeObserver) {
                this.f9599a = networkTypeObserver;
            }

            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int a2 = h.a(telephonyDisplayInfo);
                int i2 = 5;
                boolean z = a2 == 3 || a2 == 4 || a2 == 5;
                NetworkTypeObserver networkTypeObserver = this.f9599a;
                if (z) {
                    i2 = 10;
                }
                networkTypeObserver.l(i2);
            }
        }

        private Api31() {
        }

        public static void a(Context context, NetworkTypeObserver networkTypeObserver) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) Assertions.g((TelephonyManager) context.getSystemService("phone"));
                DisplayInfoCallback displayInfoCallback = new DisplayInfoCallback(networkTypeObserver);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), displayInfoCallback);
                telephonyManager.unregisterTelephonyCallback(displayInfoCallback);
            } catch (RuntimeException unused) {
                networkTypeObserver.l(5);
            }
        }
    }

    public interface Listener {
        void a(int i2);
    }

    private final class Receiver extends BroadcastReceiver {
        private Receiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int b2 = NetworkTypeObserver.g(context);
            if (Util.f9646a < 31 || b2 != 5) {
                NetworkTypeObserver.this.l(b2);
            } else {
                Api31.a(context, NetworkTypeObserver.this);
            }
        }
    }

    private NetworkTypeObserver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new Receiver(), intentFilter);
    }

    public static synchronized NetworkTypeObserver d(Context context) {
        NetworkTypeObserver networkTypeObserver;
        synchronized (NetworkTypeObserver.class) {
            try {
                if (f9594e == null) {
                    f9594e = new NetworkTypeObserver(context);
                }
                networkTypeObserver = f9594e;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return networkTypeObserver;
    }

    private static int e(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 18:
                return 2;
            case 20:
                return Util.f9646a >= 29 ? 9 : 0;
            default:
                return 6;
        }
    }

    /* access modifiers changed from: private */
    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i2 = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i2 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (!(type == 4 || type == 5)) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return e(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(Listener listener) {
        listener.a(f());
    }

    private void j() {
        Iterator<WeakReference<Listener>> it2 = this.f9596b.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            if (next.get() == null) {
                this.f9596b.remove(next);
            }
        }
    }

    @VisibleForTesting
    public static synchronized void k() {
        synchronized (NetworkTypeObserver.class) {
            f9594e = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x000e, code lost:
        r0 = r3.f9596b.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        if (r0.hasNext() == false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        r1 = r0.next();
        r2 = (androidx.media3.common.util.NetworkTypeObserver.Listener) r1.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        if (r2 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r2.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r3.f9596b.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(int r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f9597c
            monitor-enter(r0)
            int r1 = r3.f9598d     // Catch:{ all -> 0x0009 }
            if (r1 != r4) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r4 = move-exception
            goto L_0x0033
        L_0x000b:
            r3.f9598d = r4     // Catch:{ all -> 0x0009 }
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<androidx.media3.common.util.NetworkTypeObserver$Listener>> r0 = r3.f9596b
            java.util.Iterator r0 = r0.iterator()
        L_0x0014:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r2 = r1.get()
            androidx.media3.common.util.NetworkTypeObserver$Listener r2 = (androidx.media3.common.util.NetworkTypeObserver.Listener) r2
            if (r2 == 0) goto L_0x002c
            r2.a(r4)
            goto L_0x0014
        L_0x002c:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<androidx.media3.common.util.NetworkTypeObserver$Listener>> r2 = r3.f9596b
            r2.remove(r1)
            goto L_0x0014
        L_0x0032:
            return
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.NetworkTypeObserver.l(int):void");
    }

    public int f() {
        int i2;
        synchronized (this.f9597c) {
            i2 = this.f9598d;
        }
        return i2;
    }

    public void i(Listener listener) {
        j();
        this.f9596b.add(new WeakReference(listener));
        this.f9595a.post(new C0180d(this, listener));
    }
}
