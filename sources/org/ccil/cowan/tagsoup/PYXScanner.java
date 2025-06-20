package org.ccil.cowan.tagsoup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import org.xml.sax.SAXException;

public class PYXScanner implements Scanner {
    public static void c(String[] strArr) throws IOException, SAXException {
        new PYXScanner().a(new InputStreamReader(System.in, "UTF-8"), new PYXWriter(new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"))));
    }

    public void a(Reader reader, ScanHandler scanHandler) throws IOException, SAXException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        char[] cArr = null;
        boolean z = false;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                int length = readLine.length();
                if (cArr == null || cArr.length < length) {
                    cArr = new char[length];
                }
                readLine.getChars(0, length, cArr, 0);
                char c2 = cArr[0];
                if (c2 == '(') {
                    if (z) {
                        scanHandler.l(cArr, 0, 0);
                    }
                    scanHandler.p(cArr, 1, length - 1);
                    z = true;
                } else if (c2 == ')') {
                    if (z) {
                        scanHandler.l(cArr, 0, 0);
                        z = false;
                    }
                    scanHandler.i(cArr, 1, length - 1);
                } else if (c2 == '-') {
                    if (z) {
                        scanHandler.l(cArr, 0, 0);
                        z = false;
                    }
                    if (readLine.equals("-\\n")) {
                        cArr[0] = 10;
                        scanHandler.a(cArr, 0, 1);
                    } else {
                        scanHandler.a(cArr, 1, length - 1);
                    }
                } else if (c2 == '?') {
                    if (z) {
                        scanHandler.l(cArr, 0, 0);
                        z = false;
                    }
                    scanHandler.h(cArr, 1, length - 1);
                } else if (c2 == 'A') {
                    int indexOf = readLine.indexOf(32);
                    scanHandler.k(cArr, 1, indexOf - 1);
                    scanHandler.o(cArr, indexOf + 1, (length - indexOf) - 1);
                } else if (c2 == 'E') {
                    if (z) {
                        scanHandler.l(cArr, 0, 0);
                        z = false;
                    }
                    scanHandler.e(cArr, 1, length - 1);
                }
            } else {
                scanHandler.g(cArr, 0, 0);
                return;
            }
        }
    }

    public void b(String str, String str2) {
    }

    public void startCDATA() {
    }
}
