package com.itextpdf.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TabSettings {

    /* renamed from: c  reason: collision with root package name */
    public static final float f25722c = 36.0f;

    /* renamed from: a  reason: collision with root package name */
    private List<TabStop> f25723a;

    /* renamed from: b  reason: collision with root package name */
    private float f25724b;

    public TabSettings() {
        this.f25723a = new ArrayList();
        this.f25724b = 36.0f;
    }

    public static TabStop c(float f2, TabSettings tabSettings) {
        return tabSettings != null ? tabSettings.b(f2) : TabStop.f(f2, 36.0f);
    }

    public float a() {
        return this.f25724b;
    }

    public TabStop b(float f2) {
        TabStop tabStop;
        List<TabStop> list = this.f25723a;
        if (list != null) {
            Iterator<TabStop> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                TabStop next = it2.next();
                if (((double) (next.d() - f2)) > 0.001d) {
                    tabStop = new TabStop(next);
                    break;
                }
            }
        }
        tabStop = null;
        return tabStop == null ? TabStop.f(f2, this.f25724b) : tabStop;
    }

    public List<TabStop> d() {
        return this.f25723a;
    }

    public void e(float f2) {
        this.f25724b = f2;
    }

    public void f(List<TabStop> list) {
        this.f25723a = list;
    }

    public TabSettings(float f2) {
        this.f25723a = new ArrayList();
        this.f25724b = f2;
    }

    public TabSettings(List<TabStop> list) {
        new ArrayList();
        this.f25724b = 36.0f;
        this.f25723a = list;
    }

    public TabSettings(List<TabStop> list, float f2) {
        new ArrayList();
        this.f25723a = list;
        this.f25724b = f2;
    }
}
