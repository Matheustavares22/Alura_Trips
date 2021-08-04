package alura.com.br.aluratrips.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import alura.com.br.aluratrips.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        if (preferences.contains("already_opened_the_app")) {
            startsPackageListActivity();
        } else {
            Handler handler = new Handler();
            addPreferenceOpened(preferences);
            showSplashScreen(handler);
        }
    }

    private void startsPackageListActivity() {
        startActivity(new Intent(this, PackageListActivity.class));
        finish();
    }

    private void showSplashScreen(Handler handler) {
        handler.postDelayed(this::startsPackageListActivity, 2000);
    }

    private void addPreferenceOpened(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("already_opened_the_app", true);
        editor.apply();
    }

}