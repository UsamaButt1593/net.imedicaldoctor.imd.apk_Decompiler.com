package com.google.common.net;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.net.InetAddress;
import java.text.ParseException;
import javax.annotation.CheckForNull;

@GwtIncompatible
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
public final class HostSpecifier {

    /* renamed from: a  reason: collision with root package name */
    private final String f22872a;

    private HostSpecifier(String str) {
        this.f22872a = str;
    }

    @CanIgnoreReturnValue
    public static HostSpecifier a(String str) throws ParseException {
        try {
            return b(str);
        } catch (IllegalArgumentException e2) {
            ParseException parseException = new ParseException("Invalid host specifier: " + str, 0);
            parseException.initCause(e2);
            throw parseException;
        }
    }

    public static HostSpecifier b(String str) {
        InetAddress inetAddress;
        HostAndPort c2 = HostAndPort.c(str);
        Preconditions.d(!c2.h());
        String d2 = c2.d();
        try {
            inetAddress = InetAddresses.g(d2);
        } catch (IllegalArgumentException unused) {
            inetAddress = null;
        }
        if (inetAddress != null) {
            return new HostSpecifier(InetAddresses.O(inetAddress));
        }
        InternetDomainName d3 = InternetDomainName.d(d2);
        if (d3.f()) {
            return new HostSpecifier(d3.toString());
        }
        throw new IllegalArgumentException("Domain name does not have a recognized public suffix: " + d2);
    }

    public static boolean c(String str) {
        try {
            b(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostSpecifier) {
            return this.f22872a.equals(((HostSpecifier) obj).f22872a);
        }
        return false;
    }

    public int hashCode() {
        return this.f22872a.hashCode();
    }

    public String toString() {
        return this.f22872a;
    }
}
