package placeholder;

public class ShareMethod {

    public boolean within6months;


    public ShareMethod() {
        within6months = true;

    }

    //EFFECTS: return true if the card is used within 6 months,
    //false otherVise
    public boolean cardIsValid() {
        if (within6months) {
            return true;
        } else {
            return false;
        }
    }

}
