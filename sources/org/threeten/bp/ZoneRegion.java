package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

final class ZoneRegion extends ZoneId implements Serializable {
    private static final long Y2 = 8386373296231747096L;
    private static final Pattern Z2 = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    private final transient ZoneRules X2;
    private final String Z;

    ZoneRegion(String str, ZoneRules zoneRules) {
        this.Z = str;
        this.X2 = zoneRules;
    }

    static ZoneRegion C(String str, boolean z) {
        ZoneRules zoneRules;
        Jdk8Methods.j(str, "zoneId");
        if (str.length() < 2 || !Z2.matcher(str).matches()) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
        try {
            zoneRules = ZoneRulesProvider.c(str, true);
        } catch (ZoneRulesException e2) {
            if (str.equals("GMT0")) {
                zoneRules = ZoneOffset.g3.u();
            } else if (!z) {
                zoneRules = null;
            } else {
                throw e2;
            }
        }
        return new ZoneRegion(str, zoneRules);
    }

    private static ZoneRegion D(String str) {
        if (str.equals("Z") || str.startsWith("+") || str.startsWith("-")) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
        } else if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
            return new ZoneRegion(str, ZoneOffset.g3.u());
        } else {
            if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
                ZoneOffset H = ZoneOffset.H(str.substring(3));
                if (H.F() == 0) {
                    return new ZoneRegion(str.substring(0, 3), H.u());
                }
                return new ZoneRegion(str.substring(0, 3) + H.s(), H.u());
            } else if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
                return C(str, false);
            } else {
                ZoneOffset H2 = ZoneOffset.H(str.substring(2));
                if (H2.F() == 0) {
                    return new ZoneRegion("UT", H2.u());
                }
                return new ZoneRegion("UT" + H2.s(), H2.u());
            }
        }
    }

    static ZoneId E(DataInput dataInput) throws IOException {
        return D(dataInput.readUTF());
    }

    private Object F() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object I() {
        return new Ser((byte) 7, this);
    }

    /* access modifiers changed from: package-private */
    public void A(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(7);
        H(dataOutput);
    }

    /* access modifiers changed from: package-private */
    public void H(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.Z);
    }

    public String s() {
        return this.Z;
    }

    public ZoneRules u() {
        ZoneRules zoneRules = this.X2;
        return zoneRules != null ? zoneRules : ZoneRulesProvider.c(this.Z, false);
    }
}
