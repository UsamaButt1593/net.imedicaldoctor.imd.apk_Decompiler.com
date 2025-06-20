package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1;

public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KMutableProperty1 {
    public MutablePropertyReference1() {
    }

    public Object f(Object obj) {
        return get(obj);
    }

    @SinceKotlin(version = "1.1")
    public Object s(Object obj) {
        return ((KMutableProperty1) A0()).s(obj);
    }

    /* access modifiers changed from: protected */
    public KCallable x0() {
        return Reflection.k(this);
    }

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    public KProperty1.Getter a() {
        return ((KMutableProperty1) A0()).a();
    }

    public KMutableProperty1.Setter c() {
        return ((KMutableProperty1) A0()).c();
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
