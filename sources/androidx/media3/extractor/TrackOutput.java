package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@UnstableApi
public interface TrackOutput {

    /* renamed from: a  reason: collision with root package name */
    public static final int f13132a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13133b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f13134c = 2;

    public static final class CryptoData {

        /* renamed from: a  reason: collision with root package name */
        public final int f13135a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f13136b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13137c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13138d;

        public CryptoData(int i2, byte[] bArr, int i3, int i4) {
            this.f13135a = i2;
            this.f13136b = bArr;
            this.f13137c = i3;
            this.f13138d = i4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CryptoData.class != obj.getClass()) {
                return false;
            }
            CryptoData cryptoData = (CryptoData) obj;
            return this.f13135a == cryptoData.f13135a && this.f13137c == cryptoData.f13137c && this.f13138d == cryptoData.f13138d && Arrays.equals(this.f13136b, cryptoData.f13136b);
        }

        public int hashCode() {
            return (((((this.f13135a * 31) + Arrays.hashCode(this.f13136b)) * 31) + this.f13137c) * 31) + this.f13138d;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SampleDataPart {
    }

    void a(ParsableByteArray parsableByteArray, int i2, int i3);

    int b(DataReader dataReader, int i2, boolean z) throws IOException;

    int c(DataReader dataReader, int i2, boolean z, int i3) throws IOException;

    void d(ParsableByteArray parsableByteArray, int i2);

    void e(Format format);

    void f(long j2, int i2, int i3, int i4, @Nullable CryptoData cryptoData);
}
