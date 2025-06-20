package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public final /* synthetic */ class B implements Callable {
    public final /* synthetic */ Object X;
    public final /* synthetic */ Object[] Y;
    public final /* synthetic */ Method s;

    public /* synthetic */ B(Method method, Object obj, Object[] objArr) {
        this.s = method;
        this.X = obj;
        this.Y = objArr;
    }

    public final Object call() {
        return SimpleTimeLimiter.AnonymousClass1.b(this.s, this.X, this.Y);
    }
}
