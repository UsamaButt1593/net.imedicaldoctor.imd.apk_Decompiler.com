package org.checkerframework.framework.qual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LiteralKind {
    NULL,
    INT,
    LONG,
    FLOAT,
    DOUBLE,
    BOOLEAN,
    CHAR,
    STRING,
    b3,
    PRIMITIVE;

    public static List<LiteralKind> b() {
        ArrayList arrayList = new ArrayList(Arrays.asList(values()));
        arrayList.remove(b3);
        arrayList.remove(PRIMITIVE);
        return arrayList;
    }

    public static List<LiteralKind> c() {
        return Arrays.asList(new LiteralKind[]{INT, LONG, FLOAT, DOUBLE, BOOLEAN, CHAR});
    }
}
