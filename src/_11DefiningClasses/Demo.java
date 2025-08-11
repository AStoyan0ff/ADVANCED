package _11DefiningClasses;



class Person {
    // послета -> характеристики на класа ( private ) - винаги
    // енкапсулация
    private String name;
    private int age;
    private String birthday;

    //методи -> описваме действията които може да се извършват
    // Ако не е static метода -> използва се само чрез обект
    public void print() {
        System.out.println("Hello");

    }

    // конструктор -> спец метод, който се използва за да се създават обекти от класа
    //Default constructor -> той се създава заедно с класа, празен обект от класа

    public Person()
    {}


    //GETTERS -> осигурява достъп до полетата

    public String getName() {
        return this.name;
    }

    public int getAge() { // достъп до полето 'age'
        return this.age; // връща стойноста на полето 'age'
    }

    public String getBirthday() {
        return this.birthday;
    }

    // SETTERS -> позволяват да задаваме стойност на полетата
    // set method

    public void setName(String name) {
        this.name = name; // this сочи към обекта (примерно p1)
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    // вграден метод toString() -> отпечатва обекта под формата на String
    // Default -> {package}.{class}@{address}
    // demo.Person@(адреса)

    @Override // -> пренаписване на метода
    public String toString() { // аз описвам какво да отпечата (Не по default)
        return this.name + " " + this.age + " " + this.birthday;
    }

    // hashCode ->  връща хеш кода на обека (цяло число) уникален идентификатор
    // Маове, Сетове и т.н
    // equals() -> сръвнение на обектите (true, false)


}


