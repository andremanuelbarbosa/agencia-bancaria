package AgenciaBancaria;

import java.util.*;
import java.io.*;

/** Classe representante das contas
 */
public class Conta implements Serializable
{
    private String codCliente;
    private String data;
    private double saldo;
    private LinkedList movimentos;
    
    /** Cria uma conta com dados recebidos
     * @param codCliente Código do cliente
     * @param data Data de criação da conta
     * @param saldo Saldo inicial da conta
     */    
    public Conta (String codCliente, String data, double saldo)
    {
        this.codCliente = codCliente;
        this.data = data;
        this.saldo = saldo;
        this.movimentos = new LinkedList ();
    }
    
    /** Modifica o código do cliente da conta
     * @param newCodCliente Novo código do cliente da conta
     */    
    public void setCodCliente (String newCodCliente)
    {
        codCliente = newCodCliente;
    }
    
    /** Retorna o código do cliente da conta
     * @return Código do cliente da conta
     */    
    public String getCodCliente ()
    {
        return codCliente;
    }
    
    /** Retorna a data de criação da conta
     * @return Data de criação da conta
     */    
    public String getData ()
    {
        return data;
    }
    
    /** Modifica o saldo da conta
     * @param newSaldo Novo saldo da conta
     */    
    public void setSaldo (double newSaldo)
    {
        saldo = newSaldo;
    }
    
    /** Retorna o saldo da conta
     * @return Saldo da conta
     */    
    public double getSaldo ()
    {
        return saldo;
    }
    
    /** Adiciona um novo movimento à conta
     * @param movimento Movimento a adicionar
     */    
    public void addMovimento (Movimento movimento)
    {
        movimentos.addLast (movimento);
    }

    /** Retorna um movimento da conta
     * @param index Posição do movimento a retornar
     * @return Movimento da conta
     */    
    public Movimento getMovimento (int index)
    {
        return (Movimento) movimentos.get (index);
    }
    
    /** Retorna o número de movimentos da conta
     * @return Número de movimentos da conta
     */    
    public int getSizeMovimentos ()
    {
        return movimentos.size ();
    }
}
