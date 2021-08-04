package alura.com.br.aluratrips.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import alura.com.br.aluratrips.R;
import alura.com.br.aluratrips.model.Package;
import alura.com.br.aluratrips.util.MoneyUtil;

import static alura.com.br.aluratrips.ui.activity.PackageActivityConstant.KEY_PACKAGE;

public class PackagePaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_payment);
        setTitle(getString(R.string.payment));
        Intent intent = getIntent();
        loadPackageReceived(intent);
    }

    private void loadPackageReceived(Intent intent) {
        if (intent.hasExtra(KEY_PACKAGE)) {
            final Package targetPackage = (Package) intent.getSerializableExtra(KEY_PACKAGE);
            loadTextView(MoneyUtil.formatMoneyBrazil(targetPackage.getPrice(), this));
            configureButtonPay(targetPackage);
        }
    }

    private void configureButtonPay(Package targetPackage) {
        Button buttonPay = findViewById(R.id.package_payment_card_pay);
        buttonPay.setOnClickListener(v -> {
            Intent intent = new Intent(PackagePaymentActivity.this, PurchaseCompletedActivity.class);
            intent.putExtra(KEY_PACKAGE, targetPackage);
            startActivity(intent);
        });
    }

    private void loadTextView(String dataOfPackage) {
        TextView textView = findViewById(R.id.package_payment_price);
        textView.setText(dataOfPackage);
    }
}