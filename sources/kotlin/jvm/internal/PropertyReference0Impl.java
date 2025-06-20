package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class PropertyReference0Impl extends PropertyReference0 {
    @SinceKotlin(version = "1.4")
    public PropertyReference0Impl(Class cls, String str, String str2, int i2) {
        super(CallableReference.Z2, cls, str, str2, i2);
    }

    public Object get() {
        return a().u0(new Object[0]);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    public PropertyReference0Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(CallableReference.Z2, ((ClassBasedDeclarationContainer) kDeclarationContainer).o(), str, str2, (kDeclarationContainer instanceof KClass) ^ true ? 1 : 0);
    }
}
