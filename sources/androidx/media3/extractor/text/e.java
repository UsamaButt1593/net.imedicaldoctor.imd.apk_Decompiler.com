package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import java.util.Objects;

public final /* synthetic */ class e {
    public static void a(SubtitleParser subtitleParser, byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        subtitleParser.a(bArr, 0, bArr.length, outputOptions, consumer);
    }

    public static Subtitle b(SubtitleParser subtitleParser, byte[] bArr, int i2, int i3) {
        ImmutableList.Builder r = ImmutableList.r();
        SubtitleParser.OutputOptions a2 = SubtitleParser.OutputOptions.f13784c;
        Objects.requireNonNull(r);
        subtitleParser.a(bArr, i2, i3, a2, new d(r));
        return new CuesWithTimingSubtitle(r.e());
    }

    public static void c(SubtitleParser subtitleParser) {
    }
}
