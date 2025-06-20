package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5488a;

    /* renamed from: b  reason: collision with root package name */
    private final Notification.Builder f5489b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationCompat.Builder f5490c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f5491d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f5492e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Bundle> f5493f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f5494g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    private int f5495h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteViews f5496i;

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        @DoNotInline
        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        @DoNotInline
        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        @DoNotInline
        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static Notification.Action.Builder e(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i2, charSequence, pendingIntent);
        }

        @DoNotInline
        static String f(Notification notification) {
            return notification.getGroup();
        }

        @DoNotInline
        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        @DoNotInline
        static Notification.Builder h(Notification.Builder builder, boolean z) {
            return builder.setGroupSummary(z);
        }

        @DoNotInline
        static Notification.Builder i(Notification.Builder builder, boolean z) {
            return builder.setLocalOnly(z);
        }

        @DoNotInline
        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        @DoNotInline
        static Notification.Builder c(Notification.Builder builder, int i2) {
            return builder.setColor(i2);
        }

        @DoNotInline
        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        @DoNotInline
        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        @DoNotInline
        static Notification.Builder f(Notification.Builder builder, int i2) {
            return builder.setVisibility(i2);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        @DoNotInline
        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
            return builder.setAllowGeneratedReplies(z);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, int i2) {
            return builder.setBadgeIconType(i2);
        }

        @DoNotInline
        static Notification.Builder c(Notification.Builder builder, boolean z) {
            return builder.setColorized(z);
        }

        @DoNotInline
        static Notification.Builder d(Notification.Builder builder, int i2) {
            return builder.setGroupAlertBehavior(i2);
        }

        @DoNotInline
        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        @DoNotInline
        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        @DoNotInline
        static Notification.Builder g(Notification.Builder builder, long j2) {
            return builder.setTimeoutAfter(j2);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        @DoNotInline
        static Notification.Action.Builder b(Notification.Action.Builder builder, int i2) {
            return builder.setSemanticAction(i2);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static Notification.Builder a(Notification.Builder builder, boolean z) {
            return builder.setAllowSystemGeneratedContextualActions(z);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        @DoNotInline
        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z) {
            return builder.setContextual(z);
        }

        @DoNotInline
        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
            return builder.setAuthenticationRequired(z);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, int i2) {
            return builder.setForegroundServiceBehavior(i2);
        }
    }

    NotificationCompatBuilder(NotificationCompat.Builder builder) {
        int i2;
        Object obj;
        NotificationCompat.Builder builder2 = builder;
        this.f5490c = builder2;
        Context context = builder2.f5382a;
        this.f5488a = context;
        int i3 = Build.VERSION.SDK_INT;
        this.f5489b = i3 >= 26 ? Api26Impl.a(context, builder2.L) : new Notification.Builder(builder2.f5382a);
        Notification notification = builder2.U;
        this.f5489b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder2.f5390i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder2.f5386e).setContentText(builder2.f5387f).setContentInfo(builder2.f5392k).setContentIntent(builder2.f5388g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder2.f5389h, (notification.flags & 128) != 0).setNumber(builder2.f5393l).setProgress(builder2.u, builder2.v, builder2.w);
        if (i3 < 23) {
            Notification.Builder builder3 = this.f5489b;
            IconCompat iconCompat = builder2.f5391j;
            builder3.setLargeIcon(iconCompat == null ? null : iconCompat.y());
        } else {
            Notification.Builder builder4 = this.f5489b;
            IconCompat iconCompat2 = builder2.f5391j;
            Api23Impl.b(builder4, iconCompat2 == null ? null : iconCompat2.M(context));
        }
        this.f5489b.setSubText(builder2.r).setUsesChronometer(builder2.o).setPriority(builder2.f5394m);
        NotificationCompat.Style style = builder2.q;
        if (style instanceof NotificationCompat.CallStyle) {
            for (NotificationCompat.Action b2 : ((NotificationCompat.CallStyle) style).D()) {
                b(b2);
            }
        } else {
            Iterator<NotificationCompat.Action> it2 = builder2.f5383b.iterator();
            while (it2.hasNext()) {
                b(it2.next());
            }
        }
        Bundle bundle = builder2.E;
        if (bundle != null) {
            this.f5494g.putAll(bundle);
        }
        int i4 = Build.VERSION.SDK_INT;
        this.f5491d = builder2.I;
        this.f5492e = builder2.J;
        this.f5489b.setShowWhen(builder2.f5395n);
        Api20Impl.i(this.f5489b, builder2.A);
        Api20Impl.g(this.f5489b, builder2.x);
        Api20Impl.j(this.f5489b, builder2.z);
        Api20Impl.h(this.f5489b, builder2.y);
        this.f5495h = builder2.Q;
        Api21Impl.b(this.f5489b, builder2.D);
        Api21Impl.c(this.f5489b, builder2.F);
        Api21Impl.f(this.f5489b, builder2.G);
        Api21Impl.d(this.f5489b, builder2.H);
        Api21Impl.e(this.f5489b, notification.sound, notification.audioAttributes);
        List<String> e2 = i4 < 28 ? e(g(builder2.f5384c), builder2.X) : builder2.X;
        if (e2 != null && !e2.isEmpty()) {
            for (String a2 : e2) {
                Api21Impl.a(this.f5489b, a2);
            }
        }
        this.f5496i = builder2.K;
        if (builder2.f5385d.size() > 0) {
            Bundle bundle2 = builder.t().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i5 = 0; i5 < builder2.f5385d.size(); i5++) {
                bundle4.putBundle(Integer.toString(i5), NotificationCompatJellybean.j(builder2.f5385d.get(i5)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.t().putBundle("android.car.EXTENSIONS", bundle2);
            this.f5494g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23 && (obj = builder2.W) != null) {
            Api23Impl.c(this.f5489b, obj);
        }
        if (i6 >= 24) {
            this.f5489b.setExtras(builder2.E);
            Api24Impl.e(this.f5489b, builder2.t);
            RemoteViews remoteViews = builder2.I;
            if (remoteViews != null) {
                Api24Impl.c(this.f5489b, remoteViews);
            }
            RemoteViews remoteViews2 = builder2.J;
            if (remoteViews2 != null) {
                Api24Impl.b(this.f5489b, remoteViews2);
            }
            RemoteViews remoteViews3 = builder2.K;
            if (remoteViews3 != null) {
                Api24Impl.d(this.f5489b, remoteViews3);
            }
        }
        if (i6 >= 26) {
            Api26Impl.b(this.f5489b, builder2.M);
            Api26Impl.e(this.f5489b, builder2.s);
            Api26Impl.f(this.f5489b, builder2.N);
            Api26Impl.g(this.f5489b, builder2.P);
            Api26Impl.d(this.f5489b, builder2.Q);
            if (builder2.C) {
                Api26Impl.c(this.f5489b, builder2.B);
            }
            if (!TextUtils.isEmpty(builder2.L)) {
                this.f5489b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i6 >= 28) {
            Iterator<Person> it3 = builder2.f5384c.iterator();
            while (it3.hasNext()) {
                Api28Impl.a(this.f5489b, it3.next().k());
            }
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 29) {
            Api29Impl.a(this.f5489b, builder2.S);
            Api29Impl.b(this.f5489b, NotificationCompat.BubbleMetadata.k(builder2.T));
            LocusIdCompat locusIdCompat = builder2.O;
            if (locusIdCompat != null) {
                Api29Impl.d(this.f5489b, locusIdCompat.c());
            }
        }
        if (i7 >= 31 && (i2 = builder2.R) != 0) {
            Api31Impl.b(this.f5489b, i2);
        }
        if (builder2.V) {
            if (this.f5490c.y) {
                this.f5495h = 2;
            } else {
                this.f5495h = 1;
            }
            this.f5489b.setVibrate((long[]) null);
            this.f5489b.setSound((Uri) null);
            int i8 = notification.defaults & -4;
            notification.defaults = i8;
            this.f5489b.setDefaults(i8);
            if (i7 >= 26) {
                if (TextUtils.isEmpty(this.f5490c.x)) {
                    Api20Impl.g(this.f5489b, NotificationCompat.e1);
                }
                Api26Impl.d(this.f5489b, this.f5495h);
            }
        }
    }

    private void b(NotificationCompat.Action action) {
        Notification.Action.Builder builder;
        int i2 = Build.VERSION.SDK_INT;
        IconCompat f2 = action.f();
        if (i2 >= 23) {
            builder = Api23Impl.a(f2 != null ? f2.L() : null, action.j(), action.a());
        } else {
            builder = Api20Impl.e(f2 != null ? f2.z() : 0, action.j(), action.a());
        }
        if (action.g() != null) {
            for (RemoteInput c2 : RemoteInput.d(action.g())) {
                Api20Impl.c(builder, c2);
            }
        }
        Bundle bundle = action.d() != null ? new Bundle(action.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            Api24Impl.a(builder, action.b());
        }
        bundle.putInt("android.support.action.semanticAction", action.h());
        if (i3 >= 28) {
            Api28Impl.b(builder, action.h());
        }
        if (i3 >= 29) {
            Api29Impl.c(builder, action.l());
        }
        if (i3 >= 31) {
            Api31Impl.a(builder, action.k());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.i());
        Api20Impl.b(builder, bundle);
        Api20Impl.a(this.f5489b, Api20Impl.d(builder));
    }

    @Nullable
    private static List<String> e(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    @Nullable
    private static List<String> g(@Nullable List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Person j2 : list) {
            arrayList.add(j2.j());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    public Notification.Builder a() {
        return this.f5489b;
    }

    public Notification c() {
        Bundle n2;
        RemoteViews x;
        RemoteViews v;
        NotificationCompat.Style style = this.f5490c.q;
        if (style != null) {
            style.b(this);
        }
        RemoteViews w = style != null ? style.w(this) : null;
        Notification d2 = d();
        if (!(w == null && (w = this.f5490c.I) == null)) {
            d2.contentView = w;
        }
        if (!(style == null || (v = style.v(this)) == null)) {
            d2.bigContentView = v;
        }
        if (!(style == null || (x = this.f5490c.q.x(this)) == null)) {
            d2.headsUpContentView = x;
        }
        if (!(style == null || (n2 = NotificationCompat.n(d2)) == null)) {
            style.a(n2);
        }
        return d2;
    }

    /* access modifiers changed from: protected */
    public Notification d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f5489b.build();
        }
        if (i2 >= 24) {
            Notification build = this.f5489b.build();
            if (this.f5495h != 0) {
                if (!(Api20Impl.f(build) == null || (build.flags & 512) == 0 || this.f5495h != 2)) {
                    h(build);
                }
                if (Api20Impl.f(build) != null && (build.flags & 512) == 0 && this.f5495h == 1) {
                    h(build);
                }
            }
            return build;
        }
        this.f5489b.setExtras(this.f5494g);
        Notification build2 = this.f5489b.build();
        RemoteViews remoteViews = this.f5491d;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f5492e;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f5496i;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.f5495h != 0) {
            if (!(Api20Impl.f(build2) == null || (build2.flags & 512) == 0 || this.f5495h != 2)) {
                h(build2);
            }
            if (Api20Impl.f(build2) != null && (build2.flags & 512) == 0 && this.f5495h == 1) {
                h(build2);
            }
        }
        return build2;
    }

    /* access modifiers changed from: package-private */
    public Context f() {
        return this.f5488a;
    }
}
