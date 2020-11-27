package pcp.com.androidarch;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

//public class MainViewModel extends AndroidViewModel { //Use AndroidViewModel method-1
public class MainViewModel extends ViewModel {
    public final ObservableField<String> mData = new ObservableField<>();
    public final ObservableBoolean isLoading = new ObservableBoolean(false);

//    Use AndroidViewModel method-2
//    private final Context mContext; // To avoid leaks, this must be an Application Context.
//    public MainViewModel(@NonNull Application application) {
//        super(application);
//        mContext = application.getApplicationContext(); // Force use of Application context.
//    }

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
                mData.set(data);
                isLoading.set(false);
            }
        });
    }
}
