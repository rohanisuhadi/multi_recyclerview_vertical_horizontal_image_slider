package com.example.delaroy.heterogenousrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.delaroy.heterogenousrecyclerview.adapter.MainAdapter;
import com.example.delaroy.heterogenousrecyclerview.pojos.ImageSladerModel;
import com.example.delaroy.heterogenousrecyclerview.pojos.SingleHorizontal;
import com.example.delaroy.heterogenousrecyclerview.pojos.SingleVertical;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Object> dataAll = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
        MainAdapter adapter = new MainAdapter(this, getObject(),getDataAll());
        recyclerView.setAdapter(adapter);
        adapter.addDataImagesSleder(getImageSlederData());
        adapter.addDataHorizontal(getHorizontalData());
        adapter.addDataVertical(getVerticalData());


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }



    private ArrayList<Object> getObject() {

        objects.add(getImageSlederData().get(0));
        objects.add(getHorizontalData().get(0));
        objects.add(getVerticalData().get(0));
        objects.add(getHorizontalData2().get(0));
        objects.add(getVerticalData().get(0));

        return objects;
    }

    private ArrayList<Object> getDataAll() {

        dataAll.add(getImageSlederData());
        dataAll.add(getHorizontalData());
        dataAll.add(getVerticalData());
        dataAll.add(getHorizontalData2());
        dataAll.add(getVerticalData());

        return dataAll;
    }

    public ArrayList<SingleVertical> getVerticalData() {
        ArrayList<SingleVertical> singleVerticals = new ArrayList<>();
        singleVerticals.add(new SingleVertical("Charlie Chaplin", "Sir Charles Spencer \"Charlie\" Chaplin, KBE was an English comic actor,....", R.mipmap.charlie));
        singleVerticals.add(new SingleVertical("Mr.Bean", "Mr. Bean is a British sitcom created by Rowan Atkinson and Richard Curtis, and starring Atkinson as the title character.", R.mipmap.mrbean));
        singleVerticals.add(new SingleVertical("Jim Carrey", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", R.mipmap.jim));
        return singleVerticals;
    }


    public ArrayList<SingleHorizontal> getHorizontalData() {
        ArrayList<SingleHorizontal> singleHorizontals = new ArrayList<>();
        singleHorizontals.add(new SingleHorizontal(R.mipmap.charlie, "Charlie Chaplin", "Sir Charles Spencer \"Charlie\" Chaplin, KBE was an English comic actor,....", "2010/2/1"));
        singleHorizontals.add(new SingleHorizontal(R.mipmap.mrbean, "Mr.Bean", "Mr. Bean is a British sitcom created by Rowan Atkinson and Richard Curtis, and starring Atkinson as the title character.", "2010/2/1"));
        singleHorizontals.add(new SingleHorizontal(R.mipmap.jim, "Jim Carrey", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", "2010/2/1"));
        return singleHorizontals;
    }

    public  ArrayList<ImageSladerModel> getImageSlederData(){
        ArrayList<ImageSladerModel> imageSladerModels = new ArrayList<>();
        imageSladerModels.add(new ImageSladerModel("Great Indian Deal", "https://image.tmdb.org/t/p/w250_and_h141_bestv2/zYFQM9G5j9cRsMNMuZAX64nmUMf.jpg"));
        imageSladerModels.add(new ImageSladerModel("New Deal Every Hour", "https://image.tmdb.org/t/p/w250_and_h141_bestv2/zYFQM9G5j9cRsMNMuZAX64nmUMf.jpg"));
        imageSladerModels.add(new ImageSladerModel("Appliances Sale", "https://image.tmdb.org/t/p/w250_and_h141_bestv2/zYFQM9G5j9cRsMNMuZAX64nmUMf.jpg"));
        return imageSladerModels;
    }

    public static ArrayList<SingleHorizontal> getHorizontalData2() {
        ArrayList<SingleHorizontal> singleHorizontals = new ArrayList<>();
        singleHorizontals.add(new SingleHorizontal(R.mipmap.charlie, "Charlie Chaplin", "Sir Charles Spencer \"Charlie\" Chaplin, KBE was an English comic actor,....", "2010/2/1"));
        return singleHorizontals;
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
