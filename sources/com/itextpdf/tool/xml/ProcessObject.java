package com.itextpdf.tool.xml;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProcessObject {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<Writable> f27445a = new LinkedList();

    public void a(Writable writable) {
        this.f27445a.add(writable);
    }

    public void b(List<Writable> list) {
        this.f27445a.addAll(list);
    }

    public boolean c() {
        return !this.f27445a.isEmpty();
    }

    public Writable d() {
        return this.f27445a.poll();
    }
}
