package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.ClassUtils;

public class TypeToken<T> {
    private final int hashCode;
    private final Class<? super T> rawType;
    private final Type type;

    protected TypeToken() {
        Type typeTokenTypeArgument = getTypeTokenTypeArgument();
        this.type = typeTokenTypeArgument;
        this.rawType = C$Gson$Types.getRawType(typeTokenTypeArgument);
        this.hashCode = typeTokenTypeArgument.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type type2, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class<?> name : clsArr) {
            sb.append(name.getName());
            sb.append(", ");
        }
        sb.append("but got: ");
        sb.append(type2.getClass().getName());
        sb.append(", for type token: ");
        sb.append(type2.toString());
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        return new AssertionError(sb.toString());
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken<>(cls);
    }

    public static TypeToken<?> getArray(Type type2) {
        return new TypeToken<>(C$Gson$Types.arrayOf(type2));
    }

    public static TypeToken<?> getParameterized(Type type2, Type... typeArr) {
        Objects.requireNonNull(type2);
        Objects.requireNonNull(typeArr);
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            TypeVariable[] typeParameters = cls.getTypeParameters();
            int length = typeParameters.length;
            int length2 = typeArr.length;
            if (length2 == length) {
                for (int i2 = 0; i2 < length; i2++) {
                    Type type3 = typeArr[i2];
                    Class<?> rawType2 = C$Gson$Types.getRawType(type3);
                    TypeVariable typeVariable = typeParameters[i2];
                    Type[] bounds = typeVariable.getBounds();
                    int length3 = bounds.length;
                    int i3 = 0;
                    while (i3 < length3) {
                        if (C$Gson$Types.getRawType(bounds[i3]).isAssignableFrom(rawType2)) {
                            i3++;
                        } else {
                            throw new IllegalArgumentException("Type argument " + type3 + " does not satisfy bounds for type variable " + typeVariable + " declared by " + type2);
                        }
                    }
                }
                return new TypeToken<>(C$Gson$Types.newParameterizedTypeWithOwner((Type) null, type2, typeArr));
            }
            throw new IllegalArgumentException(cls.getName() + " requires " + length + " type arguments, but got " + length2);
        }
        throw new IllegalArgumentException("rawType must be of type Class, but was " + type2);
    }

    private Type getTypeTokenTypeArgument() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Class<TypeToken> cls = TypeToken.class;
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == cls) {
                return C$Gson$Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (genericSuperclass == cls) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    private static boolean matches(Type type2, Type type3, Map<String, Type> map) {
        return type3.equals(type2) || ((type2 instanceof TypeVariable) && type3.equals(map.get(((TypeVariable) type2).getName())));
    }

    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
            if (!matches(actualTypeArguments[i2], actualTypeArguments2[i2], map)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && C$Gson$Types.equals(this.type, ((TypeToken) obj).type);
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }

    private TypeToken(Type type2) {
        Objects.requireNonNull(type2);
        Type canonicalize = C$Gson$Types.canonicalize(type2);
        this.type = canonicalize;
        this.rawType = C$Gson$Types.getRawType(canonicalize);
        this.hashCode = canonicalize.hashCode();
    }

    public static TypeToken<?> get(Type type2) {
        return new TypeToken<>(type2);
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type2) {
        if (type2 == null) {
            return false;
        }
        if (this.type.equals(type2)) {
            return true;
        }
        Type type3 = this.type;
        if (type3 instanceof Class) {
            return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(type2));
        }
        if (type3 instanceof ParameterizedType) {
            return isAssignableFrom(type2, (ParameterizedType) type3, new HashMap());
        }
        if (type3 instanceof GenericArrayType) {
            return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(type2)) && isAssignableFrom(type2, (GenericArrayType) this.type);
        }
        throw buildUnexpectedTypeError(type3, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    private static boolean isAssignableFrom(Type type2, GenericArrayType genericArrayType) {
        Class<?> cls;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        if (type2 instanceof GenericArrayType) {
            cls = ((GenericArrayType) type2).getGenericComponentType();
        } else {
            boolean z = type2 instanceof Class;
            cls = type2;
            if (z) {
                Class<?> cls2 = (Class) type2;
                while (cls2.isArray()) {
                    cls2 = cls2.getComponentType();
                }
                cls = cls2;
            }
        }
        return isAssignableFrom(cls, (ParameterizedType) genericComponentType, new HashMap());
    }

    private static boolean isAssignableFrom(Type type2, ParameterizedType parameterizedType, Map<String, Type> map) {
        if (type2 == null) {
            return false;
        }
        if (parameterizedType.equals(type2)) {
            return true;
        }
        Class<?> rawType2 = C$Gson$Types.getRawType(type2);
        ParameterizedType parameterizedType2 = type2 instanceof ParameterizedType ? (ParameterizedType) type2 : null;
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable[] typeParameters = rawType2.getTypeParameters();
            for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                Type type3 = actualTypeArguments[i2];
                TypeVariable typeVariable = typeParameters[i2];
                while (type3 instanceof TypeVariable) {
                    type3 = map.get(((TypeVariable) type3).getName());
                }
                map.put(typeVariable.getName(), type3);
            }
            if (typeEquals(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        for (Type isAssignableFrom : rawType2.getGenericInterfaces()) {
            if (isAssignableFrom(isAssignableFrom, parameterizedType, new HashMap(map))) {
                return true;
            }
        }
        return isAssignableFrom(rawType2.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }
}
