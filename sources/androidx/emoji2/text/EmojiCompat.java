package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AnyThread
public class EmojiCompat {
    public static final int A = 1;
    public static final int B = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static final int C = Integer.MAX_VALUE;
    private static final Object D = new Object();
    private static final Object E = new Object();
    @GuardedBy("INSTANCE_LOCK")
    @Nullable
    private static volatile EmojiCompat F = null;
    @GuardedBy("CONFIG_LOCK")
    private static volatile boolean G = false;
    private static final String H = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final String o = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String p = "android.support.text.emoji.emojiCompat_replaceAll";
    public static final int q = 3;
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 0;
    public static final int v = 1;
    public static final int w = 2;
    public static final int x = 0;
    public static final int y = 1;
    public static final int z = 0;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ReadWriteLock f7576a = new ReentrantReadWriteLock();
    @GuardedBy("mInitLock")
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Set<InitCallback> f7577b;
    @GuardedBy("mInitLock")

    /* renamed from: c  reason: collision with root package name */
    private volatile int f7578c = 3;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Handler f7579d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final CompatInternal f7580e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    final MetadataRepoLoader f7581f;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final SpanFactory f7582g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f7583h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f7584i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    final int[] f7585j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f7586k;

    /* renamed from: l  reason: collision with root package name */
    private final int f7587l;

    /* renamed from: m  reason: collision with root package name */
    private final int f7588m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final GlyphChecker f7589n;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CodepointSequenceMatchResult {
    }

    private static class CompatInternal {

        /* renamed from: a  reason: collision with root package name */
        final EmojiCompat f7590a;

        CompatInternal(EmojiCompat emojiCompat) {
            this.f7590a = emojiCompat;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return "";
        }

        /* access modifiers changed from: package-private */
        public int b(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2) {
            return -1;
        }

        public int c(CharSequence charSequence, int i2) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int d(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2) {
            return -1;
        }

        /* access modifiers changed from: package-private */
        public boolean e(@NonNull CharSequence charSequence) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean f(@NonNull CharSequence charSequence, int i2) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.f7590a.w();
        }

        /* access modifiers changed from: package-private */
        public CharSequence h(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, boolean z) {
            return charSequence;
        }

