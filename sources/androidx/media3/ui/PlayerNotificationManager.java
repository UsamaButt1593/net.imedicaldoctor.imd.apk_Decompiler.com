package androidx.media3.ui;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.L;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.NotificationUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UnstableApi
public class PlayerNotificationManager {
    public static final String P = "androidx.media3.ui.notification.play";
    public static final String Q = "androidx.media3.ui.notification.pause";
    public static final String R = "androidx.media3.ui.notification.prev";
    public static final String S = "androidx.media3.ui.notification.next";
    public static final String T = "androidx.media3.ui.notification.ffwd";
    public static final String U = "androidx.media3.ui.notification.rewind";
    public static final String V = "androidx.media3.ui.notification.stop";
    public static final String W = "INSTANCE_ID";
    private static final String X = "androidx.media3.ui.notification.dismiss";
    private static final int Y = 0;
    private static final int Z = 1;
    private static int a0;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private boolean H;
    private int I;
    private int J;
    @DrawableRes
    private int K;
    private int L;
    private int M;
    private boolean N;
    @Nullable
    private String O;

    /* renamed from: a  reason: collision with root package name */
    private final Context f14658a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14659b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14660c;

    /* renamed from: d  reason: collision with root package name */
    private final MediaDescriptionAdapter f14661d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final NotificationListener f14662e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final CustomActionReceiver f14663f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f14664g = Util.G(Looper.getMainLooper(), new B(this));

    /* renamed from: h  reason: collision with root package name */
    private final NotificationManagerCompat f14665h;

    /* renamed from: i  reason: collision with root package name */
    private final IntentFilter f14666i;

    /* renamed from: j  reason: collision with root package name */
    private final Player.Listener f14667j;

    /* renamed from: k  reason: collision with root package name */
    private final NotificationBroadcastReceiver f14668k;

    /* renamed from: l  reason: collision with root package name */
    private final Map<String, NotificationCompat.Action> f14669l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Map<String, NotificationCompat.Action> f14670m;

    /* renamed from: n  reason: collision with root package name */
    private final PendingIntent f14671n;
    /* access modifiers changed from: private */
    public final int o;
    @Nullable
    private NotificationCompat.Builder p;
    @Nullable
    private List<NotificationCompat.Action> q;
    /* access modifiers changed from: private */
    @Nullable
    public Player r;
    /* access modifiers changed from: private */
    public boolean s;
    private int t;
    @Nullable
    private MediaSessionCompat.Token u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public final class BitmapCallback {

        /* renamed from: a  reason: collision with root package name */
        private final int f14672a;

        private BitmapCallback(int i2) {
            this.f14672a = i2;
        }

        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                PlayerNotificationManager.this.s(bitmap, this.f14672a);
            }
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        protected final Context f14674a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f14675b;

        /* renamed from: c  reason: collision with root package name */
        protected final String f14676c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        protected NotificationListener f14677d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        protected CustomActionReceiver f14678e;

        /* renamed from: f  reason: collision with root package name */
        protected MediaDescriptionAdapter f14679f;

        /* renamed from: g  reason: collision with root package name */
        protected int f14680g;

        /* renamed from: h  reason: collision with root package name */
        protected int f14681h;

        /* renamed from: i  reason: collision with root package name */
        protected int f14682i;

        /* renamed from: j  reason: collision with root package name */
        protected int f14683j;

        /* renamed from: k  reason: collision with root package name */
        protected int f14684k;

        /* renamed from: l  reason: collision with root package name */
        protected int f14685l;

        /* renamed from: m  reason: collision with root package name */
        protected int f14686m;

        /* renamed from: n  reason: collision with root package name */
        protected int f14687n;
        protected int o;
        protected int p;
        protected int q;
        @Nullable
        protected String r;

