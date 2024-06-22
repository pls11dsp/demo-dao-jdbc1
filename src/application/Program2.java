package application;

import java.util.List;
import java.util.Scanner;

import model.Dao.DaoFactory;
import model.Dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
					
		System.out.println("=== Test 1: department findById ===");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println("\n=== Test 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
		System.out.println(d);
		}
		
		System.out.println("\n=== TEST 3: department insert =======");
		Department newDepartment = new Department(null, "D3");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
		
		System.out.println("\n=== Test 4: department updadte ===");
		Department department = new Department();
		department = departmentDao.findById(1);
		department.setName("Computers");
		departmentDao.update(department);
		System.out.println("Upadate completed");
		
		System.out.println("\n=== Test 5: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
