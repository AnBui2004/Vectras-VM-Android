package com.vectras.vm;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.widget.ImageView.ScaleType;

import com.vectras.qemu.MainSettingsManager;
import com.vectras.vm.utils.FileUtils;

import java.io.File;
import java.util.Hashtable;
import java.util.Objects;

/**
 * @author dev
 */
public class AppConfig {

    // App Config
    public static final String vectrasVersion = "2.9.0";
    public static final String vectrasWebsite = "https://nguyenbaoanbui-f8a71.web.app/vectrasvm/";
    public static final String vectrasHelp = vectrasWebsite + "how.html";
    public static final String vectrasRaw = vectrasWebsite + "data/";
    public static final String vectrasLicense = vectrasRaw + "LICENSE.md";
    public static final String vectrasPrivacy = vectrasRaw + "PRIVACYANDPOLICY.md";
    public static final String vectrasTerms = vectrasRaw + "TERMSOFSERVICE.md";
    public static final String vectrasInfo = vectrasRaw + "info.md";
    public static final String vectrasRepo = "https://github.com/AnBui2004/Vectras-VM-Android";
    public static final String updateJson = vectrasRaw + "UpdateConfig.json";
    public static final String blogJson = vectrasRaw + "news_list.json";
    // public static final String storeJson = vectrasRaw + "store_list.json";
    public static final String storeJson = vectrasWebsite + "store_list.json";

    public static final String releaseUrl = vectrasWebsite;

    public static String getSetupFiles() {
        String abi = Build.SUPPORTED_ABIS[0];
        return releaseUrl + "vectras-vm-" + abi + ".tar.gz";
    }

    public static final String romsJson(Activity activity) {
        if (Objects.equals(MainSettingsManager.getArch(activity), "X86_64")) {
            return vectrasRaw + "roms-x86_64.json";
        } else if (Objects.equals(MainSettingsManager.getArch(activity), "I386")) {
            return vectrasRaw + "roms-i386.json";
        } else if (Objects.equals(MainSettingsManager.getArch(activity), "ARM64")) {
            return vectrasRaw + "roms-aarch64.json";
        } else if (Objects.equals(MainSettingsManager.getArch(activity), "PPC")) {
            return vectrasRaw + "roms-ppc.json";
        } else {
            return null;
        }
    }

    // App config
    public static final String datadirpath(Activity activity) {
        File f = new File(activity.getExternalFilesDir("data") + "/Vectras");
        return activity.getExternalFilesDir("data") + "/Vectras";
        //return FileUtils.getExternalFilesDirectory(activity).getPath();
    }
    public static final String basefiledir = datadirpath(SplashActivity.activity) + "/.qemu/";
    public static final String maindirpath = FileUtils.getExternalFilesDirectory(SplashActivity.activity).getPath() + "/";
    public static final String sharedFolder = maindirpath + "SharedFolder/";
    public static final String downloadsFolder = maindirpath + "Downloads/";
    public static final String romsdatajson = Environment.getExternalStorageDirectory().toString() + "/Documents/VectrasVM/roms-data.json";

}
