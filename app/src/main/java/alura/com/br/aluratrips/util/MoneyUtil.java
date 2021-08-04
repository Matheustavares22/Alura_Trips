package alura.com.br.aluratrips.util;

import android.content.Context;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import alura.com.br.aluratrips.R;

public class MoneyUtil {

    public static String formatMoneyBrazil(BigDecimal valor, Context context) {
        NumberFormat brazilianMoneyFormat = DecimalFormat.getCurrencyInstance(new Locale(context.getResources().getString(R.string.language_pt), context.getResources().getString(R.string.country_br)));
        return brazilianMoneyFormat.format(valor);
    }
}
