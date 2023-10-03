import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DATA_BASE_CLASS{
        private String connector ="jdbc:mysql://localhost:3306/student_management_system";
    private String user_name ="root";
    private String password = "root";

    static Connection con;
    static Statement stm;
    String query;

    {
        try {
            con = DriverManager.getConnection(connector, user_name, password);
            stm = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void publicinsert(Student s) throws SQLException {
        String Insert_query = get_insert_query(s.id,s.number,s.name,s.address,s.Standard);
        int res = stm.executeUpdate(Insert_query);

    }
    public void get_student_info(Student s){
        String Get_query = get_info_query(s.id);
        try {
            ResultSet res = stm.executeQuery (Get_query);
            ResultSetMetaData metaData = res.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<String> columns = new ArrayList<>();
            for (int i = 1 ; i <= columnCount; i++) {
                columns.add(metaData.getColumnName(i));
                System.out.print(columns.get(i-1)+" ");
            }
            System.out.println();
            while(res.next()) {
                for(int i = 0; i< columns.size(); i++) {
                    System.out.print(res.getString(columns.get(i))+" ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update_student_name(Student s,String name ){
        String Update_query;
        Update_query = get_name_query(name,s.id);
                try {
                    int res = stm.executeUpdate(Update_query);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
    }
    public void update_student_class(Student s,int std ){
        String Update_query;
        Update_query = get_class_query(std,s.id);
        try {
            int res = stm.executeUpdate(Update_query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update_student_Phone(Student s,String phone ){
        String Update_query;
        Update_query = get_Phone_query(phone,s.id);
        try {
            int res = stm.executeUpdate(Update_query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update_student_address(Student s, String newAddress) {
        String Update_query;
        Update_query = get_Address_query(newAddress,s.id);
        try {
            int res = stm.executeUpdate(Update_query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove_one_student(Student a) {
        String Update_query;
        Update_query = get_remove_one_student_query(a.id);
        try {
            int res = stm.executeUpdate(Update_query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Delete_all_records() {
        String Update_query;
        Update_query = get_delete_all_student_query();
        try {
            int res = stm.executeUpdate(Update_query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String get_delete_all_student_query() {
        return "delete from register";
    }

    private String get_remove_one_student_query(int id) {
        return "delete from register where id = '"+id+"'";
    }

    private String get_Address_query(String newAddress, int id) {
        return "update register set address = '"+newAddress+"'where id ='"+id+"'";
    }

    private String get_Phone_query(String phone, int id) {
        return "update register set phone ='"+phone+"'where id = '"+id+"'";
    }


    private String get_class_query(int std, int id) {
        return "update register set standard = '"+std+"' where id = "+id+"";
    }

    private String get_name_query(String name, int  s) {
        return "update register set name = '"+name+"' where id = "+s+"";
    }

    private String get_info_query(int id) {
        return "select * from register where id ='"+id+"'";
    }

    private String get_insert_query(int id , String phone, String name , String address , int standard  ) {
        return "insert into register values('"+id+"','"+name+"','"+phone+"','"+address+"','"+standard+"')" ;
    }


    public void get_ALl_student_info() {
        String Get_query = get_all_student_query();
        try {
            ResultSet res = stm.executeQuery (Get_query);
            ResultSetMetaData metaData = res.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<String> columns = new ArrayList<>();
            for (int i = 1 ; i <= columnCount; i++) {
                columns.add(metaData.getColumnName(i));
                System.out.print(columns.get(i-1)+"   ");
            }
            System.out.println();
            while(res.next()) {
                for(int i = 0; i< columns.size(); i++) {
                    System.out.print(res.getString(columns.get(i))+"  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String get_all_student_query() {
        return "select * from register";
    }
}
