package AgenciaBancaria;

/** Classe representante dos administrativos
 */
public class Administrativo extends Funcionario
{
    /** Cria um administrativo com dados recebidos
     * @param codigo Código do administrativo
     * @param password Password do administrativo
     * @param nome Nome do administrativo
     * @param contacto Contacto do administrativo
     */    
    public Administrativo (String codigo, String password, String nome, String contacto)
    {
        super (codigo, password, nome, contacto);
    }
}
