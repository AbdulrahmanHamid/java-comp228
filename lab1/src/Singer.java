public class Singer {
    // Declaring
    private int id;
    private String name;
    private String address;
    private String birthDate;
    private int albums;

    // Constructors
    // 0 argument
    public Singer() {
    }

    // 1 argument
    public Singer(int id) {
        this.id = id;
    }

    // 2 arguments
    public Singer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 3 arguments
    public Singer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // 4 arguments
    public Singer(int id, String name, String address, String birthDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }

    // 5 arguments
    public Singer(int id, String name, String address, String birthDate, int albums) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.albums = albums;
    }

    //Setters
    public void setId(int id) {this.id = id;}
    public void setName(String name){this.name = name;}
    public void setAddress(String address){this.address = address;}
    public void setBirthDate(String birthDate){this.birthDate = birthDate;}
    public void setAlbums(int albums){this.albums = albums;}
    // one setter that allow to set all the values
    public void setAll(int id, String name, String address, String birthDate, int albums){
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.albums = albums;
    }

    // Getter
    public int getId() {return id;}
    public String getName() {return name;}
    public String getAddress() {return address;}
    public String getBirthDate() {return birthDate;}
    public int getAlbums() {return albums;}



}
