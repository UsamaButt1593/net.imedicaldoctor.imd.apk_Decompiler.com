package androidx.media3.exoplayer.text;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.cea.Cea608Decoder;
import androidx.media3.extractor.text.cea.Cea708Decoder;
import java.util.Objects;

@UnstableApi
public interface SubtitleDecoderFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final SubtitleDecoderFactory f12346a = new SubtitleDecoderFactory() {

        /* renamed from: b  reason: collision with root package name */
        private final DefaultSubtitleParserFactory f12347b = new DefaultSubtitleParserFactory();

        public SubtitleDecoder a(Format format) {
            String str = format.f3;
            if (str != null) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case 930165504:
                        if (str.equals(MimeTypes.C0)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals(MimeTypes.w0)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1566016562:
                        if (str.equals(MimeTypes.x0)) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                        return new Cea608Decoder(str, format.x3, Cea608Decoder.A);
                    case 2:
                        return new Cea708Decoder(format.x3, format.h3);
                }
            }
            if (this.f12347b.b(format)) {
                SubtitleParser c3 = this.f12347b.c(format);
                return new DelegatingSubtitleDecoder(c3.getClass().getSimpleName() + "Decoder", c3);
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }

        public boolean b(Format format) {
            String str = format.f3;
            return this.f12347b.b(format) || Objects.equals(str, MimeTypes.w0) || Objects.equals(str, MimeTypes.C0) || Objects.equals(str, MimeTypes.x0);
        }
    };

    SubtitleDecoder a(Format format);

    boolean b(Format format);
}
