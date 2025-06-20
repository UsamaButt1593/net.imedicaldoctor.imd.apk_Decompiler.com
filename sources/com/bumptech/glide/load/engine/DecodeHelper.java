package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class DecodeHelper<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ModelLoader.LoadData<?>> f17876a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<Key> f17877b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private GlideContext f17878c;

    /* renamed from: d  reason: collision with root package name */
    private Object f17879d;

    /* renamed from: e  reason: collision with root package name */
    private int f17880e;

    /* renamed from: f  reason: collision with root package name */
    private int f17881f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f17882g;

    /* renamed from: h  reason: collision with root package name */
    private DecodeJob.DiskCacheProvider f17883h;

    /* renamed from: i  reason: collision with root package name */
    private Options f17884i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Class<?>, Transformation<?>> f17885j;

    /* renamed from: k  reason: collision with root package name */
    private Class<Transcode> f17886k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f17887l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17888m;

    /* renamed from: n  reason: collision with root package name */
    private Key f17889n;
    private Priority o;
    private DiskCacheStrategy p;
    private boolean q;
    private boolean r;

    DecodeHelper() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f17878c = null;
        this.f17879d = null;
        this.f17889n = null;
        this.f17882g = null;
        this.f17886k = null;
        this.f17884i = null;
        this.o = null;
        this.f17885j = null;
        this.p = null;
        this.f17876a.clear();
        this.f17887l = false;
        this.f17877b.clear();
        this.f17888m = false;
    }

    /* access modifiers changed from: package-private */
    public ArrayPool b() {
        return this.f17878c.b();
    }

    /* access modifiers changed from: package-private */
    public List<Key> c() {
        if (!this.f17888m) {
            this.f17888m = true;
            this.f17877b.clear();
            List<ModelLoader.LoadData<?>> g2 = g();
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.LoadData loadData = g2.get(i2);
                if (!this.f17877b.contains(loadData.f18164a)) {
                    this.f17877b.add(loadData.f18164a);
                }
                for (int i3 = 0; i3 < loadData.f18165b.size(); i3++) {
                    if (!this.f17877b.contains(loadData.f18165b.get(i3))) {
                        this.f17877b.add(loadData.f18165b.get(i3));
                    }
                }
            }
        }
        return this.f17877b;
    }

    /* access modifiers changed from: package-private */
    public DiskCache d() {
        return this.f17883h.a();
    }

    /* access modifiers changed from: package-private */
    public DiskCacheStrategy e() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f17881f;
    }

    /* access modifiers changed from: package-private */
    public List<ModelLoader.LoadData<?>> g() {
        if (!this.f17887l) {
            this.f17887l = true;
            this.f17876a.clear();
            List i2 = this.f17878c.h().i(this.f17879d);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                ModelLoader.LoadData b2 = ((ModelLoader) i2.get(i3)).b(this.f17879d, this.f17880e, this.f17881f, this.f17884i);
                if (b2 != null) {
                    this.f17876a.add(b2);
                }
            }
        }
        return this.f17876a;
    }

    /* access modifiers changed from: package-private */
    public <Data> LoadPath<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f17878c.h().h(cls, this.f17882g, this.f17886k);
    }

    /* access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f17879d.getClass();
    }

    /* access modifiers changed from: package-private */
    public List<ModelLoader<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f17878c.h().i(file);
    }

    /* access modifiers changed from: package-private */
    public Options k() {
        return this.f17884i;
    }

    /* access modifiers changed from: package-private */
    public Priority l() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f17878c.h().j(this.f17879d.getClass(), this.f17882g, this.f17886k);
    }

    /* access modifiers changed from: package-private */
    public <Z> ResourceEncoder<Z> n(Resource<Z> resource) {
        return this.f17878c.h().k(resource);
    }

    /* access modifiers changed from: package-private */
    public Key o() {
        return this.f17889n;
    }

    /* access modifiers changed from: package-private */
    public <X> Encoder<X> p(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f17878c.h().m(x);
    }

    /* access modifiers changed from: package-private */
    public Class<?> q() {
        return this.f17886k;
    }

    /* access modifiers changed from: package-private */
    public <Z> Transformation<Z> r(Class<Z> cls) {
        Transformation<Z> transformation = this.f17885j.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it2 = this.f17885j.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) next.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.f17885j.isEmpty() || !this.q) {
            return UnitTransformation.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.f17880e;
    }

    /* access modifiers changed from: package-private */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* access modifiers changed from: package-private */
    public <R> void u(GlideContext glideContext, Object obj, Key key, int i2, int i3, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, DecodeJob.DiskCacheProvider diskCacheProvider) {
        this.f17878c = glideContext;
        this.f17879d = obj;
        this.f17889n = key;
        this.f17880e = i2;
        this.f17881f = i3;
        this.p = diskCacheStrategy;
        this.f17882g = cls;
        this.f17883h = diskCacheProvider;
        this.f17886k = cls2;
        this.o = priority;
        this.f17884i = options;
        this.f17885j = map;
        this.q = z;
        this.r = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean v(Resource<?> resource) {
        return this.f17878c.h().n(resource);
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public boolean x(Key key) {
        List<ModelLoader.LoadData<?>> g2 = g();
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (g2.get(i2).f18164a.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
