package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import java.util.Arrays;
import java.util.List;

public class RadarData extends ChartData<IRadarDataSet> {

    /* renamed from: j  reason: collision with root package name */
    private List<String> f18994j;

    public RadarData() {
    }

    public List<String> Q() {
        return this.f18994j;
    }

    public void R(List<String> list) {
        this.f18994j = list;
    }

    public void S(String... strArr) {
        this.f18994j = Arrays.asList(strArr);
    }

    public Entry s(Highlight highlight) {
        return ((IRadarDataSet) k(highlight.d())).X((int) highlight.h());
    }

    public RadarData(List<IRadarDataSet> list) {
        super(list);
    }

    public RadarData(IRadarDataSet... iRadarDataSetArr) {
        super((T[]) iRadarDataSetArr);
    }
}
