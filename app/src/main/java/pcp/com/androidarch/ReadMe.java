package pcp.com.androidarch;

public class ReadMe {
/*
  注意:
   1. 重要的地方請加註記: // keynote:
  Day 2: MVVM架構
    Step 1: Build DataModel.java
    Step 2: Build MainViewModel.java
    Step 3: Modify activity_main.xml
    Step 4: Modify MainActivity.java
    Step 5: Module: app 的 build.gradle 加上 dataBinding 的功能 (這已和原本文章的處理不同了,要注意)
    Step 6: 再調整 activity_main.xml (外面加一個 <layout> </layout>
    Step 7: 再更新 MainActivity.java
    Step 8: 再更新 MainViewModel.java
    Step 9: 再更新 main_activity.xml
  Reference website: https://ithelp.ithome.com.tw/articles/10192829

  ===============
  Day 3: Architecture Components - ViewModel
    1. Lifecycle-aware ViewModel的建立
    2. 在 MainActivity.java 若需要讓下方這句成功,
       viewModel = new ViewModelProvider(this).get(MainViewModel.class);

       需要implement
       implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    3. 做這的目的,是避免螢幕轉向時,造成困擾
    4. Context: 不要儲存Activity/Fragment的內容或context在ViewModel中，因為
       configuration changes時當前的Activity及其內容會被destroy，就會變成存放被
       destroy的內容在ViewModel中而產生memory leak。

       若需要在ViewModel中使用Context的話可以改成使用AndroidViewModel，其
       constructor帶有application供我們取得context.
       (課程有一個例子,但只是例子,不是最後程式的一部分)

    5. ViewModelFactory : ViewModel需透過ViewModelProviders來取得，所以不能在
       View中直接用constructor parameter來傳遞，若需要傳遞參數的話須建立Factory。

       有實例,但只是純粹舉例用Factory來傳遞參數的方法，實務上不會這樣傳遞Model，
       因為這樣就違反MVVM原則讓View跟Model接觸

  Reference website: https://ithelp.ithome.com.tw/articles/10193118

  ===============
  Class 4 Architecture Components - LiveData - 1
   1. viewModel.mData.addOnPropertyChangedCallback
     功能: 當功能有改變(完成時)的Callback

   2. LiveData:
     a. LiveData最強大的地方在於lifecycle-aware特性，當LiveData的value發生改變
       時，若View在前景便會直接發送，而View在背景的話，value將會被保留(hold)住，直到回到前景時才發送。
       此外，當View被destroy時，LiveData也會自動停止observe行為，避免造成memory-leak。

     b. MutableLiveData是方便我們使用的LiveData子類別，提供setValue()和postValue()兩種方式更新
       value，差異在於前者是在main thread執行，若需要在background thread則改用後者。

     3. 實作 LiveData 例子,到介紹 SingleLiveEvent 前面
       Reference website: https://ithelp.ithome.com.tw/articles/10193296
 */
}
