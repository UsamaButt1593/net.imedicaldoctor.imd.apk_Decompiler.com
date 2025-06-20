package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.io.PrintStream;

public class KeyParser {

    private interface DataType {
        int get(int i2);
    }

    private interface Ids {
        int i(String str);
    }

    public static void a(String[] strArr) {
        c("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle b(String str, Ids ids, DataType dataType) {
        PrintStream printStream;
        String str2;
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject d2 = CLParser.d(str);
            int size = d2.size();
            for (int i2 = 0; i2 < size; i2++) {
                CLKey cLKey = (CLKey) d2.I(i2);
                String c2 = cLKey.c();
                CLElement m0 = cLKey.m0();
                int i3 = ids.i(c2);
                if (i3 == -1) {
                    System.err.println("unknown type " + c2);
                } else {
                    int i4 = dataType.get(i3);
                    if (i4 != 1) {
                        if (i4 == 2) {
                            typedBundle.b(i3, m0.k());
                            printStream = System.out;
                            str2 = "parse " + c2 + " INT_MASK > " + m0.k();
                        } else if (i4 == 4) {
                            typedBundle.a(i3, m0.j());
                            printStream = System.out;
                            str2 = "parse " + c2 + " FLOAT_MASK > " + m0.j();
                        } else if (i4 == 8) {
                            typedBundle.c(i3, m0.c());
                            printStream = System.out;
                            str2 = "parse " + c2 + " STRING_MASK > " + m0.c();
                        }
                        printStream.println(str2);
                    } else {
                        typedBundle.d(i3, d2.v(i2));
                    }
                }
            }
        } catch (CLParsingException e2) {
            e2.printStackTrace();
        }
        return typedBundle;
    }

    public static TypedBundle c(String str) {
        return b(str, new a(), new b());
    }
}
