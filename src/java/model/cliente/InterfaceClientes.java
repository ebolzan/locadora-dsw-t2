package model.cliente;

import java.util.List;

/**
 *
 * @author evandro
 */
public interface InterfaceClientes {
    public void salvar(Clientes clientes);
    public void excluir(Clientes clientes);
    public void atualizar(Clientes clientes);
    public Clientes carregar(Integer codigo);
    public List<Clientes> lista();    
}
