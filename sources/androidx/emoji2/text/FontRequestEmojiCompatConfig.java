package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {

    /* renamed from: k  reason: collision with root package name */
    private static final FontProviderHelper f7642k = new FontProviderHelper();

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {

        /* renamed from: a  reason: collision with root package name */
        private final long f7643a;

        /* renamed from: b  reason: collision with root package name */
        private long f7644b;

        public ExponentialBackoffRetryPolicy(long j2) {
            this.f7643a = j2;
        }

        public long a() {
            int i2 = (this.f7644b > 0 ? 1 : (this.f7644b == 0 ? 0 : -1));
            long uptimeMillis = SystemClock.uptimeMillis();
            if (i2 == 0) {
                this.f7644b = uptimeMillis;
                return 0;
            }
            long j2 = uptimeMillis - this.f7644b;
            if (j2 > this.f7643a) {
                return -1;
            }
            return Math.min(Math.max(j2, 1000), this.f7643a - j2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class FontProviderHelper {
        @Nullable
        public Typeface a(@NonNull Context context, @NonNull FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.a(context, (CancellationSignal) null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        @NonNull
        public FontsContractCompat.FontFamilyResult b(@NonNull Context context, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.b(context, (CancellationSignal) null, fontRequest);
        }

        public void c(@NonNull Context context, @NonNull Uri uri, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void d(@NonNull Context context, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    private static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: l  reason: collision with root package name */
        private static final String f7645l = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Context f7646a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final FontRequest f7647b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final FontProviderHelper f7648c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final Object f7649d = new Object();
        @GuardedBy("mLock")
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private Handler f7650e;
        @GuardedBy("mLock")
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private Executor f7651f;
        @GuardedBy("mLock")
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private ThreadPoolExecutor f7652g;
        @GuardedBy("mLock")
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private RetryPolicy f7653h;
        @GuardedBy("mLock")
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        EmojiCompat.MetadataRepoLoaderCallback f7654i;
        @GuardedBy("mLock")
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private ContentObserver f7655j;
        @GuardedBy("mLock")
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        private Runnable f7656k;

        FontRequestMetadataLoader(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontProviderHelper fontProviderHelper) {
            Preconditions.m(context, "Context cannot be null");
            Preconditions.m(fontRequest, "FontRequest cannot be null");
            this.f7646a = context.getApplicationContext();
            this.f7647b = fontRequest;
            this.f7648c = fontProviderHelper;
        }

        private void b() {
            synchronized (this.f7649d) {
                try {
                    this.f7654i = null;
                    ContentObserver contentObserver = this.f7655j;
                    if (contentObserver != null) {
                        this.f7648c.d(this.f7646a, contentObserver);
                        this.f7655j = null;
                    }
                    Handler handler = this.f7650e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f7656k);
                    }
                    this.f7650e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f7652g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f7651f = null;
                    this.f7652g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @WorkerThread
        private FontsContractCompat.FontInfo e() {
            try {
                FontsContractCompat.FontFamilyResult b2 = this.f7648c.b(this.f7646a, this.f7647b);
                if (b2.c() == 0) {
                    FontsContractCompat.FontInfo[] b3 = b2.b();
                    if (b3 != null && b3.length != 0) {
                        return b3[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + b2.c() + ")");
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException("provider not found", e2);
            }
        }

        @RequiresApi(19)
        @WorkerThread
        private void f(Uri uri, long j2) {
            synchronized (this.f7649d) {
                try {
                    Handler handler = this.f7650e;
                    if (handler == null) {
                        handler = ConcurrencyHelpers.e();
                        this.f7650e = handler;
                    }
                    if (this.f7655j == null) {
                        AnonymousClass1 r2 = new ContentObserver(handler) {
                            public void onChange(boolean z, Uri uri) {
                                FontRequestMetadataLoader.this.d();
                            }
                        };
                        this.f7655j = r2;
                        this.f7648c.c(this.f7646a, uri, r2);
                    }
                    if (this.f7656k == null) {
                        this.f7656k = new f(this);
                    }
                    handler.postDelayed(this.f7656k, j2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @RequiresApi(19)
        public void a(@NonNull EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.m(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.f7649d) {
                this.f7654i = metadataRepoLoaderCallback;
            }
            d();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = e();
            r1 = r0.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
            if (r1 != 2) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
            r2 = r8.f7649d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r3 = r8.f7653h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
            if (r3 == null) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
            r3 = r3.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
            if (r3 < 0) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
            f(r0.d(), r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0034, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0038, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x003a, code lost:
            if (r1 != 0) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            androidx.core.os.TraceCompat.b(f7645l);
            r1 = r8.f7648c.a(r8.f7646a, r0);
            r0 = androidx.core.graphics.TypefaceCompatUtil.f(r8.f7646a, (android.os.CancellationSignal) null, r0.d());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0054, code lost:
            if (r0 == null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
            if (r1 == null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0058, code lost:
            r0 = androidx.emoji2.text.MetadataRepo.e(r1, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            androidx.core.os.TraceCompat.d();
            r1 = r8.f7649d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0061, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            r2 = r8.f7654i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0064, code lost:
            if (r2 == null) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0066, code lost:
            r2.b(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006c, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0073, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x007c, code lost:
            throw new java.lang.RuntimeException("Unable to open file.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            androidx.core.os.TraceCompat.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0080, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x009c, code lost:
            throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r1 + ")");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x009f, code lost:
            monitor-enter(r8.f7649d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            r2 = r8.f7654i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a2, code lost:
            if (r2 != null) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a4, code lost:
            r2.a(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00a8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ab, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00b0, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            return;
         */
        @androidx.annotation.RequiresApi(19)
        @androidx.annotation.WorkerThread
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r8 = this;
                java.lang.Object r0 = r8.f7649d
                monitor-enter(r0)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r1 = r8.f7654i     // Catch:{ all -> 0x0009 }
                if (r1 != 0) goto L_0x000c
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r1 = move-exception
                goto L_0x00b1
            L_0x000c:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                androidx.core.provider.FontsContractCompat$FontInfo r0 = r8.e()     // Catch:{ all -> 0x0038 }
                int r1 = r0.b()     // Catch:{ all -> 0x0038 }
                r2 = 2
                if (r1 != r2) goto L_0x003a
                java.lang.Object r2 = r8.f7649d     // Catch:{ all -> 0x0038 }
                monitor-enter(r2)     // Catch:{ all -> 0x0038 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy r3 = r8.f7653h     // Catch:{ all -> 0x0032 }
                if (r3 == 0) goto L_0x0034
                long r3 = r3.a()     // Catch:{ all -> 0x0032 }
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 < 0) goto L_0x0034
                android.net.Uri r0 = r0.d()     // Catch:{ all -> 0x0032 }
                r8.f(r0, r3)     // Catch:{ all -> 0x0032 }
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r0 = move-exception
                goto L_0x0036
            L_0x0034:
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                goto L_0x003a
            L_0x0036:
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0038:
                r0 = move-exception
                goto L_0x009d
            L_0x003a:
                if (r1 != 0) goto L_0x0081
                java.lang.String r1 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
                androidx.core.os.TraceCompat.b(r1)     // Catch:{ all -> 0x0073 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$FontProviderHelper r1 = r8.f7648c     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r8.f7646a     // Catch:{ all -> 0x0073 }
                android.graphics.Typeface r1 = r1.a(r2, r0)     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r8.f7646a     // Catch:{ all -> 0x0073 }
                android.net.Uri r0 = r0.d()     // Catch:{ all -> 0x0073 }
                r3 = 0
                java.nio.ByteBuffer r0 = androidx.core.graphics.TypefaceCompatUtil.f(r2, r3, r0)     // Catch:{ all -> 0x0073 }
                if (r0 == 0) goto L_0x0075
                if (r1 == 0) goto L_0x0075
                androidx.emoji2.text.MetadataRepo r0 = androidx.emoji2.text.MetadataRepo.e(r1, r0)     // Catch:{ all -> 0x0073 }
                androidx.core.os.TraceCompat.d()     // Catch:{ all -> 0x0038 }
                java.lang.Object r1 = r8.f7649d     // Catch:{ all -> 0x0038 }
                monitor-enter(r1)     // Catch:{ all -> 0x0038 }
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.f7654i     // Catch:{ all -> 0x006a }
                if (r2 == 0) goto L_0x006c
                r2.b(r0)     // Catch:{ all -> 0x006a }
                goto L_0x006c
            L_0x006a:
                r0 = move-exception
                goto L_0x0071
            L_0x006c:
                monitor-exit(r1)     // Catch:{ all -> 0x006a }
                r8.b()     // Catch:{ all -> 0x0038 }
                goto L_0x00ae
            L_0x0071:
                monitor-exit(r1)     // Catch:{ all -> 0x006a }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0073:
                r0 = move-exception
                goto L_0x007d
            L_0x0075:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0073 }
                java.lang.String r1 = "Unable to open file."
                r0.<init>(r1)     // Catch:{ all -> 0x0073 }
                throw r0     // Catch:{ all -> 0x0073 }
            L_0x007d:
                androidx.core.os.TraceCompat.d()     // Catch:{ all -> 0x0038 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0081:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0038 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
                r2.<init>()     // Catch:{ all -> 0x0038 }
                java.lang.String r3 = "fetchFonts result is not OK. ("
                r2.append(r3)     // Catch:{ all -> 0x0038 }
                r2.append(r1)     // Catch:{ all -> 0x0038 }
                java.lang.String r1 = ")"
                r2.append(r1)     // Catch:{ all -> 0x0038 }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0038 }
                r0.<init>(r1)     // Catch:{ all -> 0x0038 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x009d:
                java.lang.Object r1 = r8.f7649d
                monitor-enter(r1)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.f7654i     // Catch:{ all -> 0x00a8 }
                if (r2 == 0) goto L_0x00aa
                r2.a(r0)     // Catch:{ all -> 0x00a8 }
                goto L_0x00aa
            L_0x00a8:
                r0 = move-exception
                goto L_0x00af
            L_0x00aa:
                monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
                r8.b()
            L_0x00ae:
                return
            L_0x00af:
                monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
                throw r0
            L_0x00b1:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.c():void");
        }

        /* access modifiers changed from: package-private */
        @RequiresApi(19)
        public void d() {
            synchronized (this.f7649d) {
                try {
                    if (this.f7654i != null) {
                        if (this.f7651f == null) {
                            ThreadPoolExecutor c2 = ConcurrencyHelpers.c("emojiCompat");
                            this.f7652g = c2;
                            this.f7651f = c2;
                        }
                        this.f7651f.execute(new e(this));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void g(@NonNull Executor executor) {
            synchronized (this.f7649d) {
                this.f7651f = executor;
            }
        }

        public void h(@Nullable RetryPolicy retryPolicy) {
            synchronized (this.f7649d) {
                this.f7653h = retryPolicy;
            }
        }
    }

    public static abstract class RetryPolicy {
        public abstract long a();
    }

    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, f7642k));
    }

    @NonNull
    @Deprecated
    public FontRequestEmojiCompatConfig l(@Nullable Handler handler) {
        if (handler == null) {
            return this;
        }
        m(ConcurrencyHelpers.b(handler));
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig m(@NonNull Executor executor) {
        ((FontRequestMetadataLoader) a()).g(executor);
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig n(@Nullable RetryPolicy retryPolicy) {
        ((FontRequestMetadataLoader) a()).h(retryPolicy);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontProviderHelper fontProviderHelper) {
        super(new FontRequestMetadataLoader(context, fontRequest, fontProviderHelper));
    }
}
