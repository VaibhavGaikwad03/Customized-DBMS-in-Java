import java.lang.*;
import java.util.*;

class Student
{
    public int RID;
    public String Name;
    public int Salary;

    private static int Generator;
    static
    {
        Generator = 0;
    }

    public Student(String str, int value)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
    }
/*
##############################################################################
##
##  Function name : DisplayData 
##  Input : None
##  Output : None
##  Description : It displays data of table(RID, Name, Salary)
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void DisplayData()
    {
        System.out.println("|\t"+this.RID+"\t|"+"\t"+this.Name+"\t|"+"\t"+this.Salary+"\t|");
    }
}

class DBMS
{
    public LinkedList<Student>lobj;

    public DBMS()
    {
        lobj = new LinkedList<>();
    }
/*
##############################################################################
##
##  Function name : StartDBMS
##  Input : None
##  Output : None
##  Description : It starts the DBMS
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void StartDBMS()
    {
        Scanner scanobj = new Scanner(System.in);

        System.out.println("Customized DBMS started successfully...");
        String Query = "";
        while(true)
        {
            System.out.print("Customized DBMS console > ");
            Query = scanobj.nextLine();
            Query.toLowerCase();

            String tokens[] = Query.split(" ");
            int QuerySize = tokens.length;

            if(QuerySize == 1)
            {
                if("help".equals(tokens[0]))
                {
                    System.out.println("This application is used to demonstrates the customized DBMS\n");
                    System.out.println("insert into student Name Salary : insert data");
                    System.out.println("select count() from student : Display count of the students in the table");
                    System.out.println("select * from  student : Display all data from student table");
                    System.out.println("select * from student where rid = student_rid : Display information of the student of that specific rid from student table");
                    System.out.println("select * from student where name = student_name : Display information of the student of that specific name from student table");
                    System.out.println("select * from student where salary = student_salary : Display information of the student of that specific salary from student table");
                    System.out.println("select * from student where salary = maximum : Display information of the student having maximum salary from student table");
                    System.out.println("select * from student where salary = minimum : Display information of the student having minimum salary from student table");
                    System.out.println("select sum(salary) as total salary from student : Display summation of salary of all students from student table");
                    System.out.println("select avg(salary) as avg salary from student : Display average salary of all students from student table");
                    System.out.println("delete from student where rid = student_rid : Delete information of the student of that specific rid from student table");
                    System.out.println("delete from student where name = student_name : Delete information of the student of that specific name from student table");
                    System.out.println("exit : Terminate DBMS\n");
                }
                else if("exit".equals(tokens[0]))
                {
                    System.out.println("Thank you for using Marvellous DBMS");
                    break;
                }
                else
                {
                    System.out.println("Invalid query !!!");
                }
            }
            if(QuerySize == 2)
            {
                System.out.println("Invalid query !!!");
            }

            if(QuerySize == 3)
            {
                System.out.println("Invalid query !!!");
            }

            if(QuerySize == 4)
            {
                if("select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        if("from".equals(tokens[2]))
                        {
                            if("student".equals(tokens[3]))
                            {   
                                DisplayAll();
                            }
                            else
                            {
                                System.out.println("Invalid query !!!");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid query !!!");
                        }
                    }
                    else if("count()".equals(tokens[1]))
                    {
                        if("from".equals(tokens[2]))
                        {
                            if("student".equals(tokens[3]))
                            {
                                AggregateCount();
                            }
                            else
                            {
                                System.out.println("Invalid query !!!");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid query !!!");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid query !!!");
                    }
                }
                else
                {
                    System.out.println("Invalid query !!!");
                }
            }
            if(QuerySize == 5)
            {
                if("insert".equals(tokens[0]))
                {
                    if("into".equals(tokens[1]))
                    {
                        if("student".equals(tokens[2]))
                        {
                            InsertData(tokens[3], Integer.parseInt(tokens[4]));
                            System.out.println("Data inserted successfully");
                        }
                        else
                        {
                            System.out.println("Invalid query !!!");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid query !!!");
                    }
                }
                else
                {
                    System.out.println("Invalid query !!!");
                }
            }

            if(QuerySize == 6)
            {
                System.out.println("Invalid query !!!");   
            }

            if(QuerySize == 7)
            {
                if("delete".equals(tokens[0]))
                {
                    if("from".equals(tokens[1]))
                    {
                        if("student".equals(tokens[2]))
                        {
                            if("where".equals(tokens[3]))
                            {
                                if("name".equals(tokens[4]))
                                {
                                    if("=".equals(tokens[5]))
                                    {
                                        DeleteSpecific(tokens[6]);
                                        System.out.println("Data deleted successfully");
                                    }
                                    else
                                    {
                                        System.out.println("Invalid query !!!");
                                    }
                                }
                                else if("rid".equals(tokens[4]))
                                {
                                    if("=".equals(tokens[5]))
                                    {
                                        DeleteSpecific(Integer.parseInt(tokens[6]));
                                        System.out.println("Data deleted successfully");
                                    }
                                    else
                                    {
                                        System.out.println("Invalid query !!!");
                                    }
                                }
                                else
                                {
                                    System.out.println("Invalid query !!!");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid query !!!");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid query !!!");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid query !!!");
                    }
                }
                else if("select".equals(tokens[0]))
                {
                    if("sum(salary)".equals(tokens[1]))
                    {
                        if("as".equals(tokens[2]))
                        {
                            if("total".equals(tokens[3]))
                            {
                                if("salary".equals(tokens[4]))
                                {
                                    if("from".equals(tokens[5]))
                                    {
                                        if("student".equals(tokens[6]))
                                        {
                                            AggregateSum();
                                        }
                                        else
                                        {
                                            System.out.println("Invalid query !!!");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Invalid query !!!");
                                    }
                                }
                                else
                                {
                                    System.out.println("Invalid query !!!");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid query !!!");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid query !!!");
                        }
                    }
                    else if("avg(salary)".equals(tokens[1]))
                    {
                        if("as".equals(tokens[2]))
                        {
                            if("avg".equals(tokens[3]))
                            {
                                if("salary".equals(tokens[4]))
                                {
                                    if("from".equals(tokens[5]))
                                    {
                                        if("student".equals(tokens[6]))
                                        {
                                            AggregateAvg();
                                        }
                                        else
                                        {
                                            System.out.println("Invalid query !!!");
                                        }
                                    }
                                    else
                                    {

                                    }
                                }
                                else
                                {
                                    System.out.println("Invalid query !!!");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid query !!!");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid query !!!");
                        }
                    }
                    else 
                    {
                        System.out.println("Invalid query !!!");
                    }
                }
                else
                {
                    System.out.println("Invalid query !!!");
                }
            }

            if(QuerySize == 8)
            {
                if("select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        if("from".equals(tokens[2]))
                        {
                            if("student".equals(tokens[3]))
                            {   
                                if("where".equals(tokens[4]))
                                {
                                    if("rid".equals(tokens[5]))
                                    {
                                        if("=".equals(tokens[6]))
                                        {
                                            DisplaySpecific(Integer.parseInt(tokens[7]));
                                        }
                                        else
                                        {
                                            System.out.println("Invalid query !!!");
                                        }
                                    }
                                    else if("name".equals(tokens[5]))
                                    {
                                        if("=".equals(tokens[6]))
                                        {
                                            DisplaySpecific(tokens[7]);
                                        }
                                        else
                                        {
                                            System.out.println("Invalid query !!!");
                                        }
                                    }
                                    else if("salary".equals(tokens[5]))
                                    {
                                        if("=".equals(tokens[6]))
                                        {
                                            if("maximum".equals(tokens[7]))
                                            {
                                                AggregateMax();
                                            }
                                            else if("minimum".equals(tokens[7]))
                                            {
                                                AggregateMin();
                                            }
                                            else if("=".equals(tokens[6]))
                                            {
                                                DisplaySpecificX(Integer.parseInt(tokens[7]));
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Invalid query !!!");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Invalid query !!!");
                                    }
                                }
                                else
                                {
                                    System.out.println("Invalid query !!!");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid query !!!");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid query !!!");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid query !!!");
                    }
                }
                else
                {
                    System.out.println("Invalid query !!!");
                }
            }
        }
    }
/* 
##############################################################################
##
##  Function name : InsertData
##  Input : String, int
##  Output : None
##  Description : Insert the data into the table
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void InsertData(String str, int value)
    {
        Student sobj = new Student(str, value);
        lobj.add(sobj);
    }
/* 
##############################################################################
##
##  Function name : DisplayAll
##  Input : None
##  Output : None
##  Description : Calls the function DisplayData() which is used to Display data(RID, Name, Salary)
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void DisplayAll()
    {
        System.out.println("-------------------------------------------------");
        System.out.println("|\tRID\t|\tName\t|\tSalary\t|");
        System.out.println("-------------------------------------------------");
        for(Student sref : lobj)
        {
            sref.DisplayData();
        }
        System.out.println("-------------------------------------------------");
    }
/* 
##############################################################################
##
##  Function name : DisplaySpecific
##  Input : int
##  Output : None
##  Description : It is used to display specific data(RID)
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void DisplaySpecific(int rid)
    {
        System.out.println("-------------------------------------------------");
        System.out.println("|\tRID\t|\tName\t|\tSalary\t|");
        System.out.println("-------------------------------------------------");
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.DisplayData();
                break;
            }
        }
        System.out.println("-------------------------------------------------");
    }

/* 
##############################################################################
##
##  Function name : DisplaySpecific
##  Input : String
##  Output : None
##  Description : It is used to display specific data(Name)
##  Author : Vaibhav Gaikwad
##  Date :15-07-2022
##
##############################################################################
*/

    public void DisplaySpecific(String str)
    {
        System.out.println("-------------------------------------------------");
        System.out.println("|\tRID\t|\tName\t|\tSalary\t|");
        System.out.println("-------------------------------------------------");
        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.DisplayData();
            }
        }
        System.out.println("-------------------------------------------------");
    }

