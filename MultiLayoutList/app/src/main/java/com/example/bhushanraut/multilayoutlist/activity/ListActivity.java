package com.example.bhushanraut.multilayoutlist.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.bhushanraut.multilayoutlist.R;
import com.example.bhushanraut.multilayoutlist.adapter.CustomListAdapter;
import com.example.bhushanraut.multilayoutlist.constants.ViewRowType;
import com.example.bhushanraut.multilayoutlist.modalclass.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * ListActivity is Launcher Activity which displays List of cricketer.
 * It comprises of ListView with Two Different Layouts
 */
public class ListActivity extends AppCompatActivity {

    private List<Player> mPlayerList;
    private ListView mPlayerListView;
    private String[] mDataArray;


    /**
     * Initilises Array and adds data to it.
     *
     * @return List of Data containing Cricketers Data
     */
    private List getListContents() {
        mPlayerList = new ArrayList<Player>();
        for (int i = 0; i < 35; i++) {
            mPlayerList.add(new Player(R.drawable.rahuldravid, "Rahul D", "909000", ViewRowType.IMAGE_ROW));
            mPlayerList.add(new Player(mDataArray[0], "https://en.wikipedia.org/wiki/Rahul_Dravid", ViewRowType.WITHOUT_IMAGE_ROW));

            mPlayerList.add(new Player(R.drawable.sachin, "Sachin tendulkar", "909000", ViewRowType.IMAGE_ROW));
            mPlayerList.add(new Player(mDataArray[1], "https://en.wikipedia.org/wiki/Sachin_Tendulkar", ViewRowType.WITHOUT_IMAGE_ROW));

            mPlayerList.add(new Player(R.drawable.virat, "Virat Kohli", "909000", ViewRowType.IMAGE_ROW));
            mPlayerList.add(new Player(mDataArray[2], "https://en.wikipedia.org/wiki/Virat_Kohli", ViewRowType.WITHOUT_IMAGE_ROW));
        }


        return mPlayerList;
    }

    /**
     * init() method initialises listview and array
     */
    private void init() {

        mPlayerListView = (ListView) findViewById(R.id.lv_player_list);
        mDataArray = getResources().getStringArray(R.array.details);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();

        CustomListAdapter listAdapter = new CustomListAdapter(this, (ArrayList<Player>) getListContents());
        mPlayerListView.setAdapter(listAdapter);

    }
}
