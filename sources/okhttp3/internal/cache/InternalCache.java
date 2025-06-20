package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

public interface InternalCache {
    void a();

    void b(CacheStrategy cacheStrategy);

    void c(Request request) throws IOException;

    CacheRequest d(Response response) throws IOException;

    Response e(Request request) throws IOException;

    void f(Response response, Response response2);
}
