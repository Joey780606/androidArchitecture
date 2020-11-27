package pcp.com.androidarch;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class GithubViewModelFactory implements ViewModelProvider.Factory {
    private DataModel dataModel;

    public GithubViewModelFactory(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    @SuppressWarnings("unchecked")  // I add this annotation
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(dataModel);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
