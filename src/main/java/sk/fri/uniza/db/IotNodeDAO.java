package sk.fri.uniza.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import sk.fri.uniza.model.Field;
import sk.fri.uniza.model.IotNode;

import java.util.List;

public class IotNodeDAO extends AbstractDAO<IotNode> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public IotNodeDAO(SessionFactory sessionFactory) { super(sessionFactory);
    }

    public IotNode create(IotNode iotNode) {
        currentSession().save(iotNode);
        return iotNode;
    }

    public IotNode findById(Long id) {
        return get(id);
    }
    public IotNode update(IotNode iotNode) {
        return (IotNode) currentSession().merge(iotNode);
    }

    public List<IotNode> findByHouseHold(Long houseHoldId) {
        //TODO Doplniť
        return null;
    }

    public List<IotNode> allIotNodes() {
        return list(namedQuery("IoTNode_findAll"));
    }
}
