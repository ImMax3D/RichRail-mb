package nl.hu.pafr.richrail.train.presentation.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddWagonRequest {
    @NotNull
    public String name;
    @Min(0)
    @NotNull
    public Integer capacity;
}
