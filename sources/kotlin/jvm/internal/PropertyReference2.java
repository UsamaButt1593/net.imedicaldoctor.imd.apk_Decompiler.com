package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty2;

public abstract class PropertyReference2 extends PropertyReference implements KProperty2 {
    public PropertyReference2() {
    }

    public Object d0(Object obj, Object obj2) {
        return z(obj, obj2);
    }

    @SinceKotlin(version = "1.1")
    public Object o0(Object obj, Object obj2) {
        return ((KProperty2) A0()).o0(obj, obj2);
    }

    /* access modifiers changed from: protected */
    public KCallable x0() {
        return Reflection.v(this);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference2(Class cls, String str, String str2, int i2) {
        super(CallableReference.Z2, cls, str, str2, i2);
    }

    public KProperty2.Getter a() {
        return ((KProperty2) A0()).a();
    }
}
