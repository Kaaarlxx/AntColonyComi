public class City {

    int index;
    double x;
    double y;

    public City() {}

    public City(int i, double x, double y){
        this.index = i;
        this.x = x;
        this.y = y;
    }

    public City clone() {
        City tmp = new City();
        tmp.index = this.index;
        tmp.x = this.x;
        tmp.y = this.y;
        return tmp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }


        if (!(o instanceof City)) {
            return false;
        }

        City c = (City) o;

        return index == c.index
                && Double.compare(y, c.y) == 0
                && Double.compare(x, c.x) == 0;
    }
    @Override
    public String toString() {
        return index + " " + x + " " + y;
    }
}
