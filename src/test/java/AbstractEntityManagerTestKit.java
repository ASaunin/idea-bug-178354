import akka.actor.ActorRef;
import akka.actor.Props;
import akka.testkit.TestActorRef;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.atomic.AtomicInteger;

abstract public class AbstractEntityManagerTestKit<T extends EntityManager<D>,
        D extends RoutingDomainEntity> extends AkkaTestKit {

    private final TestActorRef<T> managerRef;
    final T manager;

    final AtomicInteger id = new AtomicInteger(0);

    public AbstractEntityManagerTestKit() {
        final ActorRef dsManagerRef = getSystem().actorOf(DataSourceStubManagerActor.props());
        final Props props = serviceCoordinatorCreatorProps(dsManagerRef);
        final ActorRef coordinatorRef = getSystem().actorOf(props);

        //noinspection unchecked
        final Class<T> clazz = ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0]);

        this.managerRef = TestActorRef.create(getSystem(), Props.create(clazz, coordinatorRef, dsManagerRef));
        this.manager = managerRef.underlyingActor();
    }

}
