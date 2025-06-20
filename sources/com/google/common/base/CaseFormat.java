package com.google.common.base;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public enum CaseFormat {
    LOWER_HYPHEN(CharMatcher.q('-'), "-") {
        /* access modifiers changed from: package-private */
        public String c(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return str.replace('-', '_');
            }
            return caseFormat == CaseFormat.UPPER_UNDERSCORE ? Ascii.j(str.replace('-', '_')) : CaseFormat.super.c(caseFormat, str);
        }

        /* access modifiers changed from: package-private */
        public String h(String str) {
            return Ascii.g(str);
        }
    },
    LOWER_UNDERSCORE(CharMatcher.q('_'), "_") {
        /* access modifiers changed from: package-private */
        public String c(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return str.replace('_', '-');
            }
            return caseFormat == CaseFormat.UPPER_UNDERSCORE ? Ascii.j(str) : CaseFormat.super.c(caseFormat, str);
        }

        /* access modifiers changed from: package-private */
        public String h(String str) {
            return Ascii.g(str);
        }
    },
    LOWER_CAMEL(CharMatcher.m('A', ASCIIPropertyListParser.D), "") {
        /* access modifiers changed from: package-private */
        public String g(String str) {
            return Ascii.g(str);
        }

        /* access modifiers changed from: package-private */
        public String h(String str) {
            return CaseFormat.f(str);
        }
    },
    UPPER_CAMEL(CharMatcher.m('A', ASCIIPropertyListParser.D), "") {
        /* access modifiers changed from: package-private */
        public String h(String str) {
            return CaseFormat.f(str);
        }
    },
    UPPER_UNDERSCORE(CharMatcher.q('_'), "_") {
        /* access modifiers changed from: package-private */
        public String c(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return Ascii.g(str.replace('_', '-'));
            }
            return caseFormat == CaseFormat.LOWER_UNDERSCORE ? Ascii.g(str) : CaseFormat.super.c(caseFormat, str);
        }

        /* access modifiers changed from: package-private */
        public String h(String str) {
            return Ascii.j(str);
        }
    };
    
    private final String X;
    private final CharMatcher s;

    private static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long X2 = 0;
        private final CaseFormat Y;
        private final CaseFormat Z;

        StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.Y = (CaseFormat) Preconditions.E(caseFormat);
            this.Z = (CaseFormat) Preconditions.E(caseFormat2);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof StringConverter)) {
                return false;
            }
            StringConverter stringConverter = (StringConverter) obj;
            return this.Y.equals(stringConverter.Y) && this.Z.equals(stringConverter.Z);
        }

        public int hashCode() {
            return this.Y.hashCode() ^ this.Z.hashCode();
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public String h(String str) {
            return this.Z.i(this.Y, str);
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public String i(String str) {
            return this.Y.i(this.Z, str);
        }

        public String toString() {
            return this.Y + ".converterTo(" + this.Z + ")";
        }
    }

    private CaseFormat(CharMatcher charMatcher, String str) {
        this.s = charMatcher;
        this.X = str;
    }

    /* access modifiers changed from: private */
    public static String f(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return Ascii.h(str.charAt(0)) + Ascii.g(str.substring(1));
    }

    /* access modifiers changed from: package-private */
    public String c(CaseFormat caseFormat, String str) {
        String h2;
        StringBuilder sb = null;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            i3 = this.s.o(str, i3 + 1);
            if (i3 == -1) {
                break;
            }
            if (i2 == 0) {
                sb = new StringBuilder(str.length() + (caseFormat.X.length() * 4));
                h2 = caseFormat.g(str.substring(i2, i3));
            } else {
                Objects.requireNonNull(sb);
                h2 = caseFormat.h(str.substring(i2, i3));
            }
            sb.append(h2);
            sb.append(caseFormat.X);
            i2 = this.X.length() + i3;
        }
        if (i2 == 0) {
            return caseFormat.g(str);
        }
        Objects.requireNonNull(sb);
        sb.append(caseFormat.h(str.substring(i2)));
        return sb.toString();
    }

    public Converter<String, String> e(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    /* access modifiers changed from: package-private */
    public String g(String str) {
        return h(str);
    }

    /* access modifiers changed from: package-private */
    public abstract String h(String str);

    public final String i(CaseFormat caseFormat, String str) {
        Preconditions.E(caseFormat);
        Preconditions.E(str);
        return caseFormat == this ? str : c(caseFormat, str);
    }
}
