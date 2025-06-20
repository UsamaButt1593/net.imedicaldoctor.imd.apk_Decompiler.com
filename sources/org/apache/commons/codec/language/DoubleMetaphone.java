package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.lang3.StringUtils;

public class DoubleMetaphone implements StringEncoder {
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", ExifInterface.X4, ExifInterface.T4, StringUtils.SPACE};
    private static final String[] L_T_K_S_N_M_B_Z = {"L", ExifInterface.d5, "K", ExifInterface.R4, "N", "M", "B", "Z"};
    private static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    private static final String VOWELS = "AEIOUY";
    private int maxCodeLen = 4;

    public class DoubleMetaphoneResult {
        private final StringBuilder alternate;
        private final int maxLength;
        private final StringBuilder primary;

        public DoubleMetaphoneResult(int i2) {
            this.primary = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
            this.alternate = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
            this.maxLength = i2;
        }

        public void append(char c2) {
            appendPrimary(c2);
            appendAlternate(c2);
        }

        public void appendAlternate(char c2) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(c2);
            }
        }

        public void appendPrimary(char c2) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(c2);
            }
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }

        public void append(char c2, char c3) {
            appendPrimary(c2);
            appendAlternate(c3);
        }

        public void appendAlternate(String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public void appendPrimary(String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public void append(String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(String str, String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }
    }

    private String cleanInput(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(Locale.ENGLISH);
    }

    private boolean conditionC0(String str, int i2) {
        if (contains(str, i2, 4, "CHIA")) {
            return true;
        }
        if (i2 <= 1) {
            return false;
        }
        int i3 = i2 - 2;
        if (isVowel(charAt(str, i3)) || !contains(str, i2 - 1, 3, "ACH")) {
            return false;
        }
        char charAt = charAt(str, i2 + 2);
        return !(charAt == 'I' || charAt == 'E') || contains(str, i3, 6, "BACHER", "MACHER");
    }

    private boolean conditionCH0(String str, int i2) {
        if (i2 != 0) {
            return false;
        }
        int i3 = i2 + 1;
        return (contains(str, i3, 5, "HARAC", "HARIS") || contains(str, i3, 3, "HOR", "HYM", "HIA", "HEM")) && !contains(str, 0, 5, "CHORE");
    }

    private boolean conditionCH1(String str, int i2) {
        if (!contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, 3, "SCH") && !contains(str, i2 - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i3 = i2 + 2;
            if (!contains(str, i3, 1, ExifInterface.d5, ExifInterface.R4)) {
                if (contains(str, i2 - 1, 1, ExifInterface.W4, "O", "U", ExifInterface.S4) || i2 == 0) {
                    return contains(str, i3, 1, L_R_N_M_B_H_F_V_W_SPACE) || i2 + 1 == str.length() - 1;
                }
                return false;
            }
        }
    }

    private boolean conditionL0(String str, int i2) {
        if (i2 != str.length() - 3 || !contains(str, i2 - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return (contains(str, str.length() - 2, 2, "AS", "OS") || contains(str, str.length() - 1, 1, ExifInterface.W4, "O")) && contains(str, i2 - 1, 4, "ALLE");
        }
        return true;
    }

    private boolean conditionM0(String str, int i2) {
        int i3 = i2 + 1;
        if (charAt(str, i3) == 'M') {
            return true;
        }
        return contains(str, i2 + -1, 3, "UMB") && (i3 == str.length() - 1 || contains(str, i2 + 2, 2, "ER"));
    }

    protected static boolean contains(String str, int i2, int i3, String... strArr) {
        int i4;
        if (i2 < 0 || (i4 = i3 + i2) > str.length()) {
            return false;
        }
        String substring = str.substring(i2, i4);
        for (String equals : strArr) {
            if (substring.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private int handleAEIOUY(DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (i2 == 0) {
            doubleMetaphoneResult.append('A');
        }
        return i2 + 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b7, code lost:
        if (contains(r12, r14, 3, "CIO", "CIE", "CIA") != false) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleC(java.lang.String r12, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r13, int r14) {
        /*
            r11 = this;
            boolean r0 = r11.conditionC0(r12, r14)
            r1 = 75
            r2 = 2
            if (r0 == 0) goto L_0x000f
        L_0x0009:
            r13.append((char) r1)
        L_0x000c:
            int r14 = r14 + r2
            goto L_0x00eb
        L_0x000f:
            r0 = 83
            if (r14 != 0) goto L_0x0024
            java.lang.String r3 = "CAESAR"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r4 = 6
            boolean r3 = contains(r12, r14, r4, r3)
            if (r3 == 0) goto L_0x0024
        L_0x0020:
            r13.append((char) r0)
            goto L_0x000c
        L_0x0024:
            java.lang.String r3 = "CH"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            boolean r3 = contains(r12, r14, r2, r3)
            if (r3 == 0) goto L_0x0036
            int r14 = r11.handleCH(r12, r13, r14)
            goto L_0x00eb
        L_0x0036:
            java.lang.String r3 = "CZ"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            boolean r3 = contains(r12, r14, r2, r3)
            r4 = 88
            if (r3 == 0) goto L_0x0057
            int r3 = r14 + -2
            java.lang.String r5 = "WICZ"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r6 = 4
            boolean r3 = contains(r12, r3, r6, r5)
            if (r3 != 0) goto L_0x0057
        L_0x0053:
            r13.append((char) r0, (char) r4)
            goto L_0x000c
        L_0x0057:
            int r3 = r14 + 1
            java.lang.String r5 = "CIA"
            java.lang.String[] r6 = new java.lang.String[]{r5}
            r7 = 3
            boolean r6 = contains(r12, r3, r7, r6)
            if (r6 == 0) goto L_0x006c
            r13.append((char) r4)
        L_0x0069:
            int r14 = r14 + r7
            goto L_0x00eb
        L_0x006c:
            java.lang.String r6 = "CC"
            java.lang.String[] r6 = new java.lang.String[]{r6}
            boolean r6 = contains(r12, r14, r2, r6)
            r8 = 1
            if (r6 == 0) goto L_0x0089
            if (r14 != r8) goto L_0x0084
            r6 = 0
            char r6 = r11.charAt(r12, r6)
            r9 = 77
            if (r6 == r9) goto L_0x0089
        L_0x0084:
            int r12 = r11.handleCC(r12, r13, r14)
            return r12
        L_0x0089:
            java.lang.String r6 = "CG"
            java.lang.String r9 = "CQ"
            java.lang.String r10 = "CK"
            java.lang.String[] r6 = new java.lang.String[]{r10, r6, r9}
            boolean r6 = contains(r12, r14, r2, r6)
            if (r6 == 0) goto L_0x009b
            goto L_0x0009
        L_0x009b:
            java.lang.String r6 = "CY"
            java.lang.String r9 = "CI"
            java.lang.String r10 = "CE"
            java.lang.String[] r6 = new java.lang.String[]{r9, r10, r6}
            boolean r6 = contains(r12, r14, r2, r6)
            if (r6 == 0) goto L_0x00ba
            java.lang.String r1 = "CIO"
            java.lang.String r3 = "CIE"
            java.lang.String[] r1 = new java.lang.String[]{r1, r3, r5}
            boolean r12 = contains(r12, r14, r7, r1)
            if (r12 == 0) goto L_0x0020
            goto L_0x0053
        L_0x00ba:
            r13.append((char) r1)
            java.lang.String r13 = " Q"
            java.lang.String r0 = " G"
            java.lang.String r1 = " C"
            java.lang.String[] r13 = new java.lang.String[]{r1, r13, r0}
            boolean r13 = contains(r12, r3, r2, r13)
            if (r13 == 0) goto L_0x00ce
            goto L_0x0069
        L_0x00ce:
            java.lang.String r13 = "K"
            java.lang.String r0 = "Q"
            java.lang.String r1 = "C"
            java.lang.String[] r13 = new java.lang.String[]{r1, r13, r0}
            boolean r13 = contains(r12, r3, r8, r13)
            if (r13 == 0) goto L_0x00ea
            java.lang.String[] r13 = new java.lang.String[]{r10, r9}
            boolean r12 = contains(r12, r3, r2, r13)
            if (r12 != 0) goto L_0x00ea
            goto L_0x000c
        L_0x00ea:
            r14 = r3
        L_0x00eb:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleC(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleCC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        int i3 = i2 + 2;
        if (!contains(str, i3, 1, "I", ExifInterface.S4, "H") || contains(str, i3, 2, "HU")) {
            doubleMetaphoneResult.append('K');
            return i3;
        }
        if (!(i2 == 1 && charAt(str, i2 - 1) == 'A') && !contains(str, i2 - 1, 5, "UCCEE", "UCCES")) {
            doubleMetaphoneResult.append('X');
        } else {
            doubleMetaphoneResult.append("KS");
        }
        return i2 + 3;
    }

    private int handleCH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (i2 > 0 && contains(str, i2, 4, "CHAE")) {
            doubleMetaphoneResult.append('K', 'X');
        } else if (!conditionCH0(str, i2) && !conditionCH1(str, i2)) {
            if (i2 <= 0) {
                doubleMetaphoneResult.append('X');
            } else if (contains(str, 0, 2, "MC")) {
                doubleMetaphoneResult.append('K');
            } else {
                doubleMetaphoneResult.append('X', 'K');
            }
            return i2 + 2;
        } else {
            doubleMetaphoneResult.append('K');
        }
        return i2 + 2;
    }

    private int handleD(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (contains(str, i2, 2, "DG")) {
            int i3 = i2 + 2;
            if (contains(str, i3, 1, "I", ExifInterface.S4, "Y")) {
                doubleMetaphoneResult.append('J');
                return i2 + 3;
            }
            doubleMetaphoneResult.append("TK");
            return i3;
        }
        boolean contains = contains(str, i2, 2, "DT", "DD");
        doubleMetaphoneResult.append((char) ASCIIPropertyListParser.C);
        return contains ? i2 + 2 : i2 + 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c2, code lost:
        if (contains(r12, r2, 3, "RGY", "OGY") == false) goto L_0x007e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleG(java.lang.String r12, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r13, int r14, boolean r15) {
        /*
            r11 = this;
            int r0 = r14 + 1
            char r1 = r11.charAt(r12, r0)
            r2 = 72
            if (r1 != r2) goto L_0x0010
            int r0 = r11.handleGH(r12, r13, r14)
            goto L_0x0133
        L_0x0010:
            char r1 = r11.charAt(r12, r0)
            r2 = 78
            r3 = 89
            r4 = 0
            r5 = 2
            r6 = 1
            if (r1 != r2) goto L_0x0054
            java.lang.String r1 = "N"
            java.lang.String r2 = "KN"
            if (r14 != r6) goto L_0x0033
            char r4 = r11.charAt(r12, r4)
            boolean r4 = r11.isVowel(r4)
            if (r4 == 0) goto L_0x0033
            if (r15 != 0) goto L_0x0033
            r13.append((java.lang.String) r2, (java.lang.String) r1)
            goto L_0x0050
        L_0x0033:
            int r4 = r14 + 2
            java.lang.String r6 = "EY"
            java.lang.String[] r6 = new java.lang.String[]{r6}
            boolean r4 = contains(r12, r4, r5, r6)
            if (r4 != 0) goto L_0x004d
            char r12 = r11.charAt(r12, r0)
            if (r12 == r3) goto L_0x004d
            if (r15 != 0) goto L_0x004d
            r13.append((java.lang.String) r1, (java.lang.String) r2)
            goto L_0x0050
        L_0x004d:
            r13.append((java.lang.String) r2)
        L_0x0050:
            int r0 = r14 + 2
            goto L_0x0133
        L_0x0054:
            java.lang.String r1 = "LI"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            boolean r1 = contains(r12, r0, r5, r1)
            if (r1 == 0) goto L_0x006a
            if (r15 != 0) goto L_0x006a
            java.lang.String r12 = "KL"
            java.lang.String r15 = "L"
            r13.append((java.lang.String) r12, (java.lang.String) r15)
            goto L_0x0050
        L_0x006a:
            r15 = 74
            r1 = 75
            if (r14 != 0) goto L_0x0082
            char r2 = r11.charAt(r12, r0)
            if (r2 == r3) goto L_0x007e
            java.lang.String[] r2 = ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER
            boolean r2 = contains(r12, r0, r5, r2)
            if (r2 == 0) goto L_0x0082
        L_0x007e:
            r13.append((char) r1, (char) r15)
            goto L_0x0050
        L_0x0082:
            java.lang.String r2 = "ER"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            boolean r2 = contains(r12, r0, r5, r2)
            java.lang.String r7 = "I"
            java.lang.String r8 = "E"
            r9 = 3
            if (r2 != 0) goto L_0x0099
            char r2 = r11.charAt(r12, r0)
            if (r2 != r3) goto L_0x00c5
        L_0x0099:
            java.lang.String r2 = "RANGER"
            java.lang.String r3 = "MANGER"
            java.lang.String r10 = "DANGER"
            java.lang.String[] r2 = new java.lang.String[]{r10, r2, r3}
            r3 = 6
            boolean r2 = contains(r12, r4, r3, r2)
            if (r2 != 0) goto L_0x00c5
            int r2 = r14 + -1
            java.lang.String[] r3 = new java.lang.String[]{r8, r7}
            boolean r3 = contains(r12, r2, r6, r3)
            if (r3 != 0) goto L_0x00c5
            java.lang.String r3 = "RGY"
            java.lang.String r10 = "OGY"
            java.lang.String[] r3 = new java.lang.String[]{r3, r10}
            boolean r2 = contains(r12, r2, r9, r3)
            if (r2 != 0) goto L_0x00c5
            goto L_0x007e
        L_0x00c5:
            java.lang.String r2 = "Y"
            java.lang.String[] r2 = new java.lang.String[]{r8, r7, r2}
            boolean r2 = contains(r12, r0, r6, r2)
            r3 = 4
            if (r2 != 0) goto L_0x00f1
            int r2 = r14 + -1
            java.lang.String r6 = "AGGI"
            java.lang.String r7 = "OGGI"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7}
            boolean r2 = contains(r12, r2, r3, r6)
            if (r2 == 0) goto L_0x00e3
            goto L_0x00f1
        L_0x00e3:
            char r12 = r11.charAt(r12, r0)
            r15 = 71
            if (r12 != r15) goto L_0x00ed
            int r0 = r14 + 2
        L_0x00ed:
            r13.append((char) r1)
            goto L_0x0133
        L_0x00f1:
            java.lang.String r2 = "VAN "
            java.lang.String r6 = "VON "
            java.lang.String[] r2 = new java.lang.String[]{r2, r6}
            boolean r2 = contains(r12, r4, r3, r2)
            if (r2 != 0) goto L_0x012e
            java.lang.String r2 = "SCH"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            boolean r2 = contains(r12, r4, r9, r2)
            if (r2 != 0) goto L_0x012e
            java.lang.String r2 = "ET"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            boolean r2 = contains(r12, r0, r5, r2)
            if (r2 == 0) goto L_0x0118
            goto L_0x012e
        L_0x0118:
            java.lang.String r2 = "IER"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            boolean r12 = contains(r12, r0, r9, r2)
            if (r12 == 0) goto L_0x0129
            r13.append((char) r15)
            goto L_0x0050
        L_0x0129:
            r13.append((char) r15, (char) r1)
            goto L_0x0050
        L_0x012e:
            r13.append((char) r1)
            goto L_0x0050
        L_0x0133:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleG(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0090, code lost:
        if (charAt(r11, r13 - 1) != 'I') goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleGH(java.lang.String r11, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r12, int r13) {
        /*
            r10 = this;
            r0 = 75
            r1 = 2
            if (r13 <= 0) goto L_0x0017
            int r2 = r13 + -1
            char r2 = r10.charAt(r11, r2)
            boolean r2 = r10.isVowel(r2)
            if (r2 != 0) goto L_0x0017
        L_0x0011:
            r12.append((char) r0)
        L_0x0014:
            int r13 = r13 + r1
            goto L_0x0094
        L_0x0017:
            r2 = 73
            if (r13 != 0) goto L_0x002d
            int r13 = r13 + r1
            char r11 = r10.charAt(r11, r13)
            if (r11 != r2) goto L_0x0029
            r11 = 74
            r12.append((char) r11)
            goto L_0x0094
        L_0x0029:
            r12.append((char) r0)
            goto L_0x0094
        L_0x002d:
            java.lang.String r3 = "D"
            java.lang.String r4 = "H"
            java.lang.String r5 = "B"
            r6 = 1
            if (r13 <= r6) goto L_0x0042
            int r7 = r13 + -2
            java.lang.String[] r8 = new java.lang.String[]{r5, r4, r3}
            boolean r7 = contains(r11, r7, r6, r8)
            if (r7 != 0) goto L_0x0014
        L_0x0042:
            if (r13 <= r1) goto L_0x0050
            int r7 = r13 + -3
            java.lang.String[] r3 = new java.lang.String[]{r5, r4, r3}
            boolean r3 = contains(r11, r7, r6, r3)
            if (r3 != 0) goto L_0x0014
        L_0x0050:
            r3 = 3
            if (r13 <= r3) goto L_0x0060
            int r3 = r13 + -4
            java.lang.String[] r4 = new java.lang.String[]{r5, r4}
            boolean r3 = contains(r11, r3, r6, r4)
            if (r3 == 0) goto L_0x0060
            goto L_0x0014
        L_0x0060:
            if (r13 <= r1) goto L_0x0088
            int r3 = r13 + -1
            char r3 = r10.charAt(r11, r3)
            r4 = 85
            if (r3 != r4) goto L_0x0088
            int r3 = r13 + -3
            java.lang.String r4 = "R"
            java.lang.String r5 = "T"
            java.lang.String r7 = "C"
            java.lang.String r8 = "G"
            java.lang.String r9 = "L"
            java.lang.String[] r4 = new java.lang.String[]{r7, r8, r9, r4, r5}
            boolean r3 = contains(r11, r3, r6, r4)
            if (r3 == 0) goto L_0x0088
            r11 = 70
            r12.append((char) r11)
            goto L_0x0014
        L_0x0088:
            if (r13 <= 0) goto L_0x0014
            int r3 = r13 + -1
            char r11 = r10.charAt(r11, r3)
            if (r11 == r2) goto L_0x0014
            goto L_0x0011
        L_0x0094:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleGH(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if ((i2 != 0 && !isVowel(charAt(str, i2 - 1))) || !isVowel(charAt(str, i2 + 1))) {
            return i2 + 1;
        }
        doubleMetaphoneResult.append('H');
        return i2 + 2;
    }

    private int handleJ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2, boolean z) {
        if (contains(str, i2, 4, "JOSE") || contains(str, 0, 4, "SAN ")) {
            if ((i2 == 0 && charAt(str, i2 + 4) == ' ') || str.length() == 4 || contains(str, 0, 4, "SAN ")) {
                doubleMetaphoneResult.append('H');
            } else {
                doubleMetaphoneResult.append('J', 'H');
            }
            return i2 + 1;
        }
        if (i2 != 0 || contains(str, i2, 4, "JOSE")) {
            int i3 = i2 - 1;
            if (isVowel(charAt(str, i3)) && !z) {
                int i4 = i2 + 1;
                if (charAt(str, i4) == 'A' || charAt(str, i4) == 'O') {
                    doubleMetaphoneResult.append('J', 'H');
                }
            }
            if (i2 == str.length() - 1) {
                doubleMetaphoneResult.append('J', ' ');
            } else if (!contains(str, i2 + 1, 1, L_T_K_S_N_M_B_Z) && !contains(str, i3, 1, ExifInterface.R4, "K", "L")) {
                doubleMetaphoneResult.append('J');
            }
        } else {
            doubleMetaphoneResult.append('J', 'A');
        }
        int i5 = i2 + 1;
        return charAt(str, i5) == 'J' ? i2 + 2 : i5;
    }

    private int handleL(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        int i3 = i2 + 1;
        if (charAt(str, i3) == 'L') {
            if (conditionL0(str, i2)) {
                doubleMetaphoneResult.appendPrimary('L');
            } else {
                doubleMetaphoneResult.append('L');
            }
            return i2 + 2;
        }
        doubleMetaphoneResult.append('L');
        return i3;
    }

    private int handleP(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        int i3 = i2 + 1;
        if (charAt(str, i3) == 'H') {
            doubleMetaphoneResult.append('F');
            return i2 + 2;
        }
        doubleMetaphoneResult.append('P');
        if (contains(str, i3, 1, "P", "B")) {
            i3 = i2 + 2;
        }
        return i3;
    }

    private int handleR(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2, boolean z) {
        if (i2 != str.length() - 1 || z || !contains(str, i2 - 2, 2, "IE") || contains(str, i2 - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.append((char) ASCIIPropertyListParser.y);
        } else {
            doubleMetaphoneResult.appendAlternate((char) ASCIIPropertyListParser.y);
        }
        int i3 = i2 + 1;
        return charAt(str, i3) == 'R' ? i2 + 2 : i3;
    }

    private int handleS(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2, boolean z) {
        if (!contains(str, i2 - 1, 3, "ISL", "YSL")) {
            if (i2 != 0 || !contains(str, i2, 5, "SUGAR")) {
                if (contains(str, i2, 2, "SH")) {
                    if (contains(str, i2 + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
                        doubleMetaphoneResult.append('S');
                    } else {
                        doubleMetaphoneResult.append('X');
                    }
                } else if (contains(str, i2, 3, "SIO", "SIA") || contains(str, i2, 4, "SIAN")) {
                    if (z) {
                        doubleMetaphoneResult.append('S');
                    } else {
                        doubleMetaphoneResult.append('S', 'X');
                    }
                    return i2 + 3;
                } else {
                    if (i2 != 0 || !contains(str, i2 + 1, 1, "M", "N", "L", ExifInterface.T4)) {
                        int i3 = i2 + 1;
                        if (!contains(str, i3, 1, "Z")) {
                            if (contains(str, i2, 2, "SC")) {
                                return handleSC(str, doubleMetaphoneResult, i2);
                            }
                            if (i2 != str.length() - 1 || !contains(str, i2 - 2, 2, "AI", "OI")) {
                                doubleMetaphoneResult.append('S');
                            } else {
                                doubleMetaphoneResult.appendAlternate('S');
                            }
                            if (!contains(str, i3, 1, ExifInterface.R4, "Z")) {
                                return i3;
                            }
                        }
                    }
                    doubleMetaphoneResult.append('S', 'X');
                    int i4 = i2 + 1;
                    if (!contains(str, i4, 1, "Z")) {
                        return i4;
                    }
                }
                return i2 + 2;
            }
            doubleMetaphoneResult.append('X', 'S');
        }
        return i2 + 1;
    }

    private int handleSC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        int i3 = i2 + 2;
        if (charAt(str, i3) == 'H') {
            int i4 = i2 + 3;
            if (contains(str, i4, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(str, i4, 2, "ER", "EN")) {
                    doubleMetaphoneResult.append("X", "SK");
                }
            } else if (i2 != 0 || isVowel(charAt(str, 3)) || charAt(str, 3) == 'W') {
                doubleMetaphoneResult.append('X');
            } else {
                doubleMetaphoneResult.append('X', 'S');
            }
            return i2 + 3;
        } else if (contains(str, i3, 1, "I", ExifInterface.S4, "Y")) {
            doubleMetaphoneResult.append('S');
            return i2 + 3;
        }
        doubleMetaphoneResult.append("SK");
        return i2 + 3;
    }

    private int handleT(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (contains(str, i2, 4, "TION") || contains(str, i2, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.append('X');
            return i2 + 3;
        } else if (contains(str, i2, 2, "TH") || contains(str, i2, 3, "TTH")) {
            int i3 = i2 + 2;
            if (contains(str, i3, 2, "OM", "AM") || contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, 3, "SCH")) {
                doubleMetaphoneResult.append((char) ASCIIPropertyListParser.C);
                return i3;
            }
            doubleMetaphoneResult.append('0', (char) ASCIIPropertyListParser.C);
            return i3;
        } else {
            doubleMetaphoneResult.append((char) ASCIIPropertyListParser.C);
            int i4 = i2 + 1;
            return contains(str, i4, 1, ExifInterface.d5, "D") ? i2 + 2 : i4;
        }
    }

    private int handleW(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        int i3 = 2;
        if (contains(str, i2, 2, "WR")) {
            doubleMetaphoneResult.append((char) ASCIIPropertyListParser.y);
        } else {
            if (i2 == 0) {
                int i4 = i2 + 1;
                if (isVowel(charAt(str, i4)) || contains(str, i2, 2, "WH")) {
                    if (isVowel(charAt(str, i4))) {
                        doubleMetaphoneResult.append('A', 'F');
                    } else {
                        doubleMetaphoneResult.append('A');
                    }
                    return i4;
                }
            }
            if ((i2 != str.length() - 1 || !isVowel(charAt(str, i2 - 1))) && !contains(str, i2 - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") && !contains(str, 0, 3, "SCH")) {
                i3 = 4;
                if (contains(str, i2, 4, "WICZ", "WITZ")) {
                    doubleMetaphoneResult.append("TS", "FX");
                }
            } else {
                doubleMetaphoneResult.appendAlternate('F');
            }
            return i2 + 1;
        }
        return i2 + i3;
    }

    private int handleX(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (i2 == 0) {
            doubleMetaphoneResult.append('S');
            return i2 + 1;
        }
        if (i2 != str.length() - 1 || (!contains(str, i2 - 3, 3, "IAU", "EAU") && !contains(str, i2 - 2, 2, "AU", "OU"))) {
            doubleMetaphoneResult.append("KS");
        }
        int i3 = i2 + 1;
        return contains(str, i3, 1, "C", "X") ? i2 + 2 : i3;
    }

    private int handleZ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2, boolean z) {
        int i3 = i2 + 1;
        if (charAt(str, i3) == 'H') {
            doubleMetaphoneResult.append('J');
            return i2 + 2;
        }
        if (contains(str, i3, 2, "ZO", "ZI", "ZA") || (z && i2 > 0 && charAt(str, i2 - 1) != 'T')) {
            doubleMetaphoneResult.append(ExifInterface.R4, "TS");
        } else {
            doubleMetaphoneResult.append('S');
        }
        if (charAt(str, i3) == 'Z') {
            i3 = i2 + 2;
        }
        return i3;
    }

    private boolean isSilentStart(String str) {
        for (String startsWith : SILENT_START) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSlavoGermanic(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean isVowel(char c2) {
        return VOWELS.indexOf(c2) != -1;
    }

    /* access modifiers changed from: protected */
    public char charAt(String str, int i2) {
        if (i2 < 0 || i2 >= str.length()) {
            return 0;
        }
        return str.charAt(i2);
    }

    public String doubleMetaphone(String str) {
        return doubleMetaphone(str, false);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return doubleMetaphone((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public void setMaxCodeLen(int i2) {
        this.maxCodeLen = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (charAt(r8, r3) == 'V') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        r1 = r1 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (charAt(r8, r3) == 'Q') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        if (charAt(r8, r3) == 'N') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
        if (conditionM0(r8, r1) != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        if (charAt(r8, r3) == 'K') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c7, code lost:
        if (charAt(r8, r3) == 'F') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e3, code lost:
        if (charAt(r8, r3) == 'B') goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doubleMetaphone(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r8 = r7.cleanInput(r8)
            if (r8 != 0) goto L_0x0008
            r8 = 0
            return r8
        L_0x0008:
            boolean r0 = r7.isSlavoGermanic(r8)
            boolean r1 = r7.isSilentStart(r8)
            org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult r2 = new org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult
            int r3 = r7.getMaxCodeLen()
            r2.<init>(r3)
        L_0x0019:
            boolean r3 = r2.isComplete()
            if (r3 != 0) goto L_0x00f9
            int r3 = r8.length()
            int r3 = r3 + -1
            if (r1 > r3) goto L_0x00f9
            char r3 = r8.charAt(r1)
            r4 = 199(0xc7, float:2.79E-43)
            if (r3 == r4) goto L_0x00f2
            r4 = 209(0xd1, float:2.93E-43)
            r5 = 78
            if (r3 == r4) goto L_0x00ed
            r4 = 75
            r6 = 70
            switch(r3) {
                case 65: goto L_0x00e7;
                case 66: goto L_0x00d6;
                case 67: goto L_0x00d0;
                case 68: goto L_0x00ca;
                case 69: goto L_0x00e7;
                case 70: goto L_0x00be;
                case 71: goto L_0x00b8;
                case 72: goto L_0x00b2;
                case 73: goto L_0x00e7;
                case 74: goto L_0x00ac;
                case 75: goto L_0x00a0;
                case 76: goto L_0x009a;
                case 77: goto L_0x008e;
                case 78: goto L_0x0082;
                case 79: goto L_0x00e7;
                case 80: goto L_0x007d;
                case 81: goto L_0x006f;
                case 82: goto L_0x006a;
                case 83: goto L_0x0065;
                case 84: goto L_0x0060;
                case 85: goto L_0x00e7;
                case 86: goto L_0x004e;
                case 87: goto L_0x0049;
                case 88: goto L_0x0044;
                case 89: goto L_0x00e7;
                case 90: goto L_0x003f;
                default: goto L_0x003c;
            }
        L_0x003c:
            int r1 = r1 + 1
            goto L_0x0019
        L_0x003f:
            int r1 = r7.handleZ(r8, r2, r1, r0)
            goto L_0x0019
        L_0x0044:
            int r1 = r7.handleX(r8, r2, r1)
            goto L_0x0019
        L_0x0049:
            int r1 = r7.handleW(r8, r2, r1)
            goto L_0x0019
        L_0x004e:
            r2.append((char) r6)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            r5 = 86
            if (r4 != r5) goto L_0x005e
        L_0x005b:
            int r1 = r1 + 2
            goto L_0x0019
        L_0x005e:
            r1 = r3
            goto L_0x0019
        L_0x0060:
            int r1 = r7.handleT(r8, r2, r1)
            goto L_0x0019
        L_0x0065:
            int r1 = r7.handleS(r8, r2, r1, r0)
            goto L_0x0019
        L_0x006a:
            int r1 = r7.handleR(r8, r2, r1, r0)
            goto L_0x0019
        L_0x006f:
            r2.append((char) r4)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            r5 = 81
            if (r4 != r5) goto L_0x005e
            goto L_0x005b
        L_0x007d:
            int r1 = r7.handleP(r8, r2, r1)
            goto L_0x0019
        L_0x0082:
            r2.append((char) r5)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            if (r4 != r5) goto L_0x005e
            goto L_0x005b
        L_0x008e:
            r3 = 77
            r2.append((char) r3)
            boolean r3 = r7.conditionM0(r8, r1)
            if (r3 == 0) goto L_0x003c
            goto L_0x005b
        L_0x009a:
            int r1 = r7.handleL(r8, r2, r1)
            goto L_0x0019
        L_0x00a0:
            r2.append((char) r4)
            int r3 = r1 + 1
            char r5 = r7.charAt(r8, r3)
            if (r5 != r4) goto L_0x005e
            goto L_0x005b
        L_0x00ac:
            int r1 = r7.handleJ(r8, r2, r1, r0)
            goto L_0x0019
        L_0x00b2:
            int r1 = r7.handleH(r8, r2, r1)
            goto L_0x0019
        L_0x00b8:
            int r1 = r7.handleG(r8, r2, r1, r0)
            goto L_0x0019
        L_0x00be:
            r2.append((char) r6)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            if (r4 != r6) goto L_0x005e
            goto L_0x005b
        L_0x00ca:
            int r1 = r7.handleD(r8, r2, r1)
            goto L_0x0019
        L_0x00d0:
            int r1 = r7.handleC(r8, r2, r1)
            goto L_0x0019
        L_0x00d6:
            r3 = 80
            r2.append((char) r3)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            r5 = 66
            if (r4 != r5) goto L_0x005e
            goto L_0x005b
        L_0x00e7:
            int r1 = r7.handleAEIOUY(r2, r1)
            goto L_0x0019
        L_0x00ed:
            r2.append((char) r5)
            goto L_0x003c
        L_0x00f2:
            r3 = 83
            r2.append((char) r3)
            goto L_0x003c
        L_0x00f9:
            if (r9 == 0) goto L_0x0100
            java.lang.String r8 = r2.getAlternate()
            goto L_0x0104
        L_0x0100:
            java.lang.String r8 = r2.getPrimary()
        L_0x0104:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.doubleMetaphone(java.lang.String, boolean):java.lang.String");
    }

    public String encode(String str) {
        return doubleMetaphone(str);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z) {
        return org.apache.commons.codec.binary.StringUtils.equals(doubleMetaphone(str, z), doubleMetaphone(str2, z));
    }
}
