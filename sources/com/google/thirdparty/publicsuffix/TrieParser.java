package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Queues;

@GwtCompatible
final class TrieParser {

    /* renamed from: a  reason: collision with root package name */
    private static final Joiner f25191a = Joiner.p("");

    TrieParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065 A[EDGE_INSN: B:35:0x0065->B:27:0x0065 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.util.Deque<java.lang.CharSequence> r8, java.lang.CharSequence r9, int r10, com.google.common.collect.ImmutableMap.Builder<java.lang.String, com.google.thirdparty.publicsuffix.PublicSuffixType> r11) {
        /*
            int r0 = r9.length()
            r1 = 0
            r2 = r10
        L_0x0006:
            r3 = 58
            r4 = 33
            r5 = 44
            r6 = 63
            if (r2 >= r0) goto L_0x0024
            char r1 = r9.charAt(r2)
            r7 = 38
            if (r1 == r7) goto L_0x0024
            if (r1 == r6) goto L_0x0024
            if (r1 == r4) goto L_0x0024
            if (r1 == r3) goto L_0x0024
            if (r1 != r5) goto L_0x0021
            goto L_0x0024
        L_0x0021:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0024:
            java.lang.CharSequence r7 = r9.subSequence(r10, r2)
            java.lang.CharSequence r7 = d(r7)
            r8.push(r7)
            if (r1 == r4) goto L_0x0037
            if (r1 == r6) goto L_0x0037
            if (r1 == r3) goto L_0x0037
            if (r1 != r5) goto L_0x004a
        L_0x0037:
            com.google.common.base.Joiner r3 = f25191a
            java.lang.String r3 = r3.k(r8)
            int r4 = r3.length()
            if (r4 <= 0) goto L_0x004a
            com.google.thirdparty.publicsuffix.PublicSuffixType r4 = com.google.thirdparty.publicsuffix.PublicSuffixType.b(r1)
            r11.i(r3, r4)
        L_0x004a:
            int r2 = r2 + 1
            if (r1 == r6) goto L_0x0065
            if (r1 == r5) goto L_0x0065
        L_0x0050:
            if (r2 >= r0) goto L_0x0065
            int r1 = a(r8, r9, r2, r11)
            int r2 = r2 + r1
            char r1 = r9.charAt(r2)
            if (r1 == r6) goto L_0x0063
            char r1 = r9.charAt(r2)
            if (r1 != r5) goto L_0x0050
        L_0x0063:
            int r2 = r2 + 1
        L_0x0065:
            r8.pop()
            int r2 = r2 - r10
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.thirdparty.publicsuffix.TrieParser.a(java.util.Deque, java.lang.CharSequence, int, com.google.common.collect.ImmutableMap$Builder):int");
    }

    @VisibleForTesting
    static ImmutableMap<String, PublicSuffixType> b(String str) {
        ImmutableMap.Builder b2 = ImmutableMap.b();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            i2 += a(Queues.d(), str, i2, b2);
        }
        return b2.d();
    }

    static ImmutableMap<String, PublicSuffixType> c(CharSequence... charSequenceArr) {
        return b(f25191a.n(charSequenceArr));
    }

    private static CharSequence d(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
