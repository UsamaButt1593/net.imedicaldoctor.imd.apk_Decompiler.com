package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class FaultHidingSink extends ForwardingSink {
    private boolean X;

    FaultHidingSink(Sink sink) {
        super(sink);
    }

    public void close() throws IOException {
        if (!this.X) {
            try {
                super.close();
            } catch (IOException e2) {
                this.X = true;
                d(e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d(IOException iOException) {
    }

    public void flush() throws IOException {
        if (!this.X) {
            try {
                super.flush();
            } catch (IOException e2) {
                this.X = true;
                d(e2);
            }
        }
    }

    public void u1(Buffer buffer, long j2) throws IOException {
        if (this.X) {
            buffer.skip(j2);
            return;
        }
        try {
            super.u1(buffer, j2);
        } catch (IOException e2) {
            this.X = true;
            d(e2);
        }
    }
}
