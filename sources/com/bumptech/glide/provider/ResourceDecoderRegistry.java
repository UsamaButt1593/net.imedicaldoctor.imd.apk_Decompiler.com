package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDecoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f18437a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<Entry<?, ?>>> f18438b = new HashMap();

    private static class Entry<T, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f18439a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f18440b;

        /* renamed from: c  reason: collision with root package name */
        final ResourceDecoder<T, R> f18441c;

        public Entry(@NonNull Class<T> cls, @NonNull Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.f18439a = cls;
            this.f18440b = cls2;
            this.f18441c = resourceDecoder;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f18439a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f18440b);
        }
    }

    @NonNull
    private synchronized List<Entry<?, ?>> c(@NonNull String str) {
        List<Entry<?, ?>> list;
        try {
            if (!this.f18437a.contains(str)) {
                this.f18437a.add(str);
            }
            list = this.f18438b.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.f18438b.put(str, list);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return list;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(new Entry(cls, cls2, resourceDecoder));
    }

    @NonNull
    public synchronized <T, R> List<ResourceDecoder<T, R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f18437a) {
            List<Entry> list = this.f18438b.get(str);
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.a(cls, cls2)) {
                        arrayList.add(entry.f18441c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> d(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f18437a) {
            List<Entry> list = this.f18438b.get(str);
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.a(cls, cls2) && !arrayList.contains(entry.f18440b)) {
                        arrayList.add(entry.f18440b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void e(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(0, new Entry(cls, cls2, resourceDecoder));
    }

    public synchronized void f(@NonNull List<String> list) {
        try {
            ArrayList<String> arrayList = new ArrayList<>(this.f18437a);
            this.f18437a.clear();
            for (String add : list) {
                this.f18437a.add(add);
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.f18437a.add(str);
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }
}
