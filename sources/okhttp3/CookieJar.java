package okhttp3;

import java.util.Collections;
import java.util.List;

public interface CookieJar {

    /* renamed from: a  reason: collision with root package name */
    public static final CookieJar f30847a = new CookieJar() {
        public void a(HttpUrl httpUrl, List<Cookie> list) {
        }

        public List<Cookie> b(HttpUrl httpUrl) {
            return Collections.emptyList();
        }
    };

    void a(HttpUrl httpUrl, List<Cookie> list);

    List<Cookie> b(HttpUrl httpUrl);
}
