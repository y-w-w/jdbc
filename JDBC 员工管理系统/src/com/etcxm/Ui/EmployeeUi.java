package com.etcxm.Ui;


import java.util.ArrayList;
import java.util.Scanner;

import com.etcxm.Dao.EmployeeDao;
import com.etcxm.Dao.JDBCUtils;
import com.etcxm.enmo.Employee;

public class EmployeeUi {
      private EmployeeDao  em=new EmployeeDao();
	
	private Employee inputEmployee()
    {
  	  Scanner sc=new Scanner(System.in);
  	  System.out.println("请输入员工号码:");
  	   int enumber=sc.nextInt();
  	   System.out.println("请输入员工职位:");
  	   String ejob=sc.next(); 
  	   System.out.println("请输入员工姓名:");
  	   String ename=sc.next();
  	   System.out.println("请输入员工性别:");
  	   String esex=sc.next();
  	   System.out.println("请输入员工工资:");
  	   double esalary=sc.nextDouble();
  	    Employee e = new Employee(enumber,ejob,ename,esex,esalary);
  	    return e;
    }
	private void addEmployee() throws Exception
	{
		 while (true) {
			 em.addEmployeeDao(inputEmployee());
			System.out.println("请输入y-继续/非y-退出");
			Scanner sc=new Scanner(System.in);
			 String input=sc.next();
			if(!input.equals("y"))
			{
				break;
			}
		}
	}
	private void changeEmployee() throws Exception
	{
		while (true) {
			em.changeEmployeeDao(inputEmployee());
			Scanner sc=new Scanner(System.in);
			 System.out.println("请输入y-继续/非y-退出");
			 String input=sc.next();
			if(!input.equals("y"))
			{
				break;
			}
		}
	}
	private void deleteEmployee() throws Exception
	{
		while (true) {
			em.deleteEmployeeDao();
			Scanner sc=new Scanner(System.in);
			 System.out.println("请输入y-继续/非y-退出");
			 String input=sc.next();
			if(!input.equals("y"))
			{
				break;
			}
		}
		
	}
	private void showsimpleEmployee() throws Exception
	{
		while (true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入查询的enumber:");
			 int enumber=sc.nextInt();
			em.showasimpleEmployeeDao(enumber);
			 System.out.println("请输入y-继续/非y-退出");
			 String input=sc.next(); 
			if(!input.equals("y"))
			{
				break;
			}
		}
	}
    
     

      public void mainInterface() throws Exception
      {   
    	  while (true) {
			System.out.println("------1.添加员工------");
			System.out.println("------2.更改员工信息------");
			System.out.println("------3.删除员工------");
			System.out.println("------4.显示某个员工------");
			System.out.println("------5.显示所有员工------");
			System.out.println("------6.退出------");
			System.out.println("请选择:");
			Scanner sc = new Scanner(System.in);
			int res = sc.nextInt();
			switch (res) {
				case 1:addEmployee();
				  
				break;
			case 2:
				changeEmployee();
				break;
			case 3:
				deleteEmployee();
				break;
			case 4:
				showsimpleEmployee();
				break;
			case 5:
				em.showallEmployeeDao();
				break;
			case 6:
				System.out.println("程序退出");
				System.exit(0);
				break;

			default:
				break;
			}
		}
      }
      
}
