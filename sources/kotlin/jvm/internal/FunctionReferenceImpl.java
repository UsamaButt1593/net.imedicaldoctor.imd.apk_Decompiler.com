package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class FunctionReferenceImpl extends FunctionReference {
    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i2, Class cls, String str, String str2, int i3) {
        super(i2, CallableReference.Z2, cls, str, str2, i3);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(i2, obj, cls, str, str2, i3);
    }

    public FunctionReferenceImpl(int i2, KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(i2, CallableReference.Z2, ((ClassBasedDeclarationContainer) kDeclarationContainer).o(), str, str2, (kDeclarationContainer instanceof KClass) ^ true ? 1 : 0);
    }
}
