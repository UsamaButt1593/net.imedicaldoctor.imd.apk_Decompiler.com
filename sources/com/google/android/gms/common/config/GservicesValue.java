package com.google.android.gms.common.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@KeepForSdk
public abstract class GservicesValue<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f20185d = new Object();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    protected final String f20186a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    protected final Object f20187b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Object f20188c = null;

    protected GservicesValue(@NonNull String str, @NonNull Object obj) {
        this.f20186a = str;
        this.f20187b = obj;
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static boolean c() {
        synchronized (f20185d) {
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Float> f(@NonNull String str, @NonNull Float f2) {
        return new zzd(str, f2);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Integer> g(@NonNull String str, @NonNull Integer num) {
        return new zzc(str, num);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Long> h(@NonNull String str, @NonNull Long l2) {
        return new zzb(str, l2);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<String> i(@NonNull String str, @NonNull String str2) {
        return new zze(str, str2);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Boolean> j(@NonNull String str, boolean z) {
        return new zza(str, Boolean.valueOf(z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1 = android.os.Binder.clearCallingIdentity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = k(r4.f20186a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0025, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002e, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002f, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0032, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0018 */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f20188c
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()
            java.lang.Object r1 = f20185d
            monitor-enter(r1)
            monitor-exit(r1)     // Catch:{ all -> 0x0036 }
            monitor-enter(r1)
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            java.lang.String r1 = r4.f20186a     // Catch:{ SecurityException -> 0x0018 }
            java.lang.Object r1 = r4.k(r1)     // Catch:{ SecurityException -> 0x0018 }
            goto L_0x0026
        L_0x0016:
            r1 = move-exception
            goto L_0x002f
        L_0x0018:
            long r1 = android.os.Binder.clearCallingIdentity()     // Catch:{ all -> 0x0016 }
            java.lang.String r3 = r4.f20186a     // Catch:{ all -> 0x002a }
            java.lang.Object r3 = r4.k(r3)     // Catch:{ all -> 0x002a }
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x0016 }
            r1 = r3
        L_0x0026:
            android.os.StrictMode.setThreadPolicy(r0)
            return r1
        L_0x002a:
            r3 = move-exception
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x0016 }
            throw r3     // Catch:{ all -> 0x0016 }
        L_0x002f:
            android.os.StrictMode.setThreadPolicy(r0)
            throw r1
        L_0x0033:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            throw r0
        L_0x0036:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0036 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.config.GservicesValue.a():java.lang.Object");
    }

    @InlineMe(replacement = "this.get()")
    @NonNull
    @KeepForSdk
    @Deprecated
    public final T b() {
        return a();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    @androidx.annotation.VisibleForTesting
    @com.google.android.gms.common.annotation.KeepForSdk
    public void d(@androidx.annotation.NonNull T r3) {
        /*
            r2 = this;
            java.lang.String r0 = "GservicesValue"
            java.lang.String r1 = "GservicesValue.override(): test should probably call initForTests() first"
            android.util.Log.w(r0, r1)
            r2.f20188c = r3
            java.lang.Object r3 = f20185d
            monitor-enter(r3)
            monitor-enter(r3)     // Catch:{ all -> 0x0010 }
            monitor-exit(r3)     // Catch:{ all -> 0x0012 }
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            return
        L_0x0010:
            r0 = move-exception
            goto L_0x0015
        L_0x0012:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0012 }
            throw r0     // Catch:{ all -> 0x0010 }
        L_0x0015:
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.config.GservicesValue.d(java.lang.Object):void");
    }

    @VisibleForTesting
    @KeepForSdk
    public void e() {
        this.f20188c = null;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract Object k(@NonNull String str);
}
