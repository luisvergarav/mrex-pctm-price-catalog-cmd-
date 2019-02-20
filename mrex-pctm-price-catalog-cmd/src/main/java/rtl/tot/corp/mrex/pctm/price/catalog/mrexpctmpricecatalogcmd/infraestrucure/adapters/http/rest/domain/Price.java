package rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.infraestrucure.adapters.http.rest.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;
 
@Data
public class Price {
	@NotNull
	String sku;	
	@NotNull
	Long store;
	@NotNull
	Double currentPrice;	
	@NotNull
	Double regularPrice;
}

