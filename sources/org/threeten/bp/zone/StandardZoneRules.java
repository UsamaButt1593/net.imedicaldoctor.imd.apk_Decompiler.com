package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;

final class StandardZoneRules extends ZoneRules implements Serializable {
    private static final long a3 = 3044319355680032515L;
    private static final int b3 = 2100;
    private final ZoneOffset[] X;
    private final ZoneOffset[] X2;
    private final long[] Y;
    private final ZoneOffsetTransitionRule[] Y2;
    private final LocalDateTime[] Z;
    private final ConcurrentMap<Integer, ZoneOffsetTransition[]> Z2 = new ConcurrentHashMap();
    private final long[] s;

    StandardZoneRules(ZoneOffset zoneOffset, ZoneOffset zoneOffset2, List<ZoneOffsetTransition> list, List<ZoneOffsetTransition> list2, List<ZoneOffsetTransitionRule> list3) {
        LocalDateTime c2;
        this.s = new long[list.size()];
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[(list.size() + 1)];
        this.X = zoneOffsetArr;
        zoneOffsetArr[0] = zoneOffset;
        int i2 = 0;
        while (i2 < list.size()) {
            this.s[i2] = list.get(i2).p();
            int i3 = i2 + 1;
            this.X[i3] = list.get(i2).h();
            i2 = i3;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(zoneOffset2);
        for (ZoneOffsetTransition next : list2) {
            if (next.k()) {
                arrayList.add(next.c());
                c2 = next.b();
            } else {
                arrayList.add(next.b());
                c2 = next.c();
            }
            arrayList.add(c2);
            arrayList2.add(next.h());
        }
        this.Z = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        this.X2 = (ZoneOffset[]) arrayList2.toArray(new ZoneOffset[arrayList2.size()]);
        this.Y = new long[list2.size()];
        for (int i4 = 0; i4 < list2.size(); i4++) {
            this.Y[i4] = list2.get(i4).g().y();
        }
        if (list3.size() <= 15) {
            this.Y2 = (ZoneOffsetTransitionRule[]) list3.toArray(new ZoneOffsetTransitionRule[list3.size()]);
            return;
        }
        throw new IllegalArgumentException("Too many transition rules");
    }

    private Object p(LocalDateTime localDateTime, ZoneOffsetTransition zoneOffsetTransition) {
        LocalDateTime c2 = zoneOffsetTransition.c();
        boolean k2 = zoneOffsetTransition.k();
        boolean z = localDateTime.z(c2);
        if (k2) {
            if (z) {
                return zoneOffsetTransition.i();
            }
            return localDateTime.z(zoneOffsetTransition.b()) ? zoneOffsetTransition : zoneOffsetTransition.h();
        } else if (!z) {
            return zoneOffsetTransition.h();
        } else {
            return localDateTime.z(zoneOffsetTransition.b()) ? zoneOffsetTransition.i() : zoneOffsetTransition;
        }
    }

    private ZoneOffsetTransition[] q(int i2) {
        Integer valueOf = Integer.valueOf(i2);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = this.Z2.get(valueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.Y2;
        ZoneOffsetTransition[] zoneOffsetTransitionArr2 = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
        for (int i3 = 0; i3 < zoneOffsetTransitionRuleArr.length; i3++) {
            zoneOffsetTransitionArr2[i3] = zoneOffsetTransitionRuleArr[i3].a(i2);
        }
        if (i2 < b3) {
            this.Z2.putIfAbsent(valueOf, zoneOffsetTransitionArr2);
        }
        return zoneOffsetTransitionArr2;
    }

    private int r(long j2, ZoneOffset zoneOffset) {
        return LocalDate.w2(Jdk8Methods.e(j2 + ((long) zoneOffset.F()), 86400)).M0();
    }

    private Object s(LocalDateTime localDateTime) {
        int i2 = 0;
        if (this.Y2.length > 0) {
            LocalDateTime[] localDateTimeArr = this.Z;
            if (localDateTime.y(localDateTimeArr[localDateTimeArr.length - 1])) {
                ZoneOffsetTransition[] q = q(localDateTime.M0());
                int length = q.length;
                Object obj = null;
                while (i2 < length) {
                    ZoneOffsetTransition zoneOffsetTransition = q[i2];
                    Object p = p(localDateTime, zoneOffsetTransition);
                    if ((p instanceof ZoneOffsetTransition) || p.equals(zoneOffsetTransition.i())) {
                        return p;
                    }
                    i2++;
                    obj = p;
                }
                return obj;
            }
        }
        int binarySearch = Arrays.binarySearch(this.Z, localDateTime);
        if (binarySearch == -1) {
            return this.X2[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            LocalDateTime[] localDateTimeArr2 = this.Z;
            if (binarySearch < localDateTimeArr2.length - 1) {
                int i3 = binarySearch + 1;
                if (localDateTimeArr2[binarySearch].equals(localDateTimeArr2[i3])) {
                    binarySearch = i3;
                }
            }
        }
        if ((binarySearch & 1) != 0) {
            return this.X2[(binarySearch / 2) + 1];
        }
        LocalDateTime[] localDateTimeArr3 = this.Z;
        LocalDateTime localDateTime2 = localDateTimeArr3[binarySearch];
        LocalDateTime localDateTime3 = localDateTimeArr3[binarySearch + 1];
        ZoneOffset[] zoneOffsetArr = this.X2;
        int i4 = binarySearch / 2;
        ZoneOffset zoneOffset = zoneOffsetArr[i4];
        ZoneOffset zoneOffset2 = zoneOffsetArr[i4 + 1];
        return zoneOffset2.F() > zoneOffset.F() ? new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2) : new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
    }

    static StandardZoneRules t(DataInput dataInput) throws IOException, ClassNotFoundException {
        int readInt = dataInput.readInt();
        long[] jArr = new long[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            jArr[i2] = Ser.b(dataInput);
        }
        int i3 = readInt + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            zoneOffsetArr[i4] = Ser.d(dataInput);
        }
        int readInt2 = dataInput.readInt();
        long[] jArr2 = new long[readInt2];
        for (int i5 = 0; i5 < readInt2; i5++) {
            jArr2[i5] = Ser.b(dataInput);
        }
        int i6 = readInt2 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            zoneOffsetArr2[i7] = Ser.d(dataInput);
        }
        int readByte = dataInput.readByte();
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = new ZoneOffsetTransitionRule[readByte];
        for (int i8 = 0; i8 < readByte; i8++) {
            zoneOffsetTransitionRuleArr[i8] = ZoneOffsetTransitionRule.l(dataInput);
        }
        return new StandardZoneRules(jArr, zoneOffsetArr, jArr2, zoneOffsetArr2, zoneOffsetTransitionRuleArr);
    }

