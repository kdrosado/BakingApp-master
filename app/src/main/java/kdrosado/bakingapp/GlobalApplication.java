package kdrosado.bakingapp;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import kdrosado.bakingapp.RecipesIdlingResource;

public class GlobalApplication extends Application {
    // The Idling Resource which will be null in production.
    @Nullable
    private RecipesIdlingResource mIdlingResource;

    /**
     * Only called from test, creates and returns a new {@link RecipesIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    private IdlingResource initializeIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new RecipesIdlingResource();
        }
        return mIdlingResource;
    }

    public GlobalApplication() {

        // The IdlingResource will be null in production.
        if (BuildConfig.DEBUG) {
            initializeIdlingResource();
        }

        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                // Enable logging only on debug
                return BuildConfig.DEBUG;
            }
        });

    }

    public void setIdleState(boolean state) {
        if (mIdlingResource != null)
            mIdlingResource.setIdleState(state);
    }

    @Nullable
    public RecipesIdlingResource getIdlingResource() {
        return mIdlingResource;
    }
}
