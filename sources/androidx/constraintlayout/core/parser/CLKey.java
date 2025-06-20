package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;

public class CLKey extends CLContainer {
    private static ArrayList<String> b3;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        b3 = arrayList;
        arrayList.add("ConstraintSets");
        b3.add("Variables");
        b3.add("Generate");
        b3.add(TypedValues.TransitionType.f4024a);
        b3.add("KeyFrames");
        b3.add(TypedValues.AttributesType.f3934a);
        b3.add("KeyPositions");
        b3.add("KeyCycles");
    }

    public CLKey(char[] cArr) {
        super(cArr);
    }

    public static CLElement H(char[] cArr) {
        return new CLKey(cArr);
    }

    public static CLElement k0(String str, CLElement cLElement) {
        CLKey cLKey = new CLKey(str.toCharArray());
        cLKey.C(0);
        cLKey.z((long) (str.length() - 1));
        cLKey.n0(cLElement);
        return cLKey;
    }

    /* access modifiers changed from: protected */
    public String D(int i2, int i3) {
        StringBuilder sb = new StringBuilder(g());
        b(sb, i2);
        String c2 = c();
        if (this.a3.size() > 0) {
            sb.append(c2);
            sb.append(": ");
            if (b3.contains(c2)) {
                i3 = 3;
            }
            if (i3 <= 0) {
                String E = this.a3.get(0).E();
                if (E.length() + i2 < CLElement.Y2) {
                    sb.append(E);
                    return sb.toString();
                }
            }
            sb.append(this.a3.get(0).D(i2, i3 - 1));
            return sb.toString();
        }
        return c2 + ": <> ";
    }

    /* access modifiers changed from: protected */
    public String E() {
        StringBuilder sb;
        String str;
        if (this.a3.size() > 0) {
            sb = new StringBuilder();
            sb.append(g());
            sb.append(c());
            sb.append(": ");
            str = this.a3.get(0).E();
        } else {
            sb = new StringBuilder();
            sb.append(g());
            sb.append(c());
            str = ": <> ";
        }
        sb.append(str);
        return sb.toString();
    }

    public String l0() {
        return c();
    }

    public CLElement m0() {
        if (this.a3.size() > 0) {
            return this.a3.get(0);
        }
        return null;
    }

    public void n0(CLElement cLElement) {
        if (this.a3.size() > 0) {
            this.a3.set(0, cLElement);
        } else {
            this.a3.add(cLElement);
        }
    }
}
