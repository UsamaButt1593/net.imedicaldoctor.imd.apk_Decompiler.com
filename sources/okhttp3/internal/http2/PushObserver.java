package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

public interface PushObserver {

    /* renamed from: a  reason: collision with root package name */
    public static final PushObserver f31213a = new PushObserver() {
        public boolean a(int i2, List<Header> list) {
            return true;
        }

        public boolean b(int i2, List<Header> list, boolean z) {
            return true;
        }

        public void c(int i2, ErrorCode errorCode) {
        }

        public boolean d(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException {
            bufferedSource.skip((long) i3);
            return true;
        }
    };

    boolean a(int i2, List<Header> list);

    boolean b(int i2, List<Header> list, boolean z);

    void c(int i2, ErrorCode errorCode);

    boolean d(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException;
}
