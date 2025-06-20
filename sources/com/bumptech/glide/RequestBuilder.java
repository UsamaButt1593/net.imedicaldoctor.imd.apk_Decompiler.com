package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable, ModelTypes<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions c4 = ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().s(DiskCacheStrategy.f17909c)).g1(Priority.LOW)).w1(true));
    private final Context O3;
    private final RequestManager P3;
    private final Class<TranscodeType> Q3;
    private final Glide R3;
    private final GlideContext S3;
    @NonNull
    private TransitionOptions<?, ? super TranscodeType> T3;
    @Nullable
    private Object U3;
    @Nullable
    private List<RequestListener<TranscodeType>> V3;
    @Nullable
    private RequestBuilder<TranscodeType> W3;
    @Nullable
    private RequestBuilder<TranscodeType> X3;
    @Nullable
    private Float Y3;
    private boolean Z3;
    private boolean a4;
    private boolean b4;

    /* renamed from: com.bumptech.glide.RequestBuilder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17737a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f17738b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        static {
            /*
                com.bumptech.glide.Priority[] r0 = com.bumptech.glide.Priority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17738b = r0
                r1 = 1
                com.bumptech.glide.Priority r2 = com.bumptech.glide.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f17738b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.Priority r3 = com.bumptech.glide.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f17738b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bumptech.glide.Priority r4 = com.bumptech.glide.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f17738b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bumptech.glide.Priority r5 = com.bumptech.glide.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f17737a = r4
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f17737a     // Catch:{ NoSuchFieldError -> 0x004e }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f17737a     // Catch:{ NoSuchFieldError -> 0x0058 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f17737a     // Catch:{ NoSuchFieldError -> 0x0062 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f17737a     // Catch:{ NoSuchFieldError -> 0x006d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f17737a     // Catch:{ NoSuchFieldError -> 0x0078 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f17737a     // Catch:{ NoSuchFieldError -> 0x0083 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f17737a     // Catch:{ NoSuchFieldError -> 0x008f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    @SuppressLint({"CheckResult"})
    protected RequestBuilder(@NonNull Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.Z3 = true;
        this.R3 = glide;
        this.P3 = requestManager;
        this.Q3 = cls;
        this.O3 = context;
        this.T3 = requestManager.H(cls);
        this.S3 = glide.j();
        p2(requestManager.F());
        a(requestManager.G());
    }

    private boolean C2(BaseRequestOptions<?> baseRequestOptions, Request request) {
        return !baseRequestOptions.t0() && request.isComplete();
    }

    @NonNull
    private RequestBuilder<TranscodeType> T2(@Nullable Object obj) {
        this.U3 = obj;
        this.a4 = true;
        return this;
    }

    private Request U2(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i2, int i3, Executor executor) {
        Context context = this.O3;
        GlideContext glideContext = this.S3;
        return SingleRequest.x(context, glideContext, obj, this.U3, this.Q3, baseRequestOptions, i2, i3, priority, target, requestListener, this.V3, requestCoordinator, glideContext.f(), transitionOptions.c(), executor);
    }

    private Request b2(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        return d2(new Object(), target, requestListener, (RequestCoordinator) null, this.T3, baseRequestOptions.c0(), baseRequestOptions.X(), baseRequestOptions.V(), baseRequestOptions, executor);
    }

    private Request d2(Object obj, Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i2, int i3, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        if (this.X3 != null) {
            errorRequestCoordinator2 = new ErrorRequestCoordinator(obj, requestCoordinator);
            errorRequestCoordinator = errorRequestCoordinator2;
        } else {
            Object obj2 = obj;
            errorRequestCoordinator = null;
            errorRequestCoordinator2 = requestCoordinator;
        }
        Request e2 = e2(obj, target, requestListener, errorRequestCoordinator2, transitionOptions, priority, i2, i3, baseRequestOptions, executor);
        if (errorRequestCoordinator == null) {
            return e2;
        }
        int X = this.X3.X();
        int V = this.X3.V();
        if (Util.v(i2, i3) && !this.X3.F0()) {
            X = baseRequestOptions.X();
            V = baseRequestOptions.V();
        }
        RequestBuilder<TranscodeType> requestBuilder = this.X3;
        ErrorRequestCoordinator errorRequestCoordinator3 = errorRequestCoordinator;
        errorRequestCoordinator3.p(e2, requestBuilder.d2(obj, target, requestListener, errorRequestCoordinator3, requestBuilder.T3, requestBuilder.c0(), X, V, this.X3, executor));
        return errorRequestCoordinator3;
    }

    /* JADX WARNING: type inference failed for: r27v0, types: [com.bumptech.glide.request.BaseRequestOptions<?>, com.bumptech.glide.request.BaseRequestOptions] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.request.Request e2(java.lang.Object r19, com.bumptech.glide.request.target.Target<TranscodeType> r20, com.bumptech.glide.request.RequestListener<TranscodeType> r21, @androidx.annotation.Nullable com.bumptech.glide.request.RequestCoordinator r22, com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> r23, com.bumptech.glide.Priority r24, int r25, int r26, com.bumptech.glide.request.BaseRequestOptions<?> r27, java.util.concurrent.Executor r28) {
        /*
            r18 = this;
            r11 = r18
            r12 = r19
            r5 = r22
            r13 = r24
            com.bumptech.glide.RequestBuilder<TranscodeType> r0 = r11.W3
            if (r0 == 0) goto L_0x0095
            boolean r1 = r11.b4
            if (r1 != 0) goto L_0x008d
            com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> r1 = r0.T3
            boolean r2 = r0.Z3
            if (r2 == 0) goto L_0x0019
            r14 = r23
            goto L_0x001a
        L_0x0019:
            r14 = r1
        L_0x001a:
            boolean r0 = r0.u0()
            if (r0 == 0) goto L_0x0028
            com.bumptech.glide.RequestBuilder<TranscodeType> r0 = r11.W3
            com.bumptech.glide.Priority r0 = r0.c0()
        L_0x0026:
            r15 = r0
            goto L_0x002d
        L_0x0028:
            com.bumptech.glide.Priority r0 = r11.n2(r13)
            goto L_0x0026
        L_0x002d:
            com.bumptech.glide.RequestBuilder<TranscodeType> r0 = r11.W3
            int r0 = r0.X()
            com.bumptech.glide.RequestBuilder<TranscodeType> r1 = r11.W3
            int r1 = r1.V()
            boolean r2 = com.bumptech.glide.util.Util.v(r25, r26)
            if (r2 == 0) goto L_0x004f
            com.bumptech.glide.RequestBuilder<TranscodeType> r2 = r11.W3
            boolean r2 = r2.F0()
            if (r2 != 0) goto L_0x004f
            int r0 = r27.X()
            int r1 = r27.V()
        L_0x004f:
            r16 = r0
            r17 = r1
            com.bumptech.glide.request.ThumbnailRequestCoordinator r10 = new com.bumptech.glide.request.ThumbnailRequestCoordinator
            r10.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r10
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r13 = r10
            r10 = r28
            com.bumptech.glide.request.Request r10 = r0.U2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 1
            r11.b4 = r0
            com.bumptech.glide.RequestBuilder<TranscodeType> r9 = r11.W3
            r0 = r9
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r12 = r10
            r10 = r28
            com.bumptech.glide.request.Request r0 = r0.d2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = 0
            r11.b4 = r1
            r13.o(r12, r0)
            return r13
        L_0x008d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()"
            r0.<init>(r1)
            throw r0
        L_0x0095:
            java.lang.Float r0 = r11.Y3
            if (r0 == 0) goto L_0x00d5
            com.bumptech.glide.request.ThumbnailRequestCoordinator r14 = new com.bumptech.glide.request.ThumbnailRequestCoordinator
            r14.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r14
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            com.bumptech.glide.request.Request r15 = r0.U2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.bumptech.glide.request.BaseRequestOptions r0 = r27.clone()
            java.lang.Float r1 = r11.Y3
            float r1 = r1.floatValue()
            com.bumptech.glide.request.BaseRequestOptions r4 = r0.u1(r1)
            com.bumptech.glide.Priority r7 = r11.n2(r13)
            r0 = r18
            r1 = r19
            com.bumptech.glide.request.Request r0 = r0.U2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.o(r15, r0)
            return r14
        L_0x00d5:
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            com.bumptech.glide.request.Request r0 = r0.U2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.e2(java.lang.Object, com.bumptech.glide.request.target.Target, com.bumptech.glide.request.RequestListener, com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.TransitionOptions, com.bumptech.glide.Priority, int, int, com.bumptech.glide.request.BaseRequestOptions, java.util.concurrent.Executor):com.bumptech.glide.request.Request");
    }

    @NonNull
    private Priority n2(@NonNull Priority priority) {
        int i2 = AnonymousClass1.f17738b[priority.ordinal()];
        if (i2 == 1) {
            return Priority.NORMAL;
        }
        if (i2 == 2) {
            return Priority.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + c0());
    }

    @SuppressLint({"CheckResult"})
    private void p2(List<RequestListener<Object>> list) {
        for (RequestListener<Object> U1 : list) {
            U1(U1);
        }
    }

    private <Y extends Target<TranscodeType>> Y u2(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        Preconditions.d(y);
        if (this.a4) {
            Request b2 = b2(y, requestListener, baseRequestOptions, executor);
            Request q = y.q();
            if (!b2.d(q) || C2(baseRequestOptions, q)) {
                this.P3.C(y);
                y.j(b2);
                this.P3.b0(y, b2);
                return y;
            }
            if (!((Request) Preconditions.d(q)).isRunning()) {
                q.j();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @NonNull
    public ViewTarget<ImageView, TranscodeType> B2(@NonNull ImageView imageView) {
        BaseRequestOptions baseRequestOptions;
        Util.b();
        Preconditions.d(imageView);
        if (!E0() && C0() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f17737a[imageView.getScaleType().ordinal()]) {
                case 1:
                    baseRequestOptions = clone().K0();
                    break;
                case 2:
                case 6:
                    baseRequestOptions = clone().L0();
                    break;
                case 3:
                case 4:
                case 5:
                    baseRequestOptions = clone().O0();
                    break;
            }
        }
        baseRequestOptions = this;
        return (ViewTarget) u2(this.S3.a(imageView, this.Q3), (RequestListener) null, baseRequestOptions, Executors.b());
    }

    @CheckResult
    @NonNull
    public RequestBuilder<TranscodeType> E2(@Nullable RequestListener<TranscodeType> requestListener) {
        this.V3 = null;
        return U1(requestListener);
    }

    @CheckResult
    @NonNull
    /* renamed from: G2 */
    public RequestBuilder<TranscodeType> m(@Nullable Bitmap bitmap) {
        return T2(bitmap).a(RequestOptions.f2(DiskCacheStrategy.f17908b));
    }

    @CheckResult
    @NonNull
    /* renamed from: I2 */
    public RequestBuilder<TranscodeType> l(@Nullable Drawable drawable) {
        return T2(drawable).a(RequestOptions.f2(DiskCacheStrategy.f17908b));
    }

    @CheckResult
    @NonNull
    /* renamed from: J2 */
    public RequestBuilder<TranscodeType> g(@Nullable Uri uri) {
        return T2(uri);
    }

    @CheckResult
    @NonNull
    /* renamed from: L2 */
    public RequestBuilder<TranscodeType> i(@Nullable File file) {
        return T2(file);
    }

    @CheckResult
    @NonNull
    /* renamed from: M2 */
    public RequestBuilder<TranscodeType> o(@RawRes @DrawableRes @Nullable Integer num) {
        return T2(num).a(RequestOptions.L2(AndroidResourceSignature.c(this.O3)));
    }

    @CheckResult
    @NonNull
    /* renamed from: N2 */
    public RequestBuilder<TranscodeType> n(@Nullable Object obj) {
        return T2(obj);
    }

    @CheckResult
    @NonNull
    /* renamed from: P2 */
    public RequestBuilder<TranscodeType> t(@Nullable String str) {
        return T2(str);
    }

    @CheckResult
    @Deprecated
    /* renamed from: Q2 */
    public RequestBuilder<TranscodeType> f(@Nullable URL url) {
        return T2(url);
    }

    @CheckResult
    @NonNull
    /* renamed from: S2 */
    public RequestBuilder<TranscodeType> h(@Nullable byte[] bArr) {
        RequestBuilder<TranscodeType> T2 = T2(bArr);
        if (!T2.r0()) {
            T2 = T2.a(RequestOptions.f2(DiskCacheStrategy.f17908b));
        }
        return !T2.z0() ? T2.a(RequestOptions.N2(true)) : T2;
    }

    @CheckResult
    @NonNull
    public RequestBuilder<TranscodeType> U1(@Nullable RequestListener<TranscodeType> requestListener) {
        if (requestListener != null) {
            if (this.V3 == null) {
                this.V3 = new ArrayList();
            }
            this.V3.add(requestListener);
        }
        return this;
    }

    @NonNull
    public Target<TranscodeType> V2() {
        return W2(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public Target<TranscodeType> W2(int i2, int i3) {
        return r2(PreloadTarget.g(this.P3, i2, i3));
    }

    @NonNull
    public FutureTarget<TranscodeType> X2() {
        return Y2(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public FutureTarget<TranscodeType> Y2(int i2, int i3) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i2, i3);
        return (FutureTarget) w2(requestFutureTarget, requestFutureTarget, Executors.a());
    }

    @CheckResult
    @NonNull
    public RequestBuilder<TranscodeType> Z2(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.Y3 = Float.valueOf(f2);
        return this;
    }

    @CheckResult
    @NonNull
    /* renamed from: a2 */
    public RequestBuilder<TranscodeType> a(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        Preconditions.d(baseRequestOptions);
        return (RequestBuilder) super.a(baseRequestOptions);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<TranscodeType> a3(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        this.W3 = requestBuilder;
        return this;
    }

    @CheckResult
    @NonNull
    public RequestBuilder<TranscodeType> b3(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        RequestBuilder<TranscodeType> requestBuilder = null;
        if (requestBuilderArr == null || requestBuilderArr.length == 0) {
            return a3((RequestBuilder) null);
        }
        for (int length = requestBuilderArr.length - 1; length >= 0; length--) {
            RequestBuilder<TranscodeType> requestBuilder2 = requestBuilderArr[length];
            if (requestBuilder2 != null) {
                requestBuilder = requestBuilder == null ? requestBuilder2 : requestBuilder2.a3(requestBuilder);
            }
        }
        return a3(requestBuilder);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<TranscodeType> c3(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.T3 = (TransitionOptions) Preconditions.d(transitionOptions);
        this.Z3 = false;
        return this;
    }

    @CheckResult
    /* renamed from: f2 */
    public RequestBuilder<TranscodeType> p() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.T3 = requestBuilder.T3.clone();
        return requestBuilder;
    }

    @CheckResult
    @Deprecated
    public FutureTarget<File> g2(int i2, int i3) {
        return m2().Y2(i2, i3);
    }

    @CheckResult
    @Deprecated
    public <Y extends Target<File>> Y i2(@NonNull Y y) {
        return m2().r2(y);
    }

    @NonNull
    public RequestBuilder<TranscodeType> j2(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        this.X3 = requestBuilder;
        return this;
    }

    /* access modifiers changed from: protected */
    @CheckResult
    @NonNull
    public RequestBuilder<File> m2() {
        return new RequestBuilder(File.class, this).a(c4);
    }

    @Deprecated
    public FutureTarget<TranscodeType> q2(int i2, int i3) {
        return Y2(i2, i3);
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y r2(@NonNull Y y) {
        return w2(y, (RequestListener) null, Executors.b());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public <Y extends Target<TranscodeType>> Y w2(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener, Executor executor) {
        return u2(y, requestListener, this, executor);
    }

    @SuppressLint({"CheckResult"})
    protected RequestBuilder(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        this(requestBuilder.R3, requestBuilder.P3, cls, requestBuilder.O3);
        this.U3 = requestBuilder.U3;
        this.a4 = requestBuilder.a4;
        a(requestBuilder);
    }
}
