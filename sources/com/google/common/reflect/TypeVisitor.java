package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

@ElementTypesAreNonnullByDefault
abstract class TypeVisitor {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Type> f23020a = Sets.u();

    TypeVisitor() {
    }

    public final void a(Type... typeArr) {
        for (TypeVariable typeVariable : typeArr) {
            if (typeVariable != null && this.f23020a.add(typeVariable)) {
                try {
                    if (typeVariable instanceof TypeVariable) {
                        e(typeVariable);
                    } else if (typeVariable instanceof WildcardType) {
                        f((WildcardType) typeVariable);
                    } else if (typeVariable instanceof ParameterizedType) {
                        d(typeVariable);
                    } else if (typeVariable instanceof Class) {
                        b(typeVariable);
                    } else if (typeVariable instanceof GenericArrayType) {
                        c(typeVariable);
                    } else {
                        throw new AssertionError("Unknown type: " + typeVariable);
                    }
                } catch (Throwable th) {
                    this.f23020a.remove(typeVariable);
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Class<?> cls) {
    }

    /* access modifiers changed from: package-private */
    public void c(GenericArrayType genericArrayType) {
    }

    /* access modifiers changed from: package-private */
    public void d(ParameterizedType parameterizedType) {
    }

    /* access modifiers changed from: package-private */
    public void e(TypeVariable<?> typeVariable) {
    }

    /* access modifiers changed from: package-private */
    public void f(WildcardType wildcardType) {
    }
}
