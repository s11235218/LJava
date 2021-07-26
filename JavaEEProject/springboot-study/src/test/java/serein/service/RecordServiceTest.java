package serein.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecordServiceTest {

    @After
    public void after(){
        System.out.println("-----------after---------");
    }

    @Before
    public void before(){
        System.out.println("-----------before----------");
    }

    @Test
    public void query() {
        RecordService rs = new RecordService();
        System.out.println("query");

    }
    @Ignore
    @Test
    public void test1() {
    }
}