        public Builder(Context context, @IntRange(from = 1) int i2, String str) {
            Assertions.a(i2 > 0);
            this.f14674a = context;
            this.f14675b = i2;
            this.f14676c = str;
            this.f14682i = 2;
            this.f14679f = new DefaultMediaDescriptionAdapter((PendingIntent) null);
            this.f14683j = R.drawable.c0;
            this.f14685l = R.drawable.Z;
            this.f14686m = R.drawable.Y;
            this.f14687n = R.drawable.d0;
            this.f14684k = R.drawable.b0;
            this.o = R.drawable.W;
            this.p = R.drawable.a0;
            this.q = R.drawable.X;
        }

        public PlayerNotificationManager a() {
            int i2 = this.f14680g;
            if (i2 != 0) {
                NotificationUtil.a(this.f14674a, this.f14676c, i2, this.f14681h, this.f14682i);
            }
            Context context = this.f14674a;
            String str = this.f14676c;
            int i3 = this.f14675b;
            MediaDescriptionAdapter mediaDescriptionAdapter = this.f14679f;
            NotificationListener notificationListener = this.f14677d;
            CustomActionReceiver customActionReceiver = this.f14678e;
            int i4 = this.f14683j;
            int i5 = this.f14685l;
            int i6 = this.f14686m;
            int i7 = this.f14687n;
            int i8 = this.f14684k;
            int i9 = this.o;
            return new PlayerNotificationManager(context, str, i3, mediaDescriptionAdapter, notificationListener, customActionReceiver, i4, i5, i6, i7, i8, i9, this.p, this.q, this.r);
        }

        public Builder b(int i2) {
            this.f14681h = i2;
            return this;
        }

        public Builder c(int i2) {
            this.f14682i = i2;
            return this;
        }

        public Builder d(int i2) {
            this.f14680g = i2;
            return this;
        }

        public Builder e(CustomActionReceiver customActionReceiver) {
            this.f14678e = customActionReceiver;
            return this;
        }

        public Builder f(int i2) {
            this.o = i2;
            return this;
        }

        public Builder g(String str) {
            this.r = str;
            return this;
        }

        public Builder h(MediaDescriptionAdapter mediaDescriptionAdapter) {
            this.f14679f = mediaDescriptionAdapter;
            return this;
        }

        public Builder i(int i2) {
            this.q = i2;
            return this;
        }

        public Builder j(NotificationListener notificationListener) {
            this.f14677d = notificationListener;
            return this;
        }

        public Builder k(int i2) {
            this.f14686m = i2;
            return this;
        }

        public Builder l(int i2) {
            this.f14685l = i2;
            return this;
        }

        public Builder m(int i2) {
            this.p = i2;
            return this;
        }

        public Builder n(int i2) {
            this.f14684k = i2;
            return this;
        }

        public Builder o(int i2) {
            this.f14683j = i2;
            return this;
        }

        public Builder p(int i2) {
            this.f14687n = i2;
            return this;
        }

