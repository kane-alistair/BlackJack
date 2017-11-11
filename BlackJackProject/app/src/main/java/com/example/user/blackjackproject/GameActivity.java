package com.example.user.blackjackproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    Button startButton;
    Game newGame;
    Deck deck;
    Integer betPlaced;
    TextView handDisplayTv;
    TextView handValueTv;
    TextView dealerHandTv;
    TextView dealerHandValueTv;
    TextView showWinnerTv;
    TextView checkBustTv;
    TextView showFundsTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_activity);
        betPlaced = 0;


        deck = new Deck();
        newGame = new Game(deck);
        startButton = (Button) findViewById(R.id.playBtn);
        handDisplayTv = (TextView) findViewById(R.id.handDisplayTv);
        handValueTv = (TextView) findViewById(R.id.handValueTv);
        dealerHandTv = (TextView) findViewById(R.id.dealerHandDisplayTv);
        dealerHandValueTv = (TextView) findViewById(R.id.dealerHandValueTv);
        showWinnerTv = (TextView) findViewById(R.id.showWinnerTv);
        checkBustTv = (TextView) findViewById(R.id.checkBustTv);
        showFundsTv = (TextView) findViewById(R.id.displayFunds);
        showFundsTv.setText(newGame.showUserFunds().toString());

    }

    //steps of Game
    //startGame button should display user hand
    //user then picks stick or twist button
    //dealer logic gets carried out and we see their cards
    //show results win loss
    //update round counter


    public void startGame(View view) {
        dealerHandTv.setText("");
        dealerHandValueTv.setText("");
        showWinnerTv.setText("");
        checkBustTv.setText("");
        showFundsTv.setText(newGame.showUserFunds().toString());


        newGame.deal();
        handDisplayTv.setText(newGame.showUserHand());
        handValueTv.setText(newGame.showUserHandValue().toString());
    }


    public void stick(View view) {
        newGame.stick();

        //Dealer Move
        newGame.dealerMove();
        dealerHandTv.setText(newGame.showDealerHand());
        dealerHandValueTv.setText(newGame.showDealerHandValue().toString());
        showWinnerTv.setText(newGame.displayWinner().toString() + " wins!");
        betPlaced = 5;
        newGame.payOut(betPlaced);
//        showFundsTv.setText(newGame.showUserFunds());

    }


    public void twist(View view) {
        newGame.twist();
        handDisplayTv.setText(newGame.showUserHand());
        handValueTv.setText(newGame.showUserHandValue().toString());
        checkBustTv.setText(newGame.displayBust());

        //deals new card and displays new result
    }
}
