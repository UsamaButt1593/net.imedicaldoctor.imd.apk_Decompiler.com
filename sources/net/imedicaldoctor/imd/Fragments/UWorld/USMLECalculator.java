package net.imedicaldoctor.imd.Fragments.UWorld;

import android.os.Bundle;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class USMLECalculator {
    public static double a(int i2, int i3, int i4, ArrayList<Bundle> arrayList, double d2, double d3) {
        Iterator<Bundle> it2 = arrayList.iterator();
        double d4 = 0.0d;
        double d5 = 0.0d;
        while (it2.hasNext()) {
            Bundle next = it2.next();
            d5 += next.getDouble("ppltaken");
            d4 += next.getDouble("corrTaken");
        }
        return (d4 / d5) * 100.0d;
    }

    public static double b(int i2, int i3, int i4, ArrayList<Bundle> arrayList, double d2, double d3) {
        String str;
        int i5 = i2;
        int i6 = i5 + i3 + i4;
        Iterator<Bundle> it2 = arrayList.iterator();
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        while (true) {
            str = "corrTaken";
            if (!it2.hasNext()) {
                break;
            }
            Bundle next = it2.next();
            d6 += next.getDouble("ppltaken");
            d5 += next.getDouble(str);
        }
        double d7 = d5 / d6;
        double d8 = ((double) i5) / ((double) i6);
        Iterator<Bundle> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            Bundle next2 = it3.next();
            double d9 = next2.getDouble("ppltaken");
            d4 += d9 * Math.pow((next2.getDouble(str) / d9) - d7, 2.0d);
            str = str;
        }
        return d2 + (((d8 - d7) / Math.sqrt(d4 / d6)) * d3);
    }

    public static void c(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 100; i2++) {
            Bundle bundle = new Bundle();
            bundle.putDouble("ppltaken", 100.0d);
            bundle.putDouble("corrTaken", 60.0d);
            arrayList.add(bundle);
        }
        double b2 = b(70, 20, 10, arrayList, 500.0d, 100.0d);
        PrintStream printStream = System.out;
        printStream.println("USMLE Score: " + b2);
    }
}
