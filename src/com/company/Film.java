import java.time.Year;

public class Film {
    String name;
    Year released;
    float rating;
    int views;

    Film(String name,Year released, float rating,int views){
        this.name = name;
        this.released = released;
        this.rating = rating;
        this.views = views;
    }

}
