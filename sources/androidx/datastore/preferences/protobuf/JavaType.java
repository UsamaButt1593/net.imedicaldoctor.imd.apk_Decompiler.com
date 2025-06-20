package androidx.datastore.preferences.protobuf;

public enum JavaType {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(ByteString.class, ByteString.class, ByteString.X2),
    ENUM(r1, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> X;
    private final Object Y;
    private final Class<?> s;

    private JavaType(Class<?> cls, Class<?> cls2, Object obj) {
        this.s = cls;
        this.X = cls2;
        this.Y = obj;
    }

    public Class<?> a() {
        return this.X;
    }

    public Object b() {
        return this.Y;
    }

    public Class<?> c() {
        return this.s;
    }

    public boolean e(Class<?> cls) {
        return this.s.isAssignableFrom(cls);
    }
}
