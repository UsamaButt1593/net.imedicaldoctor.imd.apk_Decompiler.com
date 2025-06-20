package okio;

import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001b\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lokio/JvmFileHandle;", "Lokio/FileHandle;", "", "readWrite", "Ljava/io/RandomAccessFile;", "randomAccessFile", "<init>", "(ZLjava/io/RandomAccessFile;)V", "", "size", "", "s", "(J)V", "t", "()J", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "r", "(J[BII)I", "u", "(J[BII)V", "q", "()V", "p", "Z", "Ljava/io/RandomAccessFile;", "okio"}, k = 1, mv = {1, 5, 1})
public final class JvmFileHandle extends FileHandle {
    @NotNull
    private final RandomAccessFile Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmFileHandle(boolean z, @NotNull RandomAccessFile randomAccessFile) {
        super(z);
        Intrinsics.p(randomAccessFile, "randomAccessFile");
        this.Z = randomAccessFile;
    }

    /* access modifiers changed from: protected */
    public synchronized void p() {
        this.Z.close();
    }

    /* access modifiers changed from: protected */
    public synchronized void q() {
        this.Z.getFD().sync();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int r(long r2, @org.jetbrains.annotations.NotNull byte[] r4, int r5, int r6) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)     // Catch:{ all -> 0x001f }
            java.io.RandomAccessFile r0 = r1.Z     // Catch:{ all -> 0x001f }
            r0.seek(r2)     // Catch:{ all -> 0x001f }
            r2 = 0
        L_0x000c:
            if (r2 >= r6) goto L_0x0021
            java.io.RandomAccessFile r3 = r1.Z     // Catch:{ all -> 0x001f }
            int r0 = r6 - r2
            int r3 = r3.read(r4, r5, r0)     // Catch:{ all -> 0x001f }
            r0 = -1
            if (r3 != r0) goto L_0x001d
            if (r2 != 0) goto L_0x0021
            monitor-exit(r1)
            return r0
        L_0x001d:
            int r2 = r2 + r3
            goto L_0x000c
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            monitor-exit(r1)
            return r2
        L_0x0023:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.JvmFileHandle.r(long, byte[], int, int):int");
    }

    /* access modifiers changed from: protected */
    public synchronized void s(long j2) {
        try {
            long H = H();
            long j3 = j2 - H;
            if (j3 > 0) {
                int i2 = (int) j3;
                u(H, new byte[i2], 0, i2);
            } else {
                this.Z.setLength(j2);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized long t() {
        return this.Z.length();
    }

    /* access modifiers changed from: protected */
    public synchronized void u(long j2, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "array");
        this.Z.seek(j2);
        this.Z.write(bArr, i2, i3);
    }
}
