package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    @SinceKotlin(version = "1.4")
    public MutablePropertyReference2Impl(Class cls, String str, String str2, int i2) {
        super(cls, str, str2, i2);
    }

    public void x(Object obj, Object obj2, Object obj3) {
        c().u0(obj, obj2, obj3);
    }

    public Object z(Object obj, Object obj2) {
        return a().u0(obj, obj2);
    }

    public MutablePropertyReference2Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(((ClassBasedDeclarationContainer) kDeclarationContainer).o(), str, str2, (kDeclarationContainer instanceof KClass) ^ true ? 1 : 0);
    }
}
