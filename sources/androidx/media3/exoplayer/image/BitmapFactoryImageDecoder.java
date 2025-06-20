package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.exoplayer.V0;
import androidx.media3.exoplayer.image.ImageDecoder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@UnstableApi
public final class BitmapFactoryImageDecoder extends SimpleDecoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> implements ImageDecoder {
    private final BitmapDecoder o;

    @VisibleForTesting(otherwise = 2)
    public interface BitmapDecoder {
        Bitmap a(byte[] bArr, int i2) throws ImageDecoderException;
    }

    public static final class Factory implements ImageDecoder.Factory {

        /* renamed from: b  reason: collision with root package name */
        private final BitmapDecoder f11619b;

        public Factory() {
            this.f11619b = new a();
        }

        public int b(Format format) {
            String str = format.f3;
            if (str == null || !MimeTypes.q(str)) {
                return V0.c(0);
            }
            return V0.c(Util.g1(format.f3) ? 4 : 1);
        }

        /* renamed from: d */
        public BitmapFactoryImageDecoder a() {
            return new BitmapFactoryImageDecoder(this.f11619b);
        }

        public Factory(BitmapDecoder bitmapDecoder) {
            this.f11619b = bitmapDecoder;
        }
    }

    private BitmapFactoryImageDecoder(BitmapDecoder bitmapDecoder) {
        super(new DecoderInputBuffer[1], new ImageOutputBuffer[1]);
        this.o = bitmapDecoder;
    }

    /* access modifiers changed from: private */
    public static Bitmap C(byte[] bArr, int i2) throws ImageDecoderException {
        ByteArrayInputStream byteArrayInputStream;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i2);
        if (decodeByteArray != null) {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i2);
                ExifInterface exifInterface = new ExifInterface((InputStream) byteArrayInputStream);
                byteArrayInputStream.close();
                int B = exifInterface.B();
                if (B == 0) {
                    return decodeByteArray;
                }
                Matrix matrix = new Matrix();
                matrix.postRotate((float) B);
                return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
            } catch (IOException e2) {
                throw new ImageDecoderException((Throwable) e2);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new ImageDecoderException("Could not decode image data with BitmapFactory. (data.length = " + bArr.length + ", input length = " + i2 + ")");
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public ImageOutputBuffer k() {
        return new ImageOutputBuffer() {
            public void q() {
                BitmapFactoryImageDecoder.this.u(this);
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public ImageDecoderException l(Throwable th) {
        return new ImageDecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: D */
    public ImageDecoderException m(DecoderInputBuffer decoderInputBuffer, ImageOutputBuffer imageOutputBuffer, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.g(decoderInputBuffer.Z);
            Assertions.i(byteBuffer.hasArray());
            Assertions.a(byteBuffer.arrayOffset() == 0);
            imageOutputBuffer.X2 = this.o.a(byteBuffer.array(), byteBuffer.remaining());
            imageOutputBuffer.X = decoderInputBuffer.Y2;
            return null;
        } catch (ImageDecoderException e2) {
            return e2;
        }
    }

    @Nullable
    public /* bridge */ /* synthetic */ ImageOutputBuffer b() throws ImageDecoderException {
        return (ImageOutputBuffer) super.b();
    }

    public String getName() {
        return "BitmapFactoryImageDecoder";
    }

    /* access modifiers changed from: protected */
    public DecoderInputBuffer j() {
        return new DecoderInputBuffer(1);
    }
}
