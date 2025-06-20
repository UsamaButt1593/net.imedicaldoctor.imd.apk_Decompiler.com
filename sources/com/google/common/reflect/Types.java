package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import com.itextpdf.xmp.XMPConst;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;
import org.apache.commons.lang3.ClassUtils;

@ElementTypesAreNonnullByDefault
final class Types {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Joiner f23021a = Joiner.p(", ").s("null");

    private enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS {
            /* access modifiers changed from: package-private */
            @CheckForNull
            public Class<?> c(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER {
            /* access modifiers changed from: package-private */
            @CheckForNull
            public Class<?> c(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        static final ClassOwnership Y = null;

        static {
            Y = b();
        }

        private static ClassOwnership b() {
            new AnonymousClass1LocalClass<String>() {
            };
            ParameterizedType parameterizedType = (ParameterizedType) AnonymousClass3.class.getGenericSuperclass();
            Objects.requireNonNull(parameterizedType);
            ParameterizedType parameterizedType2 = parameterizedType;
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.c(AnonymousClass1LocalClass.class) == parameterizedType2.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public abstract Class<?> c(Class<?> cls);
    }

    private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long X = 0;
        private final Type s;

        GenericArrayTypeImpl(Type type) {
            this.s = JavaVersion.X2.g(type);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof GenericArrayType) {
                return com.google.common.base.Objects.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        public Type getGenericComponentType() {
            return this.s;
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public String toString() {
            return Types.s(this.s) + XMPConst.o2;
        }
    }

    enum JavaVersion {
        JAVA6 {
            /* access modifiers changed from: package-private */
            public Type g(Type type) {
                Preconditions.E(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: h */
            public GenericArrayType c(Type type) {
                return new GenericArrayTypeImpl(type);
            }
        },
        JAVA7 {
            /* access modifiers changed from: package-private */
            public Type c(Type type) {
                return type instanceof Class ? Types.h((Class) type) : new GenericArrayTypeImpl(type);
            }

            /* access modifiers changed from: package-private */
            public Type g(Type type) {
                return (Type) Preconditions.E(type);
            }
        },
        JAVA8 {
            /* access modifiers changed from: package-private */
            public Type c(Type type) {
                return JavaVersion.JAVA7.c(type);
            }

            /* access modifiers changed from: package-private */
            public String e(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", (Class[]) null).invoke(type, (Object[]) null);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2);
                } catch (IllegalAccessException e3) {
                    throw new RuntimeException(e3);
                }
            }

            /* access modifiers changed from: package-private */
            public Type g(Type type) {
                return JavaVersion.JAVA7.g(type);
            }
        },
        JAVA9 {
            /* access modifiers changed from: package-private */
            public boolean b() {
                return false;
            }

            /* access modifiers changed from: package-private */
            public Type c(Type type) {
                return JavaVersion.JAVA8.c(type);
            }

            /* access modifiers changed from: package-private */
            public String e(Type type) {
                return JavaVersion.JAVA8.e(type);
            }

            /* access modifiers changed from: package-private */
            public Type g(Type type) {
                return JavaVersion.JAVA8.g(type);
            }
        };
        
        static final JavaVersion X2 = null;

        /* access modifiers changed from: package-private */
        public boolean b() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public abstract Type c(Type type);

        /* access modifiers changed from: package-private */
        public String e(Type type) {
            return Types.s(type);
        }

        /* access modifiers changed from: package-private */
        public final ImmutableList<Type> f(Type[] typeArr) {
            ImmutableList.Builder r = ImmutableList.r();
            for (Type g2 : typeArr) {
                r.g(g(g2));
            }
            return r.e();
        }

        /* access modifiers changed from: package-private */
        public abstract Type g(Type type);
    }

    static final class NativeTypeVariableEquals<X> {

        /* renamed from: a  reason: collision with root package name */
        static final boolean f23023a;

        static {
            Class<NativeTypeVariableEquals> cls = NativeTypeVariableEquals.class;
            f23023a = !cls.getTypeParameters()[0].equals(Types.k(cls, "X", new Type[0]));
        }

        NativeTypeVariableEquals() {
        }
    }

    private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long Z = 0;
        private final ImmutableList<Type> X;
        private final Class<?> Y;
        @CheckForNull
        private final Type s;

        ParameterizedTypeImpl(@CheckForNull Type type, Class<?> cls, Type[] typeArr) {
            Preconditions.E(cls);
            Preconditions.d(typeArr.length == cls.getTypeParameters().length);
            Types.f(typeArr, "type parameter");
            this.s = type;
            this.Y = cls;
            this.X = JavaVersion.X2.f(typeArr);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && com.google.common.base.Objects.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        public Type[] getActualTypeArguments() {
            return Types.r(this.X);
        }

        @CheckForNull
        public Type getOwnerType() {
            return this.s;
        }

        public Type getRawType() {
            return this.Y;
        }

        public int hashCode() {
            Type type = this.s;
            return ((type == null ? 0 : type.hashCode()) ^ this.X.hashCode()) ^ this.Y.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.s != null) {
                JavaVersion javaVersion = JavaVersion.X2;
                if (javaVersion.b()) {
                    sb.append(javaVersion.e(this.s));
                    sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
            }
            sb.append(this.Y.getName());
            sb.append('<');
            Joiner d2 = Types.f23021a;
            ImmutableList<Type> immutableList = this.X;
            JavaVersion javaVersion2 = JavaVersion.X2;
            Objects.requireNonNull(javaVersion2);
            sb.append(d2.k(Iterables.T(immutableList, new d(javaVersion2))));
            sb.append('>');
            return sb.toString();
        }
    }

    private static final class TypeVariableImpl<D extends GenericDeclaration> {

        /* renamed from: a  reason: collision with root package name */
        private final D f23024a;

        /* renamed from: b  reason: collision with root package name */
        private final String f23025b;

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableList<Type> f23026c;

        TypeVariableImpl(D d2, String str, Type[] typeArr) {
            Types.f(typeArr, "bound for type variable");
            this.f23024a = (GenericDeclaration) Preconditions.E(d2);
            this.f23025b = (String) Preconditions.E(str);
            this.f23026c = ImmutableList.D(typeArr);
        }

        public Type[] a() {
            return Types.r(this.f23026c);
        }

        public D b() {
            return this.f23024a;
        }

        public String c() {
            return this.f23025b;
        }

        public String d() {
            return this.f23025b;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (NativeTypeVariableEquals.f23023a) {
                if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof TypeVariableInvocationHandler)) {
                    return false;
                }
                TypeVariableImpl a2 = ((TypeVariableInvocationHandler) Proxy.getInvocationHandler(obj)).f23028a;
                return this.f23025b.equals(a2.c()) && this.f23024a.equals(a2.b()) && this.f23026c.equals(a2.f23026c);
            } else if (!(obj instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.f23025b.equals(typeVariable.getName()) && this.f23024a.equals(typeVariable.getGenericDeclaration());
            }
        }

        public int hashCode() {
            return this.f23024a.hashCode() ^ this.f23025b.hashCode();
        }

        public String toString() {
            return this.f23025b;
        }
    }

    private static final class TypeVariableInvocationHandler implements InvocationHandler {

        /* renamed from: b  reason: collision with root package name */
        private static final ImmutableMap<String, Method> f23027b;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final TypeVariableImpl<?> f23028a;

        static {
            ImmutableMap.Builder b2 = ImmutableMap.b();
            Class<TypeVariableImpl> cls = TypeVariableImpl.class;
            for (Method method : cls.getMethods()) {
                if (method.getDeclaringClass().equals(cls)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    b2.i(method.getName(), method);
                }
            }
            f23027b = b2.c();
        }

        TypeVariableInvocationHandler(TypeVariableImpl<?> typeVariableImpl) {
            this.f23028a = typeVariableImpl;
        }

        @CheckForNull
        public Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = f23027b.get(name);
            if (method2 != null) {
                try {
                    return method2.invoke(this.f23028a, objArr);
                } catch (InvocationTargetException e2) {
                    throw e2.getCause();
                }
            } else {
                throw new UnsupportedOperationException(name);
            }
        }
    }

    static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long Y = 0;
        private final ImmutableList<Type> X;
        private final ImmutableList<Type> s;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.f(typeArr, "lower bound for wildcard");
            Types.f(typeArr2, "upper bound for wildcard");
            JavaVersion javaVersion = JavaVersion.X2;
            this.s = javaVersion.f(typeArr);
            this.X = javaVersion.f(typeArr2);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.s.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.X.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        public Type[] getLowerBounds() {
            return Types.r(this.s);
        }

        public Type[] getUpperBounds() {
            return Types.r(this.X);
        }

        public int hashCode() {
            return this.s.hashCode() ^ this.X.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            UnmodifiableIterator<Type> k2 = this.s.iterator();
            while (k2.hasNext()) {
                sb.append(" super ");
                sb.append(JavaVersion.X2.e(k2.next()));
            }
            for (Type e2 : Types.g(this.X)) {
                sb.append(" extends ");
                sb.append(JavaVersion.X2.e(e2));
            }
            return sb.toString();
        }
    }

    private Types() {
    }

    /* access modifiers changed from: private */
    public static void f(Type[] typeArr, String str) {
        for (Class cls : typeArr) {
            if (cls instanceof Class) {
                Class cls2 = cls;
                Preconditions.y(!cls2.isPrimitive(), "Primitive type '%s' used as %s", cls2, str);
            }
        }
    }

    /* access modifiers changed from: private */
    public static Iterable<Type> g(Iterable<Type> iterable) {
        return Iterables.o(iterable, Predicates.q(Predicates.m(Object.class)));
    }

    static Class<?> h(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    @CheckForNull
    static Type i(Type type) {
        Preconditions.E(type);
        final AtomicReference atomicReference = new AtomicReference();
        new TypeVisitor() {
            /* access modifiers changed from: package-private */
            public void b(Class<?> cls) {
                atomicReference.set(cls.getComponentType());
            }

            /* access modifiers changed from: package-private */
            public void c(GenericArrayType genericArrayType) {
                atomicReference.set(genericArrayType.getGenericComponentType());
            }

            /* access modifiers changed from: package-private */
            public void e(TypeVariable<?> typeVariable) {
                atomicReference.set(Types.p(typeVariable.getBounds()));
            }

            /* access modifiers changed from: package-private */
            public void f(WildcardType wildcardType) {
                atomicReference.set(Types.p(wildcardType.getUpperBounds()));
            }
        }.a(type);
        return (Type) atomicReference.get();
    }

    static Type j(Type type) {
        if (!(type instanceof WildcardType)) {
            return JavaVersion.X2.c(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        boolean z = true;
        Preconditions.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return q(j(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 1) {
            z = false;
        }
        Preconditions.e(z, "Wildcard should have only one upper bound.");
        return o(j(upperBounds[0]));
    }

    static <D extends GenericDeclaration> TypeVariable<D> k(D d2, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return n(d2, str, typeArr);
    }

    static ParameterizedType l(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.Y.c(cls), cls, typeArr);
    }

    static ParameterizedType m(@CheckForNull Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return l(cls, typeArr);
        }
        Preconditions.E(typeArr);
        Preconditions.u(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    private static <D extends GenericDeclaration> TypeVariable<D> n(D d2, String str, Type[] typeArr) {
        return (TypeVariable) Reflection.d(TypeVariable.class, new TypeVariableInvocationHandler(new TypeVariableImpl(d2, str, typeArr)));
    }

    @VisibleForTesting
    static WildcardType o(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public static Type p(Type[] typeArr) {
        for (Type i2 : typeArr) {
            Type i3 = i(i2);
            if (i3 != null) {
                if (i3 instanceof Class) {
                    Class cls = (Class) i3;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return o(i3);
            }
        }
        return null;
    }

    @VisibleForTesting
    static WildcardType q(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    /* access modifiers changed from: private */
    public static Type[] r(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[0]);
    }

    static String s(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
