package org.threeten.bp.zone;

import androidx.media3.common.PlaybackException;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.zone.ZoneOffsetTransitionRule;

class ZoneRulesBuilder {

    /* renamed from: a  reason: collision with root package name */
    private List<TZWindow> f31877a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Map<Object, Object> f31878b;

    class TZRule implements Comparable<TZRule> {
        /* access modifiers changed from: private */
        public Month X;
        /* access modifiers changed from: private */
        public LocalTime X2;
        /* access modifiers changed from: private */
        public int Y;
        /* access modifiers changed from: private */
        public boolean Y2;
        /* access modifiers changed from: private */
        public DayOfWeek Z;
        /* access modifiers changed from: private */
        public ZoneOffsetTransitionRule.TimeDefinition Z2;
        /* access modifiers changed from: private */
        public int a3;
        /* access modifiers changed from: private */
        public int s;

        TZRule(int i2, Month month, int i3, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i4) {
            this.s = i2;
            this.X = month;
            this.Y = i3;
            this.Z = dayOfWeek;
            this.X2 = localTime;
            this.Y2 = z;
            this.Z2 = timeDefinition;
            this.a3 = i4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private org.threeten.bp.LocalDate l() {
            /*
                r4 = this;
                int r0 = r4.Y
                if (r0 >= 0) goto L_0x0029
                org.threeten.bp.Month r0 = r4.X
                org.threeten.bp.chrono.IsoChronology r1 = org.threeten.bp.chrono.IsoChronology.X2
                int r2 = r4.s
                long r2 = (long) r2
                boolean r1 = r1.x(r2)
                int r0 = r0.u(r1)
                int r1 = r4.s
                org.threeten.bp.Month r2 = r4.X
                int r0 = r0 + 1
                int r3 = r4.Y
                int r0 = r0 + r3
                org.threeten.bp.LocalDate r0 = org.threeten.bp.LocalDate.u2(r1, r2, r0)
                org.threeten.bp.DayOfWeek r1 = r4.Z
                if (r1 == 0) goto L_0x003d
                org.threeten.bp.temporal.TemporalAdjuster r1 = org.threeten.bp.temporal.TemporalAdjusters.m(r1)
                goto L_0x0039
            L_0x0029:
                int r1 = r4.s
                org.threeten.bp.Month r2 = r4.X
                org.threeten.bp.LocalDate r0 = org.threeten.bp.LocalDate.u2(r1, r2, r0)
                org.threeten.bp.DayOfWeek r1 = r4.Z
                if (r1 == 0) goto L_0x003d
                org.threeten.bp.temporal.TemporalAdjuster r1 = org.threeten.bp.temporal.TemporalAdjusters.k(r1)
            L_0x0039:
                org.threeten.bp.LocalDate r0 = r0.l(r1)
            L_0x003d:
                boolean r1 = r4.Y2
                if (r1 == 0) goto L_0x0047
                r1 = 1
                org.threeten.bp.LocalDate r0 = r0.J2(r1)
            L_0x0047:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.ZoneRulesBuilder.TZRule.l():org.threeten.bp.LocalDate");
        }

        /* renamed from: k */
        public int compareTo(TZRule tZRule) {
            int i2 = this.s - tZRule.s;
            if (i2 == 0) {
                i2 = this.X.compareTo(tZRule.X);
            }
            if (i2 == 0) {
                i2 = l().compareTo(tZRule.l());
            }
            return i2 == 0 ? this.X2.compareTo(tZRule.X2) : i2;
        }

        /* access modifiers changed from: package-private */
        public ZoneOffsetTransition m(ZoneOffset zoneOffset, int i2) {
            LocalDate l2 = l();
            ZoneOffset zoneOffset2 = (ZoneOffset) ZoneRulesBuilder.this.f(ZoneOffset.L(zoneOffset.F() + i2));
            return new ZoneOffsetTransition((LocalDateTime) ZoneRulesBuilder.this.f(this.Z2.a((LocalDateTime) ZoneRulesBuilder.this.f(LocalDateTime.p2((LocalDate) ZoneRulesBuilder.this.f(l2), this.X2)), zoneOffset, zoneOffset2)), zoneOffset2, (ZoneOffset) ZoneRulesBuilder.this.f(ZoneOffset.L(zoneOffset.F() + this.a3)));
        }

        /* access modifiers changed from: package-private */
        public ZoneOffsetTransitionRule n(ZoneOffset zoneOffset, int i2) {
            int i3;
            Month month;
            if (this.Y < 0 && (month = this.X) != Month.FEBRUARY) {
                this.Y = month.v() - 6;
            }
            if (this.Y2 && (i3 = this.Y) > 0 && !(i3 == 28 && this.X == Month.FEBRUARY)) {
                LocalDate J2 = LocalDate.u2(PlaybackException.e3, this.X, i3).J2(1);
                this.X = J2.l1();
                this.Y = J2.h1();
                DayOfWeek dayOfWeek = this.Z;
                if (dayOfWeek != null) {
                    this.Z = dayOfWeek.u(1);
                }
                this.Y2 = false;
            }
            ZoneOffsetTransition m2 = m(zoneOffset, i2);
            return new ZoneOffsetTransitionRule(this.X, this.Y, this.Z, this.X2, this.Y2, this.Z2, zoneOffset, m2.i(), m2.h());
        }
    }

    class TZWindow {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final ZoneOffset f31879a;

        /* renamed from: b  reason: collision with root package name */
        private final LocalDateTime f31880b;

        /* renamed from: c  reason: collision with root package name */
        private final ZoneOffsetTransitionRule.TimeDefinition f31881c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Integer f31882d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public List<TZRule> f31883e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        private int f31884f = Year.X;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public List<TZRule> f31885g = new ArrayList();

        TZWindow(ZoneOffset zoneOffset, LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition) {
            this.f31880b = localDateTime;
            this.f31881c = timeDefinition;
            this.f31879a = zoneOffset;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, int i3, Month month, int i4, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i5) {
            boolean z2;
            if (this.f31882d != null) {
                throw new IllegalStateException("Window has a fixed DST saving, so cannot have DST rules");
            } else if (this.f31883e.size() < 2000) {
                int i6 = i3;
                if (i6 == 999999999) {
                    z2 = true;
                    i6 = i2;
                } else {
                    z2 = false;
                }
                for (int i7 = i2; i7 <= i6; i7++) {
                    TZRule tZRule = new TZRule(i7, month, i4, dayOfWeek, localTime, z, timeDefinition, i5);
                    if (z2) {
                        this.f31885g.add(tZRule);
                        this.f31884f = Math.max(i2, this.f31884f);
                    } else {
                        int i8 = i2;
                        this.f31883e.add(tZRule);
                    }
                }
            } else {
                throw new IllegalStateException("Window has reached the maximum number of allowed rules");
            }
        }

        /* access modifiers changed from: package-private */
        public long f(int i2) {
            ZoneOffset g2 = g(i2);
            return this.f31881c.a(this.f31880b, this.f31879a, g2).L(g2);
        }

        /* access modifiers changed from: package-private */
        public ZoneOffset g(int i2) {
            return ZoneOffset.L(this.f31879a.F() + i2);
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            return this.f31880b.equals(LocalDateTime.X2) && this.f31881c == ZoneOffsetTransitionRule.TimeDefinition.WALL && this.f31882d == null && this.f31885g.isEmpty() && this.f31883e.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void i(int i2) {
            if (this.f31883e.size() > 0 || this.f31885g.size() > 0) {
                throw new IllegalStateException("Window has DST rules, so cannot have fixed savings");
            }
            this.f31882d = Integer.valueOf(i2);
        }

        /* access modifiers changed from: package-private */
        public void j(int i2) {
            if (this.f31885g.size() != 1) {
                if (this.f31880b.equals(LocalDateTime.X2)) {
                    this.f31884f = Math.max(this.f31884f, i2) + 1;
                    for (TZRule next : this.f31885g) {
                        e(next.s, this.f31884f, next.X, next.Y, next.Z, next.X2, next.Y2, next.Z2, next.a3);
                        int unused = next.s = this.f31884f + 1;
                    }
                    int i3 = this.f31884f;
                    if (i3 == 999999999) {
                        this.f31885g.clear();
                    } else {
                        this.f31884f = i3 + 1;
                    }
                } else {
                    int M0 = this.f31880b.M0();
                    for (TZRule next2 : this.f31885g) {
                        e(next2.s, M0 + 1, next2.X, next2.Y, next2.Z, next2.X2, next2.Y2, next2.Z2, next2.a3);
                    }
                    this.f31885g.clear();
                    this.f31884f = Year.Y;
                }
                Collections.sort(this.f31883e);
                Collections.sort(this.f31885g);
                if (this.f31883e.size() == 0 && this.f31882d == null) {
                    this.f31882d = 0;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot have only one rule defined as being forever");
        }

        /* access modifiers changed from: package-private */
        public void k(TZWindow tZWindow) {
            if (this.f31880b.z(tZWindow.f31880b)) {
                throw new IllegalStateException("Windows must be added in date-time order: " + this.f31880b + " < " + tZWindow.f31880b);
            }
        }
    }

    public ZoneRulesBuilder a(int i2, int i3, Month month, int i4, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i5) {
        int i6 = i4;
        LocalTime localTime2 = localTime;
        Month month2 = month;
        Jdk8Methods.j(month, "month");
        Jdk8Methods.j(localTime2, HTML.Tag.P0);
        Jdk8Methods.j(timeDefinition, "timeDefinition");
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.n((long) i2);
        chronoField.n((long) i3);
        if (i6 < -28 || i6 > 31 || i6 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        } else if (z && !localTime2.equals(LocalTime.Z2)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        } else if (!this.f31877a.isEmpty()) {
            List<TZWindow> list = this.f31877a;
            list.get(list.size() - 1).e(i2, i3, month, i4, dayOfWeek, localTime, z, timeDefinition, i5);
            return this;
        } else {
            throw new IllegalStateException("Must add a window before adding a rule");
        }
    }

    public ZoneRulesBuilder b(int i2, Month month, int i3, LocalTime localTime, boolean z, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i4) {
        return a(i2, i2, month, i3, (DayOfWeek) null, localTime, z, timeDefinition, i4);
    }

    public ZoneRulesBuilder c(LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i2) {
        Jdk8Methods.j(localDateTime, "transitionDateTime");
        return a(localDateTime.M0(), localDateTime.M0(), localDateTime.K0(), localDateTime.C0(), (DayOfWeek) null, localDateTime.U(), false, timeDefinition, i2);
    }

    public ZoneRulesBuilder d(ZoneOffset zoneOffset, LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition) {
        Jdk8Methods.j(zoneOffset, "standardOffset");
        Jdk8Methods.j(localDateTime, "until");
        Jdk8Methods.j(timeDefinition, "untilDefinition");
        TZWindow tZWindow = new TZWindow(zoneOffset, localDateTime, timeDefinition);
        if (this.f31877a.size() > 0) {
            List<TZWindow> list = this.f31877a;
            tZWindow.k(list.get(list.size() - 1));
        }
        this.f31877a.add(tZWindow);
        return this;
    }

    public ZoneRulesBuilder e(ZoneOffset zoneOffset) {
        return d(zoneOffset, LocalDateTime.X2, ZoneOffsetTransitionRule.TimeDefinition.WALL);
    }

    /* access modifiers changed from: package-private */
    public <T> T f(T t) {
        if (!this.f31878b.containsKey(t)) {
            this.f31878b.put(t, t);
        }
        return this.f31878b.get(t);
    }

    public ZoneRulesBuilder g(int i2) {
        if (!this.f31877a.isEmpty()) {
            List<TZWindow> list = this.f31877a;
            list.get(list.size() - 1).i(i2);
            return this;
        }
        throw new IllegalStateException("Must add a window before setting the fixed savings");
    }

    public ZoneRules h(String str) {
        return i(str, new HashMap());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: org.threeten.bp.ZoneOffset} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.zone.ZoneRules i(java.lang.String r22, java.util.Map<java.lang.Object, java.lang.Object> r23) {
        /*
            r21 = this;
            r0 = r21
            java.lang.String r1 = "zoneId"
            r2 = r22
            org.threeten.bp.jdk8.Jdk8Methods.j(r2, r1)
            r1 = r23
            r0.f31878b = r1
            java.util.List<org.threeten.bp.zone.ZoneRulesBuilder$TZWindow> r1 = r0.f31877a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x01b1
            java.util.ArrayList r5 = new java.util.ArrayList
            r1 = 4
            r5.<init>(r1)
            java.util.ArrayList r6 = new java.util.ArrayList
            r1 = 256(0x100, float:3.59E-43)
            r6.<init>(r1)
            java.util.ArrayList r7 = new java.util.ArrayList
            r1 = 2
            r7.<init>(r1)
            java.util.List<org.threeten.bp.zone.ZoneRulesBuilder$TZWindow> r1 = r0.f31877a
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            org.threeten.bp.zone.ZoneRulesBuilder$TZWindow r1 = (org.threeten.bp.zone.ZoneRulesBuilder.TZWindow) r1
            org.threeten.bp.ZoneOffset r3 = r1.f31879a
            java.lang.Integer r4 = r1.f31882d
            if (r4 == 0) goto L_0x0044
            java.lang.Integer r4 = r1.f31882d
            int r4 = r4.intValue()
            goto L_0x0045
        L_0x0044:
            r4 = 0
        L_0x0045:
            int r8 = r3.F()
            int r8 = r8 + r4
            org.threeten.bp.ZoneOffset r8 = org.threeten.bp.ZoneOffset.L(r8)
            java.lang.Object r8 = r0.f(r8)
            org.threeten.bp.ZoneOffset r8 = (org.threeten.bp.ZoneOffset) r8
            r9 = -999999999(0xffffffffc4653601, float:-916.8438)
            r10 = 1
            org.threeten.bp.LocalDateTime r9 = org.threeten.bp.LocalDateTime.e2(r9, r10, r10, r2, r2)
            java.lang.Object r9 = r0.f(r9)
            org.threeten.bp.LocalDateTime r9 = (org.threeten.bp.LocalDateTime) r9
            java.util.List<org.threeten.bp.zone.ZoneRulesBuilder$TZWindow> r10 = r0.f31877a
            java.util.Iterator r10 = r10.iterator()
            r11 = r8
        L_0x0069:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x01a5
            java.lang.Object r12 = r10.next()
            org.threeten.bp.zone.ZoneRulesBuilder$TZWindow r12 = (org.threeten.bp.zone.ZoneRulesBuilder.TZWindow) r12
            int r13 = r9.M0()
            r12.j(r13)
            java.lang.Integer r13 = r12.f31882d
            if (r13 != 0) goto L_0x00b4
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)
            java.util.List r14 = r12.f31883e
            java.util.Iterator r14 = r14.iterator()
        L_0x008e:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x00b4
            java.lang.Object r15 = r14.next()
            org.threeten.bp.zone.ZoneRulesBuilder$TZRule r15 = (org.threeten.bp.zone.ZoneRulesBuilder.TZRule) r15
            org.threeten.bp.zone.ZoneOffsetTransition r16 = r15.m(r3, r4)
            long r16 = r16.p()
            long r18 = r9.L(r11)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 <= 0) goto L_0x00ab
            goto L_0x00b4
        L_0x00ab:
            int r13 = r15.a3
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            goto L_0x008e
        L_0x00b4:
            org.threeten.bp.ZoneOffset r4 = r12.f31879a
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x00e0
            org.threeten.bp.zone.ZoneOffsetTransition r4 = new org.threeten.bp.zone.ZoneOffsetTransition
            long r14 = r9.L(r11)
            org.threeten.bp.LocalDateTime r14 = org.threeten.bp.LocalDateTime.q2(r14, r2, r3)
            org.threeten.bp.ZoneOffset r15 = r12.f31879a
            r4.<init>((org.threeten.bp.LocalDateTime) r14, (org.threeten.bp.ZoneOffset) r3, (org.threeten.bp.ZoneOffset) r15)
            java.lang.Object r3 = r0.f(r4)
            r5.add(r3)
            org.threeten.bp.ZoneOffset r3 = r12.f31879a
            java.lang.Object r3 = r0.f(r3)
            org.threeten.bp.ZoneOffset r3 = (org.threeten.bp.ZoneOffset) r3
        L_0x00e0:
            int r4 = r3.F()
            int r14 = r13.intValue()
            int r4 = r4 + r14
            org.threeten.bp.ZoneOffset r4 = org.threeten.bp.ZoneOffset.L(r4)
            java.lang.Object r4 = r0.f(r4)
            org.threeten.bp.ZoneOffset r4 = (org.threeten.bp.ZoneOffset) r4
            boolean r14 = r11.equals(r4)
            if (r14 != 0) goto L_0x0107
            org.threeten.bp.zone.ZoneOffsetTransition r14 = new org.threeten.bp.zone.ZoneOffsetTransition
            r14.<init>((org.threeten.bp.LocalDateTime) r9, (org.threeten.bp.ZoneOffset) r11, (org.threeten.bp.ZoneOffset) r4)
            java.lang.Object r4 = r0.f(r14)
            org.threeten.bp.zone.ZoneOffsetTransition r4 = (org.threeten.bp.zone.ZoneOffsetTransition) r4
            r6.add(r4)
        L_0x0107:
            int r4 = r13.intValue()
            java.util.List r13 = r12.f31883e
            java.util.Iterator r13 = r13.iterator()
        L_0x0113:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0161
            java.lang.Object r14 = r13.next()
            org.threeten.bp.zone.ZoneRulesBuilder$TZRule r14 = (org.threeten.bp.zone.ZoneRulesBuilder.TZRule) r14
            org.threeten.bp.zone.ZoneOffsetTransition r15 = r14.m(r3, r4)
            java.lang.Object r15 = r0.f(r15)
            org.threeten.bp.zone.ZoneOffsetTransition r15 = (org.threeten.bp.zone.ZoneOffsetTransition) r15
            long r16 = r15.p()
            long r18 = r9.L(r11)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L_0x0138
        L_0x0135:
            r16 = r4
            goto L_0x015d
        L_0x0138:
            long r16 = r15.p()
            long r18 = r12.f(r4)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L_0x0135
            org.threeten.bp.ZoneOffset r2 = r15.i()
            r16 = r4
            org.threeten.bp.ZoneOffset r4 = r15.h()
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x015d
            r6.add(r15)
            int r2 = r14.a3
            r4 = r2
            goto L_0x015f
        L_0x015d:
            r4 = r16
        L_0x015f:
            r2 = 0
            goto L_0x0113
        L_0x0161:
            r16 = r4
            java.util.List r2 = r12.f31885g
            java.util.Iterator r2 = r2.iterator()
        L_0x016b:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x0189
            java.lang.Object r9 = r2.next()
            org.threeten.bp.zone.ZoneRulesBuilder$TZRule r9 = (org.threeten.bp.zone.ZoneRulesBuilder.TZRule) r9
            org.threeten.bp.zone.ZoneOffsetTransitionRule r4 = r9.n(r3, r4)
            java.lang.Object r4 = r0.f(r4)
            org.threeten.bp.zone.ZoneOffsetTransitionRule r4 = (org.threeten.bp.zone.ZoneOffsetTransitionRule) r4
            r7.add(r4)
            int r4 = r9.a3
            goto L_0x016b
        L_0x0189:
            org.threeten.bp.ZoneOffset r2 = r12.g(r4)
            java.lang.Object r2 = r0.f(r2)
            r11 = r2
            org.threeten.bp.ZoneOffset r11 = (org.threeten.bp.ZoneOffset) r11
            long r12 = r12.f(r4)
            r2 = 0
            org.threeten.bp.LocalDateTime r9 = org.threeten.bp.LocalDateTime.q2(r12, r2, r11)
            java.lang.Object r9 = r0.f(r9)
            org.threeten.bp.LocalDateTime r9 = (org.threeten.bp.LocalDateTime) r9
            goto L_0x0069
        L_0x01a5:
            org.threeten.bp.zone.StandardZoneRules r9 = new org.threeten.bp.zone.StandardZoneRules
            org.threeten.bp.ZoneOffset r3 = r1.f31879a
            r2 = r9
            r4 = r8
            r2.<init>((org.threeten.bp.ZoneOffset) r3, (org.threeten.bp.ZoneOffset) r4, (java.util.List<org.threeten.bp.zone.ZoneOffsetTransition>) r5, (java.util.List<org.threeten.bp.zone.ZoneOffsetTransition>) r6, (java.util.List<org.threeten.bp.zone.ZoneOffsetTransitionRule>) r7)
            return r9
        L_0x01b1:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "No windows have been added to the builder"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.ZoneRulesBuilder.i(java.lang.String, java.util.Map):org.threeten.bp.zone.ZoneRules");
    }
}
