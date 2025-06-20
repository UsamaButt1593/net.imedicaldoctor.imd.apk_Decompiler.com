package org.threeten.bp;

import com.google.common.primitives.SignedBytes;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class MonthDay extends DefaultInterfaceTemporalAccessor implements TemporalAccessor, TemporalAdjuster, Comparable<MonthDay>, Serializable {
    private static final DateTimeFormatter X2 = new DateTimeFormatterBuilder().i("--").u(ChronoField.MONTH_OF_YEAR, 2).h('-').u(ChronoField.DAY_OF_MONTH, 2).P();
    public static final TemporalQuery<MonthDay> Y = new TemporalQuery<MonthDay>() {
        /* renamed from: b */
        public MonthDay a(TemporalAccessor temporalAccessor) {
            return MonthDay.w(temporalAccessor);
        }
    };
    private static final long Z = -939150713474957432L;
    private final int X;
    private final int s;

    /* renamed from: org.threeten.bp.MonthDay$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31779a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31779a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31779a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.MonthDay.AnonymousClass2.<clinit>():void");
        }
    }

    private MonthDay(int i2, int i3) {
        this.s = i2;
        this.X = i3;
    }

    private Object C0() {
        return new Ser(SignedBytes.f22967a, this);
    }

    public static MonthDay F() {
        return J(Clock.g());
    }

    public static MonthDay J(Clock clock) {
        LocalDate p2 = LocalDate.p2(clock);
        return Q(p2.l1(), p2.h1());
    }

    public static MonthDay K(ZoneId zoneId) {
        return J(Clock.f(zoneId));
    }

    public static MonthDay L(int i2, int i3) {
        return Q(Month.y(i2), i3);
    }

    public static MonthDay Q(Month month, int i2) {
        Jdk8Methods.j(month, "month");
        ChronoField.DAY_OF_MONTH.n((long) i2);
        if (i2 <= month.v()) {
            return new MonthDay(month.getValue(), i2);
        }
        throw new DateTimeException("Illegal value for DayOfMonth field, value " + i2 + " is not valid for month " + month.name());
    }

    public static MonthDay S(CharSequence charSequence) {
        return U(charSequence, X2);
    }

    public static MonthDay U(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return (MonthDay) dateTimeFormatter.r(charSequence, Y);
    }

    static MonthDay c0(DataInput dataInput) throws IOException {
        return L(dataInput.readByte(), dataInput.readByte());
    }

    private Object h0() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static MonthDay w(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof MonthDay) {
            return (MonthDay) temporalAccessor;
        }
        try {
            if (!IsoChronology.X2.equals(Chronology.q(temporalAccessor))) {
                temporalAccessor = LocalDate.c1(temporalAccessor);
            }
            return L(temporalAccessor.b(ChronoField.MONTH_OF_YEAR), temporalAccessor.b(ChronoField.DAY_OF_MONTH));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public boolean A(MonthDay monthDay) {
        return compareTo(monthDay) > 0;
    }

    public boolean D(MonthDay monthDay) {
        return compareTo(monthDay) < 0;
    }

    public boolean E(int i2) {
        return !(this.X == 29 && this.s == 2 && !Year.F((long) i2));
    }

    public int b(TemporalField temporalField) {
        return f(temporalField).a(p(temporalField), temporalField);
    }

    public Temporal e(Temporal temporal) {
        if (Chronology.q(temporal).equals(IsoChronology.X2)) {
            Temporal a2 = temporal.a(ChronoField.MONTH_OF_YEAR, (long) this.s);
            ChronoField chronoField = ChronoField.DAY_OF_MONTH;
            return a2.a(chronoField, Math.min(a2.f(chronoField).d(), (long) this.X));
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonthDay)) {
            return false;
        }
        MonthDay monthDay = (MonthDay) obj;
        return this.s == monthDay.s && this.X == monthDay.X;
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            return temporalField.h();
        }
        return temporalField == ChronoField.DAY_OF_MONTH ? ValueRange.l(1, (long) y().w(), (long) y().v()) : super.f(temporalField);
    }

    public int hashCode() {
        return (this.s << 6) + this.X;
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.a() ? IsoChronology.X2 : super.i(temporalQuery);
    }

    public MonthDay k0(Month month) {
        Jdk8Methods.j(month, "month");
        if (month.getValue() == this.s) {
            return this;
        }
        return new MonthDay(month.getValue(), Math.min(this.X, month.v()));
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.DAY_OF_MONTH : temporalField != null && temporalField.c(this);
    }

    public long p(TemporalField temporalField) {
        int i2;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        int i3 = AnonymousClass2.f31779a[((ChronoField) temporalField).ordinal()];
        if (i3 == 1) {
            i2 = this.X;
        } else if (i3 == 2) {
            i2 = this.s;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return (long) i2;
    }

    public MonthDay q0(int i2) {
        return i2 == this.X ? this : L(this.s, i2);
    }

    public MonthDay r0(int i2) {
        return k0(Month.y(i2));
    }

    public LocalDate s(int i2) {
        return LocalDate.r2(i2, this.s, E(i2) ? this.X : 28);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.s < 10 ? "0" : "");
        sb.append(this.s);
        sb.append(this.X < 10 ? "-0" : "-");
        sb.append(this.X);
        return sb.toString();
    }

    /* renamed from: u */
    public int compareTo(MonthDay monthDay) {
        int i2 = this.s - monthDay.s;
        return i2 == 0 ? this.X - monthDay.X : i2;
    }

    public String v(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    /* access modifiers changed from: package-private */
    public void v0(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.s);
        dataOutput.writeByte(this.X);
    }

    public int x() {
        return this.X;
    }

    public Month y() {
        return Month.y(this.s);
    }

    public int z() {
        return this.s;
    }
}
