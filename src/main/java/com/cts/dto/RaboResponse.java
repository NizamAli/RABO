package com.cts.dto;

import com.cts.model.ErrorRecord;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class RaboResponse {
    String result;
    List<ErrorRecord> errorRecords = new ArrayList();

}
