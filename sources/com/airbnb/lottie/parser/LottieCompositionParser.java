package com.airbnb.lottie.parser;

import androidx.collection.LongSparseArray;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;
import java.util.List;

public class LottieCompositionParser {

    /* renamed from: a  reason: collision with root package name */
    static JsonReader.Options f17311a = JsonReader.Options.a("w", CmcdData.Factory.f12510n, "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x007e, code lost:
        r0 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0089, code lost:
        r12 = r0;
        r13 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x004a, code lost:
        r24.w();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.LottieComposition a(com.airbnb.lottie.parser.moshi.JsonReader r24) throws java.io.IOException {
        /*
            r0 = r24
            float r1 = com.airbnb.lottie.utils.Utils.e()
            androidx.collection.LongSparseArray r8 = new androidx.collection.LongSparseArray
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            androidx.collection.SparseArrayCompat r11 = new androidx.collection.SparseArrayCompat
            r11.<init>()
            com.airbnb.lottie.LottieComposition r14 = new com.airbnb.lottie.LottieComposition
            r14.<init>()
            r24.d()
            r2 = 0
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r15 = 0
        L_0x0037:
            boolean r16 = r24.h()
            if (r16 == 0) goto L_0x00b4
            com.airbnb.lottie.parser.moshi.JsonReader$Options r3 = f17311a
            int r3 = r0.u(r3)
            switch(r3) {
                case 0: goto L_0x00ac;
                case 1: goto L_0x00a4;
                case 2: goto L_0x009b;
                case 3: goto L_0x008d;
                case 4: goto L_0x0081;
                case 5: goto L_0x004e;
                case 6: goto L_0x0047;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x004a
        L_0x0047:
            b(r0, r14, r7, r8)
        L_0x004a:
            r24.w()
            goto L_0x007e
        L_0x004e:
            java.lang.String r3 = r24.q()
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r3.split(r0)
            r3 = 0
            r17 = r0[r3]
            int r18 = java.lang.Integer.parseInt(r17)
            r3 = 1
            r3 = r0[r3]
            int r19 = java.lang.Integer.parseInt(r3)
            r3 = 2
            r0 = r0[r3]
            int r20 = java.lang.Integer.parseInt(r0)
            r22 = 4
            r23 = 0
            r21 = 4
            boolean r0 = com.airbnb.lottie.utils.Utils.j(r18, r19, r20, r21, r22, r23)
            if (r0 != 0) goto L_0x007e
            java.lang.String r0 = "Lottie only supports bodymovin >= 4.4.0"
            r14.a(r0)
        L_0x007e:
            r0 = r24
            goto L_0x0037
        L_0x0081:
            r0 = r12
            r17 = r13
            double r12 = r24.k()
            float r6 = (float) r12
        L_0x0089:
            r12 = r0
            r13 = r17
            goto L_0x007e
        L_0x008d:
            r0 = r12
            r17 = r13
            double r12 = r24.k()
            float r3 = (float) r12
            r5 = 1008981770(0x3c23d70a, float:0.01)
            float r5 = r3 - r5
            goto L_0x0089
        L_0x009b:
            r0 = r12
            r17 = r13
            double r3 = r24.k()
            float r4 = (float) r3
            goto L_0x007e
        L_0x00a4:
            r0 = r12
            r17 = r13
            int r15 = r24.n()
            goto L_0x007e
        L_0x00ac:
            r0 = r12
            r17 = r13
            int r2 = r24.n()
            goto L_0x007e
        L_0x00b4:
            r0 = r12
            r17 = r13
            float r2 = (float) r2
            float r2 = r2 * r1
            int r2 = (int) r2
            float r3 = (float) r15
            float r3 = r3 * r1
            int r1 = (int) r3
            android.graphics.Rect r3 = new android.graphics.Rect
            r12 = 0
            r3.<init>(r12, r12, r2, r1)
            r2 = r14
            r12 = r0
            r2.u(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.LottieCompositionParser.a(com.airbnb.lottie.parser.moshi.JsonReader):com.airbnb.lottie.LottieComposition");
    }

    private static void b(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.c();
        int i2 = 0;
        while (jsonReader.h()) {
            Layer b2 = LayerParser.b(jsonReader, lottieComposition);
            if (b2.d() == Layer.LayerType.IMAGE) {
                i2++;
            }
            list.add(b2);
            longSparseArray.p(b2.b(), b2);
            if (i2 > 4) {
                Logger.e("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.e();
    }
}
