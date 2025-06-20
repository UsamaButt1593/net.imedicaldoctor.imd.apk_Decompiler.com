package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

public class EncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?>> f18428a = new ArrayList();

    private static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f18429a;

        /* renamed from: b  reason: collision with root package name */
        final Encoder<T> f18430b;

        Entry(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            this.f18429a = cls;
            this.f18430b = encoder;
        }

        /* access modifiers changed from: package-private */
        public boolean a(@NonNull Class<?> cls) {
            return this.f18429a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f18428a.add(new Entry(cls, encoder));
    }

    @Nullable
    public synchronized <T> Encoder<T> b(@NonNull Class<T> cls) {
        for (Entry next : this.f18428a) {
            if (next.a(cls)) {
                return next.f18430b;
            }
        }
        return null;
    }

    public synchronized <T> void c(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f18428a.add(0, new Entry(cls, encoder));
    }
}
