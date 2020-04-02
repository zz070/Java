import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Mysql {
    static String driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/tongxun?useSSL=false&characterEncoding=utf8";
    //?useSSL=false&characterEncoding=utf8&&useSSL=true
    static String use="root";
    static String password="12345";
    static Connection conn;

    //选择菜单
    public static void menu() {
        System.out.println("*****************************************************************");
        System.out.println("******************                 通讯录系统                ******************");
        System.out.println("******************            1、   增加联系人            ******************");
        System.out.println("******************            2、   修改联系人            ******************");
        System.out.println("******************            3、   删除联系人            ******************");
        System.out.println("******************            4、   显示联系人            ******************");
        System.out.println("******************            5、   查找联系人            ******************");
        System.out.println("******************            6、   排序并显示联系人      ***************");
        System.out.println("******************            7、   退出                         ******************");
        System.out.println("******************************************************************\n");
        System.out.print("请输入你想要进行的操作  >     ");
    }


    //添加联系人
    public static void add() throws Exception {
        System.out.println("\n添加联系人\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入姓名   >     ");
        String name = sc.next();
        System.out.print("请输入号码   >     ");
        String phoneNumber = sc.next();
        System.out.print("请输入邮箱编码   >     ");
        String postalCode = sc.next();
        System.out.print("请输入地址   >     ");
        String address = sc.next();
        System.out.print("请输入电子邮箱   >     ");
        String email = sc.next();
        System.out.print("请输入家庭号码   >     ");
        String homePhone = sc.next();
        Statement state = conn.createStatement();
        String sql = "insert into tong values (\"" +name+"\",\""+phoneNumber+" \",\""+postalCode+"\",\""+address+"\",\""+email+"\",\""+homePhone+"\")";
        System.out.println("sql 语法: " + sql);
        state.execute(sql);
    }

    //是否继续添加
    public static void addAgain()throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("\n是否继续添加（继续请输入1，不添加请输入0）\n");
        boolean choice = true;
        while(choice) {
            int select = sc.nextInt();
            if (select==1) {
                add();
                addAgain();
            } else if (select == 0) {
                choice=false;
                System.out.println("添加结束");
                break;
            } else {
                System.out.println("输入错误,请重新输入！");
            }
        }
    }

    //修改联系人
    public static void update() throws Exception {
        System.out.println("\n修改联系人\n");
        Statement state = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要修改联系人的姓名   >     ");
        String name = sc.next();
        ResultSet rs = state.executeQuery("SELECT  * FROM tong where Name = \"" + name + "\"");
        if (rs.next() ) {
            System.out.print("请输入修改后的号码   >     ");
            String phonenumber = sc.next();
            System.out.print("请输入修改后的邮政编码   >     ");
            String postalCode = sc.next();
            System.out.print("请输入修改后的地址   >     ");
            String address = sc.next();
            System.out.print("请输入修改后的电子邮箱   >     ");
            String email = sc.next();
            System.out.print("请输入修改后的家庭电话   >     ");
            long homePhone = sc.nextInt();
            System.out.println("修改完成！");
            String sql = "update tong set Name = \"" + name + "\", PhoneNumber = \"" + phonenumber + "\" ," +
                    "PostalCode = \"" + postalCode + "\", Address = \"" + address + "\", Email = \"" + email + "\"," +
                    "HomePhone = \"" + homePhone + "\" where Name = \"" + name + "\" ";
            System.out.println("sql 语法: " + sql);
            state.execute(sql);
            System.out.println("修改成功！\n");
        } else {
            System.out.println("通讯录中此人不存在，修改失败！");
        }
    }

    //删除联系人
    public static void delete() throws Exception {
        System.out.println("\n删除联系人\n");
        Scanner sc = new Scanner(System.in);
        Statement state = conn.createStatement();
        System.out.print("输入需要删除联系人的姓名  >   ");
        String name = sc.next();
        ResultSet rs = state.executeQuery( "select  * from tong where Name = \""+name+"\"");
        if(rs.next()){
            String sql = "delete from tong where Name = \"" + name + "\"";
            System.out.println("sql语法：" + sql);
            state.execute(sql);
            System.out.println("删除成功！\n");
        }else {
            System.out.println("此人不在通讯录中，删除失败");
        }
    }

    //查找联系人
    public static void find() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你要查找的联系人的姓名  >   ");
        String name = sc.next();
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("SELECT  * FROM tong where Name = \""+name+"\"");
        if(rs.next()){
            System.out.println("**************************");
            System.out.println("姓名  >  " + rs.getObject("Name"));
            System.out.println("电话  >   " + rs.getObject("PhoneNumber"));
            System.out.println("邮政编码  >  " + rs.getObject("PostalCode"));
            System.out.println("地址  >  " + rs.getObject("Address"));
            System.out.println("电子邮箱  >  " + rs.getObject("Email"));
            System.out.println("家庭电话  >  " + rs.getObject("HomePhone"));
            System.out.println("**************************");
        }else{
            System.out.println("查无此人！");
        }
    }

    //排序联系人并显示
    public static void sort()throws Exception{
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("SELECT  * FROM tong  order by PostalCode;");
        System.out.println("排序成功，显示排序后联系人！");
        //如果有数据，rs.next()返回true
        System.out.println("***********************************************************************************************************************");
        while(rs.next()){
            System.out.print("邮政编码：" +rs.getObject("PostalCode")+"  ") ;
            System.out.print("姓名 ：" +rs.getObject("Name")+"  ") ;
            System.out.print("电话 ：" +rs.getObject("PhoneNumber")+"  ") ;
            System.out.print("地址：" +rs.getObject("Address")+"  ") ;
            System.out.print("电子邮箱：" +rs.getObject("Email")+"  ") ;
            System.out.println("家庭电话：" +rs.getObject("HomePhone")+"  ");
        }
        System.out.println("***********************************************************************************************************************");
        System.out.println("成功显示数据!");
    }

    //显示联系人
    public static void show()  throws Exception {
        System.out.println("显示联系人");
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("SELECT  * FROM tong ;");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println("***********************************************************************************************************************");
            while(rs.next()){
                System.out.print("姓名 ：" +rs.getObject("Name")+"  ") ;
                System.out.print("电话 ：" +rs.getObject("PhoneNumber")+"  ") ;
                System.out.print("邮政编码：" +rs.getObject("PostalCode")+"  ") ;
                System.out.print("地址：" +rs.getObject("Address")+"  ") ;
                System.out.print("电子邮箱：" +rs.getObject("Email")+"  ") ;
                System.out.println("家庭电话：" +rs.getObject("HomePhone")+"  ");
            }
            System.out.println("***********************************************************************************************************************");
        }
        System.out.println("数据显示结束!");
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        boolean choice = true;
        //1.加载驱动程序
        Class.forName(driver);
        //2. 获得数据库连接
        conn = DriverManager.getConnection(url,use,password);

        while (choice) {
            menu();
            int a = sc.nextInt();
            switch(a) {
                case 1:
                    add();     // 添加联系人
                    addAgain();
                    break;
                case 2:
                    update();    //修改联系人
                    break;
                case 3:
                    delete();     //删除联系人
                    break;
                case 4:
                    show();      //显示联系人
                    break;
                case 5:
                    find();      //查找联系人
                    break;
                case 6:
                    sort();       //排序并显示联系人
                    break;
                case 7:
                    choice = false;    //跳出循环，退出
                    System.out.println("退出！");
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }
}