package func.theory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hans
 */
public class impl {



    public void whenSerializingAndDeserializing_ThenObjectIsTheSame()
            throws IOException, ClassNotFoundException{

        Company c1 = new Company("test", "AAA");
        Company c2 = new Company("test1", "BBB");

        FileOutputStream fileOutputStream = new FileOutputStream("serial.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(c1);
        objectOutputStream.flush();
        objectOutputStream.close();

    }




    public static void main(String[] args) {

        Company c1 = new Company("test", "AAA");
        Company c2 = new Company("test1", "BBB");

        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i < grid[0].length; i++){

            int sum =0;

            for(int j=i; j < grid.length; j++){

                sum += grid[j][i];
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(map);
        System.out.println(c1);
        System.out.println(c2);


    }
}
