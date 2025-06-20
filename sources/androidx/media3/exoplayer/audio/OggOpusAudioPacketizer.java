package androidx.media3.exoplayer.audio;

import androidx.annotation.Nullable;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.extractor.OpusUtil;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

@UnstableApi
public final class OggOpusAudioPacketizer {

    /* renamed from: d  reason: collision with root package name */
    private static final int f10900d = 22;

    /* renamed from: e  reason: collision with root package name */
    private static final int f10901e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static final int f10902f = 28;

    /* renamed from: g  reason: collision with root package name */
    private static final int f10903g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f10904h = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.F, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, Byte.MIN_VALUE, -69, 0, 0, 0, 0, 0};

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f10905i = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 11, -103, 87, 83, 1, 16, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f10906a = AudioProcessor.f9380a;

    /* renamed from: b  reason: collision with root package name */
    private int f10907b = 2;

    /* renamed from: c  reason: collision with root package name */
    private int f10908c = 0;

    private ByteBuffer b(ByteBuffer byteBuffer, @Nullable byte[] bArr) {
        int i2;
        int E;
        ByteBuffer byteBuffer2 = byteBuffer;
        byte[] bArr2 = bArr;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i3 = limit - position;
        int i4 = (i3 + 255) / 255;
        int i5 = i4 + 27 + i3;
        if (this.f10907b == 2) {
            int length = bArr2 != null ? bArr2.length + 28 : f10904h.length;
            i5 += f10905i.length + length;
            i2 = length;
        } else {
            i2 = 0;
        }
        ByteBuffer c2 = c(i5);
        if (this.f10907b == 2) {
            if (bArr2 != null) {
                e(c2, bArr2);
            } else {
                c2.put(f10904h);
            }
            c2.put(f10905i);
        }
        int j2 = this.f10908c + OpusUtil.j(byteBuffer);
        this.f10908c = j2;
        ByteBuffer byteBuffer3 = c2;
        f(c2, (long) j2, this.f10907b, i4, false);
        for (int i6 = 0; i6 < i4; i6++) {
            if (i3 >= 255) {
                byteBuffer3.put((byte) -1);
                i3 -= 255;
            } else {
                byteBuffer3.put((byte) i3);
                i3 = 0;
            }
        }
        while (position < limit) {
            byteBuffer3.put(byteBuffer2.get(position));
            position++;
        }
        byteBuffer2.position(byteBuffer.limit());
        byteBuffer3.flip();
        int i7 = 22;
        if (this.f10907b == 2) {
            byte[] array = byteBuffer3.array();
            byte[] bArr3 = f10905i;
            E = Util.E(array, byteBuffer3.arrayOffset() + i2 + bArr3.length, byteBuffer3.limit() - byteBuffer3.position(), 0);
            i7 = i2 + bArr3.length + 22;
        } else {
            E = Util.E(byteBuffer3.array(), byteBuffer3.arrayOffset(), byteBuffer3.limit() - byteBuffer3.position(), 0);
        }
        byteBuffer3.putInt(i7, E);
        this.f10907b++;
        return byteBuffer3;
    }

    private ByteBuffer c(int i2) {
        if (this.f10906a.capacity() < i2) {
            this.f10906a = ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f10906a.clear();
        }
        return this.f10906a;
    }

    private void e(ByteBuffer byteBuffer, byte[] bArr) {
        f(byteBuffer, 0, 0, 1, true);
        byteBuffer.put(UnsignedBytes.a((long) bArr.length));
        byteBuffer.put(bArr);
        byteBuffer.putInt(22, Util.E(byteBuffer.array(), byteBuffer.arrayOffset(), bArr.length + 28, 0));
        byteBuffer.position(bArr.length + 28);
    }

    private void f(ByteBuffer byteBuffer, long j2, int i2, int i3, boolean z) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(z ? (byte) 2 : 0);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i2);
        byteBuffer.putInt(0);
        byteBuffer.put(UnsignedBytes.a((long) i3));
    }

    public void a(DecoderInputBuffer decoderInputBuffer, List<byte[]> list) {
        Assertions.g(decoderInputBuffer.Z);
        if (decoderInputBuffer.Z.limit() - decoderInputBuffer.Z.position() != 0) {
            this.f10906a = b(decoderInputBuffer.Z, (this.f10907b == 2 && (list.size() == 1 || list.size() == 3)) ? list.get(0) : null);
            decoderInputBuffer.g();
            decoderInputBuffer.r(this.f10906a.remaining());
            decoderInputBuffer.Z.put(this.f10906a);
            decoderInputBuffer.s();
        }
    }

    public void d() {
        this.f10906a = AudioProcessor.f9380a;
        this.f10908c = 0;
        this.f10907b = 2;
    }
}
