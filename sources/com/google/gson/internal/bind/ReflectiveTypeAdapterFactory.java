package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final List<ReflectionAccessFilter> reflectionFilters;

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {
        final Map<String, BoundField> boundFields;

        Adapter(Map<String, BoundField> map) {
            this.boundFields = map;
        }

        /* access modifiers changed from: package-private */
        public abstract A createAccumulator();

        /* access modifiers changed from: package-private */
        public abstract T finalize(A a2);

        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Object createAccumulator = createAccumulator();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField != null) {
                        if (boundField.deserialized) {
                            readField(createAccumulator, jsonReader, boundField);
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return finalize(createAccumulator);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException((Throwable) e2);
            } catch (IllegalAccessException e3) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e3);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void readField(A a2, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException;

        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField write : this.boundFields.values()) {
                    write.write(jsonWriter, t);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e2) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e2);
            }
        }
    }

    static abstract class BoundField {
        final boolean deserialized;
        final Field field;
        final String fieldName;
        final String name;
        final boolean serialized;

        protected BoundField(String str, Field field2, boolean z, boolean z2) {
            this.name = str;
            this.field = field2;
            this.fieldName = field2.getName();
            this.serialized = z;
            this.deserialized = z2;
        }

        /* access modifiers changed from: package-private */
        public abstract void readIntoArray(JsonReader jsonReader, int i2, Object[] objArr) throws IOException, JsonParseException;

        /* access modifiers changed from: package-private */
        public abstract void readIntoField(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;
    }

    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {
        private final ObjectConstructor<T> constructor;

        FieldReflectionAdapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            super(map);
            this.constructor = objectConstructor;
        }

        /* access modifiers changed from: package-private */
        public T createAccumulator() {
            return this.constructor.construct();
        }

        /* access modifiers changed from: package-private */
        public T finalize(T t) {
            return t;
        }

        /* access modifiers changed from: package-private */
        public void readField(T t, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException {
            boundField.readIntoField(jsonReader, t);
        }
    }

    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {
        static final Map<Class<?>, Object> PRIMITIVE_DEFAULTS = primitiveDefaults();
        private final Map<String, Integer> componentIndices = new HashMap();
        private final Constructor<T> constructor;
        private final Object[] constructorArgsDefaults;

        RecordAdapter(Class<T> cls, Map<String, BoundField> map, boolean z) {
            super(map);
            Constructor<T> canonicalRecordConstructor = ReflectionHelper.getCanonicalRecordConstructor(cls);
            this.constructor = canonicalRecordConstructor;
            if (z) {
                ReflectiveTypeAdapterFactory.checkAccessible((Object) null, canonicalRecordConstructor);
            } else {
                ReflectionHelper.makeAccessible(canonicalRecordConstructor);
            }
            String[] recordComponentNames = ReflectionHelper.getRecordComponentNames(cls);
            for (int i2 = 0; i2 < recordComponentNames.length; i2++) {
                this.componentIndices.put(recordComponentNames[i2], Integer.valueOf(i2));
            }
            Class[] parameterTypes = this.constructor.getParameterTypes();
            this.constructorArgsDefaults = new Object[parameterTypes.length];
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                this.constructorArgsDefaults[i3] = PRIMITIVE_DEFAULTS.get(parameterTypes[i3]);
            }
        }

        private static Map<Class<?>, Object> primitiveDefaults() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        /* access modifiers changed from: package-private */
        public Object[] createAccumulator() {
            return (Object[]) this.constructorArgsDefaults.clone();
        }

        /* access modifiers changed from: package-private */
        public T finalize(Object[] objArr) {
            try {
                return this.constructor.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e2);
            } catch (IllegalArgumentException | InstantiationException e3) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e4.getCause());
            }
        }

        /* access modifiers changed from: package-private */
        public void readField(Object[] objArr, JsonReader jsonReader, BoundField boundField) throws IOException {
            Integer num = this.componentIndices.get(boundField.fieldName);
            if (num != null) {
                boundField.readIntoArray(jsonReader, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' for field with name '" + boundField.fieldName + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor2, FieldNamingStrategy fieldNamingStrategy, Excluder excluder2, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.constructorConstructor = constructorConstructor2;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder2;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        this.reflectionFilters = list;
    }

    /* access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void checkAccessible(Object obj, M m2) {
        if (Modifier.isStatic(((Member) m2).getModifiers())) {
            obj = null;
        }
        if (!ReflectionAccessFilterHelper.canAccess(m2, obj)) {
            String accessibleObjectDescription = ReflectionHelper.getAccessibleObjectDescription(m2, true);
            throw new JsonIOException(accessibleObjectDescription + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
        }
    }

    private BoundField createBoundField(Gson gson, Field field, Method method, String str, TypeToken<?> typeToken, boolean z, boolean z2, boolean z3) {
        Gson gson2 = gson;
        TypeToken<?> typeToken2 = typeToken;
        final boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        int modifiers = field.getModifiers();
        final boolean z4 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson2, typeToken2, jsonAdapter) : null;
        final boolean z5 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson2.getAdapter(typeToken2);
        }
        final TypeAdapter<?> typeAdapter2 = typeAdapter;
        final boolean z6 = z3;
        final Method method2 = method;
        final Gson gson3 = gson;
        final TypeToken<?> typeToken3 = typeToken;
        return new BoundField(str, field, z, z2) {
            /* access modifiers changed from: package-private */
            public void readIntoArray(JsonReader jsonReader, int i2, Object[] objArr) throws IOException, JsonParseException {
                Object read = typeAdapter2.read(jsonReader);
                if (read != null || !isPrimitive) {
                    objArr[i2] = read;
                    return;
                }
                throw new JsonParseException("null is not allowed as value for record component '" + this.fieldName + "' of primitive type; at path " + jsonReader.getPath());
            }

            /* access modifiers changed from: package-private */
            public void readIntoField(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read = typeAdapter2.read(jsonReader);
                if (read != null || !isPrimitive) {
                    if (z6) {
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, this.field);
                    } else if (z4) {
                        String accessibleObjectDescription = ReflectionHelper.getAccessibleObjectDescription(this.field, false);
                        throw new JsonIOException("Cannot set value of 'static final' " + accessibleObjectDescription);
                    }
                    this.field.set(obj, read);
                }
            }

            /* access modifiers changed from: package-private */
            public void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                Object obj2;
                if (this.serialized) {
                    if (z6) {
                        AccessibleObject accessibleObject = method2;
                        if (accessibleObject == null) {
                            accessibleObject = this.field;
                        }
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, accessibleObject);
                    }
                    Method method = method2;
                    if (method != null) {
                        try {
                            obj2 = method.invoke(obj, (Object[]) null);
                        } catch (InvocationTargetException e2) {
                            String accessibleObjectDescription = ReflectionHelper.getAccessibleObjectDescription(method2, false);
                            throw new JsonIOException("Accessor " + accessibleObjectDescription + " threw exception", e2.getCause());
                        }
                    } else {
                        obj2 = this.field.get(obj);
                    }
                    if (obj2 != obj) {
                        jsonWriter.name(this.name);
                        (z5 ? typeAdapter2 : new TypeAdapterRuntimeTypeWrapper(gson3, typeAdapter2, typeToken3.getType())).write(jsonWriter, obj2);
                    }
                }
            }
        };
    }

    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls, boolean z, boolean z2) {
        int i2;
        int i3;
        Method method;
        boolean z3;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        Class<?> cls2 = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        TypeToken<?> typeToken2 = typeToken;
        boolean z4 = z;
        Class<? super Object> cls3 = cls2;
        while (cls3 != Object.class) {
            Field[] declaredFields = cls3.getDeclaredFields();
            boolean z5 = true;
            boolean z6 = false;
            if (cls3 != cls2 && declaredFields.length > 0) {
                ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(reflectiveTypeAdapterFactory.reflectionFilters, cls3);
                if (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                    z4 = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
                } else {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + cls3 + " (supertype of " + cls2 + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
            }
            boolean z7 = z4;
            int length = declaredFields.length;
            int i4 = 0;
            while (i4 < length) {
                Field field = declaredFields[i4];
                boolean includeField = reflectiveTypeAdapterFactory.includeField(field, z5);
                boolean includeField2 = reflectiveTypeAdapterFactory.includeField(field, z6);
                if (includeField || includeField2) {
                    BoundField boundField = null;
                    if (!z2) {
                        z3 = includeField2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z3 = false;
                    } else {
                        Method accessor = ReflectionHelper.getAccessor(cls3, field);
                        if (!z7) {
                            ReflectionHelper.makeAccessible(accessor);
                        }
                        Class cls4 = SerializedName.class;
                        if (accessor.getAnnotation(cls4) == null || field.getAnnotation(cls4) != null) {
                            z3 = includeField2;
                            method = accessor;
                        } else {
                            throw new JsonIOException("@SerializedName on " + ReflectionHelper.getAccessibleObjectDescription(accessor, z6) + " is not supported");
                        }
                    }
                    if (!z7 && method == null) {
                        ReflectionHelper.makeAccessible(field);
                    }
                    Type resolve = C$Gson$Types.resolve(typeToken2.getType(), cls3, field.getGenericType());
                    List<String> fieldNames = reflectiveTypeAdapterFactory.getFieldNames(field);
                    int size = fieldNames.size();
                    int i5 = 0;
                    while (i5 < size) {
                        String str = fieldNames.get(i5);
                        boolean z8 = i5 != 0 ? false : includeField;
                        int i6 = i5;
                        BoundField boundField2 = boundField;
                        int i7 = size;
                        List<String> list = fieldNames;
                        Field field2 = field;
                        int i8 = i4;
                        int i9 = length;
                        boundField = boundField2 == null ? (BoundField) linkedHashMap.put(str, createBoundField(gson, field, method, str, TypeToken.get(resolve), z8, z3, z7)) : boundField2;
                        i5 = i6 + 1;
                        includeField = z8;
                        i4 = i8;
                        size = i7;
                        fieldNames = list;
                        field = field2;
                        length = i9;
                    }
                    BoundField boundField3 = boundField;
                    Field field3 = field;
                    i3 = i4;
                    i2 = length;
                    if (boundField3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + boundField3.name + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(boundField3.field) + " and " + ReflectionHelper.fieldToString(field3));
                    }
                } else {
                    i3 = i4;
                    i2 = length;
                }
                i4 = i3 + 1;
                length = i2;
                z6 = false;
                z5 = true;
                reflectiveTypeAdapterFactory = this;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls3, cls3.getGenericSuperclass()));
            cls3 = typeToken2.getRawType();
            reflectiveTypeAdapterFactory = this;
            z4 = z7;
        }
        return linkedHashMap;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    private boolean includeField(Field field, boolean z) {
        return !this.excluder.excludeClass(field.getType(), z) && !this.excluder.excludeField(field, z);
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        if (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            boolean z = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
            return ReflectionHelper.isRecord(rawType) ? new RecordAdapter(rawType, getBoundFields(gson, typeToken, rawType, z, true), z) : new FieldReflectionAdapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType, z, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
