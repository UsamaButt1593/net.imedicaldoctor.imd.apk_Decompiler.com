package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.errorprone.annotations.DoNotMock;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@DoNotMock("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
public abstract class Escaper {

    /* renamed from: a  reason: collision with root package name */
    private final Function<String, String> f22535a = new a(this);

    protected Escaper() {
    }

    public final Function<String, String> a() {
        return this.f22535a;
    }

    public abstract String b(String str);
}
