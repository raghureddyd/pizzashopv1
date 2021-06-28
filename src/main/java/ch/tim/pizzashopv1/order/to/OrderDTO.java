package ch.tim.pizzashopv1.order.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private Long id;
    @JsonProperty("customer_code")
    private String custCode;
    @JsonProperty("customer_name")
    private String custName;
    @NotNull(message = "address is required")
    @NotEmpty(message = "address is required")
    private String address;
    @NotNull(message = "phone_number is required")
    @NotEmpty(message = "phone_number is required")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotEmpty(message = "Pizzas list cannot be empty.")
    @JsonProperty("pizzas")
    private List<@Valid OrderDetailDTO> orderDetailDTOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<OrderDetailDTO> getOrderDetailDTOList() {
        return orderDetailDTOList;
    }

    public void setOrderDetailDTOList(List<OrderDetailDTO> orderDetailDTOList) {
        this.orderDetailDTOList = orderDetailDTOList;
    }
}
