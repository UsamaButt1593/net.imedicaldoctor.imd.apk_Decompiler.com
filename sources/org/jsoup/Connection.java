package org.jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public interface Connection {

    public interface Base<T extends Base> {
        Method A();

        T B(String str);

        Map<String, String> G();

        String H(String str);

        boolean K(String str);

        T L(String str);

        String M(String str);

        Map<String, String> N();

        T a(String str, String str2);

        T c(Method method);

        T f(String str, String str2);

        T r(URL url);

        boolean v(String str);

        URL y();

        boolean z(String str, String str2);
    }

    public interface KeyVal {
        KeyVal a(String str);

        KeyVal b(InputStream inputStream);

        KeyVal c(String str);

        String d();

        boolean e();

        String value();

        InputStream z();
    }

    public enum Method {
        GET(false),
        POST(true),
        PUT(true),
        DELETE(false),
        PATCH(true),
        HEAD(false),
        OPTIONS(false),
        TRACE(false);
        
        private final boolean s;

        private Method(boolean z) {
            this.s = z;
        }

        public final boolean a() {
            return this.s;
        }
    }

    public interface Request extends Base<Request> {
        Proxy C();

        Request F(KeyVal keyVal);

        boolean I();

        String P();

        int Q();

        Parser T();

        Request b(boolean z);

        Request d(String str);

        Request e(String str, int i2);

        Request g(int i2);

        Request h(int i2);

        Collection<KeyVal> i();

        int j();

        void l(boolean z);

        Request m(boolean z);

        Request n(String str);

        Request o(Proxy proxy);

        Request p(boolean z);

        Request q(Parser parser);

        boolean s();

        String t();

        boolean u();

        boolean x();
    }

    public interface Response extends Base<Response> {
        String D();

        Response E(String str);

        Document J() throws IOException;

        int O();

        String R();

        byte[] S();

        String k();

        String w();
    }

    Connection A(Response response);

    Document B() throws IOException;

    Connection C(String... strArr);

    KeyVal D(String str);

    Connection E(Map<String, String> map);

    Connection a(String str, String str2);

    Connection b(boolean z);

    Connection c(Method method);

    Connection d(String str);

    Connection e(String str, int i2);

    Response execute() throws IOException;

    Connection f(String str, String str2);

    Connection g(int i2);

    Document get() throws IOException;

    Connection h(int i2);

    Connection i(String str);

    Connection j(Collection<KeyVal> collection);

    Request k();

    Connection l(boolean z);

    Connection m(boolean z);

    Connection n(String str);

    Connection o(Proxy proxy);

    Connection p(boolean z);

    Connection q(Parser parser);

    Connection r(URL url);

    Connection s(Map<String, String> map);

    Connection t(Request request);

    Connection u(String str);

    Response v();

    Connection w(String str, String str2);

    Connection x(String str);

    Connection y(Map<String, String> map);

    Connection z(String str, String str2, InputStream inputStream);
}
