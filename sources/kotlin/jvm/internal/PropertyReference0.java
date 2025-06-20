package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;

public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    public PropertyReference0() {
    }

    @SinceKotlin(version = "1.1")
    public Object m0() {
        return ((KProperty0) A0()).m0();
    }

    public Object o() {
        return get();
    }

    /* access modifiers changed from: protected */
    public KCallable x0() {
        return Reflection.t(this);
    }

    @SinceKotlin(version = "1.1")
    public PropertyReference0(Object obj) {
        super(obj);
    }

    public KProperty0.Getter a() {
        return ((KProperty0) A0()).a();
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
