package androidx.media3.extractor.text.cea;

import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.extractor.text.cea.CeaDecoder;

public final /* synthetic */ class b implements DecoderOutputBuffer.Owner {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CeaDecoder f13854a;

    public /* synthetic */ b(CeaDecoder ceaDecoder) {
        this.f13854a = ceaDecoder;
    }

    public final void a(DecoderOutputBuffer decoderOutputBuffer) {
        this.f13854a.q((CeaDecoder.CeaOutputBuffer) decoderOutputBuffer);
    }
}
