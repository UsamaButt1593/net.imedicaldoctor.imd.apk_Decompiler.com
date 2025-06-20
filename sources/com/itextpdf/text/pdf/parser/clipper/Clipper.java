package com.itextpdf.text.pdf.parser.clipper;

import com.itextpdf.text.pdf.parser.clipper.Point;

public interface Clipper {

    /* renamed from: a  reason: collision with root package name */
    public static final int f27064a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f27065b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f27066c = 4;

    public enum ClipType {
        INTERSECTION,
        UNION,
        DIFFERENCE,
        XOR
    }

    public enum Direction {
        RIGHT_TO_LEFT,
        LEFT_TO_RIGHT
    }

    public enum EndType {
        CLOSED_POLYGON,
        CLOSED_LINE,
        OPEN_BUTT,
        OPEN_SQUARE,
        OPEN_ROUND
    }

    public enum JoinType {
        BEVEL,
        ROUND,
        MITER
    }

    public enum PolyFillType {
        EVEN_ODD,
        NON_ZERO,
        POSITIVE,
        NEGATIVE
    }

    public enum PolyType {
        SUBJECT,
        CLIP
    }

    public interface ZFillCallback {
        void a(Point.LongPoint longPoint, Point.LongPoint longPoint2, Point.LongPoint longPoint3, Point.LongPoint longPoint4, Point.LongPoint longPoint5);
    }

    boolean a(Path path, PolyType polyType, boolean z);

    boolean b(ClipType clipType, Paths paths, PolyFillType polyFillType, PolyFillType polyFillType2);

    boolean c(Paths paths, PolyType polyType, boolean z);

    void clear();

    boolean d(ClipType clipType, Paths paths);

    boolean e(ClipType clipType, PolyTree polyTree, PolyFillType polyFillType, PolyFillType polyFillType2);

    boolean f(ClipType clipType, PolyTree polyTree);
}
