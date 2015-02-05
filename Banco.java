package AgenciaBancaria;

import java.util.*;
import java.io.*;

/** Classe que serve de base de dados armazenando toda a informação da agência bancária
 */
public class Banco implements Serializable
{
    private LinkedList administrativos;
    private LinkedList gestores;
    private LinkedList empresas;
    private LinkedList individuos;
    private LinkedList contas;
    
    /** Cria um banco com dados pré-estabelecidos
     */    
    public Banco ()
    {
        administrativos = new LinkedList ();
        gestores = new LinkedList ();
        empresas = new LinkedList ();
        individuos = new LinkedList ();
        contas = new LinkedList ();
    }
    
    /** Adiciona um novo administrativo ao banco
     * @param administrativo Administrativo a adicionar
     */    
    public void addAdministrativo (Administrativo administrativo)
    {
        administrativos.addLast (administrativo);
    }
    
    /** Remove um administrativo do banco
     * @param index Posição do administrativo a remover
     */    
    public void removeAdministrativo (int index)
    {
        administrativos.remove (index);
    }
    
    /** Retorna um administrativo do banco
     * @param index Posição do administrativo a retornar
     * @return Administrativo do banco
     */    
    public Administrativo getAdministrativo (int index)
    {
        return (Administrativo) administrativos.get (index);
    }
    
    /** Retorna o código para um novo administrativo
     * @return Código do novo administrativo
     */    
    public String geraCodigoAdministrativo ()
    {
        if (administrativos.isEmpty ()) return "fa_00001";
        else
        {
            Administrativo administrativo = (Administrativo) administrativos.getLast ();
        
            String codigo = administrativo.getCodigo ();
            String iniciais = codigo.substring (0,2);
            int num = Integer.parseInt (codigo.substring (3, codigo.length ()));
            ++num;
            String aux = "" + num;
            int size = aux.length ();
        
            for (int i = 5; i > size; i--) aux = "0" + aux;
            return iniciais + "_" + aux;
        }
    }
    
    /** Retorna o número de administrativos do banco
     * @return Número de administrativos do banco
     */    
    public int getSizeAdministrativos ()
    {
        return administrativos.size ();
    }
    
    /** Actualiza os administrativos do banco
     * @param numRemovido Posição a partir da qual ele vai actualizar
     */    
    public void actualizaAdministrativo (int numRemovido)
    {
        for (int i = (numRemovido - 1); i < administrativos.size (); i++)
        {
            Administrativo administrativo = (Administrativo) administrativos.get (numRemovido - 1);

            String codigo = administrativo.getCodigo ();
            String iniciais = codigo.substring (0,2);
            int num = Integer.parseInt (codigo.substring (3, codigo.length ()));
            --num;
            String aux = "" + num;
            int size = aux.length ();
            
            for (int j = 5; j > size; j--) aux = "0" + aux;
            
            administrativo.setCodigo (iniciais + "_" + aux);
            administrativos.set ((numRemovido - 1), administrativo);
        }
    }
    
    /** Adiciona um novo gestor ao banco
     * @param gestor Gestor a adicionar
     */    
    public void addGestor (Gestor gestor)
    {
        gestores.addLast (gestor);
    }
    
    /** Remove um gestor do banco
     * @param index Posição do gestor a remover
     */    
    public void removeGestor (int index)
    {
        gestores.remove (index);
    }

    /** Retorna um gestor do banco
     * @param index Posição do gestor a retornar
     * @return Gestor do banco
     */    
    public Gestor getGestor (int index)
    {
        return (Gestor) gestores.get (index);
    }
    
    /** Retorna o código para um novo gestor
     * @return Código do novo gestor
     */    
    public String geraCodigoGestor ()
    {
        if (gestores.isEmpty ()) return "fg_00001";
        else
        {
            Gestor gestor = (Gestor) gestores.getLast ();
        
            String codigo = gestor.getCodigo ();
            String iniciais = codigo.substring (0,2);
            int num = Integer.parseInt (codigo.substring (3, codigo.length ()));
            ++num;
            String aux = "" + num;
            int size = aux.length ();
        
            for (int i = 5; i > size; i--) aux = "0" + aux;
            return iniciais + "_" + aux;
        }
    }
    
    /** Retorna um gestor do banco escolhido aleatoriamente
     * @return Gestor do banco
     */    
    public Gestor getRandomGestor ()
    {
        return (Gestor) gestores.get ((int) (Math.random () * (gestores.size () - 1)));
    }
    
    /** Retorna o número de gestores do banco
     * @return Número de gestores do banco
     */    
    public int getSizeGestores ()
    {
        return gestores.size ();
    }
    
    /** Actualiza os gestores do banco
     * @param numRemovido Posição a partir da qual ele vai actualizar
     */    
    public void actualizaGestor (int numRemovido)
    {
        for (int i = (numRemovido - 1); i < gestores.size (); i++)
        {
            Gestor gestor = (Gestor) gestores.get (numRemovido - 1);

            String codigo = gestor.getCodigo ();
            String iniciais = codigo.substring (0,2);
            int num = Integer.parseInt (codigo.substring (3, codigo.length ()));
            --num;
            String aux = "" + num;
            int size = aux.length ();
            
            for (int j = 5; j > size; j--) aux = "0" + aux;
            
            gestor.setCodigo (iniciais + "_" + aux);
            gestores.set ((numRemovido - 1), gestor);
        }
    }
    
