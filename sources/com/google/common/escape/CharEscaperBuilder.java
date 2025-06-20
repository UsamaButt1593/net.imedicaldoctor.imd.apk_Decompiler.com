package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class CharEscaperBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Character, String> f22531a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f22532b = -1;

    private static class CharArrayDecorator extends CharEscaper {

        /* renamed from: c  reason: collision with root package name */
        private final char[][] f22533c;

        /* renamed from: d  reason: collision with root package name */
        private final int f22534d;

        CharArrayDecorator(char[][] cArr) {
            this.f22533c = cArr;
            this.f22534d = cArr.length;
        }

        public String b(String str) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                char[][] cArr = this.f22533c;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return d(str, i2);
                }
            }
            return str;
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public char[] c(char c2) {
            if (c2 < this.f22534d) {
                return this.f22533c[c2];
            }
            return null;
        }
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder a(char c2, String str) {
        this.f22531a.put(Character.valueOf(c2), (String) Preconditions.E(str));
        if (c2 > this.f22532b) {
            this.f22532b = c2;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder b(char[] cArr, String str) {
        Preconditions.E(str);
        for (char a2 : cArr) {
            a(a2, str);
        }
        return this;
    }

    public char[][] c() {
        char[][] cArr = new char[(this.f22532b + 1)][];
        for (Map.Entry next : this.f22531a.entrySet()) {
            cArr[((Character) next.getKey()).charValue()] = ((String) next.getValue()).toCharArray();
        }
        return cArr;
    }

    public Escaper d() {
        return new CharArrayDecorator(c());
    }
}
