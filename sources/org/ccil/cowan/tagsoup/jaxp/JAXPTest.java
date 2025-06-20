package org.ccil.cowan.tagsoup.jaxp;

import java.io.File;
import java.io.PrintStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.xml.sax.helpers.DefaultHandler;

public class JAXPTest {
    public static void a(String[] strArr) throws Exception {
        new JAXPTest().b(strArr);
    }

    private void b(String[] strArr) throws Exception {
        if (strArr.length != 1) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Usage: java ");
            stringBuffer.append(getClass());
            stringBuffer.append(" [input-file]");
            printStream.println(stringBuffer.toString());
            System.exit(1);
        }
        File file = new File(strArr[0]);
        System.setProperty("javax.xml.parsers.SAXParserFactory", "org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl");
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        PrintStream printStream2 = System.out;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Ok, SAX factory JAXP creates is: ");
        stringBuffer2.append(newInstance);
        printStream2.println(stringBuffer2.toString());
        printStream2.println("Let's parse...");
        newInstance.newSAXParser().parse(file, new DefaultHandler());
        printStream2.println("Done. And then DOM build:");
        Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Succesfully built DOM tree from '");
        stringBuffer3.append(file);
        stringBuffer3.append("', -> ");
        stringBuffer3.append(parse);
        printStream2.println(stringBuffer3.toString());
    }
}
