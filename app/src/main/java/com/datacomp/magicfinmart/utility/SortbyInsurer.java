package com.datacomp.magicfinmart.utility;

import java.util.Comparator;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;

public class SortbyInsurer implements Comparator<HealthQuoteEntity> {
    // Used for sorting in ascending order of age
    public int compare(HealthQuoteEntity a, HealthQuoteEntity b) {
        return a.getTotalChilds() - b.getTotalChilds();
    }
}