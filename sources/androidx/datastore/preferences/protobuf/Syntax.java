package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);
    
    public static final int X2 = 0;
    public static final int Y2 = 1;
    private static final Internal.EnumLiteMap<Syntax> Z2 = null;
    private final int s;

    private static final class SyntaxVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f7264a = null;

        static {
            f7264a = new SyntaxVerifier();
        }

        private SyntaxVerifier() {
        }

        public boolean a(int i2) {
            return Syntax.a(i2) != null;
        }
    }

    static {
        Z2 = new Internal.EnumLiteMap<Syntax>() {
            /* renamed from: b */
            public Syntax a(int i2) {
                return Syntax.a(i2);
            }
        };
    }

    private Syntax(int i2) {
        this.s = i2;
    }

    public static Syntax a(int i2) {
        if (i2 == 0) {
            return SYNTAX_PROTO2;
        }
        if (i2 != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static Internal.EnumLiteMap<Syntax> b() {
        return Z2;
    }

    public static Internal.EnumVerifier c() {
        return SyntaxVerifier.f7264a;
    }

    @Deprecated
    public static Syntax e(int i2) {
        return a(i2);
    }

    public final int d() {
        if (this != UNRECOGNIZED) {
            return this.s;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
