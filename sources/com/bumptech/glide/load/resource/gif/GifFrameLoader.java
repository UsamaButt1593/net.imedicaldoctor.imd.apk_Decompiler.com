package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {

    /* renamed from: a  reason: collision with root package name */
    private final GifDecoder f18381a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f18382b;

    /* renamed from: c  reason: collision with root package name */
    private final List<FrameCallback> f18383c;

    /* renamed from: d  reason: collision with root package name */
    final RequestManager f18384d;

    /* renamed from: e  reason: collision with root package name */
    private final BitmapPool f18385e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18386f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18387g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18388h;

    /* renamed from: i  reason: collision with root package name */
    private RequestBuilder<Bitmap> f18389i;

    /* renamed from: j  reason: collision with root package name */
    private DelayTarget f18390j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18391k;

    /* renamed from: l  reason: collision with root package name */
    private DelayTarget f18392l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f18393m;

    /* renamed from: n  reason: collision with root package name */
    private Transformation<Bitmap> f18394n;
    private DelayTarget o;
    @Nullable
    private OnEveryFrameListener p;
    private int q;
    private int r;
    private int s;

    @VisibleForTesting
    static class DelayTarget extends CustomTarget<Bitmap> {
        final int X2;
        private final long Y2;
        private final Handler Z;
        private Bitmap Z2;

        DelayTarget(Handler handler, int i2, long j2) {
            this.Z = handler;
            this.X2 = i2;
            this.Y2 = j2;
        }

        /* access modifiers changed from: package-private */
        public Bitmap f() {
            return this.Z2;
        }

        /* renamed from: g */
        public void e(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            this.Z2 = bitmap;
            this.Z.sendMessageAtTime(this.Z.obtainMessage(1, this), this.Y2);
        }

        public void r(@Nullable Drawable drawable) {
            this.Z2 = null;
        }
    }

    public interface FrameCallback {
        void a();
    }

    private class FrameLoaderCallback implements Handler.Callback {
        static final int X = 1;
        static final int Y = 2;

        FrameLoaderCallback() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                GifFrameLoader.this.o((DelayTarget) message.obj);
                return true;
            } else if (i2 != 2) {
                return false;
            } else {
                GifFrameLoader.this.f18384d.C((DelayTarget) message.obj);
                return false;
            }
        }
    }

    @VisibleForTesting
    interface OnEveryFrameListener {
        void a();
    }

    GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i2, int i3, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.g(), Glide.D(glide.i()), gifDecoder, (Handler) null, k(Glide.D(glide.i()), i2, i3), transformation, bitmap);
    }

    private static Key g() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    private static RequestBuilder<Bitmap> k(RequestManager requestManager, int i2, int i3) {
        return requestManager.x().a(((RequestOptions) ((RequestOptions) RequestOptions.f2(DiskCacheStrategy.f17908b).S1(true)).w1(true)).c1(i2, i3));
    }

    private void n() {
        if (this.f18386f && !this.f18387g) {
            if (this.f18388h) {
                Preconditions.a(this.o == null, "Pending target must be null when starting from the first frame");
                this.f18381a.m();
                this.f18388h = false;
            }
            DelayTarget delayTarget = this.o;
            if (delayTarget != null) {
                this.o = null;
                o(delayTarget);
                return;
            }
            this.f18387g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f18381a.j());
            this.f18381a.g();
            this.f18392l = new DelayTarget(this.f18382b, this.f18381a.o(), uptimeMillis);
            this.f18389i.a(RequestOptions.L2(g())).n(this.f18381a).r2(this.f18392l);
        }
    }

    private void p() {
        Bitmap bitmap = this.f18393m;
        if (bitmap != null) {
            this.f18385e.e(bitmap);
            this.f18393m = null;
        }
    }

    private void t() {
        if (!this.f18386f) {
            this.f18386f = true;
            this.f18391k = false;
            n();
        }
    }

    private void u() {
        this.f18386f = false;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f18383c.clear();
        p();
        u();
        DelayTarget delayTarget = this.f18390j;
        if (delayTarget != null) {
            this.f18384d.C(delayTarget);
            this.f18390j = null;
        }
        DelayTarget delayTarget2 = this.f18392l;
        if (delayTarget2 != null) {
            this.f18384d.C(delayTarget2);
            this.f18392l = null;
        }
        DelayTarget delayTarget3 = this.o;
        if (delayTarget3 != null) {
            this.f18384d.C(delayTarget3);
            this.o = null;
        }
        this.f18381a.clear();
        this.f18391k = true;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f18381a.getData().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public Bitmap c() {
        DelayTarget delayTarget = this.f18390j;
        return delayTarget != null ? delayTarget.f() : this.f18393m;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        DelayTarget delayTarget = this.f18390j;
        if (delayTarget != null) {
            return delayTarget.X2;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public Bitmap e() {
        return this.f18393m;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f18381a.i();
    }

    /* access modifiers changed from: package-private */
    public Transformation<Bitmap> h() {
        return this.f18394n;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f18381a.s();
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return this.f18381a.r() + this.q;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void o(DelayTarget delayTarget) {
        OnEveryFrameListener onEveryFrameListener = this.p;
        if (onEveryFrameListener != null) {
            onEveryFrameListener.a();
        }
        this.f18387g = false;
        if (this.f18391k) {
            this.f18382b.obtainMessage(2, delayTarget).sendToTarget();
        } else if (!this.f18386f) {
            this.o = delayTarget;
        } else {
            if (delayTarget.f() != null) {
                p();
                DelayTarget delayTarget2 = this.f18390j;
                this.f18390j = delayTarget;
                for (int size = this.f18383c.size() - 1; size >= 0; size--) {
                    this.f18383c.get(size).a();
                }
                if (delayTarget2 != null) {
                    this.f18382b.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            n();
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, java.lang.Object, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3, android.graphics.Bitmap r4) {
        /*
            r2 = this;
            java.lang.Object r0 = com.bumptech.glide.util.Preconditions.d(r3)
            com.bumptech.glide.load.Transformation r0 = (com.bumptech.glide.load.Transformation) r0
            r2.f18394n = r0
            java.lang.Object r0 = com.bumptech.glide.util.Preconditions.d(r4)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r2.f18393m = r0
            com.bumptech.glide.RequestBuilder<android.graphics.Bitmap> r0 = r2.f18389i
            com.bumptech.glide.request.RequestOptions r1 = new com.bumptech.glide.request.RequestOptions
            r1.<init>()
            com.bumptech.glide.request.BaseRequestOptions r3 = r1.A1(r3)
            com.bumptech.glide.RequestBuilder r3 = r0.a(r3)
            r2.f18389i = r3
            int r3 = com.bumptech.glide.util.Util.h(r4)
            r2.q = r3
            int r3 = r4.getWidth()
            r2.r = r3
            int r3 = r4.getHeight()
            r2.s = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.GifFrameLoader.q(com.bumptech.glide.load.Transformation, android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: package-private */
    public void r() {
        Preconditions.a(!this.f18386f, "Can't restart a running animation");
        this.f18388h = true;
        DelayTarget delayTarget = this.o;
        if (delayTarget != null) {
            this.f18384d.C(delayTarget);
            this.o = null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void s(@Nullable OnEveryFrameListener onEveryFrameListener) {
        this.p = onEveryFrameListener;
    }

    /* access modifiers changed from: package-private */
    public void v(FrameCallback frameCallback) {
        if (this.f18391k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f18383c.contains(frameCallback)) {
            boolean isEmpty = this.f18383c.isEmpty();
            this.f18383c.add(frameCallback);
            if (isEmpty) {
                t();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: package-private */
    public void w(FrameCallback frameCallback) {
        this.f18383c.remove(frameCallback);
        if (this.f18383c.isEmpty()) {
            u();
        }
    }

    GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f18383c = new ArrayList();
        this.f18384d = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback()) : handler;
        this.f18385e = bitmapPool;
        this.f18382b = handler;
        this.f18389i = requestBuilder;
        this.f18381a = gifDecoder;
        q(transformation, bitmap);
    }
}
