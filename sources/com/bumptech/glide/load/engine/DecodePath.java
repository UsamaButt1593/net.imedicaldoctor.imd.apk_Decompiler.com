package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f17901f = "DecodePath";

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f17902a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends ResourceDecoder<DataType, ResourceType>> f17903b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceTranscoder<ResourceType, Transcode> f17904c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17905d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17906e;

    interface DecodeCallback<ResourceType> {
        @NonNull
        Resource<ResourceType> a(@NonNull Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.f17902a = cls;
        this.f17903b = list;
        this.f17904c = resourceTranscoder;
        this.f17905d = pool;
        this.f17906e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private Resource<ResourceType> b(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull Options options) throws GlideException {
        List list = (List) Preconditions.d(this.f17905d.b());
        try {
            return c(dataRewinder, i2, i3, options, list);
        } finally {
            this.f17905d.c(list);
        }
    }

    @NonNull
    private Resource<ResourceType> c(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull Options options, List<Throwable> list) throws GlideException {
        int size = this.f17903b.size();
        Resource<ResourceType> resource = null;
        for (int i4 = 0; i4 < size; i4++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.f17903b.get(i4);
            try {
                if (resourceDecoder.a(dataRewinder.a(), options)) {
                    resource = resourceDecoder.b(dataRewinder.a(), i2, i3, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable(f17901f, 2)) {
                    Log.v(f17901f, "Failed to decode data for " + resourceDecoder, e2);
                }
                list.add(e2);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f17906e, (List<Throwable>) new ArrayList(list));
    }

    public Resource<Transcode> a(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        return this.f17904c.a(decodeCallback.a(b(dataRewinder, i2, i3, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f17902a + ", decoders=" + this.f17903b + ", transcoder=" + this.f17904c + ASCIIPropertyListParser.f18653k;
    }
}
