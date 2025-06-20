package com.itextpdf.text.pdf.parser;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStream;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PdfContentReaderTool {
    public static String a(PdfDictionary pdfDictionary) {
        return b(pdfDictionary, 0);
    }

    public static String b(PdfDictionary pdfDictionary, int i2) {
        int i3;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ASCIIPropertyListParser.f18649g);
        ArrayList<PdfName> arrayList = new ArrayList<>();
        for (PdfName next : pdfDictionary.G0()) {
            PdfObject B0 = pdfDictionary.B0(next);
            if (B0.z()) {
                arrayList.add(next);
            }
            stringBuffer.append(next);
            stringBuffer.append(ASCIIPropertyListParser.f18654l);
            stringBuffer.append(B0);
            stringBuffer.append(", ");
        }
        if (stringBuffer.length() >= 2) {
            stringBuffer.setLength(stringBuffer.length() - 2);
        }
        stringBuffer.append(ASCIIPropertyListParser.f18650h);
        for (PdfName pdfName : arrayList) {
            stringBuffer.append(10);
            int i4 = 0;
            while (true) {
                i3 = i2 + 1;
                if (i4 >= i3) {
                    break;
                }
                stringBuffer.append(9);
                i4++;
            }
            stringBuffer.append("Subdictionary ");
            stringBuffer.append(pdfName);
            stringBuffer.append(" = ");
            stringBuffer.append(b(pdfDictionary.j0(pdfName), i3));
        }
        return stringBuffer.toString();
    }

    public static String c(PdfDictionary pdfDictionary) throws IOException {
        StringBuilder sb = new StringBuilder();
        PdfDictionary j0 = pdfDictionary.j0(PdfName.ai);
        if (j0 == null) {
            return "No XObjects";
        }
        for (PdfName next : j0.G0()) {
            PdfStream x0 = j0.x0(next);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("------ ");
            sb2.append(next);
            sb2.append(" - subtype = ");
            PdfName pdfName = PdfName.Cf;
            sb2.append(x0.d0(pdfName));
            sb2.append(" = ");
            sb2.append(x0.q0(PdfName.va));
            sb2.append(" bytes ------\n");
            sb.append(sb2.toString());
            if (!x0.d0(pdfName).equals(PdfName.F9)) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ContentByteUtils.b(x0));
                while (true) {
                    int read = byteArrayInputStream.read();
                    if (read == -1) {
                        break;
                    }
                    sb.append((char) read);
                }
                sb.append("------ " + next + " - subtype = " + x0.d0(PdfName.Cf) + "End of Content" + "------\n");
            }
        }
        return sb.toString();
    }

    public static void d(File file, int i2, PrintWriter printWriter) throws IOException {
        f(new PdfReader(file.getCanonicalPath()), i2, printWriter);
    }

    public static void e(File file, PrintWriter printWriter) throws IOException {
        PdfReader pdfReader = new PdfReader(file.getCanonicalPath());
        int c0 = pdfReader.c0();
        for (int i2 = 1; i2 <= c0; i2++) {
            f(pdfReader, i2, printWriter);
        }
    }

    public static void f(PdfReader pdfReader, int i2, PrintWriter printWriter) throws IOException {
        printWriter.println("==============Page " + i2 + "====================");
        printWriter.println("- - - - - Dictionary - - - - - -");
        PdfDictionary h0 = pdfReader.h0(i2);
        printWriter.println(a(h0));
        printWriter.println("- - - - - XObject Summary - - - - - -");
        printWriter.println(c(h0.j0(PdfName.Wd)));
        printWriter.println("- - - - - Content Stream - - - - - -");
        RandomAccessFileOrArray B0 = pdfReader.B0();
        byte[] f0 = pdfReader.f0(i2, B0);
        B0.close();
        printWriter.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(f0);
        while (true) {
            int read = byteArrayInputStream.read();
            if (read == -1) {
                break;
            }
            printWriter.print((char) read);
        }
        printWriter.flush();
        printWriter.println("- - - - - Text Extraction - - - - - -");
        String b2 = PdfTextExtractor.b(pdfReader, i2, new LocationTextExtractionStrategy());
        if (b2.length() == 0) {
            b2 = "No text found on page " + i2;
        }
        printWriter.println(b2);
        printWriter.println();
    }

    public static void g(String[] strArr) {
        try {
            if (strArr.length >= 1) {
                if (strArr.length <= 3) {
                    PrintStream printStream = System.out;
                    PrintWriter printWriter = new PrintWriter(printStream);
                    if (strArr.length >= 2 && strArr[1].compareToIgnoreCase("stdout") != 0) {
                        printStream.println("Writing PDF content to " + strArr[1]);
                        printWriter = new PrintWriter(new FileOutputStream(new File(strArr[1])));
                    }
                    int parseInt = strArr.length >= 3 ? Integer.parseInt(strArr[2]) : -1;
                    if (parseInt == -1) {
                        e(new File(strArr[0]), printWriter);
                    } else {
                        d(new File(strArr[0]), parseInt, printWriter);
                    }
                    printWriter.flush();
                    if (strArr.length >= 2) {
                        printWriter.close();
                        printStream.println("Finished writing content to " + strArr[1]);
                        return;
                    }
                    return;
                }
            }
            System.out.println("Usage:  PdfContentReaderTool <pdf file> [<output file>|stdout] [<page num>]");
        } catch (Exception e2) {
            e2.printStackTrace(System.err);
        }
    }
}
