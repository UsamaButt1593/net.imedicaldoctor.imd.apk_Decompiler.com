package com.google.common.escape;

import com.google.common.base.Function;

public final /* synthetic */ class a implements Function {
    public final /* synthetic */ Escaper s;

    public /* synthetic */ a(Escaper escaper) {
        this.s = escaper;
    }

    public final Object apply(Object obj) {
        return this.s.b((String) obj);
    }
}
