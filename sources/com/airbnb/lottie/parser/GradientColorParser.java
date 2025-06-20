package com.airbnb.lottie.parser;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradientColorParser implements ValueParser<GradientColor> {

    /* renamed from: a  reason: collision with root package name */
    private int f17290a;

    public GradientColorParser(int i2) {
        this.f17290a = i2;
    }

    private void b(GradientColor gradientColor, List<Float> list) {
        int i2 = this.f17290a * 4;
        if (list.size() > i2) {
            int size = (list.size() - i2) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i3 = 0;
            while (i2 < list.size()) {
                if (i2 % 2 == 0) {
                    dArr[i3] = (double) list.get(i2).floatValue();
                } else {
                    dArr2[i3] = (double) list.get(i2).floatValue();
                    i3++;
                }
                i2++;
            }
            for (int i4 = 0; i4 < gradientColor.c(); i4++) {
                int i5 = gradientColor.a()[i4];
                gradientColor.a()[i4] = Color.argb(c((double) gradientColor.b()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
            }
        }
    }

    @IntRange(from = 0, to = 255)
    private int c(double d2, double[] dArr, double[] dArr2) {
        double d3;
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int i2 = 1;
        while (true) {
            if (i2 >= dArr3.length) {
                d3 = dArr4[dArr4.length - 1];
                break;
            }
            int i3 = i2 - 1;
            double d4 = dArr3[i3];
            double d5 = dArr3[i2];
            if (d5 >= d2) {
                d3 = MiscUtils.i(dArr4[i3], dArr4[i2], (d2 - d4) / (d5 - d4));
                break;
            }
            i2++;
        }
        return (int) (d3 * 255.0d);
    }

    /* renamed from: d */
    public GradientColor a(JsonReader jsonReader, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.s() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        while (jsonReader.h()) {
            arrayList.add(Float.valueOf((float) jsonReader.k()));
        }
        if (z) {
            jsonReader.e();
        }
        if (this.f17290a == -1) {
            this.f17290a = arrayList.size() / 4;
        }
        int i2 = this.f17290a;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f17290a * 4; i5++) {
            int i6 = i5 / 4;
            double floatValue = (double) ((Float) arrayList.get(i5)).floatValue();
            int i7 = i5 % 4;
            if (i7 == 0) {
                fArr[i6] = (float) floatValue;
            } else if (i7 == 1) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i7 == 2) {
                i4 = (int) (floatValue * 255.0d);
            } else if (i7 == 3) {
                iArr[i6] = Color.argb(255, i3, i4, (int) (floatValue * 255.0d));
            }
        }
        GradientColor gradientColor = new GradientColor(fArr, iArr);
        b(gradientColor, arrayList);
        return gradientColor;
    }
}