    private Object v() {
        return new Ser((byte) 1, this);
    }

    public Duration a(Instant instant) {
        return Duration.K((long) (b(instant).F() - d(instant).F()));
    }

    public ZoneOffset b(Instant instant) {
        long y = instant.y();
        if (this.Y2.length > 0) {
            long[] jArr = this.Y;
            if (y > jArr[jArr.length - 1]) {
                ZoneOffset[] zoneOffsetArr = this.X2;
                ZoneOffsetTransition[] q = q(r(y, zoneOffsetArr[zoneOffsetArr.length - 1]));
                ZoneOffsetTransition zoneOffsetTransition = null;
                for (int i2 = 0; i2 < q.length; i2++) {
                    zoneOffsetTransition = q[i2];
                    if (y < zoneOffsetTransition.p()) {
                        return zoneOffsetTransition.i();
                    }
                }
                return zoneOffsetTransition.h();
            }
        }
        int binarySearch = Arrays.binarySearch(this.Y, y);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.X2[binarySearch + 1];
    }

    public ZoneOffset c(LocalDateTime localDateTime) {
        Object s2 = s(localDateTime);
        return s2 instanceof ZoneOffsetTransition ? ((ZoneOffsetTransition) s2).i() : (ZoneOffset) s2;
    }

    public ZoneOffset d(Instant instant) {
        int binarySearch = Arrays.binarySearch(this.s, instant.y());
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.X[binarySearch + 1];
    }

