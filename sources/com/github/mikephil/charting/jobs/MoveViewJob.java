package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class MoveViewJob extends ViewPortJob {
    private static ObjectPool<MoveViewJob> b3;

    static {
        ObjectPool<MoveViewJob> a2 = ObjectPool.a(2, new MoveViewJob((ViewPortHandler) null, 0.0f, 0.0f, (Transformer) null, (View) null));
        b3 = a2;
        a2.l(0.5f);
    }

    public MoveViewJob(ViewPortHandler viewPortHandler, float f2, float f3, Transformer transformer, View view) {
        super(viewPortHandler, f2, f3, transformer, view);
    }

    public static MoveViewJob d(ViewPortHandler viewPortHandler, float f2, float f3, Transformer transformer, View view) {
        MoveViewJob b2 = b3.b();
        b2.Z = viewPortHandler;
        b2.X2 = f2;
        b2.Y2 = f3;
        b2.Z2 = transformer;
        b2.a3 = view;
        return b2;
    }

    public static void e(MoveViewJob moveViewJob) {
        b3.g(moveViewJob);
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable a() {
        return new MoveViewJob(this.Z, this.X2, this.Y2, this.Z2, this.a3);
    }

    public void run() {
        float[] fArr = this.Y;
        fArr[0] = this.X2;
        fArr[1] = this.Y2;
        this.Z2.o(fArr);
        this.Z.e(this.Y, this.a3);
        e(this);
    }
}
