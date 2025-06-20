package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.Types;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    private static final long Z = 3637540370352322684L;
    @CheckForNull
    @LazyInit
    private transient TypeResolver X;
    @CheckForNull
    @LazyInit
    private transient TypeResolver Y;
    /* access modifiers changed from: private */
    public final Type s;

    private static class Bounds {

        /* renamed from: a  reason: collision with root package name */
        private final Type[] f23015a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f23016b;

        Bounds(Type[] typeArr, boolean z) {
            this.f23015a = typeArr;
            this.f23016b = z;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Type type) {
            for (Type U : this.f23015a) {
                boolean K = TypeToken.U(U).K(type);
                boolean z = this.f23016b;
                if (K == z) {
                    return z;
                }
            }
            return !this.f23016b;
        }

        /* access modifiers changed from: package-private */
        public boolean b(Type type) {
            TypeToken<?> U = TypeToken.U(type);
            for (Type K : this.f23015a) {
                boolean K2 = U.K(K);
                boolean z = this.f23016b;
                if (K2 == z) {
                    return z;
                }
            }
            return !this.f23016b;
        }
    }

    private final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long Y2 = 0;
        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> Z;

        private ClassSet() {
            super();
        }

        private Object M1() {
            return TypeToken.this.D().J1();
        }

        /* access modifiers changed from: protected */
        /* renamed from: E1 */
        public Set<TypeToken<? super T>> a1() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.Z;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<?>> V = FluentIterable.D(TypeCollector.f23017a.a().d(TypeToken.this)).t(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).V();
            this.Z = V;
            return V;
        }

        public TypeToken<T>.TypeSet J1() {
            return this;
        }

        public TypeToken<T>.TypeSet K1() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        public Set<Class<? super T>> L1() {
            return ImmutableSet.C(TypeCollector.f23018b.a().c(TypeToken.this.x()));
        }
    }

    private final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long Z2 = 0;
        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> X2;
        private final transient TypeToken<T>.TypeSet Z;

        InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.Z = typeSet;
        }

        private Object M1() {
            return TypeToken.this.D().K1();
        }

        /* access modifiers changed from: protected */
        /* renamed from: E1 */
        public Set<TypeToken<? super T>> a1() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.X2;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> V = FluentIterable.D(this.Z).t(TypeFilter.INTERFACE_ONLY).V();
            this.X2 = V;
            return V;
        }

        public TypeToken<T>.TypeSet J1() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        public TypeToken<T>.TypeSet K1() {
            return this;
        }

        public Set<Class<? super T>> L1() {
            return FluentIterable.D(TypeCollector.f23018b.c(TypeToken.this.x())).t(new c()).V();
        }
    }

    private static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long X2 = 0;

        SimpleTypeToken(Type type) {
            super(type);
        }
    }

    private static abstract class TypeCollector<K> {

        /* renamed from: a  reason: collision with root package name */
        static final TypeCollector<TypeToken<?>> f23017a = new TypeCollector<TypeToken<?>>() {
            /* access modifiers changed from: package-private */
            /* renamed from: i */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.s();
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.w();
            }

            /* access modifiers changed from: package-private */
            @CheckForNull
            /* renamed from: k */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.t();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        static final TypeCollector<Class<?>> f23018b = new TypeCollector<Class<?>>() {
            /* access modifiers changed from: package-private */
            /* renamed from: i */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public Class<?> f(Class<?> cls) {
                return cls;
            }

            /* access modifiers changed from: package-private */
            @CheckForNull
            /* renamed from: k */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        };

        private static class ForwardingTypeCollector<K> extends TypeCollector<K> {

            /* renamed from: c  reason: collision with root package name */
            private final TypeCollector<K> f23019c;

            ForwardingTypeCollector(TypeCollector<K> typeCollector) {
                super();
                this.f23019c = typeCollector;
            }

            /* access modifiers changed from: package-private */
            public Iterable<? extends K> e(K k2) {
                return this.f23019c.e(k2);
            }

            /* access modifiers changed from: package-private */
            public Class<?> f(K k2) {
                return this.f23019c.f(k2);
            }

            /* access modifiers changed from: package-private */
            @CheckForNull
            public K g(K k2) {
                return this.f23019c.g(k2);
            }
        }

        private TypeCollector() {
        }

        @CanIgnoreReturnValue
        private int b(K k2, Map<? super K, Integer> map) {
            Integer num = map.get(k2);
            if (num != null) {
                return num.intValue();
            }
            int isInterface = f(k2).isInterface();
            for (Object b2 : e(k2)) {
                isInterface = Math.max(isInterface, b(b2, map));
            }
            Object g2 = g(k2);
            if (g2 != null) {
                isInterface = Math.max(isInterface, b(g2, map));
            }
            int i2 = isInterface + 1;
            map.put(k2, Integer.valueOf(i2));
            return i2;
        }

        private static <K, V> ImmutableList<K> h(final Map<K, V> map, final Comparator<? super V> comparator) {
            return new Ordering<K>() {
                public int compare(K k2, K k3) {
                    Comparator comparator = comparator;
                    Object obj = map.get(k2);
                    Objects.requireNonNull(obj);
                    Object obj2 = map.get(k3);
                    Objects.requireNonNull(obj2);
                    return comparator.compare(obj, obj2);
                }
            }.l(map.keySet());
        }

        /* access modifiers changed from: package-private */
        public final TypeCollector<K> a() {
            return new ForwardingTypeCollector<K>(this, this) {
                /* access modifiers changed from: package-private */
                public ImmutableList<K> c(Iterable<? extends K> iterable) {
                    ImmutableList.Builder r = ImmutableList.r();
                    for (Object next : iterable) {
                        if (!f(next).isInterface()) {
                            r.g(next);
                        }
                    }
                    return super.c(r.e());
                }

                /* access modifiers changed from: package-private */
                public Iterable<? extends K> e(K k2) {
                    return ImmutableSet.K();
                }
            };
        }

        /* access modifiers changed from: package-private */
        public ImmutableList<K> c(Iterable<? extends K> iterable) {
            HashMap Y = Maps.Y();
            for (Object b2 : iterable) {
                b(b2, Y);
            }
            return h(Y, Ordering.z().E());
        }

        /* access modifiers changed from: package-private */
        public final ImmutableList<K> d(K k2) {
            return c(ImmutableList.K(k2));
        }

        /* access modifiers changed from: package-private */
        public abstract Iterable<? extends K> e(K k2);

        /* access modifiers changed from: package-private */
        public abstract Class<?> f(K k2);

        /* access modifiers changed from: package-private */
        @CheckForNull
        public abstract K g(K k2);
    }

    private enum TypeFilter implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD {
            /* renamed from: b */
            public boolean apply(TypeToken<?> typeToken) {
                return !(typeToken.s instanceof TypeVariable) && !(typeToken.s instanceof WildcardType);
            }
        },
        INTERFACE_ONLY {
            /* renamed from: b */
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.w().isInterface();
            }
        }
    }

    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long Y = 0;
        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> s;

        TypeSet() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: E1 */
        public Set<TypeToken<? super T>> a1() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.s;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<?>> V = FluentIterable.D(TypeCollector.f23017a.d(TypeToken.this)).t(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).V();
            this.s = V;
            return V;
        }

        public TypeToken<T>.TypeSet J1() {
            return new ClassSet();
        }

        public TypeToken<T>.TypeSet K1() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> L1() {
            return ImmutableSet.C(TypeCollector.f23018b.c(TypeToken.this.x()));
        }
    }

    protected TypeToken() {
        Type a2 = a();
        this.s = a2;
        Preconditions.x0(!(a2 instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", a2);
    }

    private TypeToken<? super T> B(Class<? super T> cls, Type[] typeArr) {
        for (Type U : typeArr) {
            TypeToken<?> U2 = U(U);
            if (U2.K(cls)) {
                return U2.A(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private boolean E(Type type, TypeVariable<?> typeVariable) {
        if (this.s.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return l(this.s).equals(l(type));
        }
        WildcardType j2 = j(typeVariable, (WildcardType) type);
        return n(j2.getUpperBounds()).b(this.s) && n(j2.getLowerBounds()).a(this.s);
    }

    private boolean H(Type type) {
        Iterator it2 = D().iterator();
        while (it2.hasNext()) {
            Type v = ((TypeToken) it2.next()).v();
            if (v != null && U(v).K(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean L(GenericArrayType genericArrayType) {
        TypeToken<?> U;
        Type type = this.s;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return false;
            }
            U = T(cls.getComponentType());
        } else if (!(type instanceof GenericArrayType)) {
            return false;
        } else {
            U = U(((GenericArrayType) type).getGenericComponentType());
        }
        return U.K(genericArrayType.getGenericComponentType());
    }

    private boolean M(ParameterizedType parameterizedType) {
        Class<? super Object> w = U(parameterizedType).w();
        if (!Z(w)) {
            return false;
        }
        TypeVariable[] typeParameters = w.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i2 = 0; i2 < typeParameters.length; i2++) {
            if (!U(r().j(typeParameters[i2])).E(actualTypeArguments[i2], typeParameters[i2])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || H(parameterizedType.getOwnerType());
    }

    private boolean P(GenericArrayType genericArrayType) {
        Type type = this.s;
        if (type instanceof Class) {
            Class cls = (Class) type;
            return !cls.isArray() ? cls.isAssignableFrom(Object[].class) : U(genericArrayType.getGenericComponentType()).K(cls.getComponentType());
        } else if (type instanceof GenericArrayType) {
            return U(genericArrayType.getGenericComponentType()).K(((GenericArrayType) this.s).getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean Q() {
        return Primitives.c().contains(this.s);
    }

    private static Type S(Type type) {
        return Types.JavaVersion.JAVA7.c(type);
    }

    public static <T> TypeToken<T> T(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    public static TypeToken<?> U(Type type) {
        return new SimpleTypeToken(type);
    }

    private TypeToken<?> W(Type type) {
        TypeToken<?> U = U(r().j(type));
        U.Y = this.Y;
        U.X = this.X;
        return U;
    }

    private Type Y(Class<?> cls) {
        if ((this.s instanceof Class) && (cls.getTypeParameters().length == 0 || w().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken<? extends Object> a0 = a0(cls);
        return new TypeResolver().n(a0.A(w()).s, this.s).j(a0.s);
    }

    private boolean Z(Class<?> cls) {
        UnmodifiableIterator k2 = x().iterator();
        while (k2.hasNext()) {
            if (cls.isAssignableFrom((Class) k2.next())) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    static <T> TypeToken<? extends T> a0(Class<T> cls) {
        Type m2;
        if (cls.isArray()) {
            m2 = Types.j(a0(cls.getComponentType()).s);
        } else {
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : a0(cls.getEnclosingClass()).s;
            if (typeParameters.length <= 0 && (type == null || type == cls.getEnclosingClass())) {
                return T(cls);
            }
            m2 = Types.m(type, cls, typeParameters);
        }
        return U(m2);
    }

    private static Bounds f(Type[] typeArr) {
        return new Bounds(typeArr, true);
    }

    @CheckForNull
    private TypeToken<? super T> g(Type type) {
        TypeToken<?> U = U(type);
        if (U.w().isInterface()) {
            return null;
        }
        return U;
    }

    private ImmutableList<TypeToken<? super T>> h(Type[] typeArr) {
        ImmutableList.Builder r = ImmutableList.r();
        for (Type U : typeArr) {
            TypeToken<?> U2 = U(U);
            if (U2.w().isInterface()) {
                r.g(U2);
            }
        }
        return r.e();
    }

    private static Type i(TypeVariable<?> typeVariable, Type type) {
        return type instanceof WildcardType ? j(typeVariable, (WildcardType) type) : l(type);
    }

    private static WildcardType j(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!f(bounds).a(type)) {
                arrayList.add(l(type));
            }
        }
        return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType k(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
            actualTypeArguments[i2] = i(typeParameters[i2], actualTypeArguments[i2]);
        }
        return Types.m(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type l(Type type) {
        if (type instanceof ParameterizedType) {
            return k((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? Types.j(l(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static Bounds n(Type[] typeArr) {
        return new Bounds(typeArr, false);
    }

    private TypeToken<? extends T> o(Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType != null) {
            TypeToken<?> q = q();
            Objects.requireNonNull(q);
            return U(S(q.y(componentType).s));
        }
        throw new IllegalArgumentException(cls + " does not appear to be a subtype of " + this);
    }

    private TypeToken<? super T> p(Class<? super T> cls) {
        TypeToken<?> q = q();
        if (q != null) {
            Class<?> componentType = cls.getComponentType();
            Objects.requireNonNull(componentType);
            return U(S(q.A(componentType).s));
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    /* access modifiers changed from: private */
    public TypeResolver r() {
        TypeResolver typeResolver = this.Y;
        if (typeResolver != null) {
            return typeResolver;
        }
        TypeResolver d2 = TypeResolver.d(this.s);
        this.Y = d2;
        return d2;
    }

    /* access modifiers changed from: private */
    public TypeResolver u() {
        TypeResolver typeResolver = this.X;
        if (typeResolver != null) {
            return typeResolver;
        }
        TypeResolver f2 = TypeResolver.f(this.s);
        this.X = f2;
        return f2;
    }

    @CheckForNull
    private Type v() {
        Type type = this.s;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> x() {
        final ImmutableSet.Builder r = ImmutableSet.r();
        new TypeVisitor(this) {
            /* access modifiers changed from: package-private */
            public void b(Class<?> cls) {
                r.g(cls);
            }

            /* access modifiers changed from: package-private */
            public void c(GenericArrayType genericArrayType) {
                r.g(Types.h(TypeToken.U(genericArrayType.getGenericComponentType()).w()));
            }

            /* access modifiers changed from: package-private */
            public void d(ParameterizedType parameterizedType) {
                r.g((Class) parameterizedType.getRawType());
            }

            /* access modifiers changed from: package-private */
            public void e(TypeVariable<?> typeVariable) {
                a(typeVariable.getBounds());
            }

            /* access modifiers changed from: package-private */
            public void f(WildcardType wildcardType) {
                a(wildcardType.getUpperBounds());
            }
        }.a(this.s);
        return r.e();
    }

    private TypeToken<? extends T> z(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return U(typeArr[0]).y(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    public final TypeToken<? super T> A(Class<? super T> cls) {
        Preconditions.y(Z(cls), "%s is not a super class of %s", cls, this);
        Type type = this.s;
        if (type instanceof TypeVariable) {
            return B(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return B(cls, ((WildcardType) type).getUpperBounds());
        }
        return cls.isArray() ? p(cls) : W(a0(cls).s);
    }

    public final Type C() {
        return this.s;
    }

    public final TypeToken<T>.TypeSet D() {
        return new TypeSet();
    }

    public final boolean F() {
        return q() != null;
    }

    public final boolean I() {
        Type type = this.s;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean J(TypeToken<?> typeToken) {
        return K(typeToken.C());
    }

    public final boolean K(Type type) {
        Preconditions.E(type);
        if (type instanceof WildcardType) {
            return f(((WildcardType) type).getLowerBounds()).b(this.s);
        }
        Type type2 = this.s;
        if (type2 instanceof WildcardType) {
            return f(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || f(((TypeVariable) this.s).getBounds()).a(type);
        }
        if (type2 instanceof GenericArrayType) {
            return U(type).P((GenericArrayType) this.s);
        }
        if (type instanceof Class) {
            return Z((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return M((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return L((GenericArrayType) type);
        }
        return false;
    }

    public final boolean N(TypeToken<?> typeToken) {
        return typeToken.K(C());
    }

    public final boolean O(Type type) {
        return U(type).K(C());
    }

    public final Invokable<T, Object> R(Method method) {
        Preconditions.y(Z(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new Invokable.MethodInvokable<T>(method) {
            /* access modifiers changed from: package-private */
            public Type[] f() {
                return TypeToken.this.r().l(super.f());
            }

            /* access modifiers changed from: package-private */
            public Type[] g() {
                return TypeToken.this.u().l(super.g());
            }

            /* access modifiers changed from: package-private */
            public Type h() {
                return TypeToken.this.r().j(super.h());
            }

            public TypeToken<T> i() {
                return TypeToken.this;
            }

            public String toString() {
                return i() + "." + super.toString();
            }
        };
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final TypeToken<T> V() {
        new TypeVisitor() {
            /* access modifiers changed from: package-private */
            public void c(GenericArrayType genericArrayType) {
                a(genericArrayType.getGenericComponentType());
            }

            /* access modifiers changed from: package-private */
            public void d(ParameterizedType parameterizedType) {
                a(parameterizedType.getActualTypeArguments());
                a(parameterizedType.getOwnerType());
            }

            /* access modifiers changed from: package-private */
            public void e(TypeVariable<?> typeVariable) {
                throw new IllegalArgumentException(TypeToken.this.s + "contains a type variable and is not safe for the operation");
            }

            /* access modifiers changed from: package-private */
            public void f(WildcardType wildcardType) {
                a(wildcardType.getLowerBounds());
                a(wildcardType.getUpperBounds());
            }
        }.a(this.s);
        return this;
    }

    public final TypeToken<?> X(Type type) {
        Preconditions.E(type);
        return U(u().j(type));
    }

    public final TypeToken<T> b0() {
        return Q() ? T(Primitives.e((Class) this.s)) : this;
    }

    public final <X> TypeToken<T> c0(TypeParameter<X> typeParameter, TypeToken<X> typeToken) {
        return new SimpleTypeToken(new TypeResolver().o(ImmutableMap.t(new TypeResolver.TypeVariableKey(typeParameter.s), typeToken.s)).j(this.s));
    }

    public final <X> TypeToken<T> d0(TypeParameter<X> typeParameter, Class<X> cls) {
        return c0(typeParameter, T(cls));
    }

    public final TypeToken<T> e0() {
        return I() ? T(Primitives.f((Class) this.s)) : this;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof TypeToken) {
            return this.s.equals(((TypeToken) obj).s);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Object f0() {
        return U(new TypeResolver().j(this.s));
    }

    public int hashCode() {
        return this.s.hashCode();
    }

    public final Invokable<T, T> m(Constructor<?> constructor) {
        Preconditions.y(constructor.getDeclaringClass() == w(), "%s not declared by %s", constructor, w());
        return new Invokable.ConstructorInvokable<T>(constructor) {
            /* access modifiers changed from: package-private */
            public Type[] f() {
                return TypeToken.this.r().l(super.f());
            }

            /* access modifiers changed from: package-private */
            public Type[] g() {
                return TypeToken.this.u().l(super.g());
            }

            /* access modifiers changed from: package-private */
            public Type h() {
                return TypeToken.this.r().j(super.h());
            }

            public TypeToken<T> i() {
                return TypeToken.this;
            }

            public String toString() {
                return i() + "(" + Joiner.p(", ").n(g()) + ")";
            }
        };
    }

    @CheckForNull
    public final TypeToken<?> q() {
        Type i2 = Types.i(this.s);
        if (i2 == null) {
            return null;
        }
        return U(i2);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableList<TypeToken<? super T>> s() {
        Type type = this.s;
        if (type instanceof TypeVariable) {
            return h(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.Builder r = ImmutableList.r();
        for (Type W : w().getGenericInterfaces()) {
            r.g(W(W));
        }
        return r.e();
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final TypeToken<? super T> t() {
        Type type;
        Type type2 = this.s;
        if (type2 instanceof TypeVariable) {
            type = ((TypeVariable) type2).getBounds()[0];
        } else if (type2 instanceof WildcardType) {
            type = ((WildcardType) type2).getUpperBounds()[0];
        } else {
            Type genericSuperclass = w().getGenericSuperclass();
            if (genericSuperclass == null) {
                return null;
            }
            return W(genericSuperclass);
        }
        return g(type);
    }

    public String toString() {
        return Types.s(this.s);
    }

    public final Class<? super T> w() {
        return (Class) x().iterator().next();
    }

    public final TypeToken<? extends T> y(Class<?> cls) {
        Preconditions.u(!(this.s instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.s;
        if (type instanceof WildcardType) {
            return z(cls, ((WildcardType) type).getLowerBounds());
        }
        if (F()) {
            return o(cls);
        }
        Preconditions.y(w().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<?> U = U(Y(cls));
        Preconditions.y(U.J(this), "%s does not appear to be a subtype of %s", U, this);
        return U;
    }

    protected TypeToken(Class<?> cls) {
        Type a2 = super.a();
        if (a2 instanceof Class) {
            this.s = a2;
        } else {
            this.s = TypeResolver.d(cls).j(a2);
        }
    }

    private TypeToken(Type type) {
        this.s = (Type) Preconditions.E(type);
    }
}
