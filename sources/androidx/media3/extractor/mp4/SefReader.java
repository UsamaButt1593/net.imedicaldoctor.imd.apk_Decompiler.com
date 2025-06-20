package androidx.media3.extractor.mp4;

import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.base.Splitter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class SefReader {

    /* renamed from: d  reason: collision with root package name */
    private static final int f13626d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final int f13627e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13628f = 2;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13629g = 3;

    /* renamed from: h  reason: collision with root package name */
    private static final int f13630h = 2192;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13631i = 2816;

    /* renamed from: j  reason: collision with root package name */
    private static final int f13632j = 2817;

    /* renamed from: k  reason: collision with root package name */
    private static final int f13633k = 2819;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13634l = 2820;

    /* renamed from: m  reason: collision with root package name */
    private static final String f13635m = "SefReader";

    /* renamed from: n  reason: collision with root package name */
    private static final int f13636n = 1397048916;
    private static final int o = 12;
    private static final int p = 8;
    private static final int q = 12;
    private static final Splitter r = Splitter.h(ASCIIPropertyListParser.A);
    private static final Splitter s = Splitter.h('*');

    /* renamed from: a  reason: collision with root package name */
    private final List<DataReference> f13637a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f13638b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f13639c;

    private static final class DataReference {

        /* renamed from: a  reason: collision with root package name */
        public final int f13640a;

        /* renamed from: b  reason: collision with root package name */
        public final long f13641b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13642c;

        public DataReference(int i2, long j2, int i3) {
            this.f13640a = i2;
            this.f13641b = j2;
            this.f13642c = i3;
        }
    }

    private void a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        extractorInput.readFully(parsableByteArray.e(), 0, 8);
        this.f13639c = parsableByteArray.w() + 8;
        if (parsableByteArray.s() != f13636n) {
            positionHolder.f13111a = 0;
            return;
        }
        positionHolder.f13111a = extractorInput.getPosition() - ((long) (this.f13639c - 12));
        this.f13638b = 2;
    }

    private static int b(String str) throws ParserException {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1711564334:
                if (str.equals("SlowMotion_Data")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1332107749:
                if (str.equals("Super_SlowMotion_Edit_Data")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1251387154:
                if (str.equals("Super_SlowMotion_Data")) {
                    c2 = 2;
                    break;
                }
                break;
            case -830665521:
                if (str.equals("Super_SlowMotion_Deflickering_On")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1760745220:
                if (str.equals("Super_SlowMotion_BGM")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return f13630h;
            case 1:
                return f13633k;
            case 2:
                return f13631i;
            case 3:
                return f13634l;
            case 4:
                return f13632j;
            default:
                throw ParserException.a("Invalid SEF name", (Throwable) null);
        }
    }

    private void d(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        long j2;
        long length = extractorInput.getLength();
        int i2 = this.f13639c - 20;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
        extractorInput.readFully(parsableByteArray.e(), 0, i2);
        for (int i3 = 0; i3 < i2 / 12; i3++) {
            parsableByteArray.Z(2);
            short z = parsableByteArray.z();
            if (z == f13630h || z == f13631i || z == f13632j || z == f13633k || z == f13634l) {
                this.f13637a.add(new DataReference(z, (length - ((long) this.f13639c)) - ((long) parsableByteArray.w()), parsableByteArray.w()));
            } else {
                parsableByteArray.Z(8);
            }
        }
        if (this.f13637a.isEmpty()) {
            j2 = 0;
        } else {
            this.f13638b = 3;
            j2 = this.f13637a.get(0).f13641b;
        }
        positionHolder.f13111a = j2;
    }

    private void e(ExtractorInput extractorInput, List<Metadata.Entry> list) throws IOException {
        long position = extractorInput.getPosition();
        int length = (int) ((extractorInput.getLength() - extractorInput.getPosition()) - ((long) this.f13639c));
        ParsableByteArray parsableByteArray = new ParsableByteArray(length);
        extractorInput.readFully(parsableByteArray.e(), 0, length);
        for (int i2 = 0; i2 < this.f13637a.size(); i2++) {
            DataReference dataReference = this.f13637a.get(i2);
            parsableByteArray.Y((int) (dataReference.f13641b - position));
            parsableByteArray.Z(4);
            int w = parsableByteArray.w();
            int b2 = b(parsableByteArray.I(w));
            int i3 = dataReference.f13642c - (w + 8);
            if (b2 == f13630h) {
                list.add(f(parsableByteArray, i3));
            } else if (!(b2 == f13631i || b2 == f13632j || b2 == f13633k || b2 == f13634l)) {
                throw new IllegalStateException();
            }
        }
    }

    private static SlowMotionData f(ParsableByteArray parsableByteArray, int i2) throws ParserException {
        ArrayList arrayList = new ArrayList();
        List<String> o2 = s.o(parsableByteArray.I(i2));
        int i3 = 0;
        while (i3 < o2.size()) {
            List<String> o3 = r.o(o2.get(i3));
            if (o3.size() == 3) {
                try {
                    arrayList.add(new SlowMotionData.Segment(Long.parseLong(o3.get(0)), Long.parseLong(o3.get(1)), 1 << (Integer.parseInt(o3.get(2)) - 1)));
                    i3++;
                } catch (NumberFormatException e2) {
                    throw ParserException.a((String) null, e2);
                }
            } else {
                throw ParserException.a((String) null, (Throwable) null);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public int c(ExtractorInput extractorInput, PositionHolder positionHolder, List<Metadata.Entry> list) throws IOException {
        int i2 = this.f13638b;
        long j2 = 0;
        if (i2 == 0) {
            long length = extractorInput.getLength();
            if (length != -1 && length >= 8) {
                j2 = length - 8;
            }
            positionHolder.f13111a = j2;
            this.f13638b = 1;
        } else if (i2 == 1) {
            a(extractorInput, positionHolder);
        } else if (i2 == 2) {
            d(extractorInput, positionHolder);
        } else if (i2 == 3) {
            e(extractorInput, list);
            positionHolder.f13111a = 0;
        } else {
            throw new IllegalStateException();
        }
        return 1;
    }

    public void g() {
        this.f13637a.clear();
        this.f13638b = 0;
    }
}
