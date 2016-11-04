package info.devexchanges.cardsstack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.wenchao.cardstack.CardStack;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CardStack cardStack;
    private CardsAdapter cardsAdapter;
    private ArrayList<CardItem> cardItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardStack = (CardStack)findViewById(R.id.container);
        cardStack.setContentResource(R.layout.item_card);

        cardItems = new ArrayList<>();

        cardItems.add(new CardItem(R.drawable.a));
        cardItems.add(new CardItem(R.drawable.b));
        cardItems.add(new CardItem(R.drawable.c));
        cardItems.add(new CardItem(R.drawable.d));
        cardItems.add(new CardItem(R.drawable.e));
        cardItems.add(new CardItem(R.drawable.f));
        cardItems.add(new CardItem(R.drawable.g));

        cardsAdapter = new CardsAdapter(this, R.layout.item_card, cardItems);
        cardStack.setAdapter(cardsAdapter);
    }
}
