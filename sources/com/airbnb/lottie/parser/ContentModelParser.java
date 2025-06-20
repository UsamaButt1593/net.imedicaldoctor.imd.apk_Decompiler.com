package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

class ContentModelParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17283a = JsonReader.Options.a("ty", "d");

    private ContentModelParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c0, code lost:
        if (r3.equals("fl") == false) goto L_0x0034;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.ContentModel a(com.airbnb.lottie.parser.moshi.JsonReader r7, com.airbnb.lottie.LottieComposition r8) throws java.io.IOException {
        /*
            r0 = 1
            r7.d()
            r1 = 2
            r2 = 2
        L_0x0006:
            boolean r3 = r7.h()
            r4 = 0
            if (r3 == 0) goto L_0x0028
            com.airbnb.lottie.parser.moshi.JsonReader$Options r3 = f17283a
            int r3 = r7.u(r3)
            if (r3 == 0) goto L_0x0023
            if (r3 == r0) goto L_0x001e
            r7.v()
            r7.w()
            goto L_0x0006
        L_0x001e:
            int r2 = r7.n()
            goto L_0x0006
        L_0x0023:
            java.lang.String r3 = r7.q()
            goto L_0x0029
        L_0x0028:
            r3 = r4
        L_0x0029:
            if (r3 != 0) goto L_0x002c
            return r4
        L_0x002c:
            r5 = -1
            int r6 = r3.hashCode()
            switch(r6) {
                case 3239: goto L_0x00c4;
                case 3270: goto L_0x00ba;
                case 3295: goto L_0x00ae;
                case 3307: goto L_0x00a3;
                case 3308: goto L_0x0098;
                case 3488: goto L_0x008d;
                case 3633: goto L_0x0082;
                case 3646: goto L_0x0077;
                case 3669: goto L_0x006b;
                case 3679: goto L_0x005e;
                case 3681: goto L_0x0051;
                case 3705: goto L_0x0044;
                case 3710: goto L_0x0037;
                default: goto L_0x0034;
            }
        L_0x0034:
            r0 = -1
            goto L_0x00cf
        L_0x0037:
            java.lang.String r0 = "tr"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0040
            goto L_0x0034
        L_0x0040:
            r0 = 12
            goto L_0x00cf
        L_0x0044:
            java.lang.String r0 = "tm"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x004d
            goto L_0x0034
        L_0x004d:
            r0 = 11
            goto L_0x00cf
        L_0x0051:
            java.lang.String r0 = "st"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x005a
            goto L_0x0034
        L_0x005a:
            r0 = 10
            goto L_0x00cf
        L_0x005e:
            java.lang.String r0 = "sr"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0067
            goto L_0x0034
        L_0x0067:
            r0 = 9
            goto L_0x00cf
        L_0x006b:
            java.lang.String r0 = "sh"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0074
            goto L_0x0034
        L_0x0074:
            r0 = 8
            goto L_0x00cf
        L_0x0077:
            java.lang.String r0 = "rp"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0080
            goto L_0x0034
        L_0x0080:
            r0 = 7
            goto L_0x00cf
        L_0x0082:
            java.lang.String r0 = "rc"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x008b
            goto L_0x0034
        L_0x008b:
            r0 = 6
            goto L_0x00cf
        L_0x008d:
            java.lang.String r0 = "mm"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0096
            goto L_0x0034
        L_0x0096:
            r0 = 5
            goto L_0x00cf
        L_0x0098:
            java.lang.String r0 = "gs"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00a1
            goto L_0x0034
        L_0x00a1:
            r0 = 4
            goto L_0x00cf
        L_0x00a3:
            java.lang.String r0 = "gr"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00ac
            goto L_0x0034
        L_0x00ac:
            r0 = 3
            goto L_0x00cf
        L_0x00ae:
            java.lang.String r0 = "gf"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00b8
            goto L_0x0034
        L_0x00b8:
            r0 = 2
            goto L_0x00cf
        L_0x00ba:
            java.lang.String r1 = "fl"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00cf
            goto L_0x0034
        L_0x00c4:
            java.lang.String r0 = "el"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00ce
            goto L_0x0034
        L_0x00ce:
            r0 = 0
        L_0x00cf:
            switch(r0) {
                case 0: goto L_0x0128;
                case 1: goto L_0x0123;
                case 2: goto L_0x011e;
                case 3: goto L_0x0119;
                case 4: goto L_0x0114;
                case 5: goto L_0x010a;
                case 6: goto L_0x0105;
                case 7: goto L_0x0100;
                case 8: goto L_0x00fb;
                case 9: goto L_0x00f6;
                case 10: goto L_0x00f1;
                case 11: goto L_0x00ec;
                case 12: goto L_0x00e7;
                default: goto L_0x00d2;
            }
        L_0x00d2:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unknown shape type "
            r8.append(r0)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            com.airbnb.lottie.utils.Logger.e(r8)
            goto L_0x012c
        L_0x00e7:
            com.airbnb.lottie.model.animatable.AnimatableTransform r4 = com.airbnb.lottie.parser.AnimatableTransformParser.g(r7, r8)
            goto L_0x012c
        L_0x00ec:
            com.airbnb.lottie.model.content.ShapeTrimPath r4 = com.airbnb.lottie.parser.ShapeTrimPathParser.a(r7, r8)
            goto L_0x012c
        L_0x00f1:
            com.airbnb.lottie.model.content.ShapeStroke r4 = com.airbnb.lottie.parser.ShapeStrokeParser.a(r7, r8)
            goto L_0x012c
        L_0x00f6:
            com.airbnb.lottie.model.content.PolystarShape r4 = com.airbnb.lottie.parser.PolystarShapeParser.a(r7, r8)
            goto L_0x012c
        L_0x00fb:
            com.airbnb.lottie.model.content.ShapePath r4 = com.airbnb.lottie.parser.ShapePathParser.a(r7, r8)
            goto L_0x012c
        L_0x0100:
            com.airbnb.lottie.model.content.Repeater r4 = com.airbnb.lottie.parser.RepeaterParser.a(r7, r8)
            goto L_0x012c
        L_0x0105:
            com.airbnb.lottie.model.content.RectangleShape r4 = com.airbnb.lottie.parser.RectangleShapeParser.a(r7, r8)
            goto L_0x012c
        L_0x010a:
            com.airbnb.lottie.model.content.MergePaths r4 = com.airbnb.lottie.parser.MergePathsParser.a(r7)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r8.a(r0)
            goto L_0x012c
        L_0x0114:
            com.airbnb.lottie.model.content.GradientStroke r4 = com.airbnb.lottie.parser.GradientStrokeParser.a(r7, r8)
            goto L_0x012c
        L_0x0119:
            com.airbnb.lottie.model.content.ShapeGroup r4 = com.airbnb.lottie.parser.ShapeGroupParser.a(r7, r8)
            goto L_0x012c
        L_0x011e:
            com.airbnb.lottie.model.content.GradientFill r4 = com.airbnb.lottie.parser.GradientFillParser.a(r7, r8)
            goto L_0x012c
        L_0x0123:
            com.airbnb.lottie.model.content.ShapeFill r4 = com.airbnb.lottie.parser.ShapeFillParser.a(r7, r8)
            goto L_0x012c
        L_0x0128:
            com.airbnb.lottie.model.content.CircleShape r4 = com.airbnb.lottie.parser.CircleShapeParser.a(r7, r8, r2)
        L_0x012c:
            boolean r8 = r7.h()
            if (r8 == 0) goto L_0x0136
            r7.w()
            goto L_0x012c
        L_0x0136:
            r7.f()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.ContentModelParser.a(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.ContentModel");
    }
}
