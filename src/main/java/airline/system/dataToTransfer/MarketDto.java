package airline.system.dataToTransfer;


import airline.system.domain.Airline;
import airline.system.domain.Market;
import lombok.Data;

import java.util.List;

@Data
public class MarketDto {

    private Long id;

    public static MarketDto from(Market market)
    {
        MarketDto marketDto = new MarketDto();
        marketDto.setId(market.getId());
        return marketDto;
    }





}
