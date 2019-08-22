package com.isansc.drawerpoc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragment extends Fragment {
    private static final String EXTRA_PAGE_TITLE = "EXTRA_PAGE_TITLE";
    private String mTitle;

    public static PageFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(EXTRA_PAGE_TITLE, title);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = this.getArguments();
        if (args != null) {
            mTitle = args.getString(EXTRA_PAGE_TITLE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        TextView txtContent = view.findViewById(R.id.txt_content);
        txtContent.setText(mTitle);

        return view;

    }
}
