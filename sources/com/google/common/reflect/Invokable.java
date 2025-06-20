package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class Invokable<T, R> implements AnnotatedElement, Member {

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f22990c = n();

    /* renamed from: a  reason: collision with root package name */
    private final AccessibleObject f22991a;

    /* renamed from: b  reason: collision with root package name */
    private final Member f22992b;

    static class ConstructorInvokable<T> extends Invokable<T, T> {

        /* renamed from: d  reason: collision with root package name */
        final Constructor<?> f22993d;

        ConstructorInvokable(Constructor<?> constructor) {
            super(constructor);
            this.f22993d = constructor;
        }

        private boolean I() {
            Class<?> declaringClass = this.f22993d.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            return declaringClass.getEnclosingClass() != null && !Modifier.isStatic(declaringClass.getModifiers());
        }

        public final boolean C() {
            return this.f22993d.isVarArgs();
        }

        /* access modifiers changed from: package-private */
        @IgnoreJRERequirement
        public AnnotatedType[] c() {
            return this.f22993d.getAnnotatedParameterTypes();
        }

        @IgnoreJRERequirement
        @DoNotCall
        public AnnotatedType d() {
            return this.f22993d.getAnnotatedReturnType();
        }

        /* access modifiers changed from: package-private */
        public Type[] f() {
            return this.f22993d.getGenericExceptionTypes();
        }

        /* access modifiers changed from: package-private */
        public Type[] g() {
            Type[] genericParameterTypes = this.f22993d.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !I()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f22993d.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        /* access modifiers changed from: package-private */
        public Type h() {
            Class declaringClass = getDeclaringClass();
            TypeVariable[] typeParameters = declaringClass.getTypeParameters();
            return typeParameters.length > 0 ? Types.l(declaringClass, typeParameters) : declaringClass;
        }

        /* access modifiers changed from: package-private */
        public final Annotation[][] j() {
            return this.f22993d.getParameterAnnotations();
        }

        public final TypeVariable<?>[] m() {
            TypeVariable[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable[] typeParameters2 = this.f22993d.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[(typeParameters.length + typeParameters2.length)];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        /* access modifiers changed from: package-private */
        public final Object p(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            try {
                return this.f22993d.newInstance(objArr);
            } catch (InstantiationException e2) {
                throw new RuntimeException(this.f22993d + " failed.", e2);
            }
        }

        public final boolean u() {
            return false;
        }
    }

    static class MethodInvokable<T> extends Invokable<T, Object> {

        /* renamed from: d  reason: collision with root package name */
        final Method f22994d;

        MethodInvokable(Method method) {
            super(method);
            this.f22994d = method;
        }

        public final boolean C() {
            return this.f22994d.isVarArgs();
        }

        /* access modifiers changed from: package-private */
        @IgnoreJRERequirement
        public AnnotatedType[] c() {
            return this.f22994d.getAnnotatedParameterTypes();
        }

        @IgnoreJRERequirement
        @DoNotCall
        public AnnotatedType d() {
            return this.f22994d.getAnnotatedReturnType();
        }

        /* access modifiers changed from: package-private */
        public Type[] f() {
            return this.f22994d.getGenericExceptionTypes();
        }

        /* access modifiers changed from: package-private */
        public Type[] g() {
            return this.f22994d.getGenericParameterTypes();
        }

        /* access modifiers changed from: package-private */
        public Type h() {
            return this.f22994d.getGenericReturnType();
        }

        /* access modifiers changed from: package-private */
        public final Annotation[][] j() {
            return this.f22994d.getParameterAnnotations();
        }

        public final TypeVariable<?>[] m() {
            return this.f22994d.getTypeParameters();
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public final Object p(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            return this.f22994d.invoke(obj, objArr);
        }

        public final boolean u() {
            return !s() && !w() && !z() && !Modifier.isFinal(getDeclaringClass().getModifiers());
        }
    }

    <M extends AccessibleObject & Member> Invokable(M m2) {
        Preconditions.E(m2);
        this.f22991a = m2;
        this.f22992b = (Member) m2;
    }

    public static <T> Invokable<T, T> a(Constructor<T> constructor) {
        return new ConstructorInvokable(constructor);
    }

    public static Invokable<?, Object> b(Method method) {
        return new MethodInvokable(method);
    }

    private static boolean n() {
        try {
            Class.forName("java.lang.reflect.AnnotatedType");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final boolean A() {
        return Modifier.isSynchronized(getModifiers());
    }

    /* access modifiers changed from: package-private */
    public final boolean B() {
        return Modifier.isTransient(getModifiers());
    }

    public abstract boolean C();

    /* access modifiers changed from: package-private */
    public final boolean D() {
        return Modifier.isVolatile(getModifiers());
    }

    public final <R1 extends R> Invokable<T, R1> E(TypeToken<R1> typeToken) {
        if (typeToken.N(l())) {
            return this;
        }
        throw new IllegalArgumentException("Invokable is known to return " + l() + ", not " + typeToken);
    }

    public final <R1 extends R> Invokable<T, R1> F(Class<R1> cls) {
        return E(TypeToken.T(cls));
    }

    public final void G(boolean z) {
        this.f22991a.setAccessible(z);
    }

    public final boolean H() {
        try {
            this.f22991a.setAccessible(true);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @IgnoreJRERequirement
    public abstract AnnotatedType[] c();

    @IgnoreJRERequirement
    @DoNotCall("fails under Android VMs; do not use from guava-android")
    @Deprecated
    @Beta
    public abstract AnnotatedType d();

    public final ImmutableList<TypeToken<? extends Throwable>> e() {
        ImmutableList.Builder r = ImmutableList.r();
        for (Type U : f()) {
            r.g(TypeToken.U(U));
        }
        return r.e();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Invokable)) {
            return false;
        }
        Invokable invokable = (Invokable) obj;
        return i().equals(invokable.i()) && this.f22992b.equals(invokable.f22992b);
    }

    /* access modifiers changed from: package-private */
    public abstract Type[] f();

    /* access modifiers changed from: package-private */
    public abstract Type[] g();

    @CheckForNull
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.f22991a.getAnnotation(cls);
    }

    public final Annotation[] getAnnotations() {
        return this.f22991a.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.f22991a.getDeclaredAnnotations();
    }

    public final Class<? super T> getDeclaringClass() {
        return this.f22992b.getDeclaringClass();
    }

    public final int getModifiers() {
        return this.f22992b.getModifiers();
    }

    public final String getName() {
        return this.f22992b.getName();
    }

    /* access modifiers changed from: package-private */
    public abstract Type h();

    public int hashCode() {
        return this.f22992b.hashCode();
    }

    public TypeToken<T> i() {
        return TypeToken.T(getDeclaringClass());
    }

    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f22991a.isAnnotationPresent(cls);
    }

    public final boolean isSynthetic() {
        return this.f22992b.isSynthetic();
    }

    /* access modifiers changed from: package-private */
    public abstract Annotation[][] j();

    @IgnoreJRERequirement
    public final ImmutableList<Parameter> k() {
        Type[] g2 = g();
        Annotation[][] j2 = j();
        Object[] c2 = f22990c ? c() : new Object[g2.length];
        ImmutableList.Builder r = ImmutableList.r();
        for (int i2 = 0; i2 < g2.length; i2++) {
            r.g(new Parameter(this, i2, TypeToken.U(g2[i2]), j2[i2], c2[i2]));
        }
        return r.e();
    }

    public final TypeToken<? extends R> l() {
        return TypeToken.U(h());
    }

    public abstract TypeVariable<?>[] m();

    @CanIgnoreReturnValue
    @CheckForNull
    public final R o(@CheckForNull T t, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        return p(t, (Object[]) Preconditions.E(objArr));
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public abstract Object p(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException;

    public final boolean q() {
        return Modifier.isAbstract(getModifiers());
    }

    public final boolean r() {
        return this.f22991a.isAccessible();
    }

    public final boolean s() {
        return Modifier.isFinal(getModifiers());
    }

    public final boolean t() {
        return Modifier.isNative(getModifiers());
    }

    public String toString() {
        return this.f22992b.toString();
    }

    public abstract boolean u();

    public final boolean v() {
        return !w() && !y() && !x();
    }

    public final boolean w() {
        return Modifier.isPrivate(getModifiers());
    }

    public final boolean x() {
        return Modifier.isProtected(getModifiers());
    }

    public final boolean y() {
        return Modifier.isPublic(getModifiers());
    }

    public final boolean z() {
        return Modifier.isStatic(getModifiers());
    }
}
