package AgenciaBancaria;

import java.io.*;

/** Classe representante dos movimentos
 */
public class Movimento implements Serializable
{
    private double montante;
    private String data;
    private String tipo;
    
    /** Cria um movimento com dados recebidos
     * @param montante Montante do movimento
     * @param data Data do movimento
     * @param tipo Tipo do movimento
     */    
    public Movimento (double montante, String data, String tipo)
    {
        this.montante = montante;
        this.data = data;
        this.tipo = tipo;
    }

    /** Retorna o montante do movimento
     * @return Montante do movimento
     */    
    public double getMontante ()
    {
        return montante;
    }
    
    /** Retorna a data do movimento
     * @return Data do movimento
     */    
    public String getData ()
    {
        return data;
    }
    
    /** Retorna o tipo de movimento
     * @return Tipo de movimento
     */    
    public String getTipo ()
    {
        return tipo;
    }
}
