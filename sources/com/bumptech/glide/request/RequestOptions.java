package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    @Nullable
    private static RequestOptions O3;
    @Nullable
    private static RequestOptions P3;
    @Nullable
    private static RequestOptions Q3;
    @Nullable
    private static RequestOptions R3;
    @Nullable
    private static RequestOptions S3;
    @Nullable
    private static RequestOptions T3;
    @Nullable
    private static RequestOptions U3;
    @Nullable
    private static RequestOptions V3;

    @CheckResult
    @NonNull
    public static <T> RequestOptions B2(@NonNull Option<T> option, @NonNull T t) {
        return (RequestOptions) new RequestOptions().r1(option, t);
    }

    @CheckResult
    @NonNull
    public static RequestOptions C2(int i2) {
        return E2(i2, i2);
    }

    @CheckResult
    @NonNull
    public static RequestOptions E2(int i2, int i3) {
        return (RequestOptions) new RequestOptions().c1(i2, i3);
    }

    @CheckResult
    @NonNull
    public static RequestOptions G2(@DrawableRes int i2) {
        return (RequestOptions) new RequestOptions().d1(i2);
    }

    @CheckResult
    @NonNull
    public static RequestOptions I2(@Nullable Drawable drawable) {
        return (RequestOptions) new RequestOptions().e1(drawable);
    }

    @CheckResult
    @NonNull
    public static RequestOptions J2(@NonNull Priority priority) {
        return (RequestOptions) new RequestOptions().g1(priority);
    }

    @CheckResult
    @NonNull
    public static RequestOptions L2(@NonNull Key key) {
        return (RequestOptions) new RequestOptions().t1(key);
    }

    @CheckResult
    @NonNull
    public static RequestOptions M2(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (RequestOptions) new RequestOptions().u1(f2);
    }

    @CheckResult
    @NonNull
    public static RequestOptions N2(boolean z) {
        if (z) {
            if (O3 == null) {
                O3 = (RequestOptions) ((RequestOptions) new RequestOptions().w1(true)).b();
            }
            return O3;
        }
        if (P3 == null) {
            P3 = (RequestOptions) ((RequestOptions) new RequestOptions().w1(false)).b();
        }
        return P3;
    }

    @CheckResult
    @NonNull
    public static RequestOptions P2(@IntRange(from = 0) int i2) {
        return (RequestOptions) new RequestOptions().z1(i2);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bumptech.glide.request.RequestOptions U1(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r1) {
        /*
            com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
            r0.<init>()
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.A1(r1)
            com.bumptech.glide.request.RequestOptions r1 = (com.bumptech.glide.request.RequestOptions) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestOptions.U1(com.bumptech.glide.load.Transformation):com.bumptech.glide.request.RequestOptions");
    }

    @CheckResult
    @NonNull
    public static RequestOptions a2() {
        if (S3 == null) {
            S3 = (RequestOptions) ((RequestOptions) new RequestOptions().c()).b();
        }
        return S3;
    }

    @CheckResult
    @NonNull
    public static RequestOptions b2() {
        if (R3 == null) {
            R3 = (RequestOptions) ((RequestOptions) new RequestOptions().d()).b();
        }
        return R3;
    }

    @CheckResult
    @NonNull
    public static RequestOptions d2() {
        if (T3 == null) {
            T3 = (RequestOptions) ((RequestOptions) new RequestOptions().e()).b();
        }
        return T3;
    }

    @CheckResult
    @NonNull
    public static RequestOptions e2(@NonNull Class<?> cls) {
        return (RequestOptions) new RequestOptions().q(cls);
    }

    @CheckResult
    @NonNull
    public static RequestOptions f2(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (RequestOptions) new RequestOptions().s(diskCacheStrategy);
    }

    @CheckResult
    @NonNull
    public static RequestOptions g2(@NonNull DownsampleStrategy downsampleStrategy) {
        return (RequestOptions) new RequestOptions().w(downsampleStrategy);
    }

    @CheckResult
    @NonNull
    public static RequestOptions i2(@NonNull Bitmap.CompressFormat compressFormat) {
        return (RequestOptions) new RequestOptions().x(compressFormat);
    }

    @CheckResult
    @NonNull
    public static RequestOptions j2(@IntRange(from = 0, to = 100) int i2) {
        return (RequestOptions) new RequestOptions().y(i2);
    }

    @CheckResult
    @NonNull
    public static RequestOptions m2(@DrawableRes int i2) {
        return (RequestOptions) new RequestOptions().z(i2);
    }

    @CheckResult
    @NonNull
    public static RequestOptions n2(@Nullable Drawable drawable) {
        return (RequestOptions) new RequestOptions().A(drawable);
    }

    @CheckResult
    @NonNull
    public static RequestOptions p2() {
        if (Q3 == null) {
            Q3 = (RequestOptions) ((RequestOptions) new RequestOptions().E()).b();
        }
        return Q3;
    }

    @CheckResult
    @NonNull
    public static RequestOptions q2(@NonNull DecodeFormat decodeFormat) {
        return (RequestOptions) new RequestOptions().F(decodeFormat);
    }

    @CheckResult
    @NonNull
    public static RequestOptions r2(@IntRange(from = 0) long j2) {
        return (RequestOptions) new RequestOptions().G(j2);
    }

    @CheckResult
    @NonNull
    public static RequestOptions u2() {
        if (V3 == null) {
            V3 = (RequestOptions) ((RequestOptions) new RequestOptions().u()).b();
        }
        return V3;
    }

    @CheckResult
    @NonNull
    public static RequestOptions w2() {
        if (U3 == null) {
            U3 = (RequestOptions) ((RequestOptions) new RequestOptions().v()).b();
        }
        return U3;
    }
}
