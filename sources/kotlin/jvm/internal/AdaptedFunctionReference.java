package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;

@SinceKotlin(version = "1.4")
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    private final Class X;
    private final boolean X2;
    private final String Y;
    private final int Y2;
    private final String Z;
    private final int Z2;
    protected final Object s;

    public AdaptedFunctionReference(int i2, Class cls, String str, String str2, int i3) {
        this(i2, CallableReference.Z2, cls, str, str2, i3);
    }

    public KDeclarationContainer b() {
        Class cls = this.X;
        if (cls == null) {
            return null;
        }
        return this.X2 ? Reflection.g(cls) : Reflection.d(cls);
    }

    public int e() {
        return this.Y2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        return this.X2 == adaptedFunctionReference.X2 && this.Y2 == adaptedFunctionReference.Y2 && this.Z2 == adaptedFunctionReference.Z2 && Intrinsics.g(this.s, adaptedFunctionReference.s) && Intrinsics.g(this.X, adaptedFunctionReference.X) && this.Y.equals(adaptedFunctionReference.Y) && this.Z.equals(adaptedFunctionReference.Z);
    }

    public int hashCode() {
        Object obj = this.s;
        int i2 = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.X;
        if (cls != null) {
            i2 = cls.hashCode();
        }
        return ((((((((((hashCode + i2) * 31) + this.Y.hashCode()) * 31) + this.Z.hashCode()) * 31) + (this.X2 ? 1231 : 1237)) * 31) + this.Y2) * 31) + this.Z2;
    }

    public String toString() {
        return Reflection.w(this);
    }

    public AdaptedFunctionReference(int i2, Object obj, Class cls, String str, String str2, int i3) {
        this.s = obj;
        this.X = cls;
        this.Y = str;
        this.Z = str2;
        this.X2 = (i3 & 1) == 1;
        this.Y2 = i2;
        this.Z2 = i3 >> 1;
    }
}
