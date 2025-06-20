package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class TranscoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?, ?>> f18408a = new ArrayList();

    private static final class Entry<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Z> f18409a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<R> f18410b;

        /* renamed from: c  reason: collision with root package name */
        final ResourceTranscoder<Z, R> f18411c;

        Entry(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
            this.f18409a = cls;
            this.f18410b = cls2;
            this.f18411c = resourceTranscoder;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f18409a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f18410b);
        }
    }

    @NonNull
    public synchronized <Z, R> ResourceTranscoder<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.b();
        }
        for (Entry next : this.f18408a) {
            if (next.a(cls, cls2)) {
                return next.f18411c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (Entry<?, ?> a2 : this.f18408a) {
            if (a2.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
        this.f18408a.add(new Entry(cls, cls2, resourceTranscoder));
    }
}
