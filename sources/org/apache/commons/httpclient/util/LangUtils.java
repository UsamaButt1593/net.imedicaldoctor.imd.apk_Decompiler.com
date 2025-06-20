package org.apache.commons.httpclient.util;

public class LangUtils {
    public static final int HASH_OFFSET = 37;
    public static final int HASH_SEED = 17;

    private LangUtils() {
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int hashCode(int i2, int i3) {
        return (i2 * 37) + i3;
    }

    public static int hashCode(int i2, Object obj) {
        return hashCode(i2, obj != null ? obj.hashCode() : 0);
    }

    public static int hashCode(int i2, boolean z) {
        return hashCode(i2, z ? 1 : 0);
    }
}
