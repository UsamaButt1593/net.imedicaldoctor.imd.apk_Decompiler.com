package org.threeten.bp.chrono;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.zone.ZoneOffsetTransition;

final class ChronoZonedDateTimeImpl<D extends ChronoLocalDate> extends ChronoZonedDateTime<D> implements Serializable {
    private static final long X2 = -5261813987200935591L;
    private final ChronoLocalDateTimeImpl<D> X;
    private final ZoneOffset Y;
    private final ZoneId Z;

    /* renamed from: org.threeten.bp.chrono.ChronoZonedDateTimeImpl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31790a;

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
                f31790a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31790a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoZonedDateTimeImpl.AnonymousClass1.<clinit>():void");
        }
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.X = (ChronoLocalDateTimeImpl) Jdk8Methods.j(chronoLocalDateTimeImpl, "dateTime");
        this.Y = (ZoneOffset) Jdk8Methods.j(zoneOffset, TypedValues.CycleType.R);
        this.Z = (ZoneId) Jdk8Methods.j(zoneId, "zone");
    }

    private ChronoZonedDateTimeImpl<D> G0(Instant instant, ZoneId zoneId) {
        return L0(U().x(), instant, zoneId);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        if (r2.contains(r8) != false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <R extends org.threeten.bp.chrono.ChronoLocalDate> org.threeten.bp.chrono.ChronoZonedDateTime<R> K0(org.threeten.bp.chrono.ChronoLocalDateTimeImpl<R> r6, org.threeten.bp.ZoneId r7, org.threeten.bp.ZoneOffset r8) {
        /*
            java.lang.String r0 = "localDateTime"
            org.threeten.bp.jdk8.Jdk8Methods.j(r6, r0)
            java.lang.String r0 = "zone"
            org.threeten.bp.jdk8.Jdk8Methods.j(r7, r0)
            boolean r0 = r7 instanceof org.threeten.bp.ZoneOffset
            if (r0 == 0) goto L_0x0017
            org.threeten.bp.chrono.ChronoZonedDateTimeImpl r8 = new org.threeten.bp.chrono.ChronoZonedDateTimeImpl
            r0 = r7
            org.threeten.bp.ZoneOffset r0 = (org.threeten.bp.ZoneOffset) r0
            r8.<init>(r6, r0, r7)
            return r8
        L_0x0017:
            org.threeten.bp.zone.ZoneRules r0 = r7.u()
            org.threeten.bp.LocalDateTime r1 = org.threeten.bp.LocalDateTime.v0(r6)
            java.util.List r2 = r0.h(r1)
            int r3 = r2.size()
            r4 = 1
            r5 = 0
            if (r3 != r4) goto L_0x0032
        L_0x002b:
            java.lang.Object r8 = r2.get(r5)
            org.threeten.bp.ZoneOffset r8 = (org.threeten.bp.ZoneOffset) r8
            goto L_0x0055
        L_0x0032:
            int r3 = r2.size()
            if (r3 != 0) goto L_0x004d
            org.threeten.bp.zone.ZoneOffsetTransition r8 = r0.e(r1)
            org.threeten.bp.Duration r0 = r8.e()
            long r0 = r0.o()
            org.threeten.bp.chrono.ChronoLocalDateTimeImpl r6 = r6.G0(r0)
            org.threeten.bp.ZoneOffset r8 = r8.h()
            goto L_0x0055
        L_0x004d:
            if (r8 == 0) goto L_0x002b
            boolean r0 = r2.contains(r8)
            if (r0 == 0) goto L_0x002b
        L_0x0055:
            java.lang.String r0 = "offset"
            org.threeten.bp.jdk8.Jdk8Methods.j(r8, r0)
            org.threeten.bp.chrono.ChronoZonedDateTimeImpl r0 = new org.threeten.bp.chrono.ChronoZonedDateTimeImpl
            r0.<init>(r6, r8, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoZonedDateTimeImpl.K0(org.threeten.bp.chrono.ChronoLocalDateTimeImpl, org.threeten.bp.ZoneId, org.threeten.bp.ZoneOffset):org.threeten.bp.chrono.ChronoZonedDateTime");
    }

    static <R extends ChronoLocalDate> ChronoZonedDateTimeImpl<R> L0(Chronology chronology, Instant instant, ZoneId zoneId) {
        ZoneOffset b2 = zoneId.u().b(instant);
        Jdk8Methods.j(b2, TypedValues.CycleType.R);
        return new ChronoZonedDateTimeImpl<>((ChronoLocalDateTimeImpl) chronology.y(LocalDateTime.q2(instant.y(), instant.z(), b2)), b2, zoneId);
    }

    static ChronoZonedDateTime<?> R0(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        return ((ChronoLocalDateTime) objectInput.readObject()).s((ZoneOffset) objectInput.readObject()).D0((ZoneId) objectInput.readObject());
    }

    private Object S0() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object Y0() {
        return new Ser((byte) 13, this);
    }

    public ChronoZonedDateTime<D> C0(ZoneId zoneId) {
        Jdk8Methods.j(zoneId, "zone");
        return this.Z.equals(zoneId) ? this : G0(this.X.Q(this.Y), zoneId);
    }

    public ChronoZonedDateTime<D> D0(ZoneId zoneId) {
        return K0(this.X, zoneId, this.Y);
    }

    /* renamed from: J */
    public ChronoZonedDateTime<D> q(long j2, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? l(this.X.q(j2, temporalUnit)) : U().x().n(temporalUnit.g(this, j2));
    }

