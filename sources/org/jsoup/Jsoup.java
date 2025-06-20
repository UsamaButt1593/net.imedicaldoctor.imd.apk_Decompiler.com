package org.jsoup;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

public class Jsoup {
    private Jsoup() {
    }

    public static String a(String str, String str2, Whitelist whitelist) {
        return new Cleaner(whitelist).c(o(str, str2)).m3().q2();
    }

    public static String b(String str, String str2, Whitelist whitelist, Document.OutputSettings outputSettings) {
        Document c2 = new Cleaner(whitelist).c(o(str, str2));
        c2.A3(outputSettings);
        return c2.m3().q2();
    }

    public static String c(String str, Whitelist whitelist) {
        return a(str, "", whitelist);
    }

    public static Connection d(String str) {
        return HttpConnection.I(str);
    }

    public static boolean e(String str, Whitelist whitelist) {
        return new Cleaner(whitelist).g(str);
    }

    public static Document f(File file, String str) throws IOException {
        return DataUtil.e(file, str, file.getAbsolutePath());
    }

    public static Document g(File file, String str, String str2) throws IOException {
        return DataUtil.e(file, str, str2);
    }

    public static Document h(InputStream inputStream, String str, String str2) throws IOException {
        return DataUtil.f(inputStream, str, str2);
    }

    public static Document i(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        return DataUtil.g(inputStream, str, str2, parser);
    }

    public static Document j(String str) {
        return Parser.e(str, "");
    }

    public static Document k(String str, String str2) {
        return Parser.e(str, str2);
    }

    public static Document l(String str, String str2, Parser parser) {
        return parser.j(str, str2);
    }

    public static Document m(URL url, int i2) throws IOException {
        Connection J = HttpConnection.J(url);
        J.g(i2);
        return J.get();
    }

    public static Document n(String str) {
        return Parser.f(str, "");
    }

    public static Document o(String str, String str2) {
        return Parser.f(str, str2);
    }
}
