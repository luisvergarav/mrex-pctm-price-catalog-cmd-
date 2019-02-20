package rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.adapters.output.asb.EventPublisherService;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.adapters.output.asb.EventType;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.domain.events.PriceCreatedIntegrationEvent;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.domain.ports.Handler;

@Slf4j
@Component
public class CreatePriceHandler implements Handler<CreatePriceCommandImpl> {

	@Autowired
	EventPublisherService publisher;

	public CreatePriceHandler() {

	}

	@Override
	public boolean handle(CreatePriceCommandImpl command) throws Exception {

		PriceCreatedIntegrationEvent integrationEvent = null;
		try {

			integrationEvent = new PriceCreatedIntegrationEvent();

			log.info("Sending PriceCreateEvent integration Event ", command.getSku());

			publisher.publish(EventType.PRICE_CREATED, integrationEvent);
			return true;

		} catch (Exception e) {
			log.error("Error Sending PriceCreateEvent integration Event " + integrationEvent.getMetadata(),
					e.getLocalizedMessage());
		}
		return false;

	}

}
