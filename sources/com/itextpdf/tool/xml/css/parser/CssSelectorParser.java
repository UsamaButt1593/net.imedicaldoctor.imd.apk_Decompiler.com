package com.itextpdf.tool.xml.css.parser;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CssSelectorItem;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class CssSelectorParser {

    /* renamed from: a  reason: collision with root package name */
    private static final String f27537a = "(\\*)|([_a-zA-Z][\\w-]*)|(\\.[_a-zA-Z][\\w-]*)|(#[_a-z][\\w-]*)|(\\[[_a-zA-Z][\\w-]*(([~^$*|])?=((\"[\\w-]+\")|([\\w-]+)))?\\])|(:[\\w()-]*)|( )|(\\+)|(>)|(~)";

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f27538b = Pattern.compile(f27537a);

    /* renamed from: c  reason: collision with root package name */
    private static final int f27539c = 65536;

    /* renamed from: d  reason: collision with root package name */
    private static final int f27540d = 256;

    /* renamed from: e  reason: collision with root package name */
    private static final int f27541e = 1;

    static class CssAttributeSelector implements CssSelectorItem {

        /* renamed from: a  reason: collision with root package name */
        private String f27542a;

        /* renamed from: b  reason: collision with root package name */
        private char f27543b = 0;

        /* renamed from: c  reason: collision with root package name */
        private String f27544c = null;

        CssAttributeSelector(String str) {
            int length;
            String substring;
            int indexOf = str.indexOf(61);
            if (indexOf == -1) {
                substring = str.substring(1, str.length() - 1);
            } else {
                int i2 = indexOf + 1;
                if (str.charAt(i2) == '\"') {
                    i2 = indexOf + 2;
                    length = str.length() - 2;
                } else {
                    length = str.length() - 1;
                }
                this.f27544c = str.substring(i2, length);
                int i3 = indexOf - 1;
                char charAt = str.charAt(i3);
                this.f27543b = charAt;
                if ("~^$*|".indexOf(charAt) == -1) {
                    this.f27543b = 0;
                    substring = str.substring(1, indexOf);
                } else {
                    substring = str.substring(1, i3);
                }
            }
            this.f27542a = substring;
        }

        public boolean a(Tag tag) {
            String str;
            if (tag == null || (str = tag.d().get(this.f27542a)) == null) {
                return false;
            }
            String str2 = this.f27544c;
            if (str2 == null) {
                return true;
            }
            char c2 = this.f27543b;
            if (c2 != 0) {
                if (c2 != '$') {
                    if (c2 != '*') {
                        if (c2 != '^') {
                            if (c2 == '|') {
                                if (Pattern.compile(String.format("^%s-?", new Object[]{str2})).matcher(str).find()) {
                                    return true;
                                }
                            } else if (c2 == '~') {
                                if (Pattern.compile(String.format("(^%s\\s+)|(\\s+%s\\s+)|(\\s+%s$)", new Object[]{str2, str2, str2})).matcher(str).find()) {
                                    return true;
                                }
                            }
                        } else if (str.startsWith(str2)) {
                            return true;
                        }
                    } else if (str.contains(str2)) {
                        return true;
                    }
                } else if (str.endsWith(str2)) {
                    return true;
                }
            } else if (str.equals(str2)) {
                return true;
            }
            return false;
        }

        public int b() {
            return 256;
        }

        public char c() {
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(this.f27542a);
            char c2 = this.f27543b;
            if (c2 != 0) {
                sb.append(c2);
            }
            if (this.f27544c != null) {
                sb.append(ASCIIPropertyListParser.f18654l);
                sb.append('\"');
                sb.append(this.f27544c);
                sb.append('\"');
            }
            sb.append(']');
            return sb.toString();
        }
    }

    static class CssClassSelector implements CssSelectorItem {

        /* renamed from: a  reason: collision with root package name */
        private String f27545a;

        CssClassSelector(String str) {
            this.f27545a = str;
        }

        public boolean a(Tag tag) {
            String str = tag.d().get("class");
            if (!(str == null || str.length() == 0)) {
                for (String trim : str.split(StringUtils.SPACE)) {
                    if (this.f27545a.equals(trim.trim())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int b() {
            return 256;
        }

        public char c() {
            return 0;
        }

        public String toString() {
            return "." + this.f27545a;
        }
    }

    static class CssIdSelector implements CssSelectorItem {

        /* renamed from: a  reason: collision with root package name */
        private String f27546a;

        CssIdSelector(String str) {
            this.f27546a = str;
        }

        public boolean a(Tag tag) {
            String str = tag.d().get("id");
            return str != null && this.f27546a.equals(str.trim());
        }

        public int b() {
            return 65536;
        }

        public char c() {
            return 0;
        }

        public String toString() {
            return "#" + this.f27546a;
        }
    }

    static class CssPseudoSelector implements CssSelectorItem {

        /* renamed from: a  reason: collision with root package name */
        private String f27547a;

        CssPseudoSelector(String str) {
            this.f27547a = str;
        }

        public boolean a(Tag tag) {
            return false;
        }

        public int b() {
            return 0;
        }

        public char c() {
            return 0;
        }

        public String toString() {
            return this.f27547a;
        }
    }

    static class CssSeparatorSelector implements CssSelectorItem {

        /* renamed from: a  reason: collision with root package name */
        private char f27548a;

        CssSeparatorSelector(char c2) {
            this.f27548a = c2;
        }

        public boolean a(Tag tag) {
            return false;
        }

        public int b() {
            return 0;
        }

        public char c() {
            return this.f27548a;
        }

        public String toString() {
            return String.valueOf(this.f27548a);
        }
    }

    static class CssTagSelector implements CssSelectorItem {

        /* renamed from: a  reason: collision with root package name */
        private String f27549a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f27550b;

        CssTagSelector(String str) {
            this.f27549a = str;
            this.f27550b = str.equals("*");
        }

        public boolean a(Tag tag) {
            return this.f27550b || this.f27549a.equals(tag.o());
        }

        public int b() {
            return this.f27550b ? 0 : 1;
        }

        public char c() {
            return 0;
        }

        public String toString() {
            return this.f27549a;
        }
    }

    public static List<CssSelectorItem> a(String str) {
        Object cssIdSelector;
        ArrayList arrayList = new ArrayList();
        Matcher matcher = f27538b.matcher(str);
        int i2 = 0;
        while (true) {
            boolean z = false;
            while (matcher.find()) {
                String group = matcher.group(0);
                i2 += group.length();
                char charAt = group.charAt(0);
                if (charAt != ' ') {
                    if (charAt == '#') {
                        cssIdSelector = new CssIdSelector(group.substring(1));
                    } else if (charAt != '+') {
                        if (charAt == '.') {
                            cssIdSelector = new CssClassSelector(group.substring(1));
                        } else if (charAt == ':') {
                            cssIdSelector = new CssPseudoSelector(group);
                        } else if (charAt != '>') {
                            if (charAt == '[') {
                                cssIdSelector = new CssAttributeSelector(group);
                            } else if (charAt != '~') {
                                if (z) {
                                    return null;
                                }
                                arrayList.add(new CssTagSelector(group));
                                z = true;
                            }
                        }
                    }
                    arrayList.add(cssIdSelector);
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                CssSelectorItem cssSelectorItem = (CssSelectorItem) arrayList.get(arrayList.size() - 1);
                CssSeparatorSelector cssSeparatorSelector = new CssSeparatorSelector(group.charAt(0));
                if (!(cssSelectorItem instanceof CssSeparatorSelector)) {
                    arrayList.add(cssSeparatorSelector);
                } else if (group.charAt(0) == ' ') {
                    continue;
                } else if (cssSelectorItem.c() != ' ') {
                    return null;
                } else {
                    arrayList.set(arrayList.size() - 1, cssSeparatorSelector);
                }
            }
            if (str.length() == 0 || str.length() != i2) {
                return null;
            }
            return arrayList;
        }
    }
}
