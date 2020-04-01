import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class Employee extends Person {

        public Employee(){
            super();

        }
    /*
    int empno;
    String ename;
    String job;
    int mgr;
    String hiredate;
    int sal;
    int comm;
    int deptno;

    public Employee(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int dptno){
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

*/
   public HashMap getAllEmployees(Statement statement) throws SQLException {

        HashMap<String, Person> empMap = new HashMap<String, Person>();
        ResultSet query1 = statement.executeQuery("select * from emp");
        ResultSetMetaData meta = query1.getMetaData();
        int getColumnCount = meta.getColumnCount();

       while (query1.next()) {
           String results= "";
           for (int i = 1; i <= getColumnCount; i++) {
               //System.out.println(query1.getString(i));
               if(null == query1.getString(i)){
                   results+="null ";
               } else {
                   results += query1.getString(i) + " ";
               }
           }
           //System.out.println(results);
           Scanner scan = new Scanner(results);
           Person person = new Person(scan.next(), scan.next(), scan.next(),scan.next(),scan.next(),scan.next(),scan.next(),scan.next());
           empMap.put(person.empno,person);
       }
        return empMap;
    }

    public String getName(){
       return ename;
    }

}
