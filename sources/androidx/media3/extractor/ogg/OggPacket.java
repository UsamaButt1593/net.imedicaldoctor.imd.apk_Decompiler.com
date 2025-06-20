package androidx.media3.extractor.ogg;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorUtil;
import java.io.IOException;
import java.util.Arrays;

final class OggPacket {

    /* renamed from: a  reason: collision with root package name */
    private final OggPageHeader f13723a = new OggPageHeader();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f13724b = new ParsableByteArray(new byte[OggPageHeader.f13730n], 0);

    /* renamed from: c  reason: collision with root package name */
    private int f13725c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f13726d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13727e;

    OggPacket() {
    }

    private int a(int i2) {
        int i3;
        int i4 = 0;
        this.f13726d = 0;
        do {
            int i5 = this.f13726d;
            int i6 = i2 + i5;
            OggPageHeader oggPageHeader = this.f13723a;
            if (i6 >= oggPageHeader.f13737g) {
                break;
            }
            int[] iArr = oggPageHeader.f13740j;
            this.f13726d = i5 + 1;
            i3 = iArr[i5 + i2];
            i4 += i3;
        } while (i3 == 255);
        return i4;
    }

    public OggPageHeader b() {
        return this.f13723a;
    }

    public ParsableByteArray c() {
        return this.f13724b;
    }

    public boolean d(ExtractorInput extractorInput) throws IOException {
        int i2;
        Assertions.i(extractorInput != null);
        if (this.f13727e) {
            this.f13727e = false;
            this.f13724b.U(0);
        }
        while (!this.f13727e) {
            if (this.f13725c < 0) {
                if (!this.f13723a.c(extractorInput) || !this.f13723a.a(extractorInput, true)) {
                    return false;
                }
                OggPageHeader oggPageHeader = this.f13723a;
                int i3 = oggPageHeader.f13738h;
                if ((oggPageHeader.f13732b & 1) == 1 && this.f13724b.g() == 0) {
                    i3 += a(0);
                    i2 = this.f13726d;
                } else {
                    i2 = 0;
                }
                if (!ExtractorUtil.e(extractorInput, i3)) {
                    return false;
                }
                this.f13725c = i2;
            }
            int a2 = a(this.f13725c);
            int i4 = this.f13725c + this.f13726d;
            if (a2 > 0) {
                ParsableByteArray parsableByteArray = this.f13724b;
                parsableByteArray.c(parsableByteArray.g() + a2);
                if (!ExtractorUtil.d(extractorInput, this.f13724b.e(), this.f13724b.g(), a2)) {
                    return false;
                }
                ParsableByteArray parsableByteArray2 = this.f13724b;
                parsableByteArray2.X(parsableByteArray2.g() + a2);
                this.f13727e = this.f13723a.f13740j[i4 + -1] != 255;
            }
            if (i4 == this.f13723a.f13737g) {
                i4 = -1;
            }
            this.f13725c = i4;
        }
        return true;
    }

    public void e() {
        this.f13723a.b();
        this.f13724b.U(0);
        this.f13725c = -1;
        this.f13727e = false;
    }

    public void f() {
        if (this.f13724b.e().length != 65025) {
            ParsableByteArray parsableByteArray = this.f13724b;
            parsableByteArray.W(Arrays.copyOf(parsableByteArray.e(), Math.max(OggPageHeader.f13730n, this.f13724b.g())), this.f13724b.g());
        }
    }
}
