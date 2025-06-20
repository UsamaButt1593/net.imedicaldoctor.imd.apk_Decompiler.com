package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

public interface Connection {
    Protocol a();

    Route b();

    @Nullable
    Handshake c();

    Socket d();
}
