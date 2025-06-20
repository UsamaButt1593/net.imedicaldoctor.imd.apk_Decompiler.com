package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class NotificationCompat {
    public static final int A = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int A0 = 3;
    @SuppressLint({"ActionValue"})
    public static final String B = "android.title";
    public static final int B0 = 1;
    @SuppressLint({"ActionValue"})
    public static final String C = "android.title.big";
    public static final int C0 = 0;
    @SuppressLint({"ActionValue"})
    public static final String D = "android.text";
    public static final int D0 = -1;
    @SuppressLint({"ActionValue"})
    public static final String E = "android.subText";
    public static final String E0 = "call";
    @SuppressLint({"ActionValue"})
    public static final String F = "android.remoteInputHistory";
    public static final String F0 = "navigation";
    @SuppressLint({"ActionValue"})
    public static final String G = "android.infoText";
    public static final String G0 = "msg";
    @SuppressLint({"ActionValue"})
    public static final String H = "android.summaryText";
    public static final String H0 = "email";
    @SuppressLint({"ActionValue"})
    public static final String I = "android.bigText";
    public static final String I0 = "event";
    @SuppressLint({"ActionValue"})
    public static final String J = "android.icon";
    public static final String J0 = "promo";
    @SuppressLint({"ActionValue"})
    public static final String K = "android.largeIcon";
    public static final String K0 = "alarm";
    @SuppressLint({"ActionValue"})
    public static final String L = "android.largeIcon.big";
    public static final String L0 = "progress";
    @SuppressLint({"ActionValue"})
    public static final String M = "android.progress";
    public static final String M0 = "social";
    @SuppressLint({"ActionValue"})
    public static final String N = "android.progressMax";
    public static final String N0 = "err";
    @SuppressLint({"ActionValue"})
    public static final String O = "android.progressIndeterminate";
    public static final String O0 = "transport";
    @SuppressLint({"ActionValue"})
    public static final String P = "android.showChronometer";
    public static final String P0 = "sys";
    @SuppressLint({"ActionValue"})
    public static final String Q = "android.chronometerCountDown";
    public static final String Q0 = "service";
    @SuppressLint({"ActionValue"})
    public static final String R = "android.colorized";
    public static final String R0 = "reminder";
    @SuppressLint({"ActionValue"})
    public static final String S = "android.showWhen";
    public static final String S0 = "recommendation";
    @SuppressLint({"ActionValue"})
    public static final String T = "android.picture";
    public static final String T0 = "status";
    @SuppressLint({"ActionValue"})
    public static final String U = "android.pictureIcon";
    public static final String U0 = "workout";
    @SuppressLint({"ActionValue"})
    public static final String V = "android.pictureContentDescription";
    public static final String V0 = "location_sharing";
    @SuppressLint({"ActionValue"})
    public static final String W = "android.showBigPictureWhenCollapsed";
    public static final String W0 = "stopwatch";
    @SuppressLint({"ActionValue"})
    public static final String X = "android.textLines";
    public static final String X0 = "missed_call";
    @SuppressLint({"ActionValue"})
    public static final String Y = "android.template";
    public static final int Y0 = 0;
    public static final String Z = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final int Z0 = 1;

    /* renamed from: a  reason: collision with root package name */
    private static final String f5307a = "NotifCompat";
    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String a0 = "android.people";
    public static final int a1 = 2;
    @SuppressLint({"ActionValue"})

    /* renamed from: b  reason: collision with root package name */
    public static final String f5308b = "android.intent.category.NOTIFICATION_PREFERENCES";
    @SuppressLint({"ActionValue"})
    public static final String b0 = "android.people.list";
    public static final int b1 = 0;
    @SuppressLint({"ActionValue"})

    /* renamed from: c  reason: collision with root package name */
    public static final String f5309c = "android.intent.extra.CHANNEL_ID";
    @SuppressLint({"ActionValue"})
    public static final String c0 = "android.backgroundImageUri";
    public static final int c1 = 1;
    @SuppressLint({"ActionValue"})

    /* renamed from: d  reason: collision with root package name */
    public static final String f5310d = "android.intent.extra.CHANNEL_GROUP_ID";
    @SuppressLint({"ActionValue"})
    public static final String d0 = "android.mediaSession";
    public static final int d1 = 2;
    @SuppressLint({"ActionValue"})

    /* renamed from: e  reason: collision with root package name */
    public static final String f5311e = "android.intent.extra.NOTIFICATION_TAG";
    @SuppressLint({"ActionValue"})
    public static final String e0 = "android.compactActions";
    public static final String e1 = "silent";
    @SuppressLint({"ActionValue"})

    /* renamed from: f  reason: collision with root package name */
    public static final String f5312f = "android.intent.extra.NOTIFICATION_ID";
    @SuppressLint({"ActionValue"})
    public static final String f0 = "android.selfDisplayName";
    public static final int f1 = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5313g = -1;
    @SuppressLint({"ActionValue"})
    public static final String g0 = "android.messagingStyleUser";
    public static final int g1 = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5314h = 1;
    @SuppressLint({"ActionValue"})
    public static final String h0 = "android.conversationTitle";
    public static final int h1 = 2;

    /* renamed from: i  reason: collision with root package name */
    public static final int f5315i = 2;
    @SuppressLint({"ActionValue"})
    public static final String i0 = "android.messages";

    /* renamed from: j  reason: collision with root package name */
    public static final int f5316j = 4;
    @SuppressLint({"ActionValue"})
    public static final String j0 = "android.messages.historic";

    /* renamed from: k  reason: collision with root package name */
    public static final int f5317k = -1;
    @SuppressLint({"ActionValue"})
    public static final String k0 = "android.isGroupConversation";

    /* renamed from: l  reason: collision with root package name */
    public static final int f5318l = 1;
    @SuppressLint({"ActionValue"})
    public static final String l0 = "android.callType";

    /* renamed from: m  reason: collision with root package name */
    public static final int f5319m = 2;
    @SuppressLint({"ActionValue"})
    public static final String m0 = "android.callIsVideo";

    /* renamed from: n  reason: collision with root package name */
    public static final int f5320n = 4;
    @SuppressLint({"ActionValue"})
    public static final String n0 = "android.callPerson";
    public static final int o = 8;
    @SuppressLint({"ActionValue"})
    public static final String o0 = "android.callPersonCompat";
    public static final int p = 16;
    @SuppressLint({"ActionValue"})
    public static final String p0 = "android.verificationIcon";
    public static final int q = 32;
    @SuppressLint({"ActionValue"})
    public static final String q0 = "android.verificationIconCompat";
    public static final int r = 64;
    @SuppressLint({"ActionValue"})
    public static final String r0 = "android.verificationText";
    @Deprecated
    public static final int s = 128;
    @SuppressLint({"ActionValue"})
    public static final String s0 = "android.answerIntent";
    public static final int t = 256;
    @SuppressLint({"ActionValue"})
    public static final String t0 = "android.declineIntent";
    public static final int u = 512;
    @SuppressLint({"ActionValue"})
    public static final String u0 = "android.hangUpIntent";
    public static final int v = 4096;
    @SuppressLint({"ActionValue"})
    public static final String v0 = "android.answerColor";
    public static final int w = 0;
    @SuppressLint({"ActionValue"})
    public static final String w0 = "android.declineColor";
    public static final int x = -1;
    @SuppressLint({"ActionValue"})
    public static final String x0 = "android.hiddenConversationTitle";
    public static final int y = -2;
    @SuppressLint({"ActionValue"})
    public static final String y0 = "android.audioContents";
    public static final int z = 1;
    @ColorInt
    public static final int z0 = 0;

    public static class Action {

        /* renamed from: m  reason: collision with root package name */
        public static final int f5321m = 0;

        /* renamed from: n  reason: collision with root package name */
        public static final int f5322n = 1;
        public static final int o = 2;
        public static final int p = 3;
        public static final int q = 4;
        public static final int r = 5;
        public static final int s = 6;
        public static final int t = 7;
        public static final int u = 8;
        public static final int v = 9;
        public static final int w = 10;
        static final String x = "android.support.action.showsUserInterface";
        static final String y = "android.support.action.semanticAction";

        /* renamed from: a  reason: collision with root package name */
        final Bundle f5323a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f5324b;

        /* renamed from: c  reason: collision with root package name */
        private final RemoteInput[] f5325c;

        /* renamed from: d  reason: collision with root package name */
        private final RemoteInput[] f5326d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5327e;

        /* renamed from: f  reason: collision with root package name */
        boolean f5328f;

        /* renamed from: g  reason: collision with root package name */
        private final int f5329g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f5330h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f5331i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f5332j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f5333k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f5334l;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private final IconCompat f5335a;

            /* renamed from: b  reason: collision with root package name */
            private final CharSequence f5336b;

            /* renamed from: c  reason: collision with root package name */
            private final PendingIntent f5337c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f5338d;

            /* renamed from: e  reason: collision with root package name */
            private final Bundle f5339e;

            /* renamed from: f  reason: collision with root package name */
            private ArrayList<RemoteInput> f5340f;

            /* renamed from: g  reason: collision with root package name */
            private int f5341g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f5342h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f5343i;

            /* renamed from: j  reason: collision with root package name */
            private boolean f5344j;

            @RequiresApi(20)
            static class Api20Impl {
                private Api20Impl() {
                }

                @DoNotInline
                static Bundle a(Notification.Action action) {
                    return action.getExtras();
                }

                @DoNotInline
                static RemoteInput[] b(Notification.Action action) {
                    return action.getRemoteInputs();
                }
            }

            @RequiresApi(23)
            static class Api23Impl {
                private Api23Impl() {
                }

                @DoNotInline
                static Icon a(Notification.Action action) {
                    return action.getIcon();
                }
            }

            @RequiresApi(24)
            static class Api24Impl {
                private Api24Impl() {
                }

                @DoNotInline
                static boolean a(Notification.Action action) {
                    return action.getAllowGeneratedReplies();
                }
            }

            @RequiresApi(28)
            static class Api28Impl {
                private Api28Impl() {
                }

                @DoNotInline
                static int a(Notification.Action action) {
                    return action.getSemanticAction();
                }
            }

            @RequiresApi(29)
            static class Api29Impl {
                private Api29Impl() {
                }

                @DoNotInline
                static boolean a(Notification.Action action) {
                    return action.isContextual();
                }
            }

            @RequiresApi(31)
            static class Api31Impl {
                private Api31Impl() {
                }

                @DoNotInline
                static boolean a(Notification.Action action) {
                    return action.isAuthenticationRequired();
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public Builder(int i2, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(i2 != 0 ? IconCompat.x((Resources) null, "", i2) : null, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, true, 0, true, false, false);
            }

            private void d() {
                if (this.f5343i && this.f5337c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            @NonNull
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            public static Builder f(@NonNull Notification.Action action) {
                Builder builder = (Build.VERSION.SDK_INT < 23 || Api23Impl.a(action) == null) ? new Builder(action.icon, action.title, action.actionIntent) : new Builder(IconCompat.n(Api23Impl.a(action)), action.title, action.actionIntent);
                RemoteInput[] b2 = Api20Impl.b(action);
                if (!(b2 == null || b2.length == 0)) {
                    for (RemoteInput e2 : b2) {
                        builder.b(RemoteInput.e(e2));
                    }
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 24) {
                    builder.f5338d = Api24Impl.a(action);
                }
                if (i2 >= 28) {
                    builder.k(Api28Impl.a(action));
                }
                if (i2 >= 29) {
                    builder.j(Api29Impl.a(action));
                }
                if (i2 >= 31) {
                    builder.i(Api31Impl.a(action));
                }
                builder.a(Api20Impl.a(action));
                return builder;
            }

            @NonNull
            public Builder a(@Nullable Bundle bundle) {
                if (bundle != null) {
                    this.f5339e.putAll(bundle);
                }
                return this;
            }

            @NonNull
            public Builder b(@Nullable RemoteInput remoteInput) {
                if (this.f5340f == null) {
                    this.f5340f = new ArrayList<>();
                }
                if (remoteInput != null) {
                    this.f5340f.add(remoteInput);
                }
                return this;
            }

            /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Object[]] */
            /* JADX WARNING: Multi-variable type inference failed */
            @androidx.annotation.NonNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public androidx.core.app.NotificationCompat.Action c() {
                /*
                    r17 = this;
                    r0 = r17
                    r17.d()
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.ArrayList<androidx.core.app.RemoteInput> r3 = r0.f5340f
                    if (r3 == 0) goto L_0x0031
                    java.util.Iterator r3 = r3.iterator()
                L_0x0017:
                    boolean r4 = r3.hasNext()
                    if (r4 == 0) goto L_0x0031
                    java.lang.Object r4 = r3.next()
                    androidx.core.app.RemoteInput r4 = (androidx.core.app.RemoteInput) r4
                    boolean r5 = r4.r()
                    if (r5 == 0) goto L_0x002d
                    r1.add(r4)
                    goto L_0x0017
                L_0x002d:
                    r2.add(r4)
                    goto L_0x0017
                L_0x0031:
                    boolean r3 = r1.isEmpty()
                    r4 = 0
                    if (r3 == 0) goto L_0x003a
                    r11 = r4
                    goto L_0x0047
                L_0x003a:
                    int r3 = r1.size()
                    androidx.core.app.RemoteInput[] r3 = new androidx.core.app.RemoteInput[r3]
                    java.lang.Object[] r1 = r1.toArray(r3)
                    androidx.core.app.RemoteInput[] r1 = (androidx.core.app.RemoteInput[]) r1
                    r11 = r1
                L_0x0047:
                    boolean r1 = r2.isEmpty()
                    if (r1 == 0) goto L_0x004f
                L_0x004d:
                    r10 = r4
                    goto L_0x005d
                L_0x004f:
                    int r1 = r2.size()
                    androidx.core.app.RemoteInput[] r1 = new androidx.core.app.RemoteInput[r1]
                    java.lang.Object[] r1 = r2.toArray(r1)
                    r4 = r1
                    androidx.core.app.RemoteInput[] r4 = (androidx.core.app.RemoteInput[]) r4
                    goto L_0x004d
                L_0x005d:
                    androidx.core.app.NotificationCompat$Action r1 = new androidx.core.app.NotificationCompat$Action
                    androidx.core.graphics.drawable.IconCompat r6 = r0.f5335a
                    java.lang.CharSequence r7 = r0.f5336b
                    android.app.PendingIntent r8 = r0.f5337c
                    android.os.Bundle r9 = r0.f5339e
                    boolean r12 = r0.f5338d
                    int r13 = r0.f5341g
                    boolean r14 = r0.f5342h
                    boolean r15 = r0.f5343i
                    boolean r2 = r0.f5344j
                    r5 = r1
                    r16 = r2
                    r5.<init>((androidx.core.graphics.drawable.IconCompat) r6, (java.lang.CharSequence) r7, (android.app.PendingIntent) r8, (android.os.Bundle) r9, (androidx.core.app.RemoteInput[]) r10, (androidx.core.app.RemoteInput[]) r11, (boolean) r12, (int) r13, (boolean) r14, (boolean) r15, (boolean) r16)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Action.Builder.c():androidx.core.app.NotificationCompat$Action");
            }

            @NonNull
            public Builder e(@NonNull Extender extender) {
                extender.a(this);
                return this;
            }

            @NonNull
            public Bundle g() {
                return this.f5339e;
            }

            @NonNull
            public Builder h(boolean z) {
                this.f5338d = z;
                return this;
            }

            @NonNull
            public Builder i(boolean z) {
                this.f5344j = z;
                return this;
            }

            @NonNull
            public Builder j(boolean z) {
                this.f5343i = z;
                return this;
            }

            @NonNull
            public Builder k(int i2) {
                this.f5341g = i2;
                return this;
            }

            @NonNull
            public Builder l(boolean z) {
                this.f5342h = z;
                return this;
            }

            public Builder(@NonNull Action action) {
                this(action.f(), action.f5332j, action.f5333k, new Bundle(action.f5323a), action.g(), action.b(), action.h(), action.f5328f, action.l(), action.k());
            }

            public Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, true, 0, true, false, false);
            }

            private Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @NonNull Bundle bundle, @Nullable RemoteInput[] remoteInputArr, boolean z, int i2, boolean z2, boolean z3, boolean z4) {
                this.f5338d = true;
                this.f5342h = true;
                this.f5335a = iconCompat;
                this.f5336b = Builder.A(charSequence);
                this.f5337c = pendingIntent;
                this.f5339e = bundle;
                this.f5340f = remoteInputArr == null ? null : new ArrayList<>(Arrays.asList(remoteInputArr));
                this.f5338d = z;
                this.f5341g = i2;
                this.f5342h = z2;
                this.f5343i = z3;
                this.f5344j = z4;
            }
        }

        public interface Extender {
            @NonNull
            Builder a(@NonNull Builder builder);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {

            /* renamed from: e  reason: collision with root package name */
            private static final String f5345e = "android.wearable.EXTENSIONS";

            /* renamed from: f  reason: collision with root package name */
            private static final String f5346f = "flags";

            /* renamed from: g  reason: collision with root package name */
            private static final String f5347g = "inProgressLabel";

            /* renamed from: h  reason: collision with root package name */
            private static final String f5348h = "confirmLabel";

            /* renamed from: i  reason: collision with root package name */
            private static final String f5349i = "cancelLabel";

            /* renamed from: j  reason: collision with root package name */
            private static final int f5350j = 1;

            /* renamed from: k  reason: collision with root package name */
            private static final int f5351k = 2;

            /* renamed from: l  reason: collision with root package name */
            private static final int f5352l = 4;

            /* renamed from: m  reason: collision with root package name */
            private static final int f5353m = 1;

            /* renamed from: a  reason: collision with root package name */
            private int f5354a = 1;

            /* renamed from: b  reason: collision with root package name */
            private CharSequence f5355b;

            /* renamed from: c  reason: collision with root package name */
            private CharSequence f5356c;

            /* renamed from: d  reason: collision with root package name */
            private CharSequence f5357d;

            public WearableExtender() {
            }

            private void l(int i2, boolean z) {
                int i3;
                if (z) {
                    i3 = i2 | this.f5354a;
                } else {
                    i3 = (~i2) & this.f5354a;
                }
                this.f5354a = i3;
            }

            @NonNull
            public Builder a(@NonNull Builder builder) {
                Bundle bundle = new Bundle();
                int i2 = this.f5354a;
                if (i2 != 1) {
                    bundle.putInt(f5346f, i2);
                }
                CharSequence charSequence = this.f5355b;
                if (charSequence != null) {
                    bundle.putCharSequence(f5347g, charSequence);
                }
                CharSequence charSequence2 = this.f5356c;
                if (charSequence2 != null) {
                    bundle.putCharSequence(f5348h, charSequence2);
                }
                CharSequence charSequence3 = this.f5357d;
                if (charSequence3 != null) {
                    bundle.putCharSequence(f5349i, charSequence3);
                }
                builder.g().putBundle(f5345e, bundle);
                return builder;
            }

            @NonNull
            /* renamed from: b */
            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f5354a = this.f5354a;
                wearableExtender.f5355b = this.f5355b;
                wearableExtender.f5356c = this.f5356c;
                wearableExtender.f5357d = this.f5357d;
                return wearableExtender;
            }

            @Deprecated
            @Nullable
            public CharSequence c() {
                return this.f5357d;
            }

            @Deprecated
            @Nullable
            public CharSequence d() {
                return this.f5356c;
            }

            public boolean e() {
                return (this.f5354a & 4) != 0;
            }

            public boolean f() {
                return (this.f5354a & 2) != 0;
            }

            @Deprecated
            @Nullable
            public CharSequence g() {
                return this.f5355b;
            }

            public boolean h() {
                return (this.f5354a & 1) != 0;
            }

            @NonNull
            public WearableExtender i(boolean z) {
                l(1, z);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender j(@Nullable CharSequence charSequence) {
                this.f5357d = charSequence;
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender k(@Nullable CharSequence charSequence) {
                this.f5356c = charSequence;
                return this;
            }

            @NonNull
            public WearableExtender m(boolean z) {
                l(4, z);
                return this;
            }

            @NonNull
            public WearableExtender n(boolean z) {
                l(2, z);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender o(@Nullable CharSequence charSequence) {
                this.f5355b = charSequence;
                return this;
            }

            public WearableExtender(@NonNull Action action) {
                Bundle bundle = action.d().getBundle(f5345e);
                if (bundle != null) {
                    this.f5354a = bundle.getInt(f5346f, 1);
                    this.f5355b = bundle.getCharSequence(f5347g);
                    this.f5356c = bundle.getCharSequence(f5348h);
                    this.f5357d = bundle.getCharSequence(f5349i);
                }
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Action(int i2, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.x((Resources) null, "", i2) : null, charSequence, pendingIntent);
        }

        @Nullable
        public PendingIntent a() {
            return this.f5333k;
        }

        public boolean b() {
            return this.f5327e;
        }

        @Nullable
        public RemoteInput[] c() {
            return this.f5326d;
        }

        @NonNull
        public Bundle d() {
            return this.f5323a;
        }

        @Deprecated
        public int e() {
            return this.f5331i;
        }

        @Nullable
        public IconCompat f() {
            int i2;
            if (this.f5324b == null && (i2 = this.f5331i) != 0) {
                this.f5324b = IconCompat.x((Resources) null, "", i2);
            }
            return this.f5324b;
        }

        @Nullable
        public RemoteInput[] g() {
            return this.f5325c;
        }

        public int h() {
            return this.f5329g;
        }

        public boolean i() {
            return this.f5328f;
        }

        @Nullable
        public CharSequence j() {
            return this.f5332j;
        }

        public boolean k() {
            return this.f5334l;
        }

        public boolean l() {
            return this.f5330h;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        Action(int i2, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable RemoteInput[] remoteInputArr, @Nullable RemoteInput[] remoteInputArr2, boolean z, int i3, boolean z2, boolean z3, boolean z4) {
            this(i2 != 0 ? IconCompat.x((Resources) null, "", i2) : null, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, i3, z2, z3, z4);
        }

        public Action(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false, false);
        }

        Action(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable RemoteInput[] remoteInputArr, @Nullable RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2, boolean z3, boolean z4) {
            this.f5328f = true;
            this.f5324b = iconCompat;
            if (iconCompat != null && iconCompat.C() == 2) {
                this.f5331i = iconCompat.z();
            }
            this.f5332j = Builder.A(charSequence);
            this.f5333k = pendingIntent;
            this.f5323a = bundle == null ? new Bundle() : bundle;
            this.f5325c = remoteInputArr;
            this.f5326d = remoteInputArr2;
            this.f5327e = z;
            this.f5329g = i2;
            this.f5328f = z2;
            this.f5330h = z3;
            this.f5334l = z4;
        }
    }

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static boolean a(RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        @DoNotInline
        static CharSequence[] b(RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        @DoNotInline
        static Bundle c(Notification.Action action) {
            return action.getExtras();
        }

        @DoNotInline
        static Bundle d(RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }

        @DoNotInline
        static String e(Notification notification) {
            return notification.getGroup();
        }

        @DoNotInline
        static CharSequence f(RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        @DoNotInline
        static RemoteInput[] g(Notification.Action action) {
            return action.getRemoteInputs();
        }

        @DoNotInline
        static String h(RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        @DoNotInline
        static String i(Notification notification) {
            return notification.getSortKey();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Icon a(Notification.Action action) {
            return action.getIcon();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static boolean a(Notification.Action action) {
            return action.getAllowGeneratedReplies();
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int a(Notification notification) {
            return notification.getBadgeIconType();
        }

        @DoNotInline
        static String b(Notification notification) {
            return notification.getChannelId();
        }

        @DoNotInline
        static int c(Notification notification) {
            return notification.getGroupAlertBehavior();
        }

        @DoNotInline
        static CharSequence d(Notification notification) {
            return notification.getSettingsText();
        }

        @DoNotInline
        static String e(Notification notification) {
            return notification.getShortcutId();
        }

        @DoNotInline
        static long f(Notification notification) {
            return notification.getTimeoutAfter();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int a(Notification.Action action) {
            return action.getSemanticAction();
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static boolean a(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        @DoNotInline
        static Notification.BubbleMetadata b(Notification notification) {
            return notification.getBubbleMetadata();
        }

        @DoNotInline
        static int c(RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }

        @DoNotInline
        static LocusId d(Notification notification) {
            return notification.getLocusId();
        }

        @DoNotInline
        static boolean e(Notification.Action action) {
            return action.isContextual();
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean a(Notification.Action action) {
            return action.isAuthenticationRequired();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {

        /* renamed from: j  reason: collision with root package name */
        private static final String f5358j = "androidx.core.app.NotificationCompat$BigPictureStyle";

        /* renamed from: e  reason: collision with root package name */
        private IconCompat f5359e;

        /* renamed from: f  reason: collision with root package name */
        private IconCompat f5360f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f5361g;

        /* renamed from: h  reason: collision with root package name */
        private CharSequence f5362h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5363i;

        @RequiresApi(23)
        private static class Api23Impl {
            private Api23Impl() {
            }

            @RequiresApi(23)
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        @RequiresApi(31)
        private static class Api31Impl {
            private Api31Impl() {
            }

            @RequiresApi(31)
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            @RequiresApi(31)
            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            @RequiresApi(31)
            static void c(Notification.BigPictureStyle bigPictureStyle, boolean z) {
                bigPictureStyle.showBigPictureWhenCollapsed(z);
            }
        }

        public BigPictureStyle() {
        }

        @Nullable
        private static IconCompat A(@Nullable Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 23 && k.a(parcelable)) {
                return IconCompat.m(l.a(parcelable));
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.s((Bitmap) parcelable);
            }
            return null;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static IconCompat F(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable(NotificationCompat.T);
            return parcelable != null ? A(parcelable) : A(bundle.getParcelable(NotificationCompat.U));
        }

        @NonNull
        public BigPictureStyle B(@Nullable Bitmap bitmap) {
            this.f5360f = bitmap == null ? null : IconCompat.s(bitmap);
            this.f5361g = true;
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public BigPictureStyle C(@Nullable Icon icon) {
            this.f5360f = icon == null ? null : IconCompat.m(icon);
            this.f5361g = true;
            return this;
        }

        @NonNull
        public BigPictureStyle D(@Nullable Bitmap bitmap) {
            this.f5359e = bitmap == null ? null : IconCompat.s(bitmap);
            return this;
        }

        @RequiresApi(31)
        @NonNull
        public BigPictureStyle E(@Nullable Icon icon) {
            this.f5359e = IconCompat.m(icon);
            return this;
        }

        @NonNull
        public BigPictureStyle G(@Nullable CharSequence charSequence) {
            this.f5458b = Builder.A(charSequence);
            return this;
        }

        @RequiresApi(31)
        @NonNull
        public BigPictureStyle H(@Nullable CharSequence charSequence) {
            this.f5362h = charSequence;
            return this;
        }

        @NonNull
        public BigPictureStyle I(@Nullable CharSequence charSequence) {
            this.f5459c = Builder.A(charSequence);
            this.f5460d = true;
            return this;
        }

        @RequiresApi(31)
        @NonNull
        public BigPictureStyle J(boolean z) {
            this.f5363i = z;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.f5458b);
            IconCompat iconCompat = this.f5359e;
            Context context = null;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    Api31Impl.a(bigContentTitle, this.f5359e.M(notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder ? ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f() : null));
                } else if (iconCompat.C() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f5359e.y());
                }
            }
            if (this.f5361g) {
                IconCompat iconCompat2 = this.f5360f;
                if (iconCompat2 != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder) {
                            context = ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f();
                        }
                        Api23Impl.a(bigContentTitle, this.f5360f.M(context));
                    } else if (iconCompat2.C() == 1) {
                        bigContentTitle.bigLargeIcon(this.f5360f.y());
                    }
                }
                bigContentTitle.bigLargeIcon((Bitmap) null);
            }
            if (this.f5460d) {
                bigContentTitle.setSummaryText(this.f5459c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.c(bigContentTitle, this.f5363i);
                Api31Impl.b(bigContentTitle, this.f5362h);
            }
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void g(@NonNull Bundle bundle) {
            super.g(bundle);
            bundle.remove(NotificationCompat.L);
            bundle.remove(NotificationCompat.T);
            bundle.remove(NotificationCompat.U);
            bundle.remove(NotificationCompat.W);
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String t() {
            return f5358j;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@NonNull Bundle bundle) {
            super.y(bundle);
            if (bundle.containsKey(NotificationCompat.L)) {
                this.f5360f = A(bundle.getParcelable(NotificationCompat.L));
                this.f5361g = true;
            }
            this.f5359e = F(bundle);
            this.f5363i = bundle.getBoolean(NotificationCompat.W);
        }

        public BigPictureStyle(@Nullable Builder builder) {
            z(builder);
        }
    }

    public static class BigTextStyle extends Style {

        /* renamed from: f  reason: collision with root package name */
        private static final String f5364f = "androidx.core.app.NotificationCompat$BigTextStyle";

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f5365e;

        public BigTextStyle() {
        }

        @NonNull
        public BigTextStyle A(@Nullable CharSequence charSequence) {
            this.f5365e = Builder.A(charSequence);
            return this;
        }

        @NonNull
        public BigTextStyle B(@Nullable CharSequence charSequence) {
            this.f5458b = Builder.A(charSequence);
            return this;
        }

        @NonNull
        public BigTextStyle C(@Nullable CharSequence charSequence) {
            this.f5459c = Builder.A(charSequence);
            this.f5460d = true;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void a(@NonNull Bundle bundle) {
            super.a(bundle);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.f5458b).bigText(this.f5365e);
            if (this.f5460d) {
                bigText.setSummaryText(this.f5459c);
            }
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void g(@NonNull Bundle bundle) {
            super.g(bundle);
            bundle.remove(NotificationCompat.I);
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String t() {
            return f5364f;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@NonNull Bundle bundle) {
            super.y(bundle);
            this.f5365e = bundle.getCharSequence(NotificationCompat.I);
        }

        public BigTextStyle(@Nullable Builder builder) {
            z(builder);
        }
    }

    public static final class BubbleMetadata {

        /* renamed from: h  reason: collision with root package name */
        private static final int f5366h = 1;

        /* renamed from: i  reason: collision with root package name */
        private static final int f5367i = 2;

        /* renamed from: a  reason: collision with root package name */
        private PendingIntent f5368a;

        /* renamed from: b  reason: collision with root package name */
        private PendingIntent f5369b;

        /* renamed from: c  reason: collision with root package name */
        private IconCompat f5370c;

        /* renamed from: d  reason: collision with root package name */
        private int f5371d;
        @DimenRes

        /* renamed from: e  reason: collision with root package name */
        private int f5372e;

        /* renamed from: f  reason: collision with root package name */
        private int f5373f;

        /* renamed from: g  reason: collision with root package name */
        private String f5374g;

        @RequiresApi(29)
        private static class Api29Impl {
            private Api29Impl() {
            }

            @RequiresApi(29)
            @Nullable
            static BubbleMetadata a(@Nullable Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                Builder i2 = new Builder(bubbleMetadata.getIntent(), IconCompat.m(bubbleMetadata.getIcon())).b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).i(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    i2.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    i2.e(bubbleMetadata.getDesiredHeightResId());
                }
                return i2.a();
            }

            @RequiresApi(29)
            @Nullable
            static Notification.BubbleMetadata b(@Nullable BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.g() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(bubbleMetadata.f().L()).setIntent(bubbleMetadata.g()).setDeleteIntent(bubbleMetadata.c()).setAutoExpandBubble(bubbleMetadata.b()).setSuppressNotification(bubbleMetadata.i());
                if (bubbleMetadata.d() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.d());
                }
                if (bubbleMetadata.e() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.e());
                }
                return suppressNotification.build();
            }
        }

        @RequiresApi(30)
        private static class Api30Impl {
            private Api30Impl() {
            }

            @RequiresApi(30)
            @Nullable
            static BubbleMetadata a(@Nullable Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                Builder builder = bubbleMetadata.getShortcutId() != null ? new Builder(bubbleMetadata.getShortcutId()) : new Builder(bubbleMetadata.getIntent(), IconCompat.m(bubbleMetadata.getIcon()));
                builder.b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).i(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.e(bubbleMetadata.getDesiredHeightResId());
                }
                return builder.a();
            }

            @RequiresApi(30)
            @Nullable
            static Notification.BubbleMetadata b(@Nullable BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = bubbleMetadata.h() != null ? new Notification.BubbleMetadata.Builder(bubbleMetadata.h()) : new Notification.BubbleMetadata.Builder(bubbleMetadata.g(), bubbleMetadata.f().L());
                builder.setDeleteIntent(bubbleMetadata.c()).setAutoExpandBubble(bubbleMetadata.b()).setSuppressNotification(bubbleMetadata.i());
                if (bubbleMetadata.d() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.d());
                }
                if (bubbleMetadata.e() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.e());
                }
                return builder.build();
            }
        }

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private PendingIntent f5375a;

            /* renamed from: b  reason: collision with root package name */
            private IconCompat f5376b;

            /* renamed from: c  reason: collision with root package name */
            private int f5377c;
            @DimenRes

            /* renamed from: d  reason: collision with root package name */
            private int f5378d;

            /* renamed from: e  reason: collision with root package name */
            private int f5379e;

            /* renamed from: f  reason: collision with root package name */
            private PendingIntent f5380f;

            /* renamed from: g  reason: collision with root package name */
            private String f5381g;

            @Deprecated
            public Builder() {
            }

            @NonNull
            private Builder f(int i2, boolean z) {
                int i3;
                if (z) {
                    i3 = i2 | this.f5379e;
                } else {
                    i3 = (~i2) & this.f5379e;
                }
                this.f5379e = i3;
                return this;
            }

            @NonNull
            public BubbleMetadata a() {
                String str = this.f5381g;
                if (str == null && this.f5375a == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                } else if (str == null && this.f5376b == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                } else {
                    BubbleMetadata bubbleMetadata = new BubbleMetadata(this.f5375a, this.f5380f, this.f5376b, this.f5377c, this.f5378d, this.f5379e, str);
                    bubbleMetadata.j(this.f5379e);
                    return bubbleMetadata;
                }
            }

            @NonNull
            public Builder b(boolean z) {
                f(1, z);
                return this;
            }

            @NonNull
            public Builder c(@Nullable PendingIntent pendingIntent) {
                this.f5380f = pendingIntent;
                return this;
            }

            @NonNull
            public Builder d(@Dimension(unit = 0) int i2) {
                this.f5377c = Math.max(i2, 0);
                this.f5378d = 0;
                return this;
            }

            @NonNull
            public Builder e(@DimenRes int i2) {
                this.f5378d = i2;
                this.f5377c = 0;
                return this;
            }

            @NonNull
            public Builder g(@NonNull IconCompat iconCompat) {
                if (this.f5381g != null) {
                    throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                } else if (iconCompat != null) {
                    this.f5376b = iconCompat;
                    return this;
                } else {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
            }

            @NonNull
            public Builder h(@NonNull PendingIntent pendingIntent) {
                if (this.f5381g != null) {
                    throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                } else if (pendingIntent != null) {
                    this.f5375a = pendingIntent;
                    return this;
                } else {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
            }

            @NonNull
            public Builder i(boolean z) {
                f(2, z);
                return this;
            }

            public Builder(@NonNull PendingIntent pendingIntent, @NonNull IconCompat iconCompat) {
                if (pendingIntent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                } else if (iconCompat != null) {
                    this.f5375a = pendingIntent;
                    this.f5376b = iconCompat;
                } else {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
            }

            @RequiresApi(30)
            public Builder(@NonNull String str) {
                if (!TextUtils.isEmpty(str)) {
                    this.f5381g = str;
                    return;
                }
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }
        }

        private BubbleMetadata(@Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable IconCompat iconCompat, int i2, @DimenRes int i3, int i4, @Nullable String str) {
            this.f5368a = pendingIntent;
            this.f5370c = iconCompat;
            this.f5371d = i2;
            this.f5372e = i3;
            this.f5369b = pendingIntent2;
            this.f5373f = i4;
            this.f5374g = str;
        }

        @Nullable
        public static BubbleMetadata a(@Nullable Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                return Api30Impl.a(bubbleMetadata);
            }
            if (i2 == 29) {
                return Api29Impl.a(bubbleMetadata);
            }
            return null;
        }

        @Nullable
        public static Notification.BubbleMetadata k(@Nullable BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                return Api30Impl.b(bubbleMetadata);
            }
            if (i2 == 29) {
                return Api29Impl.b(bubbleMetadata);
            }
            return null;
        }

        public boolean b() {
            return (this.f5373f & 1) != 0;
        }

        @Nullable
        public PendingIntent c() {
            return this.f5369b;
        }

        @Dimension(unit = 0)
        public int d() {
            return this.f5371d;
        }

        @DimenRes
        public int e() {
            return this.f5372e;
        }

        @SuppressLint({"InvalidNullConversion"})
        @Nullable
        public IconCompat f() {
            return this.f5370c;
        }

        @SuppressLint({"InvalidNullConversion"})
        @Nullable
        public PendingIntent g() {
            return this.f5368a;
        }

        @Nullable
        public String h() {
            return this.f5374g;
        }

        public boolean i() {
            return (this.f5373f & 2) != 0;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void j(int i2) {
            this.f5373f = i2;
        }
    }

    public static class Builder {
        private static final int Y = 5120;
        boolean A;
        boolean B;
        boolean C;
        String D;
        Bundle E;
        int F;
        int G;
        Notification H;
        RemoteViews I;
        RemoteViews J;
        RemoteViews K;
        String L;
        int M;
        String N;
        LocusIdCompat O;
        long P;
        int Q;
        int R;
        boolean S;
        BubbleMetadata T;
        Notification U;
        boolean V;
        Object W;
        @Deprecated
        public ArrayList<String> X;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: a  reason: collision with root package name */
        public Context f5382a;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Action> f5383b;
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<Person> f5384c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Action> f5385d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f5386e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f5387f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f5388g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f5389h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f5390i;

        /* renamed from: j  reason: collision with root package name */
        IconCompat f5391j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f5392k;

        /* renamed from: l  reason: collision with root package name */
        int f5393l;

        /* renamed from: m  reason: collision with root package name */
        int f5394m;

        /* renamed from: n  reason: collision with root package name */
        boolean f5395n;
        boolean o;
        boolean p;
        Style q;
        CharSequence r;
        CharSequence s;
        CharSequence[] t;
        int u;
        int v;
        boolean w;
        String x;
        boolean y;
        String z;

        @RequiresApi(21)
        static class Api21Impl {
            private Api21Impl() {
            }

            @DoNotInline
            static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            @DoNotInline
            static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            @DoNotInline
            static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i2) {
                return builder.setContentType(i2);
            }

            @DoNotInline
            static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i2) {
                return builder.setLegacyStreamType(i2);
            }

            @DoNotInline
            static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i2) {
                return builder.setUsage(i2);
            }
        }

        @RequiresApi(23)
        static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            static Icon a(Notification notification) {
                return notification.getLargeIcon();
            }

            @DoNotInline
            static Icon b(Notification notification) {
                return notification.getSmallIcon();
            }
        }

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static RemoteViews a(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            @DoNotInline
            static RemoteViews b(Notification.Builder builder) {
                return builder.createContentView();
            }

            @DoNotInline
            static RemoteViews c(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            @DoNotInline
            static Notification.Builder d(Context context, Notification notification) {
                return Notification.Builder.recoverBuilder(context, notification);
            }
        }

        @Deprecated
        public Builder(@NonNull Context context) {
            this(context, (String) null);
        }

        @Nullable
        protected static CharSequence A(@Nullable CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > Y) ? charSequence.subSequence(0, Y) : charSequence;
        }

        private boolean I0() {
            Style style = this.q;
            return style == null || !style.r();
        }

        private void V(int i2, boolean z2) {
            Notification notification;
            int i3;
            if (z2) {
                notification = this.U;
                i3 = i2 | notification.flags;
            } else {
                notification = this.U;
                i3 = (~i2) & notification.flags;
            }
            notification.flags = i3;
        }

        @Nullable
        private static Bundle u(@NonNull Notification notification, @Nullable Style style) {
            if (notification.extras == null) {
                return null;
            }
            Bundle bundle = new Bundle(notification.extras);
            bundle.remove(NotificationCompat.B);
            bundle.remove(NotificationCompat.D);
            bundle.remove(NotificationCompat.G);
            bundle.remove(NotificationCompat.E);
            bundle.remove(NotificationCompat.f5309c);
            bundle.remove(NotificationCompat.f5310d);
            bundle.remove(NotificationCompat.S);
            bundle.remove(NotificationCompat.M);
            bundle.remove(NotificationCompat.N);
            bundle.remove(NotificationCompat.O);
            bundle.remove(NotificationCompat.Q);
            bundle.remove(NotificationCompat.R);
            bundle.remove(NotificationCompat.b0);
            bundle.remove(NotificationCompat.a0);
            bundle.remove(NotificationCompatExtras.f5500d);
            bundle.remove(NotificationCompatExtras.f5498b);
            bundle.remove(NotificationCompatExtras.f5499c);
            bundle.remove(NotificationCompatExtras.f5497a);
            bundle.remove(NotificationCompatExtras.f5501e);
            Bundle bundle2 = bundle.getBundle("android.car.EXTENSIONS");
            if (bundle2 != null) {
                Bundle bundle3 = new Bundle(bundle2);
                bundle3.remove("invisible_actions");
                bundle.putBundle("android.car.EXTENSIONS", bundle3);
            }
            if (style != null) {
                style.g(bundle);
            }
            return bundle;
        }

        @NonNull
        public Builder A0(@Nullable CharSequence charSequence) {
            this.r = A(charSequence);
            return this;
        }

        @NonNull
        public Builder B(boolean z2) {
            this.S = z2;
            return this;
        }

        @NonNull
        public Builder B0(@Nullable CharSequence charSequence) {
            this.U.tickerText = A(charSequence);
            return this;
        }

        @NonNull
        public Builder C(boolean z2) {
            V(16, z2);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder C0(@Nullable CharSequence charSequence, @Nullable RemoteViews remoteViews) {
            this.U.tickerText = A(charSequence);
            this.f5390i = remoteViews;
            return this;
        }

        @NonNull
        public Builder D(int i2) {
            this.M = i2;
            return this;
        }

        @NonNull
        public Builder D0(long j2) {
            this.P = j2;
            return this;
        }

        @NonNull
        public Builder E(@Nullable BubbleMetadata bubbleMetadata) {
            this.T = bubbleMetadata;
            return this;
        }

        @NonNull
        public Builder E0(boolean z2) {
            this.o = z2;
            return this;
        }

        @NonNull
        public Builder F(@Nullable String str) {
            this.D = str;
            return this;
        }

        @NonNull
        public Builder F0(@Nullable long[] jArr) {
            this.U.vibrate = jArr;
            return this;
        }

        @NonNull
        public Builder G(@NonNull String str) {
            this.L = str;
            return this;
        }

        @NonNull
        public Builder G0(int i2) {
            this.G = i2;
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder H(boolean z2) {
            this.p = z2;
            t().putBoolean(NotificationCompat.Q, z2);
            return this;
        }

        @NonNull
        public Builder H0(long j2) {
            this.U.when = j2;
            return this;
        }

        @NonNull
        public Builder I(@ColorInt int i2) {
            this.F = i2;
            return this;
        }

        @NonNull
        public Builder J(boolean z2) {
            this.B = z2;
            this.C = true;
            return this;
        }

        @NonNull
        public Builder K(@Nullable RemoteViews remoteViews) {
            this.U.contentView = remoteViews;
            return this;
        }

        @NonNull
        public Builder L(@Nullable CharSequence charSequence) {
            this.f5392k = A(charSequence);
            return this;
        }

        @NonNull
        public Builder M(@Nullable PendingIntent pendingIntent) {
            this.f5388g = pendingIntent;
            return this;
        }

        @NonNull
        public Builder N(@Nullable CharSequence charSequence) {
            this.f5387f = A(charSequence);
            return this;
        }

        @NonNull
        public Builder O(@Nullable CharSequence charSequence) {
            this.f5386e = A(charSequence);
            return this;
        }

        @NonNull
        public Builder P(@Nullable RemoteViews remoteViews) {
            this.J = remoteViews;
            return this;
        }

        @NonNull
        public Builder Q(@Nullable RemoteViews remoteViews) {
            this.I = remoteViews;
            return this;
        }

        @NonNull
        public Builder R(@Nullable RemoteViews remoteViews) {
            this.K = remoteViews;
            return this;
        }

        @NonNull
        public Builder S(int i2) {
            Notification notification = this.U;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @NonNull
        public Builder T(@Nullable PendingIntent pendingIntent) {
            this.U.deleteIntent = pendingIntent;
            return this;
        }

        @NonNull
        public Builder U(@Nullable Bundle bundle) {
            this.E = bundle;
            return this;
        }

        @NonNull
        public Builder W(int i2) {
            this.R = i2;
            return this;
        }

        @NonNull
        public Builder X(@Nullable PendingIntent pendingIntent, boolean z2) {
            this.f5389h = pendingIntent;
            V(128, z2);
            return this;
        }

        @NonNull
        public Builder Y(@Nullable String str) {
            this.x = str;
            return this;
        }

        @NonNull
        public Builder Z(int i2) {
            this.Q = i2;
            return this;
        }

        @NonNull
        public Builder a(int i2, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this.f5383b.add(new Action(i2, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        public Builder a0(boolean z2) {
            this.y = z2;
            return this;
        }

        @NonNull
        public Builder b(@Nullable Action action) {
            if (action != null) {
                this.f5383b.add(action);
            }
            return this;
        }

        @NonNull
        public Builder b0(@Nullable Bitmap bitmap) {
            this.f5391j = bitmap == null ? null : IconCompat.s(NotificationCompat.I(this.f5382a, bitmap));
            return this;
        }

        @NonNull
        public Builder c(@Nullable Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.E;
                if (bundle2 == null) {
                    this.E = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public Builder c0(@Nullable Icon icon) {
            this.f5391j = icon == null ? null : IconCompat.m(icon);
            return this;
        }

        @RequiresApi(21)
        @NonNull
        public Builder d(int i2, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this.f5385d.add(new Action(i2, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        public Builder d0(@ColorInt int i2, int i3, int i4) {
            Notification notification = this.U;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            notification.flags = ((i3 == 0 || i4 == 0) ? 0 : 1) | (notification.flags & -2);
            return this;
        }

        @RequiresApi(21)
        @NonNull
        public Builder e(@Nullable Action action) {
            if (action != null) {
                this.f5385d.add(action);
            }
            return this;
        }

        @NonNull
        public Builder e0(boolean z2) {
            this.A = z2;
            return this;
        }

        @NonNull
        public Builder f(@Nullable Person person) {
            if (person != null) {
                this.f5384c.add(person);
            }
            return this;
        }

        @NonNull
        public Builder f0(@Nullable LocusIdCompat locusIdCompat) {
            this.O = locusIdCompat;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder g(@Nullable String str) {
            if (str != null && !str.isEmpty()) {
                this.X.add(str);
            }
            return this;
        }

        @NonNull
        @Deprecated
        public Builder g0() {
            this.V = true;
            return this;
        }

        @NonNull
        public Notification h() {
            return new NotificationCompatBuilder(this).c();
        }

        @NonNull
        public Builder h0(int i2) {
            this.f5393l = i2;
            return this;
        }

        @NonNull
        public Builder i() {
            this.f5383b.clear();
            return this;
        }

        @NonNull
        public Builder i0(boolean z2) {
            V(2, z2);
            return this;
        }

        @NonNull
        public Builder j() {
            this.f5385d.clear();
            Bundle bundle = this.E.getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                Bundle bundle2 = new Bundle(bundle);
                bundle2.remove("invisible_actions");
                this.E.putBundle("android.car.EXTENSIONS", bundle2);
            }
            return this;
        }

        @NonNull
        public Builder j0(boolean z2) {
            V(8, z2);
            return this;
        }

        @NonNull
        public Builder k() {
            this.f5384c.clear();
            this.X.clear();
            return this;
        }

        @NonNull
        public Builder k0(int i2) {
            this.f5394m = i2;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @Nullable
        public RemoteViews l() {
            RemoteViews v2;
            if (this.J != null && I0()) {
                return this.J;
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            Style style = this.q;
            if (style != null && (v2 = style.v(notificationCompatBuilder)) != null) {
                return v2;
            }
            Notification c2 = notificationCompatBuilder.c();
            return Build.VERSION.SDK_INT >= 24 ? Api24Impl.a(Api24Impl.d(this.f5382a, c2)) : c2.bigContentView;
        }

        @NonNull
        public Builder l0(int i2, int i3, boolean z2) {
            this.u = i2;
            this.v = i3;
            this.w = z2;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @Nullable
        public RemoteViews m() {
            RemoteViews w2;
            if (this.I != null && I0()) {
                return this.I;
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            Style style = this.q;
            if (style != null && (w2 = style.w(notificationCompatBuilder)) != null) {
                return w2;
            }
            Notification c2 = notificationCompatBuilder.c();
            return Build.VERSION.SDK_INT >= 24 ? Api24Impl.b(Api24Impl.d(this.f5382a, c2)) : c2.contentView;
        }

        @NonNull
        public Builder m0(@Nullable Notification notification) {
            this.H = notification;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @Nullable
        public RemoteViews n() {
            RemoteViews x2;
            int i2 = Build.VERSION.SDK_INT;
            if (this.K != null && I0()) {
                return this.K;
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            Style style = this.q;
            if (style != null && (x2 = style.x(notificationCompatBuilder)) != null) {
                return x2;
            }
            Notification c2 = notificationCompatBuilder.c();
            return i2 >= 24 ? Api24Impl.c(Api24Impl.d(this.f5382a, c2)) : c2.headsUpContentView;
        }

        @NonNull
        public Builder n0(@Nullable CharSequence[] charSequenceArr) {
            this.t = charSequenceArr;
            return this;
        }

        @NonNull
        public Builder o(@NonNull Extender extender) {
            extender.a(this);
            return this;
        }

        @NonNull
        public Builder o0(@Nullable CharSequence charSequence) {
            this.s = A(charSequence);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews p() {
            return this.J;
        }

        @NonNull
        public Builder p0(@Nullable String str) {
            this.N = str;
            return this;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public BubbleMetadata q() {
            return this.T;
        }

        @NonNull
        public Builder q0(@Nullable ShortcutInfoCompat shortcutInfoCompat) {
            LocusIdCompat locusIdCompat;
            if (shortcutInfoCompat == null) {
                return this;
            }
            this.N = shortcutInfoCompat.k();
            if (this.O == null) {
                if (shortcutInfoCompat.o() != null) {
                    locusIdCompat = shortcutInfoCompat.o();
                } else if (shortcutInfoCompat.k() != null) {
                    locusIdCompat = new LocusIdCompat(shortcutInfoCompat.k());
                }
                this.O = locusIdCompat;
            }
            if (this.f5386e == null) {
                O(shortcutInfoCompat.w());
            }
            return this;
        }

        @ColorInt
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int r() {
            return this.F;
        }

        @NonNull
        public Builder r0(boolean z2) {
            this.f5395n = z2;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews s() {
            return this.I;
        }

        @NonNull
        public Builder s0(boolean z2) {
            this.V = z2;
            return this;
        }

        @NonNull
        public Bundle t() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        @NonNull
        public Builder t0(int i2) {
            this.U.icon = i2;
            return this;
        }

        @NonNull
        public Builder u0(int i2, int i3) {
            Notification notification = this.U;
            notification.icon = i2;
            notification.iconLevel = i3;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int v() {
            return this.R;
        }

        @RequiresApi(23)
        @NonNull
        public Builder v0(@NonNull IconCompat iconCompat) {
            this.W = iconCompat.M(this.f5382a);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews w() {
            return this.K;
        }

        @NonNull
        public Builder w0(@Nullable String str) {
            this.z = str;
            return this;
        }

        @NonNull
        @Deprecated
        public Notification x() {
            return h();
        }

        @NonNull
        public Builder x0(@Nullable Uri uri) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder e2 = Api21Impl.e(Api21Impl.c(Api21Impl.b(), 4), 5);
            this.U.audioAttributes = Api21Impl.a(e2);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int y() {
            return this.f5394m;
        }

        @NonNull
        public Builder y0(@Nullable Uri uri, int i2) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = i2;
            AudioAttributes.Builder d2 = Api21Impl.d(Api21Impl.c(Api21Impl.b(), 4), i2);
            this.U.audioAttributes = Api21Impl.a(d2);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long z() {
            if (this.f5395n) {
                return this.U.when;
            }
            return 0;
        }

        @NonNull
        public Builder z0(@Nullable Style style) {
            if (this.q != style) {
                this.q = style;
                if (style != null) {
                    style.z(this);
                }
            }
            return this;
        }

        public Builder(@NonNull Context context, @NonNull Notification notification) {
            this(context, NotificationCompat.i(notification));
            ArrayList parcelableArrayList;
            Bundle bundle = notification.extras;
            Style s2 = Style.s(notification);
            O(NotificationCompat.m(notification)).N(NotificationCompat.l(notification)).L(NotificationCompat.k(notification)).A0(NotificationCompat.D(notification)).o0(NotificationCompat.z(notification)).z0(s2).Y(NotificationCompat.o(notification)).a0(NotificationCompat.H(notification)).f0(NotificationCompat.t(notification)).H0(notification.when).r0(NotificationCompat.B(notification)).E0(NotificationCompat.F(notification)).C(NotificationCompat.e(notification)).j0(NotificationCompat.w(notification)).i0(NotificationCompat.v(notification)).e0(NotificationCompat.s(notification)).b0(notification.largeIcon).D(NotificationCompat.f(notification)).F(NotificationCompat.h(notification)).E(NotificationCompat.g(notification)).h0(notification.number).B0(notification.tickerText).M(notification.contentIntent).T(notification.deleteIntent).X(notification.fullScreenIntent, NotificationCompat.q(notification)).y0(notification.sound, notification.audioStreamType).F0(notification.vibrate).d0(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).S(notification.defaults).k0(notification.priority).I(NotificationCompat.j(notification)).G0(NotificationCompat.G(notification)).m0(NotificationCompat.y(notification)).w0(NotificationCompat.C(notification)).D0(NotificationCompat.E(notification)).p0(NotificationCompat.A(notification)).l0(bundle.getInt(NotificationCompat.N), bundle.getInt(NotificationCompat.M), bundle.getBoolean(NotificationCompat.O)).B(NotificationCompat.d(notification)).u0(notification.icon, notification.iconLevel).c(u(notification, s2));
            if (Build.VERSION.SDK_INT >= 23) {
                this.W = Api23Impl.b(notification);
                Icon a2 = Api23Impl.a(notification);
                if (a2 != null) {
                    this.f5391j = IconCompat.m(a2);
                }
            }
            Notification.Action[] actionArr = notification.actions;
            if (!(actionArr == null || actionArr.length == 0)) {
                for (Notification.Action f2 : actionArr) {
                    b(Action.Builder.f(f2).c());
                }
            }
            List<Action> r2 = NotificationCompat.r(notification);
            if (!r2.isEmpty()) {
                for (Action e2 : r2) {
                    e(e2);
                }
            }
            String[] stringArray = notification.extras.getStringArray(NotificationCompat.a0);
            if (!(stringArray == null || stringArray.length == 0)) {
                for (String g2 : stringArray) {
                    g(g2);
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && (parcelableArrayList = notification.extras.getParcelableArrayList(NotificationCompat.b0)) != null && !parcelableArrayList.isEmpty()) {
                Iterator it2 = parcelableArrayList.iterator();
                while (it2.hasNext()) {
                    f(Person.a(j.a(it2.next())));
                }
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24 && bundle.containsKey(NotificationCompat.Q)) {
                H(bundle.getBoolean(NotificationCompat.Q));
            }
            if (i2 >= 26 && bundle.containsKey(NotificationCompat.R)) {
                J(bundle.getBoolean(NotificationCompat.R));
            }
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            this.f5383b = new ArrayList<>();
            this.f5384c = new ArrayList<>();
            this.f5385d = new ArrayList<>();
            this.f5395n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.Q = 0;
            this.R = 0;
            Notification notification = new Notification();
            this.U = notification;
            this.f5382a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.U.audioStreamType = -1;
            this.f5394m = 0;
            this.X = new ArrayList<>();
            this.S = true;
        }
    }

    public static class CallStyle extends Style {
        private static final String o = "androidx.core.app.NotificationCompat$CallStyle";
        public static final int p = 0;
        public static final int q = 1;
        public static final int r = 2;
        public static final int s = 3;
        private static final String t = "key_action_priority";

        /* renamed from: e  reason: collision with root package name */
        private int f5396e;

        /* renamed from: f  reason: collision with root package name */
        private Person f5397f;

        /* renamed from: g  reason: collision with root package name */
        private PendingIntent f5398g;

        /* renamed from: h  reason: collision with root package name */
        private PendingIntent f5399h;

        /* renamed from: i  reason: collision with root package name */
        private PendingIntent f5400i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f5401j;

        /* renamed from: k  reason: collision with root package name */
        private Integer f5402k;

        /* renamed from: l  reason: collision with root package name */
        private Integer f5403l;

        /* renamed from: m  reason: collision with root package name */
        private IconCompat f5404m;

        /* renamed from: n  reason: collision with root package name */
        private CharSequence f5405n;

        @RequiresApi(20)
        static class Api20Impl {
            private Api20Impl() {
            }

            @DoNotInline
            static Notification.Action.Builder a(Notification.Action.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            @DoNotInline
            static Notification.Action.Builder b(Notification.Action.Builder builder, RemoteInput remoteInput) {
                return builder.addRemoteInput(remoteInput);
            }

            @DoNotInline
            static Notification.Action c(Notification.Action.Builder builder) {
                return builder.build();
            }

            @DoNotInline
            static Notification.Action.Builder d(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(i2, charSequence, pendingIntent);
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
        }

        @RequiresApi(23)
        static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            static Parcelable a(Icon icon) {
                return icon;
            }

            @DoNotInline
            static Notification.Action.Builder b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            @DoNotInline
            static void c(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
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
            static Parcelable b(Person person) {
                return person;
            }
        }

        @RequiresApi(31)
        static class Api31Impl {
            private Api31Impl() {
            }

            @DoNotInline
            static Notification.CallStyle a(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            @DoNotInline
            static Notification.CallStyle b(@NonNull Person person, @NonNull PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            @DoNotInline
            static Notification.CallStyle c(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            @DoNotInline
            static Notification.CallStyle d(Notification.CallStyle callStyle, @ColorInt int i2) {
                return callStyle.setAnswerButtonColorHint(i2);
            }

            @DoNotInline
            static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z) {
                return builder.setAuthenticationRequired(z);
            }

            @DoNotInline
            static Notification.CallStyle f(Notification.CallStyle callStyle, @ColorInt int i2) {
                return callStyle.setDeclineButtonColorHint(i2);
            }

            @DoNotInline
            static Notification.CallStyle g(Notification.CallStyle callStyle, boolean z) {
                return callStyle.setIsVideo(z);
            }

            @DoNotInline
            static Notification.CallStyle h(Notification.CallStyle callStyle, @Nullable Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            @DoNotInline
            static Notification.CallStyle i(Notification.CallStyle callStyle, @Nullable CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Retention(RetentionPolicy.SOURCE)
        public @interface CallType {
        }

        public CallStyle() {
        }

        @NonNull
        public static CallStyle A(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
            Objects.requireNonNull(pendingIntent, "declineIntent is required");
            Objects.requireNonNull(pendingIntent2, "answerIntent is required");
            return new CallStyle(1, person, (PendingIntent) null, pendingIntent, pendingIntent2);
        }

        @NonNull
        public static CallStyle B(@NonNull Person person, @NonNull PendingIntent pendingIntent) {
            Objects.requireNonNull(pendingIntent, "hangUpIntent is required");
            return new CallStyle(2, person, pendingIntent, (PendingIntent) null, (PendingIntent) null);
        }

        @NonNull
        public static CallStyle C(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
            Objects.requireNonNull(pendingIntent, "hangUpIntent is required");
            Objects.requireNonNull(pendingIntent2, "answerIntent is required");
            return new CallStyle(3, person, pendingIntent, (PendingIntent) null, pendingIntent2);
        }

        @Nullable
        private String E() {
            Resources resources;
            int i2;
            int i3 = this.f5396e;
            if (i3 == 1) {
                resources = this.f5457a.f5382a.getResources();
                i2 = R.string.f5173e;
            } else if (i3 == 2) {
                resources = this.f5457a.f5382a.getResources();
                i2 = R.string.f5174f;
            } else if (i3 != 3) {
                return null;
            } else {
                resources = this.f5457a.f5382a.getResources();
                i2 = R.string.f5175g;
            }
            return resources.getString(i2);
        }

        private boolean F(Action action) {
            return action != null && action.d().getBoolean(t);
        }

        @RequiresApi(20)
        @NonNull
        private Action G(int i2, int i3, Integer num, int i4, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(ContextCompat.g(this.f5457a.f5382a, i4));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(this.f5457a.f5382a.getResources().getString(i3));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            Action c2 = new Action.Builder(IconCompat.w(this.f5457a.f5382a, i2), (CharSequence) spannableStringBuilder, pendingIntent).c();
            c2.d().putBoolean(t, true);
            return c2;
        }

        @RequiresApi(20)
        @Nullable
        private Action H() {
            int i2 = R.drawable.f5133c;
            int i3 = R.drawable.f5131a;
            PendingIntent pendingIntent = this.f5398g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z = this.f5401j;
            return G(z ? i2 : i3, z ? R.string.f5170b : R.string.f5169a, this.f5402k, R.color.f5113c, pendingIntent);
        }

        @RequiresApi(20)
        @NonNull
        private Action I() {
            int i2;
            Integer num;
            int i3;
            int i4 = R.drawable.f5135e;
            PendingIntent pendingIntent = this.f5399h;
            if (pendingIntent == null) {
                i2 = R.string.f5172d;
                num = this.f5403l;
                i3 = R.color.f5114d;
                pendingIntent = this.f5400i;
            } else {
                i2 = R.string.f5171c;
                num = this.f5403l;
                i3 = R.color.f5114d;
            }
            return G(i4, i2, num, i3, pendingIntent);
        }

        @RequiresApi(20)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @NonNull
        public ArrayList<Action> D() {
            Action I = I();
            Action H = H();
            ArrayList<Action> arrayList = new ArrayList<>(3);
            arrayList.add(I);
            ArrayList<Action> arrayList2 = this.f5457a.f5383b;
            int i2 = 2;
            if (arrayList2 != null) {
                for (Action next : arrayList2) {
                    if (next.l()) {
                        arrayList.add(next);
                    } else if (!F(next) && i2 > 1) {
                        arrayList.add(next);
                        i2--;
                    }
                    if (H != null && i2 == 1) {
                        arrayList.add(H);
                        i2--;
                    }
                }
            }
            if (H != null && i2 >= 1) {
                arrayList.add(H);
            }
            return arrayList;
        }

        @NonNull
        public CallStyle J(@ColorInt int i2) {
            this.f5402k = Integer.valueOf(i2);
            return this;
        }

        @NonNull
        public CallStyle K(@ColorInt int i2) {
            this.f5403l = Integer.valueOf(i2);
            return this;
        }

        @NonNull
        public CallStyle L(boolean z) {
            this.f5401j = z;
            return this;
        }

        @NonNull
        public CallStyle M(@Nullable Bitmap bitmap) {
            this.f5404m = IconCompat.s(bitmap);
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public CallStyle N(@Nullable Icon icon) {
            this.f5404m = icon == null ? null : IconCompat.m(icon);
            return this;
        }

        @NonNull
        public CallStyle O(@Nullable CharSequence charSequence) {
            this.f5405n = charSequence;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void a(@NonNull Bundle bundle) {
            String str;
            Parcelable K;
            String str2;
            Parcelable m2;
            super.a(bundle);
            bundle.putInt(NotificationCompat.l0, this.f5396e);
            bundle.putBoolean(NotificationCompat.m0, this.f5401j);
            Person person = this.f5397f;
            if (person != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    m2 = Api28Impl.b(person.k());
                    str2 = NotificationCompat.n0;
                } else {
                    str2 = NotificationCompat.o0;
                    m2 = person.m();
                }
                bundle.putParcelable(str2, m2);
            }
            IconCompat iconCompat = this.f5404m;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    K = Api23Impl.a(iconCompat.M(this.f5457a.f5382a));
                    str = NotificationCompat.p0;
                } else {
                    str = NotificationCompat.q0;
                    K = iconCompat.K();
                }
                bundle.putParcelable(str, K);
            }
            bundle.putCharSequence(NotificationCompat.r0, this.f5405n);
            bundle.putParcelable(NotificationCompat.s0, this.f5398g);
            bundle.putParcelable(NotificationCompat.t0, this.f5399h);
            bundle.putParcelable(NotificationCompat.u0, this.f5400i);
            Integer num = this.f5402k;
            if (num != null) {
                bundle.putInt(NotificationCompat.v0, num.intValue());
            }
            Integer num2 = this.f5403l;
            if (num2 != null) {
                bundle.putInt(NotificationCompat.w0, num2.intValue());
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i2 = Build.VERSION.SDK_INT;
            Notification.CallStyle callStyle = null;
            if (i2 >= 31) {
                int i3 = this.f5396e;
                if (i3 == 1) {
                    callStyle = Api31Impl.a(this.f5397f.k(), this.f5399h, this.f5398g);
                } else if (i3 == 2) {
                    callStyle = Api31Impl.b(this.f5397f.k(), this.f5400i);
                } else if (i3 == 3) {
                    callStyle = Api31Impl.c(this.f5397f.k(), this.f5400i, this.f5398g);
                } else if (Log.isLoggable(NotificationCompat.f5307a, 3)) {
                    Log.d(NotificationCompat.f5307a, "Unrecognized call type in CallStyle: " + String.valueOf(this.f5396e));
                }
                if (callStyle != null) {
                    callStyle.setBuilder(notificationBuilderWithBuilderAccessor.a());
                    Integer num = this.f5402k;
                    if (num != null) {
                        Api31Impl.d(callStyle, num.intValue());
                    }
                    Integer num2 = this.f5403l;
                    if (num2 != null) {
                        Api31Impl.f(callStyle, num2.intValue());
                    }
                    Api31Impl.i(callStyle, this.f5405n);
                    IconCompat iconCompat = this.f5404m;
                    if (iconCompat != null) {
                        Api31Impl.h(callStyle, iconCompat.M(this.f5457a.f5382a));
                    }
                    Api31Impl.g(callStyle, this.f5401j);
                    return;
                }
                return;
            }
            Notification.Builder a2 = notificationBuilderWithBuilderAccessor.a();
            Person person = this.f5397f;
            a2.setContentTitle(person != null ? person.f() : null);
            Bundle bundle = this.f5457a.E;
            if (bundle != null && bundle.containsKey(NotificationCompat.D)) {
                callStyle = this.f5457a.E.getCharSequence(NotificationCompat.D);
            }
            if (callStyle == null) {
                callStyle = E();
            }
            a2.setContentText(callStyle);
            Person person2 = this.f5397f;
            if (person2 != null) {
                if (i2 >= 23 && person2.d() != null) {
                    Api23Impl.c(a2, this.f5397f.d().M(this.f5457a.f5382a));
                }
                if (i2 >= 28) {
                    Api28Impl.a(a2, this.f5397f.k());
                } else {
                    Api21Impl.a(a2, this.f5397f.g());
                }
            }
            Api21Impl.b(a2, NotificationCompat.E0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean r() {
            return true;
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String t() {
            return o;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x004d  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b0  */
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void y(@androidx.annotation.NonNull android.os.Bundle r4) {
            /*
                r3 = this;
                super.y(r4)
                java.lang.String r0 = "android.callType"
                int r0 = r4.getInt(r0)
                r3.f5396e = r0
                java.lang.String r0 = "android.callIsVideo"
                boolean r0 = r4.getBoolean(r0)
                r3.f5401j = r0
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 28
                if (r0 < r1) goto L_0x0030
                java.lang.String r1 = "android.callPerson"
                boolean r2 = r4.containsKey(r1)
                if (r2 == 0) goto L_0x0030
                android.os.Parcelable r1 = r4.getParcelable(r1)
                android.app.Person r1 = androidx.core.app.j.a(r1)
                androidx.core.app.Person r1 = androidx.core.app.Person.a(r1)
            L_0x002d:
                r3.f5397f = r1
                goto L_0x0041
            L_0x0030:
                java.lang.String r1 = "android.callPersonCompat"
                boolean r2 = r4.containsKey(r1)
                if (r2 == 0) goto L_0x0041
                android.os.Bundle r1 = r4.getBundle(r1)
                androidx.core.app.Person r1 = androidx.core.app.Person.b(r1)
                goto L_0x002d
            L_0x0041:
                r1 = 23
                if (r0 < r1) goto L_0x005c
                java.lang.String r0 = "android.verificationIcon"
                boolean r1 = r4.containsKey(r0)
                if (r1 == 0) goto L_0x005c
                android.os.Parcelable r0 = r4.getParcelable(r0)
                android.graphics.drawable.Icon r0 = androidx.core.app.l.a(r0)
                androidx.core.graphics.drawable.IconCompat r0 = androidx.core.graphics.drawable.IconCompat.m(r0)
            L_0x0059:
                r3.f5404m = r0
                goto L_0x006d
            L_0x005c:
                java.lang.String r0 = "android.verificationIconCompat"
                boolean r1 = r4.containsKey(r0)
                if (r1 == 0) goto L_0x006d
                android.os.Bundle r0 = r4.getBundle(r0)
                androidx.core.graphics.drawable.IconCompat r0 = androidx.core.graphics.drawable.IconCompat.k(r0)
                goto L_0x0059
            L_0x006d:
                java.lang.String r0 = "android.verificationText"
                java.lang.CharSequence r0 = r4.getCharSequence(r0)
                r3.f5405n = r0
                java.lang.String r0 = "android.answerIntent"
                android.os.Parcelable r0 = r4.getParcelable(r0)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
                r3.f5398g = r0
                java.lang.String r0 = "android.declineIntent"
                android.os.Parcelable r0 = r4.getParcelable(r0)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
                r3.f5399h = r0
                java.lang.String r0 = "android.hangUpIntent"
                android.os.Parcelable r0 = r4.getParcelable(r0)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
                r3.f5400i = r0
                java.lang.String r0 = "android.answerColor"
                boolean r1 = r4.containsKey(r0)
                r2 = 0
                if (r1 == 0) goto L_0x00a5
                int r0 = r4.getInt(r0)
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x00a6
            L_0x00a5:
                r0 = r2
            L_0x00a6:
                r3.f5402k = r0
                java.lang.String r0 = "android.declineColor"
                boolean r1 = r4.containsKey(r0)
                if (r1 == 0) goto L_0x00b8
                int r4 = r4.getInt(r0)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            L_0x00b8:
                r3.f5403l = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.CallStyle.y(android.os.Bundle):void");
        }

        private CallStyle(int i2, @NonNull Person person, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3) {
            if (person == null || TextUtils.isEmpty(person.f())) {
                throw new IllegalArgumentException("person must have a non-empty a name");
            }
            this.f5396e = i2;
            this.f5397f = person;
            this.f5398g = pendingIntent3;
            this.f5399h = pendingIntent2;
            this.f5400i = pendingIntent;
        }

        public CallStyle(@Nullable Builder builder) {
            z(builder);
        }
    }

    public static final class CarExtender implements Extender {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: d  reason: collision with root package name */
        static final String f5406d = "android.car.EXTENSIONS";

        /* renamed from: e  reason: collision with root package name */
        private static final String f5407e = "large_icon";

        /* renamed from: f  reason: collision with root package name */
        private static final String f5408f = "car_conversation";

        /* renamed from: g  reason: collision with root package name */
        private static final String f5409g = "app_color";
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: h  reason: collision with root package name */
        static final String f5410h = "invisible_actions";

        /* renamed from: i  reason: collision with root package name */
        private static final String f5411i = "author";

        /* renamed from: j  reason: collision with root package name */
        private static final String f5412j = "text";

        /* renamed from: k  reason: collision with root package name */
        private static final String f5413k = "messages";

        /* renamed from: l  reason: collision with root package name */
        private static final String f5414l = "remote_input";

        /* renamed from: m  reason: collision with root package name */
        private static final String f5415m = "on_reply";

        /* renamed from: n  reason: collision with root package name */
        private static final String f5416n = "on_read";
        private static final String o = "participants";
        private static final String p = "timestamp";

        /* renamed from: a  reason: collision with root package name */
        private Bitmap f5417a;

        /* renamed from: b  reason: collision with root package name */
        private UnreadConversation f5418b;

        /* renamed from: c  reason: collision with root package name */
        private int f5419c = 0;

        @RequiresApi(20)
        static class Api20Impl {
            private Api20Impl() {
            }

            @DoNotInline
            static RemoteInput.Builder a(RemoteInput.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            @DoNotInline
            static RemoteInput b(RemoteInput.Builder builder) {
                return builder.build();
            }

            @DoNotInline
            static Parcelable c(RemoteInput remoteInput) {
                return remoteInput;
            }

            @DoNotInline
            static RemoteInput.Builder d(String str) {
                return new RemoteInput.Builder(str);
            }

            @DoNotInline
            static boolean e(RemoteInput remoteInput) {
                return remoteInput.getAllowFreeFormInput();
            }

            @DoNotInline
            static CharSequence[] f(RemoteInput remoteInput) {
                return remoteInput.getChoices();
            }

            @DoNotInline
            static Bundle g(RemoteInput remoteInput) {
                return remoteInput.getExtras();
            }

            @DoNotInline
            static CharSequence h(RemoteInput remoteInput) {
                return remoteInput.getLabel();
            }

            @DoNotInline
            static String i(RemoteInput remoteInput) {
                return remoteInput.getResultKey();
            }

            @DoNotInline
            static RemoteInput.Builder j(RemoteInput.Builder builder, boolean z) {
                return builder.setAllowFreeFormInput(z);
            }

            @DoNotInline
            static RemoteInput.Builder k(RemoteInput.Builder builder, CharSequence[] charSequenceArr) {
                return builder.setChoices(charSequenceArr);
            }

            @DoNotInline
            static RemoteInput.Builder l(RemoteInput.Builder builder, CharSequence charSequence) {
                return builder.setLabel(charSequence);
            }
        }

        @RequiresApi(29)
        static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            static int a(RemoteInput remoteInput) {
                return remoteInput.getEditChoicesBeforeSending();
            }
        }

        @Deprecated
        public static class UnreadConversation {

            /* renamed from: a  reason: collision with root package name */
            private final String[] f5420a;

            /* renamed from: b  reason: collision with root package name */
            private final RemoteInput f5421b;

            /* renamed from: c  reason: collision with root package name */
            private final PendingIntent f5422c;

            /* renamed from: d  reason: collision with root package name */
            private final PendingIntent f5423d;

            /* renamed from: e  reason: collision with root package name */
            private final String[] f5424e;

            /* renamed from: f  reason: collision with root package name */
            private final long f5425f;

            public static class Builder {

                /* renamed from: a  reason: collision with root package name */
                private final List<String> f5426a = new ArrayList();

                /* renamed from: b  reason: collision with root package name */
                private final String f5427b;

                /* renamed from: c  reason: collision with root package name */
                private RemoteInput f5428c;

                /* renamed from: d  reason: collision with root package name */
                private PendingIntent f5429d;

                /* renamed from: e  reason: collision with root package name */
                private PendingIntent f5430e;

                /* renamed from: f  reason: collision with root package name */
                private long f5431f;

                public Builder(@NonNull String str) {
                    this.f5427b = str;
                }

                @NonNull
                public Builder a(@Nullable String str) {
                    if (str != null) {
                        this.f5426a.add(str);
                    }
                    return this;
                }

                @NonNull
                public UnreadConversation b() {
                    List<String> list = this.f5426a;
                    return new UnreadConversation((String[]) list.toArray(new String[list.size()]), this.f5428c, this.f5430e, this.f5429d, new String[]{this.f5427b}, this.f5431f);
                }

                @NonNull
                public Builder c(long j2) {
                    this.f5431f = j2;
                    return this;
                }

                @NonNull
                public Builder d(@Nullable PendingIntent pendingIntent) {
                    this.f5429d = pendingIntent;
                    return this;
                }

                @NonNull
                public Builder e(@Nullable PendingIntent pendingIntent, @Nullable RemoteInput remoteInput) {
                    this.f5428c = remoteInput;
                    this.f5430e = pendingIntent;
                    return this;
                }
            }

            UnreadConversation(@Nullable String[] strArr, @Nullable RemoteInput remoteInput, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable String[] strArr2, long j2) {
                this.f5420a = strArr;
                this.f5421b = remoteInput;
                this.f5423d = pendingIntent2;
                this.f5422c = pendingIntent;
                this.f5424e = strArr2;
                this.f5425f = j2;
            }

            public long a() {
                return this.f5425f;
            }

            @Nullable
            public String[] b() {
                return this.f5420a;
            }

            @Nullable
            public String c() {
                String[] strArr = this.f5424e;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            @Nullable
            public String[] d() {
                return this.f5424e;
            }

            @Nullable
            public PendingIntent e() {
                return this.f5423d;
            }

            @Nullable
            public RemoteInput f() {
                return this.f5421b;
            }

            @Nullable
            public PendingIntent g() {
                return this.f5422c;
            }
        }

        public CarExtender() {
        }

        @RequiresApi(21)
        private static Bundle b(@NonNull UnreadConversation unreadConversation) {
            Bundle bundle = new Bundle();
            String str = (unreadConversation.d() == null || unreadConversation.d().length <= 1) ? null : unreadConversation.d()[0];
            int length = unreadConversation.b().length;
            Parcelable[] parcelableArr = new Parcelable[length];
            for (int i2 = 0; i2 < length; i2++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", unreadConversation.b()[i2]);
                bundle2.putString("author", str);
                parcelableArr[i2] = bundle2;
            }
            bundle.putParcelableArray(f5413k, parcelableArr);
            RemoteInput f2 = unreadConversation.f();
            if (f2 != null) {
                RemoteInput.Builder d2 = Api20Impl.d(f2.o());
                Api20Impl.l(d2, f2.n());
                Api20Impl.k(d2, f2.h());
                Api20Impl.j(d2, f2.f());
                Api20Impl.a(d2, f2.m());
                bundle.putParcelable(f5414l, Api20Impl.c(Api20Impl.b(d2)));
            }
            bundle.putParcelable(f5415m, unreadConversation.g());
            bundle.putParcelable(f5416n, unreadConversation.e());
            bundle.putStringArray(o, unreadConversation.d());
            bundle.putLong(p, unreadConversation.a());
            return bundle;
        }

        @RequiresApi(21)
        private static UnreadConversation f(@Nullable Bundle bundle) {
            String[] strArr;
            Bundle bundle2 = bundle;
            RemoteInput remoteInput = null;
            if (bundle2 == null) {
                return null;
            }
            Parcelable[] parcelableArray = bundle2.getParcelableArray(f5413k);
            if (parcelableArray != null) {
                int length = parcelableArray.length;
                String[] strArr2 = new String[length];
                int i2 = 0;
                while (i2 < length) {
                    Parcelable parcelable = parcelableArray[i2];
                    if (parcelable instanceof Bundle) {
                        String string = ((Bundle) parcelable).getString("text");
                        strArr2[i2] = string;
                        if (string != null) {
                            i2++;
                        }
                    }
                    return null;
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle2.getParcelable(f5416n);
            PendingIntent pendingIntent2 = (PendingIntent) bundle2.getParcelable(f5415m);
            RemoteInput remoteInput2 = (RemoteInput) bundle2.getParcelable(f5414l);
            String[] stringArray = bundle2.getStringArray(o);
            if (stringArray == null || stringArray.length != 1) {
                return null;
            }
            if (remoteInput2 != null) {
                remoteInput = new RemoteInput(Api20Impl.i(remoteInput2), Api20Impl.h(remoteInput2), Api20Impl.f(remoteInput2), Api20Impl.e(remoteInput2), Build.VERSION.SDK_INT >= 29 ? Api29Impl.a(remoteInput2) : 0, Api20Impl.g(remoteInput2), (Set<String>) null);
            }
            return new UnreadConversation(strArr, remoteInput, pendingIntent2, pendingIntent, stringArray, bundle2.getLong(p));
        }

        @NonNull
        public Builder a(@NonNull Builder builder) {
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.f5417a;
            if (bitmap != null) {
                bundle.putParcelable(f5407e, bitmap);
            }
            int i2 = this.f5419c;
            if (i2 != 0) {
                bundle.putInt(f5409g, i2);
            }
            UnreadConversation unreadConversation = this.f5418b;
            if (unreadConversation != null) {
                bundle.putBundle(f5408f, b(unreadConversation));
            }
            builder.t().putBundle(f5406d, bundle);
            return builder;
        }

        @ColorInt
        public int c() {
            return this.f5419c;
        }

        @Nullable
        public Bitmap d() {
            return this.f5417a;
        }

        @Deprecated
        @Nullable
        public UnreadConversation e() {
            return this.f5418b;
        }

        @NonNull
        public CarExtender g(@ColorInt int i2) {
            this.f5419c = i2;
            return this;
        }

        @NonNull
        public CarExtender h(@Nullable Bitmap bitmap) {
            this.f5417a = bitmap;
            return this;
        }

        @NonNull
        @Deprecated
        public CarExtender i(@Nullable UnreadConversation unreadConversation) {
            this.f5418b = unreadConversation;
            return this;
        }

        public CarExtender(@NonNull Notification notification) {
            Bundle bundle = NotificationCompat.n(notification) == null ? null : NotificationCompat.n(notification).getBundle(f5406d);
            if (bundle != null) {
                this.f5417a = (Bitmap) bundle.getParcelable(f5407e);
                this.f5419c = bundle.getInt(f5409g, 0);
                this.f5418b = f(bundle.getBundle(f5408f));
            }
        }
    }

    public static class DecoratedCustomViewStyle extends Style {

        /* renamed from: e  reason: collision with root package name */
        private static final String f5432e = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        /* renamed from: f  reason: collision with root package name */
        private static final int f5433f = 3;

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        private RemoteViews A(RemoteViews remoteViews, boolean z) {
            int min;
            int i2 = 0;
            RemoteViews c2 = c(true, R.layout.f5165f, false);
            c2.removeAllViews(R.id.L);
            List<Action> C = C(this.f5457a.f5383b);
            if (!z || C == null || (min = Math.min(C.size(), 3)) <= 0) {
                i2 = 8;
            } else {
                for (int i3 = 0; i3 < min; i3++) {
                    c2.addView(R.id.L, B(C.get(i3)));
                }
            }
            c2.setViewVisibility(R.id.L, i2);
            c2.setViewVisibility(R.id.I, i2);
            e(c2, remoteViews);
            return c2;
        }

        private RemoteViews B(Action action) {
            boolean z = action.f5333k == null;
            RemoteViews remoteViews = new RemoteViews(this.f5457a.f5382a.getPackageName(), z ? R.layout.f5164e : R.layout.f5163d);
            IconCompat f2 = action.f();
            if (f2 != null) {
                remoteViews.setImageViewBitmap(R.id.J, o(f2, R.color.f5115e));
            }
            remoteViews.setTextViewText(R.id.K, action.f5332j);
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.H, action.f5333k);
            }
            remoteViews.setContentDescription(R.id.H, action.f5332j);
            return remoteViews;
        }

        private static List<Action> C(List<Action> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Action next : list) {
                if (!next.l()) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.a().setStyle(Api24Impl.a());
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean r() {
            return true;
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String t() {
            return f5432e;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews v(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews p = this.f5457a.p();
            if (p == null) {
                p = this.f5457a.s();
            }
            if (p == null) {
                return null;
            }
            return A(p, true);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews w(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT < 24 && this.f5457a.s() != null) {
                return A(this.f5457a.s(), false);
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews x(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews w = this.f5457a.w();
            RemoteViews s = w != null ? w : this.f5457a.s();
            if (w == null) {
                return null;
            }
            return A(s, true);
        }
    }

    public interface Extender {
        @NonNull
        Builder a(@NonNull Builder builder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends Style {

        /* renamed from: f  reason: collision with root package name */
        private static final String f5434f = "androidx.core.app.NotificationCompat$InboxStyle";

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<CharSequence> f5435e = new ArrayList<>();

        public InboxStyle() {
        }

        @NonNull
        public InboxStyle A(@Nullable CharSequence charSequence) {
            if (charSequence != null) {
                this.f5435e.add(Builder.A(charSequence));
            }
            return this;
        }

        @NonNull
        public InboxStyle B(@Nullable CharSequence charSequence) {
            this.f5458b = Builder.A(charSequence);
            return this;
        }

        @NonNull
        public InboxStyle C(@Nullable CharSequence charSequence) {
            this.f5459c = Builder.A(charSequence);
            this.f5460d = true;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.f5458b);
            if (this.f5460d) {
                bigContentTitle.setSummaryText(this.f5459c);
            }
            Iterator<CharSequence> it2 = this.f5435e.iterator();
            while (it2.hasNext()) {
                bigContentTitle.addLine(it2.next());
            }
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void g(@NonNull Bundle bundle) {
            super.g(bundle);
            bundle.remove(NotificationCompat.X);
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String t() {
            return f5434f;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@NonNull Bundle bundle) {
            super.y(bundle);
            this.f5435e.clear();
            if (bundle.containsKey(NotificationCompat.X)) {
                Collections.addAll(this.f5435e, bundle.getCharSequenceArray(NotificationCompat.X));
            }
        }

        public InboxStyle(@Nullable Builder builder) {
            z(builder);
        }
    }

    public static class MessagingStyle extends Style {

        /* renamed from: j  reason: collision with root package name */
        private static final String f5436j = "androidx.core.app.NotificationCompat$MessagingStyle";

        /* renamed from: k  reason: collision with root package name */
        public static final int f5437k = 25;

        /* renamed from: e  reason: collision with root package name */
        private final List<Message> f5438e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        private final List<Message> f5439f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        private Person f5440g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private CharSequence f5441h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private Boolean f5442i;

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            @DoNotInline
            static Notification.MessagingStyle b(CharSequence charSequence) {
                return new Notification.MessagingStyle(charSequence);
            }

            @DoNotInline
            static Notification.MessagingStyle c(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        @RequiresApi(26)
        static class Api26Impl {
            private Api26Impl() {
            }

            @DoNotInline
            static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        @RequiresApi(28)
        static class Api28Impl {
            private Api28Impl() {
            }

            @DoNotInline
            static Notification.MessagingStyle a(Person person) {
                return new Notification.MessagingStyle(person);
            }

            @DoNotInline
            static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z) {
                return messagingStyle.setGroupConversation(z);
            }
        }

        public static final class Message {

            /* renamed from: g  reason: collision with root package name */
            static final String f5443g = "text";

            /* renamed from: h  reason: collision with root package name */
            static final String f5444h = "time";

            /* renamed from: i  reason: collision with root package name */
            static final String f5445i = "sender";

            /* renamed from: j  reason: collision with root package name */
            static final String f5446j = "type";

            /* renamed from: k  reason: collision with root package name */
            static final String f5447k = "uri";

            /* renamed from: l  reason: collision with root package name */
            static final String f5448l = "extras";

            /* renamed from: m  reason: collision with root package name */
            static final String f5449m = "person";

            /* renamed from: n  reason: collision with root package name */
            static final String f5450n = "sender_person";

            /* renamed from: a  reason: collision with root package name */
            private final CharSequence f5451a;

            /* renamed from: b  reason: collision with root package name */
            private final long f5452b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private final Person f5453c;

            /* renamed from: d  reason: collision with root package name */
            private Bundle f5454d;
            @Nullable

            /* renamed from: e  reason: collision with root package name */
            private String f5455e;
            @Nullable

            /* renamed from: f  reason: collision with root package name */
            private Uri f5456f;

            @RequiresApi(24)
            static class Api24Impl {
                private Api24Impl() {
                }

                @DoNotInline
                static Notification.MessagingStyle.Message a(CharSequence charSequence, long j2, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j2, charSequence2);
                }

                @DoNotInline
                static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            @RequiresApi(28)
            static class Api28Impl {
                private Api28Impl() {
                }

                @DoNotInline
                static Parcelable a(Person person) {
                    return person;
                }

                @DoNotInline
                static Notification.MessagingStyle.Message b(CharSequence charSequence, long j2, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j2, person);
                }
            }

            public Message(@Nullable CharSequence charSequence, long j2, @Nullable Person person) {
                this.f5454d = new Bundle();
                this.f5451a = charSequence;
                this.f5452b = j2;
                this.f5453c = person;
            }

            @NonNull
            static Bundle[] a(@NonNull List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bundleArr[i2] = list.get(i2).m();
                }
                return bundleArr;
            }

            @Nullable
            static Message e(@NonNull Bundle bundle) {
                try {
                    if (bundle.containsKey("text")) {
                        if (bundle.containsKey("time")) {
                            Message message = new Message(bundle.getCharSequence("text"), bundle.getLong("time"), bundle.containsKey(f5449m) ? Person.b(bundle.getBundle(f5449m)) : (!bundle.containsKey(f5450n) || Build.VERSION.SDK_INT < 28) ? bundle.containsKey(f5445i) ? new Person.Builder().f(bundle.getCharSequence(f5445i)).a() : null : Person.a(j.a(bundle.getParcelable(f5450n))));
                            if (bundle.containsKey("type") && bundle.containsKey(f5447k)) {
                                message.k(bundle.getString("type"), (Uri) bundle.getParcelable(f5447k));
                            }
                            if (bundle.containsKey(f5448l)) {
                                message.d().putAll(bundle.getBundle(f5448l));
                            }
                            return message;
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @NonNull
            static List<Message> f(@NonNull Parcelable[] parcelableArr) {
                Message e2;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (Bundle bundle : parcelableArr) {
                    if ((bundle instanceof Bundle) && (e2 = e(bundle)) != null) {
                        arrayList.add(e2);
                    }
                }
                return arrayList;
            }

            @NonNull
            private Bundle m() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f5451a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.f5452b);
                Person person = this.f5453c;
                if (person != null) {
                    bundle.putCharSequence(f5445i, person.f());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable(f5450n, Api28Impl.a(this.f5453c.k()));
                    } else {
                        bundle.putBundle(f5449m, this.f5453c.m());
                    }
                }
                String str = this.f5455e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f5456f;
                if (uri != null) {
                    bundle.putParcelable(f5447k, uri);
                }
                Bundle bundle2 = this.f5454d;
                if (bundle2 != null) {
                    bundle.putBundle(f5448l, bundle2);
                }
                return bundle;
            }

            @Nullable
            public String b() {
                return this.f5455e;
            }

            @Nullable
            public Uri c() {
                return this.f5456f;
            }

            @NonNull
            public Bundle d() {
                return this.f5454d;
            }

            @Nullable
            public Person g() {
                return this.f5453c;
            }

            @Deprecated
            @Nullable
            public CharSequence h() {
                Person person = this.f5453c;
                if (person == null) {
                    return null;
                }
                return person.f();
            }

            @Nullable
            public CharSequence i() {
                return this.f5451a;
            }

            public long j() {
                return this.f5452b;
            }

            @NonNull
            public Message k(@Nullable String str, @Nullable Uri uri) {
                this.f5455e = str;
                this.f5456f = uri;
                return this;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.app.Person} */
            /* JADX WARNING: type inference failed for: r3v0 */
            /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.CharSequence] */
            /* JADX WARNING: type inference failed for: r3v5 */
            /* JADX WARNING: type inference failed for: r3v6 */
            /* access modifiers changed from: package-private */
            /* JADX WARNING: Multi-variable type inference failed */
            @androidx.annotation.RequiresApi(24)
            @androidx.annotation.NonNull
            @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public android.app.Notification.MessagingStyle.Message l() {
                /*
                    r6 = this;
                    androidx.core.app.Person r0 = r6.g()
                    int r1 = android.os.Build.VERSION.SDK_INT
                    r2 = 28
                    r3 = 0
                    if (r1 < r2) goto L_0x001f
                    java.lang.CharSequence r1 = r6.i()
                    long r4 = r6.j()
                    if (r0 != 0) goto L_0x0016
                    goto L_0x001a
                L_0x0016:
                    android.app.Person r3 = r0.k()
                L_0x001a:
                    android.app.Notification$MessagingStyle$Message r0 = androidx.core.app.NotificationCompat.MessagingStyle.Message.Api28Impl.b(r1, r4, r3)
                    goto L_0x0032
                L_0x001f:
                    java.lang.CharSequence r1 = r6.i()
                    long r4 = r6.j()
                    if (r0 != 0) goto L_0x002a
                    goto L_0x002e
                L_0x002a:
                    java.lang.CharSequence r3 = r0.f()
                L_0x002e:
                    android.app.Notification$MessagingStyle$Message r0 = androidx.core.app.NotificationCompat.MessagingStyle.Message.Api24Impl.a(r1, r4, r3)
                L_0x0032:
                    java.lang.String r1 = r6.b()
                    if (r1 == 0) goto L_0x0043
                    java.lang.String r1 = r6.b()
                    android.net.Uri r2 = r6.c()
                    androidx.core.app.NotificationCompat.MessagingStyle.Message.Api24Impl.b(r0, r1, r2)
                L_0x0043:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.MessagingStyle.Message.l():android.app.Notification$MessagingStyle$Message");
            }

            @Deprecated
            public Message(@Nullable CharSequence charSequence, long j2, @Nullable CharSequence charSequence2) {
                this(charSequence, j2, new Person.Builder().f(charSequence2).a());
            }
        }

        MessagingStyle() {
        }

        @Nullable
        public static MessagingStyle E(@NonNull Notification notification) {
            Style s = Style.s(notification);
            if (s instanceof MessagingStyle) {
                return (MessagingStyle) s;
            }
            return null;
        }

        @Nullable
        private Message F() {
            for (int size = this.f5438e.size() - 1; size >= 0; size--) {
                Message message = this.f5438e.get(size);
                if (message.g() != null && !TextUtils.isEmpty(message.g().f())) {
                    return message;
                }
            }
            if (this.f5438e.isEmpty()) {
                return null;
            }
            List<Message> list = this.f5438e;
            return list.get(list.size() - 1);
        }

        private boolean L() {
            for (int size = this.f5438e.size() - 1; size >= 0; size--) {
                Message message = this.f5438e.get(size);
                if (message.g() != null && message.g().f() == null) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        private TextAppearanceSpan N(int i2) {
            return new TextAppearanceSpan((String) null, 0, 0, ColorStateList.valueOf(i2), (ColorStateList) null);
        }

        private CharSequence O(@NonNull Message message) {
            BidiFormatter c2 = BidiFormatter.c();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            CharSequence charSequence = "";
            CharSequence f2 = message.g() == null ? charSequence : message.g().f();
            boolean isEmpty = TextUtils.isEmpty(f2);
            int i2 = ViewCompat.y;
            if (isEmpty) {
                f2 = this.f5440g.f();
                if (this.f5457a.r() != 0) {
                    i2 = this.f5457a.r();
                }
            }
            CharSequence m2 = c2.m(f2);
            spannableStringBuilder.append(m2);
            spannableStringBuilder.setSpan(N(i2), spannableStringBuilder.length() - m2.length(), spannableStringBuilder.length(), 33);
            if (message.i() != null) {
                charSequence = message.i();
            }
            spannableStringBuilder.append("  ").append(c2.m(charSequence));
            return spannableStringBuilder;
        }

        @NonNull
        public MessagingStyle A(@Nullable Message message) {
            if (message != null) {
                this.f5439f.add(message);
                if (this.f5439f.size() > 25) {
                    this.f5439f.remove(0);
                }
            }
            return this;
        }

        @NonNull
        public MessagingStyle B(@Nullable Message message) {
            if (message != null) {
                this.f5438e.add(message);
                if (this.f5438e.size() > 25) {
                    this.f5438e.remove(0);
                }
            }
            return this;
        }

        @NonNull
        public MessagingStyle C(@Nullable CharSequence charSequence, long j2, @Nullable Person person) {
            B(new Message(charSequence, j2, person));
            return this;
        }

        @NonNull
        @Deprecated
        public MessagingStyle D(@Nullable CharSequence charSequence, long j2, @Nullable CharSequence charSequence2) {
            this.f5438e.add(new Message(charSequence, j2, new Person.Builder().f(charSequence2).a()));
            if (this.f5438e.size() > 25) {
                this.f5438e.remove(0);
            }
            return this;
        }

        @Nullable
        public CharSequence G() {
            return this.f5441h;
        }

        @NonNull
        public List<Message> H() {
            return this.f5439f;
        }

        @NonNull
        public List<Message> I() {
            return this.f5438e;
        }

        @NonNull
        public Person J() {
            return this.f5440g;
        }

        @Deprecated
        @Nullable
        public CharSequence K() {
            return this.f5440g.f();
        }

        public boolean M() {
            Builder builder = this.f5457a;
            if (builder != null && builder.f5382a.getApplicationInfo().targetSdkVersion < 28 && this.f5442i == null) {
                return this.f5441h != null;
            }
            Boolean bool = this.f5442i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        @NonNull
        public MessagingStyle P(@Nullable CharSequence charSequence) {
            this.f5441h = charSequence;
            return this;
        }

        @NonNull
        public MessagingStyle Q(boolean z) {
            this.f5442i = Boolean.valueOf(z);
            return this;
        }

        public void a(@NonNull Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence(NotificationCompat.f0, this.f5440g.f());
            bundle.putBundle(NotificationCompat.g0, this.f5440g.m());
            bundle.putCharSequence(NotificationCompat.x0, this.f5441h);
            if (this.f5441h != null && this.f5442i.booleanValue()) {
                bundle.putCharSequence(NotificationCompat.h0, this.f5441h);
            }
            if (!this.f5438e.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.i0, Message.a(this.f5438e));
            }
            if (!this.f5439f.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.j0, Message.a(this.f5439f));
            }
            Boolean bool = this.f5442i;
            if (bool != null) {
                bundle.putBoolean(NotificationCompat.k0, bool.booleanValue());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00f7  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00f9  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0103  */
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(androidx.core.app.NotificationBuilderWithBuilderAccessor r8) {
            /*
                r7 = this;
                boolean r0 = r7.M()
                r7.Q(r0)
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 24
                if (r0 < r1) goto L_0x0097
                r1 = 28
                if (r0 < r1) goto L_0x001c
                androidx.core.app.Person r0 = r7.f5440g
                android.app.Person r0 = r0.k()
                android.app.Notification$MessagingStyle r0 = androidx.core.app.NotificationCompat.MessagingStyle.Api28Impl.a(r0)
                goto L_0x0026
            L_0x001c:
                androidx.core.app.Person r0 = r7.f5440g
                java.lang.CharSequence r0 = r0.f()
                android.app.Notification$MessagingStyle r0 = androidx.core.app.NotificationCompat.MessagingStyle.Api24Impl.b(r0)
            L_0x0026:
                java.util.List<androidx.core.app.NotificationCompat$MessagingStyle$Message> r2 = r7.f5438e
                java.util.Iterator r2 = r2.iterator()
            L_0x002c:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x0044
                java.lang.Object r3 = r2.next()
                androidx.core.app.NotificationCompat$MessagingStyle$Message r3 = (androidx.core.app.NotificationCompat.MessagingStyle.Message) r3
                android.app.Notification$MessagingStyle r4 = androidx.core.app.n.a(r0)
                android.app.Notification$MessagingStyle$Message r3 = r3.l()
                androidx.core.app.NotificationCompat.MessagingStyle.Api24Impl.a(r4, r3)
                goto L_0x002c
            L_0x0044:
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 26
                if (r2 < r3) goto L_0x0068
                java.util.List<androidx.core.app.NotificationCompat$MessagingStyle$Message> r2 = r7.f5439f
                java.util.Iterator r2 = r2.iterator()
            L_0x0050:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x0068
                java.lang.Object r3 = r2.next()
                androidx.core.app.NotificationCompat$MessagingStyle$Message r3 = (androidx.core.app.NotificationCompat.MessagingStyle.Message) r3
                android.app.Notification$MessagingStyle r4 = androidx.core.app.n.a(r0)
                android.app.Notification$MessagingStyle$Message r3 = r3.l()
                androidx.core.app.NotificationCompat.MessagingStyle.Api26Impl.a(r4, r3)
                goto L_0x0050
            L_0x0068:
                java.lang.Boolean r2 = r7.f5442i
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L_0x0074
                int r2 = android.os.Build.VERSION.SDK_INT
                if (r2 < r1) goto L_0x007d
            L_0x0074:
                android.app.Notification$MessagingStyle r2 = androidx.core.app.n.a(r0)
                java.lang.CharSequence r3 = r7.f5441h
                androidx.core.app.NotificationCompat.MessagingStyle.Api24Impl.c(r2, r3)
            L_0x007d:
                int r2 = android.os.Build.VERSION.SDK_INT
                if (r2 < r1) goto L_0x008e
                android.app.Notification$MessagingStyle r1 = androidx.core.app.n.a(r0)
                java.lang.Boolean r2 = r7.f5442i
                boolean r2 = r2.booleanValue()
                androidx.core.app.NotificationCompat.MessagingStyle.Api28Impl.b(r1, r2)
            L_0x008e:
                android.app.Notification$Builder r8 = r8.a()
                r0.setBuilder(r8)
                goto L_0x013b
            L_0x0097:
                androidx.core.app.NotificationCompat$MessagingStyle$Message r0 = r7.F()
                java.lang.CharSequence r1 = r7.f5441h
                if (r1 == 0) goto L_0x00b1
                java.lang.Boolean r1 = r7.f5442i
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x00b1
                android.app.Notification$Builder r1 = r8.a()
                java.lang.CharSequence r2 = r7.f5441h
            L_0x00ad:
                r1.setContentTitle(r2)
                goto L_0x00cf
            L_0x00b1:
                if (r0 == 0) goto L_0x00cf
                android.app.Notification$Builder r1 = r8.a()
                java.lang.String r2 = ""
                r1.setContentTitle(r2)
                androidx.core.app.Person r1 = r0.g()
                if (r1 == 0) goto L_0x00cf
                android.app.Notification$Builder r1 = r8.a()
                androidx.core.app.Person r2 = r0.g()
                java.lang.CharSequence r2 = r2.f()
                goto L_0x00ad
            L_0x00cf:
                if (r0 == 0) goto L_0x00e5
                android.app.Notification$Builder r1 = r8.a()
                java.lang.CharSequence r2 = r7.f5441h
                if (r2 == 0) goto L_0x00de
                java.lang.CharSequence r0 = r7.O(r0)
                goto L_0x00e2
            L_0x00de:
                java.lang.CharSequence r0 = r0.i()
            L_0x00e2:
                r1.setContentText(r0)
            L_0x00e5:
                android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
                r0.<init>()
                java.lang.CharSequence r1 = r7.f5441h
                r2 = 1
                r3 = 0
                if (r1 != 0) goto L_0x00f9
                boolean r1 = r7.L()
                if (r1 == 0) goto L_0x00f7
                goto L_0x00f9
            L_0x00f7:
                r1 = 0
                goto L_0x00fa
            L_0x00f9:
                r1 = 1
            L_0x00fa:
                java.util.List<androidx.core.app.NotificationCompat$MessagingStyle$Message> r4 = r7.f5438e
                int r4 = r4.size()
                int r4 = r4 - r2
            L_0x0101:
                if (r4 < 0) goto L_0x012a
                java.util.List<androidx.core.app.NotificationCompat$MessagingStyle$Message> r5 = r7.f5438e
                java.lang.Object r5 = r5.get(r4)
                androidx.core.app.NotificationCompat$MessagingStyle$Message r5 = (androidx.core.app.NotificationCompat.MessagingStyle.Message) r5
                if (r1 == 0) goto L_0x0112
                java.lang.CharSequence r5 = r7.O(r5)
                goto L_0x0116
            L_0x0112:
                java.lang.CharSequence r5 = r5.i()
            L_0x0116:
                java.util.List<androidx.core.app.NotificationCompat$MessagingStyle$Message> r6 = r7.f5438e
                int r6 = r6.size()
                int r6 = r6 - r2
                if (r4 == r6) goto L_0x0124
                java.lang.String r6 = "\n"
                r0.insert(r3, r6)
            L_0x0124:
                r0.insert(r3, r5)
                int r4 = r4 + -1
                goto L_0x0101
            L_0x012a:
                android.app.Notification$Builder r8 = r8.a()
                android.app.Notification$BigTextStyle r1 = new android.app.Notification$BigTextStyle
                r1.<init>(r8)
                r8 = 0
                android.app.Notification$BigTextStyle r8 = r1.setBigContentTitle(r8)
                r8.bigText(r0)
            L_0x013b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.MessagingStyle.b(androidx.core.app.NotificationBuilderWithBuilderAccessor):void");
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void g(@NonNull Bundle bundle) {
            super.g(bundle);
            bundle.remove(NotificationCompat.g0);
            bundle.remove(NotificationCompat.f0);
            bundle.remove(NotificationCompat.h0);
            bundle.remove(NotificationCompat.x0);
            bundle.remove(NotificationCompat.i0);
            bundle.remove(NotificationCompat.j0);
            bundle.remove(NotificationCompat.k0);
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String t() {
            return f5436j;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@NonNull Bundle bundle) {
            super.y(bundle);
            this.f5438e.clear();
            this.f5440g = bundle.containsKey(NotificationCompat.g0) ? Person.b(bundle.getBundle(NotificationCompat.g0)) : new Person.Builder().f(bundle.getString(NotificationCompat.f0)).a();
            CharSequence charSequence = bundle.getCharSequence(NotificationCompat.h0);
            this.f5441h = charSequence;
            if (charSequence == null) {
                this.f5441h = bundle.getCharSequence(NotificationCompat.x0);
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.i0);
            if (parcelableArray != null) {
                this.f5438e.addAll(Message.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray(NotificationCompat.j0);
            if (parcelableArray2 != null) {
                this.f5439f.addAll(Message.f(parcelableArray2));
            }
            if (bundle.containsKey(NotificationCompat.k0)) {
                this.f5442i = Boolean.valueOf(bundle.getBoolean(NotificationCompat.k0));
            }
        }

        public MessagingStyle(@NonNull Person person) {
            if (!TextUtils.isEmpty(person.f())) {
                this.f5440g = person;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence charSequence) {
            this.f5440g = new Person.Builder().f(charSequence).a();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ServiceNotificationBehavior {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    public static abstract class Style {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: a  reason: collision with root package name */
        protected Builder f5457a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f5458b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f5459c;

        /* renamed from: d  reason: collision with root package name */
        boolean f5460d = false;

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static void a(RemoteViews remoteViews, int i2, boolean z) {
                remoteViews.setChronometerCountDown(i2, z);
            }
        }

        private int f() {
            Resources resources = this.f5457a.f5382a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.u);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.v);
            float h2 = (h(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - h2) * ((float) dimensionPixelSize)) + (h2 * ((float) dimensionPixelSize2)));
        }

        private static float h(float f2, float f3, float f4) {
            if (f2 < f3) {
                return f3;
            }
            return f2 > f4 ? f4 : f2;
        }

        @Nullable
        static Style i(@Nullable String str) {
            if (str == null) {
                return null;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -716705180:
                    if (str.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -171946061:
                    if (str.equals("androidx.core.app.NotificationCompat$BigPictureStyle")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 714386739:
                    if (str.equals("androidx.core.app.NotificationCompat$CallStyle")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 912942987:
                    if (str.equals("androidx.core.app.NotificationCompat$InboxStyle")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 919595044:
                    if (str.equals("androidx.core.app.NotificationCompat$BigTextStyle")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2090799565:
                    if (str.equals("androidx.core.app.NotificationCompat$MessagingStyle")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return new DecoratedCustomViewStyle();
                case 1:
                    return new BigPictureStyle();
                case 2:
                    return new CallStyle();
                case 3:
                    return new InboxStyle();
                case 4:
                    return new BigTextStyle();
                case 5:
                    return new MessagingStyle();
                default:
                    return null;
            }
        }

        @Nullable
        private static Style j(@Nullable String str) {
            if (str == null) {
                return null;
            }
            if (str.equals(Notification.BigPictureStyle.class.getName())) {
                return new BigPictureStyle();
            }
            if (str.equals(Notification.BigTextStyle.class.getName())) {
                return new BigTextStyle();
            }
            if (str.equals(Notification.InboxStyle.class.getName())) {
                return new InboxStyle();
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (str.equals(o.a().getName())) {
                    return new MessagingStyle();
                }
                if (str.equals(p.a().getName())) {
                    return new DecoratedCustomViewStyle();
                }
            }
            return null;
        }

        @Nullable
        static Style k(@NonNull Bundle bundle) {
            Style i2 = i(bundle.getString(NotificationCompat.Z));
            if (i2 != null) {
                return i2;
            }
            if (bundle.containsKey(NotificationCompat.f0) || bundle.containsKey(NotificationCompat.g0)) {
                return new MessagingStyle();
            }
            if (bundle.containsKey(NotificationCompat.T) || bundle.containsKey(NotificationCompat.U)) {
                return new BigPictureStyle();
            }
            if (bundle.containsKey(NotificationCompat.I)) {
                return new BigTextStyle();
            }
            if (bundle.containsKey(NotificationCompat.X)) {
                return new InboxStyle();
            }
            return bundle.containsKey(NotificationCompat.l0) ? new CallStyle() : j(bundle.getString(NotificationCompat.Y));
        }

        @Nullable
        static Style l(@NonNull Bundle bundle) {
            Style k2 = k(bundle);
            if (k2 == null) {
                return null;
            }
            try {
                k2.y(bundle);
                return k2;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        private Bitmap n(int i2, int i3, int i4) {
            return p(IconCompat.w(this.f5457a.f5382a, i2), i3, i4);
        }

        private Bitmap p(@NonNull IconCompat iconCompat, int i2, int i3) {
            Drawable F = iconCompat.F(this.f5457a.f5382a);
            int intrinsicWidth = i3 == 0 ? F.getIntrinsicWidth() : i3;
            if (i3 == 0) {
                i3 = F.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
            F.setBounds(0, 0, intrinsicWidth, i3);
            if (i2 != 0) {
                F.mutate().setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
            }
            F.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        private Bitmap q(int i2, int i3, int i4, int i5) {
            int i6 = R.drawable.f5144n;
            if (i5 == 0) {
                i5 = 0;
            }
            Bitmap n2 = n(i6, i5, i3);
            Canvas canvas = new Canvas(n2);
            Drawable mutate = this.f5457a.f5382a.getResources().getDrawable(i2).mutate();
            mutate.setFilterBitmap(true);
            int i7 = (i3 - i4) / 2;
            int i8 = i4 + i7;
            mutate.setBounds(i7, i7, i8, i8);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return n2;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Style s(@NonNull Notification notification) {
            Bundle n2 = NotificationCompat.n(notification);
            if (n2 == null) {
                return null;
            }
            return l(n2);
        }

        private void u(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R.id.v0, 8);
            remoteViews.setViewVisibility(R.id.t0, 8);
            remoteViews.setViewVisibility(R.id.s0, 8);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void a(@NonNull Bundle bundle) {
            if (this.f5460d) {
                bundle.putCharSequence(NotificationCompat.H, this.f5459c);
            }
            CharSequence charSequence = this.f5458b;
            if (charSequence != null) {
                bundle.putCharSequence(NotificationCompat.C, charSequence);
            }
            String t = t();
            if (t != null) {
                bundle.putString(NotificationCompat.Z, t);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x013a  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x017e  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0183  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0185  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x018f  */
        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.widget.RemoteViews c(boolean r13, int r14, boolean r15) {
            /*
                r12 = this;
                androidx.core.app.NotificationCompat$Builder r0 = r12.f5457a
                android.content.Context r0 = r0.f5382a
                android.content.res.Resources r0 = r0.getResources()
                android.widget.RemoteViews r7 = new android.widget.RemoteViews
                androidx.core.app.NotificationCompat$Builder r1 = r12.f5457a
                android.content.Context r1 = r1.f5382a
                java.lang.String r1 = r1.getPackageName()
                r7.<init>(r1, r14)
                androidx.core.app.NotificationCompat$Builder r14 = r12.f5457a
                r14.y()
                int r14 = android.os.Build.VERSION.SDK_INT
                androidx.core.app.NotificationCompat$Builder r1 = r12.f5457a
                androidx.core.graphics.drawable.IconCompat r2 = r1.f5391j
                r8 = 0
                if (r2 == 0) goto L_0x0064
                int r1 = androidx.core.R.id.T
                r7.setViewVisibility(r1, r8)
                androidx.core.app.NotificationCompat$Builder r2 = r12.f5457a
                androidx.core.graphics.drawable.IconCompat r2 = r2.f5391j
                android.graphics.Bitmap r2 = r12.o(r2, r8)
                r7.setImageViewBitmap(r1, r2)
                if (r13 == 0) goto L_0x0095
                androidx.core.app.NotificationCompat$Builder r13 = r12.f5457a
                android.app.Notification r13 = r13.U
                int r13 = r13.icon
                if (r13 == 0) goto L_0x0095
                int r13 = androidx.core.R.dimen.p
                int r13 = r0.getDimensionPixelSize(r13)
                int r1 = androidx.core.R.dimen.r
                int r1 = r0.getDimensionPixelSize(r1)
                int r1 = r1 * 2
                int r1 = r13 - r1
                androidx.core.app.NotificationCompat$Builder r2 = r12.f5457a
                android.app.Notification r3 = r2.U
                int r3 = r3.icon
                int r2 = r2.r()
                android.graphics.Bitmap r13 = r12.q(r3, r13, r1, r2)
                int r1 = androidx.core.R.id.d0
                r7.setImageViewBitmap(r1, r13)
                r7.setViewVisibility(r1, r8)
                goto L_0x0095
            L_0x0064:
                if (r13 == 0) goto L_0x0095
                android.app.Notification r13 = r1.U
                int r13 = r13.icon
                if (r13 == 0) goto L_0x0095
                int r13 = androidx.core.R.id.T
                r7.setViewVisibility(r13, r8)
                int r1 = androidx.core.R.dimen.f5129m
                int r1 = r0.getDimensionPixelSize(r1)
                int r2 = androidx.core.R.dimen.f5126j
                int r2 = r0.getDimensionPixelSize(r2)
                int r1 = r1 - r2
                int r2 = androidx.core.R.dimen.s
                int r2 = r0.getDimensionPixelSize(r2)
                androidx.core.app.NotificationCompat$Builder r3 = r12.f5457a
                android.app.Notification r4 = r3.U
                int r4 = r4.icon
                int r3 = r3.r()
                android.graphics.Bitmap r1 = r12.q(r4, r1, r2, r3)
                r7.setImageViewBitmap(r13, r1)
            L_0x0095:
                androidx.core.app.NotificationCompat$Builder r13 = r12.f5457a
                java.lang.CharSequence r13 = r13.f5386e
                if (r13 == 0) goto L_0x00a0
                int r1 = androidx.core.R.id.v0
                r7.setTextViewText(r1, r13)
            L_0x00a0:
                androidx.core.app.NotificationCompat$Builder r13 = r12.f5457a
                java.lang.CharSequence r13 = r13.f5387f
                r9 = 1
                if (r13 == 0) goto L_0x00ae
                int r1 = androidx.core.R.id.s0
                r7.setTextViewText(r1, r13)
                r13 = 1
                goto L_0x00af
            L_0x00ae:
                r13 = 0
            L_0x00af:
                androidx.core.app.NotificationCompat$Builder r1 = r12.f5457a
                java.lang.CharSequence r2 = r1.f5392k
                r10 = 8
                if (r2 == 0) goto L_0x00c2
                int r13 = androidx.core.R.id.V
                r7.setTextViewText(r13, r2)
            L_0x00bc:
                r7.setViewVisibility(r13, r8)
                r13 = 1
                r11 = 1
                goto L_0x00f9
            L_0x00c2:
                int r1 = r1.f5393l
                if (r1 <= 0) goto L_0x00f3
                int r13 = androidx.core.R.integer.f5159a
                int r13 = r0.getInteger(r13)
                androidx.core.app.NotificationCompat$Builder r1 = r12.f5457a
                int r1 = r1.f5393l
                if (r1 <= r13) goto L_0x00de
                int r13 = androidx.core.R.id.V
                int r1 = androidx.core.R.string.f5176h
                java.lang.String r1 = r0.getString(r1)
                r7.setTextViewText(r13, r1)
                goto L_0x00f0
            L_0x00de:
                java.text.NumberFormat r13 = java.text.NumberFormat.getIntegerInstance()
                int r1 = androidx.core.R.id.V
                androidx.core.app.NotificationCompat$Builder r2 = r12.f5457a
                int r2 = r2.f5393l
                long r2 = (long) r2
                java.lang.String r13 = r13.format(r2)
                r7.setTextViewText(r1, r13)
            L_0x00f0:
                int r13 = androidx.core.R.id.V
                goto L_0x00bc
            L_0x00f3:
                int r1 = androidx.core.R.id.V
                r7.setViewVisibility(r1, r10)
                r11 = 0
            L_0x00f9:
                androidx.core.app.NotificationCompat$Builder r1 = r12.f5457a
                java.lang.CharSequence r1 = r1.r
                if (r1 == 0) goto L_0x012e
                int r2 = androidx.core.R.id.s0
                r7.setTextViewText(r2, r1)
                androidx.core.app.NotificationCompat$Builder r1 = r12.f5457a
                java.lang.CharSequence r1 = r1.f5387f
                if (r1 == 0) goto L_0x0129
                int r3 = androidx.core.R.id.t0
                r7.setTextViewText(r3, r1)
                r7.setViewVisibility(r3, r8)
                if (r15 == 0) goto L_0x011e
                int r15 = androidx.core.R.dimen.t
                int r15 = r0.getDimensionPixelSize(r15)
                float r15 = (float) r15
                r7.setTextViewTextSize(r2, r8, r15)
            L_0x011e:
                int r2 = androidx.core.R.id.X
                r5 = 0
                r6 = 0
                r3 = 0
                r4 = 0
                r1 = r7
                r1.setViewPadding(r2, r3, r4, r5, r6)
                goto L_0x012e
            L_0x0129:
                int r15 = androidx.core.R.id.t0
                r7.setViewVisibility(r15, r10)
            L_0x012e:
                androidx.core.app.NotificationCompat$Builder r15 = r12.f5457a
                long r0 = r15.z()
                r2 = 0
                int r15 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r15 == 0) goto L_0x017e
                androidx.core.app.NotificationCompat$Builder r15 = r12.f5457a
                boolean r15 = r15.o
                if (r15 == 0) goto L_0x016d
                int r15 = androidx.core.R.id.O
                r7.setViewVisibility(r15, r8)
                androidx.core.app.NotificationCompat$Builder r0 = r12.f5457a
                long r0 = r0.z()
                long r2 = android.os.SystemClock.elapsedRealtime()
                long r4 = java.lang.System.currentTimeMillis()
                long r2 = r2 - r4
                long r0 = r0 + r2
                java.lang.String r2 = "setBase"
                r7.setLong(r15, r2, r0)
                java.lang.String r0 = "setStarted"
                r7.setBoolean(r15, r0, r9)
                androidx.core.app.NotificationCompat$Builder r0 = r12.f5457a
                boolean r0 = r0.p
                if (r0 == 0) goto L_0x017f
                r1 = 24
                if (r14 < r1) goto L_0x017f
                androidx.core.app.NotificationCompat.Style.Api24Impl.a(r7, r15, r0)
                goto L_0x017f
            L_0x016d:
                int r14 = androidx.core.R.id.u0
                r7.setViewVisibility(r14, r8)
                androidx.core.app.NotificationCompat$Builder r15 = r12.f5457a
                long r0 = r15.z()
                java.lang.String r15 = "setTime"
                r7.setLong(r14, r15, r0)
                goto L_0x017f
            L_0x017e:
                r9 = r11
            L_0x017f:
                int r14 = androidx.core.R.id.e0
                if (r9 == 0) goto L_0x0185
                r15 = 0
                goto L_0x0187
            L_0x0185:
                r15 = 8
            L_0x0187:
                r7.setViewVisibility(r14, r15)
                int r14 = androidx.core.R.id.Y
                if (r13 == 0) goto L_0x018f
                goto L_0x0191
            L_0x018f:
                r8 = 8
            L_0x0191:
                r7.setViewVisibility(r14, r8)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Style.c(boolean, int, boolean):android.widget.RemoteViews");
        }

        @Nullable
        public Notification d() {
            Builder builder = this.f5457a;
            if (builder != null) {
                return builder.h();
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void e(RemoteViews remoteViews, RemoteViews remoteViews2) {
            u(remoteViews);
            int i2 = R.id.b0;
            remoteViews.removeAllViews(i2);
            remoteViews.addView(i2, remoteViews2.clone());
            remoteViews.setViewVisibility(i2, 0);
            RemoteViews remoteViews3 = remoteViews;
            remoteViews3.setViewPadding(R.id.c0, 0, f(), 0, 0);
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void g(@NonNull Bundle bundle) {
            bundle.remove(NotificationCompat.H);
            bundle.remove(NotificationCompat.C);
            bundle.remove(NotificationCompat.Z);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap m(int i2, int i3) {
            return n(i2, i3, 0);
        }

        /* access modifiers changed from: package-private */
        public Bitmap o(@NonNull IconCompat iconCompat, int i2) {
            return p(iconCompat, i2, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean r() {
            return false;
        }

        /* access modifiers changed from: protected */
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String t() {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews v(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews w(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews x(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@NonNull Bundle bundle) {
            if (bundle.containsKey(NotificationCompat.H)) {
                this.f5459c = bundle.getCharSequence(NotificationCompat.H);
                this.f5460d = true;
            }
            this.f5458b = bundle.getCharSequence(NotificationCompat.C);
        }

        public void z(@Nullable Builder builder) {
            if (this.f5457a != builder) {
                this.f5457a = builder;
                if (builder != null) {
                    builder.z0(this);
                }
            }
        }
    }

    public static final class TvExtender implements Extender {

        /* renamed from: f  reason: collision with root package name */
        private static final String f5461f = "TvExtender";
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: g  reason: collision with root package name */
        static final String f5462g = "android.tv.EXTENSIONS";
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: h  reason: collision with root package name */
        private static final String f5463h = "flags";

        /* renamed from: i  reason: collision with root package name */
        static final String f5464i = "content_intent";

        /* renamed from: j  reason: collision with root package name */
        static final String f5465j = "delete_intent";

        /* renamed from: k  reason: collision with root package name */
        static final String f5466k = "channel_id";

        /* renamed from: l  reason: collision with root package name */
        static final String f5467l = "suppressShowOverApps";

        /* renamed from: m  reason: collision with root package name */
        private static final int f5468m = 1;

        /* renamed from: a  reason: collision with root package name */
        private int f5469a;

        /* renamed from: b  reason: collision with root package name */
        private String f5470b;

        /* renamed from: c  reason: collision with root package name */
        private PendingIntent f5471c;

        /* renamed from: d  reason: collision with root package name */
        private PendingIntent f5472d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5473e;

        public TvExtender() {
            this.f5469a = 1;
        }

        @NonNull
        public Builder a(@NonNull Builder builder) {
            if (Build.VERSION.SDK_INT < 26) {
                return builder;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(f5463h, this.f5469a);
            bundle.putString(f5466k, this.f5470b);
            bundle.putBoolean(f5467l, this.f5473e);
            PendingIntent pendingIntent = this.f5471c;
            if (pendingIntent != null) {
                bundle.putParcelable(f5464i, pendingIntent);
            }
            PendingIntent pendingIntent2 = this.f5472d;
            if (pendingIntent2 != null) {
                bundle.putParcelable(f5465j, pendingIntent2);
            }
            builder.t().putBundle(f5462g, bundle);
            return builder;
        }

        @Nullable
        public String b() {
            return this.f5470b;
        }

        @Nullable
        public PendingIntent c() {
            return this.f5471c;
        }

        @Nullable
        public PendingIntent d() {
            return this.f5472d;
        }

        public boolean e() {
            return (this.f5469a & 1) != 0;
        }

        public boolean f() {
            return this.f5473e;
        }

        @NonNull
        public TvExtender g(@Nullable String str) {
            this.f5470b = str;
            return this;
        }

        @NonNull
        public TvExtender h(@Nullable PendingIntent pendingIntent) {
            this.f5471c = pendingIntent;
            return this;
        }

        @NonNull
        public TvExtender i(@Nullable PendingIntent pendingIntent) {
            this.f5472d = pendingIntent;
            return this;
        }

        @NonNull
        public TvExtender j(boolean z) {
            this.f5473e = z;
            return this;
        }

        public TvExtender(@NonNull Notification notification) {
            if (Build.VERSION.SDK_INT >= 26) {
                Bundle bundle = notification.extras;
                Bundle bundle2 = bundle == null ? null : bundle.getBundle(f5462g);
                if (bundle2 != null) {
                    this.f5469a = bundle2.getInt(f5463h);
                    this.f5470b = bundle2.getString(f5466k);
                    this.f5473e = bundle2.getBoolean(f5467l);
                    this.f5471c = (PendingIntent) bundle2.getParcelable(f5464i);
                    this.f5472d = (PendingIntent) bundle2.getParcelable(f5465j);
                }
            }
        }
    }

    public static final class WearableExtender implements Extender {
        private static final String A = "displayIntent";
        private static final String B = "pages";
        private static final String C = "background";
        private static final String D = "contentIcon";
        private static final String E = "contentIconGravity";
        private static final String F = "contentActionIndex";
        private static final String G = "customSizePreset";
        private static final String H = "customContentHeight";
        private static final String I = "gravity";
        private static final String J = "hintScreenTimeout";
        private static final String K = "dismissalId";
        private static final String L = "bridgeTag";
        private static final int M = 1;
        private static final int N = 2;
        private static final int O = 4;
        private static final int P = 8;
        private static final int Q = 16;
        private static final int R = 32;
        private static final int S = 64;
        private static final int T = 1;
        private static final int U = 8388613;
        private static final int V = 80;
        public static final int o = -1;
        @Deprecated
        public static final int p = 0;
        @Deprecated
        public static final int q = 1;
        @Deprecated
        public static final int r = 2;
        @Deprecated
        public static final int s = 3;
        @Deprecated
        public static final int t = 4;
        @Deprecated
        public static final int u = 5;
        @Deprecated
        public static final int v = 0;
        @Deprecated
        public static final int w = -1;
        private static final String x = "android.wearable.EXTENSIONS";
        private static final String y = "actions";
        private static final String z = "flags";

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<Action> f5474a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private int f5475b = 1;

        /* renamed from: c  reason: collision with root package name */
        private PendingIntent f5476c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<Notification> f5477d = new ArrayList<>();

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f5478e;

        /* renamed from: f  reason: collision with root package name */
        private int f5479f;

        /* renamed from: g  reason: collision with root package name */
        private int f5480g = 8388613;

        /* renamed from: h  reason: collision with root package name */
        private int f5481h = -1;

        /* renamed from: i  reason: collision with root package name */
        private int f5482i = 0;

        /* renamed from: j  reason: collision with root package name */
        private int f5483j;

        /* renamed from: k  reason: collision with root package name */
        private int f5484k = 80;

        /* renamed from: l  reason: collision with root package name */
        private int f5485l;

        /* renamed from: m  reason: collision with root package name */
        private String f5486m;

        /* renamed from: n  reason: collision with root package name */
        private String f5487n;

        @RequiresApi(20)
        static class Api20Impl {
            private Api20Impl() {
            }

            @DoNotInline
            static Notification.Action.Builder a(Notification.Action.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            @DoNotInline
            static Notification.Action.Builder b(Notification.Action.Builder builder, RemoteInput remoteInput) {
                return builder.addRemoteInput(remoteInput);
            }

            @DoNotInline
            static Notification.Action c(Notification.Action.Builder builder) {
                return builder.build();
            }

            @DoNotInline
            static Notification.Action.Builder d(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(i2, charSequence, pendingIntent);
            }

            @DoNotInline
            public static Action e(ArrayList<Parcelable> arrayList, int i2) {
                return NotificationCompat.b((Notification.Action) arrayList.get(i2));
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
        }

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
                return builder.setAllowGeneratedReplies(z);
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
        }

        public WearableExtender() {
        }

        private void N(int i2, boolean z2) {
            int i3;
            if (z2) {
                i3 = i2 | this.f5475b;
            } else {
                i3 = (~i2) & this.f5475b;
            }
            this.f5475b = i3;
        }

        @RequiresApi(20)
        private static Notification.Action i(Action action) {
            Notification.Action.Builder builder;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                IconCompat f2 = action.f();
                builder = Api23Impl.a(f2 == null ? null : f2.L(), action.j(), action.a());
            } else {
                IconCompat f3 = action.f();
                builder = Api20Impl.d((f3 == null || f3.C() != 2) ? 0 : f3.z(), action.j(), action.a());
            }
            Bundle bundle = action.d() != null ? new Bundle(action.d()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
            if (i2 >= 24) {
                Api24Impl.a(builder, action.b());
            }
            if (i2 >= 31) {
                Api31Impl.a(builder, action.k());
            }
            Api20Impl.a(builder, bundle);
            RemoteInput[] g2 = action.g();
            if (g2 != null) {
                for (RemoteInput b2 : RemoteInput.d(g2)) {
                    Api20Impl.b(builder, b2);
                }
            }
            return Api20Impl.c(builder);
        }

        @Deprecated
        public boolean A() {
            return (this.f5475b & 4) != 0;
        }

        @NonNull
        @Deprecated
        public List<Notification> B() {
            return this.f5477d;
        }

        public boolean C() {
            return (this.f5475b & 8) != 0;
        }

        @NonNull
        @Deprecated
        public WearableExtender D(@Nullable Bitmap bitmap) {
            this.f5478e = bitmap;
            return this;
        }

        @NonNull
        public WearableExtender E(@Nullable String str) {
            this.f5487n = str;
            return this;
        }

        @NonNull
        public WearableExtender F(int i2) {
            this.f5481h = i2;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender G(int i2) {
            this.f5479f = i2;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender H(int i2) {
            this.f5480g = i2;
            return this;
        }

        @NonNull
        public WearableExtender I(boolean z2) {
            N(1, z2);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender J(int i2) {
            this.f5483j = i2;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender K(int i2) {
            this.f5482i = i2;
            return this;
        }

        @NonNull
        public WearableExtender L(@Nullable String str) {
            this.f5486m = str;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender M(@Nullable PendingIntent pendingIntent) {
            this.f5476c = pendingIntent;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender O(int i2) {
            this.f5484k = i2;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender P(boolean z2) {
            N(32, z2);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender Q(boolean z2) {
            N(16, z2);
            return this;
        }

        @NonNull
        public WearableExtender R(boolean z2) {
            N(64, z2);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender S(boolean z2) {
            N(2, z2);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender T(int i2) {
            this.f5485l = i2;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender U(boolean z2) {
            N(4, z2);
            return this;
        }

        @NonNull
        public WearableExtender V(boolean z2) {
            N(8, z2);
            return this;
        }

        @NonNull
        public Builder a(@NonNull Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.f5474a.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f5474a.size());
                Iterator<Action> it2 = this.f5474a.iterator();
                while (it2.hasNext()) {
                    arrayList.add(i(it2.next()));
                }
                bundle.putParcelableArrayList(y, arrayList);
            }
            int i2 = this.f5475b;
            if (i2 != 1) {
                bundle.putInt(z, i2);
            }
            PendingIntent pendingIntent = this.f5476c;
            if (pendingIntent != null) {
                bundle.putParcelable(A, pendingIntent);
            }
            if (!this.f5477d.isEmpty()) {
                ArrayList<Notification> arrayList2 = this.f5477d;
                bundle.putParcelableArray(B, (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
            }
            Bitmap bitmap = this.f5478e;
            if (bitmap != null) {
                bundle.putParcelable("background", bitmap);
            }
            int i3 = this.f5479f;
            if (i3 != 0) {
                bundle.putInt(D, i3);
            }
            int i4 = this.f5480g;
            if (i4 != 8388613) {
                bundle.putInt(E, i4);
            }
            int i5 = this.f5481h;
            if (i5 != -1) {
                bundle.putInt(F, i5);
            }
            int i6 = this.f5482i;
            if (i6 != 0) {
                bundle.putInt(G, i6);
            }
            int i7 = this.f5483j;
            if (i7 != 0) {
                bundle.putInt(H, i7);
            }
            int i8 = this.f5484k;
            if (i8 != 80) {
                bundle.putInt(I, i8);
            }
            int i9 = this.f5485l;
            if (i9 != 0) {
                bundle.putInt(J, i9);
            }
            String str = this.f5486m;
            if (str != null) {
                bundle.putString(K, str);
            }
            String str2 = this.f5487n;
            if (str2 != null) {
                bundle.putString(L, str2);
            }
            builder.t().putBundle(x, bundle);
            return builder;
        }

        @NonNull
        public WearableExtender b(@NonNull Action action) {
            this.f5474a.add(action);
            return this;
        }

        @NonNull
        public WearableExtender c(@NonNull List<Action> list) {
            this.f5474a.addAll(list);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender d(@NonNull Notification notification) {
            this.f5477d.add(notification);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender e(@NonNull List<Notification> list) {
            this.f5477d.addAll(list);
            return this;
        }

        @NonNull
        public WearableExtender f() {
            this.f5474a.clear();
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender g() {
            this.f5477d.clear();
            return this;
        }

        @NonNull
        /* renamed from: h */
        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f5474a = new ArrayList<>(this.f5474a);
            wearableExtender.f5475b = this.f5475b;
            wearableExtender.f5476c = this.f5476c;
            wearableExtender.f5477d = new ArrayList<>(this.f5477d);
            wearableExtender.f5478e = this.f5478e;
            wearableExtender.f5479f = this.f5479f;
            wearableExtender.f5480g = this.f5480g;
            wearableExtender.f5481h = this.f5481h;
            wearableExtender.f5482i = this.f5482i;
            wearableExtender.f5483j = this.f5483j;
            wearableExtender.f5484k = this.f5484k;
            wearableExtender.f5485l = this.f5485l;
            wearableExtender.f5486m = this.f5486m;
            wearableExtender.f5487n = this.f5487n;
            return wearableExtender;
        }

        @NonNull
        public List<Action> j() {
            return this.f5474a;
        }

        @Deprecated
        @Nullable
        public Bitmap k() {
            return this.f5478e;
        }

        @Nullable
        public String l() {
            return this.f5487n;
        }

        public int m() {
            return this.f5481h;
        }

        @Deprecated
        public int n() {
            return this.f5479f;
        }

        @Deprecated
        public int o() {
            return this.f5480g;
        }

        public boolean p() {
            return (this.f5475b & 1) != 0;
        }

        @Deprecated
        public int q() {
            return this.f5483j;
        }

        @Deprecated
        public int r() {
            return this.f5482i;
        }

        @Nullable
        public String s() {
            return this.f5486m;
        }

        @Deprecated
        @Nullable
        public PendingIntent t() {
            return this.f5476c;
        }

        @Deprecated
        public int u() {
            return this.f5484k;
        }

        @Deprecated
        public boolean v() {
            return (this.f5475b & 32) != 0;
        }

        @Deprecated
        public boolean w() {
            return (this.f5475b & 16) != 0;
        }

        public boolean x() {
            return (this.f5475b & 64) != 0;
        }

        @Deprecated
        public boolean y() {
            return (this.f5475b & 2) != 0;
        }

        @Deprecated
        public int z() {
            return this.f5485l;
        }

        public WearableExtender(@NonNull Notification notification) {
            Bundle n2 = NotificationCompat.n(notification);
            Bundle bundle = n2 != null ? n2.getBundle(x) : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(y);
                if (parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    Action[] actionArr = new Action[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        actionArr[i2] = Api20Impl.e(parcelableArrayList, i2);
                    }
                    Collections.addAll(this.f5474a, actionArr);
                }
                this.f5475b = bundle.getInt(z, 1);
                this.f5476c = (PendingIntent) bundle.getParcelable(A);
                Notification[] u2 = NotificationCompat.u(bundle, B);
                if (u2 != null) {
                    Collections.addAll(this.f5477d, u2);
                }
                this.f5478e = (Bitmap) bundle.getParcelable("background");
                this.f5479f = bundle.getInt(D);
                this.f5480g = bundle.getInt(E, 8388613);
                this.f5481h = bundle.getInt(F, -1);
                this.f5482i = bundle.getInt(G, 0);
                this.f5483j = bundle.getInt(H);
                this.f5484k = bundle.getInt(I, 80);
                this.f5485l = bundle.getInt(J);
                this.f5486m = bundle.getString(K);
                this.f5487n = bundle.getString(L);
            }
        }
    }

    @Nullable
    public static String A(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.e(notification);
        }
        return null;
    }

    public static boolean B(@NonNull Notification notification) {
        return notification.extras.getBoolean(S);
    }

    @Nullable
    public static String C(@NonNull Notification notification) {
        return Api20Impl.i(notification);
    }

    @Nullable
    public static CharSequence D(@NonNull Notification notification) {
        return notification.extras.getCharSequence(E);
    }

    public static long E(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.f(notification);
        }
        return 0;
    }

    public static boolean F(@NonNull Notification notification) {
        return notification.extras.getBoolean(P);
    }

    public static int G(@NonNull Notification notification) {
        return notification.visibility;
    }

    public static boolean H(@NonNull Notification notification) {
        return (notification.flags & 512) != 0;
    }

    @Nullable
    public static Bitmap I(@NonNull Context context, @Nullable Bitmap bitmap) {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f5123g);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.f5122f);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
    }

    @Nullable
    public static Action a(@NonNull Notification notification, int i2) {
        return b(notification.actions[i2]);
    }

    @RequiresApi(20)
    @NonNull
    static Action b(@NonNull Notification.Action action) {
        RemoteInput[] remoteInputArr;
        int i2;
        Notification.Action action2 = action;
        RemoteInput[] g2 = Api20Impl.g(action);
        IconCompat iconCompat = null;
        if (g2 == null) {
            remoteInputArr = null;
        } else {
            RemoteInput[] remoteInputArr2 = new RemoteInput[g2.length];
            for (int i3 = 0; i3 < g2.length; i3++) {
                RemoteInput remoteInput = g2[i3];
                remoteInputArr2[i3] = new RemoteInput(Api20Impl.h(remoteInput), Api20Impl.f(remoteInput), Api20Impl.b(remoteInput), Api20Impl.a(remoteInput), Build.VERSION.SDK_INT >= 29 ? Api29Impl.c(remoteInput) : 0, Api20Impl.d(remoteInput), (Set<String>) null);
            }
            remoteInputArr = remoteInputArr2;
        }
        int i4 = Build.VERSION.SDK_INT;
        boolean z2 = i4 >= 24 ? Api20Impl.c(action).getBoolean("android.support.allowGeneratedReplies") || Api24Impl.a(action) : Api20Impl.c(action).getBoolean("android.support.allowGeneratedReplies");
        boolean z3 = Api20Impl.c(action).getBoolean("android.support.action.showsUserInterface", true);
        int a2 = i4 >= 28 ? Api28Impl.a(action) : Api20Impl.c(action).getInt("android.support.action.semanticAction", 0);
        boolean e2 = i4 >= 29 ? Api29Impl.e(action) : false;
        boolean a3 = i4 >= 31 ? Api31Impl.a(action) : false;
        if (i4 < 23) {
            return new Action(action2.icon, action2.title, action2.actionIntent, Api20Impl.c(action), remoteInputArr, (RemoteInput[]) null, z2, a2, z3, e2, a3);
        }
        if (Api23Impl.a(action) == null && (i2 = action2.icon) != 0) {
            return new Action(i2, action2.title, action2.actionIntent, Api20Impl.c(action), remoteInputArr, (RemoteInput[]) null, z2, a2, z3, e2, a3);
        }
        if (Api23Impl.a(action) != null) {
            iconCompat = IconCompat.n(Api23Impl.a(action));
        }
        return new Action(iconCompat, action2.title, action2.actionIntent, Api20Impl.c(action), remoteInputArr, (RemoteInput[]) null, z2, a2, z3, e2, a3);
    }

    public static int c(@NonNull Notification notification) {
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean d(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(notification);
        }
        return false;
    }

    public static boolean e(@NonNull Notification notification) {
        return (notification.flags & 16) != 0;
    }

    public static int f(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(notification);
        }
        return 0;
    }

    @Nullable
    public static BubbleMetadata g(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return BubbleMetadata.a(Api29Impl.b(notification));
        }
        return null;
    }

    @Nullable
    public static String h(@NonNull Notification notification) {
        return notification.category;
    }

    @Nullable
    public static String i(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(notification);
        }
        return null;
    }

    public static int j(@NonNull Notification notification) {
        return notification.color;
    }

    @Nullable
    public static CharSequence k(@NonNull Notification notification) {
        return notification.extras.getCharSequence(G);
    }

    @Nullable
    public static CharSequence l(@NonNull Notification notification) {
        return notification.extras.getCharSequence(D);
    }

    @Nullable
    public static CharSequence m(@NonNull Notification notification) {
        return notification.extras.getCharSequence(B);
    }

    @Nullable
    public static Bundle n(@NonNull Notification notification) {
        return notification.extras;
    }

    @Nullable
    public static String o(@NonNull Notification notification) {
        return Api20Impl.e(notification);
    }

    public static int p(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.c(notification);
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static boolean q(@NonNull Notification notification) {
        return (notification.flags & 128) != 0;
    }

    @RequiresApi(21)
    @NonNull
    public static List<Action> r(@NonNull Notification notification) {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = notification.extras.getBundle("android.car.EXTENSIONS");
        if (!(bundle2 == null || (bundle = bundle2.getBundle("invisible_actions")) == null)) {
            for (int i2 = 0; i2 < bundle.size(); i2++) {
                arrayList.add(NotificationCompatJellybean.g(bundle.getBundle(Integer.toString(i2))));
            }
        }
        return arrayList;
    }

    public static boolean s(@NonNull Notification notification) {
        return (notification.flags & 256) != 0;
    }

    @Nullable
    public static LocusIdCompat t(@NonNull Notification notification) {
        LocusId d2;
        if (Build.VERSION.SDK_INT < 29 || (d2 = Api29Impl.d(notification)) == null) {
            return null;
        }
        return LocusIdCompat.d(d2);
    }

    @NonNull
    static Notification[] u(@NonNull Bundle bundle, @NonNull String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i2 = 0; i2 < parcelableArray.length; i2++) {
            notificationArr[i2] = (Notification) parcelableArray[i2];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static boolean v(@NonNull Notification notification) {
        return (notification.flags & 2) != 0;
    }

    public static boolean w(@NonNull Notification notification) {
        return (notification.flags & 8) != 0;
    }

    @NonNull
    public static List<Person> x(@NonNull Notification notification) {
        ArrayList arrayList = new ArrayList();
        int i2 = Build.VERSION.SDK_INT;
        Bundle bundle = notification.extras;
        if (i2 >= 28) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(b0);
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                Iterator it2 = parcelableArrayList.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Person.a(j.a(it2.next())));
                }
            }
        } else {
            String[] stringArray = bundle.getStringArray(a0);
            if (!(stringArray == null || stringArray.length == 0)) {
                for (String g2 : stringArray) {
                    arrayList.add(new Person.Builder().g(g2).a());
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static Notification y(@NonNull Notification notification) {
        return notification.publicVersion;
    }

    @Nullable
    public static CharSequence z(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.d(notification);
        }
        return null;
    }
}
