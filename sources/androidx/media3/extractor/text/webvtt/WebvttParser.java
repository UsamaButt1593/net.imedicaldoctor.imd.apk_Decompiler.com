package androidx.media3.extractor.text.webvtt;

import android.text.TextUtils;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.LegacySubtitleUtil;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.e;
import java.util.ArrayList;

@UnstableApi
public final class WebvttParser implements SubtitleParser {

    /* renamed from: c  reason: collision with root package name */
    public static final int f14154c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f14155d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static final int f14156e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f14157f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final int f14158g = 2;

    /* renamed from: h  reason: collision with root package name */
    private static final int f14159h = 3;

    /* renamed from: i  reason: collision with root package name */
    private static final String f14160i = "NOTE";

    /* renamed from: j  reason: collision with root package name */
    private static final String f14161j = "STYLE";

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f14162a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final WebvttCssParser f14163b = new WebvttCssParser();

    private static int e(ParsableByteArray parsableByteArray) {
        int i2 = -1;
        int i3 = 0;
        while (i2 == -1) {
            i3 = parsableByteArray.f();
            String u = parsableByteArray.u();
            i2 = u == null ? 0 : f14161j.equals(u) ? 2 : u.startsWith(f14160i) ? 1 : 3;
        }
        parsableByteArray.Y(i3);
        return i2;
    }

    private static void f(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.u()));
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        WebvttCueInfo m2;
        this.f14162a.W(bArr, i3 + i2);
        this.f14162a.Y(i2);
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.e(this.f14162a);
            do {
            } while (!TextUtils.isEmpty(this.f14162a.u()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int e2 = e(this.f14162a);
                if (e2 == 0) {
                    LegacySubtitleUtil.c(new WebvttSubtitle(arrayList2), outputOptions, consumer);
                    return;
                } else if (e2 == 1) {
                    f(this.f14162a);
                } else if (e2 == 2) {
                    if (arrayList2.isEmpty()) {
                        this.f14162a.u();
                        arrayList.addAll(this.f14163b.d(this.f14162a));
                    } else {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                } else if (e2 == 3 && (m2 = WebvttCueParser.m(this.f14162a, arrayList)) != null) {
                    arrayList2.add(m2);
                }
            }
        } catch (ParserException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return e.b(this, bArr, i2, i3);
    }

    public /* synthetic */ void c(byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        e.a(this, bArr, outputOptions, consumer);
    }

    public int d() {
        return 1;
    }

    public /* synthetic */ void reset() {
        e.c(this);
    }
}
