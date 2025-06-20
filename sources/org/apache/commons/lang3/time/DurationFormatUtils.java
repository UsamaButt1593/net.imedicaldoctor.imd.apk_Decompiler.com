package org.apache.commons.lang3.time;

import androidx.exifinterface.media.ExifInterface;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

public class DurationFormatUtils {
    static final Object H = "H";
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";
    static final Object M = "M";
    static final Object S = ExifInterface.R4;

    /* renamed from: d  reason: collision with root package name */
    static final Object f31461d = "d";

    /* renamed from: m  reason: collision with root package name */
    static final Object f31462m = "m";
    static final Object s = "s";
    static final Object y = "y";

    static class Token {
        private int count;
        private final Object value;

        Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token value2 : tokenArr) {
                if (value2.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(token.value.toString());
            }
            boolean z = obj2 instanceof Number;
            Object obj3 = token.value;
            return z ? obj2.equals(obj3) : obj2 == obj3;
        }

        /* access modifiers changed from: package-private */
        public int getCount() {
            return this.count;
        }

        /* access modifiers changed from: package-private */
        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* access modifiers changed from: package-private */
        public void increment() {
            this.count++;
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }

        Token(Object obj, int i2) {
            this.value = obj;
            this.count = i2;
        }
    }

    static String format(Token[] tokenArr, long j2, long j3, long j4, long j5, long j6, long j7, long j8, boolean z) {
        int i2;
        int i3;
        long j9;
        long j10;
        String paddedValue;
        Token[] tokenArr2 = tokenArr;
        long j11 = j8;
        boolean z2 = z;
        StringBuilder sb = new StringBuilder();
        int length = tokenArr2.length;
        int i4 = 0;
        boolean z3 = false;
        while (i4 < length) {
            Token token = tokenArr2[i4];
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuilder) {
                sb.append(value.toString());
                long j12 = j2;
                long j13 = j3;
                j9 = j11;
                i3 = length;
                i2 = i4;
            } else {
                if (value == y) {
                    sb.append(paddedValue(j2, z2, count));
                    long j14 = j3;
                } else {
                    long j15 = j2;
                    if (value == M) {
                        sb.append(paddedValue(j3, z2, count));
                    } else {
                        long j16 = j3;
                        i2 = i4;
                        long j17 = j4;
                        if (value == f31461d) {
                            sb.append(paddedValue(j17, z2, count));
                            j9 = j11;
                            i3 = length;
                            z3 = false;
                        } else {
                            if (value == H) {
                                i3 = length;
                                sb.append(paddedValue(j5, z2, count));
                                long j18 = j6;
                            } else {
                                i3 = length;
                                long j19 = j5;
                                long j20 = j6;
                                if (value == f31462m) {
                                    sb.append(paddedValue(j20, z2, count));
                                } else {
                                    long j21 = j7;
                                    if (value == s) {
                                        sb.append(paddedValue(j21, z2, count));
                                        j9 = j8;
                                        z3 = true;
                                    } else if (value == S) {
                                        if (z3) {
                                            int i5 = 3;
                                            if (z2) {
                                                i5 = Math.max(3, count);
                                            }
                                            j10 = j8;
                                            paddedValue = paddedValue(j10, true, i5);
                                        } else {
                                            j10 = j8;
                                            paddedValue = paddedValue(j10, z2, count);
                                        }
                                        sb.append(paddedValue);
                                        z3 = false;
                                    } else {
                                        j9 = j8;
                                    }
                                    i4 = i2 + 1;
                                    j11 = j9;
                                    length = i3;
                                    tokenArr2 = tokenArr;
                                }
                            }
                            j10 = j11;
                            z3 = false;
                            i4 = i2 + 1;
                            j11 = j9;
                            length = i3;
                            tokenArr2 = tokenArr;
                        }
                    }
                }
                j9 = j11;
                i3 = length;
                i2 = i4;
                z3 = false;
            }
            long j22 = j6;
            i4 = i2 + 1;
            j11 = j9;
            length = i3;
            tokenArr2 = tokenArr;
        }
        return sb.toString();
    }

    public static String formatDuration(long j2, String str) {
        return formatDuration(j2, str, true);
    }

    public static String formatDurationHMS(long j2) {
        return formatDuration(j2, "H:mm:ss.SSS");
    }

    public static String formatDurationISO(long j2) {
        return formatDuration(j2, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDurationWords(long j2, boolean z, boolean z2) {
        String formatDuration = formatDuration(j2, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            formatDuration = StringUtils.SPACE + formatDuration;
            String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 days", "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, " 0 hours", "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (formatDuration.length() != 0) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z2) {
            String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce4, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.SPACE + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long j2, long j3, String str) {
        return formatPeriod(j2, j3, str, true, TimeZone.getDefault());
    }

    public static String formatPeriodISO(long j2, long j3) {
        return formatPeriod(j2, j3, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0097 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static org.apache.commons.lang3.time.DurationFormatUtils.Token[] lexx(java.lang.String r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.length()
            r0.<init>(r1)
            r1 = 0
            r2 = 0
            r5 = r2
            r6 = r5
            r3 = 0
            r4 = 0
        L_0x000f:
            int r7 = r9.length()
            if (r3 >= r7) goto L_0x009b
            char r7 = r9.charAt(r3)
            r8 = 39
            if (r4 == 0) goto L_0x0024
            if (r7 == r8) goto L_0x0024
            r5.append(r7)
            goto L_0x0097
        L_0x0024:
            if (r7 == r8) goto L_0x006b
            r8 = 72
            if (r7 == r8) goto L_0x0068
            r8 = 77
            if (r7 == r8) goto L_0x0065
            r8 = 83
            if (r7 == r8) goto L_0x0062
            r8 = 100
            if (r7 == r8) goto L_0x005f
            r8 = 109(0x6d, float:1.53E-43)
            if (r7 == r8) goto L_0x005c
            r8 = 115(0x73, float:1.61E-43)
            if (r7 == r8) goto L_0x0059
            r8 = 121(0x79, float:1.7E-43)
            if (r7 == r8) goto L_0x0056
            if (r5 != 0) goto L_0x0051
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r8 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r8.<init>(r5)
            r0.add(r8)
        L_0x0051:
            r5.append(r7)
        L_0x0054:
            r7 = r2
            goto L_0x0080
        L_0x0056:
            java.lang.Object r7 = y
            goto L_0x0080
        L_0x0059:
            java.lang.Object r7 = s
            goto L_0x0080
        L_0x005c:
            java.lang.Object r7 = f31462m
            goto L_0x0080
        L_0x005f:
            java.lang.Object r7 = f31461d
            goto L_0x0080
        L_0x0062:
            java.lang.Object r7 = S
            goto L_0x0080
        L_0x0065:
            java.lang.Object r7 = M
            goto L_0x0080
        L_0x0068:
            java.lang.Object r7 = H
            goto L_0x0080
        L_0x006b:
            if (r4 == 0) goto L_0x0071
            r5 = r2
            r7 = r5
            r4 = 0
            goto L_0x0080
        L_0x0071:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r4 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r4.<init>(r5)
            r0.add(r4)
            r4 = 1
            goto L_0x0054
        L_0x0080:
            if (r7 == 0) goto L_0x0097
            if (r6 == 0) goto L_0x008e
            java.lang.Object r5 = r6.getValue()
            if (r5 != r7) goto L_0x008e
            r6.increment()
            goto L_0x0096
        L_0x008e:
            org.apache.commons.lang3.time.DurationFormatUtils$Token r6 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r6.<init>(r7)
            r0.add(r6)
        L_0x0096:
            r5 = r2
        L_0x0097:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x009b:
            if (r4 != 0) goto L_0x00aa
            int r9 = r0.size()
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r9 = new org.apache.commons.lang3.time.DurationFormatUtils.Token[r9]
            java.lang.Object[] r9 = r0.toArray(r9)
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r9 = (org.apache.commons.lang3.time.DurationFormatUtils.Token[]) r9
            return r9
        L_0x00aa:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unmatched quote in format: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DurationFormatUtils.lexx(java.lang.String):org.apache.commons.lang3.time.DurationFormatUtils$Token[]");
    }

    private static String paddedValue(long j2, boolean z, int i2) {
        String l2 = Long.toString(j2);
        return z ? StringUtils.leftPad(l2, i2, '0') : l2;
    }

    public static String formatDuration(long j2, String str, boolean z) {
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        Token[] lexx = lexx(str);
        if (Token.containsTokenWithValue(lexx, f31461d)) {
            j3 = j2 / DateUtils.MILLIS_PER_DAY;
            j4 = j2 - (DateUtils.MILLIS_PER_DAY * j3);
        } else {
            j4 = j2;
            j3 = 0;
        }
        if (Token.containsTokenWithValue(lexx, H)) {
            j5 = j4 / DateUtils.MILLIS_PER_HOUR;
            j4 -= DateUtils.MILLIS_PER_HOUR * j5;
        } else {
            j5 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f31462m)) {
            j6 = j4 / 60000;
            j4 -= 60000 * j6;
        } else {
            j6 = 0;
        }
        if (Token.containsTokenWithValue(lexx, s)) {
            long j9 = j4 / 1000;
            j7 = j4 - (1000 * j9);
            j8 = j9;
        } else {
            j8 = 0;
            j7 = j4;
        }
        return format(lexx, 0, 0, j3, j5, j6, j8, j7, z);
    }

    public static String formatPeriod(long j2, long j3, String str, boolean z, TimeZone timeZone) {
        int i2;
        Token[] lexx = lexx(str);
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(new Date(j2));
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.setTime(new Date(j3));
        int i3 = instance2.get(14) - instance.get(14);
        int i4 = instance2.get(13) - instance.get(13);
        int i5 = instance2.get(12) - instance.get(12);
        int i6 = instance2.get(11) - instance.get(11);
        int i7 = instance2.get(5) - instance.get(5);
        int i8 = instance2.get(2) - instance.get(2);
        int i9 = instance2.get(1) - instance.get(1);
        while (i3 < 0) {
            i3 += 1000;
            i4--;
        }
        while (i4 < 0) {
            i4 += 60;
            i5--;
        }
        while (i5 < 0) {
            i5 += 60;
            i6--;
        }
        while (i6 < 0) {
            i6 += 24;
            i7--;
        }
        int i10 = 0;
        if (Token.containsTokenWithValue(lexx, M)) {
            while (i7 < 0) {
                i7 += instance.getActualMaximum(5);
                i8--;
                instance.add(2, 1);
            }
            while (i2 < 0) {
                i8 = i2 + 12;
                i9--;
            }
            if (!Token.containsTokenWithValue(lexx, y) && i9 != 0) {
                while (i9 != 0) {
                    i2 += i9 * 12;
                    i9 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(lexx, y)) {
                int i11 = instance2.get(1);
                if (i8 < 0) {
                    i11--;
                }
                while (instance.get(1) != i11) {
                    int actualMaximum = i7 + (instance.getActualMaximum(6) - instance.get(6));
                    if ((instance instanceof GregorianCalendar) && instance.get(2) == 1 && instance.get(5) == 29) {
                        actualMaximum++;
                    }
                    instance.add(1, 1);
                    i7 = actualMaximum + instance.get(6);
                }
                i9 = 0;
            }
            while (instance.get(2) != instance2.get(2)) {
                i7 += instance.getActualMaximum(5);
                instance.add(2, 1);
            }
            i2 = 0;
            while (i7 < 0) {
                i7 += instance.getActualMaximum(5);
                i2--;
                instance.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(lexx, f31461d)) {
            i6 += i7 * 24;
            i7 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, H)) {
            i5 += i6 * 60;
            i6 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, f31462m)) {
            i4 += i5 * 60;
            i5 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, s)) {
            i3 += i4 * 1000;
        } else {
            i10 = i4;
        }
        return format(lexx, (long) i9, (long) i2, (long) i7, (long) i6, (long) i5, (long) i10, (long) i3, z);
    }
}
