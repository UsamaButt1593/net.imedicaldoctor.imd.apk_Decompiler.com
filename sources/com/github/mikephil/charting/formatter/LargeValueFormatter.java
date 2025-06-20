package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

public class LargeValueFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    private String[] f19009a;

    /* renamed from: b  reason: collision with root package name */
    private int f19010b;

    /* renamed from: c  reason: collision with root package name */
    private DecimalFormat f19011c;

    /* renamed from: d  reason: collision with root package name */
    private String f19012d;

    public LargeValueFormatter() {
        this.f19009a = new String[]{"", "k", "m", "b", "t"};
        this.f19010b = 5;
        this.f19012d = "";
        this.f19011c = new DecimalFormat("###E00");
    }

    private String m(double d2) {
        String format = this.f19011c.format(d2);
        int numericValue = Character.getNumericValue(format.charAt(format.length() - 1));
        String replaceAll = format.replaceAll("E[0-9][0-9]", this.f19009a[Integer.valueOf(Character.getNumericValue(format.charAt(format.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            if (replaceAll.length() <= this.f19010b && !replaceAll.matches("[0-9]+\\.[a-z]")) {
                return replaceAll;
            }
            replaceAll = replaceAll.substring(0, replaceAll.length() - 2) + replaceAll.substring(replaceAll.length() - 1);
        }
    }

    public String h(float f2) {
        return m((double) f2) + this.f19012d;
    }

    public int l() {
        return 0;
    }

    public void n(String str) {
        this.f19012d = str;
    }

    public void o(int i2) {
        this.f19010b = i2;
    }

    public void p(String[] strArr) {
        this.f19009a = strArr;
    }

    public LargeValueFormatter(String str) {
        this();
        this.f19012d = str;
    }
}
