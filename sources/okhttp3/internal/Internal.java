package okhttp3.internal;

import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;

public abstract class Internal {

    /* renamed from: a  reason: collision with root package name */
    public static Internal f30969a;

    public static void i() {
        new OkHttpClient();
    }

    public abstract void a(Headers.Builder builder, String str);

    public abstract void b(Headers.Builder builder, String str, String str2);

    public abstract void c(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    public abstract int d(Response.Builder builder);

    public abstract boolean e(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract Socket f(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    public abstract boolean g(Address address, Address address2);

    public abstract RealConnection h(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route);

    public abstract boolean j(IllegalArgumentException illegalArgumentException);

    public abstract Call k(OkHttpClient okHttpClient, Request request);

    public abstract void l(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract RouteDatabase m(ConnectionPool connectionPool);

    public abstract void n(OkHttpClient.Builder builder, InternalCache internalCache);

    public abstract StreamAllocation o(Call call);

    @Nullable
    public abstract IOException p(Call call, @Nullable IOException iOException);
}
