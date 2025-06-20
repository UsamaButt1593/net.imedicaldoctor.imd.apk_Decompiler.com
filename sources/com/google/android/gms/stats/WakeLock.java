package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.stats.zzb;
import com.google.android.gms.internal.stats.zzc;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ShowFirstParty
@KeepForSdk
@ThreadSafe
public class WakeLock {
    private static final long r = TimeUnit.DAYS.toMillis(366);
    private static volatile ScheduledExecutorService s = null;
    private static final Object t = new Object();
    private static volatile zzd u = new zzb();

    /* renamed from: a  reason: collision with root package name */
    private final Object f20504a = new Object();
    @GuardedBy("acquireReleaseLock")

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f20505b;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: c  reason: collision with root package name */
    private int f20506c = 0;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: d  reason: collision with root package name */
    private Future<?> f20507d;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: e  reason: collision with root package name */
    private long f20508e;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: f  reason: collision with root package name */
    private final Set<zze> f20509f = new HashSet();
    @GuardedBy("acquireReleaseLock")

    /* renamed from: g  reason: collision with root package name */
    private boolean f20510g = true;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: h  reason: collision with root package name */
    private int f20511h;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: i  reason: collision with root package name */
    zzb f20512i;

    /* renamed from: j  reason: collision with root package name */
    private Clock f20513j = DefaultClock.e();

    /* renamed from: k  reason: collision with root package name */
    private WorkSource f20514k;

    /* renamed from: l  reason: collision with root package name */
    private final String f20515l;

    /* renamed from: m  reason: collision with root package name */
    private final String f20516m;

    /* renamed from: n  reason: collision with root package name */
    private final Context f20517n;
    @GuardedBy("acquireReleaseLock")
    private final Map<String, zzc> o = new HashMap();
    private AtomicInteger p = new AtomicInteger(0);
    private final ScheduledExecutorService q;

