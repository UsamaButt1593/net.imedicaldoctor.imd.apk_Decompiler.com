package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference0Impl extends MutablePropertyReference0 {
    @SinceKotlin(version = "1.4")
    public MutablePropertyReference0Impl(Class cls, String str, String str2, int i2) {
        super(CallableReference.Z2, cls, str, str2, i2);
    }

    public Object get() {
        return a().u0(new Object[0]);
    }

    public void set(Object obj) {
        c().u0(obj);
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference0Impl(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    public MutablePropertyReference0Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(CallableReference.Z2, ((ClassBasedDeclarationContainer) kDeclarationContainer).o(), str, str2, (kDeclarationContainer instanceof KClass) ^ true ? 1 : 0);
    }
}
