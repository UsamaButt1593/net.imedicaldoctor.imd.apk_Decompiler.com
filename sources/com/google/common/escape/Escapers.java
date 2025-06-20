package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Escapers {

    /* renamed from: a  reason: collision with root package name */
    private static final Escaper f22536a = new CharEscaper() {
        public String b(String str) {
            return (String) Preconditions.E(str);
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public char[] c(char c2) {
            return null;
        }
    };

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Character, String> f22538a;

        /* renamed from: b  reason: collision with root package name */
        private char f22539b;

        /* renamed from: c  reason: collision with root package name */
        private char f22540c;
        /* access modifiers changed from: private */
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        public String f22541d;

        private Builder() {
            this.f22538a = new HashMap();
            this.f22539b = 0;
            this.f22540c = CharCompanionObject.f28914c;
            this.f22541d = null;
        }

        @CanIgnoreReturnValue
        public Builder b(char c2, String str) {
            Preconditions.E(str);
            this.f22538a.put(Character.valueOf(c2), str);
            return this;
        }

        public Escaper c() {
            return new ArrayBasedCharEscaper(this.f22538a, this.f22539b, this.f22540c) {
                @CheckForNull

                /* renamed from: g  reason: collision with root package name */
                private final char[] f22542g;

                {
                    this.f22542g = Builder.this.f22541d != null ? Builder.this.f22541d.toCharArray() : null;
                }

                /* access modifiers changed from: protected */
                @CheckForNull
                public char[] f(char c2) {
                    return this.f22542g;
                }
            };
        }

        @CanIgnoreReturnValue
        public Builder d(char c2, char c3) {
            this.f22539b = c2;
            this.f22540c = c3;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(String str) {
            this.f22541d = str;
            return this;
        }
    }

    private Escapers() {
    }

    static UnicodeEscaper a(Escaper escaper) {
        Preconditions.E(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return g((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }

    public static Builder b() {
        return new Builder();
    }

    @CheckForNull
    public static String c(CharEscaper charEscaper, char c2) {
        return f(charEscaper.c(c2));
    }

    @CheckForNull
    public static String d(UnicodeEscaper unicodeEscaper, int i2) {
        return f(unicodeEscaper.d(i2));
    }

    public static Escaper e() {
        return f22536a;
    }

    @CheckForNull
    private static String f(@CheckForNull char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper g(final CharEscaper charEscaper) {
        return new UnicodeEscaper() {
            /* access modifiers changed from: protected */
            @CheckForNull
            public char[] d(int i2) {
                if (i2 < 65536) {
                    return CharEscaper.this.c((char) i2);
                }
                char[] cArr = new char[2];
                Character.toChars(i2, cArr, 0);
                char[] c2 = CharEscaper.this.c(cArr[0]);
                char[] c3 = CharEscaper.this.c(cArr[1]);
                if (c2 == null && c3 == null) {
                    return null;
                }
                int length = c2 != null ? c2.length : 1;
                char[] cArr2 = new char[((c3 != null ? c3.length : 1) + length)];
                if (c2 != null) {
                    for (int i3 = 0; i3 < c2.length; i3++) {
                        cArr2[i3] = c2[i3];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (c3 != null) {
                    for (int i4 = 0; i4 < c3.length; i4++) {
                        cArr2[length + i4] = c3[i4];
                    }
                } else {
                    cArr2[length] = cArr[1];
                }
                return cArr2;
            }
        };
    }
}
