import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DataSourceStubManagerActor extends AbstractActor {

    public static Props props() {
        return Props.create(DataSourceStubManagerActor.class);
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().build();
    }

}
