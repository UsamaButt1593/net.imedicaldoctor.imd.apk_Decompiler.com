package com.itextpdf.tool.xml.html.pdfelement;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.pdf.draw.DrawInterface;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

public class TabbedChunk extends Chunk {
    private int E3;
    private String F3;

    public TabbedChunk(VerticalPositionMark verticalPositionMark, float f2, boolean z) {
        super((DrawInterface) verticalPositionMark, f2, z);
    }

    public String j0() {
        return this.F3;
    }

    public int l0() {
        return this.E3;
    }

    public void m0(String str) {
        this.F3 = str;
    }

    public void n0(int i2) {
        this.E3 = i2;
    }

    public TabbedChunk(VerticalPositionMark verticalPositionMark, float f2, boolean z, String str) {
        super((DrawInterface) verticalPositionMark, f2, z);
        this.F3 = str;
    }

    public TabbedChunk(String str) {
        super(str);
    }
}
