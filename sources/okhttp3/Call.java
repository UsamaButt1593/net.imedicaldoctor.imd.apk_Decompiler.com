package okhttp3;

import java.io.IOException;
import okio.Timeout;

public interface Call extends Cloneable {

    public interface Factory {
        Call a(Request request);
    }

    boolean T0();

    void cancel();

    Call clone();

    void e0(Callback callback);

    Response execute() throws IOException;

    boolean i1();

    Timeout j();

    Request k();
}
