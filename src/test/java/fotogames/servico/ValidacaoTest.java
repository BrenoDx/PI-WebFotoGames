/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fotogames.servico;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author breno
 */
public class ValidacaoTest {
    
    public ValidacaoTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    

  
    @org.junit.Test
    public void testValidacaoCliente() {
        
        String cpf = "";
        String email = "";
        String telefone = "";
        Validacao instance = new Validacao();
        boolean expResult = false;
        boolean result = instance.cliente(cpf, email, telefone);
        assertEquals(expResult, result);

    }
    
}
