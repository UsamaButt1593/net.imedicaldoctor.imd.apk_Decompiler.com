package androidx.constraintlayout.core.parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class CLContainer extends CLElement {
    ArrayList<CLElement> a3 = new ArrayList<>();

    public CLContainer(char[] cArr) {
        super(cArr);
    }

    public static CLElement H(char[] cArr) {
        return new CLContainer(cArr);
    }

    public void G(CLElement cLElement) {
        this.a3.add(cLElement);
        if (CLParser.f4065d) {
            PrintStream printStream = System.out;
            printStream.println("added element " + cLElement + " to " + this);
        }
    }

    public CLElement I(int i2) throws CLParsingException {
        if (i2 >= 0 && i2 < this.a3.size()) {
            return this.a3.get(i2);
        }
        throw new CLParsingException("no element at index " + i2, this);
    }

    public CLElement K(String str) throws CLParsingException {
        Iterator<CLElement> it2 = this.a3.iterator();
        while (it2.hasNext()) {
            CLKey cLKey = (CLKey) it2.next();
            if (cLKey.c().equals(str)) {
                return cLKey.m0();
            }
        }
        throw new CLParsingException("no element for key <" + str + ">", this);
    }

    public CLArray L(int i2) throws CLParsingException {
        CLElement I = I(i2);
        if (I instanceof CLArray) {
            return (CLArray) I;
        }
        throw new CLParsingException("no array at index " + i2, this);
    }

    public CLArray M(String str) throws CLParsingException {
        CLElement K = K(str);
        if (K instanceof CLArray) {
            return (CLArray) K;
        }
        throw new CLParsingException("no array found for key <" + str + ">, found [" + K.o() + "] : " + K, this);
    }

    public CLArray N(String str) {
        CLElement Y = Y(str);
        if (Y instanceof CLArray) {
            return (CLArray) Y;
        }
        return null;
    }

    public boolean O(String str) throws CLParsingException {
        CLElement K = K(str);
        if (K instanceof CLToken) {
            return ((CLToken) K).H();
        }
        throw new CLParsingException("no boolean found for key <" + str + ">, found [" + K.o() + "] : " + K, this);
    }

    public float P(String str) throws CLParsingException {
        CLElement K = K(str);
        if (K != null) {
            return K.j();
        }
        throw new CLParsingException("no float found for key <" + str + ">, found [" + K.o() + "] : " + K, this);
    }

    public float R(String str) {
        CLElement Y = Y(str);
        if (Y instanceof CLNumber) {
            return Y.j();
        }
        return Float.NaN;
    }

    public int T(String str) throws CLParsingException {
        CLElement K = K(str);
        if (K != null) {
            return K.k();
        }
        throw new CLParsingException("no int found for key <" + str + ">, found [" + K.o() + "] : " + K, this);
    }

    public CLObject U(int i2) throws CLParsingException {
        CLElement I = I(i2);
        if (I instanceof CLObject) {
            return (CLObject) I;
        }
        throw new CLParsingException("no object at index " + i2, this);
    }

    public CLObject V(String str) throws CLParsingException {
        CLElement K = K(str);
        if (K instanceof CLObject) {
            return (CLObject) K;
        }
        throw new CLParsingException("no object found for key <" + str + ">, found [" + K.o() + "] : " + K, this);
    }

    public CLObject W(String str) {
        CLElement Y = Y(str);
        if (Y instanceof CLObject) {
            return (CLObject) Y;
        }
        return null;
    }

    public CLElement X(int i2) {
        if (i2 < 0 || i2 >= this.a3.size()) {
            return null;
        }
        return this.a3.get(i2);
    }

    public CLElement Y(String str) {
        Iterator<CLElement> it2 = this.a3.iterator();
        while (it2.hasNext()) {
            CLKey cLKey = (CLKey) it2.next();
            if (cLKey.c().equals(str)) {
                return cLKey.m0();
            }
        }
        return null;
    }

    public String Z(int i2) throws CLParsingException {
        CLElement I = I(i2);
        if (I instanceof CLString) {
            return I.c();
        }
        throw new CLParsingException("no string at index " + i2, this);
    }

    public String a0(String str) throws CLParsingException {
        CLElement K = K(str);
        if (K instanceof CLString) {
            return K.c();
        }
        String o = K != null ? K.o() : null;
        throw new CLParsingException("no string found for key <" + str + ">, found [" + o + "] : " + K, this);
    }

    public String b0(int i2) {
        CLElement X = X(i2);
        if (X instanceof CLString) {
            return X.c();
        }
        return null;
    }

    public String d0(String str) {
        CLElement Y = Y(str);
        if (Y instanceof CLString) {
            return Y.c();
        }
        return null;
    }

    public boolean e0(String str) {
        Iterator<CLElement> it2 = this.a3.iterator();
        while (it2.hasNext()) {
            CLElement next = it2.next();
            if ((next instanceof CLKey) && ((CLKey) next).c().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> f0() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<CLElement> it2 = this.a3.iterator();
        while (it2.hasNext()) {
            CLElement next = it2.next();
            if (next instanceof CLKey) {
                arrayList.add(((CLKey) next).c());
            }
        }
        return arrayList;
    }

    public void g0(String str, CLElement cLElement) {
        Iterator<CLElement> it2 = this.a3.iterator();
        while (it2.hasNext()) {
            CLKey cLKey = (CLKey) it2.next();
            if (cLKey.c().equals(str)) {
                cLKey.n0(cLElement);
                return;
            }
        }
        this.a3.add((CLKey) CLKey.k0(str, cLElement));
    }

    public float getFloat(int i2) throws CLParsingException {
        CLElement I = I(i2);
        if (I != null) {
            return I.j();
        }
        throw new CLParsingException("no float at index " + i2, this);
    }

    public int getInt(int i2) throws CLParsingException {
        CLElement I = I(i2);
        if (I != null) {
            return I.k();
        }
        throw new CLParsingException("no int at index " + i2, this);
    }

    public void i0(String str, float f2) {
        g0(str, new CLNumber(f2));
    }

    public void j0(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<CLElement> it2 = this.a3.iterator();
        while (it2.hasNext()) {
            CLElement next = it2.next();
            if (((CLKey) next).c().equals(str)) {
                arrayList.add(next);
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            this.a3.remove((CLElement) it3.next());
        }
    }

    public int size() {
        return this.a3.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<CLElement> it2 = this.a3.iterator();
        while (it2.hasNext()) {
            CLElement next = it2.next();
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(next);
        }
        return super.toString() + " = <" + sb + " >";
    }

    public boolean v(int i2) throws CLParsingException {
        CLElement I = I(i2);
        if (I instanceof CLToken) {
            return ((CLToken) I).H();
        }
        throw new CLParsingException("no boolean at index " + i2, this);
    }
}
