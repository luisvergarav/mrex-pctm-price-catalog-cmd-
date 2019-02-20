package rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.domain.events;


import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.adapters.output.asb.EventDomain;

@Data
@JsonIgnoreProperties({"mapper", "entityType"})
public class PriceCreatedIntegrationEvent  implements EventDomain {
	@Id
	@NotNull
	String sku;	
	@NotNull
	Long store;
	@NotNull
	Double currentPrice;	
	@NotNull
	Double regularPrice;
	
	private final ObjectMapper mapper = new ObjectMapper();
	 
		
	@Override
	@JsonIgnore
	public String getEntityId() {
		// TODO Auto-generated method stub
		return sku;
	}

	@Override
	@JsonIgnore
	public String getMetadata() {
		String jsonValue;
        try {
            jsonValue = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            jsonValue = super.toString();
        }
        return jsonValue;
	}

	@Override
	public String getEntityType() {
		return getClass().getName();
	}

	

	public ObjectMapper getMapper() {
		return mapper;
	}

	


	
	
}
