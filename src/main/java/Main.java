import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {


    //https://www.pbinfo.ro/probleme/4402/ciocolata1

    public static Integer ciocolata(Integer c, Integer n, List<Integer> sir) {

        if (n < 0 || n > 100_000)
            return -2;

        for (Integer elem : sir)
            if (elem <= 0 || elem >= 10_000)
                return -3;

        if (c == 1) {
            ArrayList<Integer> vectorAparitii = new ArrayList<>(10_000);
            for (Integer i = 0; i <= 10_000; i++) {
                vectorAparitii.add(0);
            }

            for (Integer elem : sir)
                vectorAparitii.set(elem, vectorAparitii.get(elem) + 1);

            Integer max = Integer.MIN_VALUE;
            Integer maxIdx = -1;
            for (Integer i = 1; i <= 10_000; i++)
                if (vectorAparitii.get(i) > max) {
                    max = vectorAparitii.get(i);
                    maxIdx = i;
                }

            return maxIdx;
        }


        if (c == 2) {

            if (n < 2)
                return -4;

            Deque<Integer> d_sir = new ArrayDeque<>(sir);

            Integer irina = 0;
            Integer mihaela = 0;
            Integer min = Integer.MAX_VALUE;

            irina += d_sir.pollFirst();
            mihaela += d_sir.pollLast();

            while (d_sir.peek() != null) {

                while (d_sir.peek() != null && irina - mihaela < 0)
                    irina += d_sir.pollFirst();

                if (irina - mihaela >= 0 && min > irina - mihaela) {
                    min = irina - mihaela;
                }

                while (d_sir.peek() != null && mihaela - irina < 0) {
                    mihaela += d_sir.pollLast();

                    if (irina - mihaela >= 0 && min > irina - mihaela) {
                        min = irina - mihaela;
                    }
                }

                if (min == 0)
                    return min;

            }
            return min;
        }

        return -1;
    }

    public static void main(String[] args) {
        String filepath = "src/main/java/ciocolata.in";

        Integer c = null;
        Integer n = null;
        List<Integer> sir = null;
        try {
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);

            c = scanner.nextInt();
            n = scanner.nextInt();

            sir = new ArrayList<Integer>();

            while (scanner.hasNext()) {
                sir.add(scanner.nextInt());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(ciocolata(c, n, sir));

    }
}
