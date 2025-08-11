package _21RegularExam;
import java.util.*;

public class _11ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> foodSt = new ArrayDeque<>();
        ArrayDeque<Integer> powerQu = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(foodSt::push);

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(powerQu::offer);


        Map<String, Integer> peaksMap = new LinkedHashMap<>();

        peaksMap.put("Vihren", 80);
        peaksMap.put("Kutelo", 90);
        peaksMap.put("Banski Suhodol", 100);
        peaksMap.put("Polezhan", 60);
        peaksMap.put("Kamenitza", 70);

        List<String> climbList = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> it = peaksMap.entrySet().iterator();

        while (!foodSt.isEmpty() &&
                !powerQu.isEmpty() &&
                it.hasNext()) {

            int food = foodSt.pop();
            int power = powerQu.poll();
            int total = food + power;

            Map.Entry<String, Integer> currPeakMap = it.next();

            if (total >= currPeakMap.getValue()) {
                climbList.add(currPeakMap.getKey());
            }
            else {
                it = new shellIterator<>(currPeakMap, it);
            }
        }

        if (climbList.size() == 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        }
        else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!climbList.isEmpty()) {

            System.out.println("Conquered peaks:");
            climbList.forEach(System.out::println);
        }
    }

    public static class shellIterator<K, V> implements Iterator<Map.Entry<K, V>> {

        private Map.Entry<K, V> curr;
        private Iterator<Map.Entry<K, V>> it;
        private boolean bFirst = true;

        public shellIterator(Map.Entry<K, V> curr, Iterator<Map.Entry<K, V>> it) {

            this.curr = curr;
            this.it = it;
        }

        @Override
        public boolean hasNext() {
            return bFirst || it.hasNext();
        }

        @Override
        public Map.Entry<K, V> next() {
            if (bFirst) {

                bFirst = false;
                return curr;
            }
            return it.next();
        }
    }
}
