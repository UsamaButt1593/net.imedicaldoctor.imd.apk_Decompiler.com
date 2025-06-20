package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;

public class ChapterAutoNumber extends Chapter {
    private static final long m3 = -9217457637987854167L;
    protected boolean l3 = false;

    public ChapterAutoNumber(Paragraph paragraph) {
        super(paragraph, 0);
    }

    public int O1(int i2) {
        if (this.l3) {
            return i2;
        }
        int i3 = i2 + 1;
        super.t1(i3);
        this.l3 = true;
        return i3;
    }

    public Section b0(Paragraph paragraph) {
        if (!E0()) {
            return f0(paragraph, 2);
        }
        throw new IllegalStateException(MessageLocalization.b("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
    }

    public Section l0(String str) {
        if (!E0()) {
            return n0(str, 2);
        }
        throw new IllegalStateException(MessageLocalization.b("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
    }

    public ChapterAutoNumber(String str) {
        super(str, 0);
    }
}
