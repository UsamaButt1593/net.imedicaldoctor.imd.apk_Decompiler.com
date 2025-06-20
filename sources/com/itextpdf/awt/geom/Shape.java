package com.itextpdf.awt.geom;

public interface Shape {
    boolean a(Rectangle2D rectangle2D);

    PathIterator b(AffineTransform affineTransform, double d2);

    boolean c(Point2D point2D);

    boolean d(double d2, double d3);

    boolean e(double d2, double d3, double d4, double d5);

    PathIterator f(AffineTransform affineTransform);

    boolean g(Rectangle2D rectangle2D);

    Rectangle getBounds();

    Rectangle2D h();

    boolean i(double d2, double d3, double d4, double d5);
}
