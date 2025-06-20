package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.itextpdf.tool.xml.css.CSS;
import java.io.IOException;

class MergePathsParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f17312a = JsonReader.Options.a("nm", CSS.Value.k0, "hd");

    private MergePathsParser() {
    }

    static MergePaths a(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17312a);
            if (u == 0) {
                str = jsonReader.q();
            } else if (u == 1) {
                mergePathsMode = MergePaths.MergePathsMode.a(jsonReader.n());
            } else if (u != 2) {
                jsonReader.v();
                jsonReader.w();
            } else {
                z = jsonReader.i();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
