/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Clientes;
import model.Fornecedores;
import util.ConnectionFactory;

/**
 *
 * @author wende
 */
public class FornecedoresDaoImpl implements FornecedoresDao {

    @Override
    public void addFornecedores(Fornecedores fornecedor) {
        String sql = "INSERT INTO `fornecedores`(`IDFornecedor`, "
                + "`NomeCompanhia`, `NomeContato`, `TItuloContato`, "
                + "`Endereco`, `Cidade`, `Regiao`, `cep`, `Pais`, "
                + "`Telefone`, `Fax`, `Website`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, getLastID());
            pstm.setString(2, fornecedor.getNomeCompanhia());  
            pstm.setString(3, fornecedor.getNomeContato());  
            pstm.setString(4, fornecedor.getTituloContato());  
            pstm.setString(5, fornecedor.getEndereco());  
            pstm.setString(6, fornecedor.getCidade());  
            pstm.setString(7, fornecedor.getRegiao());  
            pstm.setString(8, fornecedor.getCEP());  
            pstm.setString(9, fornecedor.getPais());  
            pstm.setString(10, fornecedor.getTelefone());  
            pstm.setString(11, fornecedor.getFAX());            
            pstm.setString(12, fornecedor.getWebsite()); 
            pstm.execute();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void deleteFornecedores(int IDFornecedor) {
        String sql = "DELETE FROM FORNECEDORES WHERE IDFornecedor = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            
            pstm.setInt(1,IDFornecedor);
            pstm.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }  
    }

    @Override
    public void updateFornecedores(Fornecedores fornecedor) {
        String sql = "UPDATE `fornecedores` SET `NomeCompanhia`=?,"
                + "`NomeContato`=?,`TItuloContato`=?,`Endereco`=?,"
                + "`Cidade`=?,`Regiao`=?,`cep`=?,`Pais`=?,`Telefone`=?,"
                + "`Fax`=?,`Website`=? WHERE IDFORNECEDOR = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, fornecedor.getNomeCompanhia());  
            pstm.setString(2, fornecedor.getNomeContato());  
            pstm.setString(3, fornecedor.getTituloContato());  
            pstm.setString(4, fornecedor.getEndereco());  
            pstm.setString(5, fornecedor.getCidade());  
            pstm.setString(6, fornecedor.getRegiao());  
            pstm.setString(7, fornecedor.getCEP());  
            pstm.setString(8, fornecedor.getPais());  
            pstm.setString(9, fornecedor.getTelefone());  
            pstm.setString(10, fornecedor.getFAX());            
            pstm.setString(11, fornecedor.getWebsite()); 
            pstm.setInt(12, fornecedor.getIDFornecedor());
            pstm.execute();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Fornecedores> getAllFornecedores() {
        String sql = "SELECT * FROM FORNECEDORES";
        List<Fornecedores> fornecedores = new ArrayList<Fornecedores>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            while(rset.next()){
                Fornecedores forn = new Fornecedores();
                forn.setCEP(rset.getString("CEP"));
                forn.setCidade(rset.getString("Cidade"));
                forn.setEndereco(rset.getString("Endereco"));
                forn.setFAX(rset.getString("FAX"));
                forn.setIDFornecedor(rset.getInt("IDFornecedor"));
                forn.setNomeCompanhia(rset.getString("NomeCompanhia"));
                forn.setNomeContato(rset.getString("NomeContato"));
                forn.setPais(rset.getString("Pais"));
                forn.setTelefone(rset.getString("Telefone"));
                forn.setRegiao(rset.getString("Regiao"));
                forn.setTituloContato(rset.getString("TituloContato"));
                forn.setWebsite(rset.getString("Website"));
                fornecedores.add(forn);
            }
            return fornecedores;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
                if (rset != null){
                    rset.close();
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }  
        
        return null;
    }

    @Override
    public Fornecedores getFornecedoresById(int IDFornecedor) {
        String sql = "SELECT * FROM FORNECEDORES WHERE IDFORNECEDOR = ?";
                
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, IDFornecedor);
            rset = pstm.executeQuery();
            
            while(rset.next()){
                Fornecedores forn = new Fornecedores();
                forn.setCEP(rset.getString("CEP"));
                forn.setCidade(rset.getString("Cidade"));
                forn.setEndereco(rset.getString("Endereco"));
                forn.setFAX(rset.getString("FAX"));
                forn.setIDFornecedor(rset.getInt("IDFornecedor"));
                forn.setNomeCompanhia(rset.getString("NomeCompanhia"));
                forn.setNomeContato(rset.getString("NomeContato"));
                forn.setPais(rset.getString("Pais"));
                forn.setTelefone(rset.getString("Telefone"));
                forn.setRegiao(rset.getString("Regiao"));
                forn.setTituloContato(rset.getString("TituloContato"));
                forn.setWebsite(rset.getString("Website"));
                return forn;
            }            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
                if (rset != null){
                    rset.close();
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }  
        
        return null;
    }

    @Override
    public int getLastID() {
        String sql = "SELECT MAX(IDFORNECEDOR) AS ID FROM FORNECEDORES";
                
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();            
            pstm = conn.prepareStatement(sql);            
            rset = pstm.executeQuery();
            
            while(rset.next()){
                return rset.getInt("ID") + 1;
            }            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
                if (rset != null){
                    rset.close();
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }  
        
        return -1;
    }

    @Override
    public List<Integer> getAllIDFornecedores(){
        String sql = "SELECT IDFornecedor FROM FORNECEDORES";
        List<Integer> fornecedores = new ArrayList<Integer>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            while(rset.next()){
                 fornecedores.add(rset.getInt("IDFornecedor"));                
            }
            return fornecedores;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
                if (rset != null){
                    rset.close();
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }          
        return null;
    }
    
}
