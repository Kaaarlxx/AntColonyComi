public class Peek {

    City c1;
    City c2;
    double distance;
    double pheromones;
    double addedPheromones;

    public Peek(){}

    public Peek(City c1, City c2) {
        this.c1 = c1;
        this.c2 = c2;
        this.pheromones = 1;
        distance = Helper.length(c1,c2);
        addedPheromones = 0;
    }

    public Peek clone() {
        Peek tmp = new Peek();
        tmp.c1 = this.c1;
        tmp.c2 = this.c2;
        tmp.distance = this.distance;
        tmp.pheromones = this.pheromones;
        return tmp;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }


        if (!(o instanceof Peek)) {
            return false;
        }

        Peek p = (Peek) o;

        return c1.equals(p.c1) &&
               c2.equals(p.c2);

    }

    @Override
    public String toString() {
        return c1.index + " " + c2.index;
    }
}
