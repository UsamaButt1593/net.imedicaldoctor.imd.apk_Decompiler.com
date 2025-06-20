package org.threeten.bp.chrono;

import androidx.lifecycle.g;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.jdk8.DefaultInterfaceEra;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

public final class JapaneseEra extends DefaultInterfaceEra implements Serializable {
    public static final JapaneseEra X2;
    public static final JapaneseEra Y2;
    static final int Z = 2;
    public static final JapaneseEra Z2;
    public static final JapaneseEra a3;
    private static final int b3 = 3;
    private static final long c3 = 1466499369062886794L;
    private static final AtomicReference<JapaneseEra[]> d3;
    private final transient LocalDate X;
    private final transient String Y;
    private final int s;

    static {
        JapaneseEra japaneseEra = new JapaneseEra(-1, LocalDate.r2(1868, 9, 8), "Meiji");
        X2 = japaneseEra;
        JapaneseEra japaneseEra2 = new JapaneseEra(0, LocalDate.r2(1912, 7, 30), "Taisho");
        Y2 = japaneseEra2;
        JapaneseEra japaneseEra3 = new JapaneseEra(1, LocalDate.r2(1926, 12, 25), "Showa");
        Z2 = japaneseEra3;
        JapaneseEra japaneseEra4 = new JapaneseEra(2, LocalDate.r2(1989, 1, 8), "Heisei");
        a3 = japaneseEra4;
        d3 = new AtomicReference<>(new JapaneseEra[]{japaneseEra, japaneseEra2, japaneseEra3, japaneseEra4});
    }

    private JapaneseEra(int i2, LocalDate localDate, String str) {
        this.s = i2;
        this.X = localDate;
        this.Y = str;
    }

    public static JapaneseEra D(String str) {
        Jdk8Methods.j(str, "japaneseEra");
        for (JapaneseEra japaneseEra : d3.get()) {
            if (str.equals(japaneseEra.Y)) {
                return japaneseEra;
            }
        }
        throw new IllegalArgumentException("Era not found: " + str);
    }

    public static JapaneseEra[] E() {
        JapaneseEra[] japaneseEraArr = d3.get();
        return (JapaneseEra[]) Arrays.copyOf(japaneseEraArr, japaneseEraArr.length);
    }

    private Object J() {
        return new Ser((byte) 2, this);
    }

    static JapaneseEra u(LocalDate localDate) {
        if (!localDate.A(X2.X)) {
            JapaneseEra[] japaneseEraArr = d3.get();
            for (int length = japaneseEraArr.length - 1; length >= 0; length--) {
                JapaneseEra japaneseEra = japaneseEraArr[length];
                if (localDate.compareTo(japaneseEra.X) >= 0) {
                    return japaneseEra;
                }
            }
            return null;
        }
        throw new DateTimeException("Date too early: " + localDate);
    }

    public static JapaneseEra v(int i2) {
        JapaneseEra[] japaneseEraArr = d3.get();
        if (i2 >= X2.s && i2 <= japaneseEraArr[japaneseEraArr.length - 1].s) {
            return japaneseEraArr[w(i2)];
        }
        throw new DateTimeException("japaneseEra is invalid");
    }

    private static int w(int i2) {
        return i2 + 1;
    }

    static JapaneseEra x(DataInput dataInput) throws IOException {
        return v(dataInput.readByte());
    }

    private Object y() throws ObjectStreamException {
        try {
            return v(this.s);
        } catch (DateTimeException e2) {
            InvalidObjectException invalidObjectException = new InvalidObjectException("Invalid era");
            invalidObjectException.initCause(e2);
            throw invalidObjectException;
        }
    }

    public static JapaneseEra z(LocalDate localDate, String str) {
        AtomicReference<JapaneseEra[]> atomicReference = d3;
        JapaneseEra[] japaneseEraArr = atomicReference.get();
        if (japaneseEraArr.length <= 4) {
            Jdk8Methods.j(localDate, "since");
            Jdk8Methods.j(str, "name");
            if (localDate.z(a3.X)) {
                JapaneseEra japaneseEra = new JapaneseEra(3, localDate, str);
                JapaneseEra[] japaneseEraArr2 = (JapaneseEra[]) Arrays.copyOf(japaneseEraArr, 5);
                japaneseEraArr2[4] = japaneseEra;
                if (g.a(atomicReference, japaneseEraArr, japaneseEraArr2)) {
                    return japaneseEra;
                }
                throw new DateTimeException("Only one additional Japanese era can be added");
            }
            throw new DateTimeException("Invalid since date for additional Japanese era, must be after Heisei");
        }
        throw new DateTimeException("Only one additional Japanese era can be added");
    }

    /* access modifiers changed from: package-private */
    public LocalDate A() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public void F(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(getValue());
    }

    public ValueRange f(TemporalField temporalField) {
        ChronoField chronoField = ChronoField.ERA;
        return temporalField == chronoField ? JapaneseChronology.Y2.E(chronoField) : super.f(temporalField);
    }

    public int getValue() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public LocalDate s() {
        int w = w(this.s);
        JapaneseEra[] E = E();
        return w >= E.length + -1 ? LocalDate.Y2 : E[w + 1].A().e2(1);
    }

    public String toString() {
        return this.Y;
    }
}
