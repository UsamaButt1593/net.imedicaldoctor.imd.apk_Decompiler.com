package androidx.media3.exoplayer.metadata;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.MetadataDecoder;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.metadata.emsg.EventMessageDecoder;
import androidx.media3.extractor.metadata.icy.IcyDecoder;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.metadata.scte35.SpliceInfoDecoder;

@UnstableApi
public interface MetadataDecoderFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final MetadataDecoderFactory f11736a = new MetadataDecoderFactory() {
        public MetadataDecoder a(Format format) {
            String str = format.f3;
            if (str != null) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1354451219:
                        if (str.equals(MimeTypes.M0)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1348231605:
                        if (str.equals(MimeTypes.L0)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1248341703:
                        if (str.equals(MimeTypes.v0)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1154383568:
                        if (str.equals(MimeTypes.I0)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1652648887:
                        if (str.equals(MimeTypes.G0)) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return new AppInfoTableDecoder();
                    case 1:
                        return new IcyDecoder();
                    case 2:
                        return new Id3Decoder();
                    case 3:
                        return new EventMessageDecoder();
                    case 4:
                        return new SpliceInfoDecoder();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }

        public boolean b(Format format) {
            String str = format.f3;
            return MimeTypes.v0.equals(str) || MimeTypes.I0.equals(str) || MimeTypes.G0.equals(str) || MimeTypes.L0.equals(str) || MimeTypes.M0.equals(str);
        }
    };

    MetadataDecoder a(Format format);

    boolean b(Format format);
}
