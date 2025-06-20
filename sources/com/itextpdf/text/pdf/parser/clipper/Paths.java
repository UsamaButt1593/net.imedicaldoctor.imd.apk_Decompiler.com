package com.itextpdf.text.pdf.parser.clipper;

import com.itextpdf.text.pdf.parser.clipper.Point;
import com.itextpdf.text.pdf.parser.clipper.PolyNode;
import java.util.ArrayList;
import java.util.Iterator;

public class Paths extends ArrayList<Path> {
    private static final long s = 1910552127810480852L;

    /* renamed from: com.itextpdf.text.pdf.parser.clipper.Paths$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27144a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.itextpdf.text.pdf.parser.clipper.PolyNode$NodeType[] r0 = com.itextpdf.text.pdf.parser.clipper.PolyNode.NodeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27144a = r0
                com.itextpdf.text.pdf.parser.clipper.PolyNode$NodeType r1 = com.itextpdf.text.pdf.parser.clipper.PolyNode.NodeType.OPEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27144a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.parser.clipper.PolyNode$NodeType r1 = com.itextpdf.text.pdf.parser.clipper.PolyNode.NodeType.CLOSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.Paths.AnonymousClass1.<clinit>():void");
        }
    }

    public Paths() {
    }

    public static Paths g(PolyTree polyTree) {
        Paths paths = new Paths();
        paths.b(polyTree, PolyNode.NodeType.CLOSED);
        return paths;
    }

    public static Paths m(PolyTree polyTree) {
        Paths paths = new Paths();
        paths.b(polyTree, PolyNode.NodeType.ANY);
        return paths;
    }

    public static Paths n(PolyTree polyTree) {
        Paths paths = new Paths();
        for (PolyNode next : polyTree.c()) {
            if (next.m()) {
                paths.add(next.j());
            }
        }
        return paths;
    }

    public void b(PolyNode polyNode, PolyNode.NodeType nodeType) {
        int i2 = AnonymousClass1.f27144a[nodeType.ordinal()];
        boolean z = true;
        if (i2 != 1) {
            if (i2 == 2) {
                z = true ^ polyNode.m();
            }
            if (polyNode.j().size() > 0 && z) {
                add(polyNode.j());
            }
            for (PolyNode b2 : polyNode.c()) {
                b(b2, nodeType);
            }
        }
    }

    public Paths c() {
        return d(1.415d);
    }

    public Paths d(double d2) {
        Paths paths = new Paths(size());
        for (int i2 = 0; i2 < size(); i2++) {
            paths.add(((Path) get(i2)).g(d2));
        }
        return paths;
    }

    public LongRect h() {
        int size = size();
        LongRect longRect = new LongRect();
        int i2 = 0;
        while (i2 < size && ((Path) get(i2)).isEmpty()) {
            i2++;
        }
        if (i2 == size) {
            return longRect;
        }
        long m2 = ((Point.LongPoint) ((Path) get(i2)).get(0)).m();
        longRect.f27123a = m2;
        longRect.f27125c = m2;
        long n2 = ((Point.LongPoint) ((Path) get(i2)).get(0)).n();
        longRect.f27124b = n2;
        longRect.f27126d = n2;
        while (i2 < size) {
            for (int i3 = 0; i3 < ((Path) get(i2)).size(); i3++) {
                int i4 = (((Point.LongPoint) ((Path) get(i2)).get(i3)).m() > longRect.f27123a ? 1 : (((Point.LongPoint) ((Path) get(i2)).get(i3)).m() == longRect.f27123a ? 0 : -1));
                long m3 = ((Point.LongPoint) ((Path) get(i2)).get(i3)).m();
                if (i4 < 0) {
                    longRect.f27123a = m3;
                } else if (m3 > longRect.f27125c) {
                    longRect.f27125c = ((Point.LongPoint) ((Path) get(i2)).get(i3)).m();
                }
                int i5 = (((Point.LongPoint) ((Path) get(i2)).get(i3)).n() > longRect.f27124b ? 1 : (((Point.LongPoint) ((Path) get(i2)).get(i3)).n() == longRect.f27124b ? 0 : -1));
                long n3 = ((Point.LongPoint) ((Path) get(i2)).get(i3)).n();
                if (i5 < 0) {
                    longRect.f27124b = n3;
                } else if (n3 > longRect.f27126d) {
                    longRect.f27126d = ((Point.LongPoint) ((Path) get(i2)).get(i3)).n();
                }
            }
            i2++;
        }
        return longRect;
    }

    public void o() {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Path) it2.next()).o();
        }
    }

    public Paths(int i2) {
        super(i2);
    }
}
