package com.cts.dto;

import com.cts.model.CustomerStatement;
import com.cts.model.ErrorRecord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RaboResponse {
    String result;
    List<ErrorRecord> errorRecords = new ArrayList();

}
