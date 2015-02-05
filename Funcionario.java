package AgenciaBancaria;

import java.io.*;

/** Classe que � usada como superclasse abstracta das classes ADMINISTRATIVO e GESTOR
 */
public abstract class Funcionario implements Serializable
{
    private String codigo;
    private String password;
    private String nome;
    private String contacto;

    /** Cria um funcion�rio com dados recebidos
     * @param codigo C�digo do funcion�rio
     * @param password Password do funcion�rio
     * @param nome Nome do funcion�rio
     * @param contacto Contacto do funcion�rio
     */    
    public Funcionario (String codigo, String password, String nome, String contacto)
    {
        this.codigo = codigo;
        this.password = password;
        this.nome = nome;
        this.contacto = contacto;
    }
    
    /** Modifica o c�digo do funcion�rio
     * @param newCodigo Novo c�digo do funcion�rio
     */    
    public void setCodigo (String newCodigo)
    {
        codigo = newCodigo;
    }
    
    /** Retorna o c�digo do funcion�rio
     * @return C�digo do funcion�rio
     */    
    public String getCodigo ()
    {
        return codigo;
    }
    
    /** Modifica a password do funcion�rio
     * @param newPassword Nova password do funcion�rio
     */    
    public void setPassword (String newPassword)
    {
        password = newPassword;
    }
    
    /** Retorna a password do funcion�rio
     * @return Password do funcion�rio
     */    
    public String getPassword ()
    {
        return password;
    }
    
    /** Modifica o nome do funcion�rio
     * @param newNome Novo nome do funcion�rio
     */    
    public void setNome (String newNome)
    {
        nome = newNome;
    }
    
    /** Retorna o nome do funcion�rio
     * @return Nome do funcion�rio
     */    
    public String getNome ()
    {
        return nome;
    }
    
    /** Modifica o contacto do funcion�rio
     * @param newContacto Novo contacto do funcion�rio
     */    
    public void setContacto (String newContacto)
    {
        contacto = newContacto;
    }
    
    /** Retorna o contacto do funcion�rio
     * @return Contacto do funcion�rio
     */    
    public String getContacto ()
    {
        return contacto;
    }
}
