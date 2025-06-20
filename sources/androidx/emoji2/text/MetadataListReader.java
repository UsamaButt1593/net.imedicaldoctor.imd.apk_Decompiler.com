package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;
import net.lingala.zip4j.util.InternalZipConstants;

@RequiresApi(19)
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY})
class MetadataListReader {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7658a = 1164798569;

    /* renamed from: b  reason: collision with root package name */
    private static final int f7659b = 1701669481;

    /* renamed from: c  reason: collision with root package name */
    private static final int f7660c = 1835365473;

    private static class ByteBufferReader implements OpenTypeReader {
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final ByteBuffer f7661c;

        ByteBufferReader(@NonNull ByteBuffer byteBuffer) {
            this.f7661c = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public void b(int i2) throws IOException {
            ByteBuffer byteBuffer = this.f7661c;
            byteBuffer.position(byteBuffer.position() + i2);
        }

        public int c() throws IOException {
            return this.f7661c.getInt();
        }

        public long d() throws IOException {
            return MetadataListReader.e(this.f7661c.getInt());
        }

        public long getPosition() {
            return (long) this.f7661c.position();
        }

        public int readUnsignedShort() throws IOException {
            return MetadataListReader.f(this.f7661c.getShort());
        }
    }

    private static class InputStreamOpenTypeReader implements OpenTypeReader {
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f7662c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final ByteBuffer f7663d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private final InputStream f7664e;

        /* renamed from: f  reason: collision with root package name */
        private long f7665f = 0;

        InputStreamOpenTypeReader(@NonNull InputStream inputStream) {
            this.f7664e = inputStream;
            byte[] bArr = new byte[4];
            this.f7662c = bArr;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f7663d = wrap;
            wrap.order(ByteOrder.BIG_ENDIAN);
        }

        private void a(@IntRange(from = 0, to = 4) int i2) throws IOException {
            if (this.f7664e.read(this.f7662c, 0, i2) == i2) {
                this.f7665f += (long) i2;
                return;
            }
            throw new IOException("read failed");
        }

        public void b(int i2) throws IOException {
            while (i2 > 0) {
                int skip = (int) this.f7664e.skip((long) i2);
                if (skip >= 1) {
                    i2 -= skip;
                    this.f7665f += (long) skip;
                } else {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
            }
        }

        public int c() throws IOException {
            this.f7663d.position(0);
            a(4);
            return this.f7663d.getInt();
        }

        public long d() throws IOException {
            this.f7663d.position(0);
            a(4);
            return MetadataListReader.e(this.f7663d.getInt());
        }

        public long getPosition() {
            return this.f7665f;
        }

        public int readUnsignedShort() throws IOException {
            this.f7663d.position(0);
            a(2);
            return MetadataListReader.f(this.f7663d.getShort());
        }
    }

    private static class OffsetInfo {

        /* renamed from: a  reason: collision with root package name */
        private final long f7666a;

        /* renamed from: b  reason: collision with root package name */
        private final long f7667b;

        OffsetInfo(long j2, long j3) {
            this.f7666a = j2;
            this.f7667b = j3;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.f7667b;
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return this.f7666a;
        }
    }

    private interface OpenTypeReader {

        /* renamed from: a  reason: collision with root package name */
        public static final int f7668a = 2;

        /* renamed from: b  reason: collision with root package name */
        public static final int f7669b = 4;

        void b(int i2) throws IOException;

        int c() throws IOException;

        long d() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;
    }

    private MetadataListReader() {
    }

    private static OffsetInfo a(OpenTypeReader openTypeReader) throws IOException {
        long j2;
        openTypeReader.b(4);
        int readUnsignedShort = openTypeReader.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            openTypeReader.b(6);
            int i2 = 0;
            while (true) {
                if (i2 >= readUnsignedShort) {
                    j2 = -1;
                    break;
                }
                int c2 = openTypeReader.c();
                openTypeReader.b(4);
                j2 = openTypeReader.d();
                openTypeReader.b(4);
                if (1835365473 == c2) {
                    break;
                }
                i2++;
            }
            if (j2 != -1) {
                openTypeReader.b((int) (j2 - openTypeReader.getPosition()));
                openTypeReader.b(12);
                long d2 = openTypeReader.d();
                for (int i3 = 0; ((long) i3) < d2; i3++) {
                    int c3 = openTypeReader.c();
                    long d3 = openTypeReader.d();
                    long d4 = openTypeReader.d();
                    if (f7658a == c3 || f7659b == c3) {
                        return new OffsetInfo(d3 + j2, d4);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    static MetadataList b(AssetManager assetManager, String str) throws IOException {
        InputStream open = assetManager.open(str);
        try {
            MetadataList c2 = c(open);
            if (open != null) {
                open.close();
            }
            return c2;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    static MetadataList c(InputStream inputStream) throws IOException {
        InputStreamOpenTypeReader inputStreamOpenTypeReader = new InputStreamOpenTypeReader(inputStream);
        OffsetInfo a2 = a(inputStreamOpenTypeReader);
        inputStreamOpenTypeReader.b((int) (a2.b() - inputStreamOpenTypeReader.getPosition()));
        ByteBuffer allocate = ByteBuffer.allocate((int) a2.a());
        int read = inputStream.read(allocate.array());
        if (((long) read) == a2.a()) {
            return MetadataList.G(allocate);
        }
        throw new IOException("Needed " + a2.a() + " bytes, got " + read);
    }

    static MetadataList d(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new ByteBufferReader(duplicate)).b());
        return MetadataList.G(duplicate);
    }

    static long e(int i2) {
        return ((long) i2) & InternalZipConstants.f30717k;
    }

    static int f(short s) {
        return s & UShort.Z;
    }
}
