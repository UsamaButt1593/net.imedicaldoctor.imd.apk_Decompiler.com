package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

public interface WebSocket {

    public interface Factory {
        WebSocket b(Request request, WebSocketListener webSocketListener);
    }

    boolean a(ByteString byteString);

    boolean b(String str);

    void cancel();

    boolean f(int i2, @Nullable String str);

    long g();

    Request k();
}
