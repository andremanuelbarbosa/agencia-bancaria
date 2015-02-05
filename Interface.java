package AgenciaBancaria;

import java.util.*;
import java.io.*;

/** Classe que gere a agência bancária possibilitando acções ao utilizador
 */
public class Interface
{    
    private Banco banco;
           
    /** Cria uma interface vazia
     */    
    public Interface ()
    {

    }

    private String ler ()
    {
        String str;

        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));
        
        try
        {
            str = bufferedReader.readLine ();
        }
        
        catch (IOException exception)
        {
            str = "";
        }

        return str;
    }

    /** Limpa o output
     */    
    public void clearScreen ()
    {
        for (int i = 0; i < 20; i++) System.out.println ("");
    }
    
    /** Visualiza o menuStart (abrir novo banco, utilizar banco existente, sair) e processa a opção do utilizador
     */    
    public void menuStart ()
    {
        clearScreen ();
        
        System.out.println ("1 - Criar novo banco");
        System.out.println ("2 - Abrir banco existente");
        System.out.println ("0 - Sair");
        
        switch (Integer.parseInt (ler ()))
        {
            case 1: banco = new Banco ();
                    menuInicial ();
                    break;
            case 2: leDados ();
                    menuInicial ();
                    break;
            case 0: System.exit (0);
                    break;
            default: menuStart ();
                     break;
        }
    }
    
    /** Abre um banco já existente dum ficheiro definido pelo utilizador
     */    
    public void leDados ()
    {
        ObjectInputStream objIn;
        
        clearScreen ();
        
        System.out.print ("Introduza o nome do ficheiro: ");
        String ficheiro = ler ();
        
        try
        {
            objIn = new ObjectInputStream (new FileInputStream (ficheiro));
            banco = (Banco) objIn.readObject ();
        }
        
        catch (Exception e)
        {
            System.out.println ("\nNao foi possivel encontrar o ficheiro");
            System.out.println ("Prima «Enter» para voltar");
            ler ();
            menuStart ();
        }
    }
    
    /** Grava um banco num ficheiro definido pelo utilizador
     */    
    public void gravaDados ()
    {
        ObjectOutputStream objOut;
        
        clearScreen ();
        
        System.out.print ("Introduza o nome do ficheiro: ");
        String ficheiro = ler ();
        
        try
        {
            objOut = new ObjectOutputStream (new FileOutputStream (ficheiro));
            objOut.writeObject (banco);
            System.out.println ("\nAlterações gravadas com sucesso");
            System.out.println ("Prima «Enter» para sair");
            ler ();
        }
        
        catch (IOException e)
        {
            System.out.println ("Nao foi possivel gravar para o ficheiro");
            System.out.println ("Prima «Enter» para voltar");
            ler ();
            gravaDados ();
        }
    }
    
    /** Visualiza o menuInicial (login, sair e gravar) e processa a opção do utilizador
     */    
    public void menuInicial ()
    {
        clearScreen ();
        
        System.out.println ("1 - Login");
        System.out.println ("0 - Sair e gravar");
        
        switch (Integer.parseInt (ler ()))
        {
            case 1: menuLogin ();
                    break;
            case 0: gravaDados ();
                    System.exit (0);
                    break;
            default: menuInicial ();
                     break;
        }
    }

    /** Visualiza o menuLogin (introduzir código e password) e processa as opções do utilizador
     */    
    public void menuLogin ()
    {
        clearScreen ();
        
        System.out.print ("Introduza o código: ");
        String codigo = ler ();
        System.out.print ("Introduza a password: ");
        String password = ler ();
        
        try 
        {
            StringTokenizer stringTokenizer = new StringTokenizer (codigo, "_");
            String iniciaisCodigo = stringTokenizer.nextToken ().toString ();
            int numCodigo = Integer.parseInt (stringTokenizer.nextToken ().toString ());
        
            if (iniciaisCodigo.compareToIgnoreCase ("daf") == 0) 
            {
                if (! (password.equals ("web"))) 
                {
                    System.out.println ("\nCódigo ou password errados");
                    System.out.println ("Prima «Enter» para voltar a introduzir");
                    ler ();
                    menuLogin ();
                }
                menuDirector ();
            }
            
            if (iniciaisCodigo.compareToIgnoreCase ("fa") == 0) 
            {
                Administrativo administrativo = banco.getAdministrativo (numCodigo - 1);
                if (! (password.equals (administrativo.getPassword ()))) 
                {
                    System.out.println ("\nCódigo ou password errados");
                    System.out.println ("Prima «Enter» para voltar a introduzir");
                    ler ();
                    menuLogin ();
                }
                menuAdministrativos (numCodigo);
            }
        
            if (iniciaisCodigo.compareToIgnoreCase ("fg") == 0) 
            {
                 Gestor gestor = banco.getGestor (numCodigo - 1);
                if (! (password.equals (gestor.getPassword ())))
                {
                    System.out.println ("\nCódigo ou password errados");
                    System.out.println ("Prima «Enter» para voltar a introduzir");
                    ler ();
                    menuLogin ();
                }
                menuGestores (numCodigo);
            }
        
            if (iniciaisCodigo.compareToIgnoreCase ("ce") == 0)
            {
                Empresa empresa = banco.getEmpresa (numCodigo - 1);
                if (! (password.equals (empresa.getPassword ())))
                {
                    System.out.println ("\nCódigo ou password errados");
                    System.out.println ("Prima «Enter» para voltar a introduzir");
                    ler ();
                    menuLogin ();
                }
                menuClientesEmpresas (numCodigo);
            }
        
            if (iniciaisCodigo.compareToIgnoreCase ("ci") == 0) 
            {
                Individuo individuo = banco.getIndividuo (numCodigo - 1);
                if (! (password.equals (individuo.getPassword ())))
                {
                    System.out.println ("\nCódigo ou password errados");
                    System.out.println ("Prima «Enter» para voltar a introduzir");
                    ler ();
                    menuLogin ();
                }
                menuClientesIndividuos (numCodigo);
            }
        }
        
        catch (Exception e)
        {
            System.out.println ("\nNão existem utilizadores desse tipo");
            System.out.println ("Prima «Enter» para voltar");
            ler ();
            menuLogin ();
        }
    }
    
    /** Visualiza o menuDirector (adicionar e remover administrativo, voltar) e processa a opcão do utilizador
     */    
    public void menuDirector ()
    {
        clearScreen ();
        
        System.out.println ("Benvindos André & Filipe");
        System.out.println ("1 - Adicionar Administrativo");
        System.out.println ("2 - Remover Administrativo");
        System.out.println ("0 - Voltar");
        
        switch (Integer.parseInt (ler ()))
        {
            case 1: menuAdicionarAdministrativo ();
                    menuDirector ();
                    break;
            case 2: menuRemoverAdministrativo ();
                    menuDirector ();
                    break;
            case 0: menuInicial ();
                    break;
            default: menuDirector ();
                     break;
        }
    }
    
    /** Visualiza o nome e o código do administrativo e o menuAdministrativos (listar gerentes de conta e informação relativa ás contas associadas, alterar dados pessoais, adicionar e remover gestor, adicionar cliente, voltar) e processa a opção do utilizador
     * @param numCodigo Número do código do administrativo
     */    
    public void menuAdministrativos (int numCodigo)
    {
        Administrativo administrativo = banco.getAdministrativo (numCodigo - 1);
        
        clearScreen ();

        System.out.println ("Benvindo " + administrativo.getNome () + " (" + administrativo.getCodigo () + ")");
        System.out.println ("1 - Listar gerentes de conta e informação relativa ás contas associadas");
        System.out.println ("2 - Alterar dados pessoais");
        System.out.println ("3 - Adicionar Gestor");
        System.out.println ("4 - Remover Gestor");
        System.out.println ("5 - Adicionar Cliente");
        System.out.println ("0 - Voltar");
        
        switch (Integer.parseInt (ler ()))
        {
            case 1: listarGestoresContas ();
                    menuAdministrativos (numCodigo);
                    break;
            case 2: menuAlterarDadosAdministrativo (administrativo);
                    menuAdministrativos (numCodigo);
                    break;
            case 3: menuAdicionarGestor ();
                    menuAdministrativos (numCodigo);
                    break;
            case 4: menuRemoverGestor (numCodigo);
                    menuAdministrativos (numCodigo);
                    break;
            case 5: menuAdicionarCliente ();
                    menuAdministrativos (numCodigo);
                    break;
            case 0: menuInicial ();
                    break;
            default: menuAdministrativos (numCodigo);
                     break;
        }
    }
    
    /** Visualiza o nome e o código do gestor e o menuGestores (listar clientes e saldos de conta respectivos, alterar dados pessoais, voltar) e processa a opção do utilizador
     * @param numCodigo Número do código do gestor
     */    
    public void menuGestores (int numCodigo)
    {
        Gestor gestor = banco.getGestor (numCodigo - 1);
        
        clearScreen ();
        
        System.out.println ("Benvindo " + gestor.getNome () + " (" + gestor.getCodigo () + ")");
        System.out.println ("1 - Listar os clientes e saldos de conta respectivos");
        System.out.println ("2 - Alterar dados pessoais");
        System.out.println ("0 - Voltar");
        
        switch (Integer.parseInt (ler ()))
        {
            case 1: listarClientesSaldos (numCodigo);
                    menuGestores (numCodigo);
                    break;
            case 2: menuAlterarDadosGestor (gestor);
                    menuGestores (numCodigo);
                    break;
            case 0: menuInicial ();
                    break;
            default: menuGestores (numCodigo);
                     break;
        }
    }
    
    /** Visualiza o nome e o código da empresa e o menuClientesEmpresas (levantar dinheiro, depositar dinheiro, requisitar cheques, cancelar conta, alterar gerente de conta, consultar o saldo da conta, consultar movimentos a partir de uma determinada data, alterar dados pessoais, voltar) e processa a opção do utilizador
     * @param numCodigo Número do código da empresa
     */    
    public void menuClientesEmpresas (int numCodigo)
    {
        Empresa empresa = banco.getEmpresa (numCodigo - 1);
        Conta conta = banco.getConta (empresa.getCodigo ());

        clearScreen ();

        System.out.println ("Benvindo " + empresa.getNome () + " (" + empresa.getCodigo () + ")");
        System.out.println ("1 - Levantar dinheiro");
        System.out.println ("2 - Depositar dinheiro");
        System.out.println ("3 - Requisitar cheques");
        System.out.println ("4 - Cancelar conta");
        System.out.println ("5 - Alterar o gerente de conta");
        System.out.println ("6 - Consultar o saldo da conta");
        System.out.println ("7 - Consultar movimentos a partir de uma determinada data");
        System.out.println ("8 - Alterar dados pessoais");
        System.out.println ("0 - Voltar");
        
        switch (Integer.parseInt (ler ()))
        {
            case 1: levantamento (conta);
                    menuClientesEmpresas (numCodigo);
                    break;
            case 2: deposito (conta);
                    menuClientesEmpresas (numCodigo);
                    break;
            case 3: requisitarCheques (conta);
                    menuClientesEmpresas (numCodigo);
                    break;
            case 4: System.out.println ("\nDeseja realmente cancelar a conta?");
                    System.out.println ("1 - Sim");
                    System.out.println ("0 - Não");
                    if (Integer.parseInt (ler ()) == 1)
                    {
                        removerConta (empresa.getCodigo ());
                        banco.removeEmpresa (numCodigo - 1);
                        banco.actualizaEmpresa (numCodigo);
                        menuInicial ();
                    }
                    else menuClientesEmpresas (numCodigo);
                    break;
            case 5: alterarGestor (conta);
                    menuClientesEmpresas (numCodigo);
                    break;
            case 6: consultarSaldo (conta);
                    menuClientesEmpresas (numCodigo);
                    break;
            case 7: menuListarMovimentos (conta);
                    menuClientesEmpresas (numCodigo);
                    break;
            case 8: menuAlterarDadosEmpresa (empresa);
                    menuClientesEmpresas (numCodigo);
                    break;
            case 0: menuInicial ();
                    break;
            default: menuClientesEmpresas (numCodigo);
                     break;
        }
    }
    
    /** Visualiza o nome e o código do individuo e o menuClientesIndividuos (levantar dinheiro, depositar dinheiro, requisitar cheques, cancelar conta, alterar gerente de conta, consultar o saldo da conta, consultar movimentos a partir de uma determinada data, alterar dados pessoais, voltar) e processa a opção do utilizador
     * @param numCodigo Número do código do individuo
     */    
    public void menuClientesIndividuos (int numCodigo)
    {
        Individuo individuo = banco.getIndividuo (numCodigo - 1);
        Conta conta = banco.getConta (individuo.getCodigo ());
        
        clearScreen ();

        System.out.println ("Benvindo " + individuo.getNome () + " (" + individuo.getCodigo () + ")");
        System.out.println ("1 - Levantar dinheiro");
        System.out.println ("2 - Depositar dinheiro");
        System.out.println ("3 - Requisitar cheques");
        System.out.println ("4 - Cancelar conta");
        System.out.println ("5 - Alterar o gerente de conta");
        System.out.println ("6 - Consultar o saldo da conta");
        System.out.println ("7 - Consultar movimentos a partir de uma determinada data");
        System.out.println ("8 - Alterar dados pessoais");
        System.out.println ("0 - Voltar");
        
        switch (Integer.parseInt (ler ()))
        {
            case 1: levantamento (conta);
                    menuClientesIndividuos (numCodigo);
                    break;
            case 2: deposito (conta);
                    menuClientesIndividuos (numCodigo);
                    break;
            case 3: requisitarCheques (conta);
                    menuClientesIndividuos (numCodigo);
                    break;
            case 4: System.out.println ("\nDeseja realmente cancelar a conta?");
                    System.out.println ("1 - Sim");
                    System.out.println ("0 - Não");
                    if (Integer.parseInt (ler ()) == 1)
                    {
                        removerConta (individuo.getCodigo ());
                        banco.removeIndividuo (numCodigo - 1);
                        banco.actualizaIndividuo (numCodigo);
                        menuInicial ();
                    }
                    else menuClientesIndividuos (numCodigo);
                    break;
            case 5: alterarGestor (conta);
                    menuClientesIndividuos (numCodigo);
                    break;
            case 6: consultarSaldo (conta);
                    menuClientesIndividuos (numCodigo);
                    break;
            case 7: menuListarMovimentos (conta);
                    menuClientesIndividuos (numCodigo);
                    break;
            case 8: menuAlterarDadosIndividuo (individuo);
                    menuClientesIndividuos (numCodigo);
                    break;
            case 0: menuInicial ();
                    break;
            default: menuClientesIndividuos (numCodigo);
                     break;
        }
    }
    
    /** Visualiza o menuAdicionarAdministrativos (nome, contacto, password) e adiciona um administrativo ao banco com as opções do utilizador
     */    
    public void menuAdicionarAdministrativo ()
    {
        clearScreen ();
                
        System.out.print ("Nome: ");
        String nome = ler ();
        System.out.print ("Contacto: ");
        String contacto = ler ();
        System.out.print ("Password: ");
        String password = ler ();
        String codigo = banco.geraCodigoAdministrativo ();
        
        Administrativo administrativo = new Administrativo (codigo, password, nome, contacto);
        banco.addAdministrativo (administrativo);
    }
    
    /** Visualiza o menuAdicionarGestor (nome, contacto, password) e adiciona um gestor ao banco com as opções do utilizador
     */    
    public void menuAdicionarGestor ()
    {
        clearScreen ();
        
        System.out.print ("Nome: ");
        String nome = ler ();
        System.out.print ("Contacto: ");
        String contacto = ler ();
        System.out.print ("Password: ");
        String password = ler ();
        String codigo = banco.geraCodigoGestor ();
        
        Gestor gestor = new Gestor (codigo, password, nome, contacto);
        banco.addGestor (gestor);
    }
    
    /** Visualiza o menuAdicionarCliente (empresa, individuo, voltar) e processa a opção do utilizador
     */    
    public void menuAdicionarCliente ()
    {
        clearScreen ();
        
        System.out.println ("1 - Empresa");
        System.out.println ("2 - Individuo");
        System.out.println ("0 - Voltar");
        
        switch (Integer.parseInt (ler ()))
        {
            case 1: menuAdicionarClienteEmpresa ();
                    break;
            case 2: menuAdicionarClienteIndividuo ();
                    break;
            case 0: menuInicial ();
                    break;
            default: menuAdicionarCliente ();
                     break;
        }
    }
    
    /** Visualiza o menuAdicionarClienteEmpresa (nome, ramo, contacto, password, escolha do gestor)  e adiciona uma empresa ao banco e uma conta ao respectivo gestor com as opções do utilizador
     */    
    public void menuAdicionarClienteEmpresa ()
    {
        clearScreen ();
        
        System.out.print ("Nome: ");
        String nome = ler ();
        System.out.print ("Ramo: ");
        String ramo = ler ();
        System.out.print ("Contacto: ");
        String contacto = ler ();
        System.out.print ("Password: ");
        String password = ler ();
        String codigo = banco.geraCodigoEmpresa ();
        
        Empresa empresa = new Empresa (codigo, password, nome, contacto, ramo);
        banco.addEmpresa (empresa);
        
        clearScreen ();
        for (int i = 0; i < banco.getSizeGestores (); i++)
        {
            Gestor gestor = banco.getGestor (i);
            System.out.println ((i + 1) + " - " + gestor.getCodigo () + " - " + gestor.getNome ());
        }
        
        System.out.println ("Escolha o nº do gestor correspondente ou 0 para escolha aleatória: ");
        int opcao = Integer.parseInt (ler ());
        
        if (opcao > banco.getSizeGestores () || opcao == 0) 
        {
            Gestor gestor = banco.getRandomGestor ();
            Conta conta = menuAdicionarConta (codigo);
            gestor.addConta (conta);
        }
        
        else 
        {
            Gestor gestor = banco.getGestor (opcao - 1);
            Conta conta = menuAdicionarConta (codigo);
            gestor.addConta (conta);
        }
    }
    
    /** Visualiza o menuAdicionarClienteIndividuo (nome, profissão, contacto, password, escolha do gestor) e adiciona um individuo ao banco e uma conta ao respectivo gestor com as opções do utilizador
     */    
    public void menuAdicionarClienteIndividuo ()
    {
        clearScreen ();
        
        System.out.print ("Nome: ");
        String nome = ler ();
        System.out.print ("Profissão: ");
        String profissao = ler ();
        System.out.print ("Contacto: ");
        String contacto = ler ();
        System.out.print ("Password: ");
        String password = ler ();
        String codigo = banco.geraCodigoIndividuo ();
        
        Individuo individuo = new Individuo (codigo, password, nome, contacto, profissao);
        banco.addIndividuo (individuo);
        
        clearScreen ();
        for (int i = 0; i < banco.getSizeGestores (); i++)
        {
            Gestor gestor = banco.getGestor (i);
            System.out.println ((i + 1) + " - " + gestor.getCodigo () + " - " + gestor.getNome ());
        }
        
        System.out.println ("Escolha o nº do gestor correspondente ou 0 para escolha aleatória: ");
        int opcao = Integer.parseInt (ler ());
        
        if (opcao > banco.getSizeGestores () || opcao == 0) 
        {
            Gestor gestor = banco.getRandomGestor ();
            Conta conta = menuAdicionarConta (codigo);
            gestor.addConta (conta);
        }
        else 
        {
            Gestor gestor = banco.getGestor (opcao - 1);
            Conta conta = menuAdicionarConta (codigo);
            gestor.addConta (conta);
        }
    }
    
    /** Visualiza o menuAdicionarConta (data de criação, saldo inicial) e adiciona uma conta ao banco com as opções do utilizador
     * @param codCliente Código do cliente
     * @return Conta criada
     */    
    public Conta menuAdicionarConta (String codCliente)
    {
        clearScreen ();
        
        System.out.print ("Data: ");
        String data = ler ();
        System.out.print ("Saldo: ");
        double saldo = Double.parseDouble (ler ());
        
        Conta conta = new Conta (codCliente, data, saldo);
        banco.addConta (conta);
        
        return conta;
    }
    
    /** Visualiza o menuRemoverAdministrativo (escolha do administrativo a remover) e processa a opção do utilizador
     */    
    public void menuRemoverAdministrativo ()
    {
        clearScreen ();
        
        if (banco.getSizeAdministrativos () == 0) 
        {
            System.out.println ("Não existem administratios para remover");
            System.out.println ("Prima «Enter» para voltar");
            ler ();
            menuDirector ();
        }
        
        System.out.println ("Admi.\tCódigo\t\tNome");
        
        for (int i = 0; i < banco.getSizeAdministrativos (); i++)
        {
            Administrativo administrativo = banco.getAdministrativo (i);
            System.out.println ((i + 1) + "\t" + administrativo.getCodigo () + "\t" + administrativo.getNome ());
        }
        
        System.out.print ("Escolha o administrativo a remover: ");
        
        int opcao = Integer.parseInt (ler ());
        if (opcao > banco.getSizeAdministrativos ()) 
        {
            System.out.println ("\nAdministrativo que escolheu não existe");
            System.out.println ("Prima «Enter» para escolher novamente");
            ler ();
            menuRemoverAdministrativo ();
        }
        
        else 
        {
            banco.removeAdministrativo (opcao - 1);
            banco.actualizaAdministrativo (opcao);
        }
    }
    
    /** Visualiza o menuRemoverGestor (escolha do gestor a remover) e processa a opção do utilizador
     * @param numCodigoAdministrativo Número do código do administrativo
     */    
    public void menuRemoverGestor (int numCodigoAdministrativo)
    {
        clearScreen ();
        
        if (banco.getSizeGestores () == 0)
        {
            System.out.println ("Não existem gestores para remover");
            System.out.println ("Prima «Enter» para voltar");
            ler ();
            menuAdministrativos (numCodigoAdministrativo);
        }
        
        System.out.println ("Gestor\tCódigo\t\tNome");
        
        for (int i = 0; i < banco.getSizeGestores (); i++)
        {
            Gestor gestor = banco.getGestor (i);
            System.out.println ((i + 1) + "\t" + gestor.getCodigo () + "\t" + gestor.getNome ());
        }
        
        System.out.print ("Escolha o gestor a remover: ");
        
        int opcao = Integer.parseInt (ler ());
        if (opcao > banco.getSizeGestores ()) 
        {
            System.out.println ("\nGestor que escolheu não existe");
            System.out.println ("Prima «Enter» para escolher novamente");
            ler ();
            menuRemoverGestor (numCodigoAdministrativo);
        }
        
        else 
        {
            banco.removeGestor (opcao - 1);
            banco.actualizaGestor (opcao);
        }
    }
    
    /** Visualiza o menuAlterarDadosAdministrativo (nome, contacto, password) e modifica o administrativo com as opções do utilizador
     * @param administrativo Administrativo a modificar
     */    
    public void menuAlterarDadosAdministrativo (Administrativo administrativo)
    {
        clearScreen ();
        
        System.out.print ("Nome: ");
        String nome = ler ();
        administrativo.setNome (nome);
        System.out.print ("Contacto: ");
        String contacto = ler ();
        administrativo.setContacto (contacto);
        System.out.print ("Password: ");
        String password = ler ();
        administrativo.setPassword (password);
    }
    
    /** Visualiza o menuAlterarDadosGestor (nome, contacto, password) e modifica o gestor com as opções do utilizador
     * @param gestor Gestor a modificar
     */    
    public void menuAlterarDadosGestor (Gestor gestor)
    {
        clearScreen ();
        
        System.out.print ("Nome: ");
        String nome = ler ();
        gestor.setNome (nome);
        System.out.print ("Contacto: ");
        String contacto = ler ();
        gestor.setContacto (contacto);
        System.out.print ("Password: ");
        String password = ler ();
        gestor.setPassword (password);
    }
    
    /** Visualiza o menuAlterarDadosEmpresa (nome, ramo, contacto, password) e modifica a empresa com as opções do utilizador
     * @param empresa Empresa a modificar
     */    
    public void menuAlterarDadosEmpresa (Empresa empresa)
    {
        clearScreen ();
        
        System.out.print ("Nome: ");
        String nome = ler ();
        empresa.setNome (nome);
        System.out.print ("Contacto: ");
        String contacto = ler ();
        empresa.setContacto (contacto);
        System.out.print ("Ramo: ");
        String ramo = ler ();
        empresa.setRamo (ramo);
        System.out.print ("Password: ");
        String password = ler ();
        empresa.setPassword (password);
    }
    
    /** Visualiza o menuAlterarDadosIndividuo (nome, profissão, contacto, password) e modifica o individuo com as opções do utilizador
     * @param individuo Individuo a modificar
     */    
    public void menuAlterarDadosIndividuo (Individuo individuo)
    {
        System.out.print ("Nome: ");
        String nome = ler ();
        individuo.setNome (nome);
        System.out.print ("Contacto: ");
        String contacto = ler ();
        individuo.setContacto (contacto);
        System.out.print ("Profissao: ");
        String profissao = ler ();
        individuo.setProfissao (profissao);
        System.out.print ("Password: ");
        String password = ler ();
        individuo.setPassword (password);
    }
    
    /** Remove uma conta do banco e do gestor correspondente
     * @param codCliente Código do cliente
     */    
    public void removerConta (String codCliente)
    {
        banco.removeConta (codCliente);
        
        Gestor gestor = new Gestor ("", "", "", "");
        
        for (int i = 0; i < banco.getSizeGestores (); i++)
        {
            Gestor gestorAux = banco.getGestor (i);
            for (int j = 0; j < gestorAux.getSizeContas (); j++) 
            {
                Conta conta = gestorAux.getConta (j);
                if (codCliente.equals (conta.getCodCliente ())) gestor = gestorAux;
            }
        }
        
        StringTokenizer stringTokenizer = new StringTokenizer (codCliente, "_");
        String iniciais = stringTokenizer.nextToken ().toString ();
        int num = Integer.parseInt (stringTokenizer.nextToken ().toString ());
        
        gestor.removeConta (num - 1);
        gestor.actualizaConta (num);
    }
    
    /** Lista os clientes e saldos de conta respectivos
     * @param numCodigoGestor Número do código do gestor
     */    
    public void listarClientesSaldos (int numCodigoGestor)
    {
        Gestor gestor = banco.getGestor (numCodigoGestor - 1);
        
        if (gestor.getSizeContas () > 0)
        {
            clearScreen ();
            
            System.out.println ("Cliente\tCodigo\t\tNome\t\tSaldo");
            for (int i = 0; i < gestor.getSizeContas (); i++)
            {
                Conta conta = gestor.getConta (i);
                String codCliente = conta.getCodCliente ();

                StringTokenizer stringTokenizer = new StringTokenizer (codCliente, "_");
                String iniciaisCliente = stringTokenizer.nextToken ().toString ();
                int numCodigoCliente = Integer.parseInt (stringTokenizer.nextToken ().toString ());

                if (iniciaisCliente.equals ("ce"))
                {
                    Empresa empresa = banco.getEmpresa (numCodigoCliente - 1);
                    System.out.println ((i + 1) + "\t" + conta.getCodCliente () + "\t" + empresa.getNome () + "\t" + conta.getSaldo ());
                }
                if (iniciaisCliente.equals ("ci"))
                {
                    Individuo individuo = banco.getIndividuo (numCodigoCliente - 1);
                    System.out.println ((i + 1) + "\t" + conta.getCodCliente () + "\t" + individuo.getNome () + "\t" +conta.getSaldo ());
                }
            }
        }
        
        else System.out.println ("\nNão tem contas atribuidas");
        
        System.out.println ("Prima «Enter» para voltar");
        ler ();
    }
    
    /** Lista os gerentes de conta e informação relativa ás contas associadas
     */    
    public void listarGestoresContas ()
    {
        if (banco.getSizeGestores () > 0)
        {
            clearScreen ();
            System.out.println ("Gestor\tCódigo\t\tNome");
            for (int i = 0; i < banco.getSizeGestores (); i++)
            {
                Gestor gestor = banco.getGestor (i);
                System.out.println ((i + 1) + "\t" + gestor.getCodigo () + "\t" + gestor.getNome ());
            }
            
            System.out.print ("\nEscolha o gestor do qual deseja visualizar as contas: ");
            
            Gestor gestor = banco.getGestor (Integer.parseInt (ler ()) - 1);
            if (gestor.getSizeContas () != 0)
            {
                clearScreen ();
                System.out.println ("Conta\tCliente\t\tSaldo\t\tData Inicio");
                for (int j = 0; j < gestor.getSizeContas (); j++)
                {
                    Conta conta = gestor.getConta (j);
                    System.out.println ((j + 1) + "\t" + conta.getCodCliente () + "\t" + conta.getSaldo () + "\t\t" + conta.getData ());
                }
            }
            
            else System.out.println ("\nO gestor escolhido não tem contas atribuidas");
        }
        
        else System.out.println ("\nNão existem gestores para visualizar");
            
        System.out.println ("\nPrima «Enter» para voltar");
        ler ();
    }
    
    /** Efectua um levantamento na conta
     * @param conta Conta onde será feita o levantamento
     */    
    public void levantamento (Conta conta)
    {
        clearScreen ();
        
        System.out.print ("Insira a data: ");
        String data = ler ();
        System.out.print ("Qual o montante que deseja levantar: ");
        double montante = Double.parseDouble (ler ());
        
        if (montante < conta.getSaldo ()) 
        {
            Movimento movimento = new Movimento (montante, data, "Levantamento");
            conta.addMovimento (movimento);
            conta.setSaldo (conta.getSaldo () - montante);
        }
        
        else
        {
            System.out.println ("\nO seu saldo não permite efectuar esta operação");
            System.out.println ("Prima «Enter» para voltar");
            ler ();
        }
    }
    
    /** Efectua um depósito na conta
     * @param conta Conta onde será feita o depósito
     */    
    public void deposito (Conta conta)
    {
        clearScreen ();
        
        System.out.print ("Insira a data: ");
        String data = ler ();
        System.out.print ("Qual o montante que deseja depositar: ");
        double montante = Double.parseDouble (ler ());
        
        System.out.println ("\n1 - Cheque");
        System.out.println ("2 - Numerário");
        ler ();
        
        Movimento movimento = new Movimento (montante, data, "Depósito");
        conta.addMovimento (movimento);

        conta.setSaldo (conta.getSaldo () + montante);
    }
    
    /** Efectua um levantamento de cheques na conta
     * @param conta Conta onde serão requisitados os cheques
     */    
    public void requisitarCheques (Conta conta)
    {
        clearScreen ();
        
        System.out.println ("Preço de cada cheque: 2 euros");
        System.out.print ("Insira a data: ");
        String data = ler ();
        System.out.print ("\nQual o número de cheques que deseja requisitar: ");
        int num = Integer.parseInt (ler ());
        
        if (num < 0)
        {
            System.out.println ("\nO valor que introduziu não é válido");
            System.out.println ("Prima «Enter» para introduzir novamente");
            requisitarCheques (conta);
        }
        
        else
        {
            if ((num * 2) < conta.getSaldo ()) 
            {
                Movimento movimento = new Movimento ((num * 2), data, "Levantamento");
                conta.addMovimento (movimento);
                conta.setSaldo (conta.getSaldo () - (num * 2));
            }
            
            else
            {
                System.out.println ("\nO seu saldo não permite efectuar esta operação");
                System.out.println ("Prima «Enter» para voltar");
                ler ();
            }
        }
    }
    
    /** Alterar o gestor da conta
     * @param conta Conta onde será alterada o gestor
     */    
    public void alterarGestor (Conta conta)
    {
        Gestor gestor;
        
        for (int i = 0; i < banco.getSizeGestores (); i++)
        {
            gestor = banco.getGestor (i);
            for (int j = 0; j < gestor.getSizeContas (); j++) if (conta == gestor.getConta (j)) gestor.removeConta (j);
        }
        
        clearScreen ();
        
        System.out.println ("Gestor\tCodigo\t\tNome");
        for (int i = 0; i < banco.getSizeGestores (); i++)
        {
            gestor = banco.getGestor (i);
            System.out.println ((i + 1) + "\t" + gestor.getCodigo () + "\t" + gestor.getNome ());
        }
        
        System.out.println ("\nEscolha o nº do gestor correspondente ou 0 para escolha aleatória: ");
        int opcao = Integer.parseInt (ler ());
        
        if (opcao > banco.getSizeGestores () || opcao == 0) gestor = banco.getRandomGestor ();
        else gestor = banco.getGestor (opcao - 1);
        gestor.addConta (conta);
    }
    
    /** Visualiza o saldo da conta
     * @param conta Conta onde será visualizada o saldo
     */    
    public void consultarSaldo (Conta conta)
    {
        clearScreen ();
        
        System.out.println ("Saldo: " + conta.getSaldo ());
        System.out.println ("\nPrima «Enter» para voltar");
        ler ();
    }
    
    /** Visualiza o menuListarMovimentos (levantamentos, depósitos, todos) e processa a opção do utilizador
     * @param conta Conta onde será feita a listagem
     */    
    public void menuListarMovimentos (Conta conta)
    {
        clearScreen ();
        
        System.out.println ("1 - Listar levantamentos");
        System.out.println ("2 - Listar depósitos");
        System.out.println ("3 - Listar todos");
        
        switch (Integer.parseInt (ler ()))
        {
            case 1: menuListarMovimentosLevantamentos (conta);
                    break;
            case 2: menuListarMovimentosDepositos (conta);
                    break;
            case 3: menuListarMovimentosTodos (conta);
                    break;
            default: menuListarMovimentos (conta);
                     break;
        }
    }

    /** Visualiza a listagem dos levantamentos
     * @param conta Conta onde será feita a listagem
     */    
    public void menuListarMovimentosLevantamentos (Conta conta)
    {
        clearScreen();
        
        LinkedList listagem = new LinkedList ();
        
        if (conta.getSizeMovimentos () > 0)
        {
            System.out.print ("A partir de que data deseja listar: ");
            String dataInicio = ler ();
            
            StringTokenizer stringTokenizer = new StringTokenizer (dataInicio, "-");
            int diaInicio = Integer.parseInt (stringTokenizer.nextToken ().toString ());
            int mesInicio = Integer.parseInt (stringTokenizer.nextToken ().toString ());
            int anoInicio = Integer.parseInt (stringTokenizer.nextToken ().toString ());
            
            for (int i = 0; i < conta.getSizeMovimentos (); i++)
            {
                Movimento movimento = conta.getMovimento (i);
                String dataMovimento = movimento.getData ();
                
                StringTokenizer stringTokenizer2 = new StringTokenizer (dataMovimento, "-");
                int diaMovimento = Integer.parseInt (stringTokenizer2.nextToken ().toString ());
                int mesMovimento = Integer.parseInt (stringTokenizer2.nextToken ().toString ());
                int anoMovimento = Integer.parseInt (stringTokenizer2.nextToken ().toString ());
                
                if (anoMovimento > anoInicio && movimento.getTipo ().equals ("Levantamento")) listagem.addLast (movimento);
                else
                {
                    if (anoMovimento == anoInicio)
                    {
                        if (mesMovimento > mesInicio && movimento.getTipo ().equals ("Levantamento")) listagem.addLast (movimento);
                        else
                        {
                            if (mesMovimento == mesInicio)
                            {
                                if (diaMovimento >= diaInicio && movimento.getTipo ().equals ("Levantamento")) listagem.addLast (movimento);
                            }
                        }
                    }
                }
            }
            
            if (listagem.size () > 0)
            {
                clearScreen ();
                System.out.println ("Mov.\tData\t\tMontante\tTipo");
                for (int j = 0; j < listagem.size (); j++) 
                {
                    Movimento movimento = (Movimento) listagem.get (j);
                    System.out.println ((j + 1) + "\t" + movimento.getData () + "\t" + movimento.getMontante () + "\t" + movimento.getTipo ());
                }
                System.out.println ("\nPrima «Enter» para voltar");
                ler ();
            }
            else
            {
                System.out.println ("\nNão foram encontrados movimentos a partir dessa data");
                System.out.println ("Prima «Enter» para voltar");
                ler ();
            }
        }
        else
        {
            System.out.println ("\nConta sem movimentos");
            System.out.println ("Prima «Enter» para voltar");
            ler ();
        }
    }
    
    /** Visualiza a listagem dos depósitos
     * @param conta Conta onde será feita a listagem
     */    
    public void menuListarMovimentosDepositos (Conta conta)
    {
        clearScreen();
                
        LinkedList listagem = new LinkedList ();
        
        if (conta.getSizeMovimentos () > 0)
        {
            System.out.print ("A partir de que data deseja listar: ");
            String dataInicio = ler ();
            
            StringTokenizer stringTokenizer = new StringTokenizer (dataInicio, "-");
            int diaInicio = Integer.parseInt (stringTokenizer.nextToken ().toString ());
            int mesInicio = Integer.parseInt (stringTokenizer.nextToken ().toString ());
            int anoInicio = Integer.parseInt (stringTokenizer.nextToken ().toString ());
            
            for (int i = 0; i < conta.getSizeMovimentos (); i++)
            {
                Movimento movimento = conta.getMovimento (i);
                String dataMovimento = movimento.getData ();
                
                StringTokenizer stringTokenizer2 = new StringTokenizer (dataMovimento, "-");
                int diaMovimento = Integer.parseInt (stringTokenizer2.nextToken ().toString ());
                int mesMovimento = Integer.parseInt (stringTokenizer2.nextToken ().toString ());
                int anoMovimento = Integer.parseInt (stringTokenizer2.nextToken ().toString ());
                
                if (anoMovimento > anoInicio && movimento.getTipo ().equals ("Depósito")) listagem.addLast (movimento);
                else
                {
                    if (anoMovimento == anoInicio)
                    {
                        if (mesMovimento > mesInicio && movimento.getTipo ().equals ("Depósito")) listagem.addLast (movimento);
                        else
                        {
                            if (mesMovimento == mesInicio)
                            {
                                if (diaMovimento >= diaInicio && movimento.getTipo ().equals ("Depósito")) listagem.addLast (movimento);
                            }
                        }
                    }
                }
            }
            
            if (listagem.size () > 0)
            {
                clearScreen ();
                System.out.println ("Mov.\tData\t\tMontante\tTipo");
                for (int j = 0; j < listagem.size (); j++) 
                {
                    Movimento movimento = (Movimento) listagem.get (j);
                    System.out.println ((j + 1) + "\t" + movimento.getData () + "\t" + movimento.getMontante () + "\t" + movimento.getTipo ());
                }
                System.out.println ("\nPrima «Enter» para voltar");
                ler ();
            }
            else
            {
                System.out.println ("\nNão foram encontrados movimentos a partir dessa data");
                System.out.println ("Prima «Enter» para voltar");
                ler ();
            }
        }
        else
        {
            System.out.println ("\nConta sem movimentos");
            System.out.println ("Prima «Enter» para voltar");
            ler ();
        }
    }
    
    /** Visualiza a listagem dos levantamentos e dos depósitos
     * @param conta Conta onde será feita a listagem
     */    
    public void menuListarMovimentosTodos (Conta conta)
    {
        clearScreen();
        
        LinkedList listagem = new LinkedList ();
        
        if (conta.getSizeMovimentos () > 0)
        {
            System.out.print ("A partir de que data deseja listar: ");
            String dataInicio = ler ();
            
            StringTokenizer stringTokenizer = new StringTokenizer (dataInicio, "-");
            int diaInicio = Integer.parseInt (stringTokenizer.nextToken ().toString ());
            int mesInicio = Integer.parseInt (stringTokenizer.nextToken ().toString ());
            int anoInicio = Integer.parseInt (stringTokenizer.nextToken ().toString ());
            
            for (int i = 0; i < conta.getSizeMovimentos (); i++)
            {
                Movimento movimento = conta.getMovimento (i);
                String dataMovimento = movimento.getData ();
                
                StringTokenizer stringTokenizer2 = new StringTokenizer (dataMovimento, "-");
                int diaMovimento = Integer.parseInt (stringTokenizer2.nextToken ().toString ());
                int mesMovimento = Integer.parseInt (stringTokenizer2.nextToken ().toString ());
                int anoMovimento = Integer.parseInt (stringTokenizer2.nextToken ().toString ());
                
                if (anoMovimento > anoInicio) listagem.addLast (movimento);
                else
                {
                    if (anoMovimento == anoInicio)
                    {
                        if (mesMovimento > mesInicio) listagem.addLast (movimento);
                        else
                        {
                            if (mesMovimento == mesInicio)
                            {
                                if (diaMovimento >= diaInicio) listagem.addLast (movimento);
                            }
                        }
                    }
                }
            }
            
            if (listagem.size () > 0)
            {
                clearScreen ();
                System.out.println ("Mov.\tData\t\tMontante\tTipo");
                for (int j = 0; j < listagem.size (); j++) 
                {
                    Movimento movimento = (Movimento) listagem.get (j);
                    System.out.println ((j + 1) + "\t" + movimento.getData () + "\t" + movimento.getMontante () + "\t" + movimento.getTipo ());
                }
                System.out.println ("\nPrima «Enter» para voltar");
                ler ();
            }
            else
            {
                System.out.println ("\nNão foram encontrados movimentos a partir dessa data");
                System.out.println ("Prima «Enter» para voltar");
                ler ();
            }
        }
        else
        {
            System.out.println ("\nConta sem movimentos");
            System.out.println ("Prima «Enter» para voltar");
            ler ();
        }
    }
    
    /** Método executável da classe Interface
     * @param args
     */    
    public static void main (String[] args) 
    {
        new Interface ().menuStart ();
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                