package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Sink;

public interface HttpCodec {

    /* renamed from: a  reason: collision with root package name */
    public static final int f31072a = 100;

    void a() throws IOException;

    void b(Request request) throws IOException;

    ResponseBody c(Response response) throws IOException;

    void cancel();

    Response.Builder d(boolean z) throws IOException;

    void e() throws IOException;

    Sink f(Request request, long j2);
}
