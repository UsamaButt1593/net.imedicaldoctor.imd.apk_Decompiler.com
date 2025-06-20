package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public final class ProfileVerifier {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15119a = "/data/misc/profiles/ref/";

    /* renamed from: b  reason: collision with root package name */
    private static final String f15120b = "/data/misc/profiles/cur/0/";

    /* renamed from: c  reason: collision with root package name */
    private static final String f15121c = "primary.prof";

    /* renamed from: d  reason: collision with root package name */
    private static final String f15122d = "profileInstalled";

    /* renamed from: e  reason: collision with root package name */
    private static final ResolvableFuture<CompilationStatus> f15123e = ResolvableFuture.w();

    /* renamed from: f  reason: collision with root package name */
    private static final Object f15124f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static final String f15125g = "ProfileVerifier";
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static CompilationStatus f15126h = null;

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class Cache {

        /* renamed from: e  reason: collision with root package name */
        private static final int f15127e = 1;

        /* renamed from: a  reason: collision with root package name */
        final int f15128a;

        /* renamed from: b  reason: collision with root package name */
        final int f15129b;

        /* renamed from: c  reason: collision with root package name */
        final long f15130c;

        /* renamed from: d  reason: collision with root package name */
        final long f15131d;

        Cache(int i2, int i3, long j2, long j3) {
            this.f15128a = i2;
            this.f15129b = i3;
            this.f15130c = j2;
            this.f15131d = j3;
        }

        static Cache a(@NonNull File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return cache;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        /* access modifiers changed from: package-private */
        public void b(@NonNull File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f15128a);
                dataOutputStream.writeInt(this.f15129b);
                dataOutputStream.writeLong(this.f15130c);
                dataOutputStream.writeLong(this.f15131d);
                dataOutputStream.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Cache)) {
                return false;
            }
            Cache cache = (Cache) obj;
            return this.f15129b == cache.f15129b && this.f15130c == cache.f15130c && this.f15128a == cache.f15128a && this.f15131d == cache.f15131d;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f15129b), Long.valueOf(this.f15130c), Integer.valueOf(this.f15128a), Long.valueOf(this.f15131d)});
        }
    }

    public static class CompilationStatus {

        /* renamed from: d  reason: collision with root package name */
        private static final int f15132d = 16;

        /* renamed from: e  reason: collision with root package name */
        public static final int f15133e = 0;

        /* renamed from: f  reason: collision with root package name */
        public static final int f15134f = 1;

        /* renamed from: g  reason: collision with root package name */
        public static final int f15135g = 2;

        /* renamed from: h  reason: collision with root package name */
        public static final int f15136h = 3;

        /* renamed from: i  reason: collision with root package name */
        public static final int f15137i = 65536;

        /* renamed from: j  reason: collision with root package name */
        public static final int f15138j = 131072;

        /* renamed from: k  reason: collision with root package name */
        public static final int f15139k = 196608;

        /* renamed from: l  reason: collision with root package name */
        public static final int f15140l = 262144;

        /* renamed from: a  reason: collision with root package name */
        final int f15141a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f15142b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f15143c;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        CompilationStatus(int i2, boolean z, boolean z2) {
            this.f15141a = i2;
            this.f15143c = z2;
            this.f15142b = z;
        }

        public int a() {
            return this.f15141a;
        }

        public boolean b() {
            return this.f15143c;
        }

        public boolean c() {
            return this.f15142b;
        }
    }

    private ProfileVerifier() {
    }

    @NonNull
    public static ListenableFuture<CompilationStatus> a() {
        return f15123e;
    }

    private static long b(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return (Build.VERSION.SDK_INT >= 33 ? Api33Impl.a(packageManager, context) : packageManager.getPackageInfo(context.getPackageName(), 0)).lastUpdateTime;
    }

    private static CompilationStatus c(int i2, boolean z, boolean z2) {
        CompilationStatus compilationStatus = new CompilationStatus(i2, z, z2);
        f15126h = compilationStatus;
        f15123e.q(compilationStatus);
        return f15126h;
    }

    @WorkerThread
    @NonNull
    public static CompilationStatus d(@NonNull Context context) {
        return e(context, false);
    }

    @WorkerThread
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static CompilationStatus e(@NonNull Context context, boolean z) {
        boolean z2;
        boolean z3;
        Cache cache;
        CompilationStatus compilationStatus;
        if (!z && (compilationStatus = f15126h) != null) {
            return compilationStatus;
        }
        synchronized (f15124f) {
            if (!z) {
                try {
                    CompilationStatus compilationStatus2 = f15126h;
                    if (compilationStatus2 != null) {
                        return compilationStatus2;
                    }
                } catch (IOException unused) {
                    return c(131072, z2, z3);
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i2 = Build.VERSION.SDK_INT;
            int i3 = 0;
            if (i2 >= 28) {
                if (i2 != 30) {
                    File file = new File(new File(f15119a, context.getPackageName()), f15121c);
                    long length = file.length();
                    z2 = file.exists() && length > 0;
                    File file2 = new File(new File(f15120b, context.getPackageName()), f15121c);
                    long length2 = file2.length();
                    z3 = file2.exists() && length2 > 0;
                    try {
                        long b2 = b(context);
                        File file3 = new File(context.getFilesDir(), f15122d);
                        Cache a2 = file3.exists() ? Cache.a(file3) : null;
                        if (a2 != null && a2.f15130c == b2) {
                            int i4 = a2.f15129b;
                            if (i4 != 2) {
                                i3 = i4;
                                if (z && z3 && i3 != 1) {
                                    i3 = 2;
                                }
                                if (a2 != null && a2.f15129b == 2 && i3 == 1 && length < a2.f15131d) {
                                    i3 = 3;
                                }
                                cache = new Cache(1, i3, b2, length2);
                                if (a2 == null || !a2.equals(cache)) {
                                    cache.b(file3);
                                }
                                CompilationStatus c2 = c(i3, z2, z3);
                                return c2;
                            }
                        }
                        if (z2) {
                            i3 = 1;
                        } else if (z3) {
                            i3 = 2;
                        }
                        i3 = 2;
                        i3 = 3;
                        cache = new Cache(1, i3, b2, length2);
                        try {
                            cache.b(file3);
                        } catch (IOException unused2) {
                            i3 = CompilationStatus.f15139k;
                        }
                        CompilationStatus c22 = c(i3, z2, z3);
                        return c22;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        return c(65536, z2, z3);
                    }
                }
            }
            CompilationStatus c3 = c(262144, false, false);
            return c3;
        }
    }
}
