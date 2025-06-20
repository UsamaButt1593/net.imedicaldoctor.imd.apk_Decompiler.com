package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class Jobs {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Key, EngineJob<?>> f17951a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Key, EngineJob<?>> f17952b = new HashMap();

    Jobs() {
    }

    private Map<Key, EngineJob<?>> c(boolean z) {
        return z ? this.f17952b : this.f17951a;
    }

    /* access modifiers changed from: package-private */
    public EngineJob<?> a(Key key, boolean z) {
        return c(z).get(key);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Map<Key, EngineJob<?>> b() {
        return Collections.unmodifiableMap(this.f17951a);
    }

    /* access modifiers changed from: package-private */
    public void d(Key key, EngineJob<?> engineJob) {
        c(engineJob.q()).put(key, engineJob);
    }

    /* access modifiers changed from: package-private */
    public void e(Key key, EngineJob<?> engineJob) {
        Map<Key, EngineJob<?>> c2 = c(engineJob.q());
        if (engineJob.equals(c2.get(key))) {
            c2.remove(key);
        }
    }
}
