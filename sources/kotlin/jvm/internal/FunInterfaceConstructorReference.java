package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KFunction;

@SinceKotlin(version = "1.7")
public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    private final Class c3;

    public FunInterfaceConstructorReference(Class cls) {
        super(1);
        this.c3 = cls;
    }

    /* access modifiers changed from: protected */
    /* renamed from: C0 */
    public KFunction A0() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FunInterfaceConstructorReference)) {
            return false;
        }
        return this.c3.equals(((FunInterfaceConstructorReference) obj).c3);
    }

    public int hashCode() {
        return this.c3.hashCode();
    }

    public String toString() {
        return "fun interface " + this.c3.getName();
    }
}
