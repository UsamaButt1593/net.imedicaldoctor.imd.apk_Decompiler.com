package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class ArrayBasedEscaperMap {

    /* renamed from: b  reason: collision with root package name */
    private static final char[][] f22522b;

    /* renamed from: a  reason: collision with root package name */
    private final char[][] f22523a;

    static {
        int[] iArr = new int[2];
        iArr[1] = 0;
        iArr[0] = 0;
        f22522b = (char[][]) Array.newInstance(Character.TYPE, iArr);
    }

    private ArrayBasedEscaperMap(char[][] cArr) {
        this.f22523a = cArr;
    }

    public static ArrayBasedEscaperMap a(Map<Character, String> map) {
        return new ArrayBasedEscaperMap(b(map));
    }

    @VisibleForTesting
    static char[][] b(Map<Character, String> map) {
        Preconditions.E(map);
        if (map.isEmpty()) {
            return f22522b;
        }
        char[][] cArr = new char[(((Character) Collections.max(map.keySet())).charValue() + 1)][];
        for (Character next : map.keySet()) {
            cArr[next.charValue()] = map.get(next).toCharArray();
        }
        return cArr;
    }

    /* access modifiers changed from: package-private */
    public char[][] c() {
        return this.f22523a;
    }
}
