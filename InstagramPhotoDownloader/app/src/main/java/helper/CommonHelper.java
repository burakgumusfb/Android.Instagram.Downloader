package helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;

import constants.constants;
import core.SharedResponseTemplate;

/**
 * Created by BURAK on 11/06/2017.
 */

public class CommonHelper {

    public static SharedResponseTemplate ConvertToJson(String data) {
        Gson gson = new Gson();
        return gson.fromJson(data, SharedResponseTemplate.class);
    }

    public static void ThreadPolicy() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public static boolean CreateVideoDirectory() {
        File rootFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + constants.VideoDirName);
        boolean success = false;
        if (!rootFile.exists()) {
            success = rootFile.mkdir();
        }
        return success;
    }
    public static boolean CreatePhotoDirectory() {
        File rootFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + constants.PhotoDirName);
        boolean success = false;
        if (!rootFile.exists()) {
            success = rootFile.mkdir();
        }
        return success;
    }
    public static String CreateFileNameForVideo(String fileName) {
        if (fileName == null || fileName == "")
            return null;

        String[] splitFileName = fileName.split("/");
        fileName = splitFileName[3] + splitFileName[4];
        return fileName;
    }
    public static String CreateFileNameForImage(String fileName) {
            if (fileName == null || fileName == "")
                return  null;

        String[] splitFileName = fileName.split("/");
        fileName = splitFileName[3] + splitFileName[4] + splitFileName[5];
        return fileName;
    }


    public static boolean checkNetworkStatus(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }


}