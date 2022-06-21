import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {
    @Test
    public void employeeNameTest(){
        Employee employee = new Employee();
        employee.setName("Jelena");
        Assert.assertEquals(employee.getName(),"Jelena");
    }
    @Test
    public void employeeSurnameTest(){
        Employee employee = new Employee();
        employee.setSurname("Dinere");
        Assert.assertEquals(employee.getSurname(),"Dinere");
    }
    @Test
    public void employeeYear(){
        Employee employee = new Employee();
        employee.setYear(1985);
        Assert.assertEquals(employee.getYear(),1985);
    }
    @Test
    public void employeeRole(){
        Employee employee = new Employee();
        employee.setRole("real estate agent");
        Assert.assertEquals(employee.getRole(),"real estate agent");
    }
    @Test
    public void testAllArguments(){
        Employee employee = new Employee("Jelena","Dinere",1985,"real estate agent");
        Assert.assertEquals(employee.getName(),"Jelena");
        Assert.assertEquals(employee.getSurname(),"Dinere");
        Assert.assertEquals(employee.getYear(),1985);
        Assert.assertEquals(employee.getRole(),"real estate agent");
    }
}
