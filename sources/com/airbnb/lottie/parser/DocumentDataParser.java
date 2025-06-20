package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class DocumentDataParser implements ValueParser<DocumentData> {

    /* renamed from: a  reason: collision with root package name */
    public static final DocumentDataParser f17284a = new DocumentDataParser();

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f17285b = JsonReader.Options.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private DocumentDataParser() {
    }

    /* renamed from: b */
    public DocumentData a(JsonReader jsonReader, float f2) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.d();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f3 = 0.0f;
        int i2 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i3 = 0;
        int i4 = 0;
        float f6 = 0.0f;
        boolean z = true;
        while (jsonReader.h()) {
            switch (jsonReader.u(f17285b)) {
                case 0:
                    str = jsonReader.q();
                    break;
                case 1:
                    str2 = jsonReader.q();
                    break;
                case 2:
                    f3 = (float) jsonReader.k();
                    break;
                case 3:
                    int n2 = jsonReader.n();
                    justification2 = DocumentData.Justification.CENTER;
                    if (n2 <= justification2.ordinal() && n2 >= 0) {
                        justification2 = DocumentData.Justification.values()[n2];
                        break;
                    }
                case 4:
                    i2 = jsonReader.n();
                    break;
                case 5:
                    f4 = (float) jsonReader.k();
                    break;
                case 6:
                    f5 = (float) jsonReader.k();
                    break;
                case 7:
                    i3 = JsonUtils.d(jsonReader);
                    break;
                case 8:
                    i4 = JsonUtils.d(jsonReader);
                    break;
                case 9:
                    f6 = (float) jsonReader.k();
                    break;
                case 10:
                    z = jsonReader.i();
                    break;
                default:
                    jsonReader.v();
                    jsonReader.w();
                    break;
            }
        }
        JsonReader jsonReader2 = jsonReader;
        jsonReader.f();
        return new DocumentData(str, str2, f3, justification2, i2, f4, f5, i3, i4, f6, z);
    }
}
