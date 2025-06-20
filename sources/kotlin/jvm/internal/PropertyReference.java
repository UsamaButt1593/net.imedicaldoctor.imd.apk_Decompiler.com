package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

public abstract class PropertyReference extends CallableReference implements KProperty {
    private final boolean a3;

    public PropertyReference() {
        this.a3 = false;
    }

    /* access modifiers changed from: protected */
    @SinceKotlin(version = "1.1")
    /* renamed from: C0 */
    public KProperty A0() {
        if (!this.a3) {
            return (KProperty) super.A0();
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return z0().equals(propertyReference.z0()) && getName().equals(propertyReference.getName()) && B0().equals(propertyReference.B0()) && Intrinsics.g(y0(), propertyReference.y0());
        } else if (obj instanceof KProperty) {
            return obj.equals(w0());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((z0().hashCode() * 31) + getName().hashCode()) * 31) + B0().hashCode();
    }

    @SinceKotlin(version = "1.1")
    public boolean p0() {
        return A0().p0();
    }

    public String toString() {
        KCallable w0 = w0();
        if (w0 != this) {
            return w0.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @SinceKotlin(version = "1.1")
    public boolean v() {
        return A0().v();
    }

    public KCallable w0() {
        return this.a3 ? this : super.w0();
    }

    @SinceKotlin(version = "1.1")
    public PropertyReference(Object obj) {
        super(obj);
        this.a3 = false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SinceKotlin(version = "1.4")
    public PropertyReference(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        boolean z = false;
        this.a3 = (i2 & 2) == 2 ? true : z;
    }
}
