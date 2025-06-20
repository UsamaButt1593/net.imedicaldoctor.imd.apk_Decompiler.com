package androidx.media3.datasource;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

public class DataSourceException extends IOException {
    @UnstableApi
    @Deprecated
    public static final int X = 2008;
    public final int s;

    @UnstableApi
    public DataSourceException(int i2) {
        this.s = i2;
    }

    @UnstableApi
    public static boolean a(IOException iOException) {
        Throwable th;
        while (th != null) {
            if ((th instanceof DataSourceException) && ((DataSourceException) th).s == 2008) {
                return true;
            }
            Throwable cause = th.getCause();
            th = iOException;
            th = cause;
        }
        return false;
    }

    @UnstableApi
    public DataSourceException(@Nullable String str, int i2) {
        super(str);
        this.s = i2;
    }

    @UnstableApi
    public DataSourceException(@Nullable String str, @Nullable Throwable th, int i2) {
        super(str, th);
        this.s = i2;
    }

    @UnstableApi
    public DataSourceException(@Nullable Throwable th, int i2) {
        super(th);
        this.s = i2;
    }
}
