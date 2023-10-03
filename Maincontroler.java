import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;


public class Maincontroler {
    List <Student> list = new ArrayList<Student>();
    List <Integer> Student_Scholar = new ArrayList<>();
    static int id = 1;
    public void start() {
        System.out.println("You are in the Student System Enter your choice");
        int a = 0 ;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("Enter 1. for Creating new Student\n"+"Enter 2. for Get Student info.\n"+"Enter 3. for Get all Student info.\n"+"Enter 4. for Update Student info.\n"+"Enter 5. for delete one Student info.\n"+"Enter 6. for deleting all Student info.\n"+"Enter 7. for Exit.\n");
            a = sc.nextInt();
            switch(a){
                case 1 : System.out.println("CREATE ");
                        boolean check = create();
                        if(check){
                            int scollar = id-1;
                            System.out.println("Student recorded successfully for Scholar no [ "+ scollar +" ]");
                        }else {
                            System.out.println("Cannot create the student ");
                        }

                        break;
                case 2 : System.out.println(" GET INFO ");
                        getInfo();
                        break;
                case 3 : System.out.println(" GET ALL INFO ");
                         getALLInfo();
                         break;
                case 4 : System.out.println("UPDATE ");
                        update();
                        break;
                case 5 : System.out.println("DELETE ONE ");
                        delete_one();
                        break;
                case 6 : System.out.println("DELETE ALL ");
                        delete_all();
                        break;
                case 7 : System.out.println("Exit ");
                        System.exit(0);
                default:
                    System.out.println("YOU enterd an invalid input , try again ");
                    break;
            }
        }

    }

    private void getALLInfo() {
        System.out.print("Registered students scholar are : \n [ ");
        for(int scholar_id : Student_Scholar){
            System.out.print(scholar_id+" ");
        }
        if(list.size()==0){
            System.out.println("No Student in the record" +
                    " ]");
            return;
        }
        System.out.print("]\n");
        DATA_BASE_CLASS D1 = new DATA_BASE_CLASS();
        D1.get_ALl_student_info();


    }

    private void delete_all() {
        list.clear();
        Student_Scholar.clear();
        DATA_BASE_CLASS D1 = new DATA_BASE_CLASS();
        D1.Delete_all_records();
        System.out.println("all student records was successfully removed ");
    }

    private void delete_one() {
        System.out.print("Registered students scholar are : \n [ ");
        for(int scholar_id : Student_Scholar){
            System.out.print(scholar_id+" ");
        }
        if(list.size()==0){
            System.out.println("No Student in the record" +
                    " ]");
            return;
        }
        System.out.print("]\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Scholar you want to remove ");
        int Scholar_to_remove = sc.nextInt();
        if(Student_Scholar.contains(Scholar_to_remove)){
            System.out.println("Removed student is :");
            Student a = list.get(Student_Scholar.indexOf(Scholar_to_remove));
            DATA_BASE_CLASS D1 = new DATA_BASE_CLASS();
            D1.remove_one_student(a);
            System.out.println("********");
            System.out.println("Details of scholar no  "+a.id);
            System.out.println("class  : "+a.Standard);
            System.out.println("Name  : "+ a.name);
            System.out.println("Phone number : "+a.number);
            System.out.println("Address : "+a.address);
            System.out.println("******** \n");
            list.remove(Student_Scholar.indexOf(Scholar_to_remove));
            Student_Scholar.remove(Student_Scholar.indexOf(Scholar_to_remove));
            System.out.println("Student removed Successfully");
        }
    }

    private void update() {
        int a = 0 ;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        DATA_BASE_CLASS D1 = new DATA_BASE_CLASS();
        System.out.print("Registered students scholar are : \n [ ");
        for(int scholar_id : Student_Scholar){
            System.out.print(scholar_id+" ");
        }
        System.out.print("]\n");

        while(flag){
            System.out.println("Enter the scholar number to edit :");
            a = sc.nextInt();
            if(a<=Student_Scholar.get(Student_Scholar.size()-1) && a>=0){
                Student s = list.get(Student_Scholar.indexOf(a));
                int c = 0 ;
                System.out.println("1.   for name \n 2.     for class \n 3.     for phone \n 4.     for address \n 5.   for exit");
                c = sc.nextInt();
                sc.nextLine();
                switch(c){
                    case 1 :    System.out.println("your Current name is :"+s.name);
                                System.out.println("Enter new name ");
                                String name = sc.nextLine();
                                s.Update_name(name);
                                D1.update_student_name(s,name);
                                System.out.println("Updated name is :"+s.name);
                                break;
                    case 2 :    System.out.println("your Current Class is :"+s.Standard);
                                System.out.println("Enter new class ");
                                 int New_class = getclass();
                                s.Update_class(New_class);
                                D1.update_student_class(s,New_class);
                                System.out.println("Updated Class is :"+s.Standard);
                                break;
                    case 3 :    System.out.println("your Current Mobile no is :"+s.number);
                                System.out.println("Enter new Number ");
                                String New_Number = sc.nextLine();
                                s.Update_number(New_Number);
                                D1.update_student_Phone(s,New_Number);
                                System.out.println("Updated Class is :"+s.number);
                                break;
                    case 4 :    System.out.println("your Current Address is :"+s.address);
                                System.out.println("Enter new Address ");
                                String New_address = sc.nextLine();
                                s.Update_Address(New_address);
                                D1.update_student_address(s,New_address);
                                System.out.println("Updated Class is :"+s.address);
                                break;
                    case 5 :    break;
                    default:    System.out.println("Enter a valid choice ");
                                break;
                }
                break;
            }else{
                System.out.println("Invalid input not in the range");
            }
        }
    }

    private void getInfo() {
        System.out.print("Registered students scholar are : \n [ ");
        for(int scholar_id : Student_Scholar){
            System.out.print(scholar_id+" ");
        }
        if(list.size()==0){
            System.out.println("No Student in the record" +
                    " ]");
            return;
        }
        System.out.print("]\n");
        Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("Enter the Scholar number of student :");
                int num = sc.nextInt();
                if(Student_Scholar.contains(num)){
                    Student a = list.get(Student_Scholar.indexOf(num));
//                    System.out.println("********");
//                    System.out.println("Details of scholar no  "+a.id);
//                    System.out.println("class  : "+a.Standard);
//                    System.out.println("Name  : "+ a.name);
//                    System.out.println("Phone number : "+a.number);
//                    System.out.println("Address : "+a.address);
//                    System.out.println("******** \n");
                    DATA_BASE_CLASS D1 = new DATA_BASE_CLASS();
                    D1.get_student_info(a);
                    break;
                }else {
                    System.out.println("Scholar not found try again ");
                }
            }
    }

    private boolean create() {
        Scanner sc = new Scanner(System.in);
        String name; String standard ; String number ; String address;
        System.out.println("enter name ");
        name = sc.nextLine();
        System.out.println("enter phone number");
        number = sc.nextLine();
        System.out.println("Enter the address");
//        sc.nextLine();
        address = sc.nextLine();
        System.out.println("enter class in numbers 1-12");
        int std = getclass();

        Student s = new Student(id++,std,name,number,address);
        DATA_BASE_CLASS D1 = new DATA_BASE_CLASS();
        boolean temp;
        try {
            D1.publicinsert(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        list.add(s);
        Student_Scholar.add(id-1);
        return true;
    }

    private int getclass() {
        String standard;
        Scanner sc = new Scanner(System.in);
        int std=0;
        while(true){
            standard = sc.nextLine();
            char arr [] = standard.toCharArray();
            if(arr.length == 1 ){
                if(arr[0]-'0'<=9 && arr[0]-'0'>=1){
                    std = arr[0]-'0';
                    break;
                }else{
                    System.out.println("Invalid input try again : ");
                }
            }else if (arr.length == 2 ) {
                if ((arr[0]-'0'<=9 && arr[0]-'0'>=0) && (arr[1]-'0'<=9 && arr[1]-'0'>=0)) {
                    int i =0 ;
                    std=0;
                    while(i<arr.length){
                        std = std * 10 + arr[i]-'0';
                        i++;
//                        System.out.println(std);
                    }
                    if(std <=12 ){
                        break;
                    }else{
                        System.out.println("Invalid input try again : ");
                    }
                }else{
                    System.out.println("Invalid input try again : ");
                }
            }else{
                System.out.println("Invalid input try again : ");
            }

        }
        return std;
    }


}
