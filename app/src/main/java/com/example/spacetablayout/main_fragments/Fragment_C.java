package com.example.spacetablayout.main_fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.spacetablayout.R;
import com.example.spacetablayout.TestList;
import com.example.spacetablayout.catalogue_manager.CatalogueAdapter;
import com.example.spacetablayout.catalogue_manager.CatalogueModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_C#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_C extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_C() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_C.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_C newInstance(String param1, String param2) {
        Fragment_C fragment = new Fragment_C();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void InsertDataIntoCards() {

        int[] couverture = new int[]{
                R.drawable.cave_boissons_bio,
                R.drawable.contacts_filled_24px,
                R.drawable.contacts_filled_24px,
                R.drawable.contacts_filled_24px,
                R.drawable.contacts_filled_24px,
                R.drawable.contacts_filled_24px
        };
        CatalogueModel a = new CatalogueModel("Beers", couverture[0]);
        catalogue.add(a);

        a = new CatalogueModel("Vins",couverture[1]);
        catalogue.add(a);
        a = new CatalogueModel("Eau Minerale",couverture[2]);
        catalogue.add(a);
        a = new CatalogueModel("Jus",couverture[3]);
        catalogue.add(a);
        a = new CatalogueModel("Whisky",couverture[4]);
        catalogue.add(a);
        a = new CatalogueModel("Champagnes",couverture[5]);
        catalogue.add(a);

        // Notifier l'adapter de l'ajout de data
        adapter.notifyDataSetChanged();


    }

    public void changeItem(int position, String text){
        catalogue.get(position).changeText1("You clicked");
        adapter.notifyItemChanged(position);
    }


    private RecyclerView recyclerView;
    private CatalogueAdapter adapter;
    private List<CatalogueModel> catalogue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment__c, container, false);

        MaterialToolbar toolbar = v.findViewById(R.id.toolbar);
        // initialise le CollapsedToolbar

        //region Collapsing Toolbar
        final CollapsingToolbarLayout collapsingToolbar =
                v.findViewById(R.id.collapseToolBar);
        collapsingToolbar.setTitle("Catalogue");
        AppBarLayout appBarLayout = v.findViewById(R.id.appBar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Catalogue");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("Catalogue");
                    isShow = false;
                }
            }
        });
        // endregion
        // region Adapter
        recyclerView = v.findViewById(R.id.catalogRecycler);
        catalogue = new ArrayList<>();
        adapter = new CatalogueAdapter(getActivity(),catalogue);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new CatalogueAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }
        });

        // endregion

        /***
         * Step 4: Insertion des data dans le cards
         * ***/
        InsertDataIntoCards();

        try{
            Glide.with(this)
                    .load(R.drawable.all_drinks_removebg).into((ImageView)v.findViewById(R.id.backdrop));
        }catch (Exception e){
            e.printStackTrace();
        }

        return v;

    }




    public static class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{
        // This class for decoration of items
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp,r.getDisplayMetrics()));
    }
}
