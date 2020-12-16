/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Fornecedores;

/**
 *
 * @author wende
 */
    
public interface FornecedoresDao {
    public void addFornecedores(Fornecedores fornecedor);
    public void deleteFornecedores (int IDFornecedor);
    public void updateFornecedores (Fornecedores fornecedor);
    public List<Fornecedores> getAllFornecedores();
    public List<Integer> getAllIDFornecedores();
    public Fornecedores getFornecedoresById(int IDFornecedor);
    public int getLastID();
}
