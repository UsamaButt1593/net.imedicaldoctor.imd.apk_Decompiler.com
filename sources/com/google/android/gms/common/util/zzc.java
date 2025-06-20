package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzc {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f20406a = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = f20406a.matcher(str);
        StringBuilder sb = null;
        int i2 = 0;
        while (matcher.find()) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            int start = matcher.start();
            int i3 = start;
            while (i3 >= 0 && str.charAt(i3) == '\\') {
                i3--;
            }
            if ((start - i3) % 2 != 0) {
                int parseInt = Integer.parseInt(matcher.group().substring(2), 16);
                sb.append(str, i2, matcher.start());
                if (parseInt == 92) {
                    sb.append("\\\\");
                } else {
                    sb.append(Character.toChars(parseInt));
                }
                i2 = matcher.end();
            }
        }
        if (sb == null) {
            return str;
        }
        if (i2 < matcher.regionEnd()) {
            sb.append(str, i2, matcher.regionEnd());
        }
        return sb.toString();
    }
}
