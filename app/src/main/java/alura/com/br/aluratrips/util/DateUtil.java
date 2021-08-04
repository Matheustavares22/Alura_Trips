package alura.com.br.aluratrips.util;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import alura.com.br.aluratrips.R;

public class DateUtil {

    public static String formatDate(Context context) {
        Calendar dateOfDeparture = Calendar.getInstance();
        Calendar backDate = Calendar.getInstance();
        backDate.add(Calendar.DATE, 2);
        SimpleDateFormat dateFormatBrazilian = new SimpleDateFormat(getString(context ,R.string.date_format));
        String formattedDepartureDate = dateFormatBrazilian.format(dateOfDeparture.getTime());
        String formattedBackDate = dateFormatBrazilian.format(backDate.getTime());
        return formattedDepartureDate + " - " + formattedBackDate + getString(context, R.string.of_with_space) + backDate.get(Calendar.YEAR);
    }

    public static String formatToText(int numberOfDays, Context context) {
        if (numberOfDays > 1) {
            return numberOfDays + " " + getString(context, R.string.days);
        }
        return numberOfDays + " " + getString(context, R.string.day);
    }

    private static String getString(Context context, int data) {
        return context.getResources().getString(data);
    }
}
