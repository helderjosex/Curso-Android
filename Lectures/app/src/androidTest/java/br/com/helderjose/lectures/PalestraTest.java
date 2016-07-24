package br.com.helderjose.lectures;

import junit.framework.TestCase;

import br.com.helderjose.lectures.models.Palestra;

/**
 * Created by helder on 24/07/16.
 */
public class PalestraTest extends TestCase {

    public void testPalestraNaoPodeTerNomeNumerico(){
        Palestra p = new Palestra();
        p.setNome("Palestra 60min");
        boolean resultado = p.isNomeValido();
        assertTrue(resultado);
    }
}
