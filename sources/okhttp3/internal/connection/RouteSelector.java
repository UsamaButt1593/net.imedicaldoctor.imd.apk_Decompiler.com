package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

public final class RouteSelector {

    /* renamed from: a  reason: collision with root package name */
    private final Address f31045a;

    /* renamed from: b  reason: collision with root package name */
    private final RouteDatabase f31046b;

    /* renamed from: c  reason: collision with root package name */
    private final Call f31047c;

    /* renamed from: d  reason: collision with root package name */
    private final EventListener f31048d;

    /* renamed from: e  reason: collision with root package name */
    private List<Proxy> f31049e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private int f31050f;

    /* renamed from: g  reason: collision with root package name */
    private List<InetSocketAddress> f31051g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    private final List<Route> f31052h = new ArrayList();

    public static final class Selection {

        /* renamed from: a  reason: collision with root package name */
        private final List<Route> f31053a;

        /* renamed from: b  reason: collision with root package name */
        private int f31054b = 0;

        Selection(List<Route> list) {
            this.f31053a = list;
        }

        public List<Route> a() {
            return new ArrayList(this.f31053a);
        }

        public boolean b() {
            return this.f31054b < this.f31053a.size();
        }

        public Route c() {
            if (b()) {
                List<Route> list = this.f31053a;
                int i2 = this.f31054b;
                this.f31054b = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.f31045a = address;
        this.f31046b = routeDatabase;
        this.f31047c = call;
        this.f31048d = eventListener;
        h(address.l(), address.g());
    }

    static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean d() {
        return this.f31050f < this.f31049e.size();
    }

    private Proxy f() throws IOException {
        if (d()) {
            List<Proxy> list = this.f31049e;
            int i2 = this.f31050f;
            this.f31050f = i2 + 1;
            Proxy proxy = list.get(i2);
            g(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f31045a.l().p() + "; exhausted proxy configurations: " + this.f31049e);
    }

    private void g(Proxy proxy) throws IOException {
        String str;
        int i2;
        this.f31051g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f31045a.l().p();
            i2 = this.f31045a.l().E();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = b(inetSocketAddress);
                i2 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i2 < 1 || i2 > 65535) {
            throw new SocketException("No route to " + str + ":" + i2 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f31051g.add(InetSocketAddress.createUnresolved(str, i2));
        } else {
            this.f31048d.j(this.f31047c, str);
            List<InetAddress> a2 = this.f31045a.c().a(str);
            if (!a2.isEmpty()) {
                this.f31048d.i(this.f31047c, str, a2);
                int size = a2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f31051g.add(new InetSocketAddress(a2.get(i3), i2));
                }
                return;
            }
            throw new UnknownHostException(this.f31045a.c() + " returned no addresses for " + str);
        }
    }

    private void h(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> v;
        if (proxy != null) {
            v = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f31045a.i().select(httpUrl.R());
            if (select == null || select.isEmpty()) {
                v = Util.v(Proxy.NO_PROXY);
            } else {
                v = Util.u(select);
            }
        }
        this.f31049e = v;
        this.f31050f = 0;
    }

    public void a(Route route, IOException iOException) {
        if (!(route.b().type() == Proxy.Type.DIRECT || this.f31045a.i() == null)) {
            this.f31045a.i().connectFailed(this.f31045a.l().R(), route.b().address(), iOException);
        }
        this.f31046b.b(route);
    }

    public boolean c() {
        return d() || !this.f31052h.isEmpty();
    }

    public Selection e() throws IOException {
        if (c()) {
            ArrayList arrayList = new ArrayList();
            while (d()) {
                Proxy f2 = f();
                int size = this.f31051g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Route route = new Route(this.f31045a, f2, this.f31051g.get(i2));
                    if (this.f31046b.c(route)) {
                        this.f31052h.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f31052h);
                this.f31052h.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
