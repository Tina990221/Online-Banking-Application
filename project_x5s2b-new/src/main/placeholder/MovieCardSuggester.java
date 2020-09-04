package placeholder;

import placeholder.BankCard;
import placeholder.MovieCard;

import java.util.List;

public class MovieCardSuggester {
    public List<MovieCard> movieCardList;


    //REQUIRES: the movieCardList does not contain movieCard
    //EFFECTS: add the movieCard to CardList and add goCard to bankCardList
    public void addMovieCard(MovieCard m) {

        if (!movieCardList.contains(m)) {
            movieCardList.add(m);
            BankCard goCard = new BankCard("Tina's Card");
            m.addGoCard(goCard);
        }
    }
}

