package _13Workshop.Char;

import java.util.function.Consumer;

class CharArray {

    private char[][] data;  // Всеки ред е масив от char (представящ низ)
    private char[] size;    // Размерът като char[] (напр., {'0'}, {'1','0'})
    private char[] capacity; // Капацитетът като char[]

    public CharArray() {

        this.size = new char[]{'0'};
        this.capacity = new char[]{'9'};

        this.data = new char[parseCharToInt(this.capacity)][];
    }

    // Добавяне на елемент (като char[])
    public void add(char[] element) {

        if (compareCharArrays(this.size, this.capacity) >= 0) {
            increaseCapacity();
        }
        this.data[parseCharToInt(this.size)] = element;
        this.size = incrementCharArray(this.size);
    }

    // Увеличаване на капацитета
    private void increaseCapacity() {

        char[] newCapacity = multiplyCharArray(this.capacity);
        char[][] temp = new char[parseCharToInt(newCapacity)][];

        char[] pos = new char[]{'0'};
        while (compareCharArrays(pos, this.size) < 0) {

            temp[parseCharToInt(pos)] = this.data[parseCharToInt(pos)];
            pos = incrementCharArray(pos);
        }

        this.data = temp;
        this.capacity = newCapacity;
    }

    // Връща елемент на даден индекс (като char[])
    public char[] get(char[] index) {

        validateChar(index);
        return this.data[parseCharToInt(index)];
    }

    // Проверка за валиден индекс
    private void validateChar(char[] index) {

        if (compareCharArrays(index, new char[]{'0'}) < 0 ||
            compareCharArrays(index, this.size) >= 0) {

            throw new IndexOutOfBoundsException("Invalid index character!");
        }
    }

    // Премахване на елемент на даден индекс
    public char[] remove(char[] index) {
        validateChar(index);

        char[] removedElement = this.data[parseCharToInt(index)];
        char[] currentPos = index;

        while (compareCharArrays(currentPos, decrementCharArray(this.size)) < 0) {
            this.data[parseCharToInt(currentPos)] =
                    this.data[parseCharToInt(incrementCharArray(currentPos))];
            currentPos = incrementCharArray(currentPos);
        }

        this.data[parseCharToInt(decrementCharArray(this.size))] = null;
        this.size = decrementCharArray(this.size);

        return removedElement;
    }

    // Проверка дали съдържа елемент
    public boolean contains(char[] element) {
        char[] currentIndex = new char[]{'0'};
        while (compareCharArrays(currentIndex, this.size) < 0) {
            if (areCharArraysEqual(this.data[parseCharToInt(currentIndex)], element)) {
                return true;
            }
            currentIndex = incrementCharArray(currentIndex);
        }
        return false;
    }

    // Добавяне на елемент на конкретен индекс
    public void add(char[] element, char[] index) {
        validateAddIndex(index);

        if (compareCharArrays(this.size, this.capacity) >= 0) {
            increaseCapacity();
        }

        char[] currentPos = decrementCharArray(this.size);
        while (compareCharArrays(currentPos, index) >= 0) {
            this.data[parseCharToInt(incrementCharArray(currentPos))] =
                    this.data[parseCharToInt(currentPos)];
            currentPos = decrementCharArray(currentPos);
        }

        this.data[parseCharToInt(index)] = element;
        this.size = incrementCharArray(this.size);
    }

    // Проверка за валиден индекс при добавяне
    private void validateAddIndex(char[] index) {
        if (compareCharArrays(index, new char[]{'0'}) < 0 ||
                compareCharArrays(index, incrementCharArray(this.size)) > 0) {
            throw new IndexOutOfBoundsException("Invalid index for add");
        }
    }

    // Итерация върху всички елементи
    public void forEach(Consumer<char[]> consumer) {
        char[] currentIndex = new char[]{'0'};
        while (compareCharArrays(currentIndex, this.size) < 0) {
            consumer.accept(this.data[parseCharToInt(currentIndex)]);
            currentIndex = incrementCharArray(currentIndex);
        }
    }

    // Представяне като низ (връща като char[])
    public char[] toCharArray() {
        if (compareCharArrays(this.size, new char[]{'0'}) == 0) {
            return new char[0];
        }

        // Изчисляване на общата дължина
        char[] totalLength = new char[]{'0'};
        char[] currentIndex = new char[]{'0'};
        while (compareCharArrays(currentIndex, this.size) < 0) {
            totalLength = addCharArrays(totalLength,
                    new char[]{(char) (this.data[parseCharToInt(currentIndex)].length + '0')});
            currentIndex = incrementCharArray(currentIndex);
        }

        // Създаване на резултата
        char[] result = new char[parseCharToInt(totalLength)];
        int pos = 0;
        currentIndex = new char[]{'0'};
        while (compareCharArrays(currentIndex, this.size) < 0) {
            char[] element = this.data[parseCharToInt(currentIndex)];
            System.arraycopy(element, 0, result, pos, element.length);
            pos += element.length;
            currentIndex = incrementCharArray(currentIndex);
        }

        return result;
    }

    // Помощни методи за работа с char[]

    // Сравнява два char[] като числа (връща -1, 0, 1)
    private static int compareCharArrays(char[] a, char[] s) {

        if (a.length != s.length) {
            return a.length < s.length ? -1 : 1;
        }

        for (int pos = 0; pos < a.length; pos++) {

            if (a[pos] != s[pos]) {
                return a[pos] < s[pos] ? -1 : 1;

            }
        }
        return 0;
    }

    // Проверка дали два char[] са равни
    private static boolean areCharArraysEqual(char[] a, char[] b) {
        if (a.length != b.length) return false;

        for (int pos = 0; pos < a.length; pos++) {
            if (a[pos] != b[pos]) return false;
        }
        return true;
    }

    private static char[] incrementCharArray(char[] num) {
        return addCharArrays(num, new char[]{'1'});
    }

    private static char[] decrementCharArray(char[] num) {
        return subtractCharArrays(num, new char[]{'1'});
    }

    private static char[] multiplyCharArray(char[] num) {
        return addCharArrays(num, num);
    }

    private static char[] addCharArrays(char[] num1, char[] num2) {

        int N1 = parseCharToInt(num1);
        int N2 = parseCharToInt(num2);
        return intToCharArray(N1 + N2);
    }

    private static char[] subtractCharArrays(char[] num1, char[] num2) {

        int N1 = parseCharToInt(num1);
        int N2 = parseCharToInt(num2);
        return intToCharArray(N1 - N2);
    }

    private static int parseCharToInt(char[] num) {
        int result = 0;

        for (char c : num) {
            result = result * 10 + (c - '0');
        }
        return result;
    }

    private static char[] intToCharArray(int num) {
        if (num == 0) return new char[]{'0'};

        char[] temp = new char[10];

        int pos = 0;
        while (num > 0) {

            temp[pos++] = (char) (num % 10 + '0');
            num /= 10;
        }
        char[] result = new char[pos];

        for (int idx = 0; idx < pos; idx++) {
            result[idx] = temp[pos - idx - 1];
        }
        return result;
    }

    public void add() {

    }
}