import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountManager extends EntityManager<SubAccount> {

    public static Props props(@NonNull ActorRef serviceCoordinatorRef, @NonNull ActorRef dbManagerRef) {
        return Props.create(AccountManager.class, serviceCoordinatorRef, dbManagerRef);
    }

    public AccountManager(ActorRef serviceCoordinatorRef, ActorRef dbManagerActorRef) {
//        super(serviceCoordinatorRef, dbManagerActorRef);
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().build();
    }

}
