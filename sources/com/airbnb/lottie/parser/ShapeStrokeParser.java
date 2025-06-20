package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

class ShapeStrokeParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17324a = JsonReader.Options.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f17325b = JsonReader.Options.a("n", "v");

    private ShapeStrokeParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.ShapeStroke a(com.airbnb.lottie.parser.moshi.JsonReader r18, com.airbnb.lottie.LottieComposition r19) throws java.io.IOException {
        /*
            r0 = r18
            r1 = 1
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r3 = 0
            r4 = 0
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0013:
            boolean r14 = r18.h()
            if (r14 == 0) goto L_0x00fa
            com.airbnb.lottie.parser.moshi.JsonReader$Options r14 = f17324a
            int r14 = r0.u(r14)
            switch(r14) {
                case 0: goto L_0x00f2;
                case 1: goto L_0x00ea;
                case 2: goto L_0x00e2;
                case 3: goto L_0x00da;
                case 4: goto L_0x00cb;
                case 5: goto L_0x00bc;
                case 6: goto L_0x00b3;
                case 7: goto L_0x00ab;
                case 8: goto L_0x0026;
                default: goto L_0x0022;
            }
        L_0x0022:
            r18.w()
            goto L_0x0013
        L_0x0026:
            r18.c()
        L_0x0029:
            boolean r14 = r18.h()
            if (r14 == 0) goto L_0x0097
            r18.d()
            r14 = 0
            r15 = 0
        L_0x0034:
            boolean r16 = r18.h()
            if (r16 == 0) goto L_0x0055
            com.airbnb.lottie.parser.moshi.JsonReader$Options r2 = f17325b
            int r2 = r0.u(r2)
            if (r2 == 0) goto L_0x0050
            if (r2 == r1) goto L_0x004b
            r18.v()
            r18.w()
            goto L_0x0034
        L_0x004b:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r15 = com.airbnb.lottie.parser.AnimatableValueParser.e(r18, r19)
            goto L_0x0034
        L_0x0050:
            java.lang.String r14 = r18.q()
            goto L_0x0034
        L_0x0055:
            r18.f()
            r14.hashCode()
            int r17 = r14.hashCode()
            switch(r17) {
                case 100: goto L_0x007a;
                case 103: goto L_0x006f;
                case 111: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            r2 = -1
            goto L_0x0084
        L_0x0064:
            java.lang.String r2 = "o"
            boolean r2 = r14.equals(r2)
            if (r2 != 0) goto L_0x006d
            goto L_0x0062
        L_0x006d:
            r2 = 2
            goto L_0x0084
        L_0x006f:
            java.lang.String r2 = "g"
            boolean r2 = r14.equals(r2)
            if (r2 != 0) goto L_0x0078
            goto L_0x0062
        L_0x0078:
            r2 = 1
            goto L_0x0084
        L_0x007a:
            java.lang.String r2 = "d"
            boolean r2 = r14.equals(r2)
            if (r2 != 0) goto L_0x0083
            goto L_0x0062
        L_0x0083:
            r2 = 0
        L_0x0084:
            switch(r2) {
                case 0: goto L_0x008e;
                case 1: goto L_0x008e;
                case 2: goto L_0x008a;
                default: goto L_0x0087;
            }
        L_0x0087:
            r2 = r19
            goto L_0x0029
        L_0x008a:
            r2 = r19
            r6 = r15
            goto L_0x0029
        L_0x008e:
            r2 = r19
            r2.w(r1)
            r5.add(r15)
            goto L_0x0029
        L_0x0097:
            r2 = r19
            r18.e()
            int r14 = r5.size()
            if (r14 != r1) goto L_0x0013
            java.lang.Object r14 = r5.get(r4)
            r5.add(r14)
            goto L_0x0013
        L_0x00ab:
            r2 = r19
            boolean r13 = r18.i()
            goto L_0x0013
        L_0x00b3:
            r2 = r19
            double r14 = r18.k()
            float r12 = (float) r14
            goto L_0x0013
        L_0x00bc:
            r2 = r19
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r11 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
            int r14 = r18.n()
            int r14 = r14 - r1
            r11 = r11[r14]
            goto L_0x0013
        L_0x00cb:
            r2 = r19
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r10 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
            int r14 = r18.n()
            int r14 = r14 - r1
            r10 = r10[r14]
            goto L_0x0013
        L_0x00da:
            r2 = r19
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r8 = com.airbnb.lottie.parser.AnimatableValueParser.h(r18, r19)
            goto L_0x0013
        L_0x00e2:
            r2 = r19
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r9 = com.airbnb.lottie.parser.AnimatableValueParser.e(r18, r19)
            goto L_0x0013
        L_0x00ea:
            r2 = r19
            com.airbnb.lottie.model.animatable.AnimatableColorValue r7 = com.airbnb.lottie.parser.AnimatableValueParser.c(r18, r19)
            goto L_0x0013
        L_0x00f2:
            r2 = r19
            java.lang.String r3 = r18.q()
            goto L_0x0013
        L_0x00fa:
            com.airbnb.lottie.model.content.ShapeStroke r0 = new com.airbnb.lottie.model.content.ShapeStroke
            r2 = r0
            r4 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.ShapeStrokeParser.a(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.ShapeStroke");
    }
}
