package androidx.media3.extractor.jpeg;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ForwardingExtractorInput;

final class StartOffsetExtractorInput extends ForwardingExtractorInput {

    /* renamed from: c  reason: collision with root package name */
    private final long f13337c;

    public StartOffsetExtractorInput(ExtractorInput extractorInput, long j2) {
        super(extractorInput);
        Assertions.a(extractorInput.getPosition() >= j2);
        this.f13337c = j2;
    }

    public long getLength() {
        return super.getLength() - this.f13337c;
    }

    public long getPosition() {
        return super.getPosition() - this.f13337c;
    }

    public long i() {
        return super.i() - this.f13337c;
    }

    public <E extends Throwable> void l(long j2, E e2) throws Throwable {
        super.l(j2 + this.f13337c, e2);
    }
}
