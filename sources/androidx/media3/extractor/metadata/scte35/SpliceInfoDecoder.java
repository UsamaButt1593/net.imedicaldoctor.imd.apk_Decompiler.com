package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import java.nio.ByteBuffer;

@UnstableApi
public final class SpliceInfoDecoder extends SimpleMetadataDecoder {

    /* renamed from: d  reason: collision with root package name */
    private static final int f13372d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final int f13373e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13374f = 5;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13375g = 6;

    /* renamed from: h  reason: collision with root package name */
    private static final int f13376h = 255;

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f13377a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f13378b = new ParsableBitArray();

    /* renamed from: c  reason: collision with root package name */
    private TimestampAdjuster f13379c;

    /* access modifiers changed from: protected */
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        TimestampAdjuster timestampAdjuster = this.f13379c;
        if (timestampAdjuster == null || metadataInputBuffer.f3 != timestampAdjuster.f()) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(metadataInputBuffer.Y2);
            this.f13379c = timestampAdjuster2;
            timestampAdjuster2.a(metadataInputBuffer.Y2 - metadataInputBuffer.f3);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f13377a.W(array, limit);
        this.f13378b.p(array, limit);
        this.f13378b.s(39);
        long h2 = (((long) this.f13378b.h(1)) << 32) | ((long) this.f13378b.h(32));
        this.f13378b.s(20);
        int h3 = this.f13378b.h(12);
        int h4 = this.f13378b.h(8);
        this.f13377a.Z(14);
        Metadata.Entry a2 = h4 != 0 ? h4 != 255 ? h4 != 4 ? h4 != 5 ? h4 != 6 ? null : TimeSignalCommand.a(this.f13377a, h2, this.f13379c) : SpliceInsertCommand.a(this.f13377a, h2, this.f13379c) : SpliceScheduleCommand.a(this.f13377a) : PrivateCommand.a(this.f13377a, h3, h2) : new SpliceNullCommand();
        if (a2 == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(a2);
    }
}
