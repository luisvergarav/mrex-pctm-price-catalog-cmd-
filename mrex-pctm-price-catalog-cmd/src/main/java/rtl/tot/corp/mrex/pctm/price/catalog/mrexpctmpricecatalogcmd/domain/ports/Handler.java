package rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.domain.ports;

public interface Handler<Command> {
public boolean handle(Command cmd) throws Exception;
}
