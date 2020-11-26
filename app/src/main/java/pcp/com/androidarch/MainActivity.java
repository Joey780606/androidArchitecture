package pcp.com.androidarch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import pcp.com.androidarch.databinding.ActivityMainBinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    //private Button btnRefresh;

    private MainViewModel viewModel = new MainViewModel(); // keynote: Attention how to use it.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setViewModel(viewModel);

//        binding.btnRefresh.setOnClickListener(new View.OnClickListener() {
//        //btnRefresh = findViewById(R.id.btnRefresh);
//        //btnRefresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewModel.refresh();
//            }
//        });
    }
}