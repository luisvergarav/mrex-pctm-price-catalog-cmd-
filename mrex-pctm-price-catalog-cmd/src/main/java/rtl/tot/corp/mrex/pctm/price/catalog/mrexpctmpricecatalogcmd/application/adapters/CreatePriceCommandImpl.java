package rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.application.adapters;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import lombok.Data;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.domain.ports.CreatePriceCommand;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.infraestrucure.adapters.http.rest.domain.Price;

@Data
public class CreatePriceCommandImpl implements CreatePriceCommand<Price> {

	@Id
	@NotNull
	String sku;
	@NotNull
	Long store;
	@NotNull
	Double currentPrice;
	@NotNull
	Double regularPrice;

	public CreatePriceCommandImpl(Price price) {
		super();
		this.sku = price.getSku();
		this.store = price.getStore();
		this.currentPrice = price.getCurrentPrice();
		this.regularPrice = price.getRegularPrice();
	}

}