package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

public class CircularFlow extends VirtualLayout {
    private static final String r3 = "CircularFlow";
    private static int s3;
    private static float t3;
    ConstraintLayout h3;
    int i3;
    private float[] j3;
    private int[] k3;
    private int l3;
    private int m3;
    private String n3;
    private String o3;
    private Float p3;
    private Integer q3;

    public CircularFlow(Context context) {
        super(context);
    }

    private void K(String str) {
        float[] fArr;
        if (str != null && str.length() != 0 && this.Y2 != null && (fArr = this.j3) != null) {
            if (this.m3 + 1 > fArr.length) {
                this.j3 = Arrays.copyOf(fArr, fArr.length + 1);
            }
            this.j3[this.m3] = (float) Integer.parseInt(str);
            this.m3++;
        }
    }

    private void L(String str) {
        int[] iArr;
        if (str != null && str.length() != 0 && this.Y2 != null && (iArr = this.k3) != null) {
            if (this.l3 + 1 > iArr.length) {
                this.k3 = Arrays.copyOf(iArr, iArr.length + 1);
            }
            this.k3[this.l3] = (int) (((float) Integer.parseInt(str)) * this.Y2.getResources().getDisplayMetrics().density);
            this.l3++;
        }
    }

    private void N() {
        this.h3 = (ConstraintLayout) getParent();
        for (int i2 = 0; i2 < this.X2; i2++) {
            View o = this.h3.o(this.s[i2]);
            if (o != null) {
                int i4 = s3;
                float f2 = t3;
                int[] iArr = this.k3;
                if (iArr == null || i2 >= iArr.length) {
                    Integer num = this.q3;
                    if (num == null || num.intValue() == -1) {
                        Log.e(r3, "Added radius to view with id: " + this.e3.get(Integer.valueOf(o.getId())));
                    } else {
                        this.l3++;
                        if (this.k3 == null) {
                            this.k3 = new int[1];
                        }
                        int[] radius = getRadius();
                        this.k3 = radius;
                        radius[this.l3 - 1] = i4;
                    }
                } else {
                    i4 = iArr[i2];
                }
                float[] fArr = this.j3;
                if (fArr == null || i2 >= fArr.length) {
                    Float f3 = this.p3;
                    if (f3 == null || f3.floatValue() == -1.0f) {
                        Log.e(r3, "Added angle to view with id: " + this.e3.get(Integer.valueOf(o.getId())));
                    } else {
                        this.m3++;
                        if (this.j3 == null) {
                            this.j3 = new float[1];
                        }
                        float[] angles = getAngles();
                        this.j3 = angles;
                        angles[this.m3 - 1] = f2;
                    }
                } else {
                    f2 = fArr[i2];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) o.getLayoutParams();
                layoutParams.r = f2;
                layoutParams.p = this.i3;
                layoutParams.q = i4;
                o.setLayoutParams(layoutParams);
            }
        }
        p();
    }

    private float[] P(float[] fArr, int i2) {
        return (fArr == null || i2 < 0 || i2 >= this.m3) ? fArr : Q(fArr, i2);
    }

    public static float[] Q(float[] fArr, int i2) {
        float[] fArr2 = new float[(fArr.length - 1)];
        int i4 = 0;
        for (int i5 = 0; i5 < fArr.length; i5++) {
            if (i5 != i2) {
                fArr2[i4] = fArr[i5];
                i4++;
            }
        }
        return fArr2;
    }

