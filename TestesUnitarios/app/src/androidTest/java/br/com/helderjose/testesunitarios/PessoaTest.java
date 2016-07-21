package br.com.helderjose.testesunitarios;

import junit.framework.TestCase;

import br.com.helderjose.testesunitarios.models.Pessoa;

/**
 * Created by helder on 20/07/16.
 */
public class PessoaTest extends TestCase{

    public void testPessoaComIdadeMenorQue16AnosNaoPodeVotar(){
        Pessoa p = new Pessoa("Hélder",15);
        boolean resultado = p.podeVotar();
        assertFalse(resultado);
    }

    public void testPessoaComIdadeMaiorOuIgualA16AnosPodeVotar(){
        Pessoa p = new Pessoa("Hélder",17);
        boolean resultado = p.podeVotar();
        assertTrue(resultado);
    }
}
