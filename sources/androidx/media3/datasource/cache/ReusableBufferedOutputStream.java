package androidx.media3.datasource.cache;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@UnstableApi
final class ReusableBufferedOutputStream extends BufferedOutputStream {
    private boolean s;

    public ReusableBufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void b(OutputStream outputStream) {
        Assertions.i(this.s);
        this.out = outputStream;
        this.count = 0;
        this.s = false;
    }

    public void close() throws IOException {
        this.s = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            Util.n2(th);
        }
    }

    public ReusableBufferedOutputStream(OutputStream outputStream, int i2) {
        super(outputStream, i2);
    }
}
