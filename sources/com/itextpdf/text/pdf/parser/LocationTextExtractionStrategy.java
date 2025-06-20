package com.itextpdf.text.pdf.parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationTextExtractionStrategy implements TextExtractionStrategy {

    /* renamed from: c  reason: collision with root package name */
    static boolean f26964c = false;

    /* renamed from: a  reason: collision with root package name */
    private final List<TextChunk> f26965a;

    /* renamed from: b  reason: collision with root package name */
    private final TextChunkLocationStrategy f26966b;

    public static class TextChunk implements Comparable<TextChunk> {
        private final TextChunkLocation X;
        /* access modifiers changed from: private */
        public final String s;

        public TextChunk(String str, TextChunkLocation textChunkLocation) {
            this.s = str;
            this.X = textChunkLocation;
        }

        /* access modifiers changed from: private */
        public void i() {
            PrintStream printStream = System.out;
            printStream.println("Text (@" + this.X.O0() + " -> " + this.X.F0() + "): " + this.s);
            StringBuilder sb = new StringBuilder();
            sb.append("orientationMagnitude: ");
            sb.append(this.X.R1());
            printStream.println(sb.toString());
            printStream.println("distPerpendicular: " + this.X.u0());
            printStream.println("distParallel: " + this.X.C1());
        }

        /* access modifiers changed from: private */
        public boolean j(TextChunk textChunk) {
            return g().r1(textChunk.g());
        }

        public Vector F0() {
            return this.X.F0();
        }

        public Vector O0() {
            return this.X.O0();
        }

        public float Y() {
            return this.X.Y();
        }

        /* renamed from: e */
        public int compareTo(TextChunk textChunk) {
            return this.X.compareTo(textChunk.X);
        }

        public float f(TextChunk textChunk) {
            return this.X.u1(textChunk.X);
        }

        public TextChunkLocation g() {
            return this.X;
        }

        public String h() {
            return this.s;
        }

        public TextChunk(String str, Vector vector, Vector vector2, float f2) {
            this(str, new TextChunkLocationDefaultImp(vector, vector2, f2));
        }
    }

    public interface TextChunkFilter {
        boolean a(TextChunk textChunk);
    }

    public interface TextChunkLocation extends Comparable<TextChunkLocation> {
        float C1();

        Vector F0();

        Vector O0();

        int R1();

        float Y();

        boolean r1(TextChunkLocation textChunkLocation);

        boolean t1(TextChunkLocation textChunkLocation);

        int u0();

        float u1(TextChunkLocation textChunkLocation);

        float z1();
    }

    private static class TextChunkLocationDefaultImp implements TextChunkLocation {
        private final Vector X;
        private final int X2;
        private final Vector Y;
        private final float Y2;
        private final int Z;
        private final float Z2;
        private final float a3;
        private final Vector s;

        public TextChunkLocationDefaultImp(Vector vector, Vector vector2, float f2) {
            this.s = vector;
            this.X = vector2;
            this.a3 = f2;
            Vector i2 = vector2.i(vector);
            Vector h2 = (i2.e() == 0.0f ? new Vector(1.0f, 0.0f, 0.0f) : i2).h();
            this.Y = h2;
            this.Z = (int) (Math.atan2((double) h2.d(1), (double) h2.d(0)) * 1000.0d);
            this.X2 = (int) vector.i(new Vector(0.0f, 0.0f, 1.0f)).b(h2).d(2);
            this.Y2 = h2.c(vector);
            this.Z2 = h2.c(vector2);
        }

        public float C1() {
            return this.Y2;
        }

        public Vector F0() {
            return this.X;
        }

        public Vector O0() {
            return this.s;
        }

        public int R1() {
            return this.Z;
        }

        public float Y() {
            return this.a3;
        }

        /* renamed from: a */
        public int compareTo(TextChunkLocation textChunkLocation) {
            if (this == textChunkLocation) {
                return 0;
            }
            int i2 = LocationTextExtractionStrategy.j(R1(), textChunkLocation.R1());
            if (i2 != 0) {
                return i2;
            }
            int i3 = LocationTextExtractionStrategy.j(u0(), textChunkLocation.u0());
            return i3 != 0 ? i3 : Float.compare(C1(), textChunkLocation.C1());
        }

        public boolean r1(TextChunkLocation textChunkLocation) {
            return R1() == textChunkLocation.R1() && u0() == textChunkLocation.u0();
        }

        public boolean t1(TextChunkLocation textChunkLocation) {
            if (Y() < 0.1f) {
                return false;
            }
            float u1 = u1(textChunkLocation);
            return u1 < (-Y()) || u1 > Y() / 2.0f;
        }

        public int u0() {
            return this.X2;
        }

        public float u1(TextChunkLocation textChunkLocation) {
            return C1() - textChunkLocation.z1();
        }

        public float z1() {
            return this.Z2;
        }
    }

    public interface TextChunkLocationStrategy {
        TextChunkLocation a(TextRenderInfo textRenderInfo, LineSegment lineSegment);
    }

    public LocationTextExtractionStrategy() {
        this(new TextChunkLocationStrategy() {
            public TextChunkLocation a(TextRenderInfo textRenderInfo, LineSegment lineSegment) {
                return new TextChunkLocationDefaultImp(lineSegment.d(), lineSegment.b(), textRenderInfo.o());
            }
        });
    }

    /* access modifiers changed from: private */
    public static int j(int i2, int i3) {
        if (i2 == i3) {
            return 0;
        }
        return i2 < i3 ? -1 : 1;
    }

    private void k() {
        for (TextChunk c2 : this.f26965a) {
            c2.i();
            System.out.println();
        }
    }

    private boolean l(String str) {
        return str.length() != 0 && str.charAt(str.length() - 1) == ' ';
    }

    private List<TextChunk> m(List<TextChunk> list, TextChunkFilter textChunkFilter) {
        if (textChunkFilter == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (TextChunk next : list) {
            if (textChunkFilter.a(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private boolean p(String str) {
        return str.length() != 0 && str.charAt(0) == ' ';
    }

    public void a() {
    }

    public void c(ImageRenderInfo imageRenderInfo) {
    }

    public void e(TextRenderInfo textRenderInfo) {
        LineSegment e2 = textRenderInfo.e();
        if (textRenderInfo.n() != 0.0f) {
            e2 = e2.e(new Matrix(0.0f, -textRenderInfo.n()));
        }
        this.f26965a.add(new TextChunk(textRenderInfo.r(), this.f26966b.a(textRenderInfo, e2)));
    }

    public String g() {
        return n((TextChunkFilter) null);
    }

    public void h() {
    }

    public String n(TextChunkFilter textChunkFilter) {
        char c2;
        if (f26964c) {
            k();
        }
        List<TextChunk> m2 = m(this.f26965a, textChunkFilter);
        Collections.sort(m2);
        StringBuilder sb = new StringBuilder();
        TextChunk textChunk = null;
        for (TextChunk next : m2) {
            if (textChunk != null) {
                if (!next.j(textChunk)) {
                    c2 = 10;
                } else if (o(next, textChunk) && !p(next.s) && !l(textChunk.s)) {
                    c2 = ' ';
                }
                sb.append(c2);
            }
            sb.append(next.s);
            textChunk = next;
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean o(TextChunk textChunk, TextChunk textChunk2) {
        return textChunk.g().t1(textChunk2.g());
    }

    public LocationTextExtractionStrategy(TextChunkLocationStrategy textChunkLocationStrategy) {
        this.f26965a = new ArrayList();
        this.f26966b = textChunkLocationStrategy;
    }
}
