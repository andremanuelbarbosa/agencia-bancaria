package AgenciaBancaria;

import java.io.*;

/** Classe que é usada como superclasse abstracta das classes ADMINISTRATIVO e GESTOR
 */
public abstract class Funcionario implements Serializable
{
    private String codigo;
    private String password;
    private String nome;
    private String contacto;

    /** Cria um funcionário com dados recebidos
     * @param codigo Código do funcionário
     * @param password Password do funcionário
     * @param nome Nome do funcionário
     * @param contacto Contacto do funcionário
     */    
    public Funcionario (String codigo, String password, String nome, String contacto)
    {
        this.codigo = codigo;
        this.password = password;
        this.nome = nome;
        this.contacto = contacto;
    }
    
    /** Modifica o código do funcionário
     * @param newCodigo Novo código do funcionário
     */    
    public void setCodigo (String newCodigo)
    {
        codigo = newCodigo;
    }
    
    /** Retorna o código do funcionário
     * @return Código do funcionário
     */    
    public String getCodigo ()
    {
        return codigo;
    }
    
    /** Modifica a password do funcionário
     * @param newPassword Nova password do funcionário
     */    
    public void setPassword (String newPassword)
    {
        password = newPassword;
    }
    
    /** Retorna a password do funcionário
     * @return Password do funcionário
     */    
    public String getPassword ()
    {
        return password;
    }
    
    /** Modifica o nome do funcionário
     * @param newNome Novo nome do funcionário
     */    
    public void setNome (String newNome)
    {
        nome = newNome;
    }
    
    /** Retorna o nome do funcionário
     * @return Nome do funcionário
     */    
    public String getNome ()
    {
        return nome;
    }
    
    /** Modifica o contacto do funcionário
     * @param newContacto Novo contacto do funcionário
     */    
    public void setContacto (String newContacto)
    {
        contacto = newContacto;
    }
    
    /** Retorna o contacto do funcionário
     * @return Contacto do funcionário
     */    
    public String getContacto ()
    {
        return contacto;
    }
}
