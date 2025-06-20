package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataRewinderRegistry {

    /* renamed from: b  reason: collision with root package name */
    private static final DataRewinder.Factory<?> f17838b = new DataRewinder.Factory<Object>() {
        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @NonNull
        public DataRewinder<Object> b(@NonNull Object obj) {
            return new DefaultRewinder(obj);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, DataRewinder.Factory<?>> f17839a = new HashMap();

    private static final class DefaultRewinder implements DataRewinder<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f17840a;

        DefaultRewinder(@NonNull Object obj) {
            this.f17840a = obj;
        }

        @NonNull
        public Object a() {
            return this.f17840a;
        }

        public void b() {
        }
    }

    @NonNull
    public synchronized <T> DataRewinder<T> a(@NonNull T t) {
        DataRewinder.Factory<?> factory;
        try {
            Preconditions.d(t);
            factory = this.f17839a.get(t.getClass());
            if (factory == null) {
                Iterator<DataRewinder.Factory<?>> it2 = this.f17839a.values().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    DataRewinder.Factory<?> next = it2.next();
                    if (next.a().isAssignableFrom(t.getClass())) {
                        factory = next;
                        break;
                    }
                }
            }
            if (factory == null) {
                factory = f17838b;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return factory.b(t);
    }

    public synchronized void b(@NonNull DataRewinder.Factory<?> factory) {
        this.f17839a.put(factory.a(), factory);
    }
}