        @Deprecated
        public Builder(Context context, int i2, String str, MediaDescriptionAdapter mediaDescriptionAdapter) {
            this(context, i2, str);
            this.f14679f = mediaDescriptionAdapter;
        }
    }

    public interface CustomActionReceiver {
        Map<String, NotificationCompat.Action> a(Context context, int i2);

        void b(Player player, String str, Intent intent);

        List<String> c(Player player);
    }

    public interface MediaDescriptionAdapter {
        @Nullable
        CharSequence a(Player player);

        @Nullable
        Bitmap b(Player player, BitmapCallback bitmapCallback);

        @Nullable
        CharSequence c(Player player);

        @Nullable
        PendingIntent d(Player player);

        CharSequence e(Player player);
    }

    private class NotificationBroadcastReceiver extends BroadcastReceiver {
        private NotificationBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Player e2 = PlayerNotificationManager.this.r;
            if (e2 != null && PlayerNotificationManager.this.s && intent.getIntExtra(PlayerNotificationManager.W, PlayerNotificationManager.this.o) == PlayerNotificationManager.this.o) {
                String action = intent.getAction();
                if (PlayerNotificationManager.P.equals(action)) {
                    Util.U0(e2);
                } else if (PlayerNotificationManager.Q.equals(action)) {
                    Util.T0(e2);
                } else if (PlayerNotificationManager.R.equals(action)) {
                    if (e2.R1(7)) {
                        e2.f1();
                    }
                } else if (PlayerNotificationManager.U.equals(action)) {
                    if (e2.R1(11)) {
                        e2.v2();
                    }
                } else if (PlayerNotificationManager.T.equals(action)) {
                    if (e2.R1(12)) {
                        e2.s2();
                    }
                } else if (PlayerNotificationManager.S.equals(action)) {
                    if (e2.R1(9)) {
                        e2.q2();
                    }
                } else if (PlayerNotificationManager.V.equals(action)) {
                    if (e2.R1(3)) {
                        e2.stop();
                    }
                    if (e2.R1(20)) {
                        e2.n0();
                    }
                } else if (PlayerNotificationManager.X.equals(action)) {
                    PlayerNotificationManager.this.Q(true);
                } else if (action != null && PlayerNotificationManager.this.f14663f != null && PlayerNotificationManager.this.f14670m.containsKey(action)) {
                    PlayerNotificationManager.this.f14663f.b(e2, action, intent);
                }
            }
        }
    }

    public interface NotificationListener {
        void a(int i2, Notification notification, boolean z);

        void b(int i2, boolean z);
    }

    private class PlayerListener implements Player.Listener {
        private PlayerListener() {
        }

        public /* synthetic */ void D(int i2) {
            L.s(this, i2);
        }

        public /* synthetic */ void E(boolean z) {
            L.k(this, z);
        }

        public /* synthetic */ void F(int i2) {
            L.x(this, i2);
        }

        public /* synthetic */ void H(boolean z) {
            L.i(this, z);
        }

        public void I(Player player, Player.Events events) {
            if (events.b(4, 5, 7, 0, 12, 11, 8, 9, 14)) {
                PlayerNotificationManager.this.r();
            }
        }

        public /* synthetic */ void K(float f2) {
            L.K(this, f2);
        }

        public /* synthetic */ void L(int i2) {
            L.b(this, i2);
        }

        public /* synthetic */ void M(int i2) {
            L.r(this, i2);
        }

        public /* synthetic */ void N(AudioAttributes audioAttributes) {
            L.a(this, audioAttributes);
        }

        public /* synthetic */ void S(Timeline timeline, int i2) {
            L.G(this, timeline, i2);
        }

        public /* synthetic */ void U(boolean z) {
            L.D(this, z);
        }

        public /* synthetic */ void W(int i2, boolean z) {
            L.g(this, i2, z);
        }

        public /* synthetic */ void X(boolean z, int i2) {
            L.v(this, z, i2);
        }

        public /* synthetic */ void Y(long j2) {
            L.B(this, j2);
        }

        public /* synthetic */ void Z(MediaMetadata mediaMetadata) {
            L.n(this, mediaMetadata);
        }

        public /* synthetic */ void a0(MediaMetadata mediaMetadata) {
            L.w(this, mediaMetadata);
        }

        public /* synthetic */ void b0(long j2) {
            L.C(this, j2);
        }

        public /* synthetic */ void c(VideoSize videoSize) {
            L.J(this, videoSize);
        }

        public /* synthetic */ void d0(TrackSelectionParameters trackSelectionParameters) {
            L.H(this, trackSelectionParameters);
        }

        public /* synthetic */ void e(boolean z) {
            L.E(this, z);
        }

        public /* synthetic */ void e0() {
            L.z(this);
        }

        public /* synthetic */ void f0(Tracks tracks) {
            L.I(this, tracks);
        }

        public /* synthetic */ void g0(DeviceInfo deviceInfo) {
            L.f(this, deviceInfo);
        }

        public /* synthetic */ void h0(MediaItem mediaItem, int i2) {
            L.m(this, mediaItem, i2);
        }

        public /* synthetic */ void j0(PlaybackException playbackException) {
            L.u(this, playbackException);
        }

        public /* synthetic */ void k(PlaybackParameters playbackParameters) {
            L.q(this, playbackParameters);
        }

        public /* synthetic */ void k0(long j2) {
            L.l(this, j2);
        }

        public /* synthetic */ void l0(boolean z, int i2) {
            L.p(this, z, i2);
        }

        public /* synthetic */ void p(CueGroup cueGroup) {
            L.d(this, cueGroup);
        }

        public /* synthetic */ void p0(PlaybackException playbackException) {
            L.t(this, playbackException);
        }

        public /* synthetic */ void q(Metadata metadata) {
            L.o(this, metadata);
        }

        public /* synthetic */ void s(List list) {
            L.e(this, list);
        }

        public /* synthetic */ void s0(int i2, int i3) {
            L.F(this, i2, i3);
        }

        public /* synthetic */ void t0(Player.Commands commands) {
            L.c(this, commands);
        }

        public /* synthetic */ void u0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            L.y(this, positionInfo, positionInfo2, i2);
        }

        public /* synthetic */ void x(int i2) {
            L.A(this, i2);
        }

        public /* synthetic */ void y0(boolean z) {
            L.j(this, z);
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {
    }

    protected PlayerNotificationManager(Context context, String str, int i2, MediaDescriptionAdapter mediaDescriptionAdapter, @Nullable NotificationListener notificationListener, @Nullable CustomActionReceiver customActionReceiver, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, @Nullable String str2) {
        CustomActionReceiver customActionReceiver2 = customActionReceiver;
        Context applicationContext = context.getApplicationContext();
        this.f14658a = applicationContext;
        this.f14659b = str;
        this.f14660c = i2;
        this.f14661d = mediaDescriptionAdapter;
        this.f14662e = notificationListener;
        this.f14663f = customActionReceiver2;
        this.K = i3;
        this.O = str2;
        int i11 = a0;
        a0 = i11 + 1;
        this.o = i11;
        this.f14665h = NotificationManagerCompat.q(applicationContext);
        this.f14667j = new PlayerListener();
        this.f14668k = new NotificationBroadcastReceiver();
        this.f14666i = new IntentFilter();
        this.v = true;
        this.w = true;
        this.D = true;
        this.E = true;
        this.z = true;
        this.A = true;
        this.H = true;
        this.N = true;
        this.J = 0;
        this.I = 0;
        this.M = -1;
        this.G = 1;
        this.L = 1;
        Map<String, NotificationCompat.Action> l2 = l(applicationContext, i11, i4, i5, i6, i7, i8, i9, i10);
        this.f14669l = l2;
        for (String addAction : l2.keySet()) {
            this.f14666i.addAction(addAction);
        }
        Map<String, NotificationCompat.Action> a2 = customActionReceiver2 != null ? customActionReceiver2.a(applicationContext, this.o) : Collections.emptyMap();
        this.f14670m = a2;
        for (String addAction2 : a2.keySet()) {
            this.f14666i.addAction(addAction2);
        }
        this.f14671n = j(X, applicationContext, this.o);
        this.f14666i.addAction(X);
    }

    @SuppressLint({"MissingPermission"})
    private void P(Player player, @Nullable Bitmap bitmap) {
        boolean o2 = o(player);
        NotificationCompat.Builder k2 = k(player, this.p, o2, bitmap);
        this.p = k2;
        boolean z2 = false;
        if (k2 == null) {
            Q(false);
            return;
        }
        Notification h2 = k2.h();
        this.f14665h.F(this.f14660c, h2);
        if (!this.s) {
            Util.X1(this.f14658a, this.f14668k, this.f14666i);
        }
        NotificationListener notificationListener = this.f14662e;
        if (notificationListener != null) {
            int i2 = this.f14660c;
            if (o2 || !this.s) {
                z2 = true;
            }
            notificationListener.a(i2, h2, z2);
        }
        this.s = true;
    }

    /* access modifiers changed from: private */
    public void Q(boolean z2) {
        if (this.s) {
            this.s = false;
            this.f14664g.removeMessages(0);
            this.f14665h.c(this.f14660c);
            this.f14658a.unregisterReceiver(this.f14668k);
            NotificationListener notificationListener = this.f14662e;
            if (notificationListener != null) {
                notificationListener.b(this.f14660c, z2);
            }
        }
    }

    private static PendingIntent j(String str, Context context, int i2) {
        Intent intent = new Intent(str).setPackage(context.getPackageName());
        intent.putExtra(W, i2);
        return PendingIntent.getBroadcast(context, i2, intent, Util.f9646a >= 23 ? 201326592 : C.S0);
    }

    private static Map<String, NotificationCompat.Action> l(Context context, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        HashMap hashMap = new HashMap();
        hashMap.put(P, new NotificationCompat.Action(i3, (CharSequence) context.getString(R.string.f14792l), j(P, context, i2)));
        hashMap.put(Q, new NotificationCompat.Action(i4, (CharSequence) context.getString(R.string.f14791k), j(Q, context, i2)));
        hashMap.put(V, new NotificationCompat.Action(i5, (CharSequence) context.getString(R.string.x), j(V, context, i2)));
        hashMap.put(U, new NotificationCompat.Action(i6, (CharSequence) context.getString(R.string.r), j(U, context, i2)));
        hashMap.put(T, new NotificationCompat.Action(i7, (CharSequence) context.getString(R.string.f14784d), j(T, context, i2)));
        hashMap.put(R, new NotificationCompat.Action(i8, (CharSequence) context.getString(R.string.f14794n), j(R, context, i2)));
        hashMap.put(S, new NotificationCompat.Action(i9, (CharSequence) context.getString(R.string.f14788h), j(S, context, i2)));
        return hashMap;
    }

    /* access modifiers changed from: private */
    public boolean p(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            Player player = this.r;
            if (player != null) {
                P(player, (Bitmap) null);
            }
        } else if (i2 != 1) {
            return false;
        } else {
            Player player2 = this.r;
            if (player2 != null && this.s && this.t == message.arg1) {
                P(player2, (Bitmap) message.obj);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void r() {
        if (!this.f14664g.hasMessages(0)) {
            this.f14664g.sendEmptyMessage(0);
        }
    }

    /* access modifiers changed from: private */
    public void s(Bitmap bitmap, int i2) {
        this.f14664g.obtainMessage(1, i2, -1, bitmap).sendToTarget();
    }

    private static void x(NotificationCompat.Builder builder, @Nullable Bitmap bitmap) {
        builder.b0(bitmap);
    }

    public final void A(int i2) {
        if (this.M != i2) {
            if (i2 == -2 || i2 == -1 || i2 == 0 || i2 == 1 || i2 == 2) {
                this.M = i2;
                q();
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public void B(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
            q();
        }
    }

    public final void C(@DrawableRes int i2) {
        if (this.K != i2) {
            this.K = i2;
            q();
        }
    }

    public final void D(boolean z2) {
        if (this.N != z2) {
            this.N = z2;
            q();
        }
    }

    public final void E(boolean z2) {
        if (this.A != z2) {
            this.A = z2;
            q();
        }
    }

    public final void F(boolean z2) {
        if (this.C != z2) {
            this.C = z2;
            if (z2) {
                this.y = false;
            }
            q();
        }
    }

    public final void G(boolean z2) {
        if (this.w != z2) {
            this.w = z2;
            q();
        }
    }

    public final void H(boolean z2) {
        if (this.y != z2) {
            this.y = z2;
            if (z2) {
                this.C = false;
            }
            q();
        }
    }

    public final void I(boolean z2) {
        if (this.D != z2) {
            this.D = z2;
            q();
        }
    }

    public final void J(boolean z2) {
        if (this.v != z2) {
            this.v = z2;
            q();
        }
    }

    public final void K(boolean z2) {
        if (this.x != z2) {
            this.x = z2;
            if (z2) {
                this.B = false;
            }
            q();
        }
    }

    public final void L(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
            q();
        }
    }

    public final void M(boolean z2) {
        if (this.B != z2) {
            this.B = z2;
            if (z2) {
                this.x = false;
            }
            q();
        }
    }

    public final void N(boolean z2) {
        if (this.F != z2) {
            this.F = z2;
            q();
        }
    }

    public final void O(int i2) {
        if (this.L != i2) {
            if (i2 == -1 || i2 == 0 || i2 == 1) {
                this.L = i2;
                q();
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public NotificationCompat.Builder k(Player player, @Nullable NotificationCompat.Builder builder, boolean z2, @Nullable Bitmap bitmap) {
        if (player.i() != 1 || !player.R1(17) || !player.j2().x()) {
            List<String> n2 = n(player);
            ArrayList arrayList = new ArrayList(n2.size());
            for (int i2 = 0; i2 < n2.size(); i2++) {
                String str = n2.get(i2);
                NotificationCompat.Action action = (this.f14669l.containsKey(str) ? this.f14669l : this.f14670m).get(str);
                if (action != null) {
                    arrayList.add(action);
                }
            }
            if (builder == null || !arrayList.equals(this.q)) {
                builder = new NotificationCompat.Builder(this.f14658a, this.f14659b);
                this.q = arrayList;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    builder.b((NotificationCompat.Action) arrayList.get(i3));
                }
            }
            NotificationCompat.MediaStyle mediaStyle = new NotificationCompat.MediaStyle();
            MediaSessionCompat.Token token = this.u;
            if (token != null) {
                mediaStyle.H(token);
            }
            mediaStyle.J(m(n2, player));
            mediaStyle.K(!z2);
            mediaStyle.G(this.f14671n);
            builder.z0(mediaStyle);
            builder.T(this.f14671n);
            builder.D(this.G).i0(z2).I(this.J).J(this.H).t0(this.K).G0(this.L).k0(this.M).S(this.I);
            if (Util.f9646a < 21 || !this.N || !player.R1(16) || !player.J1() || player.c0() || player.e2() || player.r().s != 1.0f) {
                builder.r0(false).E0(false);
            } else {
                builder.H0(System.currentTimeMillis() - player.n1()).r0(true).E0(true);
            }
            builder.O(this.f14661d.e(player));
            builder.N(this.f14661d.c(player));
            builder.A0(this.f14661d.a(player));
            if (bitmap == null) {
                MediaDescriptionAdapter mediaDescriptionAdapter = this.f14661d;
                int i4 = this.t + 1;
                this.t = i4;
                bitmap = mediaDescriptionAdapter.b(player, new BitmapCallback(i4));
            }
            x(builder, bitmap);
            builder.M(this.f14661d.d(player));
            String str2 = this.O;
            if (str2 != null) {
                builder.Y(str2);
            }
            builder.j0(true);
            return builder;
        }
        this.q = null;
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int[] m(java.util.List<java.lang.String> r7, androidx.media3.common.Player r8) {
        /*
            r6 = this;
            java.lang.String r0 = "androidx.media3.ui.notification.pause"
            int r0 = r7.indexOf(r0)
            java.lang.String r1 = "androidx.media3.ui.notification.play"
            int r1 = r7.indexOf(r1)
            boolean r2 = r6.x
            r3 = -1
            if (r2 == 0) goto L_0x0018
            java.lang.String r2 = "androidx.media3.ui.notification.prev"
        L_0x0013:
            int r2 = r7.indexOf(r2)
            goto L_0x0020
        L_0x0018:
            boolean r2 = r6.B
            if (r2 == 0) goto L_0x001f
            java.lang.String r2 = "androidx.media3.ui.notification.rewind"
            goto L_0x0013
        L_0x001f:
            r2 = -1
        L_0x0020:
            boolean r4 = r6.y
            if (r4 == 0) goto L_0x002b
            java.lang.String r4 = "androidx.media3.ui.notification.next"
        L_0x0026:
            int r7 = r7.indexOf(r4)
            goto L_0x0033
        L_0x002b:
            boolean r4 = r6.C
            if (r4 == 0) goto L_0x0032
            java.lang.String r4 = "androidx.media3.ui.notification.ffwd"
            goto L_0x0026
        L_0x0032:
            r7 = -1
        L_0x0033:
            r4 = 3
            int[] r4 = new int[r4]
            r5 = 0
            if (r2 == r3) goto L_0x003c
            r4[r5] = r2
            r5 = 1
        L_0x003c:
            boolean r2 = r6.E
            boolean r8 = androidx.media3.common.util.Util.m2(r8, r2)
            if (r0 == r3) goto L_0x004c
            if (r8 != 0) goto L_0x004c
            int r8 = r5 + 1
            r4[r5] = r0
        L_0x004a:
            r5 = r8
            goto L_0x0055
        L_0x004c:
            if (r1 == r3) goto L_0x0055
            if (r8 == 0) goto L_0x0055
            int r8 = r5 + 1
            r4[r5] = r1
            goto L_0x004a
        L_0x0055:
            if (r7 == r3) goto L_0x005c
            int r8 = r5 + 1
            r4[r5] = r7
            r5 = r8
        L_0x005c:
            int[] r7 = java.util.Arrays.copyOf(r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerNotificationManager.m(java.util.List, androidx.media3.common.Player):int[]");
    }

    /* access modifiers changed from: protected */
    public List<String> n(Player player) {
        boolean R1 = player.R1(7);
        boolean R12 = player.R1(11);
        boolean R13 = player.R1(12);
        boolean R14 = player.R1(9);
        ArrayList arrayList = new ArrayList();
        if (this.v && R1) {
            arrayList.add(R);
        }
        if (this.z && R12) {
            arrayList.add(U);
        }
        if (this.D) {
            arrayList.add(Util.m2(player, this.E) ? P : Q);
        }
        if (this.A && R13) {
            arrayList.add(T);
        }
        if (this.w && R14) {
            arrayList.add(S);
        }
        CustomActionReceiver customActionReceiver = this.f14663f;
        if (customActionReceiver != null) {
            arrayList.addAll(customActionReceiver.c(player));
        }
        if (this.F) {
            arrayList.add(V);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public boolean o(Player player) {
        int i2 = player.i();
        return (i2 == 2 || i2 == 3) && player.m0();
    }

    public final void q() {
        if (this.s) {
            r();
        }
    }

    public final void t(int i2) {
        if (this.G != i2) {
            if (i2 == 0 || i2 == 1 || i2 == 2) {
                this.G = i2;
                q();
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public final void u(int i2) {
        if (this.J != i2) {
            this.J = i2;
            q();
        }
    }

    public final void v(boolean z2) {
        if (this.H != z2) {
            this.H = z2;
            q();
        }
    }

    public final void w(int i2) {
        if (this.I != i2) {
            this.I = i2;
            q();
        }
    }

    public final void y(MediaSessionCompat.Token token) {
        if (!Util.g(this.u, token)) {
            this.u = token;
            q();
        }
    }

    public final void z(@Nullable Player player) {
        boolean z2 = true;
        Assertions.i(Looper.myLooper() == Looper.getMainLooper());
        if (!(player == null || player.k2() == Looper.getMainLooper())) {
            z2 = false;
        }
        Assertions.a(z2);
        Player player2 = this.r;
        if (player2 != player) {
            if (player2 != null) {
                player2.N1(this.f14667j);
                if (player == null) {
                    Q(false);
                }
            }
            this.r = player;
            if (player != null) {
                player.f2(this.f14667j);
                r();
            }
        }
    }
}
