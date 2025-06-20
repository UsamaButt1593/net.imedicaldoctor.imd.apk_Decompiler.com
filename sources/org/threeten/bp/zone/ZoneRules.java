package org.threeten.bp.zone;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

public abstract class ZoneRules {

    static final class Fixed extends ZoneRules implements Serializable {
        private static final long X = -8733721350312276297L;
        private final ZoneOffset s;

        Fixed(ZoneOffset zoneOffset) {
            this.s = zoneOffset;
        }

        public Duration a(Instant instant) {
            return Duration.Y;
        }

        public ZoneOffset b(Instant instant) {
            return this.s;
        }

        public ZoneOffset c(LocalDateTime localDateTime) {
            return this.s;
        }

        public ZoneOffset d(Instant instant) {
            return this.s;
        }

        public ZoneOffsetTransition e(LocalDateTime localDateTime) {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Fixed) {
                return this.s.equals(((Fixed) obj).s);
            }
            if (!(obj instanceof StandardZoneRules)) {
                return false;
            }
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            return standardZoneRules.j() && this.s.equals(standardZoneRules.b(Instant.Y));
        }

        public List<ZoneOffsetTransitionRule> f() {
            return Collections.emptyList();
        }

        public List<ZoneOffsetTransition> g() {
            return Collections.emptyList();
        }

        public List<ZoneOffset> h(LocalDateTime localDateTime) {
            return Collections.singletonList(this.s);
        }

        public int hashCode() {
            return ((this.s.hashCode() + 31) ^ (this.s.hashCode() + 31)) ^ 1;
        }

        public boolean i(Instant instant) {
            return false;
        }

        public boolean j() {
            return true;
        }

        public boolean k(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
            return this.s.equals(zoneOffset);
        }

        public ZoneOffsetTransition l(Instant instant) {
            return null;
        }

        public ZoneOffsetTransition o(Instant instant) {
            return null;
        }

        public String toString() {
            return "FixedRules:" + this.s;
        }
    }

    ZoneRules() {
    }

    public static ZoneRules m(ZoneOffset zoneOffset) {
        Jdk8Methods.j(zoneOffset, TypedValues.CycleType.R);
        return new Fixed(zoneOffset);
    }

    public static ZoneRules n(ZoneOffset zoneOffset, ZoneOffset zoneOffset2, List<ZoneOffsetTransition> list, List<ZoneOffsetTransition> list2, List<ZoneOffsetTransitionRule> list3) {
        Jdk8Methods.j(zoneOffset, "baseStandardOffset");
        Jdk8Methods.j(zoneOffset2, "baseWallOffset");
        Jdk8Methods.j(list, "standardOffsetTransitionList");
        Jdk8Methods.j(list2, "transitionList");
        Jdk8Methods.j(list3, "lastRules");
        return new StandardZoneRules(zoneOffset, zoneOffset2, list, list2, list3);
    }

    public abstract Duration a(Instant instant);

    public abstract ZoneOffset b(Instant instant);

    public abstract ZoneOffset c(LocalDateTime localDateTime);

    public abstract ZoneOffset d(Instant instant);

    public abstract ZoneOffsetTransition e(LocalDateTime localDateTime);

    public abstract boolean equals(Object obj);

    public abstract List<ZoneOffsetTransitionRule> f();

    public abstract List<ZoneOffsetTransition> g();

    public abstract List<ZoneOffset> h(LocalDateTime localDateTime);

    public abstract int hashCode();

    public abstract boolean i(Instant instant);

    public abstract boolean j();

    public abstract boolean k(LocalDateTime localDateTime, ZoneOffset zoneOffset);

    public abstract ZoneOffsetTransition l(Instant instant);

    public abstract ZoneOffsetTransition o(Instant instant);
}
