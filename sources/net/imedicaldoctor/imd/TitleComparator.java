package net.imedicaldoctor.imd;

import android.os.Bundle;
import java.util.Comparator;

public class TitleComparator implements Comparator<Bundle> {
    private String s;

    public TitleComparator(String str) {
        this.s = str;
    }

    private int b(String str) {
        String[] split = str.split("\\.");
        if (split.length > 0) {
            try {
                return Integer.parseInt(split[0].trim());
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    /* renamed from: a */
    public int compare(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString(this.s);
        String string2 = bundle2.getString(this.s);
        if (!(string == null || string2 == null)) {
            int b2 = b(string);
            int b3 = b(string2);
            if (b2 != -1 && b3 != -1) {
                return Integer.compare(b2, b3);
            }
            if (b2 != -1) {
                return -1;
            }
            if (b3 != -1) {
                return 1;
            }
        }
        return 0;
    }
}
