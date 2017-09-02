
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;

@Slf4j
public abstract class AkkaTestKit extends TestKit {

    private static ActorSystem system;

    public AkkaTestKit() {
        super(system);
    }

    @BeforeClass
    public static void init() {
        log.info("Starting ActorSystem...");
        system = ActorSystem.create();
    }

    @AfterClass
    public static void destroy() {
        log.info("Shutting down ActorSystem...");
//        ManagerSupervisorActor.clearManagers();
        TestKit.shutdownActorSystem(system, true);
    }

    protected static Props serviceCoordinatorCreatorProps(ActorRef dsManagerRef) {
        return null;
    }

}
