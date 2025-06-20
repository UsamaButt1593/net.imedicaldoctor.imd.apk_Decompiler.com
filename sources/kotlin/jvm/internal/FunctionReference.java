package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int a3;
    @SinceKotlin(version = "1.4")
    private final int b3;

    public FunctionReference(int i2) {
        this(i2, CallableReference.Z2, (Class) null, (String) null, (String) null, 0);
    }

    /* access modifiers changed from: protected */
    @SinceKotlin(version = "1.1")
    /* renamed from: C0 */
    public KFunction A0() {
        return (KFunction) super.A0();
    }

    @SinceKotlin(version = "1.1")
    public boolean L() {
        return A0().L();
    }

    public int e() {
        return this.a3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && B0().equals(functionReference.B0()) && this.b3 == functionReference.b3 && this.a3 == functionReference.a3 && Intrinsics.g(y0(), functionReference.y0()) && Intrinsics.g(z0(), functionReference.z0());
        } else if (obj instanceof KFunction) {
            return obj.equals(w0());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((z0() == null ? 0 : z0().hashCode() * 31) + getName().hashCode()) * 31) + B0().hashCode();
    }

    @SinceKotlin(version = "1.1")
    public boolean k() {
        return A0().k();
    }

    @SinceKotlin(version = "1.1")
    public boolean n() {
        return A0().n();
    }

    @SinceKotlin(version = "1.1")
    public boolean t() {
        return A0().t();
    }

    @SinceKotlin(version = "1.1")
    public boolean t0() {
        return A0().t0();
    }

    public String toString() {
        KCallable w0 = w0();
        if (w0 != this) {
            return w0.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    /* access modifiers changed from: protected */
    @SinceKotlin(version = "1.1")
    public KCallable x0() {
        return Reflection.c(this);
    }

    @SinceKotlin(version = "1.1")
    public FunctionReference(int i2, Object obj) {
        this(i2, obj, (Class) null, (String) null, (String) null, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SinceKotlin(version = "1.4")
    public FunctionReference(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.a3 = i2;
        this.b3 = i3 >> 1;
    }
}
