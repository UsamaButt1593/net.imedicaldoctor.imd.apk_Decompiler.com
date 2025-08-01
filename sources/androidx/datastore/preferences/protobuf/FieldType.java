package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public enum FieldType {
    DOUBLE(0, r4, r8),
    FLOAT(1, r4, r10),
    INT64(2, r4, r5),
    UINT64(3, r4, r5),
    INT32(4, r4, r15),
    FIXED64(5, r4, r12),
    FIXED32(6, r4, r15),
    BOOL(7, r4, r19),
    STRING(8, r4, r21),
    MESSAGE(9, r4, r23),
    BYTES(10, r4, r25),
    UINT32(11, r4, r15),
    ENUM(12, r4, r28),
    SFIXED32(13, r4, r15),
    SFIXED64(14, r4, r12),
    SINT32(15, r4, r15),
    SINT64(16, r4, r12),
    GROUP(17, r4, r23),
    DOUBLE_LIST(18, r4, r8),
    FLOAT_LIST(19, r4, r10),
    INT64_LIST(20, r4, r5),
    UINT64_LIST(21, r4, r5),
    INT32_LIST(22, r4, r15),
    FIXED64_LIST(23, r4, r12),
    FIXED32_LIST(24, r4, r15),
    BOOL_LIST(25, r4, r19),
    STRING_LIST(26, r4, r21),
    MESSAGE_LIST(27, r4, r23),
    BYTES_LIST(28, r4, r25),
    UINT32_LIST(29, r4, r15),
    ENUM_LIST(30, r4, r28),
    SFIXED32_LIST(31, r4, r15),
    SFIXED64_LIST(32, r4, r12),
    SINT32_LIST(33, r4, r15),
    SINT64_LIST(34, r4, r12),
    DOUBLE_LIST_PACKED(35, r4, r8),
    FLOAT_LIST_PACKED(36, r4, r10),
    INT64_LIST_PACKED(37, r4, r5),
    UINT64_LIST_PACKED(38, r4, r5),
    INT32_LIST_PACKED(39, r4, r15),
    FIXED64_LIST_PACKED(40, r4, r12),
    FIXED32_LIST_PACKED(41, r4, r15),
    BOOL_LIST_PACKED(42, r4, r19),
    UINT32_LIST_PACKED(43, r4, r15),
    ENUM_LIST_PACKED(44, r4, r28),
    SFIXED32_LIST_PACKED(45, r4, r15),
    SFIXED64_LIST_PACKED(46, r4, r12),
    SINT32_LIST_PACKED(47, r4, r15),
    SINT64_LIST_PACKED(48, r4, r12),
    GROUP_LIST(49, r34, r23),
    MAP(50, Collection.MAP, JavaType.VOID);
    
    private static final FieldType[] X3 = null;
    private static final Type[] Y3 = null;
    private final int X;
    private final boolean X2;
    private final Collection Y;
    private final Class<?> Z;
    private final JavaType s;

    /* renamed from: androidx.datastore.preferences.protobuf.FieldType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7150a = null;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f7151b = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                androidx.datastore.preferences.protobuf.JavaType[] r0 = androidx.datastore.preferences.protobuf.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7151b = r0
                r1 = 1
                androidx.datastore.preferences.protobuf.JavaType r2 = androidx.datastore.preferences.protobuf.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f7151b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.JavaType r3 = androidx.datastore.preferences.protobuf.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f7151b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.JavaType r4 = androidx.datastore.preferences.protobuf.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.datastore.preferences.protobuf.FieldType$Collection[] r3 = androidx.datastore.preferences.protobuf.FieldType.Collection.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f7150a = r3
                androidx.datastore.preferences.protobuf.FieldType$Collection r4 = androidx.datastore.preferences.protobuf.FieldType.Collection.MAP     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f7150a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.datastore.preferences.protobuf.FieldType$Collection r3 = androidx.datastore.preferences.protobuf.FieldType.Collection.VECTOR     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f7150a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.datastore.preferences.protobuf.FieldType$Collection r1 = androidx.datastore.preferences.protobuf.FieldType.Collection.SCALAR     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldType.AnonymousClass1.<clinit>():void");
        }
    }

    enum Collection {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        
        private final boolean s;

        private Collection(boolean z) {
            this.s = z;
        }

        public boolean a() {
            return this.s;
        }
    }

    static {
        int i2;
        Y3 = new Type[0];
        FieldType[] values = values();
        X3 = new FieldType[values.length];
        for (FieldType fieldType : values) {
            X3[fieldType.X] = fieldType;
        }
    }

    private FieldType(int i2, Collection collection, JavaType javaType) {
        int i3;
        this.X = i2;
        this.Y = collection;
        this.s = javaType;
        int i4 = AnonymousClass1.f7150a[collection.ordinal()];
        boolean z = true;
        this.Z = (i4 == 1 || i4 == 2) ? javaType.a() : null;
        this.X2 = (collection != Collection.SCALAR || (i3 = AnonymousClass1.f7151b[javaType.ordinal()]) == 1 || i3 == 2 || i3 == 3) ? false : z;
    }

    public static FieldType a(int i2) {
        if (i2 < 0) {
            return null;
        }
        FieldType[] fieldTypeArr = X3;
        if (i2 >= fieldTypeArr.length) {
            return null;
        }
        return fieldTypeArr[i2];
    }

    private static Type b(Class<?> cls) {
        Type[] genericInterfaces = cls.getGenericInterfaces();
        int length = genericInterfaces.length;
        int i2 = 0;
        while (true) {
            Class<List> cls2 = List.class;
            if (i2 < length) {
                Type type = genericInterfaces[i2];
                if ((type instanceof ParameterizedType) && cls2.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                    return type;
                }
                i2++;
            } else {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (!(genericSuperclass instanceof ParameterizedType) || !cls2.isAssignableFrom((Class) ((ParameterizedType) genericSuperclass).getRawType())) {
                    return null;
                }
                return genericSuperclass;
            }
        }
    }

    private static Type e(Class<?> cls, Type[] typeArr) {
        Class<? super Object> cls2;
        while (true) {
            Class<List> cls3 = List.class;
            int i2 = 0;
            Class<? super Object> cls4 = cls;
            if (cls4 != cls3) {
                Type b2 = b(cls4);
                if (!(b2 instanceof ParameterizedType)) {
                    typeArr = Y3;
                    Class<? super Object>[] interfaces = cls4.getInterfaces();
                    int length = interfaces.length;
                    while (true) {
                        if (i2 >= length) {
                            cls2 = cls4.getSuperclass();
                            break;
                        }
                        Class<? super Object> cls5 = interfaces[i2];
                        if (cls3.isAssignableFrom(cls5)) {
                            cls2 = cls5;
                            break;
                        }
                        i2++;
                    }
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) b2;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i3 = 0; i3 < actualTypeArguments.length; i3++) {
                        Type type = actualTypeArguments[i3];
                        if (type instanceof TypeVariable) {
                            TypeVariable[] typeParameters = cls4.getTypeParameters();
                            if (typeArr.length == typeParameters.length) {
                                int i4 = 0;
                                while (i4 < typeParameters.length) {
                                    if (type == typeParameters[i4]) {
                                        actualTypeArguments[i3] = typeArr[i4];
                                    } else {
                                        i4++;
                                    }
                                }
                                throw new RuntimeException("Unable to find replacement for " + type);
                            }
                            throw new RuntimeException("Type array mismatch");
                        }
                    }
                    typeArr = actualTypeArguments;
                    cls2 = (Class) parameterizedType.getRawType();
                }
                cls4 = cls2;
            } else if (typeArr.length == 1) {
                return typeArr[0];
            } else {
                throw new RuntimeException("Unable to identify parameter type for List<T>");
            }
        }
    }

    private boolean l(Field field) {
        Class<?> type = field.getType();
        if (!this.s.c().isAssignableFrom(type)) {
            return false;
        }
        Type[] typeArr = Y3;
        if (field.getGenericType() instanceof ParameterizedType) {
            typeArr = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        }
        Type e2 = e(type, typeArr);
        if (!(e2 instanceof Class)) {
            return true;
        }
        return this.Z.isAssignableFrom((Class) e2);
    }

    public boolean a2() {
        return Collection.PACKED_VECTOR.equals(this.Y);
    }

    public JavaType c() {
        return this.s;
    }

    public int f() {
        return this.X;
    }

    public boolean g() {
        return this.Y.a();
    }

    public boolean h() {
        return this.Y == Collection.MAP;
    }

    public boolean i() {
        return this.X2;
    }

    public boolean j() {
        return this.Y == Collection.SCALAR;
    }

    public boolean k(Field field) {
        return Collection.VECTOR.equals(this.Y) ? l(field) : this.s.c().isAssignableFrom(field.getType());
    }
}
