package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    public MutablePropertyReference0() {
    }

    @SinceKotlin(version = "1.1")
    public Object m0() {
        return ((KMutableProperty0) A0()).m0();
    }

    public Object o() {
        return get();
    }

    /* access modifiers changed from: protected */
    public KCallable x0() {
        return Reflection.j(this);
    }

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    public KProperty0.Getter a() {
        return ((KMutableProperty0) A0()).a();
    }

    public KMutableProperty0.Setter c() {
        return ((KMutableProperty0) A0()).c();
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
