package pcp.com.androidarch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import pcp.com.androidarch.databinding.ActivityMainBinding;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        GithubViewModelFactory factory = new GithubViewModelFactory(new DataModel());
        viewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        binding.setViewModel(viewModel);

        // 加了這個,如果事情做完了,就會顯示 "下載完成" 的內容, 這是第一步,後來用LiveData後,又有別的方法
        //viewModel.mData.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
        //    @Override
        //    public void onPropertyChanged(Observable sender, int propertyId) {
        //        Toast.makeText(MainActivity.this, "下載完成", Toast.LENGTH_SHORT).show();
        //    }
        //});

        viewModel.mData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String data) {
                binding.txtHelloWord.setText(data);
                //Toast.makeText(MainActivity.this, "下載完成", Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.toastText.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String text) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}