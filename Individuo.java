package AgenciaBancaria;

/** Classe representante dos individuos
 */
public class Individuo extends Cliente
{
    private String profissao;
    
    /** Cria um individuo com dados recebidos
     * @param codigo Código do individuo
     * @param password Password do individuo
     * @param nome Nome do individuo
     * @param contacto Contacto do individuo
     * @param profissao Profissão do individuo
     */    
    public Individuo (String codigo, String password, String nome, String contacto, String profissao)
    {
        super (codigo, password, nome, contacto);
        profissao = this.profissao;
    }
    
    /** Modifica a profissão do individuo
     * @param newProfissao Nova profissão do individuo
     */    
    public void setProfissao (String newProfissao)
    {
        profissao = newProfissao;
    }
    
    /** Retorna a profissão do individuo
     * @return Profissão do individuo
     */    
    public String getProfissao ()
    {
        return profissao;
    }
}
