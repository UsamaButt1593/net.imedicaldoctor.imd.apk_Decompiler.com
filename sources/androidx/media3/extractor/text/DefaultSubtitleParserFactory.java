package androidx.media3.extractor.text;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.dvb.DvbParser;
import androidx.media3.extractor.text.pgs.PgsParser;
import androidx.media3.extractor.text.ssa.SsaParser;
import androidx.media3.extractor.text.subrip.SubripParser;
import androidx.media3.extractor.text.ttml.TtmlParser;
import androidx.media3.extractor.text.tx3g.Tx3gParser;
import androidx.media3.extractor.text.webvtt.Mp4WebvttParser;
import androidx.media3.extractor.text.webvtt.WebvttParser;
import java.util.Objects;

@UnstableApi
public final class DefaultSubtitleParserFactory implements SubtitleParser.Factory {
    public int a(Format format) {
        String str = format.f3;
        if (str != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals(MimeTypes.J0)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1248334819:
                    if (str.equals(MimeTypes.F0)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1026075066:
                    if (str.equals(MimeTypes.B0)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals(MimeTypes.m0)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals(MimeTypes.A0)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals(MimeTypes.n0)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals(MimeTypes.y0)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals(MimeTypes.z0)) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                case 2:
                    return 2;
                case 3:
                    return 1;
                case 4:
                    return 2;
                case 5:
                case 6:
                case 7:
                    return 1;
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: " + str);
    }

    public boolean b(Format format) {
        String str = format.f3;
        return Objects.equals(str, MimeTypes.n0) || Objects.equals(str, MimeTypes.m0) || Objects.equals(str, MimeTypes.B0) || Objects.equals(str, MimeTypes.y0) || Objects.equals(str, MimeTypes.A0) || Objects.equals(str, MimeTypes.F0) || Objects.equals(str, MimeTypes.J0) || Objects.equals(str, MimeTypes.z0);
    }

    public SubtitleParser c(Format format) {
        String str = format.f3;
        if (str != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals(MimeTypes.J0)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1248334819:
                    if (str.equals(MimeTypes.F0)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1026075066:
                    if (str.equals(MimeTypes.B0)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals(MimeTypes.m0)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals(MimeTypes.A0)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals(MimeTypes.n0)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals(MimeTypes.y0)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals(MimeTypes.z0)) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return new DvbParser(format.h3);
                case 1:
                    return new PgsParser();
                case 2:
                    return new Mp4WebvttParser();
                case 3:
                    return new WebvttParser();
                case 4:
                    return new Tx3gParser(format.h3);
                case 5:
                    return new SsaParser(format.h3);
                case 6:
                    return new SubripParser();
                case 7:
                    return new TtmlParser();
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: " + str);
    }
}
