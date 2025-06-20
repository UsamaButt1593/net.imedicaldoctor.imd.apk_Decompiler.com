package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ActivityOptionsCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5211a = "android.activity.usage_time";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5212b = "android.usage_time_packages";

    private static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {

        /* renamed from: c  reason: collision with root package name */
        private final ActivityOptions f5213c;

        ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
            this.f5213c = activityOptions;
        }

        public Rect a() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return Api24Impl.a(this.f5213c);
        }

        public void j(@NonNull PendingIntent pendingIntent) {
            if (Build.VERSION.SDK_INT >= 23) {
                Api23Impl.c(this.f5213c, pendingIntent);
            }
        }

        @NonNull
        public ActivityOptionsCompat k(@Nullable Rect rect) {
            return Build.VERSION.SDK_INT < 24 ? this : new ActivityOptionsCompatImpl(Api24Impl.b(this.f5213c, rect));
        }

        public ActivityOptionsCompat l(boolean z) {
            return Build.VERSION.SDK_INT < 34 ? this : new ActivityOptionsCompatImpl(Api34Impl.a(this.f5213c, z));
        }

        public Bundle m() {
            return this.f5213c.toBundle();
        }

        public void n(@NonNull ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsCompatImpl) {
                this.f5213c.update(((ActivityOptionsCompatImpl) activityOptionsCompat).f5213c);
            }
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ActivityOptions a(Activity activity, View view, String str) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
        }

        @DoNotInline
        @SafeVarargs
        static ActivityOptions b(Activity activity, Pair<View, String>... pairArr) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, pairArr);
        }

        @DoNotInline
        static ActivityOptions c() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }

        @DoNotInline
        static ActivityOptions b(View view, int i2, int i3, int i4, int i5) {
            return ActivityOptions.makeClipRevealAnimation(view, i2, i3, i4, i5);
        }

        @DoNotInline
        static void c(ActivityOptions activityOptions, PendingIntent pendingIntent) {
            activityOptions.requestUsageTimeReport(pendingIntent);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Rect a(ActivityOptions activityOptions) {
            return activityOptions.getLaunchBounds();
        }

        @DoNotInline
        static ActivityOptions b(ActivityOptions activityOptions, Rect rect) {
            return activityOptions.setLaunchBounds(rect);
        }
    }

    @RequiresApi(34)
    static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static ActivityOptions a(ActivityOptions activityOptions, boolean z) {
            return activityOptions.setShareIdentityEnabled(z);
        }
    }

    protected ActivityOptionsCompat() {
    }

    @NonNull
    public static ActivityOptionsCompat b() {
        return Build.VERSION.SDK_INT >= 23 ? new ActivityOptionsCompatImpl(Api23Impl.a()) : new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat c(@NonNull View view, int i2, int i3, int i4, int i5) {
        return Build.VERSION.SDK_INT >= 23 ? new ActivityOptionsCompatImpl(Api23Impl.b(view, i2, i3, i4, i5)) : new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat d(@NonNull Context context, int i2, int i3) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(context, i2, i3));
    }

    @NonNull
    public static ActivityOptionsCompat e(@NonNull View view, int i2, int i3, int i4, int i5) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation(view, i2, i3, i4, i5));
    }

    @NonNull
    public static ActivityOptionsCompat f(@NonNull Activity activity, @NonNull View view, @NonNull String str) {
        return new ActivityOptionsCompatImpl(Api21Impl.a(activity, view, str));
    }

    @NonNull
    public static ActivityOptionsCompat g(@NonNull Activity activity, @Nullable androidx.core.util.Pair<View, String>... pairArr) {
        Pair[] pairArr2;
        if (pairArr != null) {
            pairArr2 = new Pair[pairArr.length];
            for (int i2 = 0; i2 < pairArr.length; i2++) {
                androidx.core.util.Pair<View, String> pair = pairArr[i2];
                pairArr2[i2] = Pair.create((View) pair.f6296a, (String) pair.f6297b);
            }
        } else {
            pairArr2 = null;
        }
        return new ActivityOptionsCompatImpl(Api21Impl.b(activity, pairArr2));
    }

    @NonNull
    public static ActivityOptionsCompat h() {
        return new ActivityOptionsCompatImpl(Api21Impl.c());
    }

    @NonNull
    public static ActivityOptionsCompat i(@NonNull View view, @NonNull Bitmap bitmap, int i2, int i3) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i2, i3));
    }

    @Nullable
    public Rect a() {
        return null;
    }

    public void j(@NonNull PendingIntent pendingIntent) {
    }

    @NonNull
    public ActivityOptionsCompat k(@Nullable Rect rect) {
        return this;
    }

    @NonNull
    public ActivityOptionsCompat l(boolean z) {
        return this;
    }

    @Nullable
    public Bundle m() {
        return null;
    }

    public void n(@NonNull ActivityOptionsCompat activityOptionsCompat) {
    }
}
