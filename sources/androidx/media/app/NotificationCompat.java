package androidx.media.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R;

public class NotificationCompat {

    @RequiresApi(15)
    private static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static void a(RemoteViews remoteViews, int i2, CharSequence charSequence) {
            remoteViews.setContentDescription(i2, charSequence);
        }
    }

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Notification.MediaStyle a() {
            return new Notification.MediaStyle();
        }

        @DoNotInline
        static Notification.MediaStyle b(Notification.MediaStyle mediaStyle, int[] iArr, MediaSessionCompat.Token token) {
            if (iArr != null) {
                e(mediaStyle, iArr);
            }
            if (token != null) {
                c(mediaStyle, (MediaSession.Token) token.j());
            }
            return mediaStyle;
        }

        @DoNotInline
        static void c(Notification.MediaStyle mediaStyle, MediaSession.Token token) {
            mediaStyle.setMediaSession(token);
        }

        @DoNotInline
        static void d(Notification.Builder builder, Notification.MediaStyle mediaStyle) {
            builder.setStyle(mediaStyle);
        }

        @DoNotInline
        static void e(Notification.MediaStyle mediaStyle, int... iArr) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
    }

    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Notification.MediaStyle a() {
            return new Notification.DecoratedMediaCustomViewStyle();
        }
    }

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        @SuppressLint({"MissingPermission"})
        static Notification.MediaStyle a(Notification.MediaStyle mediaStyle, @NonNull CharSequence charSequence, @DrawableRes int i2, @Nullable PendingIntent pendingIntent, Boolean bool) {
            if (bool.booleanValue()) {
                mediaStyle.setRemotePlaybackInfo(charSequence, i2, pendingIntent);
            }
            return mediaStyle;
        }
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        private void L(RemoteViews remoteViews) {
            remoteViews.setInt(R.id.o, "setBackgroundColor", this.f5457a.r() != 0 ? this.f5457a.r() : this.f5457a.f5382a.getResources().getColor(R.color.f8985a));
        }

        /* access modifiers changed from: package-private */
        public int D(int i2) {
            return i2 <= 3 ? R.layout.f9008f : R.layout.f9006d;
        }

        /* access modifiers changed from: package-private */
        public int E() {
            return this.f5457a.s() != null ? R.layout.f9011i : super.E();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.Builder a2;
            Notification.MediaStyle b2;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 34) {
                a2 = notificationBuilderWithBuilderAccessor.a();
                b2 = Api21Impl.b(Api34Impl.a(Api24Impl.a(), this.f9034i, this.f9035j, this.f9036k, Boolean.valueOf(this.f9037l)), this.f9030e, this.f9031f);
            } else if (i2 >= 24) {
                a2 = notificationBuilderWithBuilderAccessor.a();
                b2 = Api21Impl.b(Api24Impl.a(), this.f9030e, this.f9031f);
            } else {
                super.b(notificationBuilderWithBuilderAccessor);
                return;
            }
            Api21Impl.d(a2, b2);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews v(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews p = this.f5457a.p() != null ? this.f5457a.p() : this.f5457a.s();
            if (p == null) {
                return null;
            }
            RemoteViews A = A();
            e(A, p);
            L(A);
            return A;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews w(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z = this.f5457a.s() != null;
            if (!z && this.f5457a.p() == null) {
                return null;
            }
            RemoteViews B = B();
            if (z) {
                e(B, this.f5457a.s());
            }
            L(B);
            return B;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews x(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews w = this.f5457a.w() != null ? this.f5457a.w() : this.f5457a.s();
            if (w == null) {
                return null;
            }
            RemoteViews A = A();
            e(A, w);
            L(A);
            return A;
        }
    }

    public static class MediaStyle extends NotificationCompat.Style {

        /* renamed from: m  reason: collision with root package name */
        private static final int f9028m = 3;

        /* renamed from: n  reason: collision with root package name */
        private static final int f9029n = 5;

        /* renamed from: e  reason: collision with root package name */
        int[] f9030e = null;

        /* renamed from: f  reason: collision with root package name */
        MediaSessionCompat.Token f9031f;

        /* renamed from: g  reason: collision with root package name */
        boolean f9032g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f9033h;

        /* renamed from: i  reason: collision with root package name */
        CharSequence f9034i;

        /* renamed from: j  reason: collision with root package name */
        int f9035j;

        /* renamed from: k  reason: collision with root package name */
        PendingIntent f9036k;

        /* renamed from: l  reason: collision with root package name */
        boolean f9037l = false;

        public MediaStyle() {
        }

        private RemoteViews C(NotificationCompat.Action action) {
            boolean z = action.a() == null;
            RemoteViews remoteViews = new RemoteViews(this.f5457a.f5382a.getPackageName(), R.layout.f9003a);
            int i2 = R.id.f8988a;
            remoteViews.setImageViewResource(i2, action.e());
            if (!z) {
                remoteViews.setOnClickPendingIntent(i2, action.a());
            }
            Api15Impl.a(remoteViews, i2, action.j());
            return remoteViews;
        }

        public static MediaSessionCompat.Token F(Notification notification) {
            Parcelable parcelable;
            Bundle n2 = androidx.core.app.NotificationCompat.n(notification);
            if (n2 == null || (parcelable = n2.getParcelable(androidx.core.app.NotificationCompat.d0)) == null) {
                return null;
            }
            return MediaSessionCompat.Token.b(parcelable);
        }

        /* access modifiers changed from: package-private */
        public RemoteViews A() {
            int min = Math.min(this.f5457a.f5383b.size(), 5);
            RemoteViews c2 = c(false, D(min), false);
            c2.removeAllViews(R.id.f8997j);
            if (min > 0) {
                for (int i2 = 0; i2 < min; i2++) {
                    c2.addView(R.id.f8997j, C(this.f5457a.f5383b.get(i2)));
                }
            }
            if (this.f9032g) {
                int i3 = R.id.f8990c;
                c2.setViewVisibility(i3, 0);
                c2.setInt(i3, "setAlpha", this.f5457a.f5382a.getResources().getInteger(R.integer.f9002a));
                c2.setOnClickPendingIntent(i3, this.f9033h);
            } else {
                c2.setViewVisibility(R.id.f8990c, 8);
            }
            return c2;
        }

        /* access modifiers changed from: package-private */
        public RemoteViews B() {
            RemoteViews c2 = c(false, E(), true);
            int size = this.f5457a.f5383b.size();
            int[] iArr = this.f9030e;
            int min = iArr == null ? 0 : Math.min(iArr.length, 3);
            c2.removeAllViews(R.id.f8997j);
            if (min > 0) {
                int i2 = 0;
                while (i2 < min) {
                    if (i2 < size) {
                        c2.addView(R.id.f8997j, C(this.f5457a.f5383b.get(this.f9030e[i2])));
                        i2++;
                    } else {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(size - 1)}));
                    }
                }
            }
            if (this.f9032g) {
                c2.setViewVisibility(R.id.f8992e, 8);
                int i3 = R.id.f8990c;
                c2.setViewVisibility(i3, 0);
                c2.setOnClickPendingIntent(i3, this.f9033h);
                c2.setInt(i3, "setAlpha", this.f5457a.f5382a.getResources().getInteger(R.integer.f9002a));
            } else {
                c2.setViewVisibility(R.id.f8992e, 0);
                c2.setViewVisibility(R.id.f8990c, 8);
            }
            return c2;
        }

        /* access modifiers changed from: package-private */
        public int D(int i2) {
            return i2 <= 3 ? R.layout.f9007e : R.layout.f9005c;
        }

        /* access modifiers changed from: package-private */
        public int E() {
            return R.layout.f9010h;
        }

        public MediaStyle G(PendingIntent pendingIntent) {
            this.f9033h = pendingIntent;
            return this;
        }

        public MediaStyle H(MediaSessionCompat.Token token) {
            this.f9031f = token;
            return this;
        }

        @RequiresPermission("android.permission.MEDIA_CONTENT_CONTROL")
        @NonNull
        public MediaStyle I(@NonNull CharSequence charSequence, @DrawableRes int i2, @Nullable PendingIntent pendingIntent) {
            this.f9034i = charSequence;
            this.f9035j = i2;
            this.f9036k = pendingIntent;
            this.f9037l = true;
            return this;
        }

        public MediaStyle J(int... iArr) {
            this.f9030e = iArr;
            return this;
        }

        public MediaStyle K(boolean z) {
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Api21Impl.d(notificationBuilderWithBuilderAccessor.a(), Build.VERSION.SDK_INT >= 34 ? Api21Impl.b(Api34Impl.a(Api21Impl.a(), this.f9034i, this.f9035j, this.f9036k, Boolean.valueOf(this.f9037l)), this.f9030e, this.f9031f) : Api21Impl.b(Api21Impl.a(), this.f9030e, this.f9031f));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews v(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews w(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            z(builder);
        }
    }

    private NotificationCompat() {
    }
}
