package nl.hu.pafr.richrail.train.presentation.dto;

import javax.validation.constraints.NotNull;

public class NewTrainRequest {
    @NotNull
    public String name;
}
