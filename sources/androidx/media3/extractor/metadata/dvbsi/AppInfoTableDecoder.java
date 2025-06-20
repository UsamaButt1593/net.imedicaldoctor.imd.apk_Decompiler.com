package androidx.media3.extractor.metadata.dvbsi;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
public final class AppInfoTableDecoder extends SimpleMetadataDecoder {

    /* renamed from: a  reason: collision with root package name */
    private static final int f13344a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static final int f13345b = 21;

    /* renamed from: c  reason: collision with root package name */
    private static final int f13346c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static final int f13347d = 116;

    @Nullable
    private static Metadata c(ParsableBitArray parsableBitArray) {
        parsableBitArray.s(12);
        int d2 = (parsableBitArray.d() + parsableBitArray.h(12)) - 4;
        parsableBitArray.s(44);
        parsableBitArray.t(parsableBitArray.h(12));
        parsableBitArray.s(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str = null;
            if (parsableBitArray.d() >= d2) {
                break;
            }
            parsableBitArray.s(48);
            int h2 = parsableBitArray.h(8);
            parsableBitArray.s(4);
            int d3 = parsableBitArray.d() + parsableBitArray.h(12);
            String str2 = null;
            while (parsableBitArray.d() < d3) {
                int h3 = parsableBitArray.h(8);
                int h4 = parsableBitArray.h(8);
                int d4 = parsableBitArray.d() + h4;
                if (h3 == 2) {
                    int h5 = parsableBitArray.h(16);
                    parsableBitArray.s(8);
                    if (h5 != 3) {
                    }
                    while (parsableBitArray.d() < d4) {
                        str = parsableBitArray.m(parsableBitArray.h(8), Charsets.f22253a);
                        int h6 = parsableBitArray.h(8);
                        for (int i2 = 0; i2 < h6; i2++) {
                            parsableBitArray.t(parsableBitArray.h(8));
                        }
                    }
                } else if (h3 == 21) {
                    str2 = parsableBitArray.m(h4, Charsets.f22253a);
                }
                parsableBitArray.q(d4 * 8);
            }
            parsableBitArray.q(d3 * 8);
            if (!(str == null || str2 == null)) {
                arrayList.add(new AppInfoTable(h2, str + str2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new ParsableBitArray(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
