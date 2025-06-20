package com.google.firebase;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class Timestamp$compareTo$1 extends PropertyReference1Impl {
    public static final Timestamp$compareTo$1 b3 = new Timestamp$compareTo$1();

    Timestamp$compareTo$1() {
        super(Timestamp.class, "seconds", "getSeconds()J", 0);
    }

    @Nullable
    public Object get(@Nullable Object obj) {
        return Long.valueOf(((Timestamp) obj).c());
    }
}
