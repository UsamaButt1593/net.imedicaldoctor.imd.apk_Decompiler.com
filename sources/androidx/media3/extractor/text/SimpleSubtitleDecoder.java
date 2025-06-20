package androidx.media3.extractor.text;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.SimpleDecoder;
import java.nio.ByteBuffer;

@UnstableApi
public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {
    private final String o;

    protected SimpleSubtitleDecoder(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.o = str;
        x(1024);
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public final SubtitleOutputBuffer k() {
        return new SubtitleOutputBuffer() {
            public void q() {
                SimpleSubtitleDecoder.this.u(this);
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public final SubtitleDecoderException l(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    public abstract Subtitle C(byte[] bArr, int i2, boolean z) throws SubtitleDecoderException;

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: D */
    public final SubtitleDecoderException m(SubtitleInputBuffer subtitleInputBuffer, SubtitleOutputBuffer subtitleOutputBuffer, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.g(subtitleInputBuffer.Z);
            SubtitleOutputBuffer subtitleOutputBuffer2 = subtitleOutputBuffer;
            subtitleOutputBuffer2.r(subtitleInputBuffer.Y2, C(byteBuffer.array(), byteBuffer.limit(), z), subtitleInputBuffer.f3);
            subtitleOutputBuffer.h(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e2) {
            return e2;
        }
    }

    public void e(long j2) {
    }

    public final String getName() {
        return this.o;
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public final SubtitleInputBuffer j() {
        return new SubtitleInputBuffer();
    }
}
