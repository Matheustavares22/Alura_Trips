package alura.com.br.aluratrips.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import alura.com.br.aluratrips.R;

public class ResourceUtil {
    public static Drawable giveBackDrawable(String drawableInText, Context context) {
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(drawableInText, context.getResources().getString(R.string.drawable_resource), context.getPackageName());
        return resources.getDrawable(drawableId);
    }

}
