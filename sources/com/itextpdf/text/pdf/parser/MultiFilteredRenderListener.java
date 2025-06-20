package com.itextpdf.text.pdf.parser;

import java.util.ArrayList;
import java.util.List;

public class MultiFilteredRenderListener implements RenderListener {

    /* renamed from: a  reason: collision with root package name */
    private final List<RenderListener> f26980a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<RenderFilter[]> f26981b = new ArrayList();

    public void a() {
        for (RenderListener a2 : this.f26980a) {
            a2.a();
        }
    }

    public void c(ImageRenderInfo imageRenderInfo) {
        for (int i2 = 0; i2 < this.f26980a.size(); i2++) {
            RenderFilter[] renderFilterArr = this.f26981b.get(i2);
            int length = renderFilterArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    this.f26980a.get(i2).c(imageRenderInfo);
                    break;
                } else if (!renderFilterArr[i3].a(imageRenderInfo)) {
                    break;
                } else {
                    i3++;
                }
            }
        }
    }

    public void e(TextRenderInfo textRenderInfo) {
        for (int i2 = 0; i2 < this.f26980a.size(); i2++) {
            RenderFilter[] renderFilterArr = this.f26981b.get(i2);
            int length = renderFilterArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    this.f26980a.get(i2).e(textRenderInfo);
                    break;
                } else if (!renderFilterArr[i3].b(textRenderInfo)) {
                    break;
                } else {
                    i3++;
                }
            }
        }
    }

    public void h() {
        for (RenderListener h2 : this.f26980a) {
            h2.h();
        }
    }

    public <E extends RenderListener> E i(E e2, RenderFilter... renderFilterArr) {
        this.f26980a.add(e2);
        this.f26981b.add(renderFilterArr);
        return e2;
    }
}
