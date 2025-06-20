package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;

public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");
    
    public final String s;

    private FileExtension(String str) {
        this.s = str;
    }

    public static FileExtension a(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.s)) {
                return fileExtension;
            }
        }
        Logger.e("Unable to find correct extension for " + str);
        return JSON;
    }

    public String b() {
        return ".temp" + this.s;
    }

    public String toString() {
        return this.s;
    }
}
