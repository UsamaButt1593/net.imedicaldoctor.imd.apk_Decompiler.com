package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public class ForwardingExtractorInput implements ExtractorInput {

    /* renamed from: b  reason: collision with root package name */
    private final ExtractorInput f13063b;

    public ForwardingExtractorInput(ExtractorInput extractorInput) {
        this.f13063b = extractorInput;
    }

    public int b(int i2) throws IOException {
        return this.f13063b.b(i2);
    }

    public boolean d(byte[] bArr, int i2, int i3, boolean z) throws IOException {
        return this.f13063b.d(bArr, i2, i3, z);
    }

    public boolean g(int i2, boolean z) throws IOException {
        return this.f13063b.g(i2, z);
    }

    public long getLength() {
        return this.f13063b.getLength();
    }

    public long getPosition() {
        return this.f13063b.getPosition();
    }

    public boolean h(byte[] bArr, int i2, int i3, boolean z) throws IOException {
        return this.f13063b.h(bArr, i2, i3, z);
    }

    public long i() {
        return this.f13063b.i();
    }

    public void j(int i2) throws IOException {
        this.f13063b.j(i2);
    }

    public <E extends Throwable> void l(long j2, E e2) throws Throwable {
        this.f13063b.l(j2, e2);
    }

    public int m(byte[] bArr, int i2, int i3) throws IOException {
        return this.f13063b.m(bArr, i2, i3);
    }

    public void n() {
        this.f13063b.n();
    }

    public void o(int i2) throws IOException {
        this.f13063b.o(i2);
    }

    public boolean q(int i2, boolean z) throws IOException {
        return this.f13063b.q(i2, z);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.f13063b.read(bArr, i2, i3);
    }

    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        this.f13063b.readFully(bArr, i2, i3);
    }

    public void s(byte[] bArr, int i2, int i3) throws IOException {
        this.f13063b.s(bArr, i2, i3);
    }
}
