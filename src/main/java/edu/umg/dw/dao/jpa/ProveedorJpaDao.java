package edu.umg.dw.dao.jpa;

import edu.umg.dw.dao.ProveedorDao;
import edu.umg.dw.model.Proveedor;

import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ProveedorJpaDao extends DaoBase implements ProveedorDao {

    private Logger logger = Logger.getLogger(ProveedorJpaDao.class.getName());

    @Override
    public List<Proveedor> obtenerProveedores() {
        try {
            return getEntityManager().createNamedQuery("Proveedor.findAll", Proveedor.class)
                    .getResultList();

        } catch (Exception ex) {
            logger.info(ex.getMessage());
            throw ex;
        }
    }
}
