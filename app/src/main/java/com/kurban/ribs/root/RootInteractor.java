package com.kurban.ribs.root;


import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kurban.ribs.R;
import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Coordinates Business Logic for {@link RootScope}.
 * <p>
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class RootInteractor extends Interactor<RootInteractor.RootPresenter, RootRouter> {

    @Inject
    RootPresenter presenter;

    private int count = 1;

    @SuppressLint("CheckResult")
    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);
        Log.d("RootInteractor", "didBecomeActive");

        Context context = presenter.getContext();

        presenter.click().subscribe(o -> {
            presenter.setText(context.getString(R.string.hello_world));

            attachControl(context);
        });
    }

    private void attachControl(@NonNull Context context) {
        count++;

        if (count % 2 == 0) {
            getRouter().attachLogin();
            presenter.setText(context.getString(R.string.attach));
        } else {
            getRouter().detachLogin();
            presenter.setText(context.getString(R.string.detach));
        }
    }

    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface RootPresenter {
        Context getContext();

        Observable<Object> click();

        void setText(@NonNull String value);
    }
}
