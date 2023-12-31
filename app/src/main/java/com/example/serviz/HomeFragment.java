package com.example.serviz;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.NavigationUI;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final DrawerLayout drawerLayout = view.findViewById(R.id.drawableLayout);


        view.findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = view.findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
        navigationView.setItemTextColor(ColorStateList.valueOf(R.color.black));

                navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.shutdown){
                    Intent intent = (new Intent(getActivity(), Login.class));
                    startActivity(intent);

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
                navigationView.getHeaderView(0).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = (new Intent(getActivity(), UserData.class));
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                });



        CardView cardView = view.findViewById(R.id.sign_upin);
        CardView cardView1 = view.findViewById(R.id.hello_world);
        CardView cardView2 = view.findViewById(R.id.carpenter);
        CardView cardView3 = view.findViewById(R.id.plumbers);
        CardView cardView4 = view.findViewById(R.id.painters);
        CardView cardView5 = view.findViewById(R.id.cleaners);
        CardView cardView6 = view.findViewById(R.id.startup);
        CardView cardView7 = view.findViewById(R.id.acrepairs);
        CardView cardView8 = view.findViewById(R.id.carclean);
        CardView cardView9 = view.findViewById(R.id.tvrepair);
        CardView cardView10 = view.findViewById(R.id.water);
        CardView cardView11 = view.findViewById(R.id.chimney);
        CardView cardView12 = view.findViewById(R.id.ovani);
        CardView cardView13 = view.findViewById(R.id.little);
        CardView cardView14 = view.findViewById(R.id.micro);
        CardView cardView15 = view.findViewById(R.id.fridge);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), SignUp.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location2.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location2.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location2.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location2.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location2.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location2.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });
        cardView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(getActivity(), current_location2.class));
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(), android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
            }
        });

        return view;
    }

}


