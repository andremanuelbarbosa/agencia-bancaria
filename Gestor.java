package AgenciaBancaria;

import java.util.*;

/** Classe representante dos gestores
 */
public class Gestor extends Funcionario
{
    private LinkedList contas;

    /** Cria um gestor com dados recebidos
     * @param codigo Código do gestor
     * @param password Password do gestor
     * @param nome Nome do gestor
     * @param contacto Contacto do gestor
     */    
    public Gestor (String codigo, String password, String nome, String contacto)
    {
        super (codigo, password, nome, contacto);
        contas = new LinkedList ();
    }
    
    /** Adiciona uma nova conta ao gestor
     * @param conta Conta a adicionar
     */    
    public void addConta (Conta conta)
    {
        contas.addLast (conta);
    }
    
    /** Remove uma conta do gestor
     * @param index Posição da conta a remover
     */    
    public void removeConta (int index)
    {
        contas.remove (index);
    }
    
    /** Retorna uma conta do gestor
     * @param index Posição da conta a retornar
     * @return Conta do gestor
     */    
    public Conta getConta (int index)
    {
        return (Conta) contas.get (index);
    }
    
    /** Actualiza as contas do gestor
     * @param numRemovido Posição a partir da qual ele vai actualizar
     */    
    public void actualizaConta (int numRemovido)
    {
        for (int i = (numRemovido - 1); i < contas.size (); i++)
        {
            Conta conta = (Conta) contas.get (i);

            String codigo = conta.getCodCliente ();
            String iniciais = codigo.substring (0,2);
            int num = Integer.parseInt (codigo.substring (3, codigo.length ()));
            --num;
            String aux = "" + num;
            int size = aux.length ();
            
            for (int j = 5; j > size; j--) aux = "0" + aux;
            
            conta.setCodCliente (iniciais + "_" + aux);
            contas.set ((i), conta);
        }
    }
    
    /** Retorna o número de contas do gestor
     * @return Número de contas do gestor
     */    
    public int getSizeContas ()
    {
        return contas.size ();
    }
}