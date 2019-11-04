package com.kevintcoughlin.common.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.kevintcoughlin.common.R;
import com.kevintcoughlin.common.adapter.BinderRecyclerAdapter;

import java.lang.ref.WeakReference;

public abstract class BinderRecyclerFragment<T, VH extends RecyclerView.ViewHolder> extends Fragment implements BinderRecyclerAdapter.OnClick<T> {
    private RecyclerView mRecyclerView;

    private WeakReference<OnItemSelected<T>> mOnItemSelectedCallback;

    protected abstract BinderRecyclerAdapter<T, VH> getAdapter();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    public interface OnItemSelected<T> {
        void onItemSelected(T item);
    }

    public void setOnItemSelectedListener(OnItemSelected<T> activity) {
        mOnItemSelectedCallback = new WeakReference<>(activity);
    }

    @Override
    public void onClick(@NonNull final T item) {
        this.mOnItemSelectedCallback.get().onItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recycler_layout, container, false);

        mRecyclerView = view.findViewById(R.id.list);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final BinderRecyclerAdapter<T, VH> adapter = getAdapter();
        adapter.setOnClickListener(this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.setAdapter(adapter);
    }
}
