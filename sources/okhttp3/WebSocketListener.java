package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

public abstract class WebSocketListener {
    public void a(WebSocket webSocket, int i2, String str) {
    }

    public void b(WebSocket webSocket, int i2, String str) {
    }

    public void c(WebSocket webSocket, Throwable th, @Nullable Response response) {
    }

    public void d(WebSocket webSocket, String str) {
    }

    public void e(WebSocket webSocket, ByteString byteString) {
    }

    public void f(WebSocket webSocket, Response response) {
    }
}
