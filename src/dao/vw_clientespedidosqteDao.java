/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.vw_clientespedidosqte;

/**
 *
 * @author bioha
 */
public interface vw_clientespedidosqteDao {

    public vw_clientespedidosqte pesquisarPorIdOrdem(int idordem);

    public List<vw_clientespedidosqte> pesquisarClientesPedidosQte();
}
