import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServiceCoordinatorActor extends AbstractActor {

    private final ActorRef dsManagerRef;

    public static Props props(ActorRef dsManagerRef) {
        return Props.create(ServiceCoordinatorActor.class, dsManagerRef);
    }

    public Receive createReceive() {
        return ReceiveBuilder.create().build();
    }

}
