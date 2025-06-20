package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class BubbleDataSet extends BarLineScatterCandleBubbleDataSet<BubbleEntry> implements IBubbleDataSet {
    private float A = 2.5f;
    protected float y;
    protected boolean z = true;

    public BubbleDataSet(List<BubbleEntry> list, String str) {
        super(list, str);
    }

    public DataSet<BubbleEntry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            arrayList.add(((BubbleEntry) this.s.get(i2)).k());
        }
        BubbleDataSet bubbleDataSet = new BubbleDataSet(arrayList, H());
        V1(bubbleDataSet);
        return bubbleDataSet;
    }

    public float S0() {
        return this.A;
    }

    /* access modifiers changed from: protected */
    /* renamed from: U1 */
    public void K1(BubbleEntry bubbleEntry) {
        super.K1(bubbleEntry);
        float t = bubbleEntry.t();
        if (t > this.y) {
            this.y = t;
        }
    }

    /* access modifiers changed from: protected */
    public void V1(BubbleDataSet bubbleDataSet) {
        bubbleDataSet.A = this.A;
        bubbleDataSet.z = this.z;
    }

    public void W1(boolean z2) {
        this.z = z2;
    }

    public float a() {
        return this.y;
    }

    public boolean e() {
        return this.z;
    }

    public void g0(float f2) {
        this.A = Utils.e(f2);
    }
}
