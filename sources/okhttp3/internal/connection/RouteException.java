package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.Util;

public final class RouteException extends RuntimeException {
    private IOException X;
    private IOException s;

    public RouteException(IOException iOException) {
        super(iOException);
        this.s = iOException;
        this.X = iOException;
    }

    public void a(IOException iOException) {
        Util.a(this.s, iOException);
        this.X = iOException;
    }

    public IOException b() {
        return this.s;
    }

    public IOException c() {
        return this.X;
    }
}
