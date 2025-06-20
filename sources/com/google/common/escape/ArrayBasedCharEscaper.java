package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ArrayBasedCharEscaper extends CharEscaper {

    /* renamed from: c  reason: collision with root package name */
    private final char[][] f22518c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22519d;

    /* renamed from: e  reason: collision with root package name */
    private final char f22520e;

    /* renamed from: f  reason: collision with root package name */
    private final char f22521f;

    protected ArrayBasedCharEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, char c2, char c3) {
        Preconditions.E(arrayBasedEscaperMap);
        char[][] c4 = arrayBasedEscaperMap.c();
        this.f22518c = c4;
        this.f22519d = c4.length;
        if (c3 < c2) {
            c3 = 0;
            c2 = CharCompanionObject.f28914c;
        }
        this.f22520e = c2;
        this.f22521f = c3;
    }

    public final String b(String str) {
        Preconditions.E(str);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < this.f22519d && this.f22518c[charAt] != null) || charAt > this.f22521f || charAt < this.f22520e) {
                return d(str, i2);
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final char[] c(char c2) {
        char[] cArr;
        if (c2 < this.f22519d && (cArr = this.f22518c[c2]) != null) {
            return cArr;
        }
        if (c2 < this.f22520e || c2 > this.f22521f) {
            return f(c2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract char[] f(char c2);

    protected ArrayBasedCharEscaper(Map<Character, String> map, char c2, char c3) {
        this(ArrayBasedEscaperMap.a(map), c2, c3);
    }
}
