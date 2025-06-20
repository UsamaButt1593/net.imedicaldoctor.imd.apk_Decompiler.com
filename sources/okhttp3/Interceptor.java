package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public interface Interceptor {

    public interface Chain {
        Chain a(int i2, TimeUnit timeUnit);

        int b();

        int c();

        Call call();

        Chain d(int i2, TimeUnit timeUnit);

        Response e(Request request) throws IOException;

        @Nullable
        Connection f();

        Chain g(int i2, TimeUnit timeUnit);

        int h();

        Request k();
    }

    Response a(Chain chain) throws IOException;
}
