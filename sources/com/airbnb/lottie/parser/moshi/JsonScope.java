package com.airbnb.lottie.parser.moshi;

import org.apache.commons.lang3.ClassUtils;

final class JsonScope {

    /* renamed from: a  reason: collision with root package name */
    static final int f17329a = 1;

    /* renamed from: b  reason: collision with root package name */
    static final int f17330b = 2;

    /* renamed from: c  reason: collision with root package name */
    static final int f17331c = 3;

    /* renamed from: d  reason: collision with root package name */
    static final int f17332d = 4;

    /* renamed from: e  reason: collision with root package name */
    static final int f17333e = 5;

    /* renamed from: f  reason: collision with root package name */
    static final int f17334f = 6;

    /* renamed from: g  reason: collision with root package name */
    static final int f17335g = 7;

    /* renamed from: h  reason: collision with root package name */
    static final int f17336h = 8;

    private JsonScope() {
    }

    static String a(int i2, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = iArr[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(iArr2[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = strArr[i3];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
