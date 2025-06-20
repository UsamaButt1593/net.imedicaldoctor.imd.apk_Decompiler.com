package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

public interface ResourceCallback {
    void a(GlideException glideException);

    void c(Resource<?> resource, DataSource dataSource);

    Object g();
}
