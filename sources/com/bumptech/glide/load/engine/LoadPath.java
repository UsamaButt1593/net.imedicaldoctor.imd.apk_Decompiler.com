package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadPath<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f17953a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17954b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> f17955c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17956d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f17953a = cls;
        this.f17954b = pool;
        this.f17955c = (List) Preconditions.c(list);
        this.f17956d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource<Transcode> c(DataRewinder<Data> dataRewinder, @NonNull Options options, int i2, int i3, DecodePath.DecodeCallback<ResourceType> decodeCallback, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.f17955c.size();
        Resource<Transcode> resource = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                resource = ((DecodePath) this.f17955c.get(i4)).a(dataRewinder, i2, i3, options, decodeCallback);
            } catch (GlideException e2) {
                list2.add(e2);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f17956d, (List<Throwable>) new ArrayList(list2));
    }

    public Class<Data> a() {
        return this.f17953a;
    }

    public Resource<Transcode> b(DataRewinder<Data> dataRewinder, @NonNull Options options, int i2, int i3, DecodePath.DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        List list = (List) Preconditions.d(this.f17954b.b());
        try {
            return c(dataRewinder, options, i2, i3, decodeCallback, list);
        } finally {
            this.f17954b.c(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f17955c.toArray()) + ASCIIPropertyListParser.f18653k;
    }
}
