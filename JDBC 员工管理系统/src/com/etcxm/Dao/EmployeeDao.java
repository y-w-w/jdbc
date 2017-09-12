package com.etcxm.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.etcxm.enmo.Employee;

public class EmployeeDao {
      
      private JDBCUtils uti =new JDBCUtils();
      
      
      
      public EmployeeDao() {
		super();
		// TODO Auto-generated constructor stub
		uti.getConnection();
	}
	//添加员工
      public void addEmployeeDao(Employee e) throws Exception
      {
    	  if(e==null)
    	  {
    		  System.out.println("输入不能为空");
    		  return;
    	  }
    	  if(showasimpleEmployeeDao(e.getEnumber())!=null)
    	  {
    		  System.out.println("此员工已存在");
    	  }else
    	  {   String sql="INSERT t_employee() VALUES(?,?,?,?,?)";
    	  ArrayList<Object> params = new ArrayList<Object>();
    	  params.add(e.getEnumber());
    	  params.add(e.getEjob());
    	  params.add(e.getEname());
    	  params.add(e.getEsex());
    	  params.add(e.getEsalary());
    		 boolean isOk = uti.updateByPreparedStatement(sql, params);
    		  if(isOk)
    		 {
    			  System.out.println(e.getEname()+"添加成功");
    			  
    		  }
    		  else
    		  {
    			  System.out.println(e.getEname()+"添加失败");
    		  }
    		  uti.releaseConn();
    	  } 
      }
      //更改
      public void changeEmployeeDao(Employee e) throws Exception
      {   
    	  if(e==null)
    	  {
    		  System.out.println("输入不能为空");
    		  return;
    	  }
    	  if(showasimpleEmployeeDao(e.getEnumber())!=null)
    	  {  String sql="UPDATE t_employee SET ejob=?,ename=?,esex=?,esalary=? WHERE enumber=?";
  	  	  ArrayList<Object> params = new ArrayList<Object>();
  	  	 params.add(e.getEjob());
  	  	 params.add(e.getEname());
  	  	 params.add(e.getEsex());
  	  	 params.add(e.getEsalary());
  	  	 params.add(e.getEnumber());
  		 uti.updateByPreparedStatement(sql, params);
    	System.out.println("更改成功");
    	uti.releaseConn();
    		  
    	  }
    	  else
    	  {
    		  
    		  System.out.println("此员工不存在");
    	  } 
      }
      //删除
      public void deleteEmployeeDao() throws Exception
      {
    	  System.out.println("请输入员工编号:");
    	  Scanner sc=new Scanner(System.in);
          int enumber=sc.nextInt();
    	  if(showasimpleEmployeeDao(enumber)!=null)
    	  {  String sql="DELETE FROM t_employee WHERE enumber=?";
    	  	ArrayList<Object> params = new ArrayList<Object>();
    	  	params.add(enumber);
    		 uti.updateByPreparedStatement(sql, params);
    			 System.out.println("删除成功");
    			 uti.releaseConn();
    			    		  
    	  }else
    	  {
    		  System.out.println("此员工不存在");
    	  } 
    	  
    	  
      }
      public Employee showasimpleEmployeeDao(int enumber) throws Exception
      {
    	  String sql="SELECT * FROM t_employee WHERE enumber=?";
    	  ArrayList<Object> params = new ArrayList<Object>();
    	  params.add(enumber);
		   Employee emp = uti.findSimpleRefResult(sql, params, Employee.class);
		   System.out.println(emp);
		   uti.releaseConn();
    	  return emp;  
      }
      
      
      
      
      //显示所有
      public void showallEmployeeDao() throws Exception
      {
    	  String sql="SELECT * FROM t_employee";
		   List<Employee> result = uti.findMoreRefResult(sql, null, Employee.class);
		   for (Employee emp : result) {
			System.out.println(emp);
		}
		   uti.releaseConn();
    	  
      }
      
      
}
