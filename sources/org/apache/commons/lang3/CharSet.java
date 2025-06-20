package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharSet implements Serializable {
    public static final CharSet ASCII_ALPHA;
    public static final CharSet ASCII_ALPHA_LOWER;
    public static final CharSet ASCII_ALPHA_UPPER;
    public static final CharSet ASCII_NUMERIC;
    protected static final Map<String, CharSet> COMMON;
    public static final CharSet EMPTY;
    private static final long serialVersionUID = 5947847346149275958L;
    private final Set<CharRange> set = Collections.synchronizedSet(new HashSet());

    static {
        CharSet charSet = new CharSet(null);
        EMPTY = charSet;
        CharSet charSet2 = new CharSet("a-zA-Z");
        ASCII_ALPHA = charSet2;
        CharSet charSet3 = new CharSet("a-z");
        ASCII_ALPHA_LOWER = charSet3;
        CharSet charSet4 = new CharSet("A-Z");
        ASCII_ALPHA_UPPER = charSet4;
        CharSet charSet5 = new CharSet("0-9");
        ASCII_NUMERIC = charSet5;
        Map<String, CharSet> synchronizedMap = Collections.synchronizedMap(new HashMap());
        COMMON = synchronizedMap;
        synchronizedMap.put((Object) null, charSet);
        synchronizedMap.put("", charSet);
        synchronizedMap.put("a-zA-Z", charSet2);
        synchronizedMap.put("A-Za-z", charSet2);
        synchronizedMap.put("a-z", charSet3);
        synchronizedMap.put("A-Z", charSet4);
        synchronizedMap.put("0-9", charSet5);
    }

    protected CharSet(String... strArr) {
        for (String add : strArr) {
            add(add);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = COMMON.get(r2[0]);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.commons.lang3.CharSet getInstance(java.lang.String... r2) {
        /*
            if (r2 != 0) goto L_0x0004
            r2 = 0
            return r2
        L_0x0004:
            int r0 = r2.length
            r1 = 1
            if (r0 != r1) goto L_0x0016
            java.util.Map<java.lang.String, org.apache.commons.lang3.CharSet> r0 = COMMON
            r1 = 0
            r1 = r2[r1]
            java.lang.Object r0 = r0.get(r1)
            org.apache.commons.lang3.CharSet r0 = (org.apache.commons.lang3.CharSet) r0
            if (r0 == 0) goto L_0x0016
            return r0
        L_0x0016:
            org.apache.commons.lang3.CharSet r0 = new org.apache.commons.lang3.CharSet
            r0.<init>(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.CharSet.getInstance(java.lang.String[]):org.apache.commons.lang3.CharSet");
    }

    /* access modifiers changed from: protected */
    public void add(String str) {
        if (str != null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = length - i2;
                if (i3 >= 4 && str.charAt(i2) == '^' && str.charAt(i2 + 2) == '-') {
                    this.set.add(CharRange.isNotIn(str.charAt(i2 + 1), str.charAt(i2 + 3)));
                    i2 += 4;
                } else if (i3 >= 3 && str.charAt(i2 + 1) == '-') {
                    this.set.add(CharRange.isIn(str.charAt(i2), str.charAt(i2 + 2)));
                    i2 += 3;
                } else if (i3 < 2 || str.charAt(i2) != '^') {
                    this.set.add(CharRange.is(str.charAt(i2)));
                    i2++;
                } else {
                    this.set.add(CharRange.isNot(str.charAt(i2 + 1)));
                    i2 += 2;
                }
            }
        }
    }

    public boolean contains(char c2) {
        for (CharRange contains : this.set) {
            if (contains.contains(c2)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharSet)) {
            return false;
        }
        return this.set.equals(((CharSet) obj).set);
    }

    /* access modifiers changed from: package-private */
    public CharRange[] getCharRanges() {
        Set<CharRange> set2 = this.set;
        return (CharRange[]) set2.toArray(new CharRange[set2.size()]);
    }

    public int hashCode() {
        return this.set.hashCode() + 89;
    }

    public String toString() {
        return this.set.toString();
    }
}
