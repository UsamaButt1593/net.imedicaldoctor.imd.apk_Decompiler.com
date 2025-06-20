package androidx.constraintlayout.core.parser;

import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement H(char[] cArr) {
        return new CLArray(cArr);
    }

    /* access modifiers changed from: protected */
    public String D(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        String E = E();
        if (i3 > 0 || E.length() + i2 >= CLElement.Y2) {
            sb.append("[\n");
            Iterator<CLElement> it2 = this.a3.iterator();
            boolean z = true;
            while (it2.hasNext()) {
                CLElement next = it2.next();
                if (!z) {
                    sb.append(",\n");
                } else {
                    z = false;
                }
                b(sb, CLElement.Z2 + i2);
                sb.append(next.D(CLElement.Z2 + i2, i3 - 1));
            }
            sb.append(StringUtils.LF);
            b(sb, i2);
            sb.append("]");
        } else {
            sb.append(E);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String E() {
        StringBuilder sb = new StringBuilder(g() + "[");
        boolean z = true;
        for (int i2 = 0; i2 < this.a3.size(); i2++) {
            if (!z) {
                sb.append(", ");
            } else {
                z = false;
            }
            sb.append(this.a3.get(i2).E());
        }
        return sb + "]";
    }
}
