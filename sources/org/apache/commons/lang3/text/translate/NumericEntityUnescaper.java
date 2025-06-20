package org.apache.commons.lang3.text.translate;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class NumericEntityUnescaper extends CharSequenceTranslator {
    private final EnumSet<OPTION> options;

    public enum OPTION {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon
    }

    public NumericEntityUnescaper(OPTION... optionArr) {
        List asList;
        if (optionArr.length > 0) {
            asList = Arrays.asList(optionArr);
        } else {
            asList = Arrays.asList(new OPTION[]{OPTION.semiColonRequired});
        }
        this.options = EnumSet.copyOf(asList);
    }

    public boolean isSet(OPTION option) {
        EnumSet<OPTION> enumSet = this.options;
        if (enumSet == null) {
            return false;
        }
        return enumSet.contains(option);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: char} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int translate(java.lang.CharSequence r8, int r9, java.io.Writer r10) throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r8.length()
            char r1 = r8.charAt(r9)
            r2 = 38
            r3 = 0
            if (r1 != r2) goto L_0x00ca
            int r1 = r0 + -2
            if (r9 >= r1) goto L_0x00ca
            int r1 = r9 + 1
            char r1 = r8.charAt(r1)
            r2 = 35
            if (r1 != r2) goto L_0x00ca
            int r1 = r9 + 2
            char r2 = r8.charAt(r1)
            r4 = 120(0x78, float:1.68E-43)
            r5 = 1
            if (r2 == r4) goto L_0x002d
            r4 = 88
            if (r2 != r4) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r9 = 0
            goto L_0x0033
        L_0x002d:
            int r1 = r9 + 3
            if (r1 != r0) goto L_0x0032
            return r3
        L_0x0032:
            r9 = 1
        L_0x0033:
            r2 = r1
        L_0x0034:
            if (r2 >= r0) goto L_0x0069
            char r4 = r8.charAt(r2)
            r6 = 48
            if (r4 < r6) goto L_0x0046
            char r4 = r8.charAt(r2)
            r6 = 57
            if (r4 <= r6) goto L_0x0066
        L_0x0046:
            char r4 = r8.charAt(r2)
            r6 = 97
            if (r4 < r6) goto L_0x0056
            char r4 = r8.charAt(r2)
            r6 = 102(0x66, float:1.43E-43)
            if (r4 <= r6) goto L_0x0066
        L_0x0056:
            char r4 = r8.charAt(r2)
            r6 = 65
            if (r4 < r6) goto L_0x0069
            char r4 = r8.charAt(r2)
            r6 = 70
            if (r4 > r6) goto L_0x0069
        L_0x0066:
            int r2 = r2 + 1
            goto L_0x0034
        L_0x0069:
            if (r2 == r0) goto L_0x0075
            char r0 = r8.charAt(r2)
            r4 = 59
            if (r0 != r4) goto L_0x0075
            r0 = 1
            goto L_0x0076
        L_0x0075:
            r0 = 0
        L_0x0076:
            if (r0 != 0) goto L_0x0092
            org.apache.commons.lang3.text.translate.NumericEntityUnescaper$OPTION r4 = org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired
            boolean r4 = r7.isSet(r4)
            if (r4 == 0) goto L_0x0081
            return r3
        L_0x0081:
            org.apache.commons.lang3.text.translate.NumericEntityUnescaper$OPTION r4 = org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.errorIfNoSemiColon
            boolean r4 = r7.isSet(r4)
            if (r4 != 0) goto L_0x008a
            goto L_0x0092
        L_0x008a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Semi-colon required at end of numeric entity"
            r8.<init>(r9)
            throw r8
        L_0x0092:
            if (r9 == 0) goto L_0x00a3
            java.lang.CharSequence r8 = r8.subSequence(r1, r2)     // Catch:{ NumberFormatException -> 0x00ca }
            java.lang.String r8 = r8.toString()     // Catch:{ NumberFormatException -> 0x00ca }
            r4 = 16
            int r8 = java.lang.Integer.parseInt(r8, r4)     // Catch:{ NumberFormatException -> 0x00ca }
            goto L_0x00b1
        L_0x00a3:
            java.lang.CharSequence r8 = r8.subSequence(r1, r2)     // Catch:{ NumberFormatException -> 0x00ca }
            java.lang.String r8 = r8.toString()     // Catch:{ NumberFormatException -> 0x00ca }
            r4 = 10
            int r8 = java.lang.Integer.parseInt(r8, r4)     // Catch:{ NumberFormatException -> 0x00ca }
        L_0x00b1:
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r8 <= r4) goto L_0x00c1
            char[] r8 = java.lang.Character.toChars(r8)
            char r3 = r8[r3]
            r10.write(r3)
            char r8 = r8[r5]
        L_0x00c1:
            r10.write(r8)
            int r2 = r2 + 2
            int r2 = r2 - r1
            int r2 = r2 + r9
            int r2 = r2 + r0
            return r2
        L_0x00ca:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.text.translate.NumericEntityUnescaper.translate(java.lang.CharSequence, int, java.io.Writer):int");
    }
}
