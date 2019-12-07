package com.kurban.ribs.root;


import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

    @SuppressLint("CheckResult")
    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);

        presenter.click().subscribe(o -> {
            presenter.setText("Hello World!");
        });
    }

    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface RootPresenter {

        Observable<Object> click();

        void setText(@NonNull String value);
    }
}
