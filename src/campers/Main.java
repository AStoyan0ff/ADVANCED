package campers;

public class Main {
    public static void main(String[] args) {

        //Initialize the repositories (Campsite)
        Campsite rila = new Campsite("Rila", 2);
        Campsite pirin = new Campsite("Pirin", 1);
        Campsite vitosha = new Campsite("Vitosha", 0);

//Initialize entities (Camper)
        Camper elena = new Camper("Elena", 30, 5, true, 80);
        Camper ivan = new Camper("Ivan", 25, 2, true, 50);
        Camper petar = new Camper("Petar", 20, 1, false, 20);
        Camper diana = new Camper("Diana", 28, 3, false, 100);
        Camper sofia = new Camper("Sofia", 35, 10, true, 200);
        Camper emil = new Camper("Emil", 40, 10, false, 150);

//Test addCamper
        System.out.println(rila.addCamper(elena));
        System.out.println(rila.addCamper(ivan));
        System.out.println(rila.addCamper(petar));
        System.out.println(pirin.addCamper(diana));
        System.out.println(pirin.addCamper(sofia));
        System.out.println(vitosha.addCamper(emil));

//Test removeCamper
        System.out.println(vitosha.removeCamper("Emilia"));
        System.out.println(vitosha.removeCamper("Diana"));

//Test getCamper
        System.out.println(rila.getCamper("Elena"));

//Test getCampersWithPersonalTents
        System.out.println(rila.getCampersWithPersonalTents());

//Test getMostExperiencedCamper
        System.out.println(pirin.getMostExperiencedCamper());

//Test getReport
        System.out.println(rila.getReport());
        System.out.println(pirin.getReport());
        System.out.println(vitosha.getReport());


// Camper Elena joined the campsite.
// Camper Ivan joined the campsite.
// Petar cannot afford to rent a tent
// Camper Diana joined the campsite.
//Camper Sofia joined the campsite.
// No available tents at Vitosha.
//false
//false
//Camper Elena is 30 years old with 5 camping trips.
//Campers with their own tents: Elena, Ivan
//Sofia has the most camping experience with 10 trips.
//Campsite Rila hosts the following campers:
//1. Elena with 5 camping trips.
//2. Ivan with 2 camping trips.
//Campsite Pirin hosts the following campers:
//1. Diana with 3 camping trips.
//2. Sofia with 10 camping trips.
//There are no campers at Vitosha.

    }
}
