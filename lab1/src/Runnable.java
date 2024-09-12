public class Runnable {
    public static void main(String[] args) {

        Singer singer1 = new Singer();

        // Default values
        System.out.println("\n          Singer 1 information\n");
        System.out.println("Id: "+ singer1.getId());
        System.out.println("Name: "+ singer1.getName());
        System.out.println("Address: "+ singer1.getAddress());
        System.out.println("Date Of Birth: " + singer1.getBirthDate());
        System.out.println("Number of albums published: " + singer1.getAlbums());

        // setting the values
        singer1.setId(783);
        singer1.setName("Abdulrahman");
        singer1.setAddress("123 Main St E");
        singer1.setBirthDate("2000-04-03");
        singer1.setAlbums(5);

        // Displaying after setting new values
        System.out.println(" \n\n        Singer 2 information\n");
        System.out.println("Id: "+ singer1.getId());
        System.out.println("Name: "+ singer1.getName());
        System.out.println("Address: "+ singer1.getAddress());
        System.out.println("Date Of Birth: " + singer1.getBirthDate());
        System.out.println("Number of albums published: " + singer1.getAlbums());
    }
}
