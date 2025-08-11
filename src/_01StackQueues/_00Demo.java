package _01StackQueues;

import java.util.*;

public class _00Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //------------------------------------
        // 1. Stack (LIFO - Last In First Out)
        //------------------------------------

        // * Стекът е структура, при която последният добавен елемент е първият изваден (като купчина чинии).

        //  Имплементация (препоръчително с ArrayDeque)
        //ArrayDeque<String> stack = new ArrayDeque<>();  // Модерен начин (вместо остарелия Stack)

        //🔹 Основни операции:

        //stack.push(e)	  -> Добавя елемент на върха на стека
        //stack.pop()	  -> Премахва и връща елемента от върха
        //stack.peek()	  -> Достъпване на елемент от стека
        //stack.isEmpty() -> Проверява дали стекът е празен

        // ПРИМЕР:

        /*ArrayDeque<String> st = new ArrayDeque<>();
        st.push("Java");
        st.push("Python");
        st.push("C++");

        System.out.println(stack.pop());  // "C++" (последният влязъл)
        System.out.println(stack.peek()); // "Python" (нов върх)*/



        //-------------------------------------
        // 2.QUEUE  (FIFO - First In First Out)
        //-------------------------------------

        // * Опашката е структура, при която първият добавен елемент е първият изваден (като опашка в магазин).

        //  Имплементация (обикновена опашка):

        // Queue<Integer> queue = new LinkedList<>();  // или new ArrayDeque<>()
        // ArrayDeque<Integer> queue = new ArrayDeque<>();

        // 🔹 Основни операции:

        //queue.offer(e) / queue.add(e) ->	Добавя елемент в края на опашката
        // queue.poll() / queue.remove() ->	Премахва и връща елемента от началото
        // queue.peek()	 -> Връща елемента от началото БЕЗ да го премахва
        // queue.isEmpty() ->	Проверява дали опашката е празна


        // ПРИМЕР:

        //Queue<String> queue = new LinkedList<>();

        /*ArrayDeque<String> qu = new ArrayDeque<>();
        qu.offer("Apple");
        qu.offer("Banana");
        qu.offer("Cherry");

        System.out.println(qu.poll());  // "Apple" (първият влязъл)
        System.out.println(qu.peek());  // "Banana" (нов първи елемент)*/


        //--------------------------------------
        // 3. PriorityQueue (Опашка с приоритет)
        //--------------------------------------

        // Имплементация:

                // Подрежда от най-малкото към най-голямото
        // Queue<Integer> priorityQueue = new PriorityQueue<>();

                // Подрежда от най-голямото към най-малкото
         Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());


        // 🔹 Основни операции:

        // priorityQueue.offer(e) -> Добавя елемент с автоматично сортиране
        // priorityQueue.poll()	  -> Премахва и връща най-важния елемент
        // priorityQueue.peek()	  -> Връща най-важния елемент без да го премахва

        // ПРИМЕР :

        PriorityQueue<Integer> pQu = new PriorityQueue<>();
        pQu.offer(5);
        pQu.offer(1);
        pQu.offer(10);

        System.out.println(pQu.poll());  // 1 (най-малкото число)
        System.out.println(pQu.poll());  // 5
        System.out.println(pQu.poll());  // 10


        /*
         ❓ Коя структура кога да използваме?

         -> Stack	Обработка на рекурсия,  операци в текстов редактор
         -> Queue	Задачи, които изискват FIFO (обработка на заявки)	Опашка от задачи за изпълнение
         -> PriorityQueue	Задачи с приоритет (най-важното първо)	Система за бърза помощ в болница

          🎯 Заключение: --> използвай ArrayDeque<>();

         ArrayDeque<Integer> stack = new ArrayDeque<>();
         ArrayDeque<Integer> queue = new ArrayDeque<>();
        */


    }

    /*public static void printMatrix(matrixOne, matrixTwo) {

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                matrixOne[row][col] = input[col].charAt(0);
            }
        }*/
    }

