package com.itextpdf.text.html.simpleparser;

import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class HTMLTagProcessors extends HashMap<String, HTMLTagProcessor> {
    public static final HTMLTagProcessor X = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.Y(str, map);
            hTMLWorker.r();
        }

        public void b(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.H();
            hTMLWorker.X(str);
        }
    };
    public static final HTMLTagProcessor X2 = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.h();
            hTMLWorker.N(hTMLWorker.n(map));
        }

        public void b(HTMLWorker hTMLWorker, String str) {
        }
    };
    public static final HTMLTagProcessor Y = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.A();
        }

        public void b(HTMLWorker hTMLWorker, String str) {
        }
    };
    public static final HTMLTagProcessor Y2 = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.Y(str, map);
        }

        public void b(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.X(str);
        }
    };
    public static final HTMLTagProcessor Z = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.h();
            if (hTMLWorker.w()) {
                hTMLWorker.d("li");
            }
            hTMLWorker.U(true);
            hTMLWorker.Y(str, map);
            hTMLWorker.N(hTMLWorker.o(str));
        }

        public void b(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.h();
            if (hTMLWorker.w()) {
                hTMLWorker.d("li");
            }
            hTMLWorker.U(false);
            hTMLWorker.X(str);
            hTMLWorker.I();
        }
    };
    public static final HTMLTagProcessor Z2 = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.h();
            if (!map.containsKey("size")) {
                map.put("size", Integer.toString(7 - Integer.parseInt(str.substring(1))));
            }
            hTMLWorker.Y(str, map);
        }

        public void b(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.h();
            hTMLWorker.X(str);
        }
    };
    public static final HTMLTagProcessor a3 = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.h();
            if (hTMLWorker.w()) {
                hTMLWorker.d(str);
            }
            hTMLWorker.U(false);
            hTMLWorker.Q(true);
            hTMLWorker.Y(str, map);
            hTMLWorker.N(hTMLWorker.p());
        }

        public void b(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.h();
            hTMLWorker.Q(false);
            hTMLWorker.U(true);
            hTMLWorker.X(str);
            hTMLWorker.J();
        }
    };
    public static final HTMLTagProcessor b3 = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.h();
            if (!map.containsKey("face")) {
                map.put("face", "Courier");
            }
            hTMLWorker.Y(str, map);
            hTMLWorker.O(true);
        }

        public void b(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.h();
            hTMLWorker.X(str);
            hTMLWorker.O(false);
        }
    };
    public static final HTMLTagProcessor c3 = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.h();
            hTMLWorker.Y(str, map);
        }

        public void b(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.h();
            hTMLWorker.X(str);
        }
    };
    public static final HTMLTagProcessor d3 = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.h();
            hTMLWorker.N(new TableWrapper(map));
            hTMLWorker.M();
            hTMLWorker.R(false);
            hTMLWorker.S(false);
            hTMLWorker.U(true);
            map.remove("align");
            map.put("colspan", IcyHeaders.a3);
            map.put("rowspan", IcyHeaders.a3);
            hTMLWorker.Y(str, map);
        }

        public void b(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.h();
            if (hTMLWorker.y()) {
                hTMLWorker.d("tr");
            }
            hTMLWorker.X(str);
            hTMLWorker.L();
            hTMLWorker.F();
            hTMLWorker.U(false);
        }
    };
    public static final HTMLTagProcessor e3 = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.h();
            if (hTMLWorker.y()) {
                hTMLWorker.d(str);
            }
            hTMLWorker.U(true);
            hTMLWorker.S(true);
            hTMLWorker.Y(str, map);
        }

        public void b(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.h();
            if (hTMLWorker.x()) {
                hTMLWorker.d("td");
            }
            hTMLWorker.S(false);
            hTMLWorker.X(str);
            hTMLWorker.K();
            hTMLWorker.U(true);
        }
    };
    public static final HTMLTagProcessor f3 = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.h();
            if (hTMLWorker.x()) {
                hTMLWorker.d(str);
            }
            hTMLWorker.U(false);
            hTMLWorker.R(true);
            hTMLWorker.Y("td", map);
            hTMLWorker.N(hTMLWorker.i(str));
        }

        public void b(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.h();
            hTMLWorker.R(false);
            hTMLWorker.X("td");
            hTMLWorker.U(true);
        }
    };
    public static final HTMLTagProcessor g3 = new HTMLTagProcessor() {
        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException, IOException {
            hTMLWorker.Y(str, map);
            hTMLWorker.G(hTMLWorker.m(map), map);
            hTMLWorker.X(str);
        }

        public void b(HTMLWorker hTMLWorker, String str) {
        }
    };
    private static final long h3 = -959260811961222824L;
    public static final HTMLTagProcessor s = new HTMLTagProcessor() {
        private String c(String str) {
            if ("em".equalsIgnoreCase(str)) {
                return "i";
            }
            if ("strong".equalsIgnoreCase(str)) {
                return "b";
            }
            return "strike".equalsIgnoreCase(str) ? "s" : str;
        }

        public void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            String c2 = c(str);
            map.put(c2, (Object) null);
            hTMLWorker.Y(c2, map);
        }

        public void b(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.X(c(str));
        }
    };

    public HTMLTagProcessors() {
        put("a", X);
        HTMLTagProcessor hTMLTagProcessor = s;
        put("b", hTMLTagProcessor);
        HTMLTagProcessor hTMLTagProcessor2 = c3;
        put("body", hTMLTagProcessor2);
        put("br", Y);
        put("div", hTMLTagProcessor2);
        put("em", hTMLTagProcessor);
        HTMLTagProcessor hTMLTagProcessor3 = Y2;
        put("font", hTMLTagProcessor3);
        HTMLTagProcessor hTMLTagProcessor4 = Z2;
        put("h1", hTMLTagProcessor4);
        put("h2", hTMLTagProcessor4);
        put("h3", hTMLTagProcessor4);
        put("h4", hTMLTagProcessor4);
        put("h5", hTMLTagProcessor4);
        put("h6", hTMLTagProcessor4);
        put("hr", X2);
        put("i", hTMLTagProcessor);
        put("img", g3);
        put("li", a3);
        HTMLTagProcessor hTMLTagProcessor5 = Z;
        put("ol", hTMLTagProcessor5);
        put("p", hTMLTagProcessor2);
        put("pre", b3);
        put("s", hTMLTagProcessor);
        put("span", hTMLTagProcessor3);
        put("strike", hTMLTagProcessor);
        put("strong", hTMLTagProcessor);
        put("sub", hTMLTagProcessor);
        put("sup", hTMLTagProcessor);
        put("table", d3);
        HTMLTagProcessor hTMLTagProcessor6 = f3;
        put("td", hTMLTagProcessor6);
        put("th", hTMLTagProcessor6);
        put("tr", e3);
        put("u", hTMLTagProcessor);
        put("ul", hTMLTagProcessor5);
    }
}
