package _15ExamClasses.shelter;

public class Main {
    public static void main(String[] args) {


        SoftUni softUni = new SoftUni(7);

        Student student = new Student("Boryana", "Dimitrova", "JavaScript");
        Student studentTwo = new Student("Joana", "Jonkova", "Java");
        Student studentThree = new Student("Desislava", "Topuzakova", "FundamentalsInMathematics");
        Student studentFour = new Student("Alex", "Raykova", "Python");
        Student studentFive = new Student("Rosica", "Nenova", "C#");

        String adding = softUni.insert(student);

        System.out.println(adding);
        String adding1 = softUni.insert(studentTwo);
        System.out.println(adding1);
        softUni.insert(studentThree);
        softUni.insert(studentFour);

        String removal = softUni.remove(studentTwo);
        System.out.println(removal);
        String removal1 = softUni.remove(studentFive);
        System.out.println(removal1);

        System.out.println(softUni.getStudent("Alex", "Raykova"));
        System.out.println(softUni.getStatistics());

    }
}
