package saman.zamani.persiandate;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public class PersianDate {
    public static final int A = 6;
    public static final int B = 7;
    public static final int C = 8;
    public static final int D = 9;
    public static final int E = 10;
    public static final int F = 11;
    public static final int G = 12;
    public static final int H = 1;
    public static final int I = 2;
    public static final String J = "ق.ظ";
    public static final String K = "ب.ظ";
    public static final String L = "قبل از ظهر";
    public static final String M = "بعد از ظهر";
    public static final int v = 1;
    public static final int w = 2;
    public static final int x = 3;
    public static final int y = 4;
    public static final int z = 5;

    /* renamed from: a  reason: collision with root package name */
    private Long f31892a;

    /* renamed from: b  reason: collision with root package name */
    private int f31893b;

    /* renamed from: c  reason: collision with root package name */
    private int f31894c;

    /* renamed from: d  reason: collision with root package name */
    private int f31895d;

    /* renamed from: e  reason: collision with root package name */
    private int f31896e;

    /* renamed from: f  reason: collision with root package name */
    private int f31897f;

    /* renamed from: g  reason: collision with root package name */
    private int f31898g;

    /* renamed from: h  reason: collision with root package name */
    private int f31899h;

    /* renamed from: i  reason: collision with root package name */
    private int f31900i;

    /* renamed from: j  reason: collision with root package name */
    private int f31901j;

    /* renamed from: k  reason: collision with root package name */
    private Locale f31902k;

    /* renamed from: l  reason: collision with root package name */
    private Dialect f31903l;

    /* renamed from: m  reason: collision with root package name */
    private final String[] f31904m;

    /* renamed from: n  reason: collision with root package name */
    private final String[] f31905n;
    private final String[] o;
    private final String[] p;
    private final String[] q;
    private final String[] r;
    private final String[] s;
    private final String[] t;
    private final String[] u;

    /* renamed from: saman.zamani.persiandate.PersianDate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31906a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                saman.zamani.persiandate.PersianDate$Dialect[] r0 = saman.zamani.persiandate.PersianDate.Dialect.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31906a = r0
                saman.zamani.persiandate.PersianDate$Dialect r1 = saman.zamani.persiandate.PersianDate.Dialect.FINGLISH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31906a     // Catch:{ NoSuchFieldError -> 0x001d }
                saman.zamani.persiandate.PersianDate$Dialect r1 = saman.zamani.persiandate.PersianDate.Dialect.AFGHAN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31906a     // Catch:{ NoSuchFieldError -> 0x0028 }
                saman.zamani.persiandate.PersianDate$Dialect r1 = saman.zamani.persiandate.PersianDate.Dialect.KURDISH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31906a     // Catch:{ NoSuchFieldError -> 0x0033 }
                saman.zamani.persiandate.PersianDate$Dialect r1 = saman.zamani.persiandate.PersianDate.Dialect.PASHTO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: saman.zamani.persiandate.PersianDate.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Dialect {
        FINGLISH,
        AFGHAN,
        IRANIAN,
        KURDISH,
        PASHTO
    }

    public PersianDate() {
        this.f31902k = Locale.getDefault();
        this.f31903l = Dialect.IRANIAN;
        this.f31904m = new String[]{"شنبه", "یک‌شنبه", "دوشنبه", "سه‌شنبه", "چهارشنبه", "پنج‌شنبه", "جمعه"};
        this.f31905n = new String[]{"Shanbe", "Yekshanbe", "Doshanbe", "Seshanbe", "Chaharshanbe", "Panjshanbe", "Jom'e"};
        this.o = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        this.p = new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
        this.q = new String[]{"Farvardin", "Ordibehesht", "Khordad", "Tir", "Mordad", "Shahrivar", "Mehr", "Aban", "Azar", "Day", "Bahman", "Esfand"};
        this.r = new String[]{"حمل", "ثور", "جوزا", "سرطان", "اسد", "سنبله", "میزان", "عقرب", "قوس", "جدی", "دلو", "حوت"};
        this.s = new String[]{"جیژنان", "گولان", "زه ردان", "په رپه ر", "گه لاویژ", "نوخشان", "به ران", "خه زان", "ساران", "بفران", "به ندان", "رمشان"};
        this.t = new String[]{"وری", "غويی", "غبرګولی", "چنګاښ", "زمری", "وږی", "تله", "لړم", "ليندۍ", "مرغومی", "سلواغه", "كب"};
        this.u = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.f31892a = Long.valueOf(new Date().getTime());
        F0();
    }

    private void C(boolean z2) {
        if (z2) {
            j(this.f31893b, this.f31894c, this.f31895d, this.f31899h, this.f31900i, this.f31901j);
            return;
        }
        i(this.f31896e, this.f31897f, this.f31898g, this.f31899h, this.f31900i, this.f31901j);
    }

    private String D1(String str) {
        if (str.length() >= 2) {
            return str;
        }
        return "0" + str;
    }

    private void F0() {
        this.f31896e = Integer.parseInt(new SimpleDateFormat("yyyy", this.f31902k).format(this.f31892a));
        this.f31897f = Integer.parseInt(new SimpleDateFormat("MM", this.f31902k).format(this.f31892a));
        this.f31898g = Integer.parseInt(new SimpleDateFormat(HTML.Tag.t, this.f31902k).format(this.f31892a));
        this.f31899h = Integer.parseInt(new SimpleDateFormat("HH", this.f31902k).format(this.f31892a));
        this.f31900i = Integer.parseInt(new SimpleDateFormat(CSS.Value.k0, this.f31902k).format(this.f31892a));
        this.f31901j = Integer.parseInt(new SimpleDateFormat("ss", this.f31902k).format(this.f31892a));
        C(false);
    }

    public static PersianDate F1() {
        PersianDate persianDate = new PersianDate();
        persianDate.e1(0).g1(0).h1(0);
        return persianDate;
    }

    public static PersianDate G1() {
        PersianDate persianDate = new PersianDate();
        persianDate.m();
        persianDate.e1(0).g1(0).h1(0);
        return persianDate;
    }

    private void J1() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", this.f31902k);
            Date parse = simpleDateFormat.parse("" + this.f31898g + "/" + this.f31897f + "/" + e0() + StringUtils.SPACE + this.f31899h + ":" + this.f31900i + ":" + this.f31901j);
            Objects.requireNonNull(parse);
            this.f31892a = Long.valueOf(parse.getTime());
        } catch (ParseException unused) {
            this.f31892a = Long.valueOf(new Date().getTime());
        }
    }

    public static boolean K0(int i2) {
        return new PersianDate().E0(i2);
    }

    public static boolean L0(int i2) {
        return new PersianDate().N0(i2);
    }

    private void Z0(int[] iArr, int[] iArr2) {
        this.f31896e = iArr[0];
        this.f31897f = iArr[1];
        this.f31898g = iArr[2];
        this.f31893b = iArr2[0];
        this.f31894c = iArr2[1];
        this.f31895d = iArr2[2];
        this.f31899h = iArr2[3];
        this.f31900i = iArr2[4];
        this.f31901j = iArr2[5];
        J1();
    }

    private void i(int i2, int i3, int i4, int i5, int i6, int i7) {
        int[] iArr = {i2, i3, i4, i5, i6, i7};
        int[] iArr2 = {0, 0, 0, 0, 0, 0};
        int[] C0 = C0(i2, i3, i4);
        iArr2[0] = C0[0];
        iArr2[1] = C0[1];
        iArr2[2] = C0[2];
        iArr2[3] = i5;
        iArr2[4] = i6;
        iArr2[5] = i7;
        Z0(iArr, iArr2);
    }

    private void j(int i2, int i3, int i4, int i5, int i6, int i7) {
        int[] iArr = {0, 0, 0, 0, 0, 0};
        int[] iArr2 = {i2, i3, i4, i5, i6, i7};
        int[] S0 = S0(i2, i3, i4);
        iArr[0] = S0[0];
        iArr[1] = S0[1];
        iArr[2] = S0[2];
        iArr[3] = i5;
        iArr[4] = i6;
        iArr[5] = i7;
        Z0(iArr, iArr2);
    }

    public Boolean A(PersianDate persianDate) {
        return Boolean.valueOf(this.f31892a.longValue() < persianDate.x0().longValue());
    }

    public ArrayList<PersianDate> A0(PersianDate persianDate) {
        ArrayList<PersianDate> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < persianDate.K(); i2++) {
            arrayList.add(new PersianDate(persianDate.f31892a).q1(persianDate.K() - i2));
        }
        arrayList.add(persianDate);
        int size = 7 - arrayList.size();
        for (int i3 = 1; i3 <= size; i3++) {
            arrayList.add(new PersianDate(persianDate.f31892a).n(i3));
        }
        return arrayList;
    }

    public PersianDate A1(int i2) {
        return q1(i2 * 7);
    }

    public Boolean B(PersianDate persianDate) {
        return Boolean.valueOf(!A(persianDate).booleanValue());
    }

    public PersianDate[] B0() {
        return (PersianDate[]) A0(this).toArray(new PersianDate[0]);
    }

    public PersianDate B1() {
        return C1(1);
    }

    public int[] C0(int i2, int i3, int i4) {
        int[] iArr = new int[3];
        int i5 = i3 > 2 ? i2 + 1 : i2;
        iArr[0] = i5;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = ((((i2 * 365) + 355666) + ((3 + i5) / 4)) - ((i5 + 99) / 100)) + ((i5 + 399) / 400) + i4 + new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, TIFFConstants.h0, 304, TIFFConstants.E1}[i3 - 1];
        iArr[2] = i6;
        int i7 = ((i6 / 12053) * 33) - 1595;
        iArr[0] = i7;
        int i8 = i6 % 12053;
        iArr[2] = i8;
        int i9 = i7 + ((i8 / 1461) * 4);
        iArr[0] = i9;
        int i10 = i8 % 1461;
        iArr[2] = i10;
        if (i10 > 365) {
            iArr[0] = i9 + ((i10 - 1) / 365);
            iArr[2] = (i10 - 1) % 365;
        }
        int i11 = iArr[2];
        if (i11 < 186) {
            iArr[1] = (i11 / 31) + 1;
            iArr[2] = (i11 % 31) + 1;
        } else {
            iArr[1] = ((i11 - 186) / 30) + 7;
            iArr[2] = ((i11 - 186) % 30) + 1;
        }
        return iArr;
    }

    public PersianDate C1(int i2) {
        return n1((long) i2, 0, 0);
    }

    public int D(PersianDate persianDate) {
        return this.f31892a.compareTo(persianDate.x0());
    }

    public boolean D0() {
        return E0(this.f31896e);
    }

    public String E() {
        return F(this);
    }

    public boolean E0(int i2) {
        if (i2 % 4 == 0) {
            return i2 % 100 != 0 || i2 % 400 == 0;
        }
        return false;
    }

    public Date E1() {
        return new Date(this.f31892a.longValue());
    }

    public String F(PersianDate persianDate) {
        return this.o[M(persianDate)];
    }

    public String G() {
        return H(this);
    }

    public PersianDate G0(int i2, int i3, int i4) throws IllegalArgumentException {
        return H0(i2, i3, i4, 0, 0, 0);
    }

    public String H(PersianDate persianDate) {
        return this.f31905n[M(persianDate)];
    }

    public PersianDate H0(int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        if (i2 < 1) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Year must be greater than 0");
        } else if (i3 < 1 || i3 > 12) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Month must be between 1 and 12");
        } else if (i4 < 1 || i4 > 31) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Day must be between 1 and 28~31");
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Hour must be between 0 and 23");
        } else if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Minute must be between 0 and 59");
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Second must be between 0 and 59");
        } else if (i4 <= a0(i2, i3)) {
            this.f31896e = i2;
            this.f31897f = i3;
            this.f31898g = i4;
            this.f31899h = i5;
            this.f31900i = i6;
            this.f31901j = i7;
            C(false);
            return this;
        } else {
            throw new IllegalArgumentException("PersianDate Error: ##=> Day in the " + d0(i3) + " must be between 1 and " + a0(i2, i3));
        }
    }

    public long[] H1() {
        return I1(new PersianDate());
    }

    public String I() {
        return J(this);
    }

    public PersianDate I0(int i2, int i3, int i4) throws IllegalArgumentException {
        return J0(i2, i3, i4, 0, 0, 0);
    }

    public long[] I1(PersianDate persianDate) {
        long abs = Math.abs(this.f31892a.longValue() - persianDate.x0().longValue());
        long j2 = abs / DateUtils.MILLIS_PER_DAY;
        long j3 = abs % DateUtils.MILLIS_PER_DAY;
        long j4 = j3 / DateUtils.MILLIS_PER_HOUR;
        long j5 = j3 % DateUtils.MILLIS_PER_HOUR;
        return new long[]{j2, j4, j5 / 60000, (j5 % 60000) / 1000};
    }

    public String J(PersianDate persianDate) {
        return this.f31904m[M(persianDate)];
    }

    public PersianDate J0(int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        if (i2 < 1) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Year must be greater than 0");
        } else if (i3 < 1 || i3 > 12) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Month must be between 1 and 12");
        } else if (i4 < 1 || i4 > 31) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Day must be between 1 and 28~31");
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Hour must be between 0 and 23");
        } else if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Minute must be between 0 and 59");
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Second must be between 0 and 59");
        } else if (i4 <= l0(Integer.valueOf(i2), Integer.valueOf(i3))) {
            this.f31893b = i2;
            this.f31894c = i3;
            this.f31895d = i4;
            this.f31899h = i5;
            this.f31900i = i6;
            this.f31901j = i7;
            C(true);
            return this;
        } else {
            throw new IllegalArgumentException("PersianDate Error: ##=> Day in the " + W0(i3) + " must be between 1 and " + l0(Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public int K() {
        return M(this);
    }

    public int L(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        if (instance.get(7) == 7) {
            return 0;
        }
        return instance.get(7);
    }

    public int M(PersianDate persianDate) {
        return L(persianDate.E1());
    }

    public boolean M0() {
        return N0(this.f31893b);
    }

    public PersianDate N() {
        return O(this);
    }

    public boolean N0(int i2) {
        double d2 = (double) i2;
        double d3 = 1375.0d;
        double d4 = d2 - 1375.0d;
        int i3 = (d4 > 0.0d ? 1 : (d4 == 0.0d ? 0 : -1));
        if (i3 == 0 || d4 % 33.0d == 0.0d) {
            return true;
        }
        if (i3 <= 0) {
            d3 = d4 > -33.0d ? 1342.0d : 1375.0d - (Math.ceil(Math.abs(d4 / 33.0d)) * 33.0d);
        } else if (d4 > 33.0d) {
            d3 = 1375.0d + (Math.floor(d4 / 33.0d) * 33.0d);
        }
        return Arrays.binarySearch(new double[]{d3, 4.0d + d3, 8.0d + d3, 12.0d + d3, 16.0d + d3, d3 + 20.0d, d3 + 24.0d, d3 + 28.0d, 33.0d + d3}, d2) >= 0;
    }

    public PersianDate O(PersianDate persianDate) {
        persianDate.e1(23).g1(59).h1(59);
        return persianDate;
    }

    public Boolean O0() {
        return Boolean.valueOf(this.f31899h < 12);
    }

    public Boolean P(PersianDate persianDate) {
        return Boolean.valueOf(this.f31892a.equals(persianDate.x0()));
    }

    public Boolean P0(PersianDate persianDate) {
        return persianDate.O0();
    }

    public int Q() {
        return R(this.f31899h);
    }

    public boolean Q0() {
        return R0(this);
    }

    public int R(int i2) {
        return i2 <= 12 ? i2 : i2 - 12;
    }

    public boolean R0(PersianDate persianDate) {
        return persianDate.U() == 0;
    }

    public int S() {
        return T(t0(), s0());
    }

    public int[] S0(int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3;
        int i8 = i2 + 1595;
        int[] iArr = new int[3];
        iArr[0] = 0;
        iArr[1] = 0;
        int i9 = ((i8 * 365) - 355668) + ((i8 / 33) * 8) + (((i8 % 33) + 3) / 4) + i4 + (i7 < 7 ? (i7 - 1) * 31 : ((i7 - 7) * 30) + 186);
        iArr[2] = i9;
        int i10 = (i9 / 146097) * 400;
        iArr[0] = i10;
        int i11 = i9 % 146097;
        iArr[2] = i11;
        if (i11 > 36524) {
            int i12 = i11 - 1;
            iArr[2] = i12;
            iArr[0] = i10 + ((i12 / 36524) * 100);
            int i13 = i12 % 36524;
            iArr[2] = i13;
            if (i13 >= 365) {
                iArr[2] = i13 + 1;
            }
        }
        int i14 = iArr[0];
        int i15 = iArr[2];
        int i16 = i14 + ((i15 / 1461) * 4);
        iArr[0] = i16;
        int i17 = i15 % 1461;
        iArr[2] = i17;
        if (i17 > 365) {
            iArr[0] = i16 + ((i17 - 1) / 365);
            iArr[2] = (i17 - 1) % 365;
        }
        int i18 = iArr[0];
        int[] iArr2 = {0, 31, ((i18 % 4 != 0 || i18 % 100 == 0) && i18 % 400 != 0) ? 28 : 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        iArr[2] = iArr[2] + 1;
        while (true) {
            int i19 = iArr[1];
            if (i19 >= 13 || (i5 = iArr[2]) <= (i6 = iArr2[i19])) {
                return iArr;
            }
            iArr[2] = i5 - i6;
            iArr[1] = i19 + 1;
        }
        return iArr;
    }

    public int T(int i2, int i3) {
        int i4 = 1;
        while (i4 < i2) {
            i3 = i4 <= 6 ? i3 + 31 : i3 + 30;
            i4++;
        }
        return i3;
    }

    public String[] T0() {
        return U0(Dialect.IRANIAN);
    }

    public long U() {
        return V(new PersianDate());
    }

    public String[] U0(Dialect dialect) {
        int i2 = AnonymousClass1.f31906a[dialect.ordinal()];
        if (i2 == 1) {
            return this.q;
        }
        if (i2 == 2) {
            return this.r;
        }
        if (i2 != 3) {
            return i2 != 4 ? this.p : this.t;
        }
        return this.s;
    }

    public long V(PersianDate persianDate) {
        return I1(persianDate)[0];
    }

    public String V0() {
        return Y0(Dialect.IRANIAN);
    }

    public Dialect W() {
        return this.f31903l;
    }

    public String W0(int i2) {
        return X0(i2, W());
    }

    public int X() {
        return this.f31898g;
    }

    public String X0(int i2, Dialect dialect) {
        int i3 = AnonymousClass1.f31906a[dialect.ordinal()];
        if (i3 == 1) {
            return this.q[i2 - 1];
        }
        if (i3 == 2) {
            return this.r[i2 - 1];
        }
        if (i3 != 3) {
            return i3 != 4 ? this.p[i2 - 1] : this.t[i2 - 1];
        }
        return this.s[i2 - 1];
    }

    public int Y() {
        return this.f31897f;
    }

    public String Y0(Dialect dialect) {
        return X0(t0(), dialect);
    }

    public int Z() {
        return b0(E1());
    }

    public String a() {
        return b(t0());
    }

    public int a0(int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i2);
        instance.set(2, i3 - 1);
        return instance.getActualMaximum(5);
    }

    public PersianDate a1(Dialect dialect) {
        this.f31903l = dialect;
        return this;
    }

    public String b(int i2) {
        return this.r[i2 - 1];
    }

    public int b0(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.getActualMaximum(5);
    }

    public PersianDate b1(int i2) throws IllegalArgumentException {
        if (i2 < 1 || i2 > 31) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Day must be between 1 and 28~31");
        } else if (i2 <= Z()) {
            this.f31898g = i2;
            C(false);
            return this;
        } else {
            throw new IllegalArgumentException("PersianDate Error: ##=> Day in the " + c0() + " must be between 1 and " + Z());
        }
    }

    public String c() {
        return d(t0());
    }

    public String c0() {
        return d0(Y());
    }

    public PersianDate c1(int i2) throws IllegalArgumentException {
        if (i2 < 1 || i2 > 12) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Month must be between 1 and 12");
        }
        this.f31897f = i2;
        C(false);
        return this;
    }

    public String d(int i2) {
        return this.q[i2 - 1];
    }

    public String d0(int i2) {
        return (i2 < 1 || i2 > 12) ? "" : this.u[i2 - 1];
    }

    public PersianDate d1(int i2) throws IllegalArgumentException {
        if (i2 >= 1) {
            this.f31896e = i2;
            C(false);
            return this;
        }
        throw new IllegalArgumentException("PersianDate Error: ##=> Year must be greater than 0");
    }

    public String e() {
        return f(t0());
    }

    public int e0() {
        return this.f31896e;
    }

    public PersianDate e1(int i2) throws IllegalArgumentException {
        if (i2 < 0 || i2 > 23) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Hour must be between 0 and 23");
        }
        this.f31899h = i2;
        C(false);
        return this;
    }

    public String f(int i2) {
        return this.s[i2 - 1];
    }

    public int f0() {
        return this.f31899h;
    }

    public PersianDate f1(Locale locale) {
        this.f31902k = locale;
        return this;
    }

    public String g() {
        return h(t0());
    }

    public Locale g0() {
        return this.f31902k;
    }

    public PersianDate g1(int i2) throws IllegalArgumentException {
        if (i2 < 0 || i2 > 59) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Minute must be between 0 and 59");
        }
        this.f31900i = i2;
        C(false);
        return this;
    }

    public String h(int i2) {
        return this.t[i2 - 1];
    }

    public int h0() {
        return this.f31900i;
    }

    public PersianDate h1(int i2) throws IllegalArgumentException {
        if (i2 < 0 || i2 > 59) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Second must be between 0 and 59");
        }
        this.f31901j = i2;
        C(false);
        return this;
    }

    public int i0() {
        return j0(u0(), t0());
    }

    public PersianDate i1(int i2) throws IllegalArgumentException {
        if (i2 < 1 || i2 > 31) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Day must be between 1 and 29~31");
        } else if (i2 <= k0()) {
            this.f31895d = i2;
            C(true);
            return this;
        } else {
            throw new IllegalArgumentException("PersianDate Error: ##=> Day in the " + n0() + " must be between 1 and " + k0());
        }
    }

    public int j0(int i2, int i3) {
        if (i3 != 12 || N0(i2)) {
            return i3 <= 6 ? 31 : 30;
        }
        return 29;
    }

    public PersianDate j1(int i2) throws IllegalArgumentException {
        if (i2 < 1 || i2 > 12) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Month must be between 1 and 12");
        }
        this.f31894c = i2;
        C(true);
        return this;
    }

    public PersianDate k(long j2, long j3, long j4) {
        return l(j2, j3, j4, 0, 0, 0);
    }

    public int k0() {
        return m0(this);
    }

    public PersianDate k1(int i2) throws IllegalArgumentException {
        if (i2 >= 1) {
            this.f31893b = i2;
            C(true);
            return this;
        }
        throw new IllegalArgumentException("PersianDate Error: ##=> Year must be greater than 0");
    }

    public PersianDate l(long j2, long j3, long j4, long j5, long j6, long j7) throws IllegalArgumentException {
        long j8;
        long j9 = j2;
        long j10 = j3;
        long j11 = j4;
        long j12 = j5;
        long j13 = j6;
        long j14 = j7;
        Calendar instance = Calendar.getInstance();
        instance.setTime(E1());
        if (j9 >= 1) {
            instance.add(1, (int) j9);
            j8 = 1;
        } else {
            j8 = 1;
        }
        if (j10 >= j8) {
            instance.add(2, (int) j10);
        }
        if (j11 >= j8) {
            instance.add(5, (int) j11);
        }
        if (j12 >= j8) {
            instance.add(11, (int) j12);
        }
        if (j13 >= j8) {
            instance.add(12, (int) j13);
        }
        if (j14 >= j8) {
            instance.add(13, (int) j14);
        }
        this.f31892a = Long.valueOf(instance.getTimeInMillis());
        F0();
        return this;
    }

    public int l0(Integer num, Integer num2) {
        if (num2.intValue() <= 6) {
            return 31;
        }
        return (num2.intValue() > 11 && !N0(num.intValue())) ? 29 : 30;
    }

    public PersianDate l1() {
        return m1(this);
    }

    public PersianDate m() {
        return n(1);
    }

    public int m0(PersianDate persianDate) {
        return l0(Integer.valueOf(persianDate.u0()), Integer.valueOf(persianDate.t0()));
    }

    public PersianDate m1(PersianDate persianDate) {
        persianDate.e1(0).g1(0).h1(0);
        return persianDate;
    }

    public PersianDate n(int i2) {
        return k(0, 0, (long) i2);
    }

    public String n0() {
        return p0(this);
    }

    public PersianDate n1(long j2, long j3, long j4) {
        return o1(j2, j3, j4, 0, 0, 0);
    }

    public PersianDate o() {
        return p(1);
    }

    public String o0(Dialect dialect) {
        return t0() > U0(dialect).length ? "" : U0(dialect)[t0() - 1];
    }

    public PersianDate o1(long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j2;
        long j9 = j3;
        long j10 = j4;
        long j11 = j5;
        long j12 = j6;
        long j13 = j7;
        Calendar instance = Calendar.getInstance();
        instance.setTime(E1());
        if (j8 >= 1) {
            instance.add(1, (int) (-j8));
        }
        if (j9 >= 1) {
            instance.add(2, (int) (-j9));
        }
        if (j10 >= 1) {
            instance.add(5, (int) (-j10));
        }
        if (j11 >= 1) {
            instance.add(11, (int) (-j11));
        }
        if (j12 >= 1) {
            instance.add(12, (int) (-j12));
        }
        if (j13 >= 1) {
            instance.add(13, (int) (-j13));
        }
        this.f31892a = Long.valueOf(instance.getTimeInMillis());
        F0();
        return this;
    }

    public PersianDate p(int i2) {
        return l(0, 0, 0, (long) i2, 0, 0);
    }

    public String p0(PersianDate persianDate) {
        return persianDate.t0() > persianDate.T0().length ? "" : persianDate.T0()[persianDate.t0() - 1];
    }

    public PersianDate p1() {
        return q1(1);
    }

    public PersianDate q() {
        return r(1);
    }

    public String q0(PersianDate persianDate, Dialect dialect) {
        return persianDate.t0() > persianDate.U0(dialect).length ? "" : persianDate.U0(dialect)[persianDate.t0() - 1];
    }

    public PersianDate q1(int i2) {
        return n1(0, 0, (long) i2);
    }

    public PersianDate r(int i2) {
        return l(0, 0, 0, 0, (long) i2, 0);
    }

    public int r0() {
        return this.f31901j;
    }

    public PersianDate r1() {
        return s1(1);
    }

    public PersianDate s() {
        return t(1);
    }

    public int s0() {
        return this.f31895d;
    }

    public PersianDate s1(int i2) {
        return o1(0, 0, 0, (long) i2, 0, 0);
    }

    public PersianDate t(int i2) {
        return k(0, (long) i2, 0);
    }

    public int t0() {
        return this.f31894c;
    }

    public PersianDate t1() {
        return u1(1);
    }

    public String toString() {
        return PersianDateFormat.c(this, (String) null);
    }

    public PersianDate u() {
        return v(1);
    }

    public int u0() {
        return this.f31893b;
    }

    public PersianDate u1(int i2) {
        return o1(0, 0, 0, 0, (long) i2, 0);
    }

    public PersianDate v(int i2) {
        return l(0, 0, 0, 0, 0, (long) i2);
    }

    public String v0() {
        return O0().booleanValue() ? J : K;
    }

    public PersianDate v1() {
        return w1(1);
    }

    public PersianDate w() {
        return x(1);
    }

    public String w0(PersianDate persianDate) {
        return persianDate.O0().booleanValue() ? J : K;
    }

    public PersianDate w1(int i2) {
        return n1(0, (long) i2, 0);
    }

    public PersianDate x(int i2) {
        return n(i2 * 7);
    }

    public Long x0() {
        return this.f31892a;
    }

    public PersianDate x1() {
        return y1(1);
    }

    public PersianDate y() {
        return z(1);
    }

    public String y0() {
        return O0().booleanValue() ? L : M;
    }

    public PersianDate y1(int i2) {
        return o1(0, 0, 0, 0, 0, (long) i2);
    }

    public PersianDate z(int i2) {
        return k((long) i2, 0, 0);
    }

    public String z0(PersianDate persianDate) {
        return persianDate.O0().booleanValue() ? L : M;
    }

    public PersianDate z1() {
        return A1(1);
    }

    public PersianDate(Long l2) {
        this.f31902k = Locale.getDefault();
        this.f31903l = Dialect.IRANIAN;
        this.f31904m = new String[]{"شنبه", "یک‌شنبه", "دوشنبه", "سه‌شنبه", "چهارشنبه", "پنج‌شنبه", "جمعه"};
        this.f31905n = new String[]{"Shanbe", "Yekshanbe", "Doshanbe", "Seshanbe", "Chaharshanbe", "Panjshanbe", "Jom'e"};
        this.o = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        this.p = new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
        this.q = new String[]{"Farvardin", "Ordibehesht", "Khordad", "Tir", "Mordad", "Shahrivar", "Mehr", "Aban", "Azar", "Day", "Bahman", "Esfand"};
        this.r = new String[]{"حمل", "ثور", "جوزا", "سرطان", "اسد", "سنبله", "میزان", "عقرب", "قوس", "جدی", "دلو", "حوت"};
        this.s = new String[]{"جیژنان", "گولان", "زه ردان", "په رپه ر", "گه لاویژ", "نوخشان", "به ران", "خه زان", "ساران", "بفران", "به ندان", "رمشان"};
        this.t = new String[]{"وری", "غويی", "غبرګولی", "چنګاښ", "زمری", "وږی", "تله", "لړم", "ليندۍ", "مرغومی", "سلواغه", "كب"};
        this.u = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.f31892a = l2;
        F0();
    }

    public PersianDate(Date date) {
        this.f31902k = Locale.getDefault();
        this.f31903l = Dialect.IRANIAN;
        this.f31904m = new String[]{"شنبه", "یک‌شنبه", "دوشنبه", "سه‌شنبه", "چهارشنبه", "پنج‌شنبه", "جمعه"};
        this.f31905n = new String[]{"Shanbe", "Yekshanbe", "Doshanbe", "Seshanbe", "Chaharshanbe", "Panjshanbe", "Jom'e"};
        this.o = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        this.p = new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
        this.q = new String[]{"Farvardin", "Ordibehesht", "Khordad", "Tir", "Mordad", "Shahrivar", "Mehr", "Aban", "Azar", "Day", "Bahman", "Esfand"};
        this.r = new String[]{"حمل", "ثور", "جوزا", "سرطان", "اسد", "سنبله", "میزان", "عقرب", "قوس", "جدی", "دلو", "حوت"};
        this.s = new String[]{"جیژنان", "گولان", "زه ردان", "په رپه ر", "گه لاویژ", "نوخشان", "به ران", "خه زان", "ساران", "بفران", "به ندان", "رمشان"};
        this.t = new String[]{"وری", "غويی", "غبرګولی", "چنګاښ", "زمری", "وږی", "تله", "لړم", "ليندۍ", "مرغومی", "سلواغه", "كب"};
        this.u = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.f31892a = Long.valueOf(date.getTime());
        F0();
    }
}
