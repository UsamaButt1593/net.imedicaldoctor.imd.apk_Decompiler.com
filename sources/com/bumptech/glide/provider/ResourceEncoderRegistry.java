package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

public class ResourceEncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?>> f18442a = new ArrayList();

    private static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f18443a;

        /* renamed from: b  reason: collision with root package name */
        final ResourceEncoder<T> f18444b;

        Entry(@NonNull Class<T> cls, @NonNull ResourceEncoder<T> resourceEncoder) {
            this.f18443a = cls;
            this.f18444b = resourceEncoder;
        }

        /* access modifiers changed from: package-private */
        public boolean a(@NonNull Class<?> cls) {
            return this.f18443a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f18442a.add(new Entry(cls, resourceEncoder));
    }

    @Nullable
    public synchronized <Z> ResourceEncoder<Z> b(@NonNull Class<Z> cls) {
        int size = this.f18442a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Entry entry = this.f18442a.get(i2);
            if (entry.a(cls)) {
                return entry.f18444b;
            }
        }
        return null;
    }

    public synchronized <Z> void c(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f18442a.add(0, new Entry(cls, resourceEncoder));
    }
}
