package alura.com.br.aluratrips.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import alura.com.br.aluratrips.R;
import alura.com.br.aluratrips.model.Package;
import alura.com.br.aluratrips.util.DateUtil;
import alura.com.br.aluratrips.util.MoneyUtil;
import alura.com.br.aluratrips.util.ResourceUtil;

import static alura.com.br.aluratrips.ui.activity.PackageActivityConstant.KEY_PACKAGE;

public class PurchaseCompletedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_completed);
        setTitle(getString(R.string.action_bar_purchase_completed));
        loadPackageReceived();
    }

    private void loadPackageReceived() {
        Intent intent = getIntent();
        if (intent.hasExtra(KEY_PACKAGE)) {
            Package packageSaoPaulo = (Package) intent.getSerializableExtra(KEY_PACKAGE);
            startFields(packageSaoPaulo);
        }
    }

    private void startFields(Package packageSaoPaulo) {
        loadImage(packageSaoPaulo);
        loadTextView(R.id.purchase_completed_city, packageSaoPaulo.getCity());
        loadTextView(R.id.purchase_completed_date, DateUtil.formatDate(this));
        loadTextView(R.id.purchase_completed_price, MoneyUtil.formatMoneyBrazil(packageSaoPaulo.getPrice(), this));
    }

    private void loadImage(Package targetPackage) {
        ImageView image = findViewById(R.id.purchase_completed_city_image);
        image.setImageDrawable(ResourceUtil.giveBackDrawable(targetPackage.getImage(), this));
    }

    private void loadTextView(int targetTextView, String dataOfPackage) {
        TextView textView = findViewById(targetTextView);
        textView.setText(dataOfPackage);
    }
}