    public ZoneOffsetTransition e(LocalDateTime localDateTime) {
        Object s2 = s(localDateTime);
        if (s2 instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) s2;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StandardZoneRules) {
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            return Arrays.equals(this.s, standardZoneRules.s) && Arrays.equals(this.X, standardZoneRules.X) && Arrays.equals(this.Y, standardZoneRules.Y) && Arrays.equals(this.X2, standardZoneRules.X2) && Arrays.equals(this.Y2, standardZoneRules.Y2);
        }
        if ((obj instanceof ZoneRules.Fixed) && j()) {
            Instant instant = Instant.Y;
            if (b(instant).equals(((ZoneRules.Fixed) obj).b(instant))) {
                return true;
            }
        }
        return false;
    }

    public List<ZoneOffsetTransitionRule> f() {
        return Collections.unmodifiableList(Arrays.asList(this.Y2));
    }

    public List<ZoneOffsetTransition> g() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            long[] jArr = this.Y;
            if (i2 >= jArr.length) {
                return Collections.unmodifiableList(arrayList);
            }
            long j2 = jArr[i2];
            ZoneOffset[] zoneOffsetArr = this.X2;
            ZoneOffset zoneOffset = zoneOffsetArr[i2];
            i2++;
            arrayList.add(new ZoneOffsetTransition(j2, zoneOffset, zoneOffsetArr[i2]));
        }
    }

    public List<ZoneOffset> h(LocalDateTime localDateTime) {
        Object s2 = s(localDateTime);
        return s2 instanceof ZoneOffsetTransition ? ((ZoneOffsetTransition) s2).j() : Collections.singletonList((ZoneOffset) s2);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.s) ^ Arrays.hashCode(this.X)) ^ Arrays.hashCode(this.Y)) ^ Arrays.hashCode(this.X2)) ^ Arrays.hashCode(this.Y2);
    }

    public boolean i(Instant instant) {
        return !d(instant).equals(b(instant));
    }

    public boolean j() {
        return this.Y.length == 0;
    }

    public boolean k(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return h(localDateTime).contains(zoneOffset);
    }

    public ZoneOffsetTransition l(Instant instant) {
        if (this.Y.length == 0) {
            return null;
        }
        long y = instant.y();
        long[] jArr = this.Y;
        if (y < jArr[jArr.length - 1]) {
            int binarySearch = Arrays.binarySearch(jArr, y);
            int i2 = binarySearch < 0 ? (-binarySearch) - 1 : binarySearch + 1;
            long j2 = this.Y[i2];
            ZoneOffset[] zoneOffsetArr = this.X2;
            return new ZoneOffsetTransition(j2, zoneOffsetArr[i2], zoneOffsetArr[i2 + 1]);
        } else if (this.Y2.length == 0) {
            return null;
        } else {
            ZoneOffset[] zoneOffsetArr2 = this.X2;
            int r = r(y, zoneOffsetArr2[zoneOffsetArr2.length - 1]);
            for (ZoneOffsetTransition zoneOffsetTransition : q(r)) {
                if (y < zoneOffsetTransition.p()) {
                    return zoneOffsetTransition;
                }
            }
            if (r < 999999999) {
                return q(r + 1)[0];
            }
            return null;
        }
    }

    public ZoneOffsetTransition o(Instant instant) {
        if (this.Y.length == 0) {
            return null;
        }
        long y = instant.y();
        if (instant.z() > 0 && y < Long.MAX_VALUE) {
            y++;
        }
        long[] jArr = this.Y;
        long j2 = jArr[jArr.length - 1];
        if (this.Y2.length > 0 && y > j2) {
            ZoneOffset[] zoneOffsetArr = this.X2;
            ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
            int r = r(y, zoneOffset);
            ZoneOffsetTransition[] q = q(r);
            for (int length = q.length - 1; length >= 0; length--) {
                if (y > q[length].p()) {
                    return q[length];
                }
            }
            int i2 = r - 1;
            if (i2 > r(j2, zoneOffset)) {
                ZoneOffsetTransition[] q2 = q(i2);
                return q2[q2.length - 1];
            }
        }
        int binarySearch = Arrays.binarySearch(this.Y, y);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        if (binarySearch <= 0) {
            return null;
        }
        int i3 = binarySearch - 1;
        long j3 = this.Y[i3];
        ZoneOffset[] zoneOffsetArr2 = this.X2;
        return new ZoneOffsetTransition(j3, zoneOffsetArr2[i3], zoneOffsetArr2[binarySearch]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StandardZoneRules[currentStandardOffset=");
        ZoneOffset[] zoneOffsetArr = this.X;
        sb.append(zoneOffsetArr[zoneOffsetArr.length - 1]);
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void u(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.s.length);
        for (long g2 : this.s) {
            Ser.g(g2, dataOutput);
        }
        for (ZoneOffset i2 : this.X) {
            Ser.i(i2, dataOutput);
        }
        dataOutput.writeInt(this.Y.length);
        for (long g3 : this.Y) {
            Ser.g(g3, dataOutput);
        }
        for (ZoneOffset i3 : this.X2) {
            Ser.i(i3, dataOutput);
        }
        dataOutput.writeByte(this.Y2.length);
        for (ZoneOffsetTransitionRule m2 : this.Y2) {
            m2.m(dataOutput);
        }
    }

    private StandardZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr) {
        LocalDateTime c2;
        this.s = jArr;
        this.X = zoneOffsetArr;
        this.Y = jArr2;
        this.X2 = zoneOffsetArr2;
        this.Y2 = zoneOffsetTransitionRuleArr;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < jArr2.length) {
            int i3 = i2 + 1;
            ZoneOffsetTransition zoneOffsetTransition = new ZoneOffsetTransition(jArr2[i2], zoneOffsetArr2[i2], zoneOffsetArr2[i3]);
            if (zoneOffsetTransition.k()) {
                arrayList.add(zoneOffsetTransition.c());
                c2 = zoneOffsetTransition.b();
            } else {
                arrayList.add(zoneOffsetTransition.b());
                c2 = zoneOffsetTransition.c();
            }
            arrayList.add(c2);
            i2 = i3;
        }
        this.Z = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
    }
}
