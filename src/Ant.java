import java.util.ArrayList;

public class Ant {

    City actPlace;
    ArrayList<City> road = new ArrayList<>();


    public Ant(City act) {
        this.actPlace = act;
        road.add(act.clone());
    }

    public boolean visited(City c)
    {
        for (int i = 0; i < road.size(); i++) {
            if(road.get(i).index==c.index) return true;
        }
        return false;
    }
    public void move(City c)
    {
        this.actPlace = c.clone();
        road.add(c);
    }

    public double wholeRoad()
    {
        double rd = 0;
        for (int i = 0; i < road.size(); i++) {
            City c = road.get(i);
            City c2 = new City();
            if(i==road.size()-1)
            {
                c2 = road.get(0);
            }
            else
            {
                c2 = road.get(i + 1);
            }
            rd += Helper.length(c,c2);
        }
        return rd;
    }
}
