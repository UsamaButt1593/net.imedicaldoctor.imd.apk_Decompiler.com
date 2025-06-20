package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;

public abstract class PropertyReference1 extends PropertyReference implements KProperty1 {
    public PropertyReference1() {
    }

    public Object f(Object obj) {
        return get(obj);
    }

    @SinceKotlin(version = "1.1")
    public Object s(Object obj) {
        return ((KProperty1) A0()).s(obj);
    }

    /* access modifiers changed from: protected */
    public KCallable x0() {
        return Reflection.u(this);
    }

    @SinceKotlin(version = "1.1")
    public PropertyReference1(Object obj) {
        super(obj);
    }

    public KProperty1.Getter a() {
        return ((KProperty1) A0()).a();
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference1(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
