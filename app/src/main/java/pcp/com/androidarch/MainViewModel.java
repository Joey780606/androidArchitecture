package pcp.com.androidarch;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//public class MainViewModel extends AndroidViewModel { //Use AndroidViewModel method-1
public class MainViewModel extends ViewModel {
    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    public final MutableLiveData<String> mData = new MutableLiveData<>();

    public final SingleLiveEvent<String> toastText = new SingleLiveEvent<>();

    private DataModel dataModel = new DataModel();
    public MainViewModel(DataModel dataModel) {
        super();
        this.dataModel = dataModel;
    }

    public void refresh() {
        isLoading.set(true);
        dataModel.retrieveData(new DataModel.onDataReadyCallback()
        {
            @Override
            public void onDataReady(String data) {
                mData.setValue(data);
                toastText.setValue("下載完成");
                isLoading.set(false);
            }
        });
    }
}
