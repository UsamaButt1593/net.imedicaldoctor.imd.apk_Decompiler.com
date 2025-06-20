package org.threeten.bp.chrono;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

final class ChronoPeriodImpl extends ChronoPeriod implements Serializable {
    private static final long X2 = 275618735781L;
    private final int X;
    private final int Y;
    private final int Z;
    private final Chronology s;

    public ChronoPeriodImpl(Chronology chronology, int i2, int i3, int i4) {
        this.s = chronology;
        this.X = i2;
        this.Y = i3;
        this.Z = i4;
    }

    public Temporal a(Temporal temporal) {
        Jdk8Methods.j(temporal, "temporal");
        Chronology chronology = (Chronology) temporal.i(TemporalQueries.a());
        if (chronology == null || this.s.equals(chronology)) {
            int i2 = this.X;
            if (i2 != 0) {
                temporal = temporal.o((long) i2, ChronoUnit.YEARS);
            }
            int i3 = this.Y;
            if (i3 != 0) {
                temporal = temporal.o((long) i3, ChronoUnit.MONTHS);
            }
            int i4 = this.Z;
            return i4 != 0 ? temporal.o((long) i4, ChronoUnit.DAYS) : temporal;
        }
        throw new DateTimeException("Invalid chronology, required: " + this.s.v() + ", but was: " + chronology.v());
    }

    public Temporal b(Temporal temporal) {
        Jdk8Methods.j(temporal, "temporal");
        Chronology chronology = (Chronology) temporal.i(TemporalQueries.a());
        if (chronology == null || this.s.equals(chronology)) {
            int i2 = this.X;
            if (i2 != 0) {
                temporal = temporal.q((long) i2, ChronoUnit.YEARS);
            }
            int i3 = this.Y;
            if (i3 != 0) {
                temporal = temporal.q((long) i3, ChronoUnit.MONTHS);
            }
            int i4 = this.Z;
            return i4 != 0 ? temporal.q((long) i4, ChronoUnit.DAYS) : temporal;
        }
        throw new DateTimeException("Invalid chronology, required: " + this.s.v() + ", but was: " + chronology.v());
    }

    public List<TemporalUnit> c() {
        return Collections.unmodifiableList(Arrays.asList(new TemporalUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public long e(TemporalUnit temporalUnit) {
        int i2;
        if (temporalUnit == ChronoUnit.YEARS) {
            i2 = this.X;
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            i2 = this.Y;
        } else if (temporalUnit == ChronoUnit.DAYS) {
            i2 = this.Z;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return (long) i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoPeriodImpl)) {
            return false;
        }
        ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) obj;
        return this.X == chronoPeriodImpl.X && this.Y == chronoPeriodImpl.Y && this.Z == chronoPeriodImpl.Z && this.s.equals(chronoPeriodImpl.s);
    }

    public Chronology f() {
        return this.s;
    }

    public int hashCode() {
        return this.s.hashCode() + Integer.rotateLeft(this.X, 16) + Integer.rotateLeft(this.Y, 8) + this.Z;
    }

    public ChronoPeriod i(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) temporalAmount;
            if (chronoPeriodImpl.f().equals(f())) {
                return new ChronoPeriodImpl(this.s, Jdk8Methods.p(this.X, chronoPeriodImpl.X), Jdk8Methods.p(this.Y, chronoPeriodImpl.Y), Jdk8Methods.p(this.Z, chronoPeriodImpl.Z));
            }
        }
        throw new DateTimeException("Unable to subtract amount: " + temporalAmount);
    }

    public ChronoPeriod j(int i2) {
        return new ChronoPeriodImpl(this.s, Jdk8Methods.m(this.X, i2), Jdk8Methods.m(this.Y, i2), Jdk8Methods.m(this.Z, i2));
    }

    public ChronoPeriod l() {
        Chronology chronology = this.s;
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        if (!chronology.E(chronoField).g()) {
            return this;
        }
        long d2 = (this.s.E(chronoField).d() - this.s.E(chronoField).e()) + 1;
        long j2 = (((long) this.X) * d2) + ((long) this.Y);
        return new ChronoPeriodImpl(this.s, Jdk8Methods.r(j2 / d2), Jdk8Methods.r(j2 % d2), this.Z);
    }

    public ChronoPeriod m(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) temporalAmount;
            if (chronoPeriodImpl.f().equals(f())) {
                return new ChronoPeriodImpl(this.s, Jdk8Methods.k(this.X, chronoPeriodImpl.X), Jdk8Methods.k(this.Y, chronoPeriodImpl.Y), Jdk8Methods.k(this.Z, chronoPeriodImpl.Z));
            }
        }
        throw new DateTimeException("Unable to add amount: " + temporalAmount);
    }

    public String toString() {
        if (h()) {
            return this.s + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.s);
        sb.append(' ');
        sb.append('P');
        int i2 = this.X;
        if (i2 != 0) {
            sb.append(i2);
            sb.append(ASCIIPropertyListParser.v);
        }
        int i3 = this.Y;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        int i4 = this.Z;
        if (i4 != 0) {
            sb.append(i4);
            sb.append(ASCIIPropertyListParser.t);
        }
        return sb.toString();
    }
}
