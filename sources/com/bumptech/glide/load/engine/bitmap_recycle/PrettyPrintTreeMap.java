package com.bumptech.glide.load.engine.bitmap_recycle;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.Map;
import java.util.TreeMap;

class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    PrettyPrintTreeMap() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for (Map.Entry entry : entrySet()) {
            sb.append(ASCIIPropertyListParser.f18652j);
            sb.append(entry.getKey());
            sb.append(ASCIIPropertyListParser.A);
            sb.append(entry.getValue());
            sb.append("}, ");
        }
        if (!isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(" )");
        return sb.toString();
    }
}
