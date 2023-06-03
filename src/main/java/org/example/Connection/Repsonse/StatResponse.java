package org.example.Connection.Repsonse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatResponse {
    private Integer statId;
    private CountryResponse country;
    private Integer countryPopulation;
    private Integer totalCases;
    private Integer totalDeaths;
    private Integer totalRecovered;
    private Integer activeAccess;
}
