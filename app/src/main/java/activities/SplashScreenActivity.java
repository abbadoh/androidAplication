package activities;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tp.gumo.activity.R;
import java.util.HashMap;
import api.ReceiveLanguages;
import api.YandexTranslateApi;

public class SplashScreenActivity extends FragmentActivity implements ReceiveLanguages {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        LoadLanguagesAsyncTask task = new LoadLanguagesAsyncTask(this);

        task.execute();
    }

    @Override
    public void setLanguages(HashMap<String, String> languages) {

    }

    public class LoadLanguagesAsyncTask extends AsyncTask<Integer, Integer, HashMap<String, String>> {
        private ReceiveLanguages receiver;

        public LoadLanguagesAsyncTask(ReceiveLanguages receiver) {
            this.receiver = receiver;
        }

        @Override
        protected void onPreExecute() { }

        @Override
        protected HashMap<String, String> doInBackground(Integer... params) {
            YandexTranslateApi yandexTranslateApi = new YandexTranslateApi();

            return yandexTranslateApi.getLanguages("ru");
        }

        @Override
        protected void onPostExecute(HashMap<String, String> result) {
            receiver.setLanguages(result);
        }
    }
}
