package okio;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002BCB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0016\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\rJ\r\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010 \u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b \u0010\u0011J\r\u0010!\u001a\u00020\u000f¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020#¢\u0006\u0004\b&\u0010'J\u001d\u0010)\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020+¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020+¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020+2\u0006\u0010(\u001a\u00020\u0007¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u000f¢\u0006\u0004\b4\u0010\"J/\u00105\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014H$¢\u0006\u0004\b5\u0010\u0017J/\u00106\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014H$¢\u0006\u0004\b6\u0010\u001fJ\u000f\u00107\u001a\u00020\u000fH$¢\u0006\u0004\b7\u0010\"J\u0017\u00108\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0007H$¢\u0006\u0004\b8\u0010\u001dJ\u000f\u00109\u001a\u00020\u0007H$¢\u0006\u0004\b9\u0010\u001aJ\u000f\u0010:\u001a\u00020\u000fH$¢\u0006\u0004\b:\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b8\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010;R\u0016\u0010A\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010$¨\u0006D"}, d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "", "readWrite", "<init>", "(Z)V", "", "fileOffset", "Lokio/Buffer;", "sink", "byteCount", "x", "(JLokio/Buffer;J)J", "source", "", "O", "(JLokio/Buffer;J)V", "", "array", "", "arrayOffset", "v", "(J[BII)I", "w", "H", "()J", "size", "C", "(J)V", "N", "(J[BII)V", "L", "flush", "()V", "Lokio/Source;", "I", "(J)Lokio/Source;", "n", "(Lokio/Source;)J", "position", "A", "(Lokio/Source;J)V", "Lokio/Sink;", "F", "(J)Lokio/Sink;", "h", "()Lokio/Sink;", "k", "(Lokio/Sink;)J", "y", "(Lokio/Sink;J)V", "close", "r", "u", "q", "s", "t", "p", "Z", "i", "()Z", "X", "closed", "Y", "openStreamCount", "FileHandleSink", "FileHandleSource", "okio"}, k = 1, mv = {1, 5, 1})
public abstract class FileHandle implements Closeable {
    /* access modifiers changed from: private */
    public boolean X;
    /* access modifiers changed from: private */
    public int Y;
    private final boolean s;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "Lokio/FileHandle;", "fileHandle", "", "position", "<init>", "(Lokio/FileHandle;J)V", "Lokio/Buffer;", "source", "byteCount", "", "u1", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "close", "s", "Lokio/FileHandle;", "c", "()Lokio/FileHandle;", "X", "J", "d", "()J", "f", "(J)V", "", "Y", "Z", "b", "()Z", "e", "(Z)V", "closed", "okio"}, k = 1, mv = {1, 5, 1})
    private static final class FileHandleSink implements Sink {
        private long X;
        private boolean Y;
        @NotNull
        private final FileHandle s;

        public FileHandleSink(@NotNull FileHandle fileHandle, long j2) {
            Intrinsics.p(fileHandle, "fileHandle");
            this.s = fileHandle;
            this.X = j2;
        }

        public final boolean b() {
            return this.Y;
        }

        @NotNull
        public final FileHandle c() {
            return this.s;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r3 = this;
                boolean r0 = r3.Y
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                r0 = 1
                r3.Y = r0
                okio.FileHandle r0 = r3.s
                monitor-enter(r0)
                okio.FileHandle r1 = r3.c()     // Catch:{ all -> 0x0036 }
                int r2 = r1.Y     // Catch:{ all -> 0x0036 }
                int r2 = r2 + -1
                r1.Y = r2     // Catch:{ all -> 0x0036 }
                okio.FileHandle r1 = r3.c()     // Catch:{ all -> 0x0036 }
                int r1 = r1.Y     // Catch:{ all -> 0x0036 }
                if (r1 != 0) goto L_0x0038
                okio.FileHandle r1 = r3.c()     // Catch:{ all -> 0x0036 }
                boolean r1 = r1.X     // Catch:{ all -> 0x0036 }
                if (r1 != 0) goto L_0x002d
                goto L_0x0038
            L_0x002d:
                kotlin.Unit r1 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0036 }
                monitor-exit(r0)
                okio.FileHandle r0 = r3.s
                r0.p()
                return
            L_0x0036:
                r1 = move-exception
                goto L_0x003a
            L_0x0038:
                monitor-exit(r0)
                return
            L_0x003a:
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.FileHandle.FileHandleSink.close():void");
        }

        public final long d() {
            return this.X;
        }

        public final void e(boolean z) {
            this.Y = z;
        }

        public final void f(long j2) {
            this.X = j2;
        }

        public void flush() {
            if (!this.Y) {
                this.s.q();
                return;
            }
            throw new IllegalStateException("closed".toString());
        }

        @NotNull
        public Timeout j() {
            return Timeout.f31400e;
        }

        public void u1(@NotNull Buffer buffer, long j2) {
            Intrinsics.p(buffer, "source");
            if (!this.Y) {
                this.s.O(this.X, buffer, j2);
                this.X += j2;
                return;
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "Lokio/FileHandle;", "fileHandle", "", "position", "<init>", "(Lokio/FileHandle;J)V", "Lokio/Buffer;", "sink", "byteCount", "n2", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "", "close", "()V", "s", "Lokio/FileHandle;", "c", "()Lokio/FileHandle;", "X", "J", "d", "()J", "f", "(J)V", "", "Y", "Z", "b", "()Z", "e", "(Z)V", "closed", "okio"}, k = 1, mv = {1, 5, 1})
    private static final class FileHandleSource implements Source {
        private long X;
        private boolean Y;
        @NotNull
        private final FileHandle s;

        public FileHandleSource(@NotNull FileHandle fileHandle, long j2) {
            Intrinsics.p(fileHandle, "fileHandle");
            this.s = fileHandle;
            this.X = j2;
        }

        public final boolean b() {
            return this.Y;
        }

        @NotNull
        public final FileHandle c() {
            return this.s;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r3 = this;
                boolean r0 = r3.Y
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                r0 = 1
                r3.Y = r0
                okio.FileHandle r0 = r3.s
                monitor-enter(r0)
                okio.FileHandle r1 = r3.c()     // Catch:{ all -> 0x0036 }
                int r2 = r1.Y     // Catch:{ all -> 0x0036 }
                int r2 = r2 + -1
                r1.Y = r2     // Catch:{ all -> 0x0036 }
                okio.FileHandle r1 = r3.c()     // Catch:{ all -> 0x0036 }
                int r1 = r1.Y     // Catch:{ all -> 0x0036 }
                if (r1 != 0) goto L_0x0038
                okio.FileHandle r1 = r3.c()     // Catch:{ all -> 0x0036 }
                boolean r1 = r1.X     // Catch:{ all -> 0x0036 }
                if (r1 != 0) goto L_0x002d
                goto L_0x0038
            L_0x002d:
                kotlin.Unit r1 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0036 }
                monitor-exit(r0)
                okio.FileHandle r0 = r3.s
                r0.p()
                return
            L_0x0036:
                r1 = move-exception
                goto L_0x003a
            L_0x0038:
                monitor-exit(r0)
                return
            L_0x003a:
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.FileHandle.FileHandleSource.close():void");
        }

        public final long d() {
            return this.X;
        }

        public final void e(boolean z) {
            this.Y = z;
        }

        public final void f(long j2) {
            this.X = j2;
        }

        @NotNull
        public Timeout j() {
            return Timeout.f31400e;
        }

        public long n2(@NotNull Buffer buffer, long j2) {
            Intrinsics.p(buffer, "sink");
            if (!this.Y) {
                long d2 = this.s.x(this.X, buffer, j2);
                if (d2 != -1) {
                    this.X += d2;
                }
                return d2;
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    public FileHandle(boolean z) {
        this.s = z;
    }

    public static /* synthetic */ Sink G(FileHandle fileHandle, long j2, int i2, Object obj) throws IOException {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                j2 = 0;
            }
            return fileHandle.F(j2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public static /* synthetic */ Source J(FileHandle fileHandle, long j2, int i2, Object obj) throws IOException {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                j2 = 0;
            }
            return fileHandle.I(j2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
    }

    /* access modifiers changed from: private */
    public final void O(long j2, Buffer buffer, long j3) {
        _UtilKt.e(buffer.L0(), 0, j3);
        long j4 = j3 + j2;
        while (j2 < j4) {
            Segment segment = buffer.s;
            Intrinsics.m(segment);
            int min = (int) Math.min(j4 - j2, (long) (segment.f31384c - segment.f31383b));
            u(j2, segment.f31382a, segment.f31383b, min);
            segment.f31383b += min;
            long j5 = (long) min;
            j2 += j5;
            buffer.C0(buffer.L0() - j5);
            if (segment.f31383b == segment.f31384c) {
                buffer.s = segment.b();
                SegmentPool.d(segment);
            }
        }
    }

    /* access modifiers changed from: private */
    public final long x(long j2, Buffer buffer, long j3) {
        Buffer buffer2 = buffer;
        if (j3 >= 0) {
            long j4 = j2 + j3;
            long j5 = j2;
            while (true) {
                if (j5 >= j4) {
                    break;
                }
                Segment Y0 = buffer2.Y0(1);
                byte[] bArr = Y0.f31382a;
                int i2 = Y0.f31384c;
                int r = r(j5, bArr, i2, (int) Math.min(j4 - j5, (long) (8192 - i2)));
                if (r == -1) {
                    if (Y0.f31383b == Y0.f31384c) {
                        buffer2.s = Y0.b();
                        SegmentPool.d(Y0);
                    }
                    if (j2 == j5) {
                        return -1;
                    }
                } else {
                    Y0.f31384c += r;
                    long j6 = (long) r;
                    j5 += j6;
                    buffer2.C0(buffer.L0() + j6);
                }
            }
            return j5 - j2;
        }
        throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j3)).toString());
    }

    public final void A(@NotNull Source source, long j2) throws IOException {
        Intrinsics.p(source, "source");
        boolean z = false;
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            Source source2 = realBufferedSource.s;
            if ((source2 instanceof FileHandleSource) && ((FileHandleSource) source2).c() == this) {
                z = true;
            }
            if (z) {
                FileHandleSource fileHandleSource = (FileHandleSource) source2;
                if (!fileHandleSource.b()) {
                    long L0 = realBufferedSource.X.L0();
                    long d2 = j2 - (fileHandleSource.d() - L0);
                    if (0 > d2 || d2 >= L0) {
                        realBufferedSource.X.d();
                        fileHandleSource.f(j2);
                        return;
                    }
                    realBufferedSource.skip(d2);
                    return;
                }
                throw new IllegalStateException("closed".toString());
            }
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        if ((source instanceof FileHandleSource) && ((FileHandleSource) source).c() == this) {
            z = true;
        }
        if (z) {
            FileHandleSource fileHandleSource2 = (FileHandleSource) source;
            if (!fileHandleSource2.b()) {
                fileHandleSource2.f(j2);
                return;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    }

    public final void C(long j2) throws IOException {
        if (this.s) {
            synchronized (this) {
                if (!this.X) {
                    Unit unit = Unit.f28779a;
                } else {
                    throw new IllegalStateException("closed".toString());
                }
            }
            s(j2);
            return;
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    @NotNull
    public final Sink F(long j2) throws IOException {
        if (this.s) {
            synchronized (this) {
                if (!this.X) {
                    this.Y++;
                } else {
                    throw new IllegalStateException("closed".toString());
                }
            }
            return new FileHandleSink(this, j2);
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final long H() throws IOException {
        synchronized (this) {
            if (!this.X) {
                Unit unit = Unit.f28779a;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        return t();
    }

    @NotNull
    public final Source I(long j2) throws IOException {
        synchronized (this) {
            if (!this.X) {
                this.Y++;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        return new FileHandleSource(this, j2);
    }

    public final void L(long j2, @NotNull Buffer buffer, long j3) throws IOException {
        Intrinsics.p(buffer, "source");
        if (this.s) {
            synchronized (this) {
                if (!this.X) {
                    Unit unit = Unit.f28779a;
                } else {
                    throw new IllegalStateException("closed".toString());
                }
            }
            O(j2, buffer, j3);
            return;
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final void N(long j2, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "array");
        if (this.s) {
            synchronized (this) {
                if (!this.X) {
                    Unit unit = Unit.f28779a;
                } else {
                    throw new IllegalStateException("closed".toString());
                }
            }
            u(j2, bArr, i2, i3);
            return;
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final void close() throws IOException {
        synchronized (this) {
            if (!this.X) {
                this.X = true;
                if (this.Y == 0) {
                    Unit unit = Unit.f28779a;
                    p();
                }
            }
        }
    }

    public final void flush() throws IOException {
        if (this.s) {
            synchronized (this) {
                if (!this.X) {
                    Unit unit = Unit.f28779a;
                } else {
                    throw new IllegalStateException("closed".toString());
                }
            }
            q();
            return;
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    @NotNull
    public final Sink h() throws IOException {
        return F(H());
    }

    public final boolean i() {
        return this.s;
    }

    public final long k(@NotNull Sink sink) throws IOException {
        long j2;
        Intrinsics.p(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            j2 = realBufferedSink.X.L0();
            sink = realBufferedSink.s;
        } else {
            j2 = 0;
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).c() == this) {
            FileHandleSink fileHandleSink = (FileHandleSink) sink;
            if (!fileHandleSink.b()) {
                return fileHandleSink.d() + j2;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }

    public final long n(@NotNull Source source) throws IOException {
        long j2;
        Intrinsics.p(source, "source");
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            j2 = realBufferedSource.X.L0();
            source = realBufferedSource.s;
        } else {
            j2 = 0;
        }
        if ((source instanceof FileHandleSource) && ((FileHandleSource) source).c() == this) {
            FileHandleSource fileHandleSource = (FileHandleSource) source;
            if (!fileHandleSource.b()) {
                return fileHandleSource.d() - j2;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    }

    /* access modifiers changed from: protected */
    public abstract void p() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void q() throws IOException;

    /* access modifiers changed from: protected */
    public abstract int r(long j2, @NotNull byte[] bArr, int i2, int i3) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void s(long j2) throws IOException;

    /* access modifiers changed from: protected */
    public abstract long t() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void u(long j2, @NotNull byte[] bArr, int i2, int i3) throws IOException;

    public final int v(long j2, @NotNull byte[] bArr, int i2, int i3) throws IOException {
        Intrinsics.p(bArr, "array");
        synchronized (this) {
            if (!this.X) {
                Unit unit = Unit.f28779a;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        return r(j2, bArr, i2, i3);
    }

    public final long w(long j2, @NotNull Buffer buffer, long j3) throws IOException {
        Intrinsics.p(buffer, "sink");
        synchronized (this) {
            if (!this.X) {
                Unit unit = Unit.f28779a;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        return x(j2, buffer, j3);
    }

    public final void y(@NotNull Sink sink, long j2) throws IOException {
        Intrinsics.p(sink, "sink");
        boolean z = false;
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            Sink sink2 = realBufferedSink.s;
            if ((sink2 instanceof FileHandleSink) && ((FileHandleSink) sink2).c() == this) {
                z = true;
            }
            if (z) {
                FileHandleSink fileHandleSink = (FileHandleSink) sink2;
                if (!fileHandleSink.b()) {
                    realBufferedSink.M();
                    fileHandleSink.f(j2);
                    return;
                }
                throw new IllegalStateException("closed".toString());
            }
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).c() == this) {
            z = true;
        }
        if (z) {
            FileHandleSink fileHandleSink2 = (FileHandleSink) sink;
            if (!fileHandleSink2.b()) {
                fileHandleSink2.f(j2);
                return;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }
}
