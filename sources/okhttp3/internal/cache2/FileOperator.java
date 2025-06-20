package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;

final class FileOperator {

    /* renamed from: a  reason: collision with root package name */
    private final FileChannel f31011a;

    FileOperator(FileChannel fileChannel) {
        this.f31011a = fileChannel;
    }

    public void a(long j2, Buffer buffer, long j3) throws IOException {
        if (j3 >= 0) {
            while (j3 > 0) {
                long transferTo = this.f31011a.transferTo(j2, j3, buffer);
                j2 += transferTo;
                j3 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public void b(long j2, Buffer buffer, long j3) throws IOException {
        if (j3 < 0 || j3 > buffer.L0()) {
            throw new IndexOutOfBoundsException();
        }
        long j4 = j2;
        long j5 = j3;
        while (j5 > 0) {
            long transferFrom = this.f31011a.transferFrom(buffer, j4, j5);
            j4 += transferFrom;
            j5 -= transferFrom;
        }
    }
}
