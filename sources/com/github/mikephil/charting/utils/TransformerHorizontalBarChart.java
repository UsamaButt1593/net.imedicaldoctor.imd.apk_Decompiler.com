package com.github.mikephil.charting.utils;

public class TransformerHorizontalBarChart extends Transformer {
    public TransformerHorizontalBarChart(ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
    }

    public void p(boolean z) {
        this.f19153b.reset();
        if (!z) {
            this.f19153b.postTranslate(this.f19154c.P(), this.f19154c.n() - this.f19154c.O());
            return;
        }
        this.f19153b.setTranslate(-(this.f19154c.o() - this.f19154c.Q()), this.f19154c.n() - this.f19154c.O());
        this.f19153b.postScale(-1.0f, 1.0f);
    }
}
