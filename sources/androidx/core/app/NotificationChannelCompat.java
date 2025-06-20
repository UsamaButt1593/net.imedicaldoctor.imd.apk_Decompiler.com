package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

public class NotificationChannelCompat {
    public static final String s = "miscellaneous";
    private static final boolean t = true;
    private static final int u = 0;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final String f5286a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f5287b;

    /* renamed from: c  reason: collision with root package name */
    int f5288c;

    /* renamed from: d  reason: collision with root package name */
    String f5289d;

    /* renamed from: e  reason: collision with root package name */
    String f5290e;

    /* renamed from: f  reason: collision with root package name */
    boolean f5291f;

    /* renamed from: g  reason: collision with root package name */
    Uri f5292g;

    /* renamed from: h  reason: collision with root package name */
    AudioAttributes f5293h;

    /* renamed from: i  reason: collision with root package name */
    boolean f5294i;

    /* renamed from: j  reason: collision with root package name */
    int f5295j;

    /* renamed from: k  reason: collision with root package name */
    boolean f5296k;

    /* renamed from: l  reason: collision with root package name */
    long[] f5297l;

    /* renamed from: m  reason: collision with root package name */
    String f5298m;

    /* renamed from: n  reason: collision with root package name */
    String f5299n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBypassDnd();
        }

        @DoNotInline
        static boolean b(NotificationChannel notificationChannel) {
            return notificationChannel.canShowBadge();
        }

        @DoNotInline
        static NotificationChannel c(String str, CharSequence charSequence, int i2) {
            return new NotificationChannel(str, charSequence, i2);
        }

        @DoNotInline
        static void d(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.enableLights(z);
        }

        @DoNotInline
        static void e(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.enableVibration(z);
        }

        @DoNotInline
        static AudioAttributes f(NotificationChannel notificationChannel) {
            return notificationChannel.getAudioAttributes();
        }

        @DoNotInline
        static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getDescription();
        }

        @DoNotInline
        static String h(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        @DoNotInline
        static String i(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        @DoNotInline
        static int j(NotificationChannel notificationChannel) {
            return notificationChannel.getImportance();
        }

        @DoNotInline
        static int k(NotificationChannel notificationChannel) {
            return notificationChannel.getLightColor();
        }

        @DoNotInline
        static int l(NotificationChannel notificationChannel) {
            return notificationChannel.getLockscreenVisibility();
        }

        @DoNotInline
        static CharSequence m(NotificationChannel notificationChannel) {
            return notificationChannel.getName();
        }

        @DoNotInline
        static Uri n(NotificationChannel notificationChannel) {
            return notificationChannel.getSound();
        }

        @DoNotInline
        static long[] o(NotificationChannel notificationChannel) {
            return notificationChannel.getVibrationPattern();
        }

        @DoNotInline
        static void p(NotificationChannel notificationChannel, String str) {
            notificationChannel.setDescription(str);
        }

        @DoNotInline
        static void q(NotificationChannel notificationChannel, String str) {
            notificationChannel.setGroup(str);
        }

        @DoNotInline
        static void r(NotificationChannel notificationChannel, int i2) {
            notificationChannel.setLightColor(i2);
        }

        @DoNotInline
        static void s(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.setShowBadge(z);
        }

        @DoNotInline
        static void t(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
            notificationChannel.setSound(uri, audioAttributes);
        }

        @DoNotInline
        static void u(NotificationChannel notificationChannel, long[] jArr) {
            notificationChannel.setVibrationPattern(jArr);
        }

        @DoNotInline
        static boolean v(NotificationChannel notificationChannel) {
            return notificationChannel.shouldShowLights();
        }

        @DoNotInline
        static boolean w(NotificationChannel notificationChannel) {
            return notificationChannel.shouldVibrate();
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBubble();
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static String a(NotificationChannel notificationChannel) {
            return notificationChannel.getConversationId();
        }

        @DoNotInline
        static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }

        @DoNotInline
        static boolean c(NotificationChannel notificationChannel) {
            return notificationChannel.isImportantConversation();
        }

        @DoNotInline
        static void d(NotificationChannel notificationChannel, String str, String str2) {
            notificationChannel.setConversationId(str, str2);
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final NotificationChannelCompat f5300a;

        public Builder(@NonNull String str, int i2) {
            this.f5300a = new NotificationChannelCompat(str, i2);
        }

        @NonNull
        public NotificationChannelCompat a() {
            return this.f5300a;
        }

        @NonNull
        public Builder b(@NonNull String str, @NonNull String str2) {
            if (Build.VERSION.SDK_INT >= 30) {
                NotificationChannelCompat notificationChannelCompat = this.f5300a;
                notificationChannelCompat.f5298m = str;
                notificationChannelCompat.f5299n = str2;
            }
            return this;
        }

        @NonNull
        public Builder c(@Nullable String str) {
            this.f5300a.f5289d = str;
            return this;
        }

        @NonNull
        public Builder d(@Nullable String str) {
            this.f5300a.f5290e = str;
            return this;
        }

        @NonNull
        public Builder e(int i2) {
            this.f5300a.f5288c = i2;
            return this;
        }

        @NonNull
        public Builder f(int i2) {
            this.f5300a.f5295j = i2;
            return this;
        }

        @NonNull
        public Builder g(boolean z) {
            this.f5300a.f5294i = z;
            return this;
        }

        @NonNull
        public Builder h(@Nullable CharSequence charSequence) {
            this.f5300a.f5287b = charSequence;
            return this;
        }

        @NonNull
        public Builder i(boolean z) {
            this.f5300a.f5291f = z;
            return this;
        }

        @NonNull
        public Builder j(@Nullable Uri uri, @Nullable AudioAttributes audioAttributes) {
            NotificationChannelCompat notificationChannelCompat = this.f5300a;
            notificationChannelCompat.f5292g = uri;
            notificationChannelCompat.f5293h = audioAttributes;
            return this;
        }

        @NonNull
        public Builder k(boolean z) {
            this.f5300a.f5296k = z;
            return this;
        }

        @NonNull
        public Builder l(@Nullable long[] jArr) {
            NotificationChannelCompat notificationChannelCompat = this.f5300a;
            notificationChannelCompat.f5296k = jArr != null && jArr.length > 0;
            notificationChannelCompat.f5297l = jArr;
            return this;
        }
    }

    @RequiresApi(26)
    NotificationChannelCompat(@NonNull NotificationChannel notificationChannel) {
        this(Api26Impl.i(notificationChannel), Api26Impl.j(notificationChannel));
        this.f5287b = Api26Impl.m(notificationChannel);
        this.f5289d = Api26Impl.g(notificationChannel);
        this.f5290e = Api26Impl.h(notificationChannel);
        this.f5291f = Api26Impl.b(notificationChannel);
        this.f5292g = Api26Impl.n(notificationChannel);
        this.f5293h = Api26Impl.f(notificationChannel);
        this.f5294i = Api26Impl.v(notificationChannel);
        this.f5295j = Api26Impl.k(notificationChannel);
        this.f5296k = Api26Impl.w(notificationChannel);
        this.f5297l = Api26Impl.o(notificationChannel);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f5298m = Api30Impl.b(notificationChannel);
            this.f5299n = Api30Impl.a(notificationChannel);
        }
        this.o = Api26Impl.a(notificationChannel);
        this.p = Api26Impl.l(notificationChannel);
        if (i2 >= 29) {
            this.q = Api29Impl.a(notificationChannel);
        }
        if (i2 >= 30) {
            this.r = Api30Impl.c(notificationChannel);
        }
    }

    public boolean a() {
        return this.q;
    }

    public boolean b() {
        return this.o;
    }

    public boolean c() {
        return this.f5291f;
    }

    @Nullable
    public AudioAttributes d() {
        return this.f5293h;
    }

    @Nullable
    public String e() {
        return this.f5299n;
    }

    @Nullable
    public String f() {
        return this.f5289d;
    }

    @Nullable
    public String g() {
        return this.f5290e;
    }

    @NonNull
    public String h() {
        return this.f5286a;
    }

    public int i() {
        return this.f5288c;
    }

    public int j() {
        return this.f5295j;
    }

    public int k() {
        return this.p;
    }

    @Nullable
    public CharSequence l() {
        return this.f5287b;
    }

    /* access modifiers changed from: package-private */
    public NotificationChannel m() {
        String str;
        String str2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return null;
        }
        NotificationChannel c2 = Api26Impl.c(this.f5286a, this.f5287b, this.f5288c);
        Api26Impl.p(c2, this.f5289d);
        Api26Impl.q(c2, this.f5290e);
        Api26Impl.s(c2, this.f5291f);
        Api26Impl.t(c2, this.f5292g, this.f5293h);
        Api26Impl.d(c2, this.f5294i);
        Api26Impl.r(c2, this.f5295j);
        Api26Impl.u(c2, this.f5297l);
        Api26Impl.e(c2, this.f5296k);
        if (!(i2 < 30 || (str = this.f5298m) == null || (str2 = this.f5299n) == null)) {
            Api30Impl.d(c2, str, str2);
        }
        return c2;
    }

    @Nullable
    public String n() {
        return this.f5298m;
    }

    @Nullable
    public Uri o() {
        return this.f5292g;
    }

    @Nullable
    public long[] p() {
        return this.f5297l;
    }

    public boolean q() {
        return this.r;
    }

    public boolean r() {
        return this.f5294i;
    }

    public boolean s() {
        return this.f5296k;
    }

    @NonNull
    public Builder t() {
        return new Builder(this.f5286a, this.f5288c).h(this.f5287b).c(this.f5289d).d(this.f5290e).i(this.f5291f).j(this.f5292g, this.f5293h).g(this.f5294i).f(this.f5295j).k(this.f5296k).l(this.f5297l).b(this.f5298m, this.f5299n);
    }

    NotificationChannelCompat(@NonNull String str, int i2) {
        this.f5291f = true;
        this.f5292g = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.f5295j = 0;
        this.f5286a = (String) Preconditions.l(str);
        this.f5288c = i2;
        this.f5293h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }
}
