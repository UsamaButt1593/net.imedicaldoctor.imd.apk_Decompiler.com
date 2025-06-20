package okhttp3;

import java.io.IOException;

public interface Callback {
    void a(Call call, Response response) throws IOException;

    void b(Call call, IOException iOException);
}
