public class Student {
    int id ;
    int Standard ;
    String number;
     String name ;
     String address;
    public Student(int i , int s , String n, String num , String add){
        this.id = i ;
        this.Standard = s ;
        this.name = n;
        this.number = num;
        this.address = add;
    }
    public void Update_name(String name ){
        this.name = name;
    }

    public void Update_class(int newClass) {
        this.Standard = newClass;
    }

    public void Update_number(String newNumber) {
        this.number = newNumber;
    }

    public void Update_Address(String newAddress) {
        this.address= newAddress;
    }
}
