package edu.uan.fis.jeesample.dao.impl;



import AdminPackage.Administrator;
import AdminPackage.AdministratorDaoJdbc;
import junit.framework.TestCase;

public class AdministratorDaoJdbcTest extends TestCase {
    
    public AdministratorDaoJdbcTest(String testName) {
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
        Administrator admin = new Administrator(1 ,"MichaelSinner","12345");
        AdministratorDaoJdbc instance = new AdministratorDaoJdbc();
        Administrator expResult = admin;
        Administrator result = instance.create(admin);
        assertEquals(expResult, result);
    }

    public void testUpdate() {
        System.out.println("update");
        int idAdministrator = 2;
        AdministratorDaoJdbc instance = new AdministratorDaoJdbc();
        instance.update(idAdministrator);
    }

    public void testDelete() 
    {
        System.out.println("delete");
        int idAdministrator = 4;
        AdministratorDaoJdbc instance = new AdministratorDaoJdbc();
        instance.delete(idAdministrator);
    }

    public void testFindById() {
        System.out.println("findById");
        Integer idAdmin = null;
        AdministratorDaoJdbc instance = new AdministratorDaoJdbc();
        Administrator expResult = null;
        Administrator result = instance.findById(idAdmin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
