package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    @SinceKotlin(version = "1.4")
    public MutablePropertyReference1Impl(Class cls, String str, String str2, int i2) {
        super(CallableReference.Z2, cls, str, str2, i2);
    }

    public void Y(Object obj, Object obj2) {
        c().u0(obj, obj2);
    }

    public Object get(Object obj) {
        return a().u0(obj);
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference1Impl(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    public MutablePropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(CallableReference.Z2, ((ClassBasedDeclarationContainer) kDeclarationContainer).o(), str, str2, (kDeclarationContainer instanceof KClass) ^ true ? 1 : 0);
    }
}