    public static int[] R(int[] iArr, int i2) {
        int[] iArr2 = new int[(iArr.length - 1)];
        int i4 = 0;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (i5 != i2) {
                iArr2[i4] = iArr[i5];
                i4++;
            }
        }
        return iArr2;
    }

    private int[] S(int[] iArr, int i2) {
        return (iArr == null || i2 < 0 || i2 >= this.l3) ? iArr : R(iArr, i2);
    }

    private void setAngles(String str) {
        if (str != null) {
            int i2 = 0;
            this.m3 = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    K(str.substring(i2).trim());
                    return;
                } else {
                    K(str.substring(i2, indexOf).trim());
                    i2 = indexOf + 1;
                }
            }
        }
    }

    private void setRadius(String str) {
        if (str != null) {
            int i2 = 0;
            this.l3 = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    L(str.substring(i2).trim());
                    return;
                } else {
                    L(str.substring(i2, indexOf).trim());
                    i2 = indexOf + 1;
                }
            }
        }
    }

    public int A(View view) {
        int A = super.A(view);
        if (A == -1) {
            return A;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.H(this.h3);
        constraintSet.F(view.getId(), 8);
        constraintSet.r(this.h3);
        float[] fArr = this.j3;
        if (A < fArr.length) {
            this.j3 = P(fArr, A);
            this.m3--;
        }
        int[] iArr = this.k3;
        if (A < iArr.length) {
            this.k3 = S(iArr, A);
            this.l3--;
        }
        N();
        return A;
    }

    public void M(View view, int i2, float f2) {
        if (!s(view.getId())) {
            o(view);
            this.m3++;
            float[] angles = getAngles();
            this.j3 = angles;
            angles[this.m3 - 1] = f2;
            this.l3++;
            int[] radius = getRadius();
            this.k3 = radius;
            radius[this.l3 - 1] = (int) (((float) i2) * this.Y2.getResources().getDisplayMetrics().density);
            N();
        }
    }

    public boolean O(View view) {
        return s(view.getId()) && x(view.getId()) != -1;
    }

    public void T(View view, float f2) {
        if (!O(view)) {
            Log.e(r3, "It was not possible to update angle to view with id: " + view.getId());
            return;
        }
        int x = x(view.getId());
        if (x <= this.j3.length) {
            float[] angles = getAngles();
            this.j3 = angles;
            angles[x] = f2;
            N();
        }
    }

    public void U(View view, int i2) {
        if (!O(view)) {
            Log.e(r3, "It was not possible to update radius to view with id: " + view.getId());
            return;
        }
        int x = x(view.getId());
        if (x <= this.k3.length) {
            int[] radius = getRadius();
            this.k3 = radius;
            radius[x] = (int) (((float) i2) * this.Y2.getResources().getDisplayMetrics().density);
            N();
        }
    }

    public void V(View view, int i2, float f2) {
        if (!O(view)) {
            Log.e(r3, "It was not possible to update radius and angle to view with id: " + view.getId());
            return;
        }
        int x = x(view.getId());
        if (getAngles().length > x) {
            float[] angles = getAngles();
            this.j3 = angles;
            angles[x] = f2;
        }
        if (getRadius().length > x) {
            int[] radius = getRadius();
            this.k3 = radius;
            radius[x] = (int) (((float) i2) * this.Y2.getResources().getDisplayMetrics().density);
        }
        N();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.j3, this.m3);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.k3, this.l3);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.n3;
        if (str != null) {
            this.j3 = new float[1];
            setAngles(str);
        }
        String str2 = this.o3;
        if (str2 != null) {
            this.k3 = new int[1];
            setRadius(str2);
        }
        Float f2 = this.p3;
        if (f2 != null) {
            setDefaultAngle(f2.floatValue());
        }
        Integer num = this.q3;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        N();
    }

    public void setDefaultAngle(float f2) {
        t3 = f2;
    }

    public void setDefaultRadius(int i2) {
        s3 = i2;
    }

    /* access modifiers changed from: protected */
    public void y(AttributeSet attributeSet) {
        super.y(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.y6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.g7) {
                    this.i3 = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.c7) {
                    String string = obtainStyledAttributes.getString(index);
                    this.n3 = string;
                    setAngles(string);
                } else if (index == R.styleable.f7) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.o3 = string2;
                    setRadius(string2);
                } else if (index == R.styleable.d7) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, t3));
                    this.p3 = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R.styleable.e7) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, s3));
                    this.q3 = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