    @KeepForSdk
    public WakeLock(@NonNull Context context, int i2, @NonNull String str) {
        String packageName = context.getPackageName();
        Preconditions.s(context, "WakeLock: context must not be null");
        Preconditions.m(str, "WakeLock: wakeLockName must not be empty");
        this.f20517n = context.getApplicationContext();
        this.f20516m = str;
        this.f20512i = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.f20515l = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.f20515l = str;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i2, str);
            this.f20505b = newWakeLock;
            if (WorkSourceUtil.g(context)) {
                WorkSource b2 = WorkSourceUtil.b(context, Strings.b(packageName) ? context.getPackageName() : packageName);
                this.f20514k = b2;
                if (b2 != null) {
                    i(newWakeLock, b2);
                }
            }
            ScheduledExecutorService scheduledExecutorService = s;
            if (scheduledExecutorService == null) {
                synchronized (t) {
                    try {
                        scheduledExecutorService = s;
                        if (scheduledExecutorService == null) {
                            zzh.zza();
                            scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                            s = scheduledExecutorService;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.q = scheduledExecutorService;
            return;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("expected a non-null reference", 0, 29);
        throw new zzi(sb.toString());
    }

    public static /* synthetic */ void e(@NonNull WakeLock wakeLock) {
        synchronized (wakeLock.f20504a) {
            try {
                if (wakeLock.b()) {
                    Log.e("WakeLock", String.valueOf(wakeLock.f20515l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    wakeLock.g();
                    if (wakeLock.b()) {
                        wakeLock.f20506c = 1;
                        wakeLock.h(0);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("acquireReleaseLock")
    private final String f(String str) {
        if (this.f20510g) {
            TextUtils.isEmpty((CharSequence) null);
        }
        return null;
    }

    @GuardedBy("acquireReleaseLock")
    private final void g() {
        if (!this.f20509f.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f20509f);
            this.f20509f.clear();
            if (arrayList.size() > 0) {
                zze zze = (zze) arrayList.get(0);
                throw null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        if (r5.f20512i != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0062, code lost:
        r5.f20512i = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0087, code lost:
        if (r5.f20512i != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void h(int r6) {
        /*
            r5 = this;
            java.lang.Object r6 = r5.f20504a
            monitor-enter(r6)
            boolean r0 = r5.b()     // Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x000e
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            return
        L_0x000b:
            r0 = move-exception
            goto L_0x00a5
        L_0x000e:
            boolean r0 = r5.f20510g     // Catch:{ all -> 0x000b }
            r1 = 0
            if (r0 == 0) goto L_0x001e
            int r0 = r5.f20506c     // Catch:{ all -> 0x000b }
            int r0 = r0 + -1
            r5.f20506c = r0     // Catch:{ all -> 0x000b }
            if (r0 > 0) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            return
        L_0x001e:
            r5.f20506c = r1     // Catch:{ all -> 0x000b }
        L_0x0020:
            r5.g()     // Catch:{ all -> 0x000b }
            java.util.Map<java.lang.String, com.google.android.gms.stats.zzc> r0 = r5.o     // Catch:{ all -> 0x000b }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x000b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x000b }
        L_0x002d:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x000b }
            if (r2 == 0) goto L_0x003c
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x000b }
            com.google.android.gms.stats.zzc r2 = (com.google.android.gms.stats.zzc) r2     // Catch:{ all -> 0x000b }
            r2.f20518a = r1     // Catch:{ all -> 0x000b }
            goto L_0x002d
        L_0x003c:
            java.util.Map<java.lang.String, com.google.android.gms.stats.zzc> r0 = r5.o     // Catch:{ all -> 0x000b }
            r0.clear()     // Catch:{ all -> 0x000b }
            java.util.concurrent.Future<?> r0 = r5.f20507d     // Catch:{ all -> 0x000b }
            r2 = 0
            if (r0 == 0) goto L_0x004f
            r0.cancel(r1)     // Catch:{ all -> 0x000b }
            r5.f20507d = r2     // Catch:{ all -> 0x000b }
            r3 = 0
            r5.f20508e = r3     // Catch:{ all -> 0x000b }
        L_0x004f:
            r5.f20511h = r1     // Catch:{ all -> 0x000b }
            android.os.PowerManager$WakeLock r0 = r5.f20505b     // Catch:{ all -> 0x000b }
            boolean r0 = r0.isHeld()     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x0092
            android.os.PowerManager$WakeLock r0 = r5.f20505b     // Catch:{ RuntimeException -> 0x0067 }
            r0.release()     // Catch:{ RuntimeException -> 0x0067 }
            com.google.android.gms.internal.stats.zzb r0 = r5.f20512i     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x00a3
        L_0x0062:
            r5.f20512i = r2     // Catch:{ all -> 0x000b }
            goto L_0x00a3
        L_0x0065:
            r0 = move-exception
            goto L_0x008b
        L_0x0067:
            r0 = move-exception
            java.lang.Class r1 = r0.getClass()     // Catch:{ all -> 0x0065 }
            java.lang.Class<java.lang.RuntimeException> r3 = java.lang.RuntimeException.class
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x008a
            java.lang.String r1 = "WakeLock"
            java.lang.String r3 = r5.f20515l     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = " failed to release!"
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x0065 }
            android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x0065 }
            com.google.android.gms.internal.stats.zzb r0 = r5.f20512i     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x00a3
            goto L_0x0062
        L_0x008a:
            throw r0     // Catch:{ all -> 0x0065 }
        L_0x008b:
            com.google.android.gms.internal.stats.zzb r1 = r5.f20512i     // Catch:{ all -> 0x000b }
            if (r1 == 0) goto L_0x0091
            r5.f20512i = r2     // Catch:{ all -> 0x000b }
        L_0x0091:
            throw r0     // Catch:{ all -> 0x000b }
        L_0x0092:
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r5.f20515l     // Catch:{ all -> 0x000b }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x000b }
            java.lang.String r2 = " should be held!"
            java.lang.String r1 = r1.concat(r2)     // Catch:{ all -> 0x000b }
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x000b }
        L_0x00a3:
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            return
        L_0x00a5:
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.h(int):void");
    }

    private static void i(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
            Log.wtf("WakeLock", e2.toString());
        }
    }

    @KeepForSdk
    public void a(long j2) {
        this.p.incrementAndGet();
        long j3 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, r), 1);
        if (j2 > 0) {
            max = Math.min(j2, max);
        }
        synchronized (this.f20504a) {
            try {
                if (!b()) {
                    this.f20512i = zzb.zza(false, (zzc) null);
                    this.f20505b.acquire();
                    this.f20513j.b();
                }
                this.f20506c++;
                this.f20511h++;
                f((String) null);
                zzc zzc = this.o.get((Object) null);
                if (zzc == null) {
                    zzc = new zzc((zzb) null);
                    this.o.put((Object) null, zzc);
                }
                zzc.f20518a++;
                long b2 = this.f20513j.b();
                if (Long.MAX_VALUE - b2 > max) {
                    j3 = b2 + max;
                }
                if (j3 > this.f20508e) {
                    this.f20508e = j3;
                    Future<?> future = this.f20507d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.f20507d = this.q.schedule(new zza(this), max, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public boolean b() {
        boolean z;
        synchronized (this.f20504a) {
            z = this.f20506c > 0;
        }
        return z;
    }

    @KeepForSdk
    public void c() {
        if (this.p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f20515l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f20504a) {
            try {
                f((String) null);
                if (this.o.containsKey((Object) null)) {
                    zzc zzc = this.o.get((Object) null);
                    if (zzc != null) {
                        int i2 = zzc.f20518a - 1;
                        zzc.f20518a = i2;
                        if (i2 == 0) {
                            this.o.remove((Object) null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f20515l).concat(" counter does not exist"));
                }
                h(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public void d(boolean z) {
        synchronized (this.f20504a) {
            this.f20510g = z;
        }
    }
}
