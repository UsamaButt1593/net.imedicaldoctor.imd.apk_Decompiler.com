package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;

public final class zab {

    /* renamed from: a  reason: collision with root package name */
    public final Set<Scope> f20282a;

    public zab(Set<Scope> set) {
        Preconditions.r(set);
        this.f20282a = Collections.unmodifiableSet(set);
    }
}