    public ChronoLocalDateTime<D> c0() {
        return this.X;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && compareTo((ChronoZonedDateTime) obj) == 0;
    }

    public int hashCode() {
        return (c0().hashCode() ^ x().hashCode()) ^ Integer.rotateLeft(y().hashCode(), 3);
    }

    public boolean m(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.c(this));
    }

    public boolean n(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.a() || temporalUnit.b() : temporalUnit != null && temporalUnit.f(this);
    }

    /* renamed from: q0 */
    public ChronoZonedDateTime<D> a(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return U().x().n(temporalField.e(this, j2));
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i2 = AnonymousClass1.f31790a[chronoField.ordinal()];
        if (i2 == 1) {
            return q(j2 - Q(), ChronoUnit.SECONDS);
        }
        if (i2 != 2) {
            return K0(this.X.h0(temporalField, j2), this.Z, this.Y);
        }
        return G0(this.X.Q(ZoneOffset.L(chronoField.m(j2))), this.Z);
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        ChronoZonedDateTime<?> P = U().x().P(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.e(this, P);
        }
        return this.X.r(P.C0(this.Y).c0(), temporalUnit);
    }

    public ChronoZonedDateTime<D> r0() {
        ZoneOffsetTransition e2 = y().u().e(LocalDateTime.v0(this));
        if (e2 != null && e2.l()) {
            ZoneOffset i2 = e2.i();
            if (!i2.equals(this.Y)) {
                return new ChronoZonedDateTimeImpl(this.X, i2, this.Z);
            }
        }
        return this;
    }

    public String toString() {
        String str = c0().toString() + x().toString();
        if (x() == y()) {
            return str;
        }
        return str + '[' + y().toString() + ']';
    }

    public ChronoZonedDateTime<D> v0() {
        ZoneOffsetTransition e2 = y().u().e(LocalDateTime.v0(this));
        if (e2 != null) {
            ZoneOffset h2 = e2.h();
            if (!h2.equals(x())) {
                return new ChronoZonedDateTimeImpl(this.X, h2, this.Z);
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.X);
        objectOutput.writeObject(this.Y);
        objectOutput.writeObject(this.Z);
    }

    public ZoneOffset x() {
        return this.Y;
    }

    public ZoneId y() {
        return this.Z;
    }
}
