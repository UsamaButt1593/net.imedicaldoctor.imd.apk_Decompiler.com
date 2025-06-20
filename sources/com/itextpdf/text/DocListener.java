package com.itextpdf.text;

public interface DocListener extends ElementListener {
    boolean c(boolean z);

    void close();

    boolean f();

    boolean g(boolean z);

    boolean j(Rectangle rectangle);

    boolean k(float f2, float f3, float f4, float f5);

    void open();

    void s();

    void t(int i2);
}
