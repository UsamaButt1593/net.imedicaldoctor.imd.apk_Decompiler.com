package org.threeten.bp;

import androidx.media3.common.C;
import java.io.Serializable;
import org.threeten.bp.jdk8.Jdk8Methods;

public abstract class Clock {

    static final class FixedClock extends Clock implements Serializable {
        private static final long Y = 7430389292664866958L;
        private final ZoneId X;
        private final Instant s;

        FixedClock(Instant instant, ZoneId zoneId) {
            this.s = instant;
            this.X = zoneId;
        }

        public ZoneId b() {
            return this.X;
        }

        public Instant c() {
            return this.s;
        }

        public long d() {
            return this.s.Y0();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof FixedClock)) {
                return false;
            }
            FixedClock fixedClock = (FixedClock) obj;
            return this.s.equals(fixedClock.s) && this.X.equals(fixedClock.X);
        }

        public int hashCode() {
            return this.s.hashCode() ^ this.X.hashCode();
        }

        public Clock l(ZoneId zoneId) {
            return zoneId.equals(this.X) ? this : new FixedClock(this.s, zoneId);
        }

        public String toString() {
            return "FixedClock[" + this.s + "," + this.X + "]";
        }
    }

    static final class OffsetClock extends Clock implements Serializable {
        private static final long Y = 2007484719125426256L;
        private final Duration X;
        private final Clock s;

        OffsetClock(Clock clock, Duration duration) {
            this.s = clock;
            this.X = duration;
        }

        public ZoneId b() {
            return this.s.b();
        }

        public Instant c() {
            return this.s.c().h(this.X);
        }

        public long d() {
            return Jdk8Methods.l(this.s.d(), this.X.j0());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetClock)) {
                return false;
            }
            OffsetClock offsetClock = (OffsetClock) obj;
            return this.s.equals(offsetClock.s) && this.X.equals(offsetClock.X);
        }

        public int hashCode() {
            return this.s.hashCode() ^ this.X.hashCode();
        }

        public Clock l(ZoneId zoneId) {
            return zoneId.equals(this.s.b()) ? this : new OffsetClock(this.s.l(zoneId), this.X);
        }

        public String toString() {
            return "OffsetClock[" + this.s + "," + this.X + "]";
        }
    }

    static final class SystemClock extends Clock implements Serializable {
        private static final long X = 6740630888130243051L;
        private final ZoneId s;

        SystemClock(ZoneId zoneId) {
            this.s = zoneId;
        }

        public ZoneId b() {
            return this.s;
        }

        public Instant c() {
            return Instant.c0(d());
        }

        public long d() {
            return System.currentTimeMillis();
        }

        public boolean equals(Object obj) {
            if (obj instanceof SystemClock) {
                return this.s.equals(((SystemClock) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return this.s.hashCode() + 1;
        }

        public Clock l(ZoneId zoneId) {
            return zoneId.equals(this.s) ? this : new SystemClock(zoneId);
        }

        public String toString() {
            return "SystemClock[" + this.s + "]";
        }
    }

    static final class TickClock extends Clock implements Serializable {
        private static final long Y = 6504659149906368850L;
        private final long X;
        private final Clock s;

        TickClock(Clock clock, long j2) {
            this.s = clock;
            this.X = j2;
        }

        public ZoneId b() {
            return this.s.b();
        }

        public Instant c() {
            int i2 = ((this.X % 1000000) > 0 ? 1 : ((this.X % 1000000) == 0 ? 0 : -1));
            Clock clock = this.s;
            if (i2 == 0) {
                long d2 = clock.d();
                return Instant.c0(d2 - Jdk8Methods.h(d2, this.X / 1000000));
            }
            Instant c2 = clock.c();
            return c2.K(Jdk8Methods.h((long) c2.z(), this.X));
        }

        public long d() {
            long d2 = this.s.d();
            return d2 - Jdk8Methods.h(d2, this.X / 1000000);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof TickClock)) {
                return false;
            }
            TickClock tickClock = (TickClock) obj;
            return this.s.equals(tickClock.s) && this.X == tickClock.X;
        }

        public int hashCode() {
            int hashCode = this.s.hashCode();
            long j2 = this.X;
            return hashCode ^ ((int) (j2 ^ (j2 >>> 32)));
        }

        public Clock l(ZoneId zoneId) {
            return zoneId.equals(this.s.b()) ? this : new TickClock(this.s.l(zoneId), this.X);
        }

        public String toString() {
            return "TickClock[" + this.s + "," + Duration.J(this.X) + "]";
        }
    }

    protected Clock() {
    }

    public static Clock a(Instant instant, ZoneId zoneId) {
        Jdk8Methods.j(instant, "fixedInstant");
        Jdk8Methods.j(zoneId, "zone");
        return new FixedClock(instant, zoneId);
    }

    public static Clock e(Clock clock, Duration duration) {
        Jdk8Methods.j(clock, "baseClock");
        Jdk8Methods.j(duration, "offsetDuration");
        return duration.equals(Duration.Y) ? clock : new OffsetClock(clock, duration);
    }

    public static Clock f(ZoneId zoneId) {
        Jdk8Methods.j(zoneId, "zone");
        return new SystemClock(zoneId);
    }

    public static Clock g() {
        return new SystemClock(ZoneId.z());
    }

    public static Clock h() {
        return new SystemClock(ZoneOffset.g3);
    }

    public static Clock i(Clock clock, Duration duration) {
        Jdk8Methods.j(clock, "baseClock");
        Jdk8Methods.j(duration, "tickDuration");
        if (!duration.p()) {
            long m0 = duration.m0();
            if (m0 % 1000000 == 0 || C.f9093k % m0 == 0) {
                return m0 <= 1 ? clock : new TickClock(clock, m0);
            }
            throw new IllegalArgumentException("Invalid tick duration");
        }
        throw new IllegalArgumentException("Tick duration must not be negative");
    }

    public static Clock j(ZoneId zoneId) {
        return new TickClock(f(zoneId), 60000000000L);
    }

    public static Clock k(ZoneId zoneId) {
        return new TickClock(f(zoneId), C.f9093k);
    }

    public abstract ZoneId b();

    public abstract Instant c();

    public long d() {
        return c().Y0();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public abstract Clock l(ZoneId zoneId);
}
