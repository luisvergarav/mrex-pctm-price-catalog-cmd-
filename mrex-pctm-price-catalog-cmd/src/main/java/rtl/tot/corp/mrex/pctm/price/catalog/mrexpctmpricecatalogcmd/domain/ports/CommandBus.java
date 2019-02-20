package rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.domain.ports;

public interface CommandBus<Command> {

    public boolean execute(Command command) throws Exception;
}