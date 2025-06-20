package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

public interface Headers {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final Headers f18144a = new Headers() {
        public Map<String, String> a() {
            return Collections.emptyMap();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Headers f18145b = new LazyHeaders.Builder().c();

    Map<String, String> a();
}
