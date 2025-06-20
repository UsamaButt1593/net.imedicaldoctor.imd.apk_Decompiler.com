package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;
import java.util.List;
import net.imedicaldoctor.imd.BuildConfig;
import org.apache.commons.httpclient.HttpStatus;

public class ColorTemplate {

    /* renamed from: a  reason: collision with root package name */
    public static final int f19136a = 1122867;

    /* renamed from: b  reason: collision with root package name */
    public static final int f19137b = 1122868;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f19138c = {Color.rgb(HttpStatus.SC_MULTI_STATUS, 248, 246), Color.rgb(148, 212, 212), Color.rgb(TsExtractor.V, BuildConfig.f29478d, 187), Color.rgb(118, 174, 175), Color.rgb(42, 109, TsExtractor.L)};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f19139d = {Color.rgb(217, 80, TsExtractor.K), Color.rgb(TIFFConstants.f26648a, 149, 7), Color.rgb(TIFFConstants.f26648a, MetaDo.s0, 120), Color.rgb(106, 167, TsExtractor.T), Color.rgb(53, 194, 209)};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f19140e = {Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(217, 184, 162), Color.rgb(191, TsExtractor.T, TsExtractor.T), Color.rgb(179, 48, 80)};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f19141f = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(179, 100, 53)};

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f19142g = {Color.rgb(PsExtractor.x, 255, 140), Color.rgb(255, MetaDo.s0, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f19143h = {e("#2ecc71"), e("#f1c40f"), e("#e74c3c"), e("#3498db")};

    public static int a(int i2, int i3) {
        return (i2 & ViewCompat.x) | ((i3 & 255) << 24);
    }

    public static List<Integer> b(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int color : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(color)));
        }
        return arrayList;
    }

    public static List<Integer> c(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    public static int d() {
        return Color.rgb(51, 181, 229);
    }

    public static int e(String str) {
        int parseLong = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((parseLong >> 16) & 255, (parseLong >> 8) & 255, parseLong & 255);
    }
}
