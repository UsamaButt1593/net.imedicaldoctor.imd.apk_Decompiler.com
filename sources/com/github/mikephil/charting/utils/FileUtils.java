package com.github.mikephil.charting.utils;

import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19144a = "MPChart-FileUtils";

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a A[SYNTHETIC, Splitter:B:20:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060 A[SYNTHETIC, Splitter:B:24:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.github.mikephil.charting.data.BarEntry> a(android.content.res.AssetManager r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "MPChart-FileUtils"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0050 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0050 }
            java.io.InputStream r5 = r5.open(r6)     // Catch:{ IOException -> 0x0050 }
            java.lang.String r6 = "UTF-8"
            r4.<init>(r5, r6)     // Catch:{ IOException -> 0x0050 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0050 }
        L_0x0018:
            java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            if (r5 == 0) goto L_0x0041
            java.lang.String r6 = "#"
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            com.github.mikephil.charting.data.BarEntry r6 = new com.github.mikephil.charting.data.BarEntry     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r2 = 1
            r2 = r5[r2]     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r4 = 0
            r5 = r5[r4]     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r6.<init>((float) r2, (float) r5)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r1.add(r6)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            goto L_0x0018
        L_0x003b:
            r5 = move-exception
            r2 = r3
            goto L_0x005e
        L_0x003e:
            r5 = move-exception
            r2 = r3
            goto L_0x0051
        L_0x0041:
            r3.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x005d
        L_0x0045:
            r5 = move-exception
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r0, r5)
            goto L_0x005d
        L_0x004e:
            r5 = move-exception
            goto L_0x005e
        L_0x0050:
            r5 = move-exception
        L_0x0051:
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x004e }
            android.util.Log.e(r0, r5)     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x005d
            r2.close()     // Catch:{ IOException -> 0x0045 }
        L_0x005d:
            return r1
        L_0x005e:
            if (r2 == 0) goto L_0x006c
            r2.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x006c
        L_0x0064:
            r6 = move-exception
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r0, r6)
        L_0x006c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.a(android.content.res.AssetManager, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e A[SYNTHETIC, Splitter:B:27:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084 A[SYNTHETIC, Splitter:B:31:0x0084] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.github.mikephil.charting.data.Entry> b(android.content.res.AssetManager r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "MPChart-FileUtils"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0074 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0074 }
            java.io.InputStream r7 = r7.open(r8)     // Catch:{ IOException -> 0x0074 }
            java.lang.String r8 = "UTF-8"
            r4.<init>(r7, r8)     // Catch:{ IOException -> 0x0074 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0074 }
        L_0x0018:
            java.lang.String r7 = r3.readLine()     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            if (r7 == 0) goto L_0x0065
            java.lang.String r8 = "#"
            java.lang.String[] r7 = r7.split(r8)     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            int r8 = r7.length     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            r2 = 2
            r4 = 0
            r5 = 1
            if (r8 > r2) goto L_0x0045
            com.github.mikephil.charting.data.Entry r8 = new com.github.mikephil.charting.data.Entry     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            r2 = r7[r5]     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            r7 = r7[r4]     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            r8.<init>(r2, r7)     // Catch:{ IOException -> 0x0042, all -> 0x003f }
        L_0x003b:
            r1.add(r8)     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            goto L_0x0018
        L_0x003f:
            r7 = move-exception
            r2 = r3
            goto L_0x0082
        L_0x0042:
            r7 = move-exception
            r2 = r3
            goto L_0x0075
        L_0x0045:
            int r8 = r7.length     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            int r8 = r8 - r5
            float[] r2 = new float[r8]     // Catch:{ IOException -> 0x0042, all -> 0x003f }
        L_0x0049:
            if (r4 >= r8) goto L_0x0056
            r6 = r7[r4]     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            r2[r4] = r6     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            int r4 = r4 + 1
            goto L_0x0049
        L_0x0056:
            com.github.mikephil.charting.data.BarEntry r8 = new com.github.mikephil.charting.data.BarEntry     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            int r4 = r7.length     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            int r4 = r4 - r5
            r7 = r7[r4]     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            float r7 = (float) r7     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            r8.<init>((float) r7, (float[]) r2)     // Catch:{ IOException -> 0x0042, all -> 0x003f }
            goto L_0x003b
        L_0x0065:
            r3.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x0081
        L_0x0069:
            r7 = move-exception
            java.lang.String r7 = r7.toString()
            android.util.Log.e(r0, r7)
            goto L_0x0081
        L_0x0072:
            r7 = move-exception
            goto L_0x0082
        L_0x0074:
            r7 = move-exception
        L_0x0075:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0072 }
            android.util.Log.e(r0, r7)     // Catch:{ all -> 0x0072 }
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0081:
            return r1
        L_0x0082:
            if (r2 == 0) goto L_0x0090
            r2.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x0090
        L_0x0088:
            r8 = move-exception
            java.lang.String r8 = r8.toString()
            android.util.Log.e(r0, r8)
        L_0x0090:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.b(android.content.res.AssetManager, java.lang.String):java.util.List");
    }

    public static List<Entry> c(String str) {
        Object barEntry;
        File file = new File(Environment.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split("#");
                if (split.length <= 2) {
                    barEntry = new Entry(Float.parseFloat(split[0]), (float) Integer.parseInt(split[1]));
                } else {
                    int length = split.length - 1;
                    float[] fArr = new float[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        fArr[i2] = Float.parseFloat(split[i2]);
                    }
                    barEntry = new BarEntry((float) Integer.parseInt(split[split.length - 1]), fArr);
                }
                arrayList.add(barEntry);
            }
        } catch (IOException e2) {
            Log.e(f19144a, e2.toString());
        }
        return arrayList;
    }

    public static void d(List<Entry> list, String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                Log.e(f19144a, e2.toString());
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry next : list) {
                bufferedWriter.append(next.c() + "#" + next.m());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e3) {
            Log.e(f19144a, e3.toString());
        }
    }
}
