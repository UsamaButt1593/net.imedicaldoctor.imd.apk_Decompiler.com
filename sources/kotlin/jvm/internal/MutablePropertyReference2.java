package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty2;

public abstract class MutablePropertyReference2 extends MutablePropertyReference implements KMutableProperty2 {
    public MutablePropertyReference2() {
    }

    public Object d0(Object obj, Object obj2) {
        return z(obj, obj2);
    }

    @SinceKotlin(version = "1.1")
    public Object o0(Object obj, Object obj2) {
        return ((KMutableProperty2) A0()).o0(obj, obj2);
    }

    /* access modifiers changed from: protected */
    public KCallable x0() {
        return Reflection.l(this);
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference2(Class cls, String str, String str2, int i2) {
        super(CallableReference.Z2, cls, str, str2, i2);
    }

    public KProperty2.Getter a() {
        return ((KMutableProperty2) A0()).a();
    }

    public KMutableProperty2.Setter c() {
        return ((KMutableProperty2) A0()).c();
    }
}
