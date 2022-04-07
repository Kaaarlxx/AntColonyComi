
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {


   final static int alfa = 1;
   final static int beta = 1;
   final static double p = 0.5;
   final static int Q = 100;




   public static void main(String[] args) {

       ArrayList<City> cities = Helper.readValues();
       ArrayList<Double> probs = new ArrayList<>();
       int size = cities.get(0).index;
       cities.remove(0);
       int MAX_ITERS = 300;
       ArrayList<Ant> ants = new ArrayList<>();
       ArrayList<Peek> peeks = new ArrayList<>();

       double prob;

       //wszystkie krawędzie
       for (int i = 0; i < size ; i++) {
           for (int j = 0; j < size; j++) {
               Peek tmpPeek = new Peek(cities.get(i),cities.get(j));
               peeks.add(tmpPeek);
           }
       }

       //mrówki w miastach
       for (int i = 0; i < size; i++) {
           Ant ant = new Ant(cities.get(i));
           ants.add(ant);
       }

       //główna pętla
       for (int i = 0; i < size; i++)
       {

           for (Peek p: peeks) {
               p.addedPheromones = 0;
           }
            //Wybieranie punktu kolejnego
           for (int j = 0; j < size; j++) {

                Ant ant = ants.get(j);
                probs.clear();
                double denominator = 0;

               for (int k = 0; k < peeks.size(); k++)
               {
                   Peek peek = peeks.get(k);
                   if(peek.c1.index==ant.actPlace.index)
                   {
                       if(!ant.visited(peek.c2))
                       denominator +=  Math.pow(peek.pheromones,alfa) * Math.pow(peek.distance,beta);
                   }
               }

               for (int k = 0; k < peeks.size(); k++)
               {
                   Peek peek = peeks.get(k);

                   if(peek.c1.index==ant.actPlace.index)
                   {
                       if(!ant.visited(peek.c2))
                       {
                           prob = (Math.pow(peek.pheromones,alfa)*Math.pow(1/peek.distance,beta)/denominator);
                       }
                       else prob = 0;
                   }
                   else prob = 0;
                   probs.add(prob);
               }
               Double a = Collections.max(probs);
               int index = probs.indexOf(a);

               //zostawianie feromonow na sciezkach
               Peek peek = peeks.get(index);
               Peek peektmp = new Peek(peek.c2,peek.c1);
               int index2 = 101;
               for (Peek p: peeks) {
                   if(p.equals(peektmp)) index2 = peeks.indexOf(p);
               }
               peektmp = peeks.get(index2);
               peek.addedPheromones += Q/peek.distance;
               peektmp.addedPheromones += Q/peektmp.distance;
               ant.move(peek.c2);
           }

            //pheromones
           for (int j = 0; j < peeks.size(); j++) {
                Peek peek = peeks.get(j);
               double fero = (1-p)*peek.pheromones;
               fero += peek.addedPheromones;
                peek.pheromones = fero;
           }

       }
    double min = 100000;
       for (int i = 0; i < ants.size(); i++) {
           if(ants.get(i).wholeRoad()< min) min = ants.get(i).wholeRoad();
       }
       for (int i = 0; i < ants.size(); i++) {
           System.out.println(ants.get(0).road.get(i).index);
       }

       System.out.println(min);
    }
}
