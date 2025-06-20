package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

public final class RouteDatabase {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Route> f31044a = new LinkedHashSet();

    public synchronized void a(Route route) {
        this.f31044a.remove(route);
    }

    public synchronized void b(Route route) {
        this.f31044a.add(route);
    }

    public synchronized boolean c(Route route) {
        return this.f31044a.contains(route);
    }
}
