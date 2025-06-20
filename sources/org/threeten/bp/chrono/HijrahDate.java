package org.threeten.bp.chrono;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.httpclient.HttpStatus;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class HijrahDate extends ChronoDateImpl<HijrahDate> implements Serializable {
    private static final Integer[] A3 = new Integer[m3.length];
    private static final Integer[] B3;
    private static final Integer[] C3 = new Integer[h3.length];
    private static final Integer[] D3 = new Integer[i3.length];
    private static final Integer[] E3 = new Integer[j3.length];
    private static final Integer[] F3 = new Integer[p3.length];
    private static final int G3 = 334;
    private static final int H3 = -492148;
    private static final long d3 = -5207853542612002020L;
    public static final int e3 = 1;
    public static final int f3 = 9999;
    private static final int[] g3;
    private static final int[] h3 = {0, 30, 59, 89, 118, 148, 177, HttpStatus.SC_MULTI_STATUS, 236, TIFFConstants.a0, MetaDo.U, TIFFConstants.t1};
    private static final int[] i3 = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
    private static final int[] j3 = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
    private static final int[] k3 = {0, 1, 0, 1, 0, 1, 1};
    private static final int[] l3 = {1, f3, 11, 51, 5, 29, 354};
    private static final int[] m3 = {1, f3, 11, 52, 6, 30, 355};
    private static final int n3 = 5;
    private static final int o3 = 6;
    private static final int[] p3 = {0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
    private static final char q3;
    private static final String r3 = File.pathSeparator;
    private static final String s3 = "hijrah_deviation.cfg";
    private static final String t3;
    private static final HashMap<Integer, Integer[]> u3 = new HashMap<>();
    private static final HashMap<Integer, Integer[]> v3 = new HashMap<>();
    private static final HashMap<Integer, Integer[]> w3 = new HashMap<>();
    private static final Long[] x3 = new Long[334];
    private static final Integer[] y3 = new Integer[k3.length];
    private static final Integer[] z3 = new Integer[l3.length];
    private final transient int X2;
    private final transient HijrahEra Y;
    private final transient int Y2;
    private final transient int Z;
    private final transient int Z2;
    private final transient DayOfWeek a3;
    private final long b3;
    private final transient boolean c3;

    /* renamed from: org.threeten.bp.chrono.HijrahDate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31791a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31791a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x006c }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f31791a     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.HijrahDate.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        int i2 = 0;
        int[] iArr = {0, 30, 59, 89, 118, 148, 177, HttpStatus.SC_MULTI_STATUS, 236, TIFFConstants.a0, MetaDo.U, TIFFConstants.t1};
        g3 = iArr;
        char c2 = File.separatorChar;
        q3 = c2;
        t3 = "org" + c2 + "threeten" + c2 + "bp" + c2 + "chrono";
        B3 = new Integer[iArr.length];
        int i4 = 0;
        while (true) {
            int[] iArr2 = g3;
            if (i4 >= iArr2.length) {
                break;
            }
            B3[i4] = Integer.valueOf(iArr2[i4]);
            i4++;
        }
        int i5 = 0;
        while (true) {
            int[] iArr3 = h3;
            if (i5 >= iArr3.length) {
                break;
            }
            C3[i5] = Integer.valueOf(iArr3[i5]);
            i5++;
        }
        int i6 = 0;
        while (true) {
            int[] iArr4 = i3;
            if (i6 >= iArr4.length) {
                break;
            }
            D3[i6] = Integer.valueOf(iArr4[i6]);
            i6++;
        }
        int i7 = 0;
        while (true) {
            int[] iArr5 = j3;
            if (i7 >= iArr5.length) {
                break;
            }
            E3[i7] = Integer.valueOf(iArr5[i7]);
            i7++;
        }
        int i8 = 0;
        while (true) {
            int[] iArr6 = p3;
            if (i8 >= iArr6.length) {
                break;
            }
            F3[i8] = Integer.valueOf(iArr6[i8]);
            i8++;
        }
        int i9 = 0;
        while (true) {
            Long[] lArr = x3;
            if (i9 >= lArr.length) {
                break;
            }
            lArr[i9] = Long.valueOf((long) (i9 * 10631));
            i9++;
        }
        int i10 = 0;
        while (true) {
            int[] iArr7 = k3;
            if (i10 >= iArr7.length) {
                break;
            }
            y3[i10] = Integer.valueOf(iArr7[i10]);
            i10++;
        }
        int i11 = 0;
        while (true) {
            int[] iArr8 = l3;
            if (i11 >= iArr8.length) {
                break;
            }
            z3[i11] = Integer.valueOf(iArr8[i11]);
            i11++;
        }
        while (true) {
            int[] iArr9 = m3;
            if (i2 < iArr9.length) {
                A3[i2] = Integer.valueOf(iArr9[i2]);
                i2++;
            } else {
                try {
                    b3();
                    return;
                } catch (IOException | ParseException unused) {
                    return;
                }
            }
        }
    }

    private HijrahDate(long j2) {
        int[] n2 = n2(j2);
        h1(n2[1]);
        e1(n2[2]);
        c1(n2[3]);
        d1(n2[4]);
        this.Y = HijrahEra.j(n2[0]);
        int i2 = n2[1];
        this.Z = i2;
        this.X2 = n2[2];
        this.Y2 = n2[3];
        this.Z2 = n2[4];
        this.a3 = DayOfWeek.s(n2[5]);
        this.b3 = j2;
        this.c3 = I2((long) i2);
    }

    static int B2() {
        return z3[5].intValue();
    }

    static int C2() {
        return z3[6].intValue();
    }

    private static int E2(int i2, long j2) {
        Integer[] k1 = k1(i2);
        int i4 = 0;
        int i5 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i5 == 0) {
            return 0;
        }
        if (i5 > 0) {
            while (i4 < k1.length) {
                if (j2 < ((long) k1[i4].intValue())) {
                    return i4 - 1;
                }
                i4++;
            }
            return 29;
        }
        long j4 = -j2;
        while (i4 < k1.length) {
            if (j4 <= ((long) k1[i4].intValue())) {
                return i4 - 1;
            }
            i4++;
        }
        return 29;
    }

    private static InputStream F1() throws IOException {
        ZipFile zipFile;
        String property = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (property == null) {
            property = s3;
        }
        String property2 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        if (property2 != null) {
            if (property2.length() != 0 || !property2.endsWith(System.getProperty("file.separator"))) {
                property2 = property2 + System.getProperty("file.separator");
            }
            File file = new File(property2 + q3 + property);
            if (file.exists()) {
                return new FileInputStream(file);
            }
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), r3);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            File file2 = new File(nextToken);
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(nextToken);
                    char c2 = q3;
                    sb.append(c2);
                    String str = t3;
                    sb.append(str);
                    if (new File(sb.toString(), property).exists()) {
                        return new FileInputStream(nextToken + c2 + str + c2 + property);
                    }
                } else {
                    try {
                        zipFile = new ZipFile(file2);
                    } catch (IOException unused) {
                        zipFile = null;
                    }
                    if (zipFile != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(t3);
                        char c4 = q3;
                        sb2.append(c4);
                        sb2.append(property);
                        String sb3 = sb2.toString();
                        ZipEntry entry = zipFile.getEntry(sb3);
                        if (entry == null) {
                            if (c4 == '/') {
                                sb3 = sb3.replace('/', ASCIIPropertyListParser.p);
                            } else if (c4 == '\\') {
                                sb3 = sb3.replace(ASCIIPropertyListParser.p, '/');
                            }
                            entry = zipFile.getEntry(sb3);
                        }
                        if (entry != null) {
                            return zipFile.getInputStream(entry);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    static int G2(int i2) {
        Integer[] numArr;
        int i4 = i2 - 1;
        int i5 = i4 / 30;
        try {
            numArr = w3.get(Integer.valueOf(i5));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr == null) {
            return I2((long) i2) ? 355 : 354;
        }
        int i6 = i4 % 30;
        if (i6 != 29) {
            return numArr[i6 + 1].intValue() - numArr[i6].intValue();
        }
        Long[] lArr = x3;
        return (lArr[i5 + 1].intValue() - lArr[i5].intValue()) - numArr[i6].intValue();
    }

    static boolean I2(long j2) {
        if (j2 <= 0) {
            j2 = -j2;
        }
        return ((j2 * 11) + 14) % 30 < 11;
    }

    public static HijrahDate M2() {
        return N2(Clock.g());
    }

    public static HijrahDate N2(Clock clock) {
        return HijrahChronology.X2.h(clock);
    }

    public static HijrahDate P2(ZoneId zoneId) {
        return N2(Clock.f(zoneId));
    }

    public static HijrahDate Q2(int i2, int i4, int i5) {
        return i2 >= 1 ? T2(HijrahEra.AH, i2, i4, i5) : T2(HijrahEra.BEFORE_AH, 1 - i2, i4, i5);
    }

    static HijrahDate S2(LocalDate localDate) {
        return new HijrahDate(localDate.c0());
    }

    private static int T1(long j2) {
        Long[] lArr = x3;
        int i2 = 0;
        while (i2 < lArr.length) {
            try {
                if (j2 < lArr[i2].longValue()) {
                    return i2 - 1;
                }
                i2++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                return ((int) j2) / 10631;
            }
        }
        return ((int) j2) / 10631;
    }

    static HijrahDate T2(HijrahEra hijrahEra, int i2, int i4, int i5) {
        Jdk8Methods.j(hijrahEra, "era");
        h1(i2);
        e1(i4);
        c1(i5);
        return new HijrahDate(m2(hijrahEra.k(i2), i4, i5));
    }

    static HijrahDate U2(long j2) {
        return new HijrahDate(j2);
    }

    private static void V2(String str, int i2) throws ParseException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(58);
            if (indexOf != -1) {
                try {
                    int parseInt = Integer.parseInt(nextToken.substring(indexOf + 1, nextToken.length()));
                    int indexOf2 = nextToken.indexOf(45);
                    if (indexOf2 != -1) {
                        String substring = nextToken.substring(0, indexOf2);
                        String substring2 = nextToken.substring(indexOf2 + 1, indexOf);
                        int indexOf3 = substring.indexOf(47);
                        int indexOf4 = substring2.indexOf(47);
                        if (indexOf3 != -1) {
                            String substring3 = substring.substring(0, indexOf3);
                            String substring4 = substring.substring(indexOf3 + 1, substring.length());
                            try {
                                int parseInt2 = Integer.parseInt(substring3);
                                try {
                                    int parseInt3 = Integer.parseInt(substring4);
                                    if (indexOf4 != -1) {
                                        String substring5 = substring2.substring(0, indexOf4);
                                        String substring6 = substring2.substring(indexOf4 + 1, substring2.length());
                                        try {
                                            int parseInt4 = Integer.parseInt(substring5);
                                            try {
                                                int parseInt5 = Integer.parseInt(substring6);
                                                if (parseInt2 == -1 || parseInt3 == -1 || parseInt4 == -1 || parseInt5 == -1) {
                                                    throw new ParseException("Unknown error at line " + i2 + ".", i2);
                                                }
                                                Y0(parseInt2, parseInt3, parseInt4, parseInt5, parseInt);
                                            } catch (NumberFormatException unused) {
                                                throw new ParseException("End month is not properly set at line " + i2 + ".", i2);
                                            }
                                        } catch (NumberFormatException unused2) {
                                            throw new ParseException("End year is not properly set at line " + i2 + ".", i2);
                                        }
                                    } else {
                                        throw new ParseException("End year/month has incorrect format at line " + i2 + ".", i2);
                                    }
                                } catch (NumberFormatException unused3) {
                                    throw new ParseException("Start month is not properly set at line " + i2 + ".", i2);
                                }
                            } catch (NumberFormatException unused4) {
                                throw new ParseException("Start year is not properly set at line " + i2 + ".", i2);
                            }
                        } else {
                            throw new ParseException("Start year/month has incorrect format at line " + i2 + ".", i2);
                        }
                    } else {
                        throw new ParseException("Start and end year/month has incorrect format at line " + i2 + ".", i2);
                    }
                } catch (NumberFormatException unused5) {
                    throw new ParseException("Offset is not properly set at line " + i2 + ".", i2);
                }
            } else {
                throw new ParseException("Offset has incorrect format at line " + i2 + ".", i2);
            }
        }
    }

    private static void Y0(int i2, int i4, int i5, int i6, int i7) {
        int i8 = i2;
        int i9 = i4;
        int i10 = i5;
        int i11 = i6;
        int i12 = i7;
        if (i8 < 1) {
            throw new IllegalArgumentException("startYear < 1");
        } else if (i10 < 1) {
            throw new IllegalArgumentException("endYear < 1");
        } else if (i9 < 0 || i9 > 11) {
            throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
        } else if (i11 < 0 || i11 > 11) {
            throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
        } else if (i10 > 9999) {
            throw new IllegalArgumentException("endYear > 9999");
        } else if (i10 < i8) {
            throw new IllegalArgumentException("startYear > endYear");
        } else if (i10 != i8 || i11 >= i9) {
            boolean I2 = I2((long) i8);
            Integer[] numArr = u3.get(Integer.valueOf(i2));
            if (numArr == null) {
                if (!I2) {
                    numArr = new Integer[g3.length];
                    int i13 = 0;
                    while (true) {
                        int[] iArr = g3;
                        if (i13 >= iArr.length) {
                            break;
                        }
                        numArr[i13] = Integer.valueOf(iArr[i13]);
                        i13++;
                    }
                } else {
                    numArr = new Integer[h3.length];
                    int i14 = 0;
                    while (true) {
                        int[] iArr2 = h3;
                        if (i14 >= iArr2.length) {
                            break;
                        }
                        numArr[i14] = Integer.valueOf(iArr2[i14]);
                        i14++;
                    }
                }
            }
            Integer[] numArr2 = new Integer[numArr.length];
            for (int i15 = 0; i15 < 12; i15++) {
                if (i15 > i9) {
                    numArr2[i15] = Integer.valueOf(numArr[i15].intValue() - i12);
                } else {
                    Integer num = numArr[i15];
                    num.intValue();
                    numArr2[i15] = num;
                }
            }
            u3.put(Integer.valueOf(i2), numArr2);
            Integer[] numArr3 = v3.get(Integer.valueOf(i2));
            if (numArr3 == null) {
                if (!I2) {
                    numArr3 = new Integer[i3.length];
                    int i16 = 0;
                    while (true) {
                        int[] iArr3 = i3;
                        if (i16 >= iArr3.length) {
                            break;
                        }
                        numArr3[i16] = Integer.valueOf(iArr3[i16]);
                        i16++;
                    }
                } else {
                    numArr3 = new Integer[j3.length];
                    int i17 = 0;
                    while (true) {
                        int[] iArr4 = j3;
                        if (i17 >= iArr4.length) {
                            break;
                        }
                        numArr3[i17] = Integer.valueOf(iArr4[i17]);
                        i17++;
                    }
                }
            }
            Integer[] numArr4 = new Integer[numArr3.length];
            for (int i18 = 0; i18 < 12; i18++) {
                if (i18 == i9) {
                    numArr4[i18] = Integer.valueOf(numArr3[i18].intValue() - i12);
                } else {
                    Integer num2 = numArr3[i18];
                    num2.intValue();
                    numArr4[i18] = num2;
                }
            }
            v3.put(Integer.valueOf(i2), numArr4);
            if (i8 != i10) {
                int i19 = i8 - 1;
                int i20 = i19 / 30;
                int i21 = i19 % 30;
                Integer[] numArr5 = w3.get(Integer.valueOf(i20));
                if (numArr5 == null) {
                    int length = p3.length;
                    Integer[] numArr6 = new Integer[length];
                    for (int i22 = 0; i22 < length; i22++) {
                        numArr6[i22] = Integer.valueOf(p3[i22]);
                    }
                    numArr5 = numArr6;
                }
                for (int i23 = i21 + 1; i23 < p3.length; i23++) {
                    numArr5[i23] = Integer.valueOf(numArr5[i23].intValue() - i12);
                }
                w3.put(Integer.valueOf(i20), numArr5);
                int i24 = i10 - 1;
                int i25 = i24 / 30;
                if (i20 != i25) {
                    int i26 = i20 + 1;
                    while (true) {
                        Long[] lArr = x3;
                        if (i26 >= lArr.length) {
                            break;
                        }
                        lArr[i26] = Long.valueOf(lArr[i26].longValue() - ((long) i12));
                        i26++;
                    }
                    int i27 = i25 + 1;
                    while (true) {
                        Long[] lArr2 = x3;
                        if (i27 >= lArr2.length) {
                            break;
                        }
                        lArr2[i27] = Long.valueOf(lArr2[i27].longValue() + ((long) i12));
                        i27++;
                        i25 = i25;
                    }
                }
                int i28 = i25;
                int i29 = i24 % 30;
                Integer[] numArr7 = w3.get(Integer.valueOf(i28));
                if (numArr7 == null) {
                    int length2 = p3.length;
                    Integer[] numArr8 = new Integer[length2];
                    for (int i30 = 0; i30 < length2; i30++) {
                        numArr8[i30] = Integer.valueOf(p3[i30]);
                    }
                    numArr7 = numArr8;
                }
                for (int i31 = i29 + 1; i31 < p3.length; i31++) {
                    numArr7[i31] = Integer.valueOf(numArr7[i31].intValue() + i12);
                }
                w3.put(Integer.valueOf(i28), numArr7);
            }
            boolean I22 = I2((long) i10);
            Integer[] numArr9 = u3.get(Integer.valueOf(i5));
            if (numArr9 == null) {
                if (!I22) {
                    numArr9 = new Integer[g3.length];
                    int i32 = 0;
                    while (true) {
                        int[] iArr5 = g3;
                        if (i32 >= iArr5.length) {
                            break;
                        }
                        numArr9[i32] = Integer.valueOf(iArr5[i32]);
                        i32++;
                    }
                } else {
                    numArr9 = new Integer[h3.length];
                    int i33 = 0;
                    while (true) {
                        int[] iArr6 = h3;
                        if (i33 >= iArr6.length) {
                            break;
                        }
                        numArr9[i33] = Integer.valueOf(iArr6[i33]);
                        i33++;
                    }
                }
            }
            Integer[] numArr10 = new Integer[numArr9.length];
            for (int i34 = 0; i34 < 12; i34++) {
                if (i34 > i11) {
                    numArr10[i34] = Integer.valueOf(numArr9[i34].intValue() + i12);
                } else {
                    Integer num3 = numArr9[i34];
                    num3.intValue();
                    numArr10[i34] = num3;
                }
            }
            u3.put(Integer.valueOf(i5), numArr10);
            Integer[] numArr11 = v3.get(Integer.valueOf(i5));
            if (numArr11 == null) {
                if (!I22) {
                    numArr11 = new Integer[i3.length];
                    int i35 = 0;
                    while (true) {
                        int[] iArr7 = i3;
                        if (i35 >= iArr7.length) {
                            break;
                        }
                        numArr11[i35] = Integer.valueOf(iArr7[i35]);
                        i35++;
                    }
                } else {
                    numArr11 = new Integer[j3.length];
                    int i36 = 0;
                    while (true) {
                        int[] iArr8 = j3;
                        if (i36 >= iArr8.length) {
                            break;
                        }
                        numArr11[i36] = Integer.valueOf(iArr8[i36]);
                        i36++;
                    }
                }
            }
            Integer[] numArr12 = new Integer[numArr11.length];
            for (int i37 = 0; i37 < 12; i37++) {
                if (i37 == i11) {
                    numArr12[i37] = Integer.valueOf(numArr11[i37].intValue() + i12);
                } else {
                    Integer num4 = numArr11[i37];
                    num4.intValue();
                    numArr12[i37] = num4;
                }
            }
            HashMap<Integer, Integer[]> hashMap = v3;
            hashMap.put(Integer.valueOf(i5), numArr12);
            Integer[] numArr13 = hashMap.get(Integer.valueOf(i2));
            Integer[] numArr14 = hashMap.get(Integer.valueOf(i5));
            HashMap<Integer, Integer[]> hashMap2 = u3;
            int intValue = numArr13[i9].intValue();
            int intValue2 = numArr14[i11].intValue();
            int intValue3 = hashMap2.get(Integer.valueOf(i2))[11].intValue() + numArr13[11].intValue();
            int intValue4 = hashMap2.get(Integer.valueOf(i5))[11].intValue() + numArr14[11].intValue();
            Integer[] numArr15 = A3;
            int intValue5 = numArr15[5].intValue();
            Integer[] numArr16 = z3;
            int intValue6 = numArr16[5].intValue();
            if (intValue5 < intValue) {
                intValue5 = intValue;
            }
            if (intValue5 < intValue2) {
                intValue5 = intValue2;
            }
            numArr15[5] = Integer.valueOf(intValue5);
            if (intValue6 <= intValue) {
                intValue = intValue6;
            }
            if (intValue <= intValue2) {
                intValue2 = intValue;
            }
            numArr16[5] = Integer.valueOf(intValue2);
            int intValue7 = numArr15[6].intValue();
            int intValue8 = numArr16[6].intValue();
            if (intValue7 < intValue3) {
                intValue7 = intValue3;
            }
            if (intValue7 < intValue4) {
                intValue7 = intValue4;
            }
            numArr15[6] = Integer.valueOf(intValue7);
            if (intValue8 <= intValue3) {
                intValue3 = intValue8;
            }
            if (intValue3 <= intValue4) {
                intValue4 = intValue3;
            }
            numArr16[6] = Integer.valueOf(intValue4);
        } else {
            throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b3() throws java.io.IOException, java.text.ParseException {
        /*
            java.io.InputStream r0 = F1()
            if (r0 == 0) goto L_0x0030
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0029 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0029 }
            r3.<init>(r0)     // Catch:{ all -> 0x0029 }
            r2.<init>(r3)     // Catch:{ all -> 0x0029 }
            r0 = 0
        L_0x0012:
            java.lang.String r1 = r2.readLine()     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0025
            int r0 = r0 + 1
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0022 }
            V2(r1, r0)     // Catch:{ all -> 0x0022 }
            goto L_0x0012
        L_0x0022:
            r0 = move-exception
            r1 = r2
            goto L_0x002a
        L_0x0025:
            r2.close()
            goto L_0x0030
        L_0x0029:
            r0 = move-exception
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            throw r0
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.HijrahDate.b3():void");
    }

    private static void c1(int i2) {
        if (i2 < 1 || i2 > p2()) {
            throw new DateTimeException("Invalid day of month of Hijrah date, day " + i2 + " greater than " + p2() + " or less than 1");
        }
    }

    static ChronoLocalDate c3(DataInput dataInput) throws IOException {
        return HijrahChronology.X2.b(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private static void d1(int i2) {
        if (i2 < 1 || i2 > q2()) {
            throw new DateTimeException("Invalid day of year of Hijrah date");
        }
    }

    private Object d3() {
        return new HijrahDate(this.b3);
    }

    private static void e1(int i2) {
        if (i2 < 1 || i2 > 12) {
            throw new DateTimeException("Invalid month of Hijrah date");
        }
    }

    private static int e2(long j2, int i2) {
        Long l2;
        try {
            l2 = x3[i2];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l2 = null;
        }
        if (l2 == null) {
            l2 = Long.valueOf((long) (i2 * 10631));
        }
        return (int) (j2 - l2.longValue());
    }

    private static HijrahDate e3(int i2, int i4, int i5) {
        int r2 = r2(i4 - 1, i2);
        if (i5 > r2) {
            i5 = r2;
        }
        return Q2(i2, i4, i5);
    }

    private static int f2(int i2, int i4, int i5) {
        Integer num;
        Integer[] l1 = l1(i5);
        if (i2 < 0) {
            i2 = I2((long) i5) ? i2 + 355 : i2 + 354;
            if (i4 <= 0) {
                return i2;
            }
            num = l1[i4];
        } else if (i4 <= 0) {
            return i2;
        } else {
            num = l1[i4];
        }
        return i2 - num.intValue();
    }

    private static void h1(int i2) {
        if (i2 < 1 || i2 > 9999) {
            throw new DateTimeException("Invalid year of Hijrah Era");
        }
    }

    private static int i2(int i2, int i4, int i5) {
        Integer[] k1 = k1(i2);
        return i4 > 0 ? i4 - k1[i5].intValue() : k1[i5].intValue() + i4;
    }

    private Object i3() {
        return new Ser((byte) 3, this);
    }

    public static HijrahDate j1(TemporalAccessor temporalAccessor) {
        return HijrahChronology.X2.e(temporalAccessor);
    }

    private static long j3(int i2) {
        Long l2;
        int i4 = i2 - 1;
        int i5 = i4 / 30;
        int i6 = i4 % 30;
        int intValue = k1(i5)[Math.abs(i6)].intValue();
        if (i6 < 0) {
            intValue = -intValue;
        }
        try {
            l2 = x3[i5];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l2 = null;
        }
        if (l2 == null) {
            l2 = Long.valueOf((long) (i5 * 10631));
        }
        return (l2.longValue() + ((long) intValue)) - 492149;
    }

    private static Integer[] k1(int i2) {
        Integer[] numArr;
        try {
            numArr = w3.get(Integer.valueOf(i2));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? F3 : numArr;
    }

    private static Integer[] l1(int i2) {
        Integer[] numArr;
        try {
            numArr = u3.get(Integer.valueOf(i2));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr == null) {
            return I2((long) i2) ? C3 : B3;
        }
        return numArr;
    }

    private static long m2(int i2, int i4, int i5) {
        return j3(i2) + ((long) r2(i4 - 1, i2)) + ((long) i5);
    }

    private static int[] n2(long j2) {
        int i2;
        int i4;
        int w2;
        int f2;
        HijrahEra hijrahEra;
        long j4 = j2 - -492148;
        if (j4 >= 0) {
            int T1 = T1(j4);
            int e2 = e2(j4, T1);
            int E2 = E2(T1, (long) e2);
            i4 = i2(T1, e2, E2);
            i2 = (T1 * 30) + E2 + 1;
            w2 = w2(i4, i2);
            f2 = f2(i4, w2, i2) + 1;
            hijrahEra = HijrahEra.AH;
        } else {
            int i5 = (int) j4;
            int i6 = i5 / 10631;
            int i7 = i5 % 10631;
            if (i7 == 0) {
                i6++;
                i7 = -10631;
            }
            int E22 = E2(i6, (long) i7);
            int i22 = i2(i6, i7, E22);
            i2 = 1 - ((i6 * 30) - E22);
            i4 = I2((long) i2) ? i22 + 355 : i22 + 354;
            w2 = w2(i4, i2);
            f2 = f2(i4, w2, i2) + 1;
            hijrahEra = HijrahEra.BEFORE_AH;
        }
        int i8 = f2;
        int i9 = (int) ((j2 - -492153) % 7);
        return new int[]{hijrahEra.getValue(), i2, w2 + 1, i8, i4 + 1, i9 + (i9 <= 0 ? 7 : 0)};
    }

    static int p2() {
        return A3[5].intValue();
    }

    static int q2() {
        return A3[6].intValue();
    }

    private static int r2(int i2, int i4) {
        return l1(i4)[i2].intValue();
    }

    static int u2(int i2, int i4) {
        return w1(i4)[i2].intValue();
    }

    private static Integer[] w1(int i2) {
        Integer[] numArr;
        try {
            numArr = v3.get(Integer.valueOf(i2));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr == null) {
            return I2((long) i2) ? E3 : D3;
        }
        return numArr;
    }

    private static int w2(int i2, int i4) {
        Integer[] l1 = l1(i4);
        int i5 = 0;
        if (i2 >= 0) {
            while (i5 < l1.length) {
                if (i2 < l1[i5].intValue()) {
                    return i5 - 1;
                }
                i5++;
            }
            return 11;
        }
        int i6 = I2((long) i4) ? i2 + 355 : i2 + 354;
        while (i5 < l1.length) {
            if (i6 < l1[i5].intValue()) {
                return i5 - 1;
            }
            i5++;
        }
        return 11;
    }

    /* renamed from: D1 */
    public HijrahChronology x() {
        return HijrahChronology.X2;
    }

    public boolean E() {
        return this.c3;
    }

    public int F() {
        return u2(this.X2 - 1, this.Z);
    }

    public int J() {
        return G2(this.Z);
    }

    /* renamed from: J2 */
    public HijrahDate o(long j2, TemporalUnit temporalUnit) {
        return (HijrahDate) super.o(j2, temporalUnit);
    }

    /* renamed from: L2 */
    public HijrahDate g(TemporalAmount temporalAmount) {
        return (HijrahDate) super.g(temporalAmount);
    }

    /* renamed from: W2 */
    public HijrahDate q(long j2, TemporalUnit temporalUnit) {
        return (HijrahDate) super.q(j2, temporalUnit);
    }

    /* renamed from: X2 */
    public HijrahDate h(TemporalAmount temporalAmount) {
        return (HijrahDate) super.h(temporalAmount);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Y2 */
    public HijrahDate K0(long j2) {
        return new HijrahDate(this.b3 + j2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Z2 */
    public HijrahDate L0(long j2) {
        if (j2 == 0) {
            return this;
        }
        int i2 = (this.X2 - 1) + ((int) j2);
        int i4 = i2 / 12;
        int i5 = i2 % 12;
        while (i5 < 0) {
            i5 += 12;
            i4 = Jdk8Methods.p(i4, 1);
        }
        return T2(this.Y, Jdk8Methods.k(this.Z, i4), i5 + 1, this.Y2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a3 */
    public HijrahDate S0(long j2) {
        if (j2 == 0) {
            return this;
        }
        return T2(this.Y, Jdk8Methods.k(this.Z, (int) j2), this.X2, this.Y2);
    }

    public long c0() {
        return m2(this.Z, this.X2, this.Y2);
    }

    public ValueRange f(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.f(this);
        }
        if (m(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i2 = AnonymousClass1.f31791a[chronoField.ordinal()];
            if (i2 == 1) {
                return ValueRange.k(1, (long) F());
            }
            if (i2 == 2) {
                return ValueRange.k(1, (long) J());
            }
            if (i2 != 3) {
                return i2 != 4 ? x().E(chronoField) : ValueRange.k(1, 1000);
            }
            return ValueRange.k(1, 5);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    /* renamed from: f3 */
    public HijrahDate l(TemporalAdjuster temporalAdjuster) {
        return (HijrahDate) super.l(temporalAdjuster);
    }

    /* renamed from: g3 */
    public HijrahDate q0(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (HijrahDate) temporalField.e(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.n(j2);
        int i2 = (int) j2;
        switch (AnonymousClass1.f31791a[chronoField.ordinal()]) {
            case 1:
                return e3(this.Z, this.X2, i2);
            case 2:
                int i4 = i2 - 1;
                return e3(this.Z, (i4 / 30) + 1, (i4 % 30) + 1);
            case 3:
                return K0((j2 - p(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                if (this.Z < 1) {
                    i2 = 1 - i2;
                }
                return e3(i2, this.X2, this.Y2);
            case 5:
                return K0(j2 - ((long) this.a3.getValue()));
            case 6:
                return K0(j2 - p(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return K0(j2 - p(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return new HijrahDate((long) i2);
            case 9:
                return K0((j2 - p(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 10:
                return e3(this.Z, i2, this.Y2);
            case 11:
                return e3(i2, this.X2, this.Y2);
            case 12:
                return e3(1 - this.Z, this.X2, this.Y2);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public /* bridge */ /* synthetic */ ChronoPeriod h0(ChronoLocalDate chronoLocalDate) {
        return super.h0(chronoLocalDate);
    }

    /* access modifiers changed from: package-private */
    public void h3(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(b(ChronoField.YEAR));
        dataOutput.writeByte(b(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(b(ChronoField.DAY_OF_MONTH));
    }

    /* renamed from: j2 */
    public HijrahEra y() {
        return this.Y;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r4 = (r4 - 1) / 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        r4 = (r4 - 1) % 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        return (long) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long p(org.threeten.bp.temporal.TemporalField r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof org.threeten.bp.temporal.ChronoField
            if (r0 == 0) goto L_0x005f
            int[] r0 = org.threeten.bp.chrono.HijrahDate.AnonymousClass1.f31791a
            r1 = r4
            org.threeten.bp.temporal.ChronoField r1 = (org.threeten.bp.temporal.ChronoField) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x005c;
                case 2: goto L_0x0059;
                case 3: goto L_0x0056;
                case 4: goto L_0x0031;
                case 5: goto L_0x004f;
                case 6: goto L_0x004c;
                case 7: goto L_0x0045;
                case 8: goto L_0x0040;
                case 9: goto L_0x0037;
                case 10: goto L_0x0034;
                case 11: goto L_0x0031;
                case 12: goto L_0x0029;
                default: goto L_0x0012;
            }
        L_0x0012:
            org.threeten.bp.temporal.UnsupportedTemporalTypeException r0 = new org.threeten.bp.temporal.UnsupportedTemporalTypeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported field: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0029:
            org.threeten.bp.chrono.HijrahEra r4 = r3.Y
            int r4 = r4.getValue()
        L_0x002f:
            long r0 = (long) r4
            return r0
        L_0x0031:
            int r4 = r3.Z
            goto L_0x002f
        L_0x0034:
            int r4 = r3.X2
            goto L_0x002f
        L_0x0037:
            int r4 = r3.Z2
        L_0x0039:
            int r4 = r4 + -1
            int r4 = r4 / 7
        L_0x003d:
            int r4 = r4 + 1
            goto L_0x002f
        L_0x0040:
            long r0 = r3.c0()
            return r0
        L_0x0045:
            int r4 = r3.Z2
        L_0x0047:
            int r4 = r4 + -1
            int r4 = r4 % 7
            goto L_0x003d
        L_0x004c:
            int r4 = r3.Y2
            goto L_0x0047
        L_0x004f:
            org.threeten.bp.DayOfWeek r4 = r3.a3
            int r4 = r4.getValue()
            goto L_0x002f
        L_0x0056:
            int r4 = r3.Y2
            goto L_0x0039
        L_0x0059:
            int r4 = r3.Z2
            goto L_0x002f
        L_0x005c:
            int r4 = r3.Y2
            goto L_0x002f
        L_0x005f:
            long r0 = r4.j(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.HijrahDate.p(org.threeten.bp.temporal.TemporalField):long");
    }

    public /* bridge */ /* synthetic */ long r(Temporal temporal, TemporalUnit temporalUnit) {
        return super.r(temporal, temporalUnit);
    }

    public final ChronoLocalDateTime<HijrahDate> s(LocalTime localTime) {
        return super.s(localTime);
    }
}
