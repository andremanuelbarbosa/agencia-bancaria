package AgenciaBancaria;

/** Classe representante das empresas
 */
public class Empresa extends Cliente
{
    private String ramo;

    /** Cria uma empresa com dados recebidos
     * @param codigo Código da empresa
     * @param password Password da empresa
     * @param nome Nome da empresa
     * @param contacto Contacto da empresa
     * @param ramo Ramo da empresa
     */    
    public Empresa (String codigo, String password, String nome, String contacto, String ramo)
    {
        super (codigo, password, nome, contacto);
        this.ramo = ramo;
    }
    
    /** Modifica o ramo da empresa
     * @param newRamo Novo ramo da empresa
     */    
    public void setRamo (String newRamo)
    {
        ramo = newRamo;
    }
    
    /** Retorna o ramo da empresa
     * @return Ramo da empresa
     */    
    public String getRamo ()
    {
        return ramo;
    }
}

