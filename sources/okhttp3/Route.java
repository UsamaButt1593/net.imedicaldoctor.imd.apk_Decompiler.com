package okhttp3;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

public final class Route {

    /* renamed from: a  reason: collision with root package name */
    final Address f30966a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f30967b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f30968c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f30966a = address;
            this.f30967b = proxy;
            this.f30968c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public Address a() {
        return this.f30966a;
    }

    public Proxy b() {
        return this.f30967b;
    }

    public boolean c() {
        return this.f30966a.f30734i != null && this.f30967b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f30968c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return route.f30966a.equals(this.f30966a) && route.f30967b.equals(this.f30967b) && route.f30968c.equals(this.f30968c);
        }
    }

    public int hashCode() {
        return ((((MetaDo.w + this.f30966a.hashCode()) * 31) + this.f30967b.hashCode()) * 31) + this.f30968c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f30968c + "}";
    }
}
