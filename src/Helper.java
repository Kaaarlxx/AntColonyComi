import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Helper {

    public static void printArray(ArrayList<City> array) {

        for (int i = 0; i < array.size(); i++) {
        City o;
        o = array.get(i);
        System.out.println(o.toString());
        }

    }

    public static double length(City c1, City c2) {
        return (Math.sqrt((c2.x - c1.x) * (c2.x - c1.x) + (c2.y - c1.y) * (c2.y - c1.y)));
    }

    public static ArrayList<City> readValues() {
        try {
            ArrayList<City> cities = new ArrayList<>();
            File file = new File("kroa150");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            City tmpcity = new City();
            int size;
            String tmp = br.readLine();
            size = Integer.parseInt(tmp);
            tmpcity.index = size;
            cities.add(tmpcity.clone());
            String[] substrings;

            for (int i = 0; i < size; i++) {
                line = br.readLine();
                substrings = line.split(" ");
                tmpcity.index = Integer.parseInt(substrings[0]);
                tmpcity.x = Double.parseDouble(substrings[1]);
                tmpcity.y = Double.parseDouble(substrings[2]);
                cities.add(tmpcity.clone());
            }
            fr.close();
            return cities;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File does not exist");
            return null;
        }

    }
}
