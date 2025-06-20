package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class TypeParameter<T> extends TypeCapture<T> {
    final TypeVariable<?> s;

    protected TypeParameter() {
        Type a2 = a();
        Preconditions.u(a2 instanceof TypeVariable, "%s should be a type variable.", a2);
        this.s = (TypeVariable) a2;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof TypeParameter) {
            return this.s.equals(((TypeParameter) obj).s);
        }
        return false;
    }

    public final int hashCode() {
        return this.s.hashCode();
    }

    public String toString() {
        return this.s.toString();
    }
}
