<h1 align="center">
  ☕ Java Advanced – Основни концепции  
  <br>
  <img src="https://media.giphy.com/media/du3J3cXyzhj75IOgvA/giphy.gif" width="80">
</h1>

📚 **`Java Advanced` надгражда основите на програмирането и се фокусира върху структури от данни, функционално програмиране и по-ефективно боравене с паметта.**  

---

## 🔑 Основни теми в Java Advanced:

---

### <span style="background:#0078d7; color:white; padding:4px 8px; border-radius:6px;"> 1️⃣ Generics</span>

✔ **Позволяват създаване на класове и методи, които работят с различни типове данни.**
✔ **Предпазват от грешки при преобразуване на типове.**
✔ **Цел: Писане на гъвкав и типово безопасен код.**

✅ *Пример:*

```java
public class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
Box<String> box = new Box<>();
box.setValue("Hello");
System.out.println(box.getValue());
```
---

### <span style="background:#0078d7; color:white; padding:4px 8px; border-radius:6px;"> 2️⃣ Iterators & Comparators</span>

✔ **Итератори обхождат колекции по безопасен начин.**
✔ **Компараторите позволяват персонализирано сортиране на обекти.**
✔ **Цел: Лесно обхождане и сортиране на колекции.**

✅ *Пример:*

```java
List<String> names = Arrays.asList("Andrey", "Vicky", "Nevena");

Collections.sort(names, (a, b) -> a.compareTo(b));
names.forEach(System.out::println);
```

---

### <span style="background:#0078d7; color:white; padding:4px 8px; border-radius:6px;"> 3️⃣ Functional Programming</span>

✔ **Използва ламбда изрази и потоци (Streams) за по-декларативен стил.**
✔ **Осигурява по-кратък и четим код.**
✔ **Цел: Обработка на данни по функционален начин.**

✅ *Пример:*

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

int sum = numbers.stream()
                 .filter(n -> n % 2 == 0)
                 .mapToInt(Integer::intValue)
                 .sum();

System.out.println("Sum of even numbers: " + sum);
```

---

### <span style="background:#0078d7; color:white; padding:4px 8px; border-radius:6px;"> 4️⃣ Multidimensional Arrays & Collections</span>

✔ **Работа с матрици и вложени колекции (List, Set, Map).**
✔ **Използват се за решаване на задачи с по-сложни структури от данни.**
✔ **Цел: Ефективно съхранение и обработка на данни.**

✅ *Пример:*

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

for (int[] row : matrix) {
    for (int num : row) {
        System.out.print(num + " ");
    }
    System.out.println();
}
```
