package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;

@ElementTypesAreNonnullByDefault
public final class TypeResolver {

    /* renamed from: a  reason: collision with root package name */
    private final TypeTable f23000a;

    private static final class TypeMappingIntrospector extends TypeVisitor {

        /* renamed from: b  reason: collision with root package name */
        private final Map<TypeVariableKey, Type> f23003b = Maps.Y();

        private TypeMappingIntrospector() {
        }

        static ImmutableMap<TypeVariableKey, Type> g(Type type) {
            Preconditions.E(type);
            TypeMappingIntrospector typeMappingIntrospector = new TypeMappingIntrospector();
            typeMappingIntrospector.a(type);
            return ImmutableMap.g(typeMappingIntrospector.f23003b);
        }

        private void h(TypeVariableKey typeVariableKey, Type type) {
            if (!this.f23003b.containsKey(typeVariableKey)) {
                Type type2 = type;
                while (type2 != null) {
                    if (typeVariableKey.a(type2)) {
                        while (type != null) {
                            type = this.f23003b.remove(TypeVariableKey.c(type));
                        }
                        return;
                    }
                    type2 = this.f23003b.get(TypeVariableKey.c(type2));
                }
                this.f23003b.put(typeVariableKey, type);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        /* access modifiers changed from: package-private */
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Preconditions.g0(typeParameters.length == actualTypeArguments.length);
            for (int i2 = 0; i2 < typeParameters.length; i2++) {
                h(new TypeVariableKey(typeParameters[i2]), actualTypeArguments[i2]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        /* access modifiers changed from: package-private */
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        /* access modifiers changed from: package-private */
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    private static class TypeTable {

        /* renamed from: a  reason: collision with root package name */
        private final ImmutableMap<TypeVariableKey, Type> f23004a;

        TypeTable() {
            this.f23004a = ImmutableMap.s();
        }

        /* access modifiers changed from: package-private */
        public final Type a(final TypeVariable<?> typeVariable) {
            return b(typeVariable, new TypeTable(this) {
                public Type b(TypeVariable<?> typeVariable, TypeTable typeTable) {
                    return typeVariable.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) ? typeVariable : this.b(typeVariable, typeTable);
                }
            });
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.reflect.Type, java.lang.reflect.TypeVariable, java.lang.reflect.TypeVariable<?>] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.reflect.Type b(java.lang.reflect.TypeVariable<?> r4, com.google.common.reflect.TypeResolver.TypeTable r5) {
            /*
                r3 = this;
                com.google.common.collect.ImmutableMap<com.google.common.reflect.TypeResolver$TypeVariableKey, java.lang.reflect.Type> r0 = r3.f23004a
                com.google.common.reflect.TypeResolver$TypeVariableKey r1 = new com.google.common.reflect.TypeResolver$TypeVariableKey
                r1.<init>(r4)
                java.lang.Object r0 = r0.get(r1)
                java.lang.reflect.Type r0 = (java.lang.reflect.Type) r0
                r1 = 0
                if (r0 != 0) goto L_0x0039
                java.lang.reflect.Type[] r0 = r4.getBounds()
                int r2 = r0.length
                if (r2 != 0) goto L_0x0018
                return r4
            L_0x0018:
                com.google.common.reflect.TypeResolver r2 = new com.google.common.reflect.TypeResolver
                r2.<init>(r5)
                java.lang.reflect.Type[] r5 = r2.k(r0)
                boolean r1 = com.google.common.reflect.Types.NativeTypeVariableEquals.f23023a
                if (r1 == 0) goto L_0x002c
                boolean r0 = java.util.Arrays.equals(r0, r5)
                if (r0 == 0) goto L_0x002c
                return r4
            L_0x002c:
                java.lang.reflect.GenericDeclaration r0 = r4.getGenericDeclaration()
                java.lang.String r4 = r4.getName()
                java.lang.reflect.TypeVariable r4 = com.google.common.reflect.Types.k(r0, r4, r5)
                return r4
            L_0x0039:
                com.google.common.reflect.TypeResolver r4 = new com.google.common.reflect.TypeResolver
                r4.<init>(r5)
                java.lang.reflect.Type r4 = r4.j(r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.TypeResolver.TypeTable.b(java.lang.reflect.TypeVariable, com.google.common.reflect.TypeResolver$TypeTable):java.lang.reflect.Type");
        }

        /* access modifiers changed from: package-private */
        public final TypeTable c(Map<TypeVariableKey, ? extends Type> map) {
            ImmutableMap.Builder b2 = ImmutableMap.b();
            b2.l(this.f23004a);
            for (Map.Entry next : map.entrySet()) {
                TypeVariableKey typeVariableKey = (TypeVariableKey) next.getKey();
                Type type = (Type) next.getValue();
                Preconditions.u(!typeVariableKey.a(type), "Type variable %s bound to itself", typeVariableKey);
                b2.i(typeVariableKey, type);
            }
            return new TypeTable(b2.d());
        }

        private TypeTable(ImmutableMap<TypeVariableKey, Type> immutableMap) {
            this.f23004a = immutableMap;
        }
    }

    static final class TypeVariableKey {

        /* renamed from: a  reason: collision with root package name */
        private final TypeVariable<?> f23007a;

        TypeVariableKey(TypeVariable<?> typeVariable) {
            this.f23007a = (TypeVariable) Preconditions.E(typeVariable);
        }

        private boolean b(TypeVariable<?> typeVariable) {
            return this.f23007a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f23007a.getName().equals(typeVariable.getName());
        }

        @CheckForNull
        static TypeVariableKey c(Type type) {
            if (type instanceof TypeVariable) {
                return new TypeVariableKey((TypeVariable) type);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof TypeVariableKey) {
                return b(((TypeVariableKey) obj).f23007a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(this.f23007a.getGenericDeclaration(), this.f23007a.getName());
        }

        public String toString() {
            return this.f23007a.toString();
        }
    }

    private static class WildcardCapturer {

        /* renamed from: b  reason: collision with root package name */
        static final WildcardCapturer f23008b = new WildcardCapturer();

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f23009a;

        private WildcardCapturer() {
            this(new AtomicInteger());
        }

        @CheckForNull
        private Type c(@CheckForNull Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private WildcardCapturer d(final TypeVariable<?> typeVariable) {
            return new WildcardCapturer(this, this.f23009a) {
                /* access modifiers changed from: package-private */
                public TypeVariable<?> b(Type[] typeArr) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                    linkedHashSet.addAll(Arrays.asList(typeVariable.getBounds()));
                    if (linkedHashSet.size() > 1) {
                        linkedHashSet.remove(Object.class);
                    }
                    return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
                }
            };
        }

        private WildcardCapturer e() {
            return new WildcardCapturer(this.f23009a);
        }

        /* access modifiers changed from: package-private */
        public final Type a(Type type) {
            Preconditions.E(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.j(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                    actualTypeArguments[i2] = d(typeParameters[i2]).a(actualTypeArguments[i2]);
                }
                return Types.m(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        /* access modifiers changed from: package-private */
        public TypeVariable<?> b(Type[] typeArr) {
            return Types.k(WildcardCapturer.class, "capture#" + this.f23009a.incrementAndGet() + "-of ? extends " + Joiner.o(Typography.f29117d).n(typeArr), typeArr);
        }

        private WildcardCapturer(AtomicInteger atomicInteger) {
            this.f23009a = atomicInteger;
        }
    }

    public TypeResolver() {
        this.f23000a = new TypeTable();
    }

    static TypeResolver d(Type type) {
        return new TypeResolver().o(TypeMappingIntrospector.g(type));
    }

    /* access modifiers changed from: private */
    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    static TypeResolver f(Type type) {
        return new TypeResolver().o(TypeMappingIntrospector.g(WildcardCapturer.f23008b.a(type)));
    }

    /* access modifiers changed from: private */
    public static void g(final Map<TypeVariableKey, Type> map, Type type, final Type type2) {
        if (!type.equals(type2)) {
            new TypeVisitor() {
                /* access modifiers changed from: package-private */
                public void b(Class<?> cls) {
                    if (!(type2 instanceof WildcardType)) {
                        throw new IllegalArgumentException("No type mapping from " + cls + " to " + type2);
                    }
                }

                /* access modifiers changed from: package-private */
                public void c(GenericArrayType genericArrayType) {
                    Type type = type2;
                    if (!(type instanceof WildcardType)) {
                        Type i2 = Types.i(type);
                        Preconditions.u(i2 != null, "%s is not an array type.", type2);
                        TypeResolver.g(map, genericArrayType.getGenericComponentType(), i2);
                    }
                }

                /* access modifiers changed from: package-private */
                public void d(ParameterizedType parameterizedType) {
                    Type type = type2;
                    if (!(type instanceof WildcardType)) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) TypeResolver.e(ParameterizedType.class, type);
                        if (!(parameterizedType.getOwnerType() == null || parameterizedType2.getOwnerType() == null)) {
                            TypeResolver.g(map, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
                        }
                        Preconditions.y(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, type2);
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                        Preconditions.y(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
                        for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                            TypeResolver.g(map, actualTypeArguments[i2], actualTypeArguments2[i2]);
                        }
                    }
                }

                /* access modifiers changed from: package-private */
                public void e(TypeVariable<?> typeVariable) {
                    map.put(new TypeVariableKey(typeVariable), type2);
                }

                /* access modifiers changed from: package-private */
                public void f(WildcardType wildcardType) {
                    Type type = type2;
                    if (type instanceof WildcardType) {
                        WildcardType wildcardType2 = (WildcardType) type;
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        Type[] upperBounds2 = wildcardType2.getUpperBounds();
                        Type[] lowerBounds = wildcardType.getLowerBounds();
                        Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                        Preconditions.y(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, type2);
                        for (int i2 = 0; i2 < upperBounds.length; i2++) {
                            TypeResolver.g(map, upperBounds[i2], upperBounds2[i2]);
                        }
                        for (int i3 = 0; i3 < lowerBounds.length; i3++) {
                            TypeResolver.g(map, lowerBounds[i3], lowerBounds2[i3]);
                        }
                    }
                }
            }.a(type);
        }
    }

    private Type h(GenericArrayType genericArrayType) {
        return Types.j(j(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.m(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    /* access modifiers changed from: private */
    public Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i2 = 0; i2 < typeArr.length; i2++) {
            typeArr2[i2] = j(typeArr[i2]);
        }
        return typeArr2;
    }

    private WildcardType m(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public Type j(Type type) {
        Preconditions.E(type);
        if (type instanceof TypeVariable) {
            return this.f23000a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    /* access modifiers changed from: package-private */
    public Type[] l(Type[] typeArr) {
        for (int i2 = 0; i2 < typeArr.length; i2++) {
            typeArr[i2] = j(typeArr[i2]);
        }
        return typeArr;
    }

    public TypeResolver n(Type type, Type type2) {
        HashMap Y = Maps.Y();
        g(Y, (Type) Preconditions.E(type), (Type) Preconditions.E(type2));
        return o(Y);
    }

    /* access modifiers changed from: package-private */
    public TypeResolver o(Map<TypeVariableKey, ? extends Type> map) {
        return new TypeResolver(this.f23000a.c(map));
    }

    private TypeResolver(TypeTable typeTable) {
        this.f23000a = typeTable;
    }
}
