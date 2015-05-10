package edu.uan.fis.jeesample.dao.impl;
import UserPackage.User;
import UserPackage.UserDaoJdbc;
import java.util.List;
import junit.framework.TestCase;

public class UserDaoJdbcTest extends TestCase {
    
    public UserDaoJdbcTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreate() {
        System.out.println("create");
        User user = new User(1 ,"AlexDiaz","12345");
        UserDaoJdbc instance = new UserDaoJdbc();
        User expResult = user;
        User result = instance.create(user);
        assertEquals(expResult, result);
    }

    public void testUpdate() {
        System.out.println("update");
        int idUser = 2;
        UserDaoJdbc instance = new UserDaoJdbc();
        instance.update(idUser);
    }

    public void testDelete() 
    {
        System.out.println("delete");
        int idUser = 4;
        UserDaoJdbc instance = new UserDaoJdbc();
        instance.delete(idUser);
    }

    public void testFindById() {
        System.out.println("findById");
        Integer idUser = null;
        UserDaoJdbc instance = new UserDaoJdbc();
        User expResult = null;
        User result = instance.findById(idUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public void testFindAll() {
        System.out.println("findAll");
        UserDaoJdbc instance = new UserDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
