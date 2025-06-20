package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {

    /* renamed from: k  reason: collision with root package name */
    public static final String f17723k = "Gif";

    /* renamed from: l  reason: collision with root package name */
    public static final String f17724l = "Bitmap";

    /* renamed from: m  reason: collision with root package name */
    public static final String f17725m = "BitmapDrawable";

    /* renamed from: n  reason: collision with root package name */
    private static final String f17726n = "legacy_prepend_all";
    private static final String o = "legacy_append";

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoaderRegistry f17727a;

    /* renamed from: b  reason: collision with root package name */
    private final EncoderRegistry f17728b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceDecoderRegistry f17729c;

    /* renamed from: d  reason: collision with root package name */
    private final ResourceEncoderRegistry f17730d;

    /* renamed from: e  reason: collision with root package name */
    private final DataRewinderRegistry f17731e;

    /* renamed from: f  reason: collision with root package name */
    private final TranscoderRegistry f17732f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageHeaderParserRegistry f17733g;

    /* renamed from: h  reason: collision with root package name */
    private final ModelToResourceClassCache f17734h = new ModelToResourceClassCache();

    /* renamed from: i  reason: collision with root package name */
    private final LoadPathCache f17735i = new LoadPathCache();

    /* renamed from: j  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17736j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m2, @NonNull List<ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> f2 = FactoryPools.f();
        this.f17736j = f2;
        this.f17727a = new ModelLoaderRegistry(f2);
        this.f17728b = new EncoderRegistry();
        this.f17729c = new ResourceDecoderRegistry();
        this.f17730d = new ResourceEncoderRegistry();
        this.f17731e = new DataRewinderRegistry();
        this.f17732f = new TranscoderRegistry();
        this.f17733g = new ImageHeaderParserRegistry();
        z(Arrays.asList(new String[]{f17723k, f17724l, f17725m}));
    }

    @NonNull
    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.f17729c.d(cls, cls2)) {
            for (Class next2 : this.f17732f.b(next, cls3)) {
                arrayList.add(new DecodePath(cls, next, next2, this.f17729c.b(cls, next), this.f17732f.a(next, next2), this.f17736j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        this.f17728b.a(cls, encoder);
        return this;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        this.f17730d.a(cls, resourceEncoder);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        e(o, cls, cls2, resourceDecoder);
        return this;
    }

    @NonNull
    public <Model, Data> Registry d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f17727a.a(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f17729c.a(str, resourceDecoder, cls, cls2);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b2 = this.f17733g.b();
        if (!b2.isEmpty()) {
            return b2;
        }
        throw new NoImageHeaderParserException();
    }

    @Nullable
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> a2 = this.f17735i.a(cls, cls2, cls3);
        if (this.f17735i.c(a2)) {
            return null;
        }
        if (a2 == null) {
            List<DecodePath<Data, TResource, Transcode>> f2 = f(cls, cls2, cls3);
            if (f2.isEmpty()) {
                a2 = null;
            } else {
                a2 = new LoadPath<>(cls, cls2, cls3, f2, this.f17736j);
            }
            this.f17735i.d(cls, cls2, cls3, a2);
        }
        return a2;
    }

    @NonNull
    public <Model> List<ModelLoader<Model, ?>> i(@NonNull Model model) {
        return this.f17727a.e(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> b2 = this.f17734h.b(cls, cls2, cls3);
        if (b2 == null) {
            b2 = new ArrayList<>();
            for (Class<?> d2 : this.f17727a.d(cls)) {
                for (Class next : this.f17729c.d(d2, cls2)) {
                    if (!this.f17732f.b(next, cls3).isEmpty() && !b2.contains(next)) {
                        b2.add(next);
                    }
                }
            }
            this.f17734h.c(cls, cls2, cls3, Collections.unmodifiableList(b2));
        }
        return b2;
    }

    @NonNull
    public <X> ResourceEncoder<X> k(@NonNull Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> b2 = this.f17730d.b(resource.c());
        if (b2 != null) {
            return b2;
        }
        throw new NoResultEncoderAvailableException(resource.c());
    }

    @NonNull
    public <X> DataRewinder<X> l(@NonNull X x) {
        return this.f17731e.a(x);
    }

    @NonNull
    public <X> Encoder<X> m(@NonNull X x) throws NoSourceEncoderAvailableException {
        Encoder<X> b2 = this.f17728b.b(x.getClass());
        if (b2 != null) {
            return b2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean n(@NonNull Resource<?> resource) {
        return this.f17730d.b(resource.c()) != null;
    }

    @NonNull
    public <Data> Registry o(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        this.f17728b.c(cls, encoder);
        return this;
    }

    @NonNull
    public <TResource> Registry p(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        this.f17730d.c(cls, resourceEncoder);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry q(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        s(f17726n, cls, cls2, resourceDecoder);
        return this;
    }

    @NonNull
    public <Model, Data> Registry r(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f17727a.g(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry s(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f17729c.e(str, resourceDecoder, cls, cls2);
        return this;
    }

    @NonNull
    public Registry t(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f17733g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry u(@NonNull DataRewinder.Factory<?> factory) {
        this.f17731e.b(factory);
        return this;
    }

    @NonNull
    @Deprecated
    public <Data> Registry v(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        return a(cls, encoder);
    }

    @NonNull
    @Deprecated
    public <TResource> Registry w(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        return b(cls, resourceEncoder);
    }

    @NonNull
    public <TResource, Transcode> Registry x(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f17732f.c(cls, cls2, resourceTranscoder);
        return this;
    }

    @NonNull
    public <Model, Data> Registry y(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f17727a.i(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    public final Registry z(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, f17726n);
        arrayList.add(o);
        this.f17729c.f(arrayList);
        return this;
    }
}
