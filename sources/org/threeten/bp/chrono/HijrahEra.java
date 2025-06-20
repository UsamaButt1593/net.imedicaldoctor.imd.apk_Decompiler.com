package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public enum HijrahEra implements Era {
    BEFORE_AH,
    AH;

    public static HijrahEra j(int i2) {
        if (i2 == 0) {
            return BEFORE_AH;
        }
        if (i2 == 1) {
            return AH;
        }
        throw new DateTimeException("HijrahEra not valid");
    }

    static HijrahEra s(DataInput dataInput) throws IOException {
        return j(dataInput.readByte());
    }

    private Object v() {
        return new Ser((byte) 4, this);
    }

    public int b(TemporalField temporalField) {
        return temporalField == ChronoField.ERA ? getValue() : f(temporalField).a(p(temporalField), temporalField);
    }

    public String c(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().r(ChronoField.ERA, textStyle).Q(locale).d(this);
    }

    public Temporal e(Temporal temporal) {
        return temporal.a(ChronoField.ERA, (long) getValue());
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return ValueRange.k(1, 1);
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.f(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int getValue() {
        return ordinal();
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.ERAS;
        }
        if (temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    /* access modifiers changed from: package-private */
    public int k(int i2) {
        return this == AH ? i2 : 1 - i2;
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.ERA : temporalField != null && temporalField.c(this);
    }

    public long p(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return (long) getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    /* access modifiers changed from: package-private */
    public void u(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(getValue());
    }
}
