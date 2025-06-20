package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingObject {
    protected ForwardingObject() {
    }

    /* access modifiers changed from: protected */
    public abstract Object Z0();

    public String toString() {
        return Z0().toString();
    }
}