    /** Adiciona uma nova empresa ao banco
     * @param empresa Empresa a adicionar
     */    
    public void addEmpresa (Empresa empresa)
    {
        empresas.addLast (empresa);
    }
    
    /** Remove uma empresa do banco
     * @param index Posição da empresa a remover */    
    public void removeEmpresa (int index)
    {
        empresas.remove (index);
    }

    /** Retorna uma empresa do banco
     * @param index Posição da empresa a retornar
     * @return Empresa do banco
     */    
    public Empresa getEmpresa (int index)
    {
        return (Empresa) empresas.get (index);
    }
    
    /** Retorna o código para uma nova empresa
     * @return Código para uma nova empresa
     */    
    public String geraCodigoEmpresa ()
    {
        if (empresas.isEmpty ()) return "ce_00001";
        else
        {
            Empresa empresa = (Empresa) empresas.getLast ();
            
            String codigo = empresa.getCodigo ();
            String iniciais = codigo.substring (0,2);
            int num = Integer.parseInt (codigo.substring (3, codigo.length ()));
            ++num;
            String aux = "" + num;
            int size = aux.length ();
        
            for (int i = 5; i > size; i--) aux = "0" + aux;
            return iniciais + "_" + aux;
        }
    }
    
    /** Retorna o número de empresas do banco
     * @return Número de empresas do banco
     */    
    public int getSizeEmpresas ()
    {
        return empresas.size ();
    }
    
    /** Actualiza as empresas do banco
     * @param numRemovido Posição a partir da qual ele vai actualizar
     */    
    public void actualizaEmpresa (int numRemovido)
    {
        for (int i = (numRemovido - 1); i < empresas.size (); i++)
        {
            Empresa empresa = (Empresa) empresas.get (i);
            
            String codigo = empresa.getCodigo ();
            String iniciais = codigo.substring (0,2);
            int num = Integer.parseInt (codigo.substring (3, codigo.length ()));
            --num;
            String aux = "" + num;
            int size = aux.length ();
            
            for (int j = 5; j > size; j--) aux = "0" + aux;
            
            empresa.setCodigo (iniciais + "_" + aux);
            empresas.set ((i), empresa);
        }
    }
    
    /** Adiciona um novo individuo ao banco
     * @param individuo Individuo a adicionar
     */    
    public void addIndividuo (Individuo individuo)
    {
        individuos.addLast (individuo);
    }
    
    /** Remove um individuo do banco
     * @param index Posição do individuo a remover
     */    
    public void removeIndividuo (int index)
    {
        individuos.remove (index);
    }
    
    /** Retorna um individuo do banco
     * @param index Posição do individuo a retornar
     * @return Individuo do banco
     */    
    public Individuo getIndividuo (int index)
    {
        return (Individuo) individuos.get (index);
    }
    
    /** Retorna o código para um novo individuo
     * @return Código do novo individuo
     */    
    public String geraCodigoIndividuo ()
    {
        if (individuos.isEmpty ()) return "ci_00001";
        else
        {
            Individuo individuo = (Individuo) individuos.getLast ();
        
            String codigo = individuo.getCodigo ();
            String iniciais = codigo.substring (0,2);
            int num = Integer.parseInt (codigo.substring (3, codigo.length ()));
            ++num;
            String aux = "" + num;
            int size = aux.length ();
        
            for (int i = 5; i > size; i--) aux = "0" + aux;
            return iniciais + "_" + aux;
        }
    }
    
    /** Retorna o número de inviduos do banco
     * @return Número de individuos do banco
     */    
    public int getSizeIndividuos ()
    {
        return individuos.size ();
    }
    
    /** Actualiza os individuos do banco
     * @param numRemovido Posição a partir da qual ele vai actualizar
     */    
    public void actualizaIndividuo (int numRemovido)
    {
        for (int i = (numRemovido - 1); i < individuos.size (); i++)
        {
            Individuo individuo = (Individuo) individuos.get (i);

            String codigo = individuo.getCodigo ();
            String iniciais = codigo.substring (0,2);
            int num = Integer.parseInt (codigo.substring (3, codigo.length ()));
            --num;
            String aux = "" + num;
            int size = aux.length ();
            
            for (int j = 5; j > size; j--) aux = "0" + aux;
            
            individuo.setCodigo (iniciais + "_" + aux);
            individuos.set (i, individuo);
        }
    }
    
    /** Adiciona uma nova conta ao banco
     * @param conta Conta a adicionar
     */    
    public void addConta (Conta conta)
    {
        contas.addLast (conta);
    }
    
    /** Remove uma conta do banco
     * @param codCliente Código do cliente
     */    
    public void removeConta (String codCliente)
    {
        for (int i = 0; i < contas.size (); i++)
        {
            Conta conta = (Conta) contas.get (i);
            if (codCliente.equals (conta.getCodCliente ())) contas.remove (i);
        }
    }

    /** Retorna uma conta do banco
     * @param codCliente Código do cliente
     * @return Conta do banco
     */    
    public Conta getConta (String codCliente)
    {
        Conta conta = new Conta ("", "", 0.0);
        for (int i = 0; i < contas.size (); i++)
        {
            Conta contaAux = (Conta) contas.get (i);
            if (codCliente.equals (contaAux.getCodCliente ())) conta = contaAux;
        }
        return conta;
    }
    
    /** Retorna o número de contas do banco
     * @return Número de contas do banco
     */    
    public int getSizeContas ()
    {
        return contas.size ();
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                