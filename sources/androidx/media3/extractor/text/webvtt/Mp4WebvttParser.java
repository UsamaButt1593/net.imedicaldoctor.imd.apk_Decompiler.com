package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.e;
import java.util.ArrayList;
import java.util.Collections;

@UnstableApi
public final class Mp4WebvttParser implements SubtitleParser {

    /* renamed from: b  reason: collision with root package name */
    public static final int f14085b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f14086c = 8;

    /* renamed from: d  reason: collision with root package name */
    private static final int f14087d = 1885436268;

    /* renamed from: e  reason: collision with root package name */
    private static final int f14088e = 1937011815;

    /* renamed from: f  reason: collision with root package name */
    private static final int f14089f = 1987343459;

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f14090a = new ParsableByteArray();

    private static Cue e(ParsableByteArray parsableByteArray, int i2) {
        CharSequence charSequence = null;
        Cue.Builder builder = null;
        while (i2 > 0) {
            Assertions.b(i2 >= 8, "Incomplete vtt cue box header found.");
            int s = parsableByteArray.s();
            int s2 = parsableByteArray.s();
            int i3 = s - 8;
            String U = Util.U(parsableByteArray.e(), parsableByteArray.f(), i3);
            parsableByteArray.Z(i3);
            i2 = (i2 - 8) - i3;
            if (s2 == f14088e) {
                builder = WebvttCueParser.o(U);
            } else if (s2 == f14087d) {
                charSequence = WebvttCueParser.q((String) null, U.trim(), Collections.emptyList());
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        return builder != null ? builder.A(charSequence).a() : WebvttCueParser.l(charSequence);
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        this.f14090a.W(bArr, i3 + i2);
        this.f14090a.Y(i2);
        ArrayList arrayList = new ArrayList();
        while (this.f14090a.a() > 0) {
            Assertions.b(this.f14090a.a() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int s = this.f14090a.s();
            if (this.f14090a.s() == f14089f) {
                arrayList.add(e(this.f14090a, s - 8));
            } else {
                this.f14090a.Z(s - 8);
            }
        }
        consumer.accept(new CuesWithTiming(arrayList, C.f9084b, C.f9084b));
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return e.b(this, bArr, i2, i3);
    }

    public /* synthetic */ void c(byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        e.a(this, bArr, outputOptions, consumer);
    }

    public int d() {
        return 2;
    }

    public /* synthetic */ void reset() {
        e.c(this);
    }
}
