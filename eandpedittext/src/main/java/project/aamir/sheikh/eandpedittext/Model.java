package project.aamir.sheikh.eandpedittext;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Aamir on 11-02-2017.
 */

public class Model {
    static int TextColor=-1;
    static Context context;
    static AttributeSet attrs;
    static String errorMsg="Invalid Email";
    static int eyeOnIcon=-1;
    static int eyeOffIcon=-1;

    public static int getEyeOnIcon() {
        return eyeOnIcon;
    }

    public static void setEyeOnIcon(int eyeOnIcon) {
        Model.eyeOnIcon = eyeOnIcon;
    }

    public static int getEyeOffIcon() {
        return eyeOffIcon;
    }

    public static void setEyeOffIcon(int eyeOffIcon) {
        Model.eyeOffIcon = eyeOffIcon;
    }

    public static String getErrorMsg() {
        return errorMsg;
    }

    public static void setErrorMsg(String errorMsg) {
        Model.errorMsg = errorMsg;
    }

    public static AttributeSet getAttrs() {
        return attrs;
    }

    public static void setAttrs(AttributeSet attrs) {
        Model.attrs = attrs;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        Model.context = context;
    }

    public static int getTextColor() {
        return TextColor;
    }

    public static void setTextColor(int color) {
        Model.TextColor = color;
    }
}
