package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    private static final RequestOptions f3 = ((RequestOptions) RequestOptions.e2(Bitmap.class).G0());
    private static final RequestOptions g3 = ((RequestOptions) RequestOptions.e2(GifDrawable.class).G0());
    private static final RequestOptions h3 = ((RequestOptions) ((RequestOptions) RequestOptions.f2(DiskCacheStrategy.f17909c).g1(Priority.LOW)).w1(true));
    protected final Context X;
    @GuardedBy("this")
    private final RequestManagerTreeNode X2;
    final Lifecycle Y;
    @GuardedBy("this")
    private final TargetTracker Y2;
    @GuardedBy("this")
    private final RequestTracker Z;
    private final Runnable Z2;
    private final Handler a3;
    private final ConnectivityMonitor b3;
    private final CopyOnWriteArrayList<RequestListener<Object>> c3;
    @GuardedBy("this")
    private RequestOptions d3;
    private boolean e3;
    protected final Glide s;

    private static class ClearTarget extends CustomViewTarget<View, Object> {
        ClearTarget(@NonNull View view) {
            super(view);
        }

        public void e(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        public void k(@Nullable Drawable drawable) {
        }

        /* access modifiers changed from: protected */
        public void m(@Nullable Drawable drawable) {
        }
    }

    private class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        @GuardedBy("RequestManager.this")

        /* renamed from: a  reason: collision with root package name */
        private final RequestTracker f17739a;

        RequestManagerConnectivityListener(@NonNull RequestTracker requestTracker) {
            this.f17739a = requestTracker;
        }

        public void a(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    this.f17739a.g();
                }
            }
        }
    }

    public RequestManager(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.h(), context);
    }

    private void d0(@NonNull Target<?> target) {
        boolean c0 = c0(target);
        Request q = target.q();
        if (!c0 && !this.s.v(target) && q != null) {
            target.j((Request) null);
            q.clear();
        }
    }

    private synchronized void e0(@NonNull RequestOptions requestOptions) {
        this.d3 = (RequestOptions) this.d3.a(requestOptions);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<GifDrawable> A() {
        return w(GifDrawable.class).a(g3);
    }

    public void B(@NonNull View view) {
        C(new ClearTarget(view));
    }

    public void C(@Nullable Target<?> target) {
        if (target != null) {
            d0(target);
        }
    }

    @CheckResult
    @NonNull
    public RequestBuilder<File> D(@Nullable Object obj) {
        return E().n(obj);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<File> E() {
        return w(File.class).a(h3);
    }

    /* access modifiers changed from: package-private */
    public List<RequestListener<Object>> F() {
        return this.c3;
    }

    /* access modifiers changed from: package-private */
    public synchronized RequestOptions G() {
        return this.d3;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public <T> TransitionOptions<?, T> H(Class<T> cls) {
        return this.s.j().e(cls);
    }

    public synchronized boolean I() {
        return this.Z.d();
    }

    @CheckResult
    @NonNull
    /* renamed from: J */
    public RequestBuilder<Drawable> m(@Nullable Bitmap bitmap) {
        return y().m(bitmap);
    }

    @CheckResult
    @NonNull
    /* renamed from: K */
    public RequestBuilder<Drawable> l(@Nullable Drawable drawable) {
        return y().l(drawable);
    }

    @CheckResult
    @NonNull
    /* renamed from: L */
    public RequestBuilder<Drawable> g(@Nullable Uri uri) {
        return y().g(uri);
    }

    @CheckResult
    @NonNull
    /* renamed from: M */
    public RequestBuilder<Drawable> i(@Nullable File file) {
        return y().i(file);
    }

    @CheckResult
    @NonNull
    /* renamed from: N */
    public RequestBuilder<Drawable> o(@RawRes @DrawableRes @Nullable Integer num) {
        return y().o(num);
    }

    @CheckResult
    @NonNull
    /* renamed from: O */
    public RequestBuilder<Drawable> n(@Nullable Object obj) {
        return y().n(obj);
    }

    @CheckResult
    @NonNull
    /* renamed from: P */
    public RequestBuilder<Drawable> t(@Nullable String str) {
        return y().t(str);
    }

    @CheckResult
    @Deprecated
    /* renamed from: Q */
    public RequestBuilder<Drawable> f(@Nullable URL url) {
        return y().f(url);
    }

    @CheckResult
    @NonNull
    /* renamed from: R */
    public RequestBuilder<Drawable> h(@Nullable byte[] bArr) {
        return y().h(bArr);
    }

    public synchronized void S() {
        this.Z.e();
    }

    public synchronized void T() {
        S();
        for (RequestManager S : this.X2.a()) {
            S.S();
        }
    }

    public synchronized void U() {
        this.Z.f();
    }

    public synchronized void V() {
        U();
        for (RequestManager U : this.X2.a()) {
            U.U();
        }
    }

    public synchronized void W() {
        this.Z.h();
    }

    public synchronized void X() {
        Util.b();
        W();
        for (RequestManager W : this.X2.a()) {
            W.W();
        }
    }

    @NonNull
    public synchronized RequestManager Y(@NonNull RequestOptions requestOptions) {
        a0(requestOptions);
        return this;
    }

    public void Z(boolean z) {
        this.e3 = z;
    }

    public synchronized void a() {
        W();
        this.Y2.a();
    }

    /* access modifiers changed from: protected */
    public synchronized void a0(@NonNull RequestOptions requestOptions) {
        this.d3 = (RequestOptions) ((RequestOptions) requestOptions.clone()).b();
    }

    public synchronized void b() {
        try {
            this.Y2.b();
            for (Target<?> C : this.Y2.g()) {
                C(C);
            }
            this.Y2.f();
            this.Z.c();
            this.Y.b(this);
            this.Y.b(this.b3);
            this.a3.removeCallbacks(this.Z2);
            this.s.A(this);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void b0(@NonNull Target<?> target, @NonNull Request request) {
        this.Y2.h(target);
        this.Z.i(request);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean c0(@NonNull Target<?> target) {
        Request q = target.q();
        if (q == null) {
            return true;
        }
        if (!this.Z.b(q)) {
            return false;
        }
        this.Y2.i(target);
        target.j((Request) null);
        return true;
    }

    public synchronized void d() {
        U();
        this.Y2.d();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.e3) {
            T();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.Z + ", treeNode=" + this.X2 + "}";
    }

    public RequestManager u(RequestListener<Object> requestListener) {
        this.c3.add(requestListener);
        return this;
    }

    @NonNull
    public synchronized RequestManager v(@NonNull RequestOptions requestOptions) {
        e0(requestOptions);
        return this;
    }

    @CheckResult
    @NonNull
    public <ResourceType> RequestBuilder<ResourceType> w(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.s, this, cls, this.X);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Bitmap> x() {
        return w(Bitmap.class).a(f3);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Drawable> y() {
        return w(Drawable.class);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<File> z() {
        return w(File.class).a(RequestOptions.N2(true));
    }

    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.Y2 = new TargetTracker();
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.Y.a(requestManager);
            }
        };
        this.Z2 = r0;
        Handler handler = new Handler(Looper.getMainLooper());
        this.a3 = handler;
        this.s = glide;
        this.Y = lifecycle;
        this.X2 = requestManagerTreeNode;
        this.Z = requestTracker;
        this.X = context;
        ConnectivityMonitor a2 = connectivityMonitorFactory.a(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        this.b3 = a2;
        if (Util.s()) {
            handler.post(r0);
        } else {
            lifecycle.a(this);
        }
        lifecycle.a(a2);
        this.c3 = new CopyOnWriteArrayList<>(glide.j().c());
        a0(glide.j().d());
        glide.u(this);
    }
}
