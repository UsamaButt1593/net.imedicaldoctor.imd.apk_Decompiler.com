package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i2, int i3) {
        return i3 + 1 == i2;
    }

    private boolean isNextChar(StringBuilder sb, int i2, char c2) {
        return i2 >= 0 && i2 < sb.length() - 1 && sb.charAt(i2 + 1) == c2;
    }

    private boolean isPreviousChar(StringBuilder sb, int i2, char c2) {
        return i2 > 0 && i2 < sb.length() && sb.charAt(i2 - 1) == c2;
    }

    private boolean isVowel(StringBuilder sb, int i2) {
        return VOWELS.indexOf(sb.charAt(i2)) >= 0;
    }

    private boolean regionMatch(StringBuilder sb, int i2, String str) {
        if (i2 < 0 || (str.length() + i2) - 1 >= sb.length()) {
            return false;
        }
        return sb.substring(i2, str.length() + i2).equals(str);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return metaphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0207, code lost:
        if (isNextChar(r2, r5, 'H') != false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x021b, code lost:
        if (isVowel(r2, 2) != false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x022b, code lost:
        if (isLastChar(r1, r5) != false) goto L_0x01c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x022e, code lost:
        if (r5 == 0) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0232, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        if (r1[1] == 'N') goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
        if (r1[1] == 'E') goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00aa, code lost:
        r4.append('S');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bf, code lost:
        if (isVowel(r2, r5 + 1) != false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c6, code lost:
        r4.append('F');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fa, code lost:
        r4.append('X');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0115, code lost:
        if (regionMatch(r2, r5, "SIA") == false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0121, code lost:
        if (isNextChar(r2, r5, 'H') != false) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012a, code lost:
        if (isPreviousChar(r2, r5, 'C') != false) goto L_0x01c3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x007f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String metaphone(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            if (r1 == 0) goto L_0x024b
            int r2 = r17.length()
            if (r2 != 0) goto L_0x000e
            goto L_0x024b
        L_0x000e:
            r3 = 1
            if (r2 != r3) goto L_0x0018
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r2)
            return r1
        L_0x0018:
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r2)
            char[] r1 = r1.toCharArray()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 40
            r2.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r5 = 10
            r4.<init>(r5)
            r5 = 0
            char r6 = r1[r5]
            r7 = 65
            r8 = 71
            r9 = 88
            r10 = 72
            r11 = 83
            r12 = 75
            if (r6 == r7) goto L_0x0074
            if (r6 == r8) goto L_0x006d
            if (r6 == r12) goto L_0x006d
            r7 = 80
            if (r6 == r7) goto L_0x006d
            r7 = 87
            if (r6 == r7) goto L_0x0056
            if (r6 == r9) goto L_0x0053
        L_0x004f:
            r2.append(r1)
            goto L_0x007b
        L_0x0053:
            r1[r5] = r11
            goto L_0x004f
        L_0x0056:
            char r6 = r1[r3]
            r13 = 82
            if (r6 != r13) goto L_0x0062
        L_0x005c:
            int r6 = r1.length
            int r6 = r6 - r3
            r2.append(r1, r3, r6)
            goto L_0x007b
        L_0x0062:
            if (r6 != r10) goto L_0x004f
            int r6 = r1.length
            int r6 = r6 - r3
            r2.append(r1, r3, r6)
            r2.setCharAt(r5, r7)
            goto L_0x007b
        L_0x006d:
            char r6 = r1[r3]
            r7 = 78
            if (r6 != r7) goto L_0x004f
            goto L_0x005c
        L_0x0074:
            char r6 = r1[r3]
            r7 = 69
            if (r6 != r7) goto L_0x004f
            goto L_0x005c
        L_0x007b:
            int r1 = r2.length()
        L_0x007f:
            int r6 = r4.length()
            int r7 = r16.getMaxCodeLen()
            if (r6 >= r7) goto L_0x0246
            if (r5 >= r1) goto L_0x0246
            char r6 = r2.charAt(r5)
            r7 = 67
            if (r6 == r7) goto L_0x009d
            boolean r13 = r0.isPreviousChar(r2, r5, r6)
            if (r13 == 0) goto L_0x009d
            int r5 = r5 + 1
            goto L_0x0233
        L_0x009d:
            r13 = 74
            r14 = 84
            r15 = 70
            java.lang.String r3 = "EIY"
            switch(r6) {
                case 65: goto L_0x022e;
                case 66: goto L_0x021f;
                case 67: goto L_0x01c6;
                case 68: goto L_0x01a5;
                case 69: goto L_0x022e;
                case 70: goto L_0x00c1;
                case 71: goto L_0x0154;
                case 72: goto L_0x012d;
                case 73: goto L_0x022e;
                case 74: goto L_0x00c1;
                case 75: goto L_0x0124;
                case 76: goto L_0x00c1;
                case 77: goto L_0x00c1;
                case 78: goto L_0x00c1;
                case 79: goto L_0x022e;
                case 80: goto L_0x011d;
                case 81: goto L_0x0118;
                case 82: goto L_0x00c1;
                case 83: goto L_0x00ff;
                case 84: goto L_0x00cb;
                case 85: goto L_0x022e;
                case 86: goto L_0x00c6;
                case 87: goto L_0x00b3;
                case 88: goto L_0x00af;
                case 89: goto L_0x00b3;
                case 90: goto L_0x00aa;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            goto L_0x01c3
        L_0x00aa:
            r4.append(r11)
            goto L_0x01c3
        L_0x00af:
            r4.append(r12)
            goto L_0x00aa
        L_0x00b3:
            boolean r3 = r0.isLastChar(r1, r5)
            if (r3 != 0) goto L_0x01c3
            int r3 = r5 + 1
            boolean r3 = r0.isVowel(r2, r3)
            if (r3 == 0) goto L_0x01c3
        L_0x00c1:
            r4.append(r6)
            goto L_0x01c3
        L_0x00c6:
            r4.append(r15)
            goto L_0x01c3
        L_0x00cb:
            java.lang.String r3 = "TIA"
            boolean r3 = r0.regionMatch(r2, r5, r3)
            if (r3 != 0) goto L_0x00fa
            java.lang.String r3 = "TIO"
            boolean r3 = r0.regionMatch(r2, r5, r3)
            if (r3 == 0) goto L_0x00dc
            goto L_0x00fa
        L_0x00dc:
            java.lang.String r3 = "TCH"
            boolean r3 = r0.regionMatch(r2, r5, r3)
            if (r3 == 0) goto L_0x00e6
            goto L_0x01c3
        L_0x00e6:
            java.lang.String r3 = "TH"
            boolean r3 = r0.regionMatch(r2, r5, r3)
            if (r3 == 0) goto L_0x00f5
            r3 = 48
            r4.append(r3)
            goto L_0x01c3
        L_0x00f5:
            r4.append(r14)
            goto L_0x01c3
        L_0x00fa:
            r4.append(r9)
            goto L_0x01c3
        L_0x00ff:
            java.lang.String r3 = "SH"
            boolean r3 = r0.regionMatch(r2, r5, r3)
            if (r3 != 0) goto L_0x00fa
            java.lang.String r3 = "SIO"
            boolean r3 = r0.regionMatch(r2, r5, r3)
            if (r3 != 0) goto L_0x00fa
            java.lang.String r3 = "SIA"
            boolean r3 = r0.regionMatch(r2, r5, r3)
            if (r3 == 0) goto L_0x00aa
            goto L_0x00fa
        L_0x0118:
            r4.append(r12)
            goto L_0x01c3
        L_0x011d:
            boolean r3 = r0.isNextChar(r2, r5, r10)
            if (r3 == 0) goto L_0x00c1
            goto L_0x00c6
        L_0x0124:
            if (r5 <= 0) goto L_0x00c1
            boolean r3 = r0.isPreviousChar(r2, r5, r7)
            if (r3 != 0) goto L_0x01c3
            goto L_0x00c1
        L_0x012d:
            boolean r3 = r0.isLastChar(r1, r5)
            if (r3 == 0) goto L_0x0135
            goto L_0x01c3
        L_0x0135:
            if (r5 <= 0) goto L_0x0147
            int r3 = r5 + -1
            char r3 = r2.charAt(r3)
            java.lang.String r6 = "CSPTG"
            int r3 = r6.indexOf(r3)
            if (r3 < 0) goto L_0x0147
            goto L_0x01c3
        L_0x0147:
            int r3 = r5 + 1
            boolean r3 = r0.isVowel(r2, r3)
            if (r3 == 0) goto L_0x01c3
            r4.append(r10)
            goto L_0x01c3
        L_0x0154:
            int r6 = r5 + 1
            boolean r7 = r0.isLastChar(r1, r6)
            if (r7 == 0) goto L_0x0163
            boolean r7 = r0.isNextChar(r2, r5, r10)
            if (r7 == 0) goto L_0x0163
            goto L_0x01c3
        L_0x0163:
            boolean r7 = r0.isLastChar(r1, r6)
            if (r7 != 0) goto L_0x0178
            boolean r7 = r0.isNextChar(r2, r5, r10)
            if (r7 == 0) goto L_0x0178
            int r7 = r5 + 2
            boolean r7 = r0.isVowel(r2, r7)
            if (r7 != 0) goto L_0x0178
            goto L_0x01c3
        L_0x0178:
            if (r5 <= 0) goto L_0x018b
            java.lang.String r7 = "GN"
            boolean r7 = r0.regionMatch(r2, r5, r7)
            if (r7 != 0) goto L_0x01c3
            java.lang.String r7 = "GNED"
            boolean r7 = r0.regionMatch(r2, r5, r7)
            if (r7 == 0) goto L_0x018b
            goto L_0x01c3
        L_0x018b:
            boolean r7 = r0.isPreviousChar(r2, r5, r8)
            boolean r14 = r0.isLastChar(r1, r5)
            if (r14 != 0) goto L_0x0118
            char r6 = r2.charAt(r6)
            int r3 = r3.indexOf(r6)
            if (r3 < 0) goto L_0x0118
            if (r7 != 0) goto L_0x0118
            r4.append(r13)
            goto L_0x01c3
        L_0x01a5:
            int r6 = r5 + 1
            boolean r6 = r0.isLastChar(r1, r6)
            if (r6 != 0) goto L_0x00f5
            boolean r6 = r0.isNextChar(r2, r5, r8)
            if (r6 == 0) goto L_0x00f5
            int r6 = r5 + 2
            char r7 = r2.charAt(r6)
            int r3 = r3.indexOf(r7)
            if (r3 < 0) goto L_0x00f5
            r4.append(r13)
            r5 = r6
        L_0x01c3:
            r3 = 1
            goto L_0x0232
        L_0x01c6:
            boolean r6 = r0.isPreviousChar(r2, r5, r11)
            if (r6 == 0) goto L_0x01df
            boolean r6 = r0.isLastChar(r1, r5)
            if (r6 != 0) goto L_0x01df
            int r6 = r5 + 1
            char r6 = r2.charAt(r6)
            int r6 = r3.indexOf(r6)
            if (r6 < 0) goto L_0x01df
            goto L_0x01c3
        L_0x01df:
            java.lang.String r6 = "CIA"
            boolean r6 = r0.regionMatch(r2, r5, r6)
            if (r6 == 0) goto L_0x01e9
            goto L_0x00fa
        L_0x01e9:
            boolean r6 = r0.isLastChar(r1, r5)
            if (r6 != 0) goto L_0x01fd
            int r6 = r5 + 1
            char r6 = r2.charAt(r6)
            int r3 = r3.indexOf(r6)
            if (r3 < 0) goto L_0x01fd
            goto L_0x00aa
        L_0x01fd:
            boolean r3 = r0.isPreviousChar(r2, r5, r11)
            if (r3 == 0) goto L_0x020b
            boolean r3 = r0.isNextChar(r2, r5, r10)
            if (r3 == 0) goto L_0x020b
            goto L_0x0118
        L_0x020b:
            boolean r3 = r0.isNextChar(r2, r5, r10)
            if (r3 == 0) goto L_0x0118
            if (r5 != 0) goto L_0x00fa
            r3 = 3
            if (r1 < r3) goto L_0x00fa
            r3 = 2
            boolean r3 = r0.isVowel(r2, r3)
            if (r3 == 0) goto L_0x00fa
            goto L_0x0118
        L_0x021f:
            r3 = 77
            boolean r3 = r0.isPreviousChar(r2, r5, r3)
            if (r3 == 0) goto L_0x00c1
            boolean r3 = r0.isLastChar(r1, r5)
            if (r3 == 0) goto L_0x00c1
            goto L_0x01c3
        L_0x022e:
            if (r5 != 0) goto L_0x01c3
            goto L_0x00c1
        L_0x0232:
            int r5 = r5 + r3
        L_0x0233:
            int r6 = r4.length()
            int r7 = r16.getMaxCodeLen()
            if (r6 <= r7) goto L_0x007f
            int r6 = r16.getMaxCodeLen()
            r4.setLength(r6)
            goto L_0x007f
        L_0x0246:
            java.lang.String r1 = r4.toString()
            return r1
        L_0x024b:
            java.lang.String r1 = ""
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.Metaphone.metaphone(java.lang.String):java.lang.String");
    }

    public void setMaxCodeLen(int i2) {
        this.maxCodeLen = i2;
    }

    public String encode(String str) {
        return metaphone(str);
    }
}
