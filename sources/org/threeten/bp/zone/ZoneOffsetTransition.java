package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class ZoneOffsetTransition implements Comparable<ZoneOffsetTransition>, Serializable {
    private static final long Z = -6946044323557704546L;
    private final ZoneOffset X;
    private final ZoneOffset Y;
    private final LocalDateTime s;

    ZoneOffsetTransition(long j2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.s = LocalDateTime.q2(j2, 0, zoneOffset);
        this.X = zoneOffset;
        this.Y = zoneOffset2;
    }

    private int f() {
        return h().F() - i().F();
    }

    public static ZoneOffsetTransition n(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        Jdk8Methods.j(localDateTime, "transition");
        Jdk8Methods.j(zoneOffset, "offsetBefore");
        Jdk8Methods.j(zoneOffset2, "offsetAfter");
        if (zoneOffset.equals(zoneOffset2)) {
            throw new IllegalArgumentException("Offsets must not be equal");
        } else if (localDateTime.R0() == 0) {
            return new ZoneOffsetTransition(localDateTime, zoneOffset, zoneOffset2);
        } else {
            throw new IllegalArgumentException("Nano-of-second must be zero");
        }
    }

    static ZoneOffsetTransition o(DataInput dataInput) throws IOException {
        long b2 = Ser.b(dataInput);
        ZoneOffset d2 = Ser.d(dataInput);
        ZoneOffset d3 = Ser.d(dataInput);
        if (!d2.equals(d3)) {
            return new ZoneOffsetTransition(b2, d2, d3);
        }
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    private Object r() {
        return new Ser((byte) 2, this);
    }

    /* renamed from: a */
    public int compareTo(ZoneOffsetTransition zoneOffsetTransition) {
        return g().compareTo(zoneOffsetTransition.g());
    }

    public LocalDateTime b() {
        return this.s.M2((long) f());
    }

    public LocalDateTime c() {
        return this.s;
    }

    public Duration e() {
        return Duration.K((long) f());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransition)) {
            return false;
        }
        ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
        return this.s.equals(zoneOffsetTransition.s) && this.X.equals(zoneOffsetTransition.X) && this.Y.equals(zoneOffsetTransition.Y);
    }

    public Instant g() {
        return this.s.Q(this.X);
    }

    public ZoneOffset h() {
        return this.Y;
    }

    public int hashCode() {
        return (this.s.hashCode() ^ this.X.hashCode()) ^ Integer.rotateLeft(this.Y.hashCode(), 16);
    }

    public ZoneOffset i() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public List<ZoneOffset> j() {
        if (k()) {
            return Collections.emptyList();
        }
        return Arrays.asList(new ZoneOffset[]{i(), h()});
    }

    public boolean k() {
        return h().F() > i().F();
    }

    public boolean l() {
        return h().F() < i().F();
    }

    public boolean m(ZoneOffset zoneOffset) {
        if (k()) {
            return false;
        }
        return i().equals(zoneOffset) || h().equals(zoneOffset);
    }

    public long p() {
        return this.s.L(this.X);
    }

    /* access modifiers changed from: package-private */
    public void q(DataOutput dataOutput) throws IOException {
        Ser.g(p(), dataOutput);
        Ser.i(this.X, dataOutput);
        Ser.i(this.Y, dataOutput);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transition[");
        sb.append(k() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.s);
        sb.append(this.X);
        sb.append(" to ");
        sb.append(this.Y);
        sb.append(']');
        return sb.toString();
    }

    ZoneOffsetTransition(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.s = localDateTime;
        this.X = zoneOffset;
        this.Y = zoneOffset2;
    }
}
