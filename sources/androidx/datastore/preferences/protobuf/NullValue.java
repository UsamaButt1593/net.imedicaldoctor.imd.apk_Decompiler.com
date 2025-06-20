package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    
    private static final Internal.EnumLiteMap<NullValue> X2 = null;
    public static final int Z = 0;
    private final int s;

    private static final class NullValueVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f7227a = null;

        static {
            f7227a = new NullValueVerifier();
        }

        private NullValueVerifier() {
        }

        public boolean a(int i2) {
            return NullValue.a(i2) != null;
        }
    }

    static {
        X2 = new Internal.EnumLiteMap<NullValue>() {
            /* renamed from: b */
            public NullValue a(int i2) {
                return NullValue.a(i2);
            }
        };
    }

    private NullValue(int i2) {
        this.s = i2;
    }

    public static NullValue a(int i2) {
        if (i2 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static Internal.EnumLiteMap<NullValue> b() {
        return X2;
    }

    public static Internal.EnumVerifier c() {
        return NullValueVerifier.f7227a;
    }

    @Deprecated
    public static NullValue e(int i2) {
        return a(i2);
    }

    public final int d() {
        if (this != UNRECOGNIZED) {
            return this.s;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