/* 
##############################################################################
##
##  Function name : DisplaySpecificX
##  Input : String
##  Output : None
##  Description : It is used to display specific data(Salary)
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void DisplaySpecificX(int salary)
    {
        System.out.println("-------------------------------------------------");
        System.out.println("|\tRID\t|\tName\t|\tSalary\t|");
        System.out.println("-------------------------------------------------");
        for(Student sref : lobj)
        {
            if(sref.Salary == salary)
            {
                sref.DisplayData();
            }
        }
        System.out.println("-------------------------------------------------");
    }

/* 
##############################################################################
##
##  Function name : DeleteSpecific
##  Input : int
##  Output : None
##  Description : It is used to delete specific data using(RID)
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void DeleteSpecific(int rid)
    {
        int index = 0;
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

/* 
##############################################################################
##
##  Function name : DeleteSpecific
##  Input : String
##  Output : None
##  Description : It is used to delete specific data using(Name)
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void DeleteSpecific(String str)
    {
        int index = 0;
        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

/* 
##############################################################################
##
##  Function name : AggregateMax
##  Input : None
##  Output : None
##  Description : It is used to display maximum salary from the table
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void AggregateMax()
    {
        int iMax = 0;
        Student temp = null;

        for(Student sref : lobj)
        {
            if(sref.Salary > iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }
        System.out.println("Information of student having maximum salary : ");
        System.out.println("-------------------------------------------------");
        System.out.println("|\tRID\t|\tName\t|\tSalary\t|");
        System.out.println("-------------------------------------------------");
        temp.DisplayData();
        System.out.println("-------------------------------------------------");
    }

/* 
##############################################################################
##
##  Function name : AggregateMin
##  Input : None
##  Output : None
##  Description : It is used to display minimum salary from the table
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void AggregateMin()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }
        System.out.println("Information of student having minimum salary : ");
        System.out.println("-------------------------------------------------");
        System.out.println("|\tRID\t|\tName\t|\tSalary\t|");
        System.out.println("-------------------------------------------------");
        temp.DisplayData();
        System.out.println("-------------------------------------------------");
    }

/* 
##############################################################################
##
##  Function name : AggregateSum
##  Input : None
##  Output : None
##  Description : It is used to add salary of all students
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void AggregateSum()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }
        System.out.println("Summation of salaries is : "+iSum);
    }

/* 
##############################################################################
##
##  Function name : AggregateAvg
##  Input : None
##  Output : None
##  Description : It is used to display average salary from the table
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void AggregateAvg()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }
        System.out.println("Average salary is : "+iSum/(lobj.size()));
    }

/* 
##############################################################################
##
##  Function name : AggregateCount
##  Input : None
##  Output : None
##  Description : It is used to display count of the students from the table
##  Author : Vaibhav Gaikwad
##  Date : 15-07-2022
##
##############################################################################
*/

    public void AggregateCount()
    {
        System.out.println("Count is : "+lobj.size());
    }
}

class Customized_DBMS
{
    public static void main(String arg[])
    {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();
    }
}