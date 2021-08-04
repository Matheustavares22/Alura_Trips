package alura.com.br.aluratrips.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Objects;

import alura.com.br.aluratrips.R;
import alura.com.br.aluratrips.dao.PackageDAO;
import alura.com.br.aluratrips.model.Package;
import alura.com.br.aluratrips.ui.adapter.PackageListAdapter;

import static alura.com.br.aluratrips.ui.activity.PackageActivityConstant.KEY_PACKAGE;

public class PackageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_list);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.action_bar_package_list_activity);
        configureListView();
    }

    private void configureListView() {
        ListView packageList = findViewById(R.id.list_package_listview);
        final List<Package> packages = new PackageDAO().list();
        packageList.setAdapter(new PackageListAdapter(packages, this));
        packageList.setOnItemClickListener((parent, view, position, id) -> {
            Package targetPackage = packages.get(position);
            openPackageResume(targetPackage);
        });
    }

    private void openPackageResume(Package targetPackage) {
        Intent intent = (new Intent(PackageListActivity.this, PackageResumeActivity.class));
        intent.putExtra(KEY_PACKAGE, targetPackage);
        startActivity(intent);
    }
}