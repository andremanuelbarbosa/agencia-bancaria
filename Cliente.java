package AgenciaBancaria; 

import java.io.*;

/** Classe usada como superclasse abstracta das classes EMPRESA e INDIVIDUO
 */
public abstract class Cliente implements Serializable
{
    private String codigo;
    private String password;
    private String nome;
    private String contacto;
    
    /** Cria um clinte com dados recebidos
     * @param codigo Código do cliente
     * @param password Password do cliente
     * @param nome Nome do Cliente
     * @param contacto Contacto do cliente
     */    
    public Cliente (String codigo, String password, String nome, String contacto)
    {
        this.codigo = codigo;
        this.password = password;
        this.nome = nome;
        this.contacto = contacto;
    }
    
    /** Modifica o código do cliente
     * @param newCodigo Novo código do cliente
     */    
    public void setCodigo (String newCodigo)
    {
        codigo = newCodigo;
    }
    
    /** Retorna o código do cliente
     * @return Código do cliente
     */    
    public String getCodigo ()
    {
        return codigo;
    }
    
    /** Modifica a password do cliente
     * @param newPassword Nova password do cliente
     */    
    public void setPassword (String newPassword)
    {
        password = newPassword;
    }
    
    /** Retorna a password do cliente
     * @return Password do cliente
     */    
    public String getPassword ()
    {
        return password;
    }
    
    /** Modifica o nome do cliente
     * @param newNome Novo nome do cliente
     */    
    public void setNome (String newNome)
    {
        nome = newNome;
    }
    
    /** Retorna o nome do cliente
     * @return Nome do cliente
     */    
    public String getNome ()
    {
        return nome;
    }
    
    /** Modifica o contacto do cliente
     * @param newContacto Novo contacto do cliente
     */    
    public void setContacto (String newContacto)
    {
        contacto = newContacto;
    }
    
    /** Retorna o contacto do cliente
     * @return Contacto do cliente
     */    
    public String getContacto ()
    {
        return contacto;
    }
}
