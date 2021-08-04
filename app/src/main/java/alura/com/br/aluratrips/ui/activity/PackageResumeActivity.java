package alura.com.br.aluratrips.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import alura.com.br.aluratrips.R;
import alura.com.br.aluratrips.model.Package;
import alura.com.br.aluratrips.util.DateUtil;
import alura.com.br.aluratrips.util.MoneyUtil;
import alura.com.br.aluratrips.util.ResourceUtil;

import static alura.com.br.aluratrips.ui.activity.PackageActivityConstant.KEY_PACKAGE;


public class PackageResumeActivity extends AppCompatActivity {

    public PackageResumeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_resume);
        setTitle(getString(R.string.action_bar_package_resume));
        loadPackageReceived();
    }

    private void loadPackageReceived() {
        Intent intent = getIntent();
        if (intent.hasExtra(KEY_PACKAGE)) {
            final Package targetPackage = (Package) intent.getSerializableExtra(KEY_PACKAGE);
            startFields(targetPackage);
            configureButton(targetPackage);
        }
    }

    private void startFields(Package targetPackage) {
        loadImageView(targetPackage);
        loadTextView(R.id.package_resume_city_name, targetPackage.getCity());
        loadTextView(R.id.package_resume_days, DateUtil.formatToText(targetPackage.getDays(), this));
        loadTextView(R.id.package_resume_payment_price, MoneyUtil.formatMoneyBrazil(targetPackage.getPrice(), this));
        loadTextView(R.id.package_resume_date, DateUtil.formatDate(this));
    }

    private void loadImageView(Package dataOfPackage) {
        ImageView cityImage = findViewById(R.id.package_resume_city_image);
        cityImage.setImageDrawable(ResourceUtil.giveBackDrawable(dataOfPackage.getImage(), this));
    }

    private void loadTextView(int targetTextView, String dataOfPackage) {
        TextView textView = findViewById(targetTextView);
        textView.setText(dataOfPackage);
    }

    private void configureButton(Package targetPackage) {
        Button buttonMakePayment = findViewById(R.id.package_resume_make_payment);
        buttonMakePayment.setOnClickListener(v -> {
            Intent intent = new Intent(PackageResumeActivity.this, PackagePaymentActivity.class);
            intent.putExtra(KEY_PACKAGE, targetPackage);
            startActivity(intent);
        });
    }
}