        /* access modifiers changed from: package-private */
        public void i(@NonNull EditorInfo editorInfo) {
        }
    }

    @RequiresApi(19)
    private static final class CompatInternal19 extends CompatInternal {

        /* renamed from: b  reason: collision with root package name */
        private volatile EmojiProcessor f7591b;

        /* renamed from: c  reason: collision with root package name */
        private volatile MetadataRepo f7592c;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        /* access modifiers changed from: package-private */
        public String a() {
            String N = this.f7592c.g().N();
            return N == null ? "" : N;
        }

        /* access modifiers changed from: package-private */
        public int b(@NonNull CharSequence charSequence, int i2) {
            return this.f7591b.b(charSequence, i2);
        }

        public int c(CharSequence charSequence, int i2) {
            return this.f7591b.d(charSequence, i2);
        }

        /* access modifiers changed from: package-private */
        public int d(@NonNull CharSequence charSequence, int i2) {
            return this.f7591b.e(charSequence, i2);
        }

        /* access modifiers changed from: package-private */
        public boolean e(@NonNull CharSequence charSequence) {
            return this.f7591b.c(charSequence) == 1;
        }

        /* access modifiers changed from: package-private */
        public boolean f(@NonNull CharSequence charSequence, int i2) {
            return this.f7591b.d(charSequence, i2) == 1;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            try {
                this.f7590a.f7581f.a(new MetadataRepoLoaderCallback() {
                    public void a(@Nullable Throwable th) {
                        CompatInternal19.this.f7590a.v(th);
                    }

                    public void b(@NonNull MetadataRepo metadataRepo) {
                        CompatInternal19.this.j(metadataRepo);
                    }
                });
            } catch (Throwable th) {
                this.f7590a.v(th);
            }
        }

        /* access modifiers changed from: package-private */
        public CharSequence h(@NonNull CharSequence charSequence, int i2, int i3, int i4, boolean z) {
            return this.f7591b.l(charSequence, i2, i3, i4, z);
        }

        /* access modifiers changed from: package-private */
        public void i(@NonNull EditorInfo editorInfo) {
            editorInfo.extras.putInt(EmojiCompat.o, this.f7592c.h());
            editorInfo.extras.putBoolean(EmojiCompat.p, this.f7590a.f7583h);
        }

        /* access modifiers changed from: package-private */
        public void j(@NonNull MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.f7590a.v(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f7592c = metadataRepo;
            MetadataRepo metadataRepo2 = this.f7592c;
            SpanFactory a2 = this.f7590a.f7582g;
            GlyphChecker b2 = this.f7590a.f7589n;
            EmojiCompat emojiCompat = this.f7590a;
            this.f7591b = new EmojiProcessor(metadataRepo2, a2, b2, emojiCompat.f7584i, emojiCompat.f7585j, EmojiExclusions.a());
            this.f7590a.w();
        }
    }

    public static abstract class Config {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final MetadataRepoLoader f7594a;

        /* renamed from: b  reason: collision with root package name */
        SpanFactory f7595b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7596c;

        /* renamed from: d  reason: collision with root package name */
        boolean f7597d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        int[] f7598e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        Set<InitCallback> f7599f;

        /* renamed from: g  reason: collision with root package name */
        boolean f7600g;

        /* renamed from: h  reason: collision with root package name */
        int f7601h = -16711936;

        /* renamed from: i  reason: collision with root package name */
        int f7602i = 0;
        @NonNull

        /* renamed from: j  reason: collision with root package name */
        GlyphChecker f7603j = new DefaultGlyphChecker();

        protected Config(@NonNull MetadataRepoLoader metadataRepoLoader) {
            Preconditions.m(metadataRepoLoader, "metadataLoader cannot be null.");
            this.f7594a = metadataRepoLoader;
        }

        /* access modifiers changed from: protected */
        @NonNull
        public final MetadataRepoLoader a() {
            return this.f7594a;
        }

        @NonNull
        public Config b(@NonNull InitCallback initCallback) {
            Preconditions.m(initCallback, "initCallback cannot be null");
            if (this.f7599f == null) {
                this.f7599f = new ArraySet();
            }
            this.f7599f.add(initCallback);
            return this;
        }

        @NonNull
        public Config c(@ColorInt int i2) {
            this.f7601h = i2;
            return this;
        }

        @NonNull
        public Config d(boolean z) {
            this.f7600g = z;
            return this;
        }

        @NonNull
        public Config e(@NonNull GlyphChecker glyphChecker) {
            Preconditions.m(glyphChecker, "GlyphChecker cannot be null");
            this.f7603j = glyphChecker;
            return this;
        }

        @NonNull
        public Config f(int i2) {
            this.f7602i = i2;
            return this;
        }

        @NonNull
        public Config g(boolean z) {
            this.f7596c = z;
            return this;
        }

        @NonNull
        public Config h(@NonNull SpanFactory spanFactory) {
            this.f7595b = spanFactory;
            return this;
        }

        @NonNull
        public Config i(boolean z) {
            return j(z, (List<Integer>) null);
        }

        @NonNull
        public Config j(boolean z, @Nullable List<Integer> list) {
            this.f7597d = z;
            if (!z || list == null) {
                this.f7598e = null;
            } else {
                this.f7598e = new int[list.size()];
                int i2 = 0;
                for (Integer intValue : list) {
                    this.f7598e[i2] = intValue.intValue();
                    i2++;
                }
                Arrays.sort(this.f7598e);
            }
            return this;
        }

        @NonNull
        public Config k(@NonNull InitCallback initCallback) {
            Preconditions.m(initCallback, "initCallback cannot be null");
            Set<InitCallback> set = this.f7599f;
            if (set != null) {
                set.remove(initCallback);
            }
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultSpanFactory implements SpanFactory {
        @RequiresApi(19)
        @NonNull
        public EmojiSpan a(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            return new TypefaceEmojiSpan(typefaceEmojiRasterizer);
        }
    }

    public interface GlyphChecker {
        boolean a(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4);
    }

    public static abstract class InitCallback {
        public void a(@Nullable Throwable th) {
        }

        public void b() {
        }
    }

    private static class ListenerDispatcher implements Runnable {
        private final Throwable X;
        private final int Y;
        private final List<InitCallback> s;

        ListenerDispatcher(@NonNull InitCallback initCallback, int i2) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) Preconditions.m(initCallback, "initCallback cannot be null")}), i2, (Throwable) null);
        }

        public void run() {
            int size = this.s.size();
            int i2 = 0;
            if (this.Y != 1) {
                while (i2 < size) {
                    this.s.get(i2).a(this.X);
                    i2++;
                }
                return;
            }
            while (i2 < size) {
                this.s.get(i2).b();
                i2++;
            }
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> collection, int i2) {
            this(collection, i2, (Throwable) null);
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> collection, int i2, @Nullable Throwable th) {
            Preconditions.m(collection, "initCallbacks cannot be null");
            this.s = new ArrayList(collection);
            this.Y = i2;
            this.X = th;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void a(@NonNull MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void a(@Nullable Throwable th);

        public abstract void b(@NonNull MetadataRepo metadataRepo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReplaceStrategy {
    }

    public interface SpanFactory {
        @RequiresApi(19)
        @NonNull
        EmojiSpan a(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    private EmojiCompat(@NonNull Config config) {
        this.f7583h = config.f7596c;
        this.f7584i = config.f7597d;
        this.f7585j = config.f7598e;
        this.f7586k = config.f7600g;
        this.f7587l = config.f7601h;
        this.f7581f = config.f7594a;
        this.f7588m = config.f7602i;
        this.f7589n = config.f7603j;
        this.f7579d = new Handler(Looper.getMainLooper());
        ArraySet arraySet = new ArraySet();
        this.f7577b = arraySet;
        SpanFactory spanFactory = config.f7595b;
        this.f7582g = spanFactory == null ? new DefaultSpanFactory() : spanFactory;
        Set<InitCallback> set = config.f7599f;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(config.f7599f);
        }
        this.f7580e = new CompatInternal19(this);
        u();
    }

    @NonNull
    public static EmojiCompat C(@NonNull Config config) {
        EmojiCompat emojiCompat;
        synchronized (D) {
            emojiCompat = new EmojiCompat(config);
            F = emojiCompat;
        }
        return emojiCompat;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static EmojiCompat D(@Nullable EmojiCompat emojiCompat) {
        EmojiCompat emojiCompat2;
        synchronized (D) {
            F = emojiCompat;
            emojiCompat2 = F;
        }
        return emojiCompat2;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void E(boolean z2) {
        synchronized (E) {
            G = z2;
        }
    }

    @NonNull
    public static EmojiCompat c() {
        EmojiCompat emojiCompat;
        synchronized (D) {
            emojiCompat = F;
            Preconditions.o(emojiCompat != null, H);
        }
        return emojiCompat;
    }

    public static boolean j(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, boolean z2) {
        return EmojiProcessor.f(inputConnection, editable, i2, i3, z2);
    }

    public static boolean k(@NonNull Editable editable, int i2, @NonNull KeyEvent keyEvent) {
        return EmojiProcessor.g(editable, i2, keyEvent);
    }

    @Nullable
    public static EmojiCompat n(@NonNull Context context) {
        return o(context, (DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory) null);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static EmojiCompat o(@NonNull Context context, @Nullable DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultEmojiCompatConfigFactory) {
        EmojiCompat emojiCompat;
        if (G) {
            return F;
        }
        if (defaultEmojiCompatConfigFactory == null) {
            defaultEmojiCompatConfigFactory = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory((DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper) null);
        }
        Config c2 = defaultEmojiCompatConfigFactory.c(context);
        synchronized (E) {
            try {
                if (!G) {
                    if (c2 != null) {
                        p(c2);
                    }
                    G = true;
                }
                emojiCompat = F;
            } catch (Throwable th) {
                throw th;
            }
        }
        return emojiCompat;
    }

    @NonNull
    public static EmojiCompat p(@NonNull Config config) {
        EmojiCompat emojiCompat = F;
        if (emojiCompat == null) {
            synchronized (D) {
                try {
                    emojiCompat = F;
                    if (emojiCompat == null) {
                        emojiCompat = new EmojiCompat(config);
                        F = emojiCompat;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return emojiCompat;
    }

    public static boolean q() {
        return F != null;
    }

    private boolean s() {
        return i() == 1;
    }

    /* JADX INFO: finally extract failed */
    private void u() {
        this.f7576a.writeLock().lock();
        try {
            if (this.f7588m == 0) {
                this.f7578c = 0;
            }
            this.f7576a.writeLock().unlock();
            if (i() == 0) {
                this.f7580e.g();
            }
        } catch (Throwable th) {
            this.f7576a.writeLock().unlock();
            throw th;
        }
    }

    @CheckResult
    @Nullable
    public CharSequence A(@Nullable CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, int i5) {
        Preconditions.o(s(), "Not initialized yet");
        Preconditions.j(i2, "start cannot be negative");
        Preconditions.j(i3, "end cannot be negative");
        Preconditions.j(i4, "maxEmojiCount cannot be negative");
        Preconditions.b(i2 <= i3, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.b(i2 <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.b(i3 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i2 == i3) {
            return charSequence;
        }
        return this.f7580e.h(charSequence, i2, i3, i4, i5 != 1 ? i5 != 2 ? this.f7583h : false : true);
    }

    public void B(@NonNull InitCallback initCallback) {
        Preconditions.m(initCallback, "initCallback cannot be null");
        this.f7576a.writeLock().lock();
        try {
            if (this.f7578c != 1) {
                if (this.f7578c != 2) {
                    this.f7577b.add(initCallback);
                }
            }
            this.f7579d.post(new ListenerDispatcher(initCallback, this.f7578c));
        } finally {
            this.f7576a.writeLock().unlock();
        }
    }

    public void F(@NonNull InitCallback initCallback) {
        Preconditions.m(initCallback, "initCallback cannot be null");
        this.f7576a.writeLock().lock();
        try {
            this.f7577b.remove(initCallback);
        } finally {
            this.f7576a.writeLock().unlock();
        }
    }

    public void G(@NonNull EditorInfo editorInfo) {
        if (s() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.f7580e.i(editorInfo);
        }
    }

    @NonNull
    public String d() {
        Preconditions.o(s(), "Not initialized yet");
        return this.f7580e.a();
    }

    public int e(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2) {
        return this.f7580e.b(charSequence, i2);
    }

    public int f(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2) {
        Preconditions.o(s(), "Not initialized yet");
        Preconditions.m(charSequence, "sequence cannot be null");
        return this.f7580e.c(charSequence, i2);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int g() {
        return this.f7587l;
    }

    public int h(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2) {
        return this.f7580e.d(charSequence, i2);
    }

    public int i() {
        this.f7576a.readLock().lock();
        try {
            return this.f7578c;
        } finally {
            this.f7576a.readLock().unlock();
        }
    }

    @Deprecated
    public boolean l(@NonNull CharSequence charSequence) {
        Preconditions.o(s(), "Not initialized yet");
        Preconditions.m(charSequence, "sequence cannot be null");
        return this.f7580e.e(charSequence);
    }

    @Deprecated
    public boolean m(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2) {
        Preconditions.o(s(), "Not initialized yet");
        Preconditions.m(charSequence, "sequence cannot be null");
        return this.f7580e.f(charSequence, i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean r() {
        return this.f7586k;
    }

    public void t() {
        boolean z2 = true;
        if (this.f7588m != 1) {
            z2 = false;
        }
        Preconditions.o(z2, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (!s()) {
            this.f7576a.writeLock().lock();
            try {
                if (this.f7578c != 0) {
                    this.f7578c = 0;
                    this.f7576a.writeLock().unlock();
                    this.f7580e.g();
                }
            } finally {
                this.f7576a.writeLock().unlock();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void v(@Nullable Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f7576a.writeLock().lock();
        try {
            this.f7578c = 2;
            arrayList.addAll(this.f7577b);
            this.f7577b.clear();
            this.f7576a.writeLock().unlock();
            this.f7579d.post(new ListenerDispatcher(arrayList, this.f7578c, th));
        } catch (Throwable th2) {
            this.f7576a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void w() {
        ArrayList arrayList = new ArrayList();
        this.f7576a.writeLock().lock();
        try {
            this.f7578c = 1;
            arrayList.addAll(this.f7577b);
            this.f7577b.clear();
            this.f7576a.writeLock().unlock();
            this.f7579d.post(new ListenerDispatcher((Collection<InitCallback>) arrayList, this.f7578c));
        } catch (Throwable th) {
            this.f7576a.writeLock().unlock();
            throw th;
        }
    }

    @CheckResult
    @Nullable
    public CharSequence x(@Nullable CharSequence charSequence) {
        return y(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    @CheckResult
    @Nullable
    public CharSequence y(@Nullable CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        return z(charSequence, i2, i3, Integer.MAX_VALUE);
    }

    @CheckResult
    @Nullable
    public CharSequence z(@Nullable CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4) {
        return A(charSequence, i2, i3, i4, 0);
    }
}
