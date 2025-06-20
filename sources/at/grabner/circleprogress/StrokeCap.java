package at.grabner.circleprogress;

import android.graphics.Paint;

public enum StrokeCap {
    BUTT(Paint.Cap.BUTT),
    ROUND(Paint.Cap.ROUND),
    SQUARE(Paint.Cap.SQUARE);
    
    final Paint.Cap s;

    private StrokeCap(Paint.Cap cap) {
        this.s = cap;
    }
}
