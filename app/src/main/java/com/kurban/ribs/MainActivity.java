package com.kurban.ribs;

import android.view.ViewGroup;

import com.kurban.ribs.root.RootBuilder;
import com.uber.rib.core.RibActivity;
import com.uber.rib.core.ViewRouter;

public class MainActivity extends RibActivity {

    @Override
    protected ViewRouter<?, ?, ?> createRouter(ViewGroup parentViewGroup) {
        RootBuilder builder = new RootBuilder(new RootBuilder.ParentComponent() {});
        return builder.build(parentViewGroup);
    }
}
