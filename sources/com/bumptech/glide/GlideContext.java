package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;

public class GlideContext extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    static final TransitionOptions<?, ?> f17613k = new GenericTransitionOptions();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayPool f17614a;

    /* renamed from: b  reason: collision with root package name */
    private final Registry f17615b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageViewTargetFactory f17616c;

    /* renamed from: d  reason: collision with root package name */
    private final Glide.RequestOptionsFactory f17617d;

    /* renamed from: e  reason: collision with root package name */
    private final List<RequestListener<Object>> f17618e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, TransitionOptions<?, ?>> f17619f;

    /* renamed from: g  reason: collision with root package name */
    private final Engine f17620g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f17621h;

    /* renamed from: i  reason: collision with root package name */
    private final int f17622i;
    @GuardedBy("this")
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private RequestOptions f17623j;

    public GlideContext(@NonNull Context context, @NonNull ArrayPool arrayPool, @NonNull Registry registry, @NonNull ImageViewTargetFactory imageViewTargetFactory, @NonNull Glide.RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, @NonNull Engine engine, boolean z, int i2) {
        super(context.getApplicationContext());
        this.f17614a = arrayPool;
        this.f17615b = registry;
        this.f17616c = imageViewTargetFactory;
        this.f17617d = requestOptionsFactory;
        this.f17618e = list;
        this.f17619f = map;
        this.f17620g = engine;
        this.f17621h = z;
        this.f17622i = i2;
    }

    @NonNull
    public <X> ViewTarget<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f17616c.a(imageView, cls);
    }

    @NonNull
    public ArrayPool b() {
        return this.f17614a;
    }

    public List<RequestListener<Object>> c() {
        return this.f17618e;
    }

    public synchronized RequestOptions d() {
        try {
            if (this.f17623j == null) {
                this.f17623j = (RequestOptions) this.f17617d.build().G0();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f17623j;
    }

    @NonNull
    public <T> TransitionOptions<?, T> e(@NonNull Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = this.f17619f.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry next : this.f17619f.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions) next.getValue();
                }
            }
        }
        return transitionOptions == null ? f17613k : transitionOptions;
    }

    @NonNull
    public Engine f() {
        return this.f17620g;
    }

    public int g() {
        return this.f17622i;
    }

    @NonNull
    public Registry h() {
        return this.f17615b;
    }

    public boolean i() {
        return this.f17621h;
    }
}
