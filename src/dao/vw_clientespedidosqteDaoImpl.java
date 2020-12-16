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
import model.vw_clientespedidosqte;
import util.ConnectionFactory;

/**
 *
 * @author bioha
 */
//vw_clientespedidosqte(String nomeContato, String endereco, String cidade, int idOrdem, int qtde, Date dataOrdem)
public class vw_clientespedidosqteDaoImpl implements vw_clientespedidosqteDao {

    @Override
    public vw_clientespedidosqte pesquisarPorIdOrdem(int idordem) {
        String sql = "SELECT * FROM CLIENTES WHERE IDCLIENTE = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idordem);

            rset = pstm.executeQuery();

            while (rset.next()) {
                vw_clientespedidosqte clientesPedidos = new vw_clientespedidosqte();
                clientesPedidos.setNomeContato(rset.getString("nomecontato"));
                clientesPedidos.setEndereco(rset.getString("endereco"));
                clientesPedidos.setCidade(rset.getString("cidade"));
                clientesPedidos.setIdOrdem(rset.getInt("idordem"));
                clientesPedidos.setQtde(rset.getInt("qtde"));
                clientesPedidos.setDataOrdem(rset.getDate("dataordem"));

                return clientesPedidos;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rset != null) {
                    rset.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<vw_clientespedidosqte> pesquisarClientesPedidosQte() {
        String sql = "SELECT * FROM vw_clientespedidosqte";
        List<vw_clientespedidosqte> clientesPedidosqte = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                vw_clientespedidosqte clientesPedidos = new vw_clientespedidosqte();
                clientesPedidos.setNomeContato(rset.getString("nomecontato"));
                clientesPedidos.setEndereco(rset.getString("endereco"));
                clientesPedidos.setCidade(rset.getString("cidade"));
                clientesPedidos.setIdOrdem(rset.getInt("idordem"));
                clientesPedidos.setQtde(rset.getInt("qtde"));
                clientesPedidos.setDataOrdem(rset.getDate("dataordem"));

                clientesPedidosqte.add(clientesPedidos);
            }
            return clientesPedidosqte;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rset != null) {
                    rset.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;

    }

}
