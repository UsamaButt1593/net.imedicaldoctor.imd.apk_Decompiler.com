package org.threeten.bp.zone;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.html.HTML;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class ZoneOffsetTransitionRule implements Serializable {
    private static final long c3 = 6889046316657758795L;
    private final byte X;
    private final boolean X2;
    private final DayOfWeek Y;
    private final TimeDefinition Y2;
    private final LocalTime Z;
    private final ZoneOffset Z2;
    private final ZoneOffset a3;
    private final ZoneOffset b3;
    private final Month s;

    /* renamed from: org.threeten.bp.zone.ZoneOffsetTransitionRule$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31876a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.threeten.bp.zone.ZoneOffsetTransitionRule$TimeDefinition[] r0 = org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31876a = r0
                org.threeten.bp.zone.ZoneOffsetTransitionRule$TimeDefinition r1 = org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.UTC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31876a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.zone.ZoneOffsetTransitionRule$TimeDefinition r1 = org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.STANDARD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.ZoneOffsetTransitionRule.AnonymousClass1.<clinit>():void");
        }
    }

    public enum TimeDefinition {
        UTC,
        WALL,
        STANDARD;

        public LocalDateTime a(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
            long F;
            int i2 = AnonymousClass1.f31876a[ordinal()];
            if (i2 == 1) {
                F = (long) (zoneOffset2.F() - ZoneOffset.g3.F());
            } else if (i2 != 2) {
                return localDateTime;
            } else {
                F = (long) (zoneOffset2.F() - zoneOffset.F());
            }
            return localDateTime.M2(F);
        }
    }

    ZoneOffsetTransitionRule(Month month, int i2, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.s = month;
        this.X = (byte) i2;
        this.Y = dayOfWeek;
        this.Z = localTime;
        this.X2 = z;
        this.Y2 = timeDefinition;
        this.Z2 = zoneOffset;
        this.a3 = zoneOffset2;
        this.b3 = zoneOffset3;
    }

    public static ZoneOffsetTransitionRule k(Month month, int i2, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        int i3 = i2;
        LocalTime localTime2 = localTime;
        Month month2 = month;
        Jdk8Methods.j(month, "month");
        Jdk8Methods.j(localTime, HTML.Tag.P0);
        Jdk8Methods.j(timeDefinition, "timeDefnition");
        Jdk8Methods.j(zoneOffset, "standardOffset");
        Jdk8Methods.j(zoneOffset2, "offsetBefore");
        Jdk8Methods.j(zoneOffset3, "offsetAfter");
        if (i3 < -28 || i3 > 31 || i3 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        } else if (!z || localTime.equals(LocalTime.Z2)) {
            return new ZoneOffsetTransitionRule(month, i2, dayOfWeek, localTime, z, timeDefinition, zoneOffset, zoneOffset2, zoneOffset3);
        } else {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
    }

    static ZoneOffsetTransitionRule l(DataInput dataInput) throws IOException {
        int readInt = dataInput.readInt();
        Month y = Month.y(readInt >>> 28);
        int i2 = ((264241152 & readInt) >>> 22) - 32;
        int i3 = (3670016 & readInt) >>> 19;
        DayOfWeek s2 = i3 == 0 ? null : DayOfWeek.s(i3);
        int i4 = (507904 & readInt) >>> 14;
        TimeDefinition timeDefinition = TimeDefinition.values()[(readInt & 12288) >>> 12];
        int i5 = (readInt & 4080) >>> 4;
        int i6 = (readInt & 12) >>> 2;
        int i7 = readInt & 3;
        LocalTime C0 = i4 == 31 ? LocalTime.C0((long) dataInput.readInt()) : LocalTime.k0(i4 % 24, 0);
        ZoneOffset L = ZoneOffset.L(i5 == 255 ? dataInput.readInt() : (i5 - 128) * TypedValues.Custom.f3957j);
        return k(y, i2, s2, C0, i4 == 24, timeDefinition, L, ZoneOffset.L(i6 == 3 ? dataInput.readInt() : L.F() + (i6 * 1800)), ZoneOffset.L(i7 == 3 ? dataInput.readInt() : L.F() + (i7 * 1800)));
    }

    private Object n() {
        return new Ser((byte) 3, this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.zone.ZoneOffsetTransition a(int r5) {
        /*
            r4 = this;
            byte r0 = r4.X
            if (r0 >= 0) goto L_0x0027
            org.threeten.bp.Month r0 = r4.s
            org.threeten.bp.chrono.IsoChronology r1 = org.threeten.bp.chrono.IsoChronology.X2
            long r2 = (long) r5
            boolean r1 = r1.x(r2)
            int r1 = r0.u(r1)
            int r1 = r1 + 1
            byte r2 = r4.X
            int r1 = r1 + r2
            org.threeten.bp.LocalDate r5 = org.threeten.bp.LocalDate.u2(r5, r0, r1)
            org.threeten.bp.DayOfWeek r0 = r4.Y
            if (r0 == 0) goto L_0x0036
            org.threeten.bp.temporal.TemporalAdjuster r0 = org.threeten.bp.temporal.TemporalAdjusters.m(r0)
        L_0x0022:
            org.threeten.bp.LocalDate r5 = r5.l(r0)
            goto L_0x0036
        L_0x0027:
            org.threeten.bp.Month r1 = r4.s
            org.threeten.bp.LocalDate r5 = org.threeten.bp.LocalDate.u2(r5, r1, r0)
            org.threeten.bp.DayOfWeek r0 = r4.Y
            if (r0 == 0) goto L_0x0036
            org.threeten.bp.temporal.TemporalAdjuster r0 = org.threeten.bp.temporal.TemporalAdjusters.k(r0)
            goto L_0x0022
        L_0x0036:
            boolean r0 = r4.X2
            if (r0 == 0) goto L_0x0040
            r0 = 1
            org.threeten.bp.LocalDate r5 = r5.J2(r0)
        L_0x0040:
            org.threeten.bp.LocalTime r0 = r4.Z
            org.threeten.bp.LocalDateTime r5 = org.threeten.bp.LocalDateTime.p2(r5, r0)
            org.threeten.bp.zone.ZoneOffsetTransitionRule$TimeDefinition r0 = r4.Y2
            org.threeten.bp.ZoneOffset r1 = r4.Z2
            org.threeten.bp.ZoneOffset r2 = r4.a3
            org.threeten.bp.LocalDateTime r5 = r0.a(r5, r1, r2)
            org.threeten.bp.zone.ZoneOffsetTransition r0 = new org.threeten.bp.zone.ZoneOffsetTransition
            org.threeten.bp.ZoneOffset r1 = r4.a3
            org.threeten.bp.ZoneOffset r2 = r4.b3
            r0.<init>((org.threeten.bp.LocalDateTime) r5, (org.threeten.bp.ZoneOffset) r1, (org.threeten.bp.ZoneOffset) r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.ZoneOffsetTransitionRule.a(int):org.threeten.bp.zone.ZoneOffsetTransition");
    }

    public int b() {
        return this.X;
    }

    public DayOfWeek c() {
        return this.Y;
    }

    public LocalTime d() {
        return this.Z;
    }

    public Month e() {
        return this.s;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransitionRule)) {
            return false;
        }
        ZoneOffsetTransitionRule zoneOffsetTransitionRule = (ZoneOffsetTransitionRule) obj;
        return this.s == zoneOffsetTransitionRule.s && this.X == zoneOffsetTransitionRule.X && this.Y == zoneOffsetTransitionRule.Y && this.Y2 == zoneOffsetTransitionRule.Y2 && this.Z.equals(zoneOffsetTransitionRule.Z) && this.X2 == zoneOffsetTransitionRule.X2 && this.Z2.equals(zoneOffsetTransitionRule.Z2) && this.a3.equals(zoneOffsetTransitionRule.a3) && this.b3.equals(zoneOffsetTransitionRule.b3);
    }

    public ZoneOffset f() {
        return this.b3;
    }

    public ZoneOffset g() {
        return this.a3;
    }

    public ZoneOffset h() {
        return this.Z2;
    }

    public int hashCode() {
        int k1 = ((this.Z.k1() + (this.X2 ? 1 : 0)) << 15) + (this.s.ordinal() << 11) + ((this.X + 32) << 5);
        DayOfWeek dayOfWeek = this.Y;
        return ((((k1 + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)) + this.Y2.ordinal()) ^ this.Z2.hashCode()) ^ this.a3.hashCode()) ^ this.b3.hashCode();
    }

    public TimeDefinition i() {
        return this.Y2;
    }

    public boolean j() {
        return this.X2;
    }

    /* access modifiers changed from: package-private */
    public void m(DataOutput dataOutput) throws IOException {
        int k1 = this.X2 ? 86400 : this.Z.k1();
        int F = this.Z2.F();
        int F2 = this.a3.F() - F;
        int F3 = this.b3.F() - F;
        int A1 = k1 % 3600 == 0 ? this.X2 ? 24 : this.Z.A1() : 31;
        int i2 = F % TypedValues.Custom.f3957j == 0 ? (F / TypedValues.Custom.f3957j) + 128 : 255;
        int i3 = (F2 == 0 || F2 == 1800 || F2 == 3600) ? F2 / 1800 : 3;
        int i4 = (F3 == 0 || F3 == 1800 || F3 == 3600) ? F3 / 1800 : 3;
        DayOfWeek dayOfWeek = this.Y;
        dataOutput.writeInt((this.s.getValue() << 28) + ((this.X + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.getValue()) << 19) + (A1 << 14) + (this.Y2.ordinal() << 12) + (i2 << 4) + (i3 << 2) + i4);
        if (A1 == 31) {
            dataOutput.writeInt(k1);
        }
        if (i2 == 255) {
            dataOutput.writeInt(F);
        }
        if (i3 == 3) {
            dataOutput.writeInt(this.a3.F());
        }
        if (i4 == 3) {
            dataOutput.writeInt(this.b3.F());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "TransitionRule["
            r0.append(r1)
            org.threeten.bp.ZoneOffset r1 = r5.a3
            org.threeten.bp.ZoneOffset r2 = r5.b3
            int r1 = r1.compareTo(r2)
            if (r1 <= 0) goto L_0x0017
            java.lang.String r1 = "Gap "
            goto L_0x0019
        L_0x0017:
            java.lang.String r1 = "Overlap "
        L_0x0019:
            r0.append(r1)
            org.threeten.bp.ZoneOffset r1 = r5.a3
            r0.append(r1)
            java.lang.String r1 = " to "
            r0.append(r1)
            org.threeten.bp.ZoneOffset r1 = r5.b3
            r0.append(r1)
            java.lang.String r1 = ", "
            r0.append(r1)
            org.threeten.bp.DayOfWeek r1 = r5.Y
            r2 = 32
            if (r1 == 0) goto L_0x0068
            byte r3 = r5.X
            r4 = -1
            java.lang.String r1 = r1.name()
            r0.append(r1)
            if (r3 != r4) goto L_0x0051
            java.lang.String r1 = " on or before last day of "
        L_0x0044:
            r0.append(r1)
            org.threeten.bp.Month r1 = r5.s
            java.lang.String r1 = r1.name()
            r0.append(r1)
            goto L_0x0079
        L_0x0051:
            if (r3 >= 0) goto L_0x0063
            java.lang.String r1 = " on or before last day minus "
            r0.append(r1)
            byte r1 = r5.X
            int r1 = -r1
            int r1 = r1 + -1
            r0.append(r1)
            java.lang.String r1 = " of "
            goto L_0x0044
        L_0x0063:
            java.lang.String r1 = " on or after "
            r0.append(r1)
        L_0x0068:
            org.threeten.bp.Month r1 = r5.s
            java.lang.String r1 = r1.name()
            r0.append(r1)
            r0.append(r2)
            byte r1 = r5.X
            r0.append(r1)
        L_0x0079:
            java.lang.String r1 = " at "
            r0.append(r1)
            boolean r1 = r5.X2
            if (r1 == 0) goto L_0x0085
            java.lang.String r1 = "24:00"
            goto L_0x008b
        L_0x0085:
            org.threeten.bp.LocalTime r1 = r5.Z
            java.lang.String r1 = r1.toString()
        L_0x008b:
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            org.threeten.bp.zone.ZoneOffsetTransitionRule$TimeDefinition r1 = r5.Y2
            r0.append(r1)
            java.lang.String r1 = ", standard offset "
            r0.append(r1)
            org.threeten.bp.ZoneOffset r1 = r5.Z2
            r0.append(r1)
            r1 = 93
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.ZoneOffsetTransitionRule.toString():java.lang.String");
    }
}
