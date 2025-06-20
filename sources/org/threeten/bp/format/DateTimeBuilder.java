package org.threeten.bp.format;

import androidx.media3.common.C;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

final class DateTimeBuilder extends DefaultInterfaceTemporalAccessor implements TemporalAccessor, Cloneable {
    Chronology X;
    LocalTime X2;
    ZoneId Y;
    boolean Y2;
    ChronoLocalDate Z;
    Period Z2;
    final Map<TemporalField, Long> s = new HashMap();

    public DateTimeBuilder() {
    }

    private Long A(TemporalField temporalField) {
        return this.s.get(temporalField);
    }

    private void D(ResolverStyle resolverStyle) {
        if (this.X instanceof IsoChronology) {
            x(IsoChronology.X2.J(this.s, resolverStyle));
            return;
        }
        Map<TemporalField, Long> map = this.s;
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            x(LocalDate.w2(this.s.remove(chronoField).longValue()));
        }
    }

    private void E() {
        if (this.s.containsKey(ChronoField.INSTANT_SECONDS)) {
            ZoneId zoneId = this.Y;
            if (zoneId == null) {
                Long l2 = this.s.get(ChronoField.OFFSET_SECONDS);
                if (l2 != null) {
                    zoneId = ZoneOffset.L(l2.intValue());
                } else {
                    return;
                }
            }
            F(zoneId);
        }
    }

    private void F(ZoneId zoneId) {
        Map<TemporalField, Long> map = this.s;
        ChronoField chronoField = ChronoField.INSTANT_SECONDS;
        ChronoZonedDateTime O = this.X.O(Instant.h0(map.remove(chronoField).longValue()), zoneId);
        if (this.Z == null) {
            v(O.U());
        } else {
            h0(chronoField, O.U());
        }
        s(ChronoField.SECOND_OF_DAY, (long) O.h0().k1());
    }

    private void J(ResolverStyle resolverStyle) {
        ChronoField chronoField;
        long j2;
        Map<TemporalField, Long> map = this.s;
        ChronoField chronoField2 = ChronoField.CLOCK_HOUR_OF_DAY;
        long j3 = 0;
        if (map.containsKey(chronoField2)) {
            long longValue = this.s.remove(chronoField2).longValue();
            if (!(resolverStyle == ResolverStyle.LENIENT || (resolverStyle == ResolverStyle.SMART && longValue == 0))) {
                chronoField2.n(longValue);
            }
            ChronoField chronoField3 = ChronoField.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            s(chronoField3, longValue);
        }
        Map<TemporalField, Long> map2 = this.s;
        ChronoField chronoField4 = ChronoField.CLOCK_HOUR_OF_AMPM;
        if (map2.containsKey(chronoField4)) {
            long longValue2 = this.s.remove(chronoField4).longValue();
            if (!(resolverStyle == ResolverStyle.LENIENT || (resolverStyle == ResolverStyle.SMART && longValue2 == 0))) {
                chronoField4.n(longValue2);
            }
            ChronoField chronoField5 = ChronoField.HOUR_OF_AMPM;
            if (longValue2 != 12) {
                j3 = longValue2;
            }
            s(chronoField5, j3);
        }
        ResolverStyle resolverStyle2 = ResolverStyle.LENIENT;
        if (resolverStyle != resolverStyle2) {
            Map<TemporalField, Long> map3 = this.s;
            ChronoField chronoField6 = ChronoField.AMPM_OF_DAY;
            if (map3.containsKey(chronoField6)) {
                chronoField6.n(this.s.get(chronoField6).longValue());
            }
            Map<TemporalField, Long> map4 = this.s;
            ChronoField chronoField7 = ChronoField.HOUR_OF_AMPM;
            if (map4.containsKey(chronoField7)) {
                chronoField7.n(this.s.get(chronoField7).longValue());
            }
        }
        Map<TemporalField, Long> map5 = this.s;
        ChronoField chronoField8 = ChronoField.AMPM_OF_DAY;
        if (map5.containsKey(chronoField8)) {
            Map<TemporalField, Long> map6 = this.s;
            ChronoField chronoField9 = ChronoField.HOUR_OF_AMPM;
            if (map6.containsKey(chronoField9)) {
                s(ChronoField.HOUR_OF_DAY, (this.s.remove(chronoField8).longValue() * 12) + this.s.remove(chronoField9).longValue());
            }
        }
        Map<TemporalField, Long> map7 = this.s;
        ChronoField chronoField10 = ChronoField.NANO_OF_DAY;
        if (map7.containsKey(chronoField10)) {
            long longValue3 = this.s.remove(chronoField10).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField10.n(longValue3);
            }
            s(ChronoField.SECOND_OF_DAY, longValue3 / C.f9093k);
            s(ChronoField.NANO_OF_SECOND, longValue3 % C.f9093k);
        }
        Map<TemporalField, Long> map8 = this.s;
        ChronoField chronoField11 = ChronoField.MICRO_OF_DAY;
        if (map8.containsKey(chronoField11)) {
            long longValue4 = this.s.remove(chronoField11).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField11.n(longValue4);
            }
            s(ChronoField.SECOND_OF_DAY, longValue4 / 1000000);
            s(ChronoField.MICRO_OF_SECOND, longValue4 % 1000000);
        }
        Map<TemporalField, Long> map9 = this.s;
        ChronoField chronoField12 = ChronoField.MILLI_OF_DAY;
        if (map9.containsKey(chronoField12)) {
            long longValue5 = this.s.remove(chronoField12).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField12.n(longValue5);
            }
            s(ChronoField.SECOND_OF_DAY, longValue5 / 1000);
            s(ChronoField.MILLI_OF_SECOND, longValue5 % 1000);
        }
        Map<TemporalField, Long> map10 = this.s;
        ChronoField chronoField13 = ChronoField.SECOND_OF_DAY;
        if (map10.containsKey(chronoField13)) {
            long longValue6 = this.s.remove(chronoField13).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField13.n(longValue6);
            }
            s(ChronoField.HOUR_OF_DAY, longValue6 / 3600);
            s(ChronoField.MINUTE_OF_HOUR, (longValue6 / 60) % 60);
            s(ChronoField.SECOND_OF_MINUTE, longValue6 % 60);
        }
        Map<TemporalField, Long> map11 = this.s;
        ChronoField chronoField14 = ChronoField.MINUTE_OF_DAY;
        if (map11.containsKey(chronoField14)) {
            long longValue7 = this.s.remove(chronoField14).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField14.n(longValue7);
            }
            s(ChronoField.HOUR_OF_DAY, longValue7 / 60);
            s(ChronoField.MINUTE_OF_HOUR, longValue7 % 60);
        }
        if (resolverStyle != resolverStyle2) {
            Map<TemporalField, Long> map12 = this.s;
            ChronoField chronoField15 = ChronoField.MILLI_OF_SECOND;
            if (map12.containsKey(chronoField15)) {
                chronoField15.n(this.s.get(chronoField15).longValue());
            }
            Map<TemporalField, Long> map13 = this.s;
            ChronoField chronoField16 = ChronoField.MICRO_OF_SECOND;
            if (map13.containsKey(chronoField16)) {
                chronoField16.n(this.s.get(chronoField16).longValue());
            }
        }
        Map<TemporalField, Long> map14 = this.s;
        ChronoField chronoField17 = ChronoField.MILLI_OF_SECOND;
        if (map14.containsKey(chronoField17)) {
            Map<TemporalField, Long> map15 = this.s;
            ChronoField chronoField18 = ChronoField.MICRO_OF_SECOND;
            if (map15.containsKey(chronoField18)) {
                s(chronoField18, (this.s.remove(chronoField17).longValue() * 1000) + (this.s.get(chronoField18).longValue() % 1000));
            }
        }
        Map<TemporalField, Long> map16 = this.s;
        ChronoField chronoField19 = ChronoField.MICRO_OF_SECOND;
        if (map16.containsKey(chronoField19)) {
            Map<TemporalField, Long> map17 = this.s;
            ChronoField chronoField20 = ChronoField.NANO_OF_SECOND;
            if (map17.containsKey(chronoField20)) {
                s(chronoField19, this.s.get(chronoField20).longValue() / 1000);
                this.s.remove(chronoField19);
            }
        }
        if (this.s.containsKey(chronoField17)) {
            Map<TemporalField, Long> map18 = this.s;
            ChronoField chronoField21 = ChronoField.NANO_OF_SECOND;
            if (map18.containsKey(chronoField21)) {
                s(chronoField17, this.s.get(chronoField21).longValue() / 1000000);
                this.s.remove(chronoField17);
            }
        }
        if (this.s.containsKey(chronoField19)) {
            long longValue8 = this.s.remove(chronoField19).longValue();
            chronoField = ChronoField.NANO_OF_SECOND;
            j2 = longValue8 * 1000;
        } else if (this.s.containsKey(chronoField17)) {
            long longValue9 = this.s.remove(chronoField17).longValue();
            chronoField = ChronoField.NANO_OF_SECOND;
            j2 = longValue9 * 1000000;
        } else {
            return;
        }
        s(chronoField, j2);
    }

    private DateTimeBuilder K(TemporalField temporalField, long j2) {
        this.s.put(temporalField, Long.valueOf(j2));
        return this;
    }

    private boolean Q(ResolverStyle resolverStyle) {
        int i2 = 0;
        loop0:
        while (i2 < 100) {
            for (Map.Entry<TemporalField, Long> key : this.s.entrySet()) {
                TemporalField temporalField = (TemporalField) key.getKey();
                Object l2 = temporalField.l(this.s, this, resolverStyle);
                if (l2 != null) {
                    if (l2 instanceof ChronoZonedDateTime) {
                        ChronoZonedDateTime chronoZonedDateTime = (ChronoZonedDateTime) l2;
                        ZoneId zoneId = this.Y;
                        if (zoneId == null) {
                            this.Y = chronoZonedDateTime.y();
                        } else if (!zoneId.equals(chronoZonedDateTime.y())) {
                            throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.Y);
                        }
                        l2 = chronoZonedDateTime.c0();
                    }
                    if (l2 instanceof ChronoLocalDate) {
                        h0(temporalField, (ChronoLocalDate) l2);
                    } else if (l2 instanceof LocalTime) {
                        c0(temporalField, (LocalTime) l2);
                    } else if (l2 instanceof ChronoLocalDateTime) {
                        ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) l2;
                        h0(temporalField, chronoLocalDateTime.S());
                        c0(temporalField, chronoLocalDateTime.U());
                    } else {
                        throw new DateTimeException("Unknown type: " + l2.getClass().getName());
                    }
                } else if (!this.s.containsKey(temporalField)) {
                }
                i2++;
            }
        }
        if (i2 != 100) {
            return i2 > 0;
        }
        throw new DateTimeException("Badly written field");
    }

    private void S() {
        if (this.X2 != null) {
            return;
        }
        if (this.s.containsKey(ChronoField.INSTANT_SECONDS) || this.s.containsKey(ChronoField.SECOND_OF_DAY) || this.s.containsKey(ChronoField.SECOND_OF_MINUTE)) {
            Map<TemporalField, Long> map = this.s;
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            if (map.containsKey(chronoField)) {
                long longValue = this.s.get(chronoField).longValue();
                this.s.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(longValue / 1000));
                this.s.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(longValue / 1000000));
                return;
            }
            this.s.put(chronoField, 0L);
            this.s.put(ChronoField.MICRO_OF_SECOND, 0L);
            this.s.put(ChronoField.MILLI_OF_SECOND, 0L);
        }
    }

    private void U() {
        ChronoZonedDateTime<?> s2;
        if (this.Z != null && this.X2 != null) {
            Long l2 = this.s.get(ChronoField.OFFSET_SECONDS);
            if (l2 != null) {
                s2 = this.Z.s(this.X2).s(ZoneOffset.L(l2.intValue()));
            } else if (this.Y != null) {
                s2 = this.Z.s(this.X2).s(this.Y);
            } else {
                return;
            }
            ChronoField chronoField = ChronoField.INSTANT_SECONDS;
            this.s.put(chronoField, Long.valueOf(s2.p(chronoField)));
        }
    }

    private void c0(TemporalField temporalField, LocalTime localTime) {
        long j1 = localTime.j1();
        Long put = this.s.put(ChronoField.NANO_OF_DAY, Long.valueOf(j1));
        if (put != null && put.longValue() != j1) {
            throw new DateTimeException("Conflict found: " + LocalTime.v0(put.longValue()) + " differs from " + localTime + " while resolving  " + temporalField);
        }
    }

    private void h0(TemporalField temporalField, ChronoLocalDate chronoLocalDate) {
        if (this.X.equals(chronoLocalDate.x())) {
            long c0 = chronoLocalDate.c0();
            Long put = this.s.put(ChronoField.EPOCH_DAY, Long.valueOf(c0));
            if (put != null && put.longValue() != c0) {
                throw new DateTimeException("Conflict found: " + LocalDate.w2(put.longValue()) + " differs from " + LocalDate.w2(c0) + " while resolving  " + temporalField);
            }
            return;
        }
        throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.X);
    }

    private void k0(ResolverStyle resolverStyle) {
        int r;
        LocalTime k0;
        LocalTime k02;
        ResolverStyle resolverStyle2 = resolverStyle;
        Map<TemporalField, Long> map = this.s;
        ChronoField chronoField = ChronoField.HOUR_OF_DAY;
        Long l2 = map.get(chronoField);
        Map<TemporalField, Long> map2 = this.s;
        ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
        Long l3 = map2.get(chronoField2);
        Map<TemporalField, Long> map3 = this.s;
        ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
        Long l4 = map3.get(chronoField3);
        Map<TemporalField, Long> map4 = this.s;
        ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
        Long l5 = map4.get(chronoField4);
        if (l2 != null) {
            if (l3 == null && (l4 != null || l5 != null)) {
                return;
            }
            if (l3 == null || l4 != null || l5 == null) {
                if (resolverStyle2 != ResolverStyle.LENIENT) {
                    if (resolverStyle2 == ResolverStyle.SMART && l2.longValue() == 24 && ((l3 == null || l3.longValue() == 0) && ((l4 == null || l4.longValue() == 0) && (l5 == null || l5.longValue() == 0)))) {
                        l2 = 0L;
                        this.Z2 = Period.B(1);
                    }
                    int m2 = chronoField.m(l2.longValue());
                    if (l3 != null) {
                        int m3 = chronoField2.m(l3.longValue());
                        if (l4 != null) {
                            int m4 = chronoField3.m(l4.longValue());
                            k02 = l5 != null ? LocalTime.r0(m2, m3, m4, chronoField4.m(l5.longValue())) : LocalTime.q0(m2, m3, m4);
                        } else if (l5 == null) {
                            k02 = LocalTime.k0(m2, m3);
                        }
                    } else if (l4 == null && l5 == null) {
                        k02 = LocalTime.k0(m2, 0);
                    }
                    u(k02);
                } else {
                    long longValue = l2.longValue();
                    if (l3 == null) {
                        r = Jdk8Methods.r(Jdk8Methods.e(longValue, 24));
                        k0 = LocalTime.k0((int) ((long) Jdk8Methods.g(longValue, 24)), 0);
                    } else if (l4 != null) {
                        if (l5 == null) {
                            l5 = 0L;
                        }
                        long l6 = Jdk8Methods.l(Jdk8Methods.l(Jdk8Methods.l(Jdk8Methods.o(longValue, 3600000000000L), Jdk8Methods.o(l3.longValue(), 60000000000L)), Jdk8Methods.o(l4.longValue(), C.f9093k)), l5.longValue());
                        r = (int) Jdk8Methods.e(l6, 86400000000000L);
                        k0 = LocalTime.v0(Jdk8Methods.h(l6, 86400000000000L));
                    } else {
                        long l7 = Jdk8Methods.l(Jdk8Methods.o(longValue, 3600), Jdk8Methods.o(l3.longValue(), 60));
                        r = (int) Jdk8Methods.e(l7, 86400);
                        k0 = LocalTime.C0(Jdk8Methods.h(l7, 86400));
                    }
                    u(k0);
                    this.Z2 = Period.B(r);
                }
                this.s.remove(chronoField);
                this.s.remove(chronoField2);
                this.s.remove(chronoField3);
                this.s.remove(chronoField4);
            }
        }
    }

    private void x(LocalDate localDate) {
        if (localDate != null) {
            v(localDate);
            for (TemporalField next : this.s.keySet()) {
                if ((next instanceof ChronoField) && next.a()) {
                    try {
                        long p = localDate.p(next);
                        Long l2 = this.s.get(next);
                        if (p != l2.longValue()) {
                            throw new DateTimeException("Conflict found: Field " + next + StringUtils.SPACE + p + " differs from " + next + StringUtils.SPACE + l2 + " derived from " + localDate);
                        }
                    } catch (DateTimeException unused) {
                        continue;
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [org.threeten.bp.LocalTime] */
    /* JADX WARNING: type inference failed for: r0v5, types: [org.threeten.bp.chrono.ChronoLocalDateTime] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void y() {
        /*
            r2 = this;
            java.util.Map<org.threeten.bp.temporal.TemporalField, java.lang.Long> r0 = r2.s
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0020
            org.threeten.bp.chrono.ChronoLocalDate r0 = r2.Z
            if (r0 == 0) goto L_0x0018
            org.threeten.bp.LocalTime r1 = r2.X2
            if (r1 == 0) goto L_0x0018
            org.threeten.bp.chrono.ChronoLocalDateTime r0 = r0.s(r1)
        L_0x0014:
            r2.z(r0)
            goto L_0x0020
        L_0x0018:
            if (r0 == 0) goto L_0x001b
        L_0x001a:
            goto L_0x0014
        L_0x001b:
            org.threeten.bp.LocalTime r0 = r2.X2
            if (r0 == 0) goto L_0x0020
            goto L_0x001a
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeBuilder.y():void");
    }

    private void z(TemporalAccessor temporalAccessor) {
        Iterator<Map.Entry<TemporalField, Long>> it2 = this.s.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            TemporalField temporalField = (TemporalField) next.getKey();
            long longValue = ((Long) next.getValue()).longValue();
            if (temporalAccessor.m(temporalField)) {
                try {
                    long p = temporalAccessor.p(temporalField);
                    if (p == longValue) {
                        it2.remove();
                    } else {
                        throw new DateTimeException("Cross check failed: " + temporalField + StringUtils.SPACE + p + " vs " + temporalField + StringUtils.SPACE + longValue);
                    }
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    public DateTimeBuilder L(ResolverStyle resolverStyle, Set<TemporalField> set) {
        ChronoLocalDate chronoLocalDate;
        if (set != null) {
            this.s.keySet().retainAll(set);
        }
        E();
        D(resolverStyle);
        J(resolverStyle);
        if (Q(resolverStyle)) {
            E();
            D(resolverStyle);
            J(resolverStyle);
        }
        k0(resolverStyle);
        y();
        Period period = this.Z2;
        if (!(period == null || period.h() || (chronoLocalDate = this.Z) == null || this.X2 == null)) {
            this.Z = chronoLocalDate.h(this.Z2);
            this.Z2 = Period.Z;
        }
        S();
        U();
        return this;
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.g()) {
            return this.Y;
        }
        if (temporalQuery == TemporalQueries.a()) {
            return this.X;
        }
        if (temporalQuery == TemporalQueries.b()) {
            ChronoLocalDate chronoLocalDate = this.Z;
            if (chronoLocalDate != null) {
                return LocalDate.c1(chronoLocalDate);
            }
            return null;
        } else if (temporalQuery == TemporalQueries.c()) {
            return this.X2;
        } else {
            if (temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.d()) {
                return temporalQuery.a(this);
            }
            if (temporalQuery == TemporalQueries.e()) {
                return null;
            }
            return temporalQuery.a(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r1 = r2.Z;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r1 = r2.X2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m(org.threeten.bp.temporal.TemporalField r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Map<org.threeten.bp.temporal.TemporalField, java.lang.Long> r1 = r2.s
            boolean r1 = r1.containsKey(r3)
            if (r1 != 0) goto L_0x0020
            org.threeten.bp.chrono.ChronoLocalDate r1 = r2.Z
            if (r1 == 0) goto L_0x0016
            boolean r1 = r1.m(r3)
            if (r1 != 0) goto L_0x0020
        L_0x0016:
            org.threeten.bp.LocalTime r1 = r2.X2
            if (r1 == 0) goto L_0x0021
            boolean r3 = r1.m(r3)
            if (r3 == 0) goto L_0x0021
        L_0x0020:
            r0 = 1
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeBuilder.m(org.threeten.bp.temporal.TemporalField):boolean");
    }

    public long p(TemporalField temporalField) {
        Jdk8Methods.j(temporalField, "field");
        Long A = A(temporalField);
        if (A != null) {
            return A.longValue();
        }
        ChronoLocalDate chronoLocalDate = this.Z;
        if (chronoLocalDate != null && chronoLocalDate.m(temporalField)) {
            return this.Z.p(temporalField);
        }
        LocalTime localTime = this.X2;
        if (localTime != null && localTime.m(temporalField)) {
            return this.X2.p(temporalField);
        }
        throw new DateTimeException("Field not found: " + temporalField);
    }

    /* access modifiers changed from: package-private */
    public DateTimeBuilder s(TemporalField temporalField, long j2) {
        Jdk8Methods.j(temporalField, "field");
        Long A = A(temporalField);
        if (A == null || A.longValue() == j2) {
            return K(temporalField, j2);
        }
        throw new DateTimeException("Conflict found: " + temporalField + StringUtils.SPACE + A + " differs from " + temporalField + StringUtils.SPACE + j2 + ": " + this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("DateTimeBuilder[");
        if (this.s.size() > 0) {
            sb.append("fields=");
            sb.append(this.s);
        }
        sb.append(", ");
        sb.append(this.X);
        sb.append(", ");
        sb.append(this.Y);
        sb.append(", ");
        sb.append(this.Z);
        sb.append(", ");
        sb.append(this.X2);
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void u(LocalTime localTime) {
        this.X2 = localTime;
    }

    /* access modifiers changed from: package-private */
    public void v(ChronoLocalDate chronoLocalDate) {
        this.Z = chronoLocalDate;
    }

    public <R> R w(TemporalQuery<R> temporalQuery) {
        return temporalQuery.a(this);
    }

    public DateTimeBuilder(TemporalField temporalField, long j2) {
        s(temporalField, j2);
    }
}
