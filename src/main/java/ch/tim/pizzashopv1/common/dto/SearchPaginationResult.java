package ch.tim.pizzashopv1.common.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The class SearchPaginationResult.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchPaginationResult<T> {

    private final Integer rowCount;

    private final List<T> data;

    @JsonCreator
    public SearchPaginationResult(@JsonProperty("rowCount") Integer rowCount, @JsonProperty("data") List<T> data) {
        this.rowCount = rowCount;
        this.data = data;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public List<T> getData() {
        return data;
    }
}




