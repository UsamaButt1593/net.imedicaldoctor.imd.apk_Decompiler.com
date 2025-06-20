package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {

    /* renamed from: c  reason: collision with root package name */
    private final char[][] f22524c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22525d;

    /* renamed from: e  reason: collision with root package name */
    private final int f22526e;

    /* renamed from: f  reason: collision with root package name */
    private final int f22527f;

    /* renamed from: g  reason: collision with root package name */
    private final char f22528g;

    /* renamed from: h  reason: collision with root package name */
    private final char f22529h;

    protected ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, int i2, int i3, String str) {
        char min;
        Preconditions.E(arrayBasedEscaperMap);
        char[][] c2 = arrayBasedEscaperMap.c();
        this.f22524c = c2;
        this.f22525d = c2.length;
        if (i3 < i2) {
            i3 = -1;
            i2 = Integer.MAX_VALUE;
        }
        this.f22526e = i2;
        this.f22527f = i3;
        if (i2 >= 55296) {
            this.f22528g = CharCompanionObject.f28914c;
            min = 0;
        } else {
            this.f22528g = (char) i2;
            min = (char) Math.min(i3, 55295);
        }
        this.f22529h = min;
    }

    public final String b(String str) {
        Preconditions.E(str);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < this.f22525d && this.f22524c[charAt] != null) || charAt > this.f22529h || charAt < this.f22528g) {
                return e(str, i2);
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final char[] d(int i2) {
        char[] cArr;
        if (i2 < this.f22525d && (cArr = this.f22524c[i2]) != null) {
            return cArr;
        }
        if (i2 < this.f22526e || i2 > this.f22527f) {
            return h(i2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final int g(CharSequence charSequence, int i2, int i3) {
        while (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            if ((charAt < this.f22525d && this.f22524c[charAt] != null) || charAt > this.f22529h || charAt < this.f22528g) {
                break;
            }
            i2++;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract char[] h(int i2);

    protected ArrayBasedUnicodeEscaper(Map<Character, String> map, int i2, int i3, String str) {
        this(ArrayBasedEscaperMap.a(map), i2, i3, str);
    }